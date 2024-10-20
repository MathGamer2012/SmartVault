/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import gui.Validation;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class Recognizer extends javax.swing.JFrame {

    public DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    CascadeClassifier faceDetector = new CascadeClassifier(FaceID.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
    MatOfRect faceDetections = new MatOfRect();
    Validation valid = new Validation();
    String check = valid.getValues();

    public class DaemonThread implements Runnable {

        public static String currentFace;
        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                            Graphics g = jPanel1.getGraphics();
                            faceDetector.detectMultiScale(frame, faceDetections);
                            for (Rect rect : faceDetections.toArray()) {
                                // System.out.println("ttt");
                                Core.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                                        new Scalar(0, 255, 0));
                                Core.putText(frame, String.valueOf("Height: " + rect.height) + " Width: " + String.valueOf(rect.width), //this prints the shit 
                                        new Point(rect.x, rect.y - 20), 1, 1, new Scalar(255, 255, 255));

                                for (int i = 0; i < Validation.face.size(); i++) {
                                    if (!Validation.face.get(i).equals("No")) {
                                        if (rect.height > (Integer.valueOf(Validation.face.get(i)) - 5) && rect.height < (Integer.valueOf(Validation.face.get(i)) + 10)) {
                                            Core.putText(frame, Validation.username.get(i),
                                                    new Point(rect.x, rect.y + 50), 1, 1, new Scalar(255, 255, 255));
                                            myThread.runnable = false;
                                            webSource.release();

                                            btnCam.setEnabled(false);
                                            lblInfo.setVisible(true);
                                            btnRedetect.setVisible(true);
                                            btnRecognize.setVisible(true);
                                            btnRedetect.setEnabled(true);
                                            btnRecognize.setEnabled(true);
                                            currentFace = Validation.face.get(i);
                                            valid.getCurrentValue(currentFace);
                                            break;

                                        }
                                    }
                                }
                            }
                            Highgui.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            BufferedImage buff = (BufferedImage) im;
                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                if (runnable == false) {
                                    System.out.println("Paused ..... ");
                                    this.wait();
                                }
                            }
                        } catch (Exception ex) {
                            System.out.println("Error!!");
                            ex.printStackTrace();
                        }

                    }
                }
            }
        }
    }

    public Recognizer() {
        initComponents();
        btnRedetect.setVisible(false);
        btnRecognize.setVisible(false);
        lblInfo.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRedetect = new javax.swing.JButton();
        btnRecognize = new javax.swing.JButton();
        btnCam = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        btnRedetect.setText("Redetect");
        btnRedetect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedetectActionPerformed(evt);
            }
        });

        btnRecognize.setText("Log In");
        btnRecognize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecognizeActionPerformed(evt);
            }
        });

        btnCam.setText("Open Camera");
        btnCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCamActionPerformed(evt);
            }
        });

        lblInfo.setText("Not You? Click this button to Re-Detect:");

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(354, 354, 354)
                        .addComponent(btnRecognize)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 201, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(202, 202, 202))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCam)
                                .addGap(137, 137, 137)
                                .addComponent(btnRedetect)
                                .addGap(364, 364, 364))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblInfo)
                                .addGap(296, 296, 296))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRedetect)
                    .addComponent(btnCam))
                .addGap(18, 18, 18)
                .addComponent(btnRecognize)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRedetectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedetectActionPerformed
        // TODO add your handling code here:
        webSource = new VideoCapture(0); // video capture from default cam
        myThread = new Recognizer.DaemonThread(); //create object of threat class
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();                 //start thrad
    }//GEN-LAST:event_btnRedetectActionPerformed

    private void btnRecognizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecognizeActionPerformed
        // TODO add your handling code here:
        int index = Validation.face.indexOf(Validation.currentVal);

        String answer = JOptionPane.showInputDialog(this, Validation.security.get(index));
        if (answer != null) {
            answer = answer.trim();
        }
        if (Validation.answer.get(index).equals(answer)) {
            JOptionPane.showMessageDialog(null, "Sucesfully Logged In!");

            try {
                FileWriter current = new FileWriter("currentLogin.txt");
                current.write(Validation.username.get(index) + "\n");
                current.close();

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            dispose();
            new mainMenu().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Answer!");

        }


    }//GEN-LAST:event_btnRecognizeActionPerformed

    private void btnCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCamActionPerformed
        // TODO add your handling code here:
        webSource = new VideoCapture(0); // video capture from default cam
        myThread = new Recognizer.DaemonThread(); //create object of threat class
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();                 //start thrad
        btnRedetect.setEnabled(false);  // deactivate start button
        btnRecognize.setEnabled(true);
    }//GEN-LAST:event_btnCamActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recognizer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCam;
    private javax.swing.JButton btnRecognize;
    private javax.swing.JButton btnRedetect;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInfo;
    // End of variables declaration//GEN-END:variables
}
