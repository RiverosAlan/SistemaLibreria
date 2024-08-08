package Ux;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import static javax.management.Query.value;
import static javax.management.Query.value;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
//import static org.omg.CORBA.ARG_IN.value;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP 245 G4
 */
public class DtableL extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Select,boolean hasFocus,int row,int colum)
    {
        
        super.getTableCellRendererComponent(table, value, Select, hasFocus, row, colum);
        
        if(table.getValueAt(row, 3).equals("Prestado"))
        {
            setBackground(Color.YELLOW);
            setForeground(Color.black);
        }
        else
        {
            if(table.getValueAt(row, 3).equals("Disponible"))
            {
                setBackground(new java.awt.Color(51, 73, 84));
                setForeground(Color.WHITE);
            }
            else
            {
                if(table.getValueAt(row, 3).equals("No Disponible"))
                {
                      setBackground(new java.awt.Color(255, 58, 11));
                      setForeground(Color.WHITE);
                }
                else
                {
                    setBackground(new java.awt.Color(51, 73, 84));
                    setForeground(Color.WHITE);
                }
                
            }
            
        }
        
        
        return this;
    }
    
    
}
