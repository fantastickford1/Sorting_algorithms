package Sorting;


import java.util.Arrays;
public class Merge{
	private int comparaciones = 0;
	int intercambios=0;
	long TInicio, TFin, tiempo;



	public int[] merge_sort(int[] arreglo){
		//Si lista esta vacía o de tamaño 1 ya está ordenada. Se devuelve lista tal cual
		TInicio = System.currentTimeMillis();

		if(arreglo.length <= 1){
			return arreglo;
		}else{
			int medio = arreglo.length/2;
			//Se crean dos arreglos para almacenar
			int[] tempA = new int[medio];
			int[] tempB = new int[arreglo.length-medio];
			int index=0;
			for (int i=0;i<arreglo.length ; i++ ) {
				if(i<medio){
					tempA[i] = arreglo[i];
				}else{
					tempB[index++] = arreglo[i];
				}
			}
			int[] izq = merge_sort(tempA);
			int[] der = merge_sort(tempB);
			TFin = System.currentTimeMillis();
			System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
			return merge(izq, der);
		}
	}

	public int[] merge(int[] izq, int[] der){
		int i = 0; //indice izq
		int j = 0; //indece der
		int index =0;
		int[] resultado = new int[izq.length+der.length];
		while(i<izq.length && j<der.length){

			intercambios++;
			if(izq[i] < der[j]){
				resultado[index++] = izq[i++];
				//i++;
			}else{
				resultado[index++] = der[j++];
			}
			comparaciones++;
		}
		while( i<izq.length ){    // Copia el resto de la mitad izq
			resultado[ index++] = izq[ i++];
			comparaciones++;
			intercambios++;
		}
		while( j<der.length){ //Copia el resto de la mitad der
			resultado[ index++] = der[ j++ ];
			comparaciones++;
			intercambios++;
		}
		return resultado;

	}


	public int getComparaciones() {
		return this.comparaciones;
	}

	public int getIntercambios(){
		return this.comparaciones;
	}
}

