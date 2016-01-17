package Sorting;

public class Burbuja{

	/*public static void main(String[] args) {
		int[] array = {6,3,8,12,5,0,9,4};
		Burbuja bur = new Burbuja();
		int[] array2= bur.burbuja(array);;
		for(int i=0;i<array2.length;i++)
			System.out.println(array2[i]);
	}*/

	public int[] burbuja(int [] A){
         int i, j, aux;
         for(i=0;i<A.length-1;i++){
              for(j=0;j<A.length-i-1;j++){
                   if(A[j+1]<A[j]){
                      aux=A[j+1];
                      A[j+1]=A[j];
                      A[j]=aux;
                   }
               }
         	}

         	return A;
	}
}