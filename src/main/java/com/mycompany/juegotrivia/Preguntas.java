/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.juegotrivia;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.mycompany.conexionSQLServer.Conexion;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author javie
 */
public class Preguntas extends javax.swing.JFrame {

    /**
     * Creates new form preguntas
     */
    private String dato; //se crea una variable que almacenara lo que mandemos a esta 
    private int countNumPreg = 0; //se crea el contador
    private int countPuntaje = 0; //se crea contador de puntaje o respuestas buenas
    private int countPuntajeMalas = 0; //se crea contador de respuestas malas

    int countTimer = 20; //se crea el contador
    Timer timer = new Timer(1000, new ActionListener() { //se crea una variable tipo timer para el cronometro
        public void actionPerformed(ActionEvent ae) {
            countTimer--;
            if (countTimer >= 0) {
                contador.setText("" + countTimer);
            } else {
                timer.stop();
                JOptionPane.showMessageDialog(null, "¡Se acabó el tiempo!");
                respuesta1.setVisible(false);
                respuesta2.setVisible(false);
                respuesta3.setVisible(false);
                respuesta4.setVisible(false);
                pista.setVisible(false);
                sigPregunta.setVisible(true);
                countPuntajeMalas++;
                String countStringPuntajeMalas = Integer.toString(countPuntajeMalas);
                malas.setText("❌ - " + countStringPuntajeMalas);
            }
        }
    });

    public void agregarDato(String dato) { //metodo para copiar dato de otra clase
        this.dato = dato;
        verbo.setText(dato);
    }

    public Preguntas() { //constructor creo
        initComponents();
        initStyles();
        respuesta1.setVisible(false);
        respuesta2.setVisible(false);
        respuesta3.setVisible(false);
        respuesta4.setVisible(false);
        sigPregunta.setVisible(false);
        contador.setVisible(false);
        buenas.setVisible(false);
        malas.setVisible(false);
        numPregunta.setVisible(false);
        pista.setVisible(false);
    }

    private void initStyles() {
        verbo.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
        txt_pregunta.putClientProperty("FlatLaf.style", "font: bold $h2.regular.font");
    }

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_Preguntas = new javax.swing.JPanel();
        txt_pregunta = new javax.swing.JLabel();
        verbo = new javax.swing.JLabel();
        numPregunta = new javax.swing.JLabel();
        contador = new javax.swing.JLabel();
        malas = new javax.swing.JLabel();
        buenas = new javax.swing.JLabel();
        respuesta1 = new javax.swing.JButton();
        respuesta2 = new javax.swing.JButton();
        respuesta3 = new javax.swing.JButton();
        respuesta4 = new javax.swing.JButton();
        pista = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        iniciar = new javax.swing.JButton();
        sigPregunta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        background_Preguntas.setBackground(new java.awt.Color(255, 255, 255));

        txt_pregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_pregunta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        verbo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verbo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        numPregunta.setText("Numero de pregunta");

        contador.setText("20");

        malas.setText("❌ - ");

        buenas.setText("✅ - ");

