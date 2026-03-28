
package com.mycompany.algoritmosdeordenamiento.principal;

import com.mycompany.algoritmosdeordenamiento.vista.*;
import com.mycompany.algoritmosdeordenamiento.algoritmos.*;

public class Main {
    public static void main(String[] args){
        BubbleSort burbuja = new BubbleSort();
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal(burbuja).setVisible(true);
        });
    }
}
