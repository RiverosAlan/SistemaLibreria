/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import JavaSql.JavaMySql;
import Ventanas.libro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import static Ventanas.Principal_Sistema.content;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Antonio
 */
public class nuevolibro extends javax.swing.JPanel {

    JavaMySql conn;
    Connection reg;
    boolean edition;
    String origId;
    String sigla;
    /**
     * Creates new form Principal
     */
    public nuevolibro(String cod) {
        
 
        initComponents();
        conn = new JavaMySql();
        reg = conn.conexion();
        edition = false;
        sigla=cod;
        id.setText(GeneraCod(cod));
        id.setEnabled(false);
        
        
        Title.setText("REGISTRAR NUEVO LIBRO");
        cancelar.setText("CANCELAR");
        btn_1.setText("REGISTRAR LIBRO");
    }
    public String GeneraCod(String cod)
    {
        String codN="",carLib="";
        int m;
        
        switch(cod)
        {
            case "AUS":
                carLib="Contaduria y Auditoria de Sistemas";
                break;
                
           
            case "SIS":
                carLib="Ing de Sistemas y TIC";
                break;
                
            case "COM":
                carLib="Ing Comercial y Empresarial";
                break;
            case "VET":
                carLib="Medicina Veterinaria";
                break;
            case "CIV":
                carLib="Ing Civil";
                break;
            case "TRS":
                carLib="Trabajo Social";
                break;
            case "HAR":
                carLib="Ing de Hardware y Robotica";
                break;
            case "SOF":
                carLib="Ing de Software y Multimedia";
                break;
            case "ZOO":
                carLib="Ing Zootecnica";
                break;
            case "ARG":
                carLib="Ing Agronomica";
                break;
            case "ARU":
                carLib="Arquitectura y Urbanismo";
                break;
            
        }
        
        carreraL.setSelectedItem(carLib);
       // JOptionPane.showMessageDialog(null,"carrera de genera: "+carLib);
        try{
            
                Statement stm = reg.createStatement();
                ResultSet counter = stm.executeQuery("SELECT * FROM `libro` WHERE `carrera` = '"+carLib+"'");
                while(counter.next())
                {
                    codN=counter.getString("idlibro");
                }
                if(codN.equals(""))
                {
                    codN="L-"+cod+"001";
                }
                else
                {
                    m=Integer.parseInt(codN.substring(6,8));
                    m=m+1;
                    
                    switch (Integer.toString(m).length())
                    {
                        case(1):
                            codN="L-"+cod+"00"+m;
                            break;
                        case(2):
                            codN="L-"+cod+"0"+m;
                            break;
                        case(3):
                            codN="L-"+cod+m;
                            break;
                    }
                    
                }
        }
        catch(Exception e)
        {
            
        }
        return codN;
    }
    
