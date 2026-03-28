
package com.mycompany.algoritmosdeordenamiento.vista;
import com.mycompany.algoritmosdeordenamiento.algoritmos.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import java.awt.Color;


public class MenuPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPrincipal.class.getName());
    private DefaultCategoryDataset dataset;
    private BubbleSort burbuja; 
    private int[] colorEstado;
    
    public MenuPrincipal(BubbleSort burbuja) {
        dataset = new DefaultCategoryDataset();
        this.burbuja = burbuja;
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
    chartPanel.setPreferredSize(new java.awt.Dimension(400, 300));

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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        graficaPanel = new javax.swing.JPanel();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(entradaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmBtn)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(velocidadBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 162, Short.MAX_VALUE)
                        .addComponent(ordenBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(algoritmoBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entradaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(algoritmoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordenBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(velocidadBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(confirmBtn)
                .addGap(51, 51, 51))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        graficaPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout graficaPanelLayout = new javax.swing.GroupLayout(graficaPanel);
        graficaPanel.setLayout(graficaPanelLayout);
        graficaPanelLayout.setHorizontalGroup(
            graficaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graficaPanelLayout.setVerticalGroup(
            graficaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(graficaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(graficaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
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
        switch(algoritmoBox.getSelectedItem().toString()){
            case "Bubble Sort":
                new Thread(() -> {
                burbuja.ordenar(datos, orden, velocidad, this);
                }).start();
                break;
            
        }
                
    }//GEN-LAST:event_confirmBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> {
        new MenuPrincipal(new BubbleSort()).setVisible(true);
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> algoritmoBox;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextField entradaTxt;
    private javax.swing.JPanel graficaPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> ordenBox;
    private javax.swing.JComboBox<String> velocidadBox;
    // End of variables declaration//GEN-END:variables
}
