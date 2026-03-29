
package com.mycompany.algoritmosdeordenamiento.algoritmos;
import com.mycompany.algoritmosdeordenamiento.vista.*;
import com.mycompany.algoritmosdeordenamiento.modelo.*;

public class BubbleSort {
    private int contiempo = 0;
    
    public int setTiempo(int contTiempo){
        this.contiempo = contTiempo;
        return contTiempo;
    }
    
    public int getTiempo(){
        return contiempo;
    }
    
    public void ordenar(int[] datos, boolean orden, int velocidad, 
            MenuPrincipal vista, Estadisticas est, int contiempo){
        est.reiniciar();
        int aux = 0;
        int[] estados = new int[datos.length];
        try{
            for (int i = 0; i < datos.length -1 ; i++){
                est.sumarIteracion();
                vista.mostrarConsola("----Iteracion: "+(i+1)+"----");
                vista.actualizarEstadisticas(est);
                for (int j = 0; j < datos.length-1; j++){ 
                    est.sumarComparacion();
                    vista.mostrarConsola("Comparando datos["+i+"]="+datos[i]+" y "+"datos["+j+"]="+datos[j]);
                    vista.actualizarEstadisticas(est);
                    for (int k = 0; k < estados.length; k++) {
                        if (estados[k] != 3) {
                            estados[k] = 0;
                        }
                    }
                    estados[j] = 1;
                    estados[j+1] = 1;
                    vista.actualizarGrafica(datos, estados);
                    Thread.sleep(velocidad);
                    contiempo += velocidad;

                    if (orden == true){
                        if (datos[j] > datos[j+1]){
                            estados[j] = 2;
                            estados[j+1] = 2;
                            vista.mostrarConsola("Intercambiando: "+datos[j]+" y "+datos[j+1]);
                            aux = datos[j];
                            datos[j] = datos[j+1];
                            datos[j+1] = aux;
                            est.sumarIntercambio();
                            vista.actualizarEstadisticas(est);
                            vista.actualizarGrafica(datos, estados);
                            Thread.sleep(velocidad);
                            contiempo += velocidad;
                        }                        
                    }
                 
                    else{
                        if (datos[j] < datos[j+1]){
                            estados[j] = 2;
                            estados[j+1] = 2;
                            vista.mostrarConsola("Intercambiando: "+datos[j]+" y "+datos[j+1]);
                            aux = datos[j];
                            datos[j] = datos[j+1];
                            datos[j+1] = aux; 
                            est.sumarIntercambio();
                            vista.actualizarEstadisticas(est);
                            vista.actualizarGrafica(datos, estados);
                            Thread.sleep(velocidad);
                            contiempo += velocidad;
                        }                
                    }  
                }
             estados[datos.length - 1 - i] = 3;
             vista.actualizarGrafica(datos, estados);  
            }
                for (int i = 0; i < estados.length; i++) {
                estados[i] = 3;
                }
            vista.actualizarGrafica(datos, estados);
        
             }catch(InterruptedException e){
                 e.printStackTrace();
        }
        vista.mostrarConsola("Ordenamiento Completado en: "+contiempo+"ms");
        setTiempo(contiempo);
    }
    
}
