package Sorting;

import java.util.*;
public class InsercionYSeleccion{

    int comparaciones = 1;
    int intercambios=0;
    long TInicio, TFin, tiempo;

    public int[] ordenarInsercion(int[] array) {
        int aux;
        int x = 0;
        int j;
        for (int i = 1; i < array.length; i++) {
            aux = array[i];
            j = i;
            comparaciones++;
            while (j > 0 && array[j - 1] > aux) {
                comparaciones++;
                array[j] = array[j - 1];
                intercambios++;
                j = j - 1;
                array[j] = aux;
            }



        }
        return array;
    }



    public int getComparaciones() {
        return this.comparaciones;
    }

    public int getIntercambios(){
        return this.intercambios;
    }
}