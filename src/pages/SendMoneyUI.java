package pages;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import components.Balance;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class SendMoneyUI extends javax.swing.JFrame {

    /**
     * Creates new form SendMoneyUI
     */
    public SendMoneyUI() {
        initComponents();
        sLabel3.setVisible(false);
        sLabel4.setVisible(false);
        sLabel5.setVisible(false);
        sLabel6.setVisible(false);
        sLabel8.setVisible(false);
        sLabel9.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sPanel1 = new javax.swing.JPanel();
        sLabel1 = new javax.swing.JLabel();
        chequingOrSavings = new javax.swing.JComboBox<>();
        confirmTransaction = new javax.swing.JButton();
        withdrawAmount = new javax.swing.JTextField();
        sLabel2 = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        sLabel4 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        sLabel3 = new javax.swing.JLabel();
        sLabel6 = new javax.swing.JLabel();
        whoIsRecipient = new javax.swing.JTextField();
        sLabel7 = new javax.swing.JLabel();
        sLabel8 = new javax.swing.JLabel();
        sLabel5 = new javax.swing.JLabel();
        sLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        sLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sLabel1.setText("Select account to send money from.");

        chequingOrSavings.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an Account...", "Chequing", "Savings" }));
        chequingOrSavings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chequingOrSavingsActionPerformed(evt);
            }
        });

        confirmTransaction.setText("Confirm Transaction");
        confirmTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmTransactionActionPerformed(evt);
            }
        });

        withdrawAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawAmountActionPerformed(evt);
            }
        });

        sLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sLabel2.setText("Select amount to send.");

        Title.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Send Money");

        sLabel4.setForeground(new java.awt.Color(255, 0, 0));
        sLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sLabel4.setText("Try Again. Please fill in all the required fields.");

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        sLabel3.setForeground(new java.awt.Color(255, 0, 0));
        sLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sLabel3.setText("Try again. Please input a value greater than 0.");

        sLabel6.setForeground(new java.awt.Color(255, 0, 0));
        sLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sLabel6.setText("The value cannot exceed the money in your account.");

        whoIsRecipient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whoIsRecipientActionPerformed(evt);
            }
        });

        sLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sLabel7.setText("Select a user to transfer the money to.");

        sLabel8.setForeground(new java.awt.Color(255, 0, 0));
        sLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sLabel8.setText("This user does not exist. Try again.");

        javax.swing.GroupLayout sPanel1Layout = new javax.swing.GroupLayout(sPanel1);
        sPanel1.setLayout(sPanel1Layout);
        sPanel1Layout.setHorizontalGroup(
            sPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sPanel1Layout.createSequentialGroup()
                .addGroup(sPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sPanel1Layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(sLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(sPanel1Layout.createSequentialGroup()
                .addGroup(sPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(confirmTransaction))
                    .addGroup(sPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(chequingOrSavings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(sLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(sPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(whoIsRecipient, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(withdrawAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sPanel1Layout.createSequentialGroup()
                .addGroup(sPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sLabel3))
                    .addGroup(sPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(sPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sLabel4)
                            .addComponent(sLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(sPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sPanel1Layout.createSequentialGroup()
                        .addComponent(sLabel8)
                        .addGap(46, 46, 46)))
                .addGap(14, 14, 14))
        );
        sPanel1Layout.setVerticalGroup(
            sPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chequingOrSavings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(sPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(sLabel2)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(withdrawAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(whoIsRecipient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sPanel1Layout.createSequentialGroup()
                        .addComponent(sLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmTransaction)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sPanel1Layout.createSequentialGroup()
                        .addComponent(BackButton)
                        .addContainerGap())))
        );

        sLabel5.setText("jLabel1");

        sLabel9.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sLabel9)
                    .addComponent(sLabel5)
                    .addComponent(sPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sLabel5)
                .addGap(5, 5, 5)
                .addComponent(sLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chequingOrSavingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chequingOrSavingsActionPerformed
        //if(chequingOrSavings.)
    }//GEN-LAST:event_chequingOrSavingsActionPerformed

    private void confirmTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmTransactionActionPerformed
        Balance bal = new Balance();
        bal.getUser();
        
        String user = Balance.username;
        
        boolean valGood = false;
        boolean accGood = false;
        boolean recGood = false;
        String input = withdrawAmount.getText().toString();
        sLabel5.setText(input);
        String s = sLabel5.getText();
        double withdrawAmountNum = Double.valueOf(s);

        //remember to fix the exceptions -> when no value is inputted into the textfield
        if(chequingOrSavings.getSelectedItem().toString().equals("Select an Account...")){
            sLabel4.setVisible(true);
        }else{
            accGood=true;
        }
        boolean isChequingPicked=false;
        if(chequingOrSavings.getSelectedItem().toString().equals("Chequing")){
            isChequingPicked = true;
        }else{
            isChequingPicked = false;
        }

        if(withdrawAmountNum<=0||withdrawAmount.getText().length()<=0){//make sure to include balance to this if statement
            sLabel3.setVisible(true);
            valGood=false;
        }else if(withdrawAmountNum > getBalance(user,isChequingPicked)){
            sLabel6.setVisible(true);
            valGood=false;
        }else{
            valGood=true;
        }
        MoneyTransfer mt = new MoneyTransfer();
        
        String potentialUsername = whoIsRecipient.getText().toString();
        sLabel9.setText(potentialUsername);
        String testUsername = sLabel9.getText();
        
        String recipient="";
        System.out.println("testUsername: "+testUsername);
        System.out.println("amount: "+withdrawAmountNum);
        if(mt.doesUserExist(testUsername)){
        recGood = true;
        recipient = testUsername;
        }else{
        sLabel8.setVisible(true);
        recGood=false;
        }
        
        if(accGood&&valGood&&recGood){
            double transferAmount = withdrawAmountNum;

            boolean chequingSelected=true;

            if (chequingOrSavings.getSelectedItem().toString().equals("Chequing")) {
                chequingSelected=true;
            } else {
                chequingSelected=false;
            }
            
            mt.sendMoney(transferAmount,user,recipient,chequingSelected);// CORRECT IT OVER HERE

            
            dispose();
        }
    }//GEN-LAST:event_confirmTransactionActionPerformed

    private void withdrawAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawAmountActionPerformed

    }//GEN-LAST:event_withdrawAmountActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void whoIsRecipientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whoIsRecipientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_whoIsRecipientActionPerformed

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
            java.util.logging.Logger.getLogger(SendMoneyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendMoneyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendMoneyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendMoneyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendMoneyUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel Title;
    private javax.swing.JComboBox<String> chequingOrSavings;
    private javax.swing.JButton confirmTransaction;
    private javax.swing.JLabel sLabel1;
    private javax.swing.JLabel sLabel2;
    private javax.swing.JLabel sLabel3;
    private javax.swing.JLabel sLabel4;
    private javax.swing.JLabel sLabel5;
    private javax.swing.JLabel sLabel6;
    private javax.swing.JLabel sLabel7;
    private javax.swing.JLabel sLabel8;
    private javax.swing.JLabel sLabel9;
    private javax.swing.JPanel sPanel1;
    private javax.swing.JTextField whoIsRecipient;
    private javax.swing.JTextField withdrawAmount;
    // End of variables declaration//GEN-END:variables
private double getBalance(String user, boolean chequingSelected){
 ArrayList<String> usersList = new ArrayList<>();
            ArrayList<String> newUsersList = new ArrayList<>();
            boolean userFound= false;

            File users = new File("users.txt");
            Scanner scan = null;
            
            try{
                scan = new Scanner(users);
                while(scan.hasNextLine()){
                    usersList.add(scan.nextLine());
                }
                
            }catch(FileNotFoundException e){
                System.out.println("The file was not found and this is an error!");
            }
            
            //text file has now been copied into a String array list to analyze each individual line
            //the program will now search for the occurance of the inputted username to find the balance
            
            System.out.println();

            for(int i = 0; i<usersList.size();i++){
                if(usersList.get(i).equals(user)){
                    if(chequingSelected){
                        double chequingBalance = Double.valueOf(usersList.get(i+1));
                        return chequingBalance;
                    }else{
                        double savingsBalance = Double.valueOf(usersList.get(i+2));
                        return savingsBalance;
                    }
                }else{
                    return -1;
                }
            }
            return -1;
}

}
