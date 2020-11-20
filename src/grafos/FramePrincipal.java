/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author criss
 */
public class FramePrincipal extends javax.swing.JFrame {
   Grafo grafo = new Grafo();
   Vertice verticeInicio;
   Vertice verticeFinal;
   int x, y;
   /**
    * Creates new form FramePrincipal
    */
   public FramePrincipal() {
      initComponents();
      jcbDepartamentoOrigen.setEnabled(false);
      jcbDepartamentoDestino.setEnabled(false);
      Image img = new ImageIcon("src/Img/mapa-el-salvador.svg").getImage();
      Image image = img.getScaledInstance(700, 400, Image.SCALE_SMOOTH);
      jlbMapa.setIcon(new ImageIcon(image));
      agregarVertices();
      agregarItems();
      jcbDepartamentoOrigen.setSelectedIndex(-1);
      jcbDepartamentoDestino.setSelectedIndex(-1);
   }
   
   private void agregarVertices()
   {
      grafo.agregarVertice(new Vertice("Ahuachapán", 95, 185)); // indice 0
      grafo.agregarVertice(new Vertice("Santa Ana", 185, 130)); // indice 1
      grafo.agregarVertice(new Vertice("Sonsonate", 145, 220)); // indice 2
      grafo.agregarVertice(new Vertice("Chalatenango", 305, 120)); // indice 3
      grafo.agregarVertice(new Vertice("La Libertad", 235, 220)); // indice 4
      grafo.agregarVertice(new Vertice("San Salvador", 280, 210)); // indice 5
      grafo.agregarVertice(new Vertice("Cuscatlán", 320, 195)); // indice 6
      grafo.agregarVertice(new Vertice("Cabañas", 400, 185)); // indice 7
      grafo.agregarVertice(new Vertice("La Paz", 330, 270)); // indice 8
      grafo.agregarVertice(new Vertice("San Vicente", 390, 250)); // indice 9
      grafo.agregarVertice(new Vertice("Usulután", 445, 290)); // indice 10
      grafo.agregarVertice(new Vertice("San Miguel", 520, 270)); // indice 11
      grafo.agregarVertice(new Vertice("Morazán", 555, 205)); // indice 12
      grafo.agregarVertice(new Vertice("La Unión", 600, 275)); // indice 13
      agregarConexiones();
   }
   
