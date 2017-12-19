import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class MainInterface extends javax.swing.JFrame {
    
    Socket socketServer = null;
    private ObjectOutputStream serverOutput;

    /**
     * Creates new form Interface
     */
    public MainInterface() {
        initComponents(); 
      
        //this.btnSend.setEnabled(false);
        this.txtAreaCommad.setEnabled(false);
        //this.txtAreaSend.setEnabled(false);
        //this.jListUsersOnline.setVisible(false); 
    }
    
    // Class to listenner the server and get message and send message. 
    public class ListennerServer implements Runnable {
        
        private ObjectInputStream serverInput;


        public ListennerServer(Socket socketServer) {

            try {
                this.serverInput = new ObjectInputStream(socketServer.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ListennerServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {

            boolean runTemp = true;
            //String text;
            String userName;
            Message message = null;
            //ArrayList<String> namesOnlineUsers;

            try {
                message = (Message) this.serverInput.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                runTemp = false;
            }
            
            //CONNECT, SEND_ALL, SEND_RESTRICT, ADD_USER_NAME_ONLINE, REMOVE_USER_NAME_ONLINE;   
            while(runTemp) {
                
                /*switch (message.getAction()) {
                case SEND_ALL:
                text =  message.getText();
                txtAreaMessage.append(text + '\n');
                break;
                case SEND_RESTRICT:
                text =  message.getText();
                txtAreaMessage.append(text + '\n');
                break;
                case ADD_USER_NAME_ONLINE:
                userName = message.getClientName();
                addUserNameOnline(userName);
                break;
                case REMOVE_USER_NAME_ONLINE:
                userName = message.getClientName();
                removeUserNameOnline(userName);
                break;
                default:// case CONNECT  
               
                text =  message.getText();
                if (text.equals("Name duplicate!")) {
                JOptionPane.showMessageDialog(null, "Nome duplicado!");
                txtName.setEditable(true);
                btnConect.setEnabled(true);
                run = false;
                } else {
                JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
                namesOnlineUsers = message.getNamesOnlineUsers();
                addAllUserNamesOnline(namesOnlineUsers);
                txtName.setEditable(false);
                btnConect.setEnabled(false);
                jListUsersOnline.setVisible(true);
                txtAreaSend.setEnabled(true);
                btnSend.setEnabled(true);
                }
                break;
                }*/
    
            }  
        }  
    }
 
    // Send message to connect in the server.
    private void sendConnect() {
        Message message = new Message();
        message.setAction(Message.Action.CONNECT);
        message.setClientName(this.txtName.getText());
        
        try {
            this.serverOutput.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    /*
    // Add user name online.
    private void addUserNameOnline(String userName) {
        DefaultListModel modelNamesOnlineUsers;
        
        modelNamesOnlineUsers = (DefaultListModel) this.jListUsersOnline.getModel(); 
        modelNamesOnlineUsers.addElement(userName); 
    }
    
    // Remove user name online.
    private void removeUserNameOnline(String userName) {
        DefaultListModel modelNamesOnlineUsers;
        String userReceiver = this.lblReceiverName.getText();
        int indexUserName;
        
        if (userReceiver.equals(userName)) {
            this.lblReceiverName.setText("All");
            JOptionPane.showMessageDialog(null, userReceiver + " disconnected...");
        }
        
        modelNamesOnlineUsers = (DefaultListModel) this.jListUsersOnline.getModel(); 
        indexUserName = modelNamesOnlineUsers.indexOf(userName);
        modelNamesOnlineUsers.remove(indexUserName);
        this.jListUsersOnline.setModel(modelNamesOnlineUsers);
    } */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnConect = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaCommad = new javax.swing.JTextArea();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Aharoni", 0, 12)); // NOI18N
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        btnConect.setText("Conectar");
        btnConect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectActionPerformed(evt);
            }
        });

        txtAreaCommad.setColumns(20);
        txtAreaCommad.setRows(5);
        txtAreaCommad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaCommadKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAreaCommadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAreaCommadKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtAreaCommad);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConect))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnConectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectActionPerformed
        String ipservidor;
        int portaservidor;
        
        if (this.txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo Nome.");
        }
        else {
            try {
                
                //ipservidor = "localhost";
                //portaservidor = 1212;
                
                ipservidor = JOptionPane.showInputDialog("Digite o IP do servidor:");
                portaservidor = Integer.parseInt(JOptionPane.showInputDialog("Digite a porta do servidor:"));
                
                this.socketServer = new Socket(ipservidor, portaservidor);
                this.serverOutput = new ObjectOutputStream(socketServer.getOutputStream());

                sendConnect();// Send CONNECT to server.
                this.txtName.setEditable(false);
                this.btnConect.setEnabled(false);
                this.txtAreaCommad.setEnabled(true);

                ListennerServer inputServer = new ListennerServer(this.socketServer);

                Thread threadInputServer = new Thread(inputServer);

                threadInputServer.start();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Falha ao se conectar ao servidor! Tente novamente...");
                 this.txtName.setEditable(true);
                 this.btnConect.setEnabled(true);
            }
        }    
    }//GEN-LAST:event_btnConectActionPerformed

    private void txtAreaCommadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaCommadKeyTyped
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtAreaCommadKeyTyped

    private void txtAreaCommadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaCommadKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtAreaCommadKeyPressed

    private void txtAreaCommadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaCommadKeyReleased
        // TODO add your handling code here:
        Message message = new Message();
        String aux = txtAreaCommad.getText().toUpperCase();
        
        //txtAreaCommad.setText(" -- ");
        //txtAreaCommad.setText(null);
        txtAreaCommad.setText("");
        txtAreaCommad.requestFocus();
        
        message.setClientName(getName());
        
        //okay
        
        if  ("W".equals(aux) ) {
        
            message.setCommand(Message.Command.UP);
        }
        
        if  ("S".equals(aux) ) {
            
            message.setCommand(Message.Command.DOWN);
        }
        
        if  ("A".equals(aux) ) {
            
            message.setCommand(Message.Command.LEFT);
        }
        
        if  ("D".equals(aux) ) {
            
            message.setCommand(Message.Command.RIGHT);
        }
        
        try {
            this.serverOutput.writeObject(message);
            System.out.println("Command sended");
        } catch (IOException ex) {
            Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtAreaCommad.setText("");
    }//GEN-LAST:event_txtAreaCommadKeyReleased

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
    }//GEN-LAST:event_formWindowStateChanged

 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConect;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaCommad;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
