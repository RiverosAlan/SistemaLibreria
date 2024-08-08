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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author HP 245 G4
 */
public class Reporte_Prestamos extends javax.swing.JPanel {

    JavaMySql conn;
    Connection reg;

    /**
     * Creates new form Reporte_Prestamos
     */
    //CONSTRUCTOR 1 COMBINACION DE UNO//
    public Reporte_Prestamos(String fechaA, String fechaB, String carreraU, String estadoU) throws SQLException {

        initComponents();
        conn = new JavaMySql();
        reg = conn.conexion();

        if (fechaA != null && fechaB != null) {
            int cont = 0;
            String A = fechaA;
            String B = fechaB;
            String auxA = A;
            String auxB = B;

            Statement stm = reg.createStatement();

            auxB = NextFecha(auxB);
            int count = 0;
            do {

                ResultSet r = stm.executeQuery("SELECT * FROM `prestamo` WHERE `fechaPr`='" + auxA + "'");

                while (r.next()) {
                    if (r.getString("estado").equals(estadoU)) {
                        if (carreraU.equals("Todas las Carreras")) {
                            count++;
                        } else {
                            if (deCarreraM(r.getString("CodUsuario")).equals(carreraU)) {
                                count++;
                            }
                        }
                    }
                }
                auxA = NextFecha(auxA);
            } while (!auxA.equals(auxB));

            B = NextFecha(B);
            String list[][] = new String[count][7];
            int i = 0;
            if (count > 0) {
                do {

                    ResultSet r = stm.executeQuery("SELECT * FROM `prestamo` WHERE `fechaPr`='" + A + "'");

                    while (r.next()) {

                        if (r.getString("estado").equals(estadoU)) {
                            if (carreraU.equals("Todas las Carreras")) {
                                /*primera columna cod de prestamo*/
                                list[i][0] = r.getString("idPrestamo");
                                /*----------------------------------------*/
 /*segunda columna carnet de usuario*/
                                list[i][1] = deCIM(r.getString("CodUsuario"));
                                /*----------------------------------------*/
 /*tercera columna titulo de libro*/
                                list[i][2] = deTituloLC(r.getString("CodLibro"));
                                /*----------------------------------------*/
 /*Cuarta columna categoria de libro*/
                                list[i][3] = deCategoriaLC(r.getString("CodLibro"));
                                /*----------------------------------------*/
 /*quinta columna carrera de Usuario*/
                                list[i][4] = deCarreraM(r.getString("CodUsuario"));
                                /*----------------------------------------*/
 /*sexta columna fecha de prestamo*/
                                list[i][5] = r.getString("fechaPr");
                                /*----------------------------------------*/
 /*septima columna Estado de usuario*/
                                list[i][6] = deEstado(r.getString("idPrestamo"));
                                i++;
                            } else {
                                if (deCarreraM(r.getString("CodUsuario")).equals(carreraU)) {

                                    /*primera columna cod de prestamo*/
                                    list[i][0] = r.getString("idPrestamo");
                                    /*----------------------------------------*/
 /*segunda columna carnet de usuario*/
                                    list[i][1] = deCIM(r.getString("CodUsuario"));
                                    /*----------------------------------------*/
 /*tercera columna titulo de libro*/
                                    list[i][2] = deTituloLC(r.getString("CodLibro"));
                                    /*----------------------------------------*/
 /*Cuarta columna categoria de libro*/
                                    list[i][3] = deCategoriaLC(r.getString("CodLibro"));
                                    /*----------------------------------------*/
 /*quinta columna carrera de Usuario*/
                                    list[i][4] = deCarreraM(r.getString("CodUsuario"));
                                    /*----------------------------------------*/
 /*sexta columna fecha de prestamo*/
                                    list[i][5] = r.getString("fechaPr");
                                    /*----------------------------------------*/
 /*septima columna Estado de usuario*/
                                    list[i][6] = deEstado(r.getString("idPrestamo"));
                                    i++;
                                }

                            }
                        }

                    }
                    A = NextFecha(A);

                } while (!A.equals(B));

            } else {
                JOptionPane.showMessageDialog(null, "NO HAY REGISTROS");
            }

            listT.setModel(new javax.swing.table.DefaultTableModel(
                    list,
                    new String[]{
                        "COD DE PRESTAMO", "CEDULA DE IDENTIDAD", "TITULO DE LIBRO", "CATEGORIA", "CARRERA", "FECHA DE PRESTAMO", "OBSERVACION"
                    }));

        }

    }
//-----------------------------------------------------------------------------------------
    //CONSTRUCTOR DOS COBINACION DE DOS//

    public Reporte_Prestamos(String fechaA, String fechaB, String carreraU, String E1, String E2) throws SQLException {

        initComponents();
        conn = new JavaMySql();
        reg = conn.conexion();

        if (fechaA != null && fechaB != null) {
            int cont = 0;
            String A = fechaA;
            String B = fechaB;
            String auxA = A;
            String auxB = B;

            Statement stm = reg.createStatement();
            auxB = NextFecha(auxB);
            int count = 0;
            do {
                ResultSet r = stm.executeQuery("SELECT * FROM `prestamo` WHERE `fechaPr`='" + auxA + "'");
                while (r.next()) {
                    if (r.getString("estado").equals(E1) || r.getString("estado").equals(E2)) {
                        if (carreraU.equals("Todas las Carreras")) {
                            count++;
                        } else {
                            if (deCarreraM(r.getString("CodUsuario")).equals(carreraU)) {
                                count++;
                            }
                        }
                    }
                }
                auxA = NextFecha(auxA);
            } while (!auxA.equals(auxB));
            B = NextFecha(B);
            String list[][] = new String[count][7];
            int i = 0;
            if (count > 0) {
                do {
                    ResultSet r = stm.executeQuery("SELECT * FROM `prestamo` WHERE `fechaPr`='" + A + "'");
                    while (r.next()) {
                        if (r.getString("estado").equals(E1) || r.getString("estado").equals(E2)) {
                            if (carreraU.equals("Todas las Carreras")) {
                                /*primera columna cod de prestamo*/
                                list[i][0] = r.getString("idPrestamo");
                                /*----------------------------------------*/
 /*segunda columna carnet de usuario*/
                                list[i][1] = deCIM(r.getString("CodUsuario"));
                                /*----------------------------------------*/
 /*tercera columna titulo de libro*/
                                list[i][2] = deTituloLC(r.getString("CodLibro"));
                                /*----------------------------------------*/
 /*Cuarta columna categoria de libro*/
                                list[i][3] = deCategoriaLC(r.getString("CodLibro"));
                                /*----------------------------------------*/
 /*quinta columna carrera de Usuario*/
                                list[i][4] = deCarreraM(r.getString("CodUsuario"));
                                /*----------------------------------------*/
 /*sexta columna fecha de prestamo*/
                                list[i][5] = r.getString("fechaPr");
                                /*----------------------------------------*/
 /*septima columna Estado de usuario*/
                                list[i][6] = deEstado(r.getString("idPrestamo"));
                                i++;
                            } else {
                                if (deCarreraM(r.getString("CodUsuario")).equals(carreraU)) {

                                    /*primera columna cod de prestamo*/
                                    list[i][0] = r.getString("idPrestamo");
                                    /*----------------------------------------*/
 /*segunda columna carnet de usuario*/
                                    list[i][1] = deCIM(r.getString("CodUsuario"));
                                    /*----------------------------------------*/
 /*tercera columna titulo de libro*/
                                    list[i][2] = deTituloLC(r.getString("CodLibro"));
                                    /*----------------------------------------*/
 /*Cuarta columna categoria de libro*/
                                    list[i][3] = deCategoriaLC(r.getString("CodLibro"));
                                    /*----------------------------------------*/
 /*quinta columna carrera de Usuario*/
                                    list[i][4] = deCarreraM(r.getString("CodUsuario"));
                                    /*----------------------------------------*/
 /*sexta columna fecha de prestamo*/
                                    list[i][5] = r.getString("fechaPr");
                                    /*----------------------------------------*/
 /*septima columna Estado de usuario*/
                                    list[i][6] = deEstado(r.getString("idPrestamo"));
                                    i++;
                                }

                            }

                        }
                    }
                    A = NextFecha(A);

                } while (!A.equals(B));
            } else {
                JOptionPane.showMessageDialog(null, "NO HAY REGISTROS");

            }
            listT.setModel(new javax.swing.table.DefaultTableModel(
                    list,
                    new String[]{
                        "COD DE PRESTAMO", "CEDULA DE IDENTIDAD", "TITULO DE LIBRO", "CATEGORIA", "CARRERA", "FECHA DE PRESTAMO", "OBSERVACION"
                    }));

        }
    }

//-----------------------------------------------------------------------------------------
    //CONSTRUCTOR TRES COBINACION DE TRES//
    public Reporte_Prestamos(String fechaA, String fechaB, String carreraU, String E1, String E2, String E3) throws SQLException {

        initComponents();
        conn = new JavaMySql();
        reg = conn.conexion();

        if (fechaA != null && fechaB != null) {
            int cont = 0;
            String A = fechaA;
            String B = fechaB;
            String auxA = A;
            String auxB = B;

            Statement stm = reg.createStatement();
            auxB = NextFecha(auxB);
            int count = 0;
            do {
                ResultSet r = stm.executeQuery("SELECT * FROM `prestamo` WHERE `fechaPr`='" + auxA + "'");
                while (r.next()) {
                    if (r.getString("estado").equals(E1) || r.getString("estado").equals(E2) || r.getString("estado").equals(E3)) {
                        if (carreraU.equals("Todas las Carreras")) {
                            count++;
                        } else {
                            if (deCarreraM(r.getString("CodUsuario")).equals(carreraU)) {
                                count++;
                            }
                        }
                    }
                }
                auxA = NextFecha(auxA);
            } while (!auxA.equals(auxB));
            B = NextFecha(B);
            String list[][] = new String[count][7];
            int i = 0;
            if (count > 0) {
                do {
                    ResultSet r = stm.executeQuery("SELECT * FROM `prestamo` WHERE `fechaPr`='" + A + "'");
                    while (r.next()) {
                        if (r.getString("estado").equals(E1) || r.getString("estado").equals(E2) || r.getString("estado").equals(E3)) {
                            if (carreraU.equals("Todas las Carreras")) {
                                /*primera columna cod de prestamo*/
                                list[i][0] = r.getString("idPrestamo");
                                /*----------------------------------------*/
 /*segunda columna carnet de usuario*/
                                list[i][1] = deCIM(r.getString("CodUsuario"));
                                /*----------------------------------------*/
 /*tercera columna titulo de libro*/
                                list[i][2] = deTituloLC(r.getString("CodLibro"));
                                /*----------------------------------------*/
 /*Cuarta columna categoria de libro*/
                                list[i][3] = deCategoriaLC(r.getString("CodLibro"));
                                /*----------------------------------------*/
 /*quinta columna carrera de Usuario*/
                                list[i][4] = deCarreraM(r.getString("CodUsuario"));
                                /*----------------------------------------*/
 /*sexta columna fecha de prestamo*/
                                list[i][5] = r.getString("fechaPr");
                                /*----------------------------------------*/
 /*septima columna Estado de usuario*/
                                list[i][6] = deEstado(r.getString("idPrestamo"));
                                i++;
                            } else {
                                if (deCarreraM(r.getString("CodUsuario")).equals(carreraU)) {

                                    /*primera columna cod de prestamo*/
                                    list[i][0] = r.getString("idPrestamo");
                                    /*----------------------------------------*/
 /*segunda columna carnet de usuario*/
                                    list[i][1] = deCIM(r.getString("CodUsuario"));
                                    /*----------------------------------------*/
 /*tercera columna titulo de libro*/
                                    list[i][2] = deTituloLC(r.getString("CodLibro"));
                                    /*----------------------------------------*/
 /*Cuarta columna categoria de libro*/
                                    list[i][3] = deCategoriaLC(r.getString("CodLibro"));
                                    /*----------------------------------------*/
 /*quinta columna carrera de Usuario*/
                                    list[i][4] = deCarreraM(r.getString("CodUsuario"));
                                    /*----------------------------------------*/
 /*sexta columna fecha de prestamo*/
                                    list[i][5] = r.getString("fechaPr");
                                    /*----------------------------------------*/
 /*septima columna Estado de usuario*/
                                    list[i][6] = deEstado(r.getString("idPrestamo"));
                                    i++;
                                }

                            }

                        }
                    }
                    A = NextFecha(A);

                } while (!A.equals(B));
            } else {
                JOptionPane.showMessageDialog(null, "NO HAY REGISTROS");

            }
            listT.setModel(new javax.swing.table.DefaultTableModel(
                    list,
                    new String[]{
                        "COD DE PRESTAMO", "CEDULA DE IDENTIDAD", "TITULO DE LIBRO", "CATEGORIA", "CARRERA", "FECHA DE PRESTAMO", "OBSERVACION"
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
        listT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAtras = new javax.swing.JPanel();
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

        listT.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        listT.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 10)); // NOI18N
        listT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD DE PRESTAMO", "CEDULA DE IDENTIDAD", "TITULO DE LIBRO", "CATEGORIA", "CARRERA", "FECHA DE PRESTAMO", "OBSERVACION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        listT.setRowHeight(20);
        jScrollPane1.setViewportView(listT);
        if (listT.getColumnModel().getColumnCount() > 0) {
            listT.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 740, 270));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jLabel2.setText("PRESTAMOS REALIZADOS POR FECHA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 290, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 290, 10));

        btnAtras.setBackground(new java.awt.Color(51, 73, 84));
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtrasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAtrasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAtrasMousePressed(evt);
            }
        });
        btnAtras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        atras.setForeground(new java.awt.Color(255, 255, 255));
        atras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        atras.setText("Atras");
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                atrasMousePressed(evt);
            }
        });
        btnAtras.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));

        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 170, 40));

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

    /*buscando deudor*/
    private String deEstado(String n) throws SQLException {
        boolean sw = false;
        String estado = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT `estado` FROM `prestamo` WHERE `idPrestamo` = '" + n + "'");
        while (re.next()) {
            estado = re.getString("estado");
        }

        return estado;
    }

    /*buscador de nombre*/
    private String deCI(String n) throws SQLException {
        String nci = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT `matricula` FROM `usuario` WHERE `matricula` = '" + n + "'");
        while (re.next()) {
            nci = re.getString("matricula");
        }

        return nci;
    }

    private String deCIM(String n) throws SQLException {
        String nci = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT `matricula` FROM `usuario` WHERE `matricula` = '" + n + "'");
        while (re.next()) {
            nci = re.getString("matricula");
        }

        return nci;
    }

    /*-------------------------------------------------*/

 /*buscador de paterno*/
    private String dePaterno(String n) throws SQLException {
        String pat = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT apP FROM `usuario` WHERE `apP` = '" + n + "'");
        while (re.next()) {
            pat = re.getString("apP");
        }

        return pat;
    }

    private String dePaternoM(String n) throws SQLException {
        String pat = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT apP FROM `usuario` WHERE `matricula` = '" + n + "'");
        while (re.next()) {
            pat = re.getString("apP");
        }

        return pat;
    }

    /*-------------------------------------------------*/

 /*buscador de materno*/
    private String deMaterno(String n) throws SQLException {
        String mat = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT apM FROM `usuario` WHERE `apM` = '" + n + "'");
        while (re.next()) {
            mat = re.getString("apM");
        }

        return mat;
    }

    private String deMaternoM(String n) throws SQLException {
        String mat = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT apM FROM `usuario` WHERE `matricula` = '" + n + "'");
        while (re.next()) {
            mat = re.getString("apM");
        }

        return mat;
    }

    /*-------------------------------------------------*/
 /*buscar carrera*/
    private String deCarrera(String n) throws SQLException {
        String car = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT carrera FROM `usuario` WHERE `carrera` = '" + n + "'");
        while (re.next()) {
            car = re.getString("carrera");
        }

        return car;
    }

    private String deCarreraM(String n) throws SQLException {
        String car = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT carrera FROM `usuario` WHERE `matricula` = '" + n + "'");
        while (re.next()) {
            car = re.getString("carrera");
        }

        return car;
    }

    /*-------------------------------------------------*/
 /*buscar titulo de libro*/
    private String deTituloL(String n) throws SQLException {
        String tit = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT titulo FROM `libro` WHERE `titulo` = '" + n + "'");
        while (re.next()) {
            tit = re.getString("titulo");
        }

        return tit;
    }

    private String deTituloLC(String n) throws SQLException {
        String tit = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT titulo FROM `libro` WHERE `idlibro` = '" + n + "'");
        while (re.next()) {
            tit = re.getString("titulo");
        }

        return tit;
    }

    /*-------------------------------------------------*/
 /*buscar categoria de libro*/
    private String deCategoriaL(String n) throws SQLException {
        String catl = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT categoria FROM `libro` WHERE `categoria` = '" + n + "'");
        while (re.next()) {
            catl = re.getString("categoria");
        }

        return catl;
    }

    private String deCategoriaLC(String n) throws SQLException {
        String catl = "";
        Statement stm = reg.createStatement();
        ResultSet re = stm.executeQuery("SELECT categoria FROM `libro` WHERE `idlibro` = '" + n + "'");
        while (re.next()) {
            catl = re.getString("categoria");
        }

        return catl;
    }

    private String NextFecha(String f) {

        //System.out.println(f);
        String dia = f.substring(0, 2);

        int d = Integer.parseInt(dia);

        String mes = f.substring(3, 5);


        int m = Integer.parseInt(mes);
        /*JOptionPane.showMessageDialog(null," "+mes);*/

        String year = f.substring(6, 10);

        int y = Integer.parseInt(year);
        /*JOptionPane.showMessageDialog(null," "+year);*/

        String Nenfecha = "";

        switch (mes) {
            case "01":
                if (d < 31) {

                    d = d + 1;
                    if (d < 10) {
                        Nenfecha = "0" + d + "/" + mes + "/" + year;
                    } else {
                        Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                    }

                } else {
                    Nenfecha = "01/02/" + year;
                }
                break;
            case "02":

                if (bisiesto2(y)) {
                    if (d < 29) {
                        d = d + 1;
                        if (d < 10) {
                            Nenfecha = "0" + d + "/" + mes + "/" + year;
                        } else {
                            Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                        }
                    } else {
                        Nenfecha = "01/03/" + year;
                    }
                } else {
                    if (d < 28) {
                        d = d + 1;
                        if (d < 10) {
                            Nenfecha = "0" + d + "/" + mes + "/" + year;
                        } else {
                            Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                        }
                    } else {
                        Nenfecha = "01/03/" + year;
                    }
                }
                break;
            case "03":
                if (d < 31) {
                    d = d + 1;

                    if (d < 10) {
                        Nenfecha = "0" + d + "/" + mes + "/" + year;
                    } else {
                        Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                    }
                } else {
                    Nenfecha = "01/04/" + year;
                }
                break;
            case "04":
                if (d < 30) {
                    d = d + 1;
                    if (d < 10) {
                        Nenfecha = "0" + d + "/" + mes + "/" + year;
                    } else {
                        Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                    }
                } else {
                    Nenfecha = "01/05/" + year;
                }
                break;
            case "05":
                if (d < 31) {
                    d = d + 1;

                    if (d < 10) {
                        Nenfecha = "0" + d + "/" + mes + "/" + year;
                    } else {
                        Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                    }
                } else {
                    Nenfecha = "01/06/" + year;
                }
                break;
            case "06":
                if (d < 30) {
                    d = d + 1;
                    if (d < 10) {
                        Nenfecha = "0" + d + "/" + mes + "/" + year;
                    } else {
                        Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                    }
                } else {
                    Nenfecha = "01/07/" + year;
                }
                break;
            case "07":
                if (d < 31) {
                    d = d + 1;
                    if (d < 10) {
                        Nenfecha = "0" + d + "/" + mes + "/" + year;
                    } else {
                        Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                    }
                } else {
                    Nenfecha = "01/08/" + year;
                }
                break;
            case "08":
                if (d < 31) {
                    d = d + 1;
                    if (d < 10) {
                        Nenfecha = "0" + d + "/" + mes + "/" + year;
                    } else {
                        Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                    }
                } else {
                    Nenfecha = "01/09/" + year;
                }
                break;
            case "09":
                if (d < 30) {
                    d = d + 1;
                    if (d < 10) {
                        Nenfecha = "0" + d + "/" + mes + "/" + year;
                    } else {
                        Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                    }
                } else {
                    Nenfecha = "01/10/" + year;
                }
                break;
            case "10":
                if (d < 31) {
                    d = d + 1;
                    if (d < 10) {
                        Nenfecha = "0" + d + "/" + mes + "/" + year;
                    } else {
                        Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                    }
                } else {
                    Nenfecha = "01/11/" + year;
                }
                break;
            case "11":
                if (d < 30) {
                    d = d + 1;
                    if (d < 10) {
                        Nenfecha = "0" + d + "/" + mes + "/" + year;
                    } else {
                        Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                    }
                } else {
                    Nenfecha = "01/12/" + year;
                }
                break;
            case "12":
                if (d < 31) {
                    d++;
                    if (d < 10) {
                        Nenfecha = "0" + d + "/" + mes + "/" + year;
                    } else {
                        Nenfecha = Integer.toString(d) + "/" + mes + "/" + year;
                    }
                } else {
                    y++;
                    Nenfecha = "01/01/" + Integer.toString(y);
                }

                break;

        }

        return Nenfecha;
    }

    public boolean bisiesto2(int ano) {

        if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private String DevFecha(Date f) {
        char af, bf, c, d, e, g;
        SimpleDateFormat fc = new SimpleDateFormat();
        String fec = fc.format(f);

        af = fec.charAt(0);
        String dia1 = Character.toString(af);
        bf = fec.charAt(1);
        String dia2 = Character.toString(bf);

        c = fec.charAt(3);
        String m1 = Character.toString(c);
        d = fec.charAt(4);
        String m2 = Character.toString(d);

        e = fec.charAt(6);
        String y1 = Character.toString(e);
        g = fec.charAt(7);
        String y2 = Character.toString(g);

        String nfecha = dia1 + dia2 + "/" + m1 + m2 + "/20" + y1 + y2;

        return nfecha;

    }
    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        ArrayList<listaPrestamo> lista = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "cantidad: " + listT.getRowCount());
        for (int i = 0; i < listT.getRowCount(); i++) {
            listaPrestamo listP = new listaPrestamo(listT.getValueAt(i, 0).toString(), listT.getValueAt(i, 1).toString(), listT.getValueAt(i, 2).toString(), listT.getValueAt(i, 3).toString(), listT.getValueAt(i, 4).toString(), listT.getValueAt(i, 5).toString(), listT.getValueAt(i, 6).toString());          
            lista.add(listP);
        }

        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(Reporte_Prestamos.class.getResource("/Ventanas/report1.jasper"));
           
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));

            JasperViewer viewer = new JasperViewer(imprimir, false);
            viewer.show();

        } catch (JRException ex) {
            System.out.println(ex.getMessage());

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

    private void btnAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasMouseEntered

    private void btnAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasMouseExited

    private void btnAtrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasMousePressed

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        // Abrir sección
        ReportesG p1 = new ReportesG();
        p1.setSize(750, 430);
        p1.setLocation(0, 0);

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        Reports p1 = new Reports();
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
    private javax.swing.JPanel btnAtras;
    private javax.swing.JPanel button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listT;
    // End of variables declaration//GEN-END:variables
}