        respuesta1.setText("Respuesta 1");
        respuesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuesta1ActionPerformed(evt);
            }
        });

        respuesta2.setText("Respuesta 2");
        respuesta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuesta2ActionPerformed(evt);
            }
        });

        respuesta3.setText("Respuesta 3");
        respuesta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuesta3ActionPerformed(evt);
            }
        });

        respuesta4.setText("Respuesa 4");
        respuesta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respuesta4ActionPerformed(evt);
            }
        });

        pista.setText("Pista");
        pista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pistaActionPerformed(evt);
            }
        });

        regresar.setText("Regresar al menú");
        regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        iniciar.setText("Iniciar");
        iniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciarMouseClicked(evt);
            }
        });
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        sigPregunta.setText("Siguiente pregunta");
        sigPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigPreguntaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background_PreguntasLayout = new javax.swing.GroupLayout(background_Preguntas);
        background_Preguntas.setLayout(background_PreguntasLayout);
        background_PreguntasLayout.setHorizontalGroup(
            background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_PreguntasLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_PreguntasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(verbo, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_PreguntasLayout.createSequentialGroup()
                        .addGroup(background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pista)
                            .addComponent(respuesta1))
                        .addGroup(background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(background_PreguntasLayout.createSequentialGroup()
                                .addGap(267, 267, 267)
                                .addGroup(background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_PreguntasLayout.createSequentialGroup()
                                        .addComponent(numPregunta)
                                        .addGap(254, 254, 254))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_PreguntasLayout.createSequentialGroup()
                                        .addComponent(sigPregunta)
                                        .addGap(240, 240, 240)))
                                .addComponent(regresar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, background_PreguntasLayout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(respuesta2)
                                .addGap(145, 145, 145)
                                .addComponent(respuesta3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(respuesta4))))
                    .addComponent(txt_pregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buenas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(malas, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_PreguntasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_PreguntasLayout.createSequentialGroup()
                        .addComponent(contador)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background_PreguntasLayout.createSequentialGroup()
                        .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(410, 410, 410))))
        );
        background_PreguntasLayout.setVerticalGroup(
            background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background_PreguntasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contador)
                .addGap(35, 35, 35)
                .addComponent(verbo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(background_PreguntasLayout.createSequentialGroup()
                        .addComponent(buenas)
                        .addGap(18, 18, 18)
                        .addComponent(malas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numPregunta)
                .addGap(70, 70, 70)
                .addGroup(background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background_PreguntasLayout.createSequentialGroup()
                        .addGap(32, 180, Short.MAX_VALUE)
                        .addGroup(background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(respuesta1)
                            .addComponent(respuesta2)
                            .addComponent(respuesta3)
                            .addComponent(respuesta4))
                        .addGap(103, 103, 103)
                        .addGroup(background_PreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pista)
                            .addComponent(regresar)
                            .addComponent(sigPregunta))
                        .addGap(30, 30, 30))
                    .addGroup(background_PreguntasLayout.createSequentialGroup()
                        .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_Preguntas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_Preguntas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed

        try { //Aignacion de preguntas

            String verboActual = verbo.getText();

            String sql = "select texto_pregunta from preguntas_y_respuestas where respuesta_correcta = '" + verboActual + "' or respuesta_correcta like '%" + verboActual + "%' order by newid()";

            Connection conn = Conexion.getConnection(sql);

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String texto_pregunta = rs.getString("texto_pregunta");
                txt_pregunta.setText(texto_pregunta);
            }

            conn.close();
            iniciar.setVisible(false);
            respuesta1.setVisible(true);
            respuesta2.setVisible(true);
            respuesta3.setVisible(true);
            respuesta4.setVisible(true);
            contador.setVisible(true);
            buenas.setVisible(true);
            malas.setVisible(true);
            numPregunta.setVisible(true);
            pista.setVisible(true);

            timer.start();

            countNumPreg++;
            String countStringNum = Integer.toString(countNumPreg);
            numPregunta.setText("Pregunta " + countStringNum + " de 10");
            if (countStringNum.equals("11")) {
                close();
                Final finalJ = new Final();
                finalJ.setVisible(true);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        try { //Respuestas correctas aleatorias

            String preguntaActual = txt_pregunta.getText();

            String sqlCorrectas = "select respuesta_correcta from preguntas_y_respuestas where texto_pregunta like '%" + preguntaActual + "%'";

            Connection connCorrectas = Conexion.getConnection(sqlCorrectas);

            Statement stCorrectas = connCorrectas.createStatement();

            ResultSet rsCorrectas = stCorrectas.executeQuery(sqlCorrectas);

            List<String> texto_respuestas_incorrectas = new ArrayList<>();

            if (rsCorrectas.next()) {
                String texto_respuesta = rsCorrectas.getString("respuesta_correcta");

                try { //Respuestas incorrectas aleatorias

                    String sqlIncorrectas = "select ris.respuesta_incorrecta from respuestas_incorrectas as ris join preguntas_y_respuestas as prs on ris.cve_preguntas_y_respuestas = prs.cve_preguntas_y_respuestas where prs.texto_pregunta like '%" + preguntaActual + "%'";

                    Connection connIncorrectas = Conexion.getConnection(sqlIncorrectas);

                    Statement stIncorrectas = connIncorrectas.createStatement();

                    ResultSet rsIncorrectas = stIncorrectas.executeQuery(sqlIncorrectas);

                    while (rsIncorrectas.next()) {
                        String texto_respuesta_incorrecta = rsIncorrectas.getString("respuesta_incorrecta");
                        texto_respuestas_incorrectas.add(texto_respuesta_incorrecta);
                    }

                    connIncorrectas.close();

                } catch (SQLException ex) {

                    ex.printStackTrace();

                }

                Random rand = new Random();
                int numeroBoton = rand.nextInt(4) + 1;

                switch (numeroBoton) {
                    case 1:
                        respuesta1.setText(texto_respuesta);
                        respuesta2.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta3.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta4.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        break;
                    case 2:
                        respuesta1.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta2.setText(texto_respuesta);
                        respuesta3.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta4.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        break;
                    case 3:
                        respuesta1.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta2.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta3.setText(texto_respuesta);
                        respuesta4.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        break;
                    case 4:
                        respuesta1.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta2.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta3.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta4.setText(texto_respuesta);
                        break;
                }

            }

            connCorrectas.close();

        } catch (SQLException ex) {

            ex.printStackTrace();

        }


    }//GEN-LAST:event_iniciarActionPerformed

    private void pistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pistaActionPerformed
        Pistas pistas = new Pistas();
        pistas.setVisible(true);
    }//GEN-LAST:event_pistaActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        timer.stop();
        countTimer = 20;
        contador.setText("" + countTimer);
        close();
        Principal principal = new Principal();
        principal.setVisible(true);
    }//GEN-LAST:event_regresarActionPerformed

    private void respuesta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuesta1ActionPerformed
        try { //Comprobar si la respuesta es buena

            String preguntaActual = txt_pregunta.getText();
            String seleccionActual = respuesta1.getText();

            String sql = "select respuesta_correcta from preguntas_y_respuestas where texto_pregunta like '%" + preguntaActual + "%'";

            Connection conn = Conexion.getConnection(sql);

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String respuesta = rs.getString("respuesta_correcta");
                if (seleccionActual.equals(respuesta)) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Respuesta correcta");
                    sigPregunta.setVisible(true);
                    countPuntaje++;
                    String countStringPuntaje = Integer.toString(countPuntaje);
                    buenas.setText("✅ - " + countStringPuntaje);
                    respuesta1.setVisible(false);
                    respuesta2.setVisible(false);
                    respuesta3.setVisible(false);
                    respuesta4.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta");
                    sigPregunta.setVisible(true);
                    countPuntajeMalas++;
                    String countStringPuntajeMalas = Integer.toString(countPuntajeMalas);
                    malas.setText("❌ - " + countStringPuntajeMalas);
                    respuesta1.setVisible(false);
                    respuesta2.setVisible(false);
                    respuesta3.setVisible(false);
                    respuesta4.setVisible(false);
                }
            }

            conn.close();

        } catch (SQLException ex) {

            ex.printStackTrace();

        }
    }//GEN-LAST:event_respuesta1ActionPerformed

    private void respuesta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuesta2ActionPerformed
        try { //Comprobar si la respuesta es buena

            String preguntaActual = txt_pregunta.getText();
            String seleccionActual = respuesta2.getText();

            String sql = "select respuesta_correcta from preguntas_y_respuestas where texto_pregunta like '%" + preguntaActual + "%'";

            Connection conn = Conexion.getConnection(sql);

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String respuesta = rs.getString("respuesta_correcta");
                if (seleccionActual.equals(respuesta)) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Respuesta correcta");
                    sigPregunta.setVisible(true);
                    countPuntaje++;
                    String countStringPuntaje = Integer.toString(countPuntaje);
                    buenas.setText("✅ - " + countStringPuntaje);
                    respuesta1.setVisible(false);
                    respuesta2.setVisible(false);
                    respuesta3.setVisible(false);
                    respuesta4.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta");
                    sigPregunta.setVisible(true);
                    countPuntajeMalas++;
                    String countStringPuntajeMalas = Integer.toString(countPuntajeMalas);
                    malas.setText("❌ - " + countStringPuntajeMalas);
                    respuesta1.setVisible(false);
                    respuesta2.setVisible(false);
                    respuesta3.setVisible(false);
                    respuesta4.setVisible(false);
                }
            }

            conn.close();

        } catch (SQLException ex) {

            ex.printStackTrace();

        }
    }//GEN-LAST:event_respuesta2ActionPerformed

    private void respuesta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuesta3ActionPerformed
        try { //Comprobar si la respuesta es buena

            String preguntaActual = txt_pregunta.getText();
            String seleccionActual = respuesta3.getText();

            String sql = "select respuesta_correcta from preguntas_y_respuestas where texto_pregunta like '%" + preguntaActual + "%'";

            Connection conn = Conexion.getConnection(sql);

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String respuesta = rs.getString("respuesta_correcta");
                if (seleccionActual.equals(respuesta)) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Respuesta correcta");
                    sigPregunta.setVisible(true);
                    countPuntaje++;
                    String countStringPuntaje = Integer.toString(countPuntaje);
                    buenas.setText("✅ - " + countStringPuntaje);
                    respuesta1.setVisible(false);
                    respuesta2.setVisible(false);
                    respuesta3.setVisible(false);
                    respuesta4.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta");
                    sigPregunta.setVisible(true);
                    countPuntajeMalas++;
                    String countStringPuntajeMalas = Integer.toString(countPuntajeMalas);
                    malas.setText("❌ - " + countStringPuntajeMalas);
                    respuesta1.setVisible(false);
                    respuesta2.setVisible(false);
                    respuesta3.setVisible(false);
                    respuesta4.setVisible(false);
                }
            }

            conn.close();

        } catch (SQLException ex) {

            ex.printStackTrace();

        }
    }//GEN-LAST:event_respuesta3ActionPerformed

    private void respuesta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respuesta4ActionPerformed
        try { //Comprobar si la respuesta es buena

            String preguntaActual = txt_pregunta.getText();
            String seleccionActual = respuesta4.getText();

            String sql = "select respuesta_correcta from preguntas_y_respuestas where texto_pregunta like '%" + preguntaActual + "%'";

            Connection conn = Conexion.getConnection(sql);

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String respuesta = rs.getString("respuesta_correcta");
                if (seleccionActual.equals(respuesta)) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Respuesta correcta");
                    sigPregunta.setVisible(true);
                    countPuntaje++;
                    String countStringPuntaje = Integer.toString(countPuntaje);
                    buenas.setText("✅ - " + countStringPuntaje);
                    respuesta1.setVisible(false);
                    respuesta2.setVisible(false);
                    respuesta3.setVisible(false);
                    respuesta4.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta");
                    sigPregunta.setVisible(true);
                    countPuntajeMalas++;
                    String countStringPuntajeMalas = Integer.toString(countPuntajeMalas);
                    malas.setText("❌ - " + countStringPuntajeMalas);
                    respuesta1.setVisible(false);
                    respuesta2.setVisible(false);
                    respuesta3.setVisible(false);
                    respuesta4.setVisible(false);
                }
            }

            conn.close();

        } catch (SQLException ex) {

            ex.printStackTrace();

        }
    }//GEN-LAST:event_respuesta4ActionPerformed

    private void iniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_iniciarMouseClicked

    private void sigPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigPreguntaActionPerformed
        try { //Aignacion de preguntas

            String verboActual = verbo.getText();

            String sql = "select texto_pregunta from preguntas_y_respuestas where respuesta_correcta = '" + verboActual + "' or respuesta_correcta like '%" + verboActual + "%' order by newid()";

            Connection conn = Conexion.getConnection(sql);

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String texto_pregunta = rs.getString("texto_pregunta");
                txt_pregunta.setText(texto_pregunta);
            }

            conn.close();
            sigPregunta.setVisible(false);
            respuesta1.setVisible(true);
            respuesta2.setVisible(true);
            respuesta3.setVisible(true);
            respuesta4.setVisible(true);

            //reiniciar timer a 20
            timer.stop();
            countTimer = 20;
            contador.setText("" + countTimer);
            timer.start();

            countNumPreg++;
            String countStringNum = Integer.toString(countNumPreg);
            numPregunta.setText("Pregunta " + countStringNum + " de 10");
            if (countStringNum.equals("10")) {
                sigPregunta.setText("Ver resultados");
            }
            if (countStringNum.equals("11")) {
                close();
                Final finalJ = new Final();
                finalJ.agregarDato(countPuntaje, countPuntajeMalas);
                finalJ.setVisible(true);
                timer.stop();
                countTimer = 20;
                contador.setText("" + countTimer);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        try { //Respuestas correctas aleatorias

            String preguntaActual = txt_pregunta.getText();

            String sqlCorrectas = "select respuesta_correcta from preguntas_y_respuestas where texto_pregunta like '%" + preguntaActual + "%'";

            Connection connCorrectas = Conexion.getConnection(sqlCorrectas);

            Statement stCorrectas = connCorrectas.createStatement();

            ResultSet rsCorrectas = stCorrectas.executeQuery(sqlCorrectas);

            List<String> texto_respuestas_incorrectas = new ArrayList<>();

            if (rsCorrectas.next()) {
                String texto_respuesta = rsCorrectas.getString("respuesta_correcta");

                try { //Respuestas incorrectas aleatorias

                    String sqlIncorrectas = "select ris.respuesta_incorrecta from respuestas_incorrectas as ris join preguntas_y_respuestas as prs on ris.cve_preguntas_y_respuestas = prs.cve_preguntas_y_respuestas where prs.texto_pregunta like '%" + preguntaActual + "%'";

                    Connection connIncorrectas = Conexion.getConnection(sqlIncorrectas);

                    Statement stIncorrectas = connIncorrectas.createStatement();

                    ResultSet rsIncorrectas = stIncorrectas.executeQuery(sqlIncorrectas);

                    while (rsIncorrectas.next()) {
                        String texto_respuesta_incorrecta = rsIncorrectas.getString("respuesta_incorrecta");
                        texto_respuestas_incorrectas.add(texto_respuesta_incorrecta);
                    }

                    connIncorrectas.close();

                } catch (SQLException ex) {

                    ex.printStackTrace();

                }

                Random rand = new Random();
                int numeroBoton = rand.nextInt(4) + 1;

                switch (numeroBoton) {
                    case 1:
                        respuesta1.setText(texto_respuesta);
                        respuesta2.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta3.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta4.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        break;
                    case 2:
                        respuesta1.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta2.setText(texto_respuesta);
                        respuesta3.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta4.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        break;
                    case 3:
                        respuesta1.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta2.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta3.setText(texto_respuesta);
                        respuesta4.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        break;
                    case 4:
                        respuesta1.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta2.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta3.setText(texto_respuestas_incorrectas.get(rand.nextInt(texto_respuestas_incorrectas.size())));
                        respuesta4.setText(texto_respuesta);
                        break;
                }

            }

            connCorrectas.close();

        } catch (SQLException ex) {

            ex.printStackTrace();

        }
    }//GEN-LAST:event_sigPreguntaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatArcOrangeIJTheme.setup(); //Creacion del look and feel
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Preguntas().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background_Preguntas;
    private javax.swing.JLabel buenas;
    private javax.swing.JLabel contador;
    private javax.swing.JButton iniciar;
    private javax.swing.JLabel malas;
    private javax.swing.JLabel numPregunta;
    private javax.swing.JButton pista;
    private javax.swing.JButton regresar;
    private javax.swing.JButton respuesta1;
    private javax.swing.JButton respuesta2;
    private javax.swing.JButton respuesta3;
    private javax.swing.JButton respuesta4;
    private javax.swing.JButton sigPregunta;
    private javax.swing.JLabel txt_pregunta;
    private javax.swing.JLabel verbo;
    // End of variables declaration//GEN-END:variables
}

/*
            //algoritmo de puntaje
                int puntajeGlobal = 0;
                    puntajeGlobal = + 1;
                    JOptionPane.showMessageDialog(null, "Tu puntaje actual es de: " + puntajeGlobal);
                    String puntajeString = Integer.toString(puntajeGlobal);
                    puntosj.setText(puntajeString);

            //boton desaparece on click
                botonNombre.setVisible(false);

            //contador de preguntas
                int contador
                contador =+ 1;
                contador.setText("Pregunta " + contador + " de 10";
                if (contador >= 11) {
                sout se acabo el juego
                }

            //on click countdown
                for (int i = 10; i >= 1; 1--){
                timer.setText(i)
                Thread.sleep(1000);
                } necesita el throws

            //cronometro
        Thread countdownThread = new Thread({
                @Override
                for (int n = 20; n >= 0; n--){
                JOptionPane.showMessageDialog(null, n);
                try{
                    Thread.sleep(1000);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Error" + ex);
                }
            }
            });
 */
