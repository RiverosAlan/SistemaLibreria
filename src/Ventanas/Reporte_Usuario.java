/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import JavaSql.JavaMySql;
import static Ventanas.Principal_Sistema.content;
import java.awt.BorderLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author TORREZ PC
 */
public class Reporte_Usuario extends javax.swing.JPanel {

    JavaMySql conn;
    Connection reg;

    /**
     * Creates new form Reporte_Usuario
     */
    public Reporte_Usuario(String car) throws SQLException {
        initComponents();
        conn = new JavaMySql();
        reg = conn.conexion();

        Statement stm = reg.createStatement();

        if (!car.equals("Todas las Carreras")) {
            int c = 0;
            ResultSet r = stm.executeQuery("SELECT * FROM `usuario` WHERE `carrera`='" + car + "'");
            while (r.next()) {
                c++;
            }
            String list[][] = new String[c][7];
            int i = 0;
            ResultSet rs = stm.executeQuery("SELECT * FROM `usuario` WHERE `carrera`='" + car + "'");
            while (rs.next()) {
                list[i][0] = rs.getString("matricula");
                list[i][1] = rs.getString("nombre");
                list[i][2] = rs.getString("apP");
                list[i][3] = rs.getString("apM");
                list[i][4] = rs.getString("feN");
                list[i][5] = rs.getString("carrera");
                list[i][6] = rs.getString("tel");
                i++;
            }
            listUs.setModel(new javax.swing.table.DefaultTableModel(
                    list,
                    new String[]{
                        "CÉDULA DE IDENTIDAD", "NOMBRE", "A. PATERNO", "A. MATERNO", "FECHA DE NACIMIENTO", "CARRERA", "TÉLEFONO"
                    }));
        } else {
            int c = 0;
            ResultSet r = stm.executeQuery("SELECT * FROM `usuario`");
            while (r.next()) {
                c++;
            }
            String list[][] = new String[c][7];
            int i = 0;
            ResultSet rs = stm.executeQuery("SELECT * FROM `usuario`");
            while (rs.next()) {
                list[i][0] = rs.getString("matricula");
                list[i][1] = rs.getString("nombre");
                list[i][2] = rs.getString("apP");
                list[i][3] = rs.getString("apM");
                list[i][4] = rs.getString("feN");
                list[i][5] = rs.getString("carrera");
                list[i][6] = rs.getString("tel");
                i++;
            }
            listUs.setModel(new javax.swing.table.DefaultTableModel(
                    list,
                    new String[]{
                        "CÉDULA DE IDENTIDAD", "NOMBRE", "A. PATERNO", "A. MATERNO", "FECHA DE NACIMIENTO", "CARRERA", "TÉLEFONO"
                    }));
        }

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
        body = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        button = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listUs = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        button1 = new javax.swing.JPanel();
        atras = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(750, 430));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 430));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setText("REPORTES");
        jPanel1.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        button.setBackground(new java.awt.Color(51, 73, 84));
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonMousePressed(evt);
            }
        });
        button.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generar Reporte");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        button.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));

        jPanel1.add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 170, 40));

        listUs.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        listUs.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 10)); // NOI18N
        listUs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÉDULA DE IDENTIDAD", "NOMBRE", "A. PATERNO", "A. MATERNO", "FECHA DE NACIMIENTO", "CARRERA", "TÉLEFONO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        listUs.setRowHeight(20);
        jScrollPane1.setViewportView(listUs);
        if (listUs.getColumnModel().getColumnCount() > 0) {
            listUs.getColumnModel().getColumn(0).setPreferredWidth(105);
            listUs.getColumnModel().getColumn(4).setPreferredWidth(110);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 740, 270));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jLabel2.setText("ESTUDIANTES POR CARRERA ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 220, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 230, 10));

        button1.setBackground(new java.awt.Color(51, 73, 84));
        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button1MousePressed(evt);
            }
        });
        button1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        atras.setForeground(new java.awt.Color(255, 255, 255));
        atras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        atras.setText("<-Atras");
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                atrasMousePressed(evt);
            }
        });
        button1.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));

        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 170, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed

        ArrayList<listaUsuario> lista = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "cantidad: " + listUs.getRowCount());
        for (int i = 0; i < listUs.getRowCount(); i++) {
            listaUsuario listP = new listaUsuario(listUs.getValueAt(i, 0).toString(), listUs.getValueAt(i, 1).toString(), listUs.getValueAt(i, 2).toString(), listUs.getValueAt(i, 3).toString(), listUs.getValueAt(i, 4).toString(), listUs.getValueAt(i, 5).toString(), listUs.getValueAt(i, 6).toString());
            lista.add(listP);
        }

        try {
            JasperReport reporte = (JasperReport) net.sf.jasperreports.engine.util.JRLoader.loadObject(Reporte_Usuario.class.getResource("/Ventanas/report2.jasper"));
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
            JasperViewer viewer = new JasperViewer(imprimir, false);
            viewer.show();

//            //GENERAMOS ARCHIVOS           
//            File reporte2 = new File(getClass().getResource("/Ventanas/report2.jasper").getFile());
//            JFileChooser filechooser = new JFileChooser();
//            filechooser.setFileFilter(new FileNameExtensionFilter("Archivos PDf", "pdf"));
//            int seleccion = filechooser.showSaveDialog(this);
//            if (seleccion == JFileChooser.APPROVE_OPTION) {
//                File ArchivoSeleccionado = filechooser.getSelectedFile();
//                try {
//                    InputStream is = new BufferedInputStream(new FileInputStream(reporte2.getAbsolutePath()));
//                    JasperPrint imprimir2 = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
//                    //asperExportManager.exportReportToPdfFile( imprimir2, "C://Users/hp/Desktop/reporte.pdf");
//                    JasperExportManager.exportReportToPdfFile(imprimir2, ArchivoSeleccionado.getAbsolutePath() + ".pdf");
//
//                    //new lineas
//                    JRExporter exporter = new JRPdfExporter();
//                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, imprimir2);
//                    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("/docs/reportePDF.pdf"));
//                    exporter.exportReport();
//
//                } catch (FileNotFoundException | JRException e) {
//                    JOptionPane.showConfirmDialog(null, e + "Error en el genrado de archivos");
//                }
       // }
        } catch (JRException ex) {
            System.out.println("Error en la impresion");
            System.out.println(ex);
            ex.printStackTrace();
            JOptionPane.showConfirmDialog(null, ex + "Error en la impresion");
        }

    }//GEN-LAST:event_jLabel1MousePressed

    private void buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseEntered

    }//GEN-LAST:event_buttonMouseEntered

    private void buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseExited

    }//GEN-LAST:event_buttonMouseExited

    private void buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMousePressed

    }//GEN-LAST:event_buttonMousePressed

    private void atrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_atrasMousePressed

    private void button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_button1MouseEntered

    private void button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_button1MouseExited

    private void button1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1MousePressed

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
       //BOTON CLICK PARA NAVEGAR HACIA ATRAS
        ReportU p1 = new ReportU();
        p1.setSize(750, 430);
        p1.setLocation(0, 0);

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();  
    }//GEN-LAST:event_atrasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JLabel atras;
    private javax.swing.JPanel body;
    private javax.swing.JPanel button;
    private javax.swing.JPanel button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listUs;
    // End of variables declaration//GEN-END:variables
}
