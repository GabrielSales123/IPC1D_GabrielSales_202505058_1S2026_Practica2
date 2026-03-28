
package com.mycompany.algoritmosdeordenamiento.algoritmos;
import com.mycompany.algoritmosdeordenamiento.vista.*;

public class BubbleSort {
    public void ordenar(int[] datos, boolean orden, int velocidad, MenuPrincipal vista){
        int aux = 0;
        int[] estados = new int[datos.length];
        try{
            for (int i = 0; i < datos.length -1 ; i++){
                for (int j = 0; j < datos.length-1; j++){ 
                    for (int k = 0; k < estados.length; k++) {
                        if (estados[k] != 3) {
                            estados[k] = 0;
                        }
                    }
                    estados[j] = 1;
                    estados[j+1] = 1;
                    vista.actualizarGrafica(datos, estados);
                    Thread.sleep(velocidad);

                    if (orden == true){
                        if (datos[j] > datos[j+1]){
                            estados[j] = 2;
                            estados[j+1] = 2;
                            aux = datos[j];
                            datos[j] = datos[j+1];
                            datos[j+1] = aux;
                            vista.actualizarGrafica(datos, estados);
                            Thread.sleep(velocidad);  
                        }                        
                    }
                 
                    else{
                        if (datos[j] < datos[j+1]){
                            estados[j] = 2;
                            estados[j+1] = 2;
                            aux = datos[j];
                            datos[j] = datos[j+1];
                            datos[j+1] = aux; 
                            vista.actualizarGrafica(datos, estados);
                            Thread.sleep(velocidad);
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
    }
}
