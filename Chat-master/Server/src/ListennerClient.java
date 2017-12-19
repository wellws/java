import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListennerClient implements Runnable {
    
    private static final Map<String, ObjectOutputStream> USERSONLINE 
            = Collections.synchronizedMap(new HashMap<String, ObjectOutputStream>());  
    
    private ObjectInputStream clientInput;
    private ObjectOutputStream clientOutput;
    private String clientName = ""; 
    public Tetris game = new Tetris();
    private boolean democracy;
    
    public boolean getDemocracy() {
        return this.democracy;
    }

    public final void setDemocracy(boolean democracy) {
        this.democracy = democracy;
    } 
    
    public ListennerClient(Socket socketCliente){
        try {
            this.clientInput = new ObjectInputStream(socketCliente.getInputStream());
            this.clientOutput = new ObjectOutputStream(socketCliente.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ListennerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ListennerClient(Socket socketCliente, Tetris tetris){
        
        try {
            this.clientInput = new ObjectInputStream(socketCliente.getInputStream());
            this.clientOutput = new ObjectOutputStream(socketCliente.getOutputStream());
            game = tetris;
            
        } catch (IOException ex) {
            Logger.getLogger(ListennerClient.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public ListennerClient(Socket socketCliente, Tetris tetris, boolean democracy){
        
        try {
            this.clientInput = new ObjectInputStream(socketCliente.getInputStream());
            this.clientOutput = new ObjectOutputStream(socketCliente.getOutputStream());
            game = tetris;  
            setDemocracy(democracy);
            
        } catch (IOException ex) {
            Logger.getLogger(ListennerClient.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @Override
    public void run() {
        
        boolean runTemp = true;
//      boolean connected;
        Message message = null;
//      Message messageThisClient;
//      String oldText, newText;
        
        try {
            message = (Message) this.clientInput.readObject();
            System.out.println(message.getClientName());
        } catch (IOException | ClassNotFoundException ex) {
            runTemp = false;
            
            System.out.println("runTemp: ");
            System.out.println(runTemp);
        } 

        //CONNECT, SEND_ALL, SEND_RESTRICT, ADD_USER_NAME_ONLINE, REMOVE_USER_NAME_ONLINE; 
        
        int[] amounts = new int[4];
        
        // amounts of UP
        amounts[0] = 0;
        
        // amounts of LEFT
        amounts[1] = 0;
        
        // amounts of RIGHT
        amounts[2] = 0;
        
        // amounts of DOWN
        amounts[3] = 0;

            while(runTemp) {

                // amounts of UP
            amounts[0] = 0;

            // amounts of LEFT
            amounts[1] = 0;

            // amounts of RIGHT
            amounts[2] = 0;

            // amounts of DOWN
            amounts[3] = 0;
            
            try {
                
                //estimated time for all users to send commands
                Thread.sleep(5);
                
                //storage of commands sent by the user           
                if (message.getCommand() == Message.Command.UP ) {
                    
                    amounts[0]++;
 
                    //game.rotate(-1);
                    //System.out.println(" UP ");
                } 

                if (message.getCommand() == Message.Command.LEFT) {
                    
                    amounts[1]++;
                    
                   // game.move(-1);
                   // System.out.println(" LEFT ");
                }

                if (message.getCommand() == Message.Command.RIGHT) {
                    
                    amounts[2]++;
                    
                    //game.move(+1);
                    //System.out.println(" RIGHT ");
                } 

                if (message.getCommand() == Message.Command.DOWN) {
                    
                    amounts[3]++;
                    
                    //game.dropDown();
                    //game.score += 1;

                   // System.out.println(" DOWN ");
                } 
                
            } catch (Exception e) {
                e.printStackTrace();
            }        
            
            //check sent commands and perform task
            
            //majoritarian or democracy
            
            if ( getDemocracy() ) {
                
               // if ( (amounts[0] == amounts[1]) || (amounts[2] == amounts[3]) || (amounts[2] == amounts[1]) ) {
                 //   game.rotate(-1);
               // }

                if ( (amounts[0] > amounts[1]) && (amounts[0] > amounts[2]) && (amounts[0] > amounts[3]) ) {

                    game.rotate(-1);
                }

                if ( (amounts[1] > amounts[0]) && (amounts[1] > amounts[2]) && (amounts[1] > amounts[3]) ) {

                    game.move(-1);
                }

                if ( (amounts[2] > amounts[0]) && (amounts[2] > amounts[1]) && (amounts[2] > amounts[3]) ) {

                    game.move(+1);
                }

                if ( (amounts[3] > amounts[0]) && (amounts[3] > amounts[1]) && (amounts[3] > amounts[2]) ) {

                    game.dropDown();
                    game.score += 1;
                }
            } else { // random. According to the sample

                int lottery = (int) (Math.random() * 4);

                switch (lottery) {

                    case 0 : game.rotate(-1);
                    break;

                    case 1 : game.move(-1);
                    break;

                    case 2 : game.move(+1);
                    break;

                    default: game.rotate(+1);
                    break;       
                }
            }
            
            if (runTemp) {// Case the not name duplicated, then...
                try {
                    message = (Message) this.clientInput.readObject();
                } catch (IOException | ClassNotFoundException ex) {
                    userDisconnected();
                    runTemp = false;
                }
            }    
        }      
    }
    
    // Verify if is possible connect. 
    private boolean connect(Message message) {
        Message messageDuplicateName; 
        Message messageConnected;
        Message messageAddUserNameOnline;
        Message messageAll;
        boolean connected;
        String ClientName = message.getClientName();
        ArrayList<String> namesOnlineUsers;
        
        if (USERSONLINE.containsKey(ClientName)) {// if name duplicate, then...
            messageDuplicateName = new Message();
            messageDuplicateName.setAction(Message.Action.CONNECT);
            //messageDuplicateName.setText("Name duplicate!");
            try {
                this.clientOutput.writeObject(messageDuplicateName);
            } catch (IOException ex) {
                Logger.getLogger(ListennerClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            connected = false;
        } else { // if not duplicate name, then...
            this.clientName = ClientName;
            
            messageAddUserNameOnline = new Message();
            messageAddUserNameOnline.setClientName(ClientName);
            //messageAddUserNameOnline.setAction(Message.Action.ADD_USER_NAME_ONLINE);
            sendAll(messageAddUserNameOnline);
            
            USERSONLINE.put(ClientName, clientOutput);
            
            //namesOnlineUsers = getUsersNamesOnline();
            messageConnected = new Message();
            //messageConnected.setReceiverName(ClientName);
            messageConnected.setAction(Message.Action.CONNECT);
            //messageConnected.setNamesOnlineUsers(namesOnlineUsers);
            //messageConnected.setText("");
            //sendRestrict(messageConnected);

            messageAll = new Message();
            messageAll.setClientName(ClientName);
            //messageAll.setAction(Message.Action.SEND_ALL);                   
            //messageAll.setText("[" + ClientName + "]: " + "Connected...");
            sendAll(messageAll);
            connected = true;
        }
        
        return connected;
    }
    
    // Send a message to all users.
    private void sendAll(Message message) {
        ObjectOutputStream output; 
        
        for (Map.Entry<String, ObjectOutputStream> user : USERSONLINE.entrySet()) {
            output = user.getValue();

            try {
                output.writeObject(message);
                
                System.err.println("Enviou");
                
            } catch (IOException ex) {
                Logger.getLogger(ListennerClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
            
    /*
    // Send a message restrict to a user.
    private void sendRestrict(Message message) {
        //String receiverName = message.getReceiverName();
        ObjectOutputStream receiverOutput;
        
       // if (USERSONLINE.containsKey(receiverName)) {
         //   receiverOutput = USERSONLINE.get(receiverName);

            try {
                receiverOutput.writeObject(message);
            } catch (IOException ex) {
                Logger.getLogger(ListennerClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    } */
    
    // Remove it user of the list of the users online and send message to all notifying this act.
    private void userDisconnected() {
        Message messageDisconnect;
        Message messageRemoveUserNameOnline;
        
        USERSONLINE.remove(this.clientName);// Remove the client that is offline.   
        
        messageDisconnect = new Message();
        messageDisconnect.setClientName(this.clientName);
        //messageDisconnect.setAction(Message.Action.SEND_ALL);
        //messageDisconnect.setText("[" + this.clientName + "]: Disconnected...");
        sendAll(messageDisconnect);

        messageRemoveUserNameOnline = new Message();
        messageRemoveUserNameOnline.setClientName(this.clientName);
        //messageRemoveUserNameOnline.setAction(Message.Action.REMOVE_USER_NAME_ONLINE);
        sendAll(messageRemoveUserNameOnline);
    }
    
    // Converter the map of the user to an ArrayList and return this.
    private ArrayList<String> getUsersNamesOnline() {
        ArrayList<String> namesOnlineUsers = new ArrayList<String>();
        String name;
        
        for (Map.Entry<String, ObjectOutputStream> user : USERSONLINE.entrySet()) {
            name = user.getKey();
            namesOnlineUsers.add(name);
        }    
        
        return namesOnlineUsers;
    }
}
    
