package Sorting;

public class Burbuja{

    public int comparaciones = 0;
    public int intercambios=0;
    long TInicio, TFin, tiempo;

	public int[] burbuja(int [] A){
        TInicio = System.currentTimeMillis();
         int i, j, aux;
         for(i=0;i<A.length-1;i++){
              for(j=0;j<A.length-i-1;j++){
                  comparaciones++;
                   if(A[j+1]<A[j]){
                       intercambios++;
                      aux=A[j+1];
                      A[j+1]=A[j];
                      A[j]=aux;
                   }
              }
         }
        TFin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
        return A;
	}

    public int getComparaciones(){
        return this.comparaciones;
    }

    public int getIntercambios(){
        return this.intercambios;
    }

}