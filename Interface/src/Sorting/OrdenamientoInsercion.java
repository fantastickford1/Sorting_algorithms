package Sorting;

import java.util.*;
public class OrdenamientoInsercion{

    long iterador = 0;

    /*public static void main(String[] args) {
        int aux[] = new int [6];
        OrdenamientoInsercion orden = new OrdenamientoInsercion();
        int[] array = {23,42,4,16,8,15};
        aux = orden.ordenarInsercion(array);

        System.out.println("Array final");
        for(int a=0;a<aux.length;a++){
                System.out.print(aux[a]+",");
            }

        
       
        
    }*/



    public int[] ordenarInsercion(int[] array){     
        int aux;
        int x=0;
        int j;
        for (int i = 1; i < array.length; i++) {
            aux = array[i];
            j = i;
            while ( j > 0 && array[j-1] > aux) {
                array[j]=array[j-1];
                j = j-1;
                array[j]=aux;
            }
            System.out.println("Orden actual:\n");
            for(int a=0;a<array.length;a++){
                System.out.print(array[a]+",");
            }
            System.out.println();
            
        }
        //System.out.println("iteerador: " + x);
        return array;

    }

    /*public int[] PeorCaso(){

        int peorcaso[] = new int [1000];
         for (int x = 0; x <1000; x++) {
             peorcaso[x]= 1000 - x;
         }
        return peorcaso;
    }

    public int[] mejorCaso(){
        int mejorcaso[] = new int [1000];
         for (int x = 0; x <1000; x++) {
             mejorcaso[x]= x+1; 
         }
        return mejorcaso;
    }

    public int[] casoPromedio(){
        Random rnd = new Random();
        int casopromedio[] = new int [1000];
         for (int x = 0; x <1000; x++) {
             casopromedio[x]= rnd.nextInt(1000); 
         }
        return casopromedio;
    }*/
}