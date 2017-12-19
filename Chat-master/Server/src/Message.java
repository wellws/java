import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Flávio Barreiro Landes
 * E-mail: landesflavio@gmail.com
 */
public class Message implements Serializable {
    private String clientName;
//    private String receiverName;
    private Command command;
//  private String text;
//  private ArrayList<String> namesOnlineUsers;
   private Action action;
     
public enum Command {
        UP, DOWN, LEFT, RIGHT;
    }
    
   public enum Action {
        CONNECT;//, SEND_ALL, SEND_RESTRICT, ADD_USER_NAME_ONLINE, REMOVE_USER_NAME_ONLINE;  
    }

    
    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /*    
    public String getReceiverName() {
    return this.receiverName;
    }
    
    public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
    }
    public String getText() {
    return this.text;
    }
    
    public void setText(String text) {
    this.text = text;
    }

    public ArrayList<String> getNamesOnlineUsers() {
        return this.namesOnlineUsers;
    }

    public void setNamesOnlineUsers(ArrayList<String> namesOnlineUsers) {
        this.namesOnlineUsers = namesOnlineUsers;
    }*/
    
    public Action getAction() {
        return this.action;
    }

    public void setAction(Action action) {
        this.action = action;
    } 
    
    public Command getCommand() {
        return this.command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
