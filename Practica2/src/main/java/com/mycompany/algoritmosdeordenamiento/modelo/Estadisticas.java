
package com.mycompany.algoritmosdeordenamiento.modelo;

public class Estadisticas {
    
    private int comparaciones;
    private int intercambios;
    private int iteraciones;

    public void reiniciar() {
        comparaciones = 0;
        intercambios = 0;
        iteraciones = 0;
    }

    public void sumarComparacion() {
        comparaciones++;
    }

    public void sumarIntercambio() {
        intercambios++;
    }

    public void sumarIteracion() {
        iteraciones++;
    }

    public int getComparaciones() {
        return comparaciones;
    }

    public int getIntercambios() {
        return intercambios;
    }

    public int getIteraciones() {
        return iteraciones;
    }
    
}
