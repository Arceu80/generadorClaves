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
import java.util.ArrayList;
import java.util.Collections;
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
    TreeMap<Integer, String> mapaclaves = new TreeMap();
    HashMap<Integer, Raideo> mapaRaideo = new HashMap();
    String ruta = "src/datos/claves.txt";

    public Panel() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Generador de Claves v1.6");
        jLAdvertencia.setVisible(false);

        File fichero = new File("src/datos/claves.txt");

        if (fichero.exists()) {
            cargaDatos(ruta);
            tablaClaves = creaTabla(jScrollPane1);
        }

        tablaClaves.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                DefaultTableModel dtm = (DefaultTableModel) tablaClaves.getModel();
                super.keyReleased(e);
                
                cargarDatosRaideos((int) dtm.getValueAt(tablaClaves.getSelectedRow(), 0));
                
            }

        });

        tablaClaves.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KeyEvent ke = new KeyEvent(tablaClaves, KeyEvent.KEY_RELEASED, 1, 0, KeyEvent.VK_UNDEFINED, 'a');
                tablaClaves.dispatchEvent(ke);
            }
        });

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
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();

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
        jTclave.setEnabled(false);

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

        jLabel11.setText("Jugadores");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBguardarDatos)
                                .addGap(101, 101, 101))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTtribu, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTbase, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addComponent(jSeparator1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTtribu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 116, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTbase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBguardarDatos)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Tribu", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Raideos", jPanel4);

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
                    etiquetas[0] = mapaclaves.lastKey() + 1;
                    etiquetas[1] = jTclave.getText();
                    dtm.addRow(etiquetas);
                    mapaclaves.put(mapaclaves.lastKey() + 1, jTclave.getText());
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
            JOptionPane.showMessageDialog(this, "Fila borrada correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jBborrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        guardaFichero(ruta);
    }//GEN-LAST:event_formWindowClosing

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

    public JTable creaTabla(JScrollPane jScrol_Tabla) {

        DefaultTableModel dtm;
        JTable tabla = null;

        //4.- Procesar el resultado de la consulta.......
        //4.1.- crear el array de la etiquetas....
        Object[] etiquetas = new Object[2];
        etiquetas[0] = "ID";
        etiquetas[1] = "CLAVE";
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

        int cnt = 1;
        for (String value : mapaclaves.values()) {

            etiquetas[0] = cnt;
            etiquetas[1] = value;
            cnt++;
            dtm.addRow(etiquetas);
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

    void cargaDatos(String ruta) {

        BufferedReader bf = null;

        try {

            bf = new BufferedReader(new FileReader(new File(ruta)));

            String linea, clave;
            String[] datos;

            while ((linea = bf.readLine()) != null) {
                datos = linea.split(";");
                int id = Integer.parseInt(datos[0]);
                clave = datos[1];

                mapaclaves.put(id, clave);

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

    public String guardaFichero(String ruta) {
        File file = new File(ruta);
        PrintWriter fichero;
        String listado = "";

        for (Map.Entry<Integer, String> entry : mapaclaves.entrySet()) {
            Integer key = entry.getKey();
            String val = entry.getValue();

            listado += String.valueOf(key) + ";" + val + "\n";

        }

        try {
            fichero = new PrintWriter(new FileWriter(ruta));

            fichero.print(listado);

            fichero.close();
        } catch (IOException ex) {
            System.out.println("Error de E/S escribiendo en el fichero ...");
        }

        return "";
    }

    public void cargarDatosRaideos(int id){
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBborrar;
    private javax.swing.JButton jBgenerar;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBguardarDatos;
    private javax.swing.JButton jBlimpiar;
    private javax.swing.JLabel jLAdvertencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTbase;
    private javax.swing.JTextField jTclave;
    private javax.swing.JTextField jTdigitos;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTletras;
    private javax.swing.JTextField jTnumeros;
    private javax.swing.JTextField jTtribu;
    // End of variables declaration//GEN-END:variables
}
