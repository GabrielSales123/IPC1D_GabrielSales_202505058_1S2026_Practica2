
package com.mycompany.algoritmosdeordenamiento.principal;

import com.mycompany.algoritmosdeordenamiento.vista.*;
import com.mycompany.algoritmosdeordenamiento.algoritmos.*;
import com.mycompany.algoritmosdeordenamiento.modelo.*;

public class Main {
    public static void main(String[] args){
        BubbleSort burbuja = new BubbleSort();
        QuickSort quick = new QuickSort();
        ShellSort shell = new ShellSort();
        Estadisticas est = new Estadisticas();
        Reportes rep = new Reportes();
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal(burbuja, quick, shell, est, rep).setVisible(true);
        });
    }
}
