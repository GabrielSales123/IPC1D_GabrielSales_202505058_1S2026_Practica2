
package com.mycompany.algoritmosdeordenamiento.algoritmos;
import com.mycompany.algoritmosdeordenamiento.modelo.*;
import com.mycompany.algoritmosdeordenamiento.vista.*;


public class QuickSort {
   
    public void ordenar(int[] datos, int prim, int ult, boolean orden, int velocidad, MenuPrincipal vista, Estadisticas est){
        
        if(prim < ult){
            est.sumarIteracion();
            vista.actualizarEstadisticas(est);
            int pivo = particion(datos, prim, ult, orden, velocidad, vista, est);
            ordenar(datos, prim, pivo-1, orden, velocidad, vista, est);
            ordenar(datos, pivo+1, ult, orden, velocidad, vista, est);
            int[] estados = new int[datos.length];
            for (int i = 0; i < estados.length; i++) {
            estados[i] = 3;
        }
        vista.actualizarGrafica(datos, estados);

        }
    }
    
    public int particion(int[] datos, int prim, int ult, boolean orden, int velocidad, MenuPrincipal vista, Estadisticas est){
        int pivote = datos[ult];
        int i = prim - 1;
        
        int[] estados = new int[datos.length];
        try{
        for (int j = prim; j < ult; j++){
            for (int k = 0; k < estados.length; k++) {
            if (estados[k] != 3) {
                estados[k] = 0;
            }
        }
            
            estados[j] = 1;
            estados[ult] = 1; // pivote también
            vista.actualizarGrafica(datos, estados);
            Thread.sleep(velocidad);

            if (orden == true){
            est.sumarComparacion();
            vista.actualizarEstadisticas(est);
            if(datos[j] < pivote){
                i++;
                
                estados[i] = 2;
                estados[j] = 2;
                est.sumarIntercambio();
                vista.actualizarEstadisticas(est);
                int aux = datos[i];
                datos[i] = datos[j];
                datos[j] = aux;
                vista.actualizarGrafica(datos, estados);
                Thread.sleep(velocidad);
            }
            }
            else{
               est.sumarComparacion();
               vista.actualizarEstadisticas(est);
               if(datos[j] > pivote){
                i++;
                estados[i] = 2;
                estados[j] = 2;
                est.sumarIntercambio();
                vista.actualizarEstadisticas(est);
                int aux = datos[i];
                datos[i] = datos[j];
                datos[j] = aux;
                vista.actualizarGrafica(datos, estados);
                Thread.sleep(velocidad);
            } 
            }
        }
        estados[ult] = 2;
        estados[i + 1] = 2;
        int aux = datos[i+1];
        datos[i+1] = datos[ult];
        datos[ult] = aux;
        est.sumarIntercambio();
        vista.actualizarEstadisticas(est);
        vista.actualizarGrafica(datos, estados);
        Thread.sleep(velocidad);
        estados[i + 1] = 3;
        vista.actualizarGrafica(datos, estados);
        
    }
        catch(InterruptedException e){
                 e.printStackTrace();
    }
    return i+1;
}
    
}