   private void agregarConexiones()
   {
      grafo.getListaVertices().get(0).agregarArista(
              new Arista(grafo.getListaVertices().get(0), grafo.getListaVertices().get(1), 41.06)); //Ahuachapán - Santa Ana
      grafo.getListaVertices().get(0).agregarArista(
              new Arista(grafo.getListaVertices().get(0), grafo.getListaVertices().get(2), 26.51)); //Ahuachapán - Sonsonate
      grafo.getListaVertices().get(1).agregarArista(
              new Arista(grafo.getListaVertices().get(1), grafo.getListaVertices().get(0), 41.06)); //Santa Ana - Ahuachapán
      grafo.getListaVertices().get(1).agregarArista(
              new Arista(grafo.getListaVertices().get(1), grafo.getListaVertices().get(2), 35.40)); //Santa Ana - Sonsonate
      grafo.getListaVertices().get(1).agregarArista(
              new Arista(grafo.getListaVertices().get(1), grafo.getListaVertices().get(3), 67.74)); //Santa Ana - Chalatenango
      grafo.getListaVertices().get(1).agregarArista(
              new Arista(grafo.getListaVertices().get(1), grafo.getListaVertices().get(4), 33.17)); //Santa Ana - La Libertad
      grafo.getListaVertices().get(2).agregarArista(
              new Arista(grafo.getListaVertices().get(2), grafo.getListaVertices().get(0), 26.51)); //Sonsonate - Ahuachapán
      grafo.getListaVertices().get(2).agregarArista(
              new Arista(grafo.getListaVertices().get(2), grafo.getListaVertices().get(1), 35.40)); //Sonsonate - Santa Ana
      grafo.getListaVertices().get(2).agregarArista(
              new Arista(grafo.getListaVertices().get(2), grafo.getListaVertices().get(4), 36.99)); //Sonsonate - La Libertad
      grafo.getListaVertices().get(3).agregarArista(
              new Arista(grafo.getListaVertices().get(3), grafo.getListaVertices().get(1), 67.74)); //Chalatenango - Santa Ana
      grafo.getListaVertices().get(3).agregarArista(
              new Arista(grafo.getListaVertices().get(3), grafo.getListaVertices().get(4), 57.91)); //Chalatenango - La Libertad
      grafo.getListaVertices().get(3).agregarArista(
              new Arista(grafo.getListaVertices().get(3), grafo.getListaVertices().get(5), 47.07)); //Chalatenango - San Salvador
      grafo.getListaVertices().get(3).agregarArista(
              new Arista(grafo.getListaVertices().get(3), grafo.getListaVertices().get(6), 23.96)); //Chalatenango - Cuscatlán
      grafo.getListaVertices().get(3).agregarArista(
              new Arista(grafo.getListaVertices().get(3), grafo.getListaVertices().get(7), 27.12)); //Chalatenango - Cabañas
      grafo.getListaVertices().get(4).agregarArista(
              new Arista(grafo.getListaVertices().get(4), grafo.getListaVertices().get(1), 33.17)); //La Libertad - Santa Ana
      grafo.getListaVertices().get(4).agregarArista(
              new Arista(grafo.getListaVertices().get(4), grafo.getListaVertices().get(2), 36.99)); //La Libertad - Sonsonate
      grafo.getListaVertices().get(4).agregarArista(
              new Arista(grafo.getListaVertices().get(4), grafo.getListaVertices().get(3), 57.91)); //La Libertad - Chalatenango
      grafo.getListaVertices().get(4).agregarArista(
              new Arista(grafo.getListaVertices().get(4), grafo.getListaVertices().get(5), 22.24)); //La Libertad - San Salvador
      grafo.getListaVertices().get(4).agregarArista(
              new Arista(grafo.getListaVertices().get(4), grafo.getListaVertices().get(8), 53.51)); //La Libertad - La Paz
      grafo.getListaVertices().get(5).agregarArista(
              new Arista(grafo.getListaVertices().get(5), grafo.getListaVertices().get(3), 47.07)); //San Salvador - Chalatenango
      grafo.getListaVertices().get(5).agregarArista(
              new Arista(grafo.getListaVertices().get(5), grafo.getListaVertices().get(4), 22.24)); //San Salvador - La Libertad
      grafo.getListaVertices().get(5).agregarArista(
              new Arista(grafo.getListaVertices().get(5), grafo.getListaVertices().get(6), 23.11)); //San Salvador - Cuscatlán
      grafo.getListaVertices().get(5).agregarArista(
              new Arista(grafo.getListaVertices().get(5), grafo.getListaVertices().get(8), 33.16)); //San Salvador - La Paz
      grafo.getListaVertices().get(6).agregarArista(
              new Arista(grafo.getListaVertices().get(6), grafo.getListaVertices().get(3), 23.96)); //Cuscatlán - Chalatenango
      grafo.getListaVertices().get(6).agregarArista(
              new Arista(grafo.getListaVertices().get(6), grafo.getListaVertices().get(5), 23.11)); //Cuscatlán - San Salvador
      grafo.getListaVertices().get(6).agregarArista(
              new Arista(grafo.getListaVertices().get(6), grafo.getListaVertices().get(7), 33.62)); //Cuscatlán - Cabañas
      grafo.getListaVertices().get(6).agregarArista(
              new Arista(grafo.getListaVertices().get(6), grafo.getListaVertices().get(8), 44.25)); //Cuscatlán - La Paz
      grafo.getListaVertices().get(6).agregarArista(
              new Arista(grafo.getListaVertices().get(6), grafo.getListaVertices().get(9), 37.64)); //Cuscatlán - San Vicente
      grafo.getListaVertices().get(7).agregarArista(
              new Arista(grafo.getListaVertices().get(7), grafo.getListaVertices().get(3), 27.12)); //Cabañas - Chalatenango
      grafo.getListaVertices().get(7).agregarArista(
              new Arista(grafo.getListaVertices().get(7), grafo.getListaVertices().get(6), 33.62)); //Cabañas - Cuscatlán
      grafo.getListaVertices().get(7).agregarArista(
              new Arista(grafo.getListaVertices().get(7), grafo.getListaVertices().get(9), 26.51)); //Cabañas - San Vicente
      grafo.getListaVertices().get(7).agregarArista(
              new Arista(grafo.getListaVertices().get(7), grafo.getListaVertices().get(11), 74.62)); //Cabañas - San Miguel
      grafo.getListaVertices().get(8).agregarArista(
              new Arista(grafo.getListaVertices().get(8), grafo.getListaVertices().get(4), 53.51)); //La Paz - La Libertad
      grafo.getListaVertices().get(8).agregarArista(
              new Arista(grafo.getListaVertices().get(8), grafo.getListaVertices().get(5), 33.16)); //La Paz - San Salvador
      grafo.getListaVertices().get(8).agregarArista(
              new Arista(grafo.getListaVertices().get(8), grafo.getListaVertices().get(6), 44.25)); //La Paz - Cuscatlán
      grafo.getListaVertices().get(8).agregarArista(
              new Arista(grafo.getListaVertices().get(8), grafo.getListaVertices().get(9), 27.14)); //La Paz - San Vicente
      grafo.getListaVertices().get(9).agregarArista(
              new Arista(grafo.getListaVertices().get(9), grafo.getListaVertices().get(6), 37.64)); //San Vicente - Cuscatlán
      grafo.getListaVertices().get(9).agregarArista(
              new Arista(grafo.getListaVertices().get(9), grafo.getListaVertices().get(7), 26.51)); //San Vicente - Cabañas
      grafo.getListaVertices().get(9).agregarArista(
              new Arista(grafo.getListaVertices().get(9), grafo.getListaVertices().get(8), 27.14)); //San Vicente - La Paz
      grafo.getListaVertices().get(9).agregarArista(
              new Arista(grafo.getListaVertices().get(9), grafo.getListaVertices().get(10), 49.26)); //San Vicente - Usulután
      grafo.getListaVertices().get(9).agregarArista(
              new Arista(grafo.getListaVertices().get(9), grafo.getListaVertices().get(11), 68.74)); //San Vicente - San Miguel
      grafo.getListaVertices().get(10).agregarArista(
              new Arista(grafo.getListaVertices().get(10), grafo.getListaVertices().get(9), 49.26)); //Usulután - San Vicente
      grafo.getListaVertices().get(10).agregarArista(
              new Arista(grafo.getListaVertices().get(10), grafo.getListaVertices().get(11), 32.44)); //Usulután - San Miguel
      grafo.getListaVertices().get(11).agregarArista(
              new Arista(grafo.getListaVertices().get(11), grafo.getListaVertices().get(7), 74.62)); //San Miguel - Cabañas
      grafo.getListaVertices().get(11).agregarArista(
              new Arista(grafo.getListaVertices().get(11), grafo.getListaVertices().get(9), 68.74)); //San Miguel - San Vicente
      grafo.getListaVertices().get(11).agregarArista(
              new Arista(grafo.getListaVertices().get(11), grafo.getListaVertices().get(10), 32.44)); //San Miguel - Usulutan
      grafo.getListaVertices().get(11).agregarArista(
              new Arista(grafo.getListaVertices().get(11), grafo.getListaVertices().get(12), 33.56)); //San Miguel - Morazán
      grafo.getListaVertices().get(11).agregarArista(
              new Arista(grafo.getListaVertices().get(11), grafo.getListaVertices().get(13), 31.53)); //San Miguel - La Unión
      grafo.getListaVertices().get(12).agregarArista(
              new Arista(grafo.getListaVertices().get(12), grafo.getListaVertices().get(11), 33.56)); //Morazán - San Miguel
      grafo.getListaVertices().get(12).agregarArista(
              new Arista(grafo.getListaVertices().get(12), grafo.getListaVertices().get(13), 32.53)); //Morazán - La Unión
      grafo.getListaVertices().get(13).agregarArista(
              new Arista(grafo.getListaVertices().get(13), grafo.getListaVertices().get(11), 31.53)); //La Unión - San Miguel
      grafo.getListaVertices().get(13).agregarArista(
              new Arista(grafo.getListaVertices().get(13), grafo.getListaVertices().get(12), 32.53)); //La Unión - Morazán
   }
   
