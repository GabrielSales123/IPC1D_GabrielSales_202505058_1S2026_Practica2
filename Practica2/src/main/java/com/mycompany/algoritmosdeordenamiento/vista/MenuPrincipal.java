
package com.mycompany.algoritmosdeordenamiento.vista;
import com.mycompany.algoritmosdeordenamiento.algoritmos.*;
import com.mycompany.algoritmosdeordenamiento.modelo.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class MenuPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPrincipal.class.getName());
    private DefaultCategoryDataset dataset;
    private BubbleSort burbuja; 
    private QuickSort quick;
    private ShellSort shell;
    private Estadisticas est;
    private Reportes rep;
    private TablaHistorial historial;
    private int[] colorEstado;
    private int contadorEjecuciones = 1;
    
    public MenuPrincipal(BubbleSort burbuja, QuickSort quick, ShellSort shell, Estadisticas est, Reportes rep) {
        dataset = new DefaultCategoryDataset();
        historial = new TablaHistorial(est);
        this.burbuja = burbuja;
        this.quick = quick; 
        this.shell = shell;
        this.est = est;
        this.rep = rep;
        historial.limpiarHistorial();
        initComponents();
        inicializarGrafica();
        iniciarBox();
        
        
    }

    private void inicializarGrafica(){
    JFreeChart chart = ChartFactory.createBarChart(
            "",
            "",
            "",
            dataset
    );

    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));

    graficaPanel.setLayout(new java.awt.BorderLayout());
    graficaPanel.add(chartPanel, java.awt.BorderLayout.CENTER);
    CategoryPlot plot = chart.getCategoryPlot();

BarRenderer renderer = new BarRenderer() {
    @Override
    public java.awt.Paint getItemPaint(int dat, int columna) {
        if (colorEstado == null) return Color.BLUE;

        switch (colorEstado[columna]) {
            case 1: return Color.YELLOW;   
            case 2: return Color.RED;      
            case 3: return Color.GREEN;   
            default: return Color.CYAN;    
        }
    }
};