    public nuevolibro(String bid, String tit, String cate, String care,String aut, String fechaP, String disp,String des)
    {
        initComponents();
        conn = new JavaMySql();
        reg = conn.conexion();
        edition = true;
        
        origId = bid;
        id.setText(bid);
        tituloL.setText(tit);
        
        Title.setText("EDITAR LIBRO");
        cancelar.setText("CANCELAR EDICION");
        btn_1.setText("GUARDAR CAMBIOS");
        
        switch(care)
        {
            case "Contaduria y Auditoria de Sistemas":
                sigla="AUS";
                break;
                
           
            case "Ing de Sistemas y TIC":
                sigla="SIS";
                break;
                
            case "Ing Comercial y Empresarial":
                sigla="COM";
                break;
            case "Medicina Veterinaria":
                sigla="VET";
                break;
            case "Ing Civil":
                sigla="CIV";
                break;
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        Date e;
        
            try {
                e = DevFechaD(fechaP);
                fechaPu.setDatoFecha(e);
            } catch (ParseException ex) {
                Logger.getLogger(nuevolibro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
        
        autor.setText(aut);
        categoria.setSelectedItem(cate);
        carreraL.setSelectedItem(care);
        descri.setText(des);
        dis.setText(disp);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        subir = new javax.swing.JPanel();
        btn_1 = new javax.swing.JLabel();
        Text3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        Text6 = new javax.swing.JLabel();
        tituloL = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        Text7 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        Text8 = new javax.swing.JLabel();
        autor = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        Text9 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        Text12 = new javax.swing.JLabel();
        descri = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        Text15 = new javax.swing.JLabel();
        dis = new javax.swing.JTextField();
        Text16 = new javax.swing.JLabel();
        carreraL = new javax.swing.JComboBox<>();
        fechaPu = new rojeru_san.rsdate.RSDateChooser();
        categoria = new javax.swing.JComboBox<>();
        subir1 = new javax.swing.JPanel();
        cancelar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(750, 430));
        setPreferredSize(new java.awt.Dimension(750, 430));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setText("REGISTRAR NUEVO LIBRO");
        add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 10, 350));

        subir.setBackground(new java.awt.Color(51, 73, 84));
        subir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                subirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                subirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                subirMousePressed(evt);
            }
        });
        subir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        btn_1.setForeground(new java.awt.Color(255, 255, 255));
        btn_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_1.setText("REGISTRAR LIBRO");
        btn_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_1MousePressed(evt);
            }
        });
        subir.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 250, 50));

        add(subir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 260, 50));

        Text3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text3.setText("Libro ID");
        add(Text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        id.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        id.setForeground(new java.awt.Color(102, 102, 102));
        id.setText("Ingrese el ID del Libro");
        id.setBorder(null);
        id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                idMousePressed(evt);
            }
        });
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 260, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator4.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 260, 10));

        Text6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text6.setText("Título");
        add(Text6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        tituloL.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tituloL.setForeground(new java.awt.Color(102, 102, 102));
        tituloL.setText("Ingrese el Título");
        tituloL.setBorder(null);
        tituloL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tituloLMousePressed(evt);
            }
        });
        tituloL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloLActionPerformed(evt);
            }
        });
        add(tituloL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 260, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator7.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 260, 10));

        Text7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text7.setText("Fecha de Publicación");
        add(Text7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jSeparator8.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator8.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 260, 10));

        Text8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text8.setText("Autor");
        add(Text8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        autor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        autor.setForeground(new java.awt.Color(102, 102, 102));
        autor.setText("Ingrese el nombre del Autor/es");
        autor.setBorder(null);
        autor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                autorMousePressed(evt);
            }
        });
        autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autorActionPerformed(evt);
            }
        });
        add(autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 260, 30));

        jSeparator9.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator9.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 260, 10));

        Text9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text9.setText("Categoría");
        add(Text9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jSeparator10.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator10.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 260, 10));

        Text12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text12.setText("Descripción");
        add(Text12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        descri.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        descri.setForeground(new java.awt.Color(102, 102, 102));
        descri.setText("Ingrese la descripción del Libro");
        descri.setBorder(null);
        descri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                descriMousePressed(evt);
            }
        });
        descri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriActionPerformed(evt);
            }
        });
        add(descri, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 260, 70));

        jSeparator13.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator13.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 260, -1));

        jSeparator16.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator16.setPreferredSize(new java.awt.Dimension(200, 10));
        add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 260, 10));

        Text15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text15.setText("Carrera");
        add(Text15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        dis.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        dis.setForeground(new java.awt.Color(102, 102, 102));
        dis.setText("Cantidad a prestar");
        dis.setBorder(null);
        dis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                disMousePressed(evt);
            }
        });
        dis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disActionPerformed(evt);
            }
        });
        add(dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 100, 30));

        Text16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text16.setText("Disponibles");
        add(Text16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 20));

        carreraL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ninguno", "Ing de Sistemas y TIC", "Contaduria y Auditoria de Sistemas", "Ing Comercial y Empresarial", "Medicina Veterinaria", "Ing Civil", "Ing Zootecnica", "Ing Agronomica", "Arquitectura y Urbanismo", "Trabajo Social", "Ing de Hardware y Robotica", "Ing de Software y Multimedia", " " }));
        carreraL.setEnabled(false);
        add(carreraL, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 260, 30));

        fechaPu.setBackground(new java.awt.Color(51, 73, 84));
        fechaPu.setColorBackground(new java.awt.Color(51, 73, 84));
        fechaPu.setColorButtonHover(new java.awt.Color(51, 73, 84));
        fechaPu.setColorDiaActual(new java.awt.Color(51, 73, 84));
        fechaPu.setColorForeground(new java.awt.Color(0, 0, 0));
        fechaPu.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        fechaPu.setFormatoFecha("dd/MM/yyyy");
        fechaPu.setFuente(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        fechaPu.setMaximumSize(new java.awt.Dimension(300, 200));
        fechaPu.setPreferredSize(new java.awt.Dimension(100, 20));
        add(fechaPu, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 260, 30));

        categoria.setEditable(true);
        categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proyecto", "Tesis de Licenciatura", "Emprendimiento", "Perfil de Tesis", "Borrrador de Tesis" }));
        categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaActionPerformed(evt);
            }
        });
        add(categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 260, 30));

        subir1.setBackground(new java.awt.Color(51, 73, 84));
        subir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                subir1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                subir1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                subir1MousePressed(evt);
            }
        });
        subir1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancelar.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelar.setText("CANCELAR");
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelarMousePressed(evt);
            }
        });
        subir1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        add(subir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 260, 50));
    }// </editor-fold>//GEN-END:initComponents
