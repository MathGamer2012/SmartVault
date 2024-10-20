/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import swings.ButtonMenu;
import events.EventMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JLabel;
import java.awt.Color;
/**
 *
 * @author Danial Suhail
 */
public class Menu extends javax.swing.JPanel {
private EventMenu event;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setOpaque(false);
        
        menuOption.setLayout(new MigLayout("wrap, fillx, inset 3", "[fill]", "[]0[]"));
        String username = ""; 
        
        try {
            File myObj = new File("currentLogin.txt");
            Scanner myReader = new Scanner(myObj);
            
            username = myReader.nextLine();
        }
        
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        jLabel1.setText(username); 
    }
    
    public void initMenu(EventMenu event) {
        this.event = event;
        addMenu(new ImageIcon(getClass().getResource("/menuicons/homeLogo.png")),"Home", 0 );
        addMenu(new ImageIcon(getClass().getResource("/menuicons/transferLogo.png")),"Transferring", 1 );
        addMenu(new ImageIcon(getClass().getResource("/menuicons/cashoutLogo.png")),"Cashout", 2 );
        addMenu(new ImageIcon(getClass().getResource("/menuicons/stockmarketLogo.png")),"Stock Market", 3 );
        addMenu(new ImageIcon(getClass().getResource("/menuicons/voucherLogo.png")),"Vouchers", 4 );
        addEmpty();
        addMenu(new ImageIcon(getClass().getResource("/menuicons/logoutLogo.png")),"Logout", 5 );
    }
    
    private void addEmpty() {
        menuOption.add(new JLabel(), "push");
    }
    private void addMenu(Icon icon, String text, int index) {
        ButtonMenu menu = new ButtonMenu();
        menu.setIcon(icon);
        menu.setText(" " + text);
//                if (index == 0) {  //Targets button located at "vouchers" index 4.
//
//        }
        menuOption.add(menu);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.selected(index);
                setSelected(menu);
            }
        });
    }
    
    private void setSelected(ButtonMenu menu) {
        for (Component com:menuOption.getComponents()) {
            if (com instanceof ButtonMenu) {
            ButtonMenu b = (ButtonMenu)com;
            b.setSelected(false);
            }
        }
        menu.setSelected(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        roundPanel1 = new swings.RoundPanel();
        imageAvatar1 = new swings.ImageAvatar();
        jLabel1 = new javax.swing.JLabel();
        roundPanel2 = new swings.RoundPanel();
        menuOption = new javax.swing.JPanel();

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        roundPanel1.setBackground(new java.awt.Color(153, 204, 255));
        roundPanel1.setForeground(new java.awt.Color(255, 255, 255));

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ProfilePicIconV3.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(31, 31, 204));
        jLabel1.setText("User Name");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel2.setBackground(new java.awt.Color(153, 204, 255));
        roundPanel2.setForeground(new java.awt.Color(255, 255, 255));

        menuOption.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout menuOptionLayout = new javax.swing.GroupLayout(menuOption);
        menuOption.setLayout(menuOptionLayout);
        menuOptionLayout.setHorizontalGroup(
            menuOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        menuOptionLayout.setVerticalGroup(
            menuOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swings.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel menuOption;
    private java.awt.Panel panel1;
    private swings.RoundPanel roundPanel1;
    private swings.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