plot.setRenderer(renderer);
    }
   
    public void actualizarGrafica(int[] datos, int[] estados){
        javax.swing.SwingUtilities.invokeLater(() -> {
        this.colorEstado = estados;
        dataset.clear();
        for (int i = 0; i < datos.length; i++){
            dataset.addValue(datos[i], "Valores", String.valueOf(datos[i]));
        }
    });
        
    }
    
    public void iniciarBox(){
         algoritmoBox.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { 
            "Bubble Sort", 
            "Quick Sort", 
            "Shell Sort"
            }
            ));
         
         ordenBox.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { 
            "Ascendente", 
            "Descendente"
            }
            ));
         
         velocidadBox.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { 
            "20 ms", 
            "100 ms", 
            "500 ms"
            }
            ));
    }
    
    public void actualizarEstadisticas(Estadisticas est) {
    SwingUtilities.invokeLater(() -> {
        CompTxt.setText(String.valueOf(est.getComparaciones()));
        InterTxt.setText(String.valueOf(est.getIntercambios()));
        IteraTxt.setText(String.valueOf(est.getIteraciones()));
    });
}
    
    public void mostrarConsola(String texto){
        consoleLog.append(texto+"\n");
        consoleLog.setCaretPosition(consoleLog.getDocument().getLength());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        entradaTxt = new javax.swing.JTextField();
        algoritmoBox = new javax.swing.JComboBox<>();
        ordenBox = new javax.swing.JComboBox<>();
        velocidadBox = new javax.swing.JComboBox<>();
        confirmBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        CompTxt = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        InterTxt = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        IteraTxt = new javax.swing.JLabel();
        cargarBtn = new javax.swing.JButton();
        aleatorioBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        graficaPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        consoleLog = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        entradaTxt.addActionListener(this::entradaTxtActionPerformed);

        algoritmoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ordenBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        velocidadBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        confirmBtn.setText("Iniciar");
        confirmBtn.addActionListener(this::confirmBtnActionPerformed);

        jLabel1.setText("Velocidad");

        jLabel2.setText("Orden");

        jLabel3.setText("Algoritmo");

        jLabel4.setText("Entrada:");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Comp.");

        CompTxt.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(CompTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CompTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Interca.");

        InterTxt.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(InterTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(InterTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Iteracion");

        IteraTxt.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(IteraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(IteraTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6))
        );

        cargarBtn.setText("Cargar");
        cargarBtn.addActionListener(this::cargarBtnActionPerformed);

        aleatorioBtn.setText("Aleatorio");
        aleatorioBtn.addActionListener(this::aleatorioBtnActionPerformed);

        jLabel9.setText("Panel de Control");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(confirmBtn)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(velocidadBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ordenBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(algoritmoBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cargarBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aleatorioBtn))
                            .addComponent(jLabel4)
                            .addComponent(entradaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entradaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargarBtn)
                    .addComponent(aleatorioBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(algoritmoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordenBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(velocidadBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(confirmBtn)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        graficaPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout graficaPanelLayout = new javax.swing.GroupLayout(graficaPanel);
        graficaPanel.setLayout(graficaPanelLayout);
        graficaPanelLayout.setHorizontalGroup(
            graficaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );
        graficaPanelLayout.setVerticalGroup(
            graficaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        consoleLog.setColumns(20);
        consoleLog.setRows(5);
        jScrollPane1.setViewportView(consoleLog);

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel10.setText("Visualizacion");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addComponent(graficaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(3, 3, 3)
                .addComponent(graficaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jButton1.setText("Historial");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Visualizador de Algoritmos de Ordenamiento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel8)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entradaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entradaTxtActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        String texto = entradaTxt.getText();
        String[] partes = texto.split(",");
        int [] datos = new int[partes.length];
        for (int i=0; i<partes.length; i++){
            datos[i] = Integer.parseInt(partes[i].trim());
        }
        boolean orden = ordenBox.getSelectedItem().toString().equals("Ascendente");
        String opcion = velocidadBox.getSelectedItem().toString();
        int velocidad;
        switch(opcion) {
            case "500 ms": velocidad = 500; break;
            case "100 ms": velocidad = 100; break;
            case "20 ms": velocidad = 20; break;
            default: velocidad = 100;
        }
        int contiempo = 0;
        switch(algoritmoBox.getSelectedItem().toString()){
            case "Bubble Sort":
                mostrarConsola("Iniciando Bubble Sort "+ "("+ ordenBox.getSelectedItem().toString()+")");
                new Thread(() -> {
                burbuja.setTiempo(0); 
                int[] original = datos.clone();
                burbuja.ordenar(datos, orden, velocidad, this, est, contiempo);
                rep.generarReporte("Bubble Sort", ordenBox.getSelectedItem().toString(), original, datos, est, burbuja.getTiempo());
                historial.agregarHistorial(contadorEjecuciones, algoritmoBox.getSelectedItem().toString(), 
                ordenBox.getSelectedItem().toString(), datos, est, burbuja.getTiempo());
                contadorEjecuciones++;
                }).start();
                break;
            case "Quick Sort":
                int cont= 0;
                
                mostrarConsola("Iniciando Quick Sort "+ "("+ ordenBox.getSelectedItem().toString()+")");
                est.reiniciar();
                quick.setTiempo(0);              
                new Thread(() -> {
                    int[] original = datos.clone();
                    quick.ordenar(datos, 0, datos.length-1, orden, velocidad, this, est, cont);
                    mostrarConsola("Ordenamiento Completado en "+quick.getTiempo()+"ms");
                    rep.generarReporte("Quick Sort", ordenBox.getSelectedItem().toString(), original, datos, est, quick.getTiempo());
                    historial.agregarHistorial(contadorEjecuciones, algoritmoBox.getSelectedItem().toString(), 
                    ordenBox.getSelectedItem().toString(), datos, est, quick.getTiempo());
                    contadorEjecuciones++;
                }).start();        
                break;
            case "Shell Sort":
                mostrarConsola("Iniciando Shell Sort "+ "("+ ordenBox.getSelectedItem().toString()+")");
                new Thread(() -> {
                shell.setTiempo(0); 
                int[] original = datos.clone();    
                shell.ordenar(datos, orden, velocidad, this, est, contiempo);
                rep.generarReporte("Shell Sort", ordenBox.getSelectedItem().toString(), original, datos, est, shell.getTiempo());
                historial.agregarHistorial(contadorEjecuciones, algoritmoBox.getSelectedItem().toString(), 
                ordenBox.getSelectedItem().toString(), datos, est, shell.getTiempo());
                contadorEjecuciones++;
                }).start();
                break;
        }
       
                
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void cargarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            try {
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                String contenido = "";
                    while ((linea = br.readLine()) != null) {
                    contenido += linea + "\n";
                }
        br.close();
        entradaTxt.setText(contenido);
        mostrarConsola("Numeros cargados desde archivo");  
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar archivo");
        }
    }     
    }//GEN-LAST:event_cargarBtnActionPerformed

    private void aleatorioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aleatorioBtnActionPerformed
        Random random = new Random();
        String texto = "";
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100);
            texto += num;
                if (i < 9) {
                    texto += ",";
                }
        }
        entradaTxt.setText(texto);
        mostrarConsola("Numeros Generados Aleatoriamente");  
    }//GEN-LAST:event_aleatorioBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        historial.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> {
        new MenuPrincipal(new BubbleSort(), new QuickSort(), new ShellSort(), new Estadisticas(), new Reportes()).setVisible(true);
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CompTxt;
    private javax.swing.JLabel InterTxt;
    private javax.swing.JLabel IteraTxt;
    private javax.swing.JButton aleatorioBtn;
    private javax.swing.JComboBox<String> algoritmoBox;
    private javax.swing.JButton cargarBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextArea consoleLog;
    private javax.swing.JTextField entradaTxt;
    private javax.swing.JPanel graficaPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> ordenBox;
    private javax.swing.JComboBox<String> velocidadBox;
    // End of variables declaration//GEN-END:variables
}