   private void agregarItems()
   {
      for (Vertice v:grafo.getListaVertices())
      {
         jcbDepartamentoOrigen.addItem(v.getDato());
         jcbDepartamentoDestino.addItem(v.getDato());
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jpMenu = new javax.swing.JPanel();
        jbtMostrarRutas = new javax.swing.JButton();
        jcbDepartamentoOrigen = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jbtCalcularRuta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbDepartamentoDestino = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResultados = new javax.swing.JTextArea();
        jpMapa = new javax.swing.JPanel();
        jlbMapa = new javax.swing.JLabel();
        Panel = new javax.swing.JPanel();
        jlbCerrar = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setUndecorated(true);
        setResizable(false);

        jpMenu.setBackground(new java.awt.Color(51, 51, 51));

        jbtMostrarRutas.setBackground(new java.awt.Color(255, 255, 255));
        jbtMostrarRutas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtMostrarRutas.setText("MOSTRAR RUTAS");
        jbtMostrarRutas.setBorder(null);
        jbtMostrarRutas.setFocusPainted(false);
        jbtMostrarRutas.setFocusable(false);
        jbtMostrarRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMostrarRutasActionPerformed(evt);
            }
        });

        jcbDepartamentoOrigen.setBackground(new java.awt.Color(102, 102, 102));
        jcbDepartamentoOrigen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jcbDepartamentoOrigen.setForeground(new java.awt.Color(255, 255, 255));
        jcbDepartamentoOrigen.setAutoscrolls(true);
        jcbDepartamentoOrigen.setFocusable(false);
        jcbDepartamentoOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDepartamentoOrigenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RUTA MÁS CORTA");

        jbtCalcularRuta.setBackground(new java.awt.Color(255, 255, 255));
        jbtCalcularRuta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtCalcularRuta.setText("CALCULAR RUTA");
        jbtCalcularRuta.setBorder(null);
        jbtCalcularRuta.setFocusPainted(false);
        jbtCalcularRuta.setFocusable(false);
        jbtCalcularRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCalcularRutaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DEPARTAMENTO ORIGEN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DEPARTAMENTO DESTINO");

        jcbDepartamentoDestino.setBackground(new java.awt.Color(102, 102, 102));
        jcbDepartamentoDestino.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jcbDepartamentoDestino.setForeground(new java.awt.Color(255, 255, 255));
        jcbDepartamentoDestino.setAutoscrolls(true);
        jcbDepartamentoDestino.setFocusable(false);
        jcbDepartamentoDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDepartamentoDestinoActionPerformed(evt);
            }
        });

        jtResultados.setEditable(false);
        jtResultados.setBackground(new java.awt.Color(51, 51, 51));
        jtResultados.setColumns(20);
        jtResultados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtResultados.setForeground(new java.awt.Color(255, 255, 255));
        jtResultados.setLineWrap(true);
        jtResultados.setRows(5);
        jtResultados.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jtResultados);

        javax.swing.GroupLayout jpMenuLayout = new javax.swing.GroupLayout(jpMenu);
        jpMenu.setLayout(jpMenuLayout);
        jpMenuLayout.setHorizontalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbDepartamentoOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbDepartamentoDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpMenuLayout.createSequentialGroup()
                        .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jbtMostrarRutas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtCalcularRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpMenuLayout.setVerticalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbDepartamentoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addComponent(jcbDepartamentoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtMostrarRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCalcularRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpMapa.setBackground(new java.awt.Color(102, 153, 255));
        jpMapa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpMapaLayout = new javax.swing.GroupLayout(jpMapa);
        jpMapa.setLayout(jpMapaLayout);
        jpMapaLayout.setHorizontalGroup(
            jpMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbMapa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        jpMapaLayout.setVerticalGroup(
            jpMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbMapa, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        Panel.setBackground(new java.awt.Color(51, 51, 51));
        Panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelMouseDragged(evt);
            }
        });
        Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelMousePressed(evt);
            }
        });

        jlbCerrar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlbCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jlbCerrar.setText("X");
        jlbCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbCerrar)
                .addGap(14, 14, 14))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbCerrar)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   private void jbtMostrarRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMostrarRutasActionPerformed
      // TODO add your handling code here:
      if(jbtMostrarRutas.getText().equals("MOSTRAR RUTAS"))
      {
         verticeInicio = null;
         verticeFinal = null;
         jcbDepartamentoOrigen.setEnabled(true);
         jcbDepartamentoDestino.setEnabled(true);
         DibujarRutas.dibujarRutas(jpMapa.getGraphics(), grafo);
         jbtMostrarRutas.setText("OCULTAR RUTAS");
      }
      else
      {
         jpMapa.repaint();
         jbtMostrarRutas.setText("MOSTRAR RUTAS");
         jtResultados.setText("");
         jcbDepartamentoOrigen.setEnabled(false);
         jcbDepartamentoDestino.setEnabled(false);
         jcbDepartamentoOrigen.setSelectedIndex(-1);
         jcbDepartamentoDestino.setSelectedIndex(-1);
      }
   }//GEN-LAST:event_jbtMostrarRutasActionPerformed

   private void jbtCalcularRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCalcularRutaActionPerformed
      // TODO add your handling code here:
      if (jcbDepartamentoOrigen.getSelectedIndex() != -1 && jcbDepartamentoDestino.getSelectedIndex() != -1)
      {
         Grafo Ruta = AlgoritmoDijkstra.obtenerRuta(grafo, verticeInicio, verticeFinal);
         double DistanciaTotal = 0;
         
         for (Vertice V:Ruta.getListaVertices())
         {
            for (Arista A:V.getAristas())
            {
               DistanciaTotal += A.getPeso();
            }
         }
         
         DibujarRutas.dibujarRutas(jpMapa.getGraphics(), grafo);
         DibujarRutas.dibujarRutaMinima(jpMapa.getGraphics(), Ruta);
         jtResultados.setText("Distancia Minima: " + String.format("%.2f", DistanciaTotal) + " Km");
      }
      else
      {
         JOptionPane.showMessageDialog(null, "Seleccione Un Departamento De Las Listas", "", JOptionPane.ERROR_MESSAGE);
      }
   }//GEN-LAST:event_jbtCalcularRutaActionPerformed
