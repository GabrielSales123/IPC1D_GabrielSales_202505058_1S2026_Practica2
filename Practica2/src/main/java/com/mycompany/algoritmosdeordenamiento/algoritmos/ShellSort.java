

package com.mycompany.algoritmosdeordenamiento.algoritmos;
import com.mycompany.algoritmosdeordenamiento.modelo.*;
import com.mycompany.algoritmosdeordenamiento.vista.*;


public class ShellSort {
    public void ordenar(int[] datos, boolean orden, int velocidad, MenuPrincipal vista, Estadisticas est) {
        est.reiniciar();
        int[] estados = new int[datos.length];
        try {
            for (int sal = datos.length / 2; sal > 0; sal /= 2) {
                est.sumarIteracion();
                vista.actualizarEstadisticas(est);
                for (int i = sal; i < datos.length; i++) {
                    int temp = datos[i];
                    int j = i;
                    while (j >= sal && 
                          ((orden && datos[j - sal] > temp) || 
                          (!orden && datos[j - sal] < temp))) {
                         est.sumarComparacion();
                         vista.actualizarEstadisticas(est);
                        for (int k = 0; k < estados.length; k++) {
                            if (estados[k] != 3) estados[k] = 0;
                        }
                        estados[j] = 1;
                        estados[j - sal] = 1;
                        est.sumarIntercambio();
                        vista.actualizarEstadisticas(est);
                        vista.actualizarGrafica(datos, estados);
                        Thread.sleep(velocidad);

                        estados[j] = 2;
                        estados[j - sal] = 2;
                        datos[j] = datos[j - sal];
                        vista.actualizarGrafica(datos, estados);
                        Thread.sleep(velocidad);
                        j -= sal;
                    }

                    datos[j] = temp;
                    vista.actualizarGrafica(datos, estados);
                    Thread.sleep(velocidad);
                }
            }

            for (int i = 0; i < estados.length; i++) {
                estados[i] = 3;
            }
            vista.actualizarGrafica(datos, estados);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
