package components;

import Swing.ModelCard;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.text.DecimalFormat;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Card extends javax.swing.JPanel {
private int currentBalance = 100;
private String voucherPrice = "";
private int numVoucherPrice = 0;

Balance bal = new Balance(); 

    public Color getColorGradient() {
        return colorGradient;
    }

    public void setColorGradient(Color colorGradient) {
        this.colorGradient = colorGradient;
    }

    private Color colorGradient;

    public Card() {
        initComponents();
        
       
        System.out.println("Udated"); 
        setOpaque(false);
        setBackground(new Color(112, 69, 246));
        colorGradient = new Color(255, 255, 255);
                        File flReader = new File("voucherAddon.txt");
                    try {
                        
                        Scanner vouchScan = new Scanner(flReader);
                        if (vouchScan.hasNextLine()) {
                            voucherPrice = vouchScan.next();
                            numVoucherPrice = Integer.valueOf(voucherPrice);
                            currentBalance += numVoucherPrice;
                            bal.getUser();
                            bal.getInfo();

                            if(Balance.firstOpen){
                                bal.getBalances(Balance.username);
                                Balance.firstOpen = false;
                            }
                            
                            
                            //ask danial how to parse code into this section + same for savings
                            
                            
                            bal.updateBalFile(true);
                            lbPer.setText("$" + Balance.currentCheque + ".00");
                        }
//                        if (!vouchScan.hasNextLine()) {
//                            lbPer.setText("$0.00");
//                        }

                    } catch (FileNotFoundException ex) {
                        System.out.println("Error occurred in sending voucher info");
                    }

    }
    
    public void selected(int index) {
        if (index == 0) {
                            File flReader = new File("voucherAddon.txt");
                    try {
                        
                        Scanner vouchScan = new Scanner(flReader);
                        if (vouchScan.hasNextLine()) {
                                                    voucherPrice = vouchScan.next();
                             numVoucherPrice = Integer.valueOf(voucherPrice);
                             currentBalance += numVoucherPrice;
                             voucherPrice = Integer.toString(currentBalance);
                            lbPer.setText("$" + voucherPrice + ".00");
                        } 
//                        if (!vouchScan.hasNextLine()) {
//                            lbPer.setText("$0.00");
//                        }

                    } catch (FileNotFoundException ex) {
                        System.out.println("Error occurred in sending voucher info");
                    }
        }
    }

    public void setData(ModelCard data) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        lbTitle.setText(data.getTitle());
        lbValues.setText(df.format(data.getValues()));
        lbIcon.setIcon(data.getIcon());
        lbPer.setText(df.format(data.getPercentage()) + "%");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbValues = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        lbPer = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(225, 225, 225));
        lbTitle.setText("Chequing Account");

        lbValues.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lbValues.setForeground(new java.awt.Color(225, 225, 225));
        lbValues.setText("Balance");

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lbPer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbPer.setForeground(new java.awt.Color(255, 255, 255));
        lbPer.setText("$0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbPer))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValues)
                            .addComponent(lbTitle))
                        .addGap(18, 18, 18)
                        .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbValues))
                    .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(lbPer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, getHeight(), getBackground(), getWidth(), 0, colorGradient);
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        
       
       
        
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbPer;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValues;
    // End of variables declaration//GEN-END:variables
}
