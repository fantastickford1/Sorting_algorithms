package Sorting;

import java.util.*;
public class InsercionYSeleccion{

    int comparaciones = 1;

    public void InsercionSort(int matriz[]){
        int i, temp, j;

        for (i= 1; i < matriz.length; i++){
            temp = matriz[i];
            j = i-1;

            while ((matriz[j] >temp) && (j>= 0 )){
                comparaciones++;
                matriz[j + 1] = matriz[j];
                j--;
            }

            matriz[j + 1] = temp;
        }
    }

    public void SeleccionSort(int[] matriz){
        int i, j, k, p, buffer, limit = matriz.length-1;

        for (k = 0; k <= limit; k++){

            p = k;

            for (i = k+1; k < limit; i++){
                if (matriz[i] < matriz[p]){
                    p = i;
                }
            }
            if (p != k){
                buffer = matriz[p];
                matriz[p] = matriz[k];
                matriz[k] = buffer;
            }
        }
    }

    public int getComparaciones() {
        return this.comparaciones;
    }
}