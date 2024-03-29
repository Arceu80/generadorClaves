/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorclaves;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Francisco
 */
public class Panel extends javax.swing.JFrame {

    /**
     * Creates new form Panel
     */
    JTable tablaClaves;
    JTable tablaRaideos;
    HashMap<Integer, String> mapaclaves = new HashMap();
    HashMap<Integer, Raideo> mapaRaideo = new HashMap();
    String rutaClaves = "src/datos/claves.txt";
    String rutaRaideos = "src/datos/raideos.txt";

    public Panel() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Generador de Claves v1.6");
        jLAdvertencia.setVisible(false);

        File ficheroClaves = new File(rutaClaves);
        File ficheroRaideos = new File(rutaRaideos);

        if (ficheroClaves.exists()) {
            Object[] etiquetas = new Object[2];
            etiquetas[0] = "ID";
            etiquetas[1] = "CLAVE";
            cargaDatos(rutaClaves, 0);
            tablaClaves = creaTabla(jScrollPane1, etiquetas, 0);
        }
        if (ficheroRaideos.exists()) {
            Object[] etiquetas = new Object[4];
            etiquetas[0] = "ID";
            etiquetas[1] = "TRIBU";
            etiquetas[2] = "NIVEL";
            etiquetas[3] = "FECHA";
            cargaDatos(rutaRaideos, 1);
            tablaRaideos = creaTabla(jScrollRaideos, etiquetas, 1);
        } else {
            DefaultTableModel dtm;
            Object[] etiquetas = new Object[4];
            etiquetas[0] = "ID";
            etiquetas[1] = "TRIBU";
            etiquetas[2] = "NIVEL";
            etiquetas[3] = "FECHA";
            dtm = new DefaultTableModel(etiquetas, 0);
            tablaRaideos = new JTable(dtm);
        }

        tablaClaves.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                DefaultTableModel dtm = (DefaultTableModel) tablaClaves.getModel();
                super.keyReleased(e);

                int id = (int) dtm.getValueAt(tablaClaves.getSelectedRow(), 0);

                jTclavetribu.setText(mapaclaves.get(id));

            }

        });

        tablaClaves.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KeyEvent ke = new KeyEvent(tablaClaves, KeyEvent.KEY_RELEASED, 1, 0, KeyEvent.VK_UNDEFINED, 'a');
                tablaClaves.dispatchEvent(ke);
            }
        });

        tablaRaideos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                DefaultTableModel dtm = (DefaultTableModel) tablaRaideos.getModel();
                super.keyReleased(e);

                int id = (int) dtm.getValueAt(tablaRaideos.getSelectedRow(), 0);

                jTclavetribuRaid.setText(mapaclaves.get(mapaRaideo.get(id).getIdclave()));
                jTtribuRaid.setText(mapaRaideo.get(id).getTribu());
                jTbaseRaid.setText(mapaRaideo.get(id).getBase());;
                String jugadores = "";
                for (String value : mapaRaideo.get(id).getJugadores().values()) {
                    jugadores += value + ", ";
                }
                jTAjugadoresRaid.setText(jugadores.substring(0, jugadores.length() - 2));

            }

        });

        tablaRaideos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KeyEvent ke = new KeyEvent(tablaRaideos, KeyEvent.KEY_RELEASED, 1, 0, KeyEvent.VK_UNDEFINED, 'a');
                tablaRaideos.dispatchEvent(ke);
            }
        });
        
        tablaRaideos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tablaRaideos.getColumnModel().getColumn(1).setPreferredWidth(30);
        tablaRaideos.getColumnModel().getColumn(2).setPreferredWidth(30);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTdigitos = new javax.swing.JTextField();
        jBgenerar = new javax.swing.JButton();
        jTnumeros = new javax.swing.JTextField();
        jTletras = new javax.swing.JTextField();
        jTclave = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jBlimpiar = new javax.swing.JButton();
        jLAdvertencia = new javax.swing.JLabel();
        jBguardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jBborrar = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTtribu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTbase = new javax.swing.JTextField();
        jBguardarDatos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAjugadores = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jTclavetribu = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollRaideos = new javax.swing.JScrollPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTtribuRaid = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTbaseRaid = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTAjugadoresRaid = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jTclavetribuRaid = new javax.swing.JTextField();
        jBborrarRaid = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 255, 204));

        jLabel1.setBackground(new java.awt.Color(182, 243, 2));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Generador de Claves");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Número de Dígitos:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Número de Números:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Número de Letras:");

        jTdigitos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTdigitosKeyReleased(evt);
            }
        });

        jBgenerar.setText("Generar");
        jBgenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBgenerarActionPerformed(evt);
            }
        });

        jTnumeros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTnumerosKeyReleased(evt);
            }
        });

        jTletras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTletrasKeyReleased(evt);
            }
        });

        jTclave.setBackground(java.awt.Color.gray);
        jTclave.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jTclave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTclave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 8)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 102));
        jLabel5.setText("Por Arceu80");

        jBlimpiar.setText("Limpiar");
        jBlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlimpiarActionPerformed(evt);
            }
        });

        jLAdvertencia.setForeground(new java.awt.Color(255, 51, 0));
        jLAdvertencia.setText("El tamaño máximo de la clave es de 10 digitos");

        jBguardar.setText("Guardar Clave");
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jBlimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBgenerar)
                                .addGap(27, 27, 27))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTdigitos, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTnumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTletras, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLAdvertencia))
                                    .addComponent(jTclave, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBguardar)
                        .addGap(126, 126, 126))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTdigitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTnumeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jTclave, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jTletras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLAdvertencia)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBgenerar)
                            .addComponent(jBlimpiar))
                        .addGap(18, 18, 18)
                        .addComponent(jBguardar)
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Generador", jPanel1);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jBborrar.setText("Borrar");
        jBborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBborrarActionPerformed(evt);
            }
        });

        jLabel9.setText("Tribu");

        jLabel10.setText("Base Raideo");

        jBguardarDatos.setText("Guardar");
        jBguardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarDatosActionPerformed(evt);
            }
        });

        jLabel11.setText("Jugadores");

        jTAjugadores.setColumns(20);
        jTAjugadores.setRows(5);
        jScrollPane3.setViewportView(jTAjugadores);

        jLabel6.setText("Clave");

        jTclavetribu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTclavetribu.setForeground(new java.awt.Color(0, 0, 0));
        jTclavetribu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTclavetribu.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addGap(64, 64, 64))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jTclavetribu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTbase, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jTtribu))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jBguardarDatos)
                .addGap(0, 120, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTtribu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTbase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTclavetribu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBguardarDatos)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Tribu", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jBborrar)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBborrar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Almacenamiento", jPanel2);

        jPanel4.setBackground(new java.awt.Color(102, 255, 255));

        jLabel12.setText("Tribu");

        jTtribuRaid.setEnabled(false);

        jLabel13.setText("Base Raideo");

        jTbaseRaid.setEnabled(false);

        jLabel14.setText("Jugadores");

        jTAjugadoresRaid.setColumns(20);
        jTAjugadoresRaid.setRows(5);
        jTAjugadoresRaid.setEnabled(false);
        jScrollPane4.setViewportView(jTAjugadoresRaid);

        jLabel7.setText("Clave");

        jTclavetribuRaid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTclavetribuRaid.setForeground(new java.awt.Color(0, 0, 0));
        jTclavetribuRaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTclavetribuRaid.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)
                                .addGap(64, 64, 64))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel14))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jTclavetribuRaid, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTbaseRaid, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jTtribuRaid))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTtribuRaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTbaseRaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTclavetribuRaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addGap(68, 68, 68))
        );

        jTabbedPane3.addTab("Tribu", jPanel5);

        jBborrarRaid.setText("Borrar");
        jBborrarRaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBborrarRaidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollRaideos, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jBborrarRaid)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollRaideos, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBborrarRaid)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Raideos", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimpiarActionPerformed
        jTdigitos.setText("");
        jTnumeros.setText("");
        jTletras.setText("");
        jTclave.setText("");

        if (!jTletras.isEnabled() || !jTnumeros.isEnabled()) {
            jTletras.setEnabled(true);
            jTnumeros.setEnabled(true);
        }
    }//GEN-LAST:event_jBlimpiarActionPerformed

    private void jBgenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBgenerarActionPerformed

        String resultado = "";
        int digitos, numeros, letras;
        char letra;
        String minuscula;

        try {
            digitos = Integer.parseInt(jTdigitos.getText());
            numeros = Integer.parseInt(jTnumeros.getText());
            letras = Integer.parseInt(jTletras.getText());

            String[] clave = new String[digitos];

            if (numeros == 0) {
                //System.out.print((char)aleatorio(65,90));
                for (int i = 0; i < clave.length; i++) {
                    letra = (char) aleatorio(65, 90);
                    if (aleatorio(0, 1) == 0) {
                        minuscula = String.valueOf(letra);
                        clave[i] = minuscula.toLowerCase();
                    } else {
                        clave[i] = String.valueOf(letra);
                    }

                }
            } else if (letras == 0) {
                for (int i = 0; i < clave.length; i++) {
                    clave[i] = String.valueOf(aleatorio(0, 9));
                }
            } else {

                int[] num = new int[numeros];
                char[] ch = new char[letras];

                for (int i = 0; i < num.length; i++) {
                    num[i] = aleatorio(0, 9);
                }

                for (int i = 0; i < ch.length; i++) {
                    ch[i] = (char) aleatorio(65, 90);
                }

                ArrayList<String> inter = new ArrayList();

                for (int i = 0; i < num.length; i++) {
                    inter.add(String.valueOf(num[i]));
                }

                for (int i = 0; i < ch.length; i++) {

                    if (aleatorio(0, 1) == 0) {
                        inter.add(String.valueOf(ch[i]));
                    } else {
                        inter.add(String.valueOf(ch[i]).toLowerCase());
                    }

                }

                Collections.shuffle(inter);

                for (int i = 0; i < inter.size(); i++) {
                    clave[i] = inter.get(i);
                }

                /*
                for (int i = 0; i < clave.length; i++) {
                    if (aleatorio(0, 1) == 0) {
                        letra = (char) aleatorio(65, 90);
                        if (aleatorio(0, 1) == 0) {
                            minuscula = String.valueOf(letra);
                            clave[i] = minuscula.toLowerCase();
                        } else {
                            clave[i] = String.valueOf(letra);
                        }
                    } else {
                        clave[i] = String.valueOf(aleatorio(0, 9));
                    }

                }*/
            }

            //jTclave.setText(digitos + ", " + numeros + ", " + letras);
            for (int i = 0; i < clave.length; i++) {
                resultado += clave[i];
            }
            jTclave.setText(resultado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error, el valor introducido no es un numero", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jBgenerarActionPerformed

    private void jTnumerosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTnumerosKeyReleased
        if (!jTnumeros.getText().equalsIgnoreCase("")) {
            if (Integer.parseInt(jTnumeros.getText()) == 0) {
                jTletras.setEnabled(false);
                jTletras.setText(jTdigitos.getText());
            } else if (Integer.parseInt(jTnumeros.getText()) > 0) {
                jTletras.setText(String.valueOf(Integer.parseInt(jTdigitos.getText()) - Integer.parseInt(jTnumeros.getText())));
            } else {
                jTletras.setEnabled(true);
            }
        } else {
            jTletras.setText("");
            jTletras.setEnabled(true);
        }

    }//GEN-LAST:event_jTnumerosKeyReleased

    private void jTletrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTletrasKeyReleased
        if (!jTletras.getText().equalsIgnoreCase("")) {
            if (Integer.parseInt(jTletras.getText()) == 0) {
                jTnumeros.setEnabled(false);
                jTnumeros.setText(jTdigitos.getText());
            } else if (Integer.parseInt(jTletras.getText()) > 0) {
                jTnumeros.setText(String.valueOf(Integer.parseInt(jTdigitos.getText()) - Integer.parseInt(jTletras.getText())));
            } else {
                jTnumeros.setEnabled(true);
            }
        } else {
            jTnumeros.setText("");
            jTnumeros.setEnabled(true);
        }

    }//GEN-LAST:event_jTletrasKeyReleased

    private void jTdigitosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdigitosKeyReleased
        if (!jTdigitos.getText().equalsIgnoreCase("")) {
            if (Integer.parseInt(jTdigitos.getText()) > 10) {
                jLAdvertencia.setVisible(true);
                jBgenerar.setEnabled(false);
            } else {
                jLAdvertencia.setVisible(false);
                jBgenerar.setEnabled(true);
            }
        }

    }//GEN-LAST:event_jTdigitosKeyReleased

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        Object[] etiquetas = new Object[2];
        DefaultTableModel dtm = (DefaultTableModel) tablaClaves.getModel();
        if (!jTclave.getText().equalsIgnoreCase("")) {
            if (mapaclaves.isEmpty()) {
                etiquetas[0] = 1;
                etiquetas[1] = jTclave.getText();
                mapaclaves.put(1, jTclave.getText());
            } else {
                if (mapaclaves.containsValue(jTclave.getText())) {
                    JOptionPane.showMessageDialog(this, "Clave ya existente/guardada, genere otra", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    etiquetas[0] = mapaclaves.size() + 1;
                    etiquetas[1] = jTclave.getText();
                    dtm.addRow(etiquetas);
                    mapaclaves.put(mapaclaves.size() + 1, jTclave.getText());
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay ninguna clave que guardar", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBguardarActionPerformed

    private void jBborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBborrarActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tablaClaves.getModel();
        if (tablaClaves.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "No hay ninguna fila seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = (int) dtm.getValueAt(tablaClaves.getSelectedRow(), 0);
            dtm.removeRow(tablaClaves.getSelectedRow());
            mapaclaves.remove(id);
            
            HashMap<Integer, String> mapaclaves2 = new HashMap();
            
            for (Map.Entry<Integer, String> entry : mapaclaves.entrySet()) {
                Integer key = entry.getKey();
                String val = entry.getValue();
                
                mapaclaves2.put(mapaclaves2.size()+1, val);
                
                for (Map.Entry<Integer, Raideo> entry1 : mapaRaideo.entrySet()) {
                    Integer key1 = entry1.getKey();
                    Raideo val1 = entry1.getValue();
                    
                    if(val1.getIdclave()==key){
                        val1.setIdclave(mapaclaves2.size());
                    }
                    else if(val1.getIdclave()==id){
                        mapaRaideo.remove(key1);
                    }
                    
                }
                
            }
            
            if(mapaclaves.isEmpty()){
                mapaRaideo.clear();
            }
            
            mapaclaves.clear();
            mapaclaves.putAll(mapaclaves2);
            
            JOptionPane.showMessageDialog(this, "Fila borrada correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jBborrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        guardaFichero(rutaClaves, 0);
        guardaFichero(rutaRaideos, 1);
    }//GEN-LAST:event_formWindowClosing

    private void jBguardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarDatosActionPerformed
        if (!jTtribu.getText().equalsIgnoreCase("") && !jTbase.getText().equalsIgnoreCase("") && !jTAjugadores.getText().equalsIgnoreCase("") /*&& jTclavetribu.getText().equalsIgnoreCase("")*/) {
            DefaultTableModel dtm = (DefaultTableModel) tablaClaves.getModel();
            int idclave = (int) dtm.getValueAt(tablaClaves.getSelectedRow(), 0);
            String tribu = jTtribu.getText();
            String base = jTbase.getText();
            SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            Date dateObj = calendar.getTime();
            String formattedDate = dtf.format(dateObj);

            Raideo raid = new Raideo(idclave, formattedDate, base, tribu);
            String[] jugadores = jTAjugadores.getText().split(",");

            for (String jugadore : jugadores) {
                raid.anyadirjugador(jugadore);
            }

            if(mapaRaideo.isEmpty()){
                mapaRaideo.put(1, raid);
            }else{
                mapaRaideo.put(mapaRaideo.size() + 1, raid);
            }

            DefaultTableModel dtm2 = (DefaultTableModel) tablaRaideos.getModel();
            tablaRaideos = new JTable(dtm2);

            Object[] etiquetas = new Object[4];
            etiquetas[0] = mapaRaideo.size();
            etiquetas[1] = raid.getTribu();
            etiquetas[2] = raid.getBase();
            etiquetas[3] = raid.getFecha();
            dtm2.addRow(etiquetas);

            tablaRaideos.setModel(dtm2);

            JOptionPane.showMessageDialog(this, "Datos Insertados Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Faltan Datos en alguno de los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBguardarDatosActionPerformed

    private void jBborrarRaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBborrarRaidActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tablaRaideos.getModel();
        if (tablaRaideos.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "No hay ninguna fila seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = (int) dtm.getValueAt(tablaRaideos.getSelectedRow(), 0);
            dtm.removeRow(tablaRaideos.getSelectedRow());
            jTclavetribuRaid.setText("");
            jTtribuRaid.setText("");
            jTbaseRaid.setText("");
            jTAjugadoresRaid.setText("");
            mapaRaideo.remove(id);

            JOptionPane.showMessageDialog(this, "Fila borrada correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBborrarRaidActionPerformed

    public int aleatorio(int min, int max) {
        double alea;
        int alea2;

        alea = Math.random();

        alea *= max - min + 1;

        alea += min;

        alea = Math.floor(alea);

        alea2 = (int) alea;

        return alea2;
    }

    public JTable creaTabla(JScrollPane jScrol_Tabla, Object[] etiquetas, int num) {

        DefaultTableModel dtm;
        JTable tabla = null;

        //4.- Procesar el resultado de la consulta.......
        //4.1.- crear el array de la etiquetas....
        //Creamos el modelo de la tabla........................
        dtm = new DefaultTableModel(etiquetas, 0);
        //Creamos la tabla con el modelo........................
        tabla = new JTable(dtm);
        // Procesar las filas de la consulta y cargarlas en el modelo
        /* while (rset.next()) {
        for (int i = 0; i < rsetMd.getColumnCount(); i++) {
        Object obj = rset.getObject(i + 1);
        if (i == 4 || i == 5)//{
        //  if((Integer)obj==0)
        {
        etiquetas[i] = new Boolean((Boolean) obj);
        }    else
        etiquetas[i]=new Boolean(true);
        } else {
        etiquetas[i] = rset.getObject(i + 1);
        }
        }
        dtm.addRow(etiquetas);
        }*/

 /*int cnt = 1;
        for (String value : mapaclaves.values()) {

            etiquetas[0] = cnt;
            etiquetas[1] = value;
            cnt++;
            dtm.addRow(etiquetas);
        }*/
        if (num == 0) {
            for (Map.Entry<Integer, String> entry : mapaclaves.entrySet()) {
                etiquetas[0] = entry.getKey();
                etiquetas[1] = entry.getValue();
                dtm.addRow(etiquetas);

            }
        } else if (num == 1) {
            for (Map.Entry<Integer, Raideo> entry : mapaRaideo.entrySet()) {
                etiquetas[0] = entry.getKey();
                etiquetas[1] = entry.getValue().getTribu();
                etiquetas[2] = entry.getValue().getBase();
                etiquetas[3] = entry.getValue().getFecha();
                dtm.addRow(etiquetas);
            }
        }

        // Cambiar el CellRenderer......................
        //TableColumn estreno = tabla.getColumnModel().getColumn(4);
        //estreno.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
        //TableColumn publico = tabla.getColumnModel().getColumn(5);
        //publico.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
        //publico.setCellRenderer(new DefaultCellRenderer(Boolean.class));
        // Cambiar el CellEditor generos......................
        //TableColumn genero = tabla.getColumnModel().getColumn(3);
        //genero.setCellEditor(new DefaultCellEditor(generos));
        // Ordenar la tabla......................
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter(dtm);
        tabla.setRowSorter(elQueOrdena);
        jScrol_Tabla.setViewportView(tabla);

        return tabla;

    }

    void cargaDatos(String ruta, int num) {

        BufferedReader bf = null;

        try {

            bf = new BufferedReader(new FileReader(new File(ruta)));

            String linea, clave, fecha, base, tribu;
            String[] datos, jugadores, jugador;
            int id, idclave;

            if (num == 0) {
                while ((linea = bf.readLine()) != null) {
                    datos = linea.split(";");
                    id = Integer.parseInt(datos[0]);
                    clave = datos[1];

                    mapaclaves.put(id, clave);
                }
            } else if (num == 1) {
                while ((linea = bf.readLine()) != null) {
                    datos = linea.split(";");
                    id = Integer.parseInt(datos[0]);
                    idclave =Integer.parseInt(datos[1]);
                    fecha = datos[2];
                    base = datos[3];
                    tribu = datos[4];
                    jugadores = datos[5].split("-");

                    Raideo raid = new Raideo(idclave, fecha, tribu, base);

                    for (int i = 0; i < jugadores.length; i++) {
                        jugador = jugadores[i].split(":");
                        raid.anyadirjugador(jugador[1]);
                    }
                    mapaRaideo.put(id, raid);
                    System.out.println(raid);
                }
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error cargando los actores\n\tFichero no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado cargando los actores\n\t" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                bf.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error inesperado cargando los actores\n\t" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void guardaFichero(String ruta, int num) {
        File file = new File(ruta);
        PrintWriter fichero;
        String listado = "";
        String jugadores = "";

        if (num == 0) {
            for (Map.Entry<Integer, String> entry : mapaclaves.entrySet()) {
                Integer key = entry.getKey();
                String val = entry.getValue();

                listado += String.valueOf(key) + ";" + val + "\n";

            }
        } else if (num == 1) {
            for (Map.Entry<Integer, Raideo> entry : mapaRaideo.entrySet()) {
                Integer key = entry.getKey();
                Raideo val = entry.getValue();
                //key;idClave;fecha;tribu;base;keyJugador:Jugador-keyJugador2-Jugador2      
                listado += String.valueOf(key) + ";" + val.getIdclave() + ";" + val.getFecha() + ";" + val.getTribu() + ";" + val.getBase() + ";";
                jugadores = "";
                for (Map.Entry<Integer, String> entry1 : val.getJugadores().entrySet()) {
                    Integer key1 = entry1.getKey();
                    String val1 = entry1.getValue();

                    jugadores += String.valueOf(key1) + ":" + val1.trim() + "-";

                }

                listado += jugadores.substring(0, jugadores.length() - 1) + "\n";

            }
        }

        try {
            fichero = new PrintWriter(new FileWriter(ruta));

            fichero.print(listado);

            fichero.close();
        } catch (IOException ex) {
            System.out.println("Error de E/S escribiendo en el fichero ...");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBborrar;
    private javax.swing.JButton jBborrarRaid;
    private javax.swing.JButton jBgenerar;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBguardarDatos;
    private javax.swing.JButton jBlimpiar;
    private javax.swing.JLabel jLAdvertencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollRaideos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTAjugadores;
    private javax.swing.JTextArea jTAjugadoresRaid;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTbase;
    private javax.swing.JTextField jTbaseRaid;
    private javax.swing.JTextField jTclave;
    private javax.swing.JTextField jTclavetribu;
    private javax.swing.JTextField jTclavetribuRaid;
    private javax.swing.JTextField jTdigitos;
    private javax.swing.JTextField jTletras;
    private javax.swing.JTextField jTnumeros;
    private javax.swing.JTextField jTtribu;
    private javax.swing.JTextField jTtribuRaid;
    // End of variables declaration//GEN-END:variables
}