private Date DevFechaD(String f) throws ParseException
{
    SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
    Date fecha=formato.parse(f);
    
    return fecha;
}
 private String DevFecha(Date f)
{
    
    /*otro*/
     
        
    
    
    
    
    
        
        char af,bf,c,d,e,g,h,i;
        SimpleDateFormat fc=new SimpleDateFormat("dd/MM/yyyy");
        String fec=fc.format(f);
        af=fec.charAt(0);
        String dia1=Character.toString(af);
        bf=fec.charAt(1);
        String dia2=Character.toString(bf);
        
        c=fec.charAt(3);
        String m1=Character.toString(c);
        d=fec.charAt(4);
        String m2=Character.toString(d);
        
        e=fec.charAt(6);
        String y1=Character.toString(e);
        g=fec.charAt(7);
        String y2=Character.toString(g);
        h=fec.charAt(8);
        String y3=Character.toString(h);
        i=fec.charAt(9);
        String y4=Character.toString(i);
        
        
        
        String nfecha = dia1+dia2+"/"+m1+m2+"/"+y1+y2+y3+y4;
        
        return nfecha;
       

}
    private void subirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subirMouseEntered
        
    }//GEN-LAST:event_subirMouseEntered

    private void subirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subirMouseExited
        
    }//GEN-LAST:event_subirMouseExited

    private void idMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idMousePressed
       if(id.getText().equals("Ingrese el ID del Libro"))
        id.setText("");
       if(tituloL.getText().equals("") || tituloL.getText() == null || tituloL.getText().equals(" "))
        tituloL.setText("Ingrese el Título");
       
       if(autor.getText().equals("") || autor.getText() == null || autor.getText().equals(" "))
        autor.setText("Ingrese el nombre del Autor/es");
       
       if(descri.getText().equals("") || descri.getText() == null || descri.getText().equals(" "))
        descri.setText("Ingrese la descripción del Libro");  
    }//GEN-LAST:event_idMousePressed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void tituloLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tituloLMousePressed
        if(tituloL.getText().equals("Ingrese el Título"))
        tituloL.setText("");
       if(id.getText().equals("") || id.getText() == null || id.getText().equals(" "))
        id.setText("Ingrese el ID del Libro");
       if(dis.getText().equals("") || dis.getText() == null || dis.getText().equals(" "))
        dis.setText("Cantidad a prestar");
       if(autor.getText().equals("") || autor.getText() == null || autor.getText().equals(" "))
        autor.setText("Ingrese el nombre del Autor/es");
      
       if(descri.getText().equals("") || descri.getText() == null || descri.getText().equals(" "))
        descri.setText("Ingrese la descripción del Libro"); 
    }//GEN-LAST:event_tituloLMousePressed

    private void tituloLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloLActionPerformed

    private void autorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autorMousePressed
        if(autor.getText().equals("Ingrese el nombre del Autor/es"))
        autor.setText("");
       if(id.getText().equals("") || id.getText() == null || id.getText().equals(" "))
        id.setText("Ingrese el ID del Libro");
       if(tituloL.getText().equals("") || tituloL.getText() == null || tituloL.getText().equals(" "))
        tituloL.setText("Ingrese el Título");
       if(dis.getText().equals("") || dis.getText() == null || dis.getText().equals(" "))
        dis.setText("Cantidad a prestar");
       
       if(descri.getText().equals("") || descri.getText() == null || descri.getText().equals(" "))
        descri.setText("Ingrese la descripción del Libro");
       
       
    }//GEN-LAST:event_autorMousePressed

    private void autorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autorActionPerformed

    private void descriMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descriMousePressed
        if(descri.getText().equals("Ingrese la descripción del Libro"))
        descri.setText("");
       if(id.getText().equals("") || id.getText() == null || id.getText().equals(" "))
        id.setText("Ingrese el ID del Libro");
       if(tituloL.getText().equals("") || tituloL.getText() == null || tituloL.getText().equals(" "))
        tituloL.setText("Ingrese el Título");
       if(dis.getText().equals("") || dis.getText() == null || dis.getText().equals(" "))
        dis.setText("Cantidad a prestar");
       if(autor.getText().equals("") || autor.getText() == null || autor.getText().equals(" "))
        autor.setText("Ingrese el nombre del Autor/es");
      
       
        
       
    }//GEN-LAST:event_descriMousePressed

    private void descriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriActionPerformed

    // SUBIR
    private void subirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subirMousePressed
        if(id.getText().equals("Ingrese el ID del Libro") || tituloL.getText().equals("Ingrese el Título")
            || DevFecha(fechaPu.getDatoFecha()).equals("Seleccinar fecha") || autor.getText().equals("Ingrese el nombre del Autor/es")
            ||  descri.getText().equals("Ingrese la descripción del Libro")
            || dis.getText().equals("Cantidad a prestar")
            || carreraL.getSelectedItem().toString().equals("ninguno")
                
         )
        {
            
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            id.requestFocus();
        }
        else
        {
            String bid = id.getText();
            String btitle = tituloL.getText();
            String bcategory = (String) categoria.getSelectedItem();
            String bcarrera=(String) carreraL.getSelectedItem();
            String bathor = autor.getText();
            String bdate = DevFecha(fechaPu.getDatoFecha());
            String bavailable = dis.getText();
            String bdescr = descri.getText();
            int pag=0;
            int stc=0;
            int av=0;

            if(bid == null 
                    || "".equals(bid) 
                    || btitle == null 
                    || "".equals(btitle) 
                    || bdate == null 
                    || "".equals(bdate) 
                    || bathor == null 
                    || "".equals(bathor) 
                    || bcategory == null 
                    || "".equals(bcategory)
                    || bdescr == null 
                    || "".equals(bdescr) 
                    || bavailable == null 
                    || "".equals(bavailable)
                    
                    || bcarrera == null 
                    || "".equals(bcarrera)
                    
               )
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                id.requestFocus();
            }
            else{ 
                try{
                    
                    av = Integer.parseInt(bavailable);

                    try {
                        if(edition)
                            EditBook(bid, btitle, bcategory, bcarrera,bathor,bdate,bavailable, bdescr);
                        else
                            InsertBook(bid, btitle, bcategory,bcarrera, bathor,bdate,bavailable, bdescr);

                        id.setText("");
                        tituloL.setText("");
                        
                        autor.setText("");
                        categoria.setSelectedItem("");
                        
                        descri.setText("");
                       
                        carreraL.setSelectedItem("");
                        

                        if(edition){
                            libro p1 = new libro(bcarrera);
                            p1.setSize(750, 430);
                            p1.setLocation(5, 5);

                            content.removeAll();
                            content.add(p1, BorderLayout.CENTER);
                            content.revalidate();
                            content.repaint();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(NuevoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }catch(NumberFormatException ex){
                    javax.swing.JOptionPane.showMessageDialog(this, "Las páginas, el Stock y el Disponible, deben ser números enteros. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    id.requestFocus();
                }

            }
        }
    }//GEN-LAST:event_subirMousePressed

    private void btn_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MousePressed
if(id.getText().equals("Ingrese el ID del Libro") || tituloL.getText().equals("Ingrese el Título")
            || DevFecha(fechaPu.getDatoFecha()).equals("Seleccinar fecha") || autor.getText().equals("Ingrese el nombre del Autor/es")
            || descri.getText().equals("Ingrese la descripción del Libro")
            || dis.getText().equals("Cantidad a prestar")
            || carreraL.getSelectedItem().toString().equals("ninguno")
                
         )
        {
            
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            id.requestFocus();
        }
        else
        {
            String bid = id.getText();
            String btitle = tituloL.getText();
            String bcategory =(String) categoria.getSelectedItem();
            String bcarrera=(String) carreraL.getSelectedItem();
            String bathor = autor.getText();
            String bdate = DevFecha(fechaPu.getDatoFecha());
            String bavailable = dis.getText();
            String bdescr = descri.getText();
            int pag=0;
            int stc=0;
            int av=0;

            if(bid == null 
                    || "".equals(bid) 
                    || btitle == null 
                    || "".equals(btitle) 
                    || bdate == null 
                    || "".equals(bdate) 
                    || bathor == null 
                    || "".equals(bathor) 
                    || bcategory == null 
                    || "".equals(bcategory)
                    || bdescr == null 
                    || "".equals(bdescr) 
                    || bavailable == null 
                    || "".equals(bavailable)
                    
                    || bcarrera == null 
                    || "".equals(bcarrera)
                    
               )
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                id.requestFocus();
            }
            else{ 
                try{
                    
                    av = Integer.parseInt(bavailable);

                    try {
                        if(edition)
                            EditBook(bid, btitle, bcategory, bcarrera,bathor,bdate,bavailable, bdescr);
                        else
                            InsertBook(bid, btitle, bcategory,bcarrera, bathor,bdate,bavailable, bdescr);

                        id.setText("");
                        tituloL.setText("");
                        
                        autor.setText("");
                        categoria.setSelectedItem("");
                        
                        descri.setText("");
                       
                        carreraL.setSelectedItem("");
                        

                       
                    } catch (SQLException ex) {
                        Logger.getLogger(NuevoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }catch(NumberFormatException ex){
                    javax.swing.JOptionPane.showMessageDialog(this, "Las páginas, el Stock y el Disponible, deben ser números enteros. \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    id.requestFocus();
                }

            }
        }






        // TODO add your handling code here:
    }//GEN-LAST:event_btn_1MousePressed

    private void disMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disMousePressed
 if(dis.getText().equals("Cantidad a prestar") || dis.getText() == null || dis.getText().equals(" "))
        dis.setText("");
       if(tituloL.getText().equals("") || tituloL.getText() == null || tituloL.getText().equals(" "))
        tituloL.setText("Ingrese el Título");
       
       if(autor.getText().equals("") || autor.getText() == null || autor.getText().equals(" "))
        autor.setText("Ingrese el nombre del Autor/es");
       
       if(descri.getText().equals("") || descri.getText() == null || descri.getText().equals(" "))
        descri.setText("Ingrese la descripción del Libro");        // TODO add your handling code here:
    }//GEN-LAST:event_disMousePressed

    private void disActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disActionPerformed

    private void categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaActionPerformed

    private void cancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMousePressed
        libro p1 = new libro(carreraL.getSelectedItem().toString());
        p1.setSize(750, 430);
        p1.setLocation(0,0);
        
        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarMousePressed

    private void subir1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subir1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_subir1MouseEntered

    private void subir1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subir1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_subir1MouseExited

    private void subir1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subir1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_subir1MousePressed

    void setColor(JPanel panel){
        panel.setBackground(new Color(21,101,192));
    }
    void resetColor(JPanel panel){
        panel.setBackground(new Color(18,90,173));
    }
    
    public void InsertBook(String id, String titu, String cate,String car,String auth,String fech, String dispo, String descrip) throws SQLException{
        Statement stm = reg.createStatement();
        
        stm.executeUpdate("INSERT INTO `libro` (`idlibro`, `titulo`, `categoria`,`carrera`,`autor`, `fecha_P`, `disponible`, `descripcion`) VALUES ('"+id+"', '"+titu+"', '"+ cate +"','"+ car +"', '"+ auth +"', '"+fech+"', '"+dispo+"', '"+descrip+"')");
        javax.swing.JOptionPane.showMessageDialog(this, "¡Libro registrado correctamente! \n", "HECHO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        libro p1 = new libro(car);
        p1.setSize(750, 430);
        p1.setLocation(0,0);

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
    
    public void EditBook(String id, String titu, String cate,String car,String auth,String fech, String dispo, String descrip) throws SQLException{
        Statement stm = reg.createStatement();
        
        stm.executeUpdate("UPDATE `libro` SET `titulo` = '"+titu+"', `categoria` = '"+cate+"', `carrera` = '"+car+"',`autor` = '"+auth+"', `fecha_P` = '"+fech+"', `disponible` = '"+dispo+"', `descripcion` = '"+descrip+"' WHERE `idlibro`='"+id+"';");
        javax.swing.JOptionPane.showMessageDialog(this, "¡Libro editado correctamente! \n", "HECHO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
        libro p1 = new libro(car);
        p1.setSize(750, 430);
        p1.setLocation(0,0);

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Text12;
    private javax.swing.JLabel Text15;
    private javax.swing.JLabel Text16;
    private javax.swing.JLabel Text3;
    private javax.swing.JLabel Text6;
    private javax.swing.JLabel Text7;
    private javax.swing.JLabel Text8;
    private javax.swing.JLabel Text9;
    private javax.swing.JLabel Title;
    private javax.swing.JTextField autor;
    private javax.swing.JPanel body;
    private javax.swing.JLabel btn_1;
    private javax.swing.JLabel cancelar;
    private javax.swing.JComboBox<String> carreraL;
    private javax.swing.JComboBox<String> categoria;
    private javax.swing.JTextField descri;
    private javax.swing.JTextField dis;
    private rojeru_san.rsdate.RSDateChooser fechaPu;
    private javax.swing.JTextField id;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel subir;
    private javax.swing.JPanel subir1;
    private javax.swing.JTextField tituloL;
    // End of variables declaration//GEN-END:variables
}
