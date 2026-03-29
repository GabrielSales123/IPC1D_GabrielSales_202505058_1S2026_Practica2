
package com.mycompany.algoritmosdeordenamiento.modelo;

import java.io.FileWriter;
import java.util.*;

public class Reportes {
    
    public void generarReporte(String algoritmo, String orden,
                             int[] original, int[] ordenado,
                             Estadisticas est, int tiempo) {

        try {
            FileWriter writer = new FileWriter("reporte.html");

            writer.write("<html><body>");
            writer.write("<h1>Reporte</h1>");

            writer.write("<p>Algoritmo: " + algoritmo + "</p>");
            writer.write("<p>Orden: " + orden + "</p>");
            writer.write("<p>Original: " + Arrays.toString(original) + "</p>");
            writer.write("<p>Ordenado: " + Arrays.toString(ordenado) + "</p>");

            writer.write("<p>Comparaciones: " + est.getComparaciones() + "</p>");
            writer.write("<p>Intercambios: " + est.getIntercambios() + "</p>");
            writer.write("<p>Iteraciones: " + est.getIteraciones() + "</p>");
            writer.write("<p>Tiempo: " + tiempo + " ms</p>");

            writer.write("</body></html>");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