/**/
   private void jlbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseClicked
      System.exit(0);
   }//GEN-LAST:event_jlbCerrarMouseClicked

   private void PanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMousePressed
      x = evt.getX();
      y = evt.getY();
   }//GEN-LAST:event_PanelMousePressed

   private void PanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseDragged
      this.setLocation(evt.getX() + this.getLocation().x - x, evt.getY() + this.getLocation().y - y);
   }//GEN-LAST:event_PanelMouseDragged

   private void jcbDepartamentoOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDepartamentoOrigenActionPerformed
      // TODO add your handling code here:
      if (jcbDepartamentoOrigen.isEnabled())
      {
         if (verticeInicio != null && verticeFinal != null)
         {
            if (verticeInicio != verticeFinal)
               DibujarRutas.deseleccionarVertice(jpMapa.getGraphics(), verticeInicio);
         }
         else
         {
            if (verticeInicio != null)
               DibujarRutas.deseleccionarVertice(jpMapa.getGraphics(), verticeInicio);
         }
         
         verticeInicio = grafo.buscarVertice(jcbDepartamentoOrigen.getSelectedItem().toString());
         DibujarRutas.seleccionarVertice(jpMapa.getGraphics(), verticeInicio);
      }
   }//GEN-LAST:event_jcbDepartamentoOrigenActionPerformed

   private void jcbDepartamentoDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDepartamentoDestinoActionPerformed
      // TODO add your handling code here:
      if (jcbDepartamentoDestino.isEnabled())
      {
         if (verticeFinal != null && verticeInicio != null)
         {
            if (verticeFinal != verticeInicio)
               DibujarRutas.deseleccionarVertice(jpMapa.getGraphics(), verticeFinal);
         }
         else
         {
            if (verticeFinal != null)
               DibujarRutas.deseleccionarVertice(jpMapa.getGraphics(), verticeFinal);
         }
         
         verticeFinal = grafo.buscarVertice(jcbDepartamentoDestino.getSelectedItem().toString());
         DibujarRutas.seleccionarVertice(jpMapa.getGraphics(), verticeFinal);
      }
   }//GEN-LAST:event_jcbDepartamentoDestinoActionPerformed
/**/
   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new FramePrincipal().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbtCalcularRuta;
    private javax.swing.JButton jbtMostrarRutas;
    private javax.swing.JComboBox<String> jcbDepartamentoDestino;
    private javax.swing.JComboBox<String> jcbDepartamentoOrigen;
    private javax.swing.JLabel jlbCerrar;
    private javax.swing.JLabel jlbMapa;
    private javax.swing.JPanel jpMapa;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JTextArea jtResultados;
    // End of variables declaration//GEN-END:variables
}
