/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ux;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author HP 245 G4
 */
public class DtableD extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Select,boolean hasFocus,int row,int colum)
    {
        
        super.getTableCellRendererComponent(table, value, Select, hasFocus, row, colum);
        
        
        if(table.getValueAt(row, 4).equals("Deudor"))
        {
            setBackground(Color.YELLOW);
            setForeground(Color.black);
            
        }
        else
        {
            
                if(table.getValueAt(row, 4).equals("moroso"))
                {
                setBackground(new java.awt.Color(255, 58, 11));
                setForeground(Color.WHITE);
                 
                
                }
            
            
        }
        
        
        return this;
    }
}
