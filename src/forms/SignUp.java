/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.opencv.core.Core;
import forms.mainMenu;
import java.awt.Image;
import javax.swing.ImageIcon;

public class SignUp extends javax.swing.JFrame {

    public SignUp() {
        initComponents();
        lblInfo4.setVisible(false);
        btnYes.setVisible(false);
        btnNo.setVisible(false);
                        this.setTitle("Sign Up");
        
        Image icon = new ImageIcon(this.getClass().getResource("/icons/CardLogoV1.png")).getImage();
        this.setIconImage(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        lblInfo1 = new javax.swing.JLabel();
        lblInfo3 = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtQuestion = new javax.swing.JTextField();
        lblInfo2 = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        txtAns = new javax.swing.JTextField();
        lblAns = new javax.swing.JLabel();
        lblInfo4 = new javax.swing.JLabel();
        btnYes = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jTextField2.setText("jTextField1");

        lblInfo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo1.setText("Enter your new Username and Password: ");

        lblInfo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo3.setText("Enter your new Username and Password: ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblInfo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo.setText("Enter your new Username and Password: ");

        lblUser.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblUser.setText("Username:");

        lblPass.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblPass.setText("Password:");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblInfo2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblInfo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo2.setText("Enter a Security Question and Answer:");

        lblQuestion.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblQuestion.setText("Security Question:");

        lblAns.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblAns.setText("Answer:");

        lblInfo4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblInfo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo4.setText("Would you like to register for a Face ID?");

        btnYes.setText("Yes");
        btnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYesActionPerformed(evt);
            }
        });

        btnNo.setText("No");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoBGV3.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnBack))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(btnYes)
                                .addGap(100, 100, 100)
                                .addComponent(btnNo))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblInfo4, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblUser)
                                .addComponent(lblAns)
                                .addComponent(lblQuestion)
                                .addComponent(lblPass))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAns, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(lblInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(214, 214, 214)
                            .addComponent(btnSubmit))))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(lblInfo)
                .addGap(18, 18, 18)
                .addComponent(lblInfo2)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPass))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuestion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns))
                .addGap(62, 62, 62)
                .addComponent(btnSubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInfo4)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnYes)
                    .addComponent(btnNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:

        boolean check = true;
        boolean check2 = true;
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*"); //https://www.javamadesoeasy.com/2015/12/how-to-check-string-contains-special.html

        ArrayList<String> username = new ArrayList<String>();
        ArrayList<String> trash = new ArrayList<String>();

        int counter = 1;
        try {
            File myObj = new File("accounts.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) //continues to read until the line is null or doesn't contrain anything 
            {
                if (counter == 1) {
                    username.add(myReader.nextLine().toLowerCase().trim());
                }

                if (counter == 2) {
                    trash.add(myReader.nextLine());

                }

                if (counter == 3) {
                    trash.add(myReader.nextLine());

                }

                if (counter == 4) {
                    trash.add(myReader.nextLine());

                }

                if (counter == 5) {
                    trash.add(myReader.nextLine());
                    counter = 0;
                }

                counter++;
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Matcher matcher = pattern.matcher(txtPass.getText());

        if (txtUser.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a value for username");
            check = false;
        }

        if (txtUser.getText().contains(" ")) {
            JOptionPane.showMessageDialog(null, "Username cannot contain spaces");
            check = false;

        }

        if (username.contains(txtUser.getText().toLowerCase())) {
            JOptionPane.showMessageDialog(null, "Username already exsists");
            check = false;
        }

        if (txtUser.getText().length() > 8) {
            JOptionPane.showMessageDialog(null, "Username cannot be more than 8 characters");
            check = false;

        }

        if (txtPass.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a value for password");
            check = false;
            check2 = false;

        }

        if (txtPass.getText().contains(" ")) {
            JOptionPane.showMessageDialog(null, "Password cannot contain spaces");
            check = false;

        }

        if (txtPass.getText().length() > 4 || txtPass.getText().length() < 4 && check2 == true) {
            JOptionPane.showMessageDialog(null, "Password must be 4 characters");
            check = false;

        }

        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Password cannot contain special characters");
            check = false;

        }

        if (txtQuestion.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a value for security question");
            check = false;

        }

        if (txtAns.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a value for answer");
            check = false;

        }

        if (txtAns.getText().contains(" ")) {
            JOptionPane.showMessageDialog(null, "Answer to the security question must be one word");
            check = false;

        }

        if (check == true) {
            btnSubmit.setEnabled(false);
            txtUser.setEditable(false);
            txtPass.setEditable(false);
            txtQuestion.setEditable(false);
            txtAns.setEditable(false);
            lblInfo4.setVisible(true);
            btnYes.setVisible(true);
            btnNo.setVisible(true);
            btnBack.setVisible(false);

        }


    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        dispose();
        new Login().setVisible(true);

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYesActionPerformed
        // TODO add your handling code here:
        //load into face ID
        try {
            FileWriter myWriter = new FileWriter("accounts.txt", true);
            myWriter.write(txtUser.getText().toLowerCase() + "\n");
            myWriter.write(txtPass.getText() + "\n");
            myWriter.write(txtQuestion.getText() + "\n");
            myWriter.write(txtAns.getText() + "\n");
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter current = new FileWriter("currentLogin.txt");
            current.write(txtUser.getText().toLowerCase() + "\n");
            current.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        dispose();
        new FaceID().setVisible(true);
    }//GEN-LAST:event_btnYesActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        // TODO add your handling code here:
        try {
            FileWriter myWriter = new FileWriter("accounts.txt", true);
            myWriter.write(txtUser.getText().toLowerCase() + "\n");
            myWriter.write(txtPass.getText() + "\n");
            myWriter.write(txtQuestion.getText() + "\n");
            myWriter.write(txtAns.getText() + "\n");
            myWriter.write("No" + "\n");
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter current = new FileWriter("currentLogin.txt");
            current.write(txtUser.getText().toLowerCase() + "\n");
            current.close();
            JOptionPane.showMessageDialog(null, "Successfully saved information!");
            btnNo.setEnabled(false);
            btnYes.setEnabled(false);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        dispose();
        new mainMenu().setVisible(true);

    }//GEN-LAST:event_btnNoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnYes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblAns;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblInfo1;
    private javax.swing.JLabel lblInfo2;
    private javax.swing.JLabel lblInfo3;
    private javax.swing.JLabel lblInfo4;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtAns;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtQuestion;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
