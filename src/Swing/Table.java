/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Danial Suhail
 */
public class Table extends JTable {
    
    public Table() {
        setShowHorizontalLines(true);
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(true);
        setGridColor(new Color(245,251,253));
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 3) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
//        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) { 
//                if(i1 != 3) {
//                    Component com =  super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
//                    com.setBackground(Color.WHITE);
//                    setBorder(noFocusBorder);
//                    if (selected) {
//                        com.setForeground(new Color(15, 89, 140));
//                    } else {
//                        com.setForeground(new Color(102, 102, 102));
//                    }
//                    return com;
//                }
//                return new JLabel("Testing");
//            }
//        });
    }
    
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel)getModel();
        model.addRow(row);
    }
}
