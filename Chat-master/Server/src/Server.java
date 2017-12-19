import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;

public class Server{
    
    public static void main(String[] args) throws IOException {
        
        int portServer;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Digite a porta que deseja abrir: ");
        portServer = keyboard.nextInt();
        
        //portServer = 1212;
        
        ServerSocket server = new ServerSocket(portServer);
        
        System.out.println("Porta aberta \n");  
        
        System.out.println("Servidor iniciado em: " + new Date());
        
        Socket socketClient;
        ListennerClient client;
        Thread threadServer;
        
       
        JFrame f = new JFrame("Tetris");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(12*26+10, 26*23+25);
        f.setVisible(true);
		
        final Tetris game = new Tetris();
        
        game.init();
        f.add(game);
        
        new Thread() {         
            @Override public void run() {
                while (true) {
                    try {
                   
                        Thread.sleep(1000);                 
                        game.dropDown();
               
                    } catch ( InterruptedException e ) {}
                }
            }   
	}.start();
        
        
        while(true) {
            
            socketClient = server.accept();
            
            System.out.println("Cliente " + socketClient.getInetAddress().getHostAddress() 
                    + " conectado as " + new Date());
            
            //client = new ListennerClient(socketClient);
            
            //If true the democracy mode is active. 
            //otherwise it becomes random the selection of commands
            client = new ListennerClient(socketClient, game, true);
    
        
            threadServer = new Thread(client);
            threadServer.start();
        } 
    }
}
