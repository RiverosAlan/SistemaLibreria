/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import JavaSql.JavaMySql;
import static Ventanas.Principal_Sistema.content;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author TORREZ PC
 */
public class Reporte_Libros extends javax.swing.JPanel {

    JavaMySql conn;
    Connection reg;

    /**
     * Creates new form Reporte_Libros
     */
    public Reporte_Libros(String car, String cat) throws SQLException {
        initComponents();
        conn = new JavaMySql();
        reg = conn.conexion();

        Statement stm = reg.createStatement();

        if (car.equals("Todas las Carreras")) {
            if (cat.equals("Todos")) {
                int c = 0;
                ResultSet r = stm.executeQuery("SELECT * FROM `libro`");
                while (r.next()) {
                    c++;
                }
                String list[][] = new String[c][5];
                int i = 0;
                ResultSet rs = stm.executeQuery("SELECT * FROM `libro`");
                while (rs.next()) {
                    list[i][0] = rs.getString("titulo");
                    list[i][1] = rs.getString("categoria");
                    list[i][2] = rs.getString("carrera");
                    list[i][3] = rs.getString("autor");
                    list[i][4] = rs.getString("fecha_P");
                    i++;
                }
                listLi.setModel(new javax.swing.table.DefaultTableModel(
                        list,
                        new String[]{
                            "TÍTULO", "CATEGORÍA", "CARRERA", "AUTOR", "FECHA DE PUBLICACIÓN"
                        }));
            } else {
                int c = 0;
                ResultSet r = stm.executeQuery("SELECT * FROM `libro` WHERE categoria='" + cat + "'");
                while (r.next()) {
                    c++;
                }
                String list[][] = new String[c][5];
                int i = 0;
                ResultSet rs = stm.executeQuery("SELECT * FROM `libro` WHERE categoria='" + cat + "'");
                while (rs.next()) {
                    list[i][0] = rs.getString("titulo");
                    list[i][1] = rs.getString("categoria");
                    list[i][2] = rs.getString("carrera");
                    list[i][3] = rs.getString("autor");
                    list[i][4] = rs.getString("fecha_P");
                    i++;
                }
                listLi.setModel(new javax.swing.table.DefaultTableModel(
                        list,
                        new String[]{
                            "TÍTULO", "CATEGORÍA", "CARRERA", "AUTOR", "FECHA DE PUBLICACIÓN"
                        }));
            }
        } else {
            if (cat.equals("Todos")) {
                int c = 0;
                ResultSet r = stm.executeQuery("SELECT * FROM `libro` WHERE `carrera`='" + car + "'");
                while (r.next()) {
                    c++;
                }
                String list[][] = new String[c][5];
                int i = 0;
                ResultSet rs = stm.executeQuery("SELECT * FROM `libro` WHERE `carrera`='" + car + "'");
                while (rs.next()) {
                    list[i][0] = rs.getString("titulo");
                    list[i][1] = rs.getString("categoria");
                    list[i][2] = rs.getString("carrera");
                    list[i][3] = rs.getString("autor");
                    list[i][4] = rs.getString("fecha_P");
                    i++;
                }
                listLi.setModel(new javax.swing.table.DefaultTableModel(
                        list,
                        new String[]{
                            "TITULO", "CATEGORIA", "CARRERA", "AUTOR", "FECHA DE PUBLICACION"
                        }));
            } else {
                int c = 0;
                ResultSet r = stm.executeQuery("SELECT * FROM `libro` WHERE `carrera`='" + car + "' AND `categoria`='" + cat + "'");
                while (r.next()) {
                    c++;
                }
                String list[][] = new String[c][5];
                int i = 0;
                ResultSet rs = stm.executeQuery("SELECT * FROM `libro` WHERE `carrera`='" + car + "' AND `categoria`='" + cat + "'");
                while (rs.next()) {
                    list[i][0] = rs.getString("titulo");
                    list[i][1] = rs.getString("categoria");
                    list[i][2] = rs.getString("carrera");
                    list[i][3] = rs.getString("autor");
                    list[i][4] = rs.getString("fecha_P");
                    i++;
                }
                listLi.setModel(new javax.swing.table.DefaultTableModel(
                        list,
                        new String[]{
                            "TITULO", "CATEGORIA", "CARRERA", "AUTOR", "FECHA DE PUBLICACION"
                        }));
            }
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
        listLi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        button1 = new javax.swing.JPanel();
        btnAtras = new javax.swing.JLabel();

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

        jPanel1.add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 170, 40));

        listLi.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        listLi.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 10)); // NOI18N
        listLi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TÍTULO", "CATEGORÍA", "CARRERA", "AUTOR", "FECHA DE PUBLICACIÓN "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        listLi.setRowHeight(20);
        jScrollPane1.setViewportView(listLi);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 740, 270));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jLabel2.setText("LIBROS POR CARRERAS Y CATEGORÍA ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 290, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 280, 10));

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

        btnAtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAtras.setText("<- Atras");
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAtrasMousePressed(evt);
            }
        });
        button1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));

        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 170, 40));

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
        ArrayList<listaLibro> lista = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "cantidad: " + listLi.getRowCount());
        for (int i = 0; i < listLi.getRowCount(); i++) {
            listaLibro listP = new listaLibro(listLi.getValueAt(i, 0).toString(), listLi.getValueAt(i, 1).toString(), listLi.getValueAt(i, 2).toString(), listLi.getValueAt(i, 3).toString(), listLi.getValueAt(i, 4).toString());

            lista.add(listP);

        }

        try {
            JasperReport reporte = (JasperReport) net.sf.jasperreports.engine.util.JRLoader.loadObject(Reporte_Prestamos.class.getResource("/Ventanas/report3.jasper"));

            JasperPrint imprimir = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));

            JasperViewer viewer = new JasperViewer(imprimir, false);
            viewer.show();

        } catch (JRException ex) {

        }
    }//GEN-LAST:event_jLabel1MousePressed

    private void buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseEntered

    }//GEN-LAST:event_buttonMouseEntered

    private void buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseExited

    }//GEN-LAST:event_buttonMouseExited

    private void buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMousePressed

    }//GEN-LAST:event_buttonMousePressed

    private void btnAtrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasMousePressed

    private void button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_button1MouseEntered

    private void button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_button1MouseExited

    private void button1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1MousePressed

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        //NUEVO BOTON ATRAS
        ReportL p1 = new ReportL();
        p1.setSize(750, 430);
        p1.setLocation(0, 0);

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();   // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JPanel body;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JPanel button;
    private javax.swing.JPanel button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listLi;
    // End of variables declaration//GEN-END:variables
}
