package Sorting;

public class Quicksort{

  int comparaciones = 0;
  long TInicio, TFin, tiempo;

  public void quickSort(int arr[], int left, int right) {
    TInicio = System.currentTimeMillis();
    int index = partition(arr, left, right);
    if (left < index - 1)
      quickSort(arr, left, index - 1);
    if (index < right)
      quickSort(arr, index, right);
    TFin = System.currentTimeMillis();
    System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
  }

  private int partition(int arr[], int left, int right){
    int i = left, j = right;
    int tmp;
    int pivot = arr[(left + right) / 2];
    while (i <= j) {
      while (arr[i] < pivot)
        i++;
      while (arr[j] > pivot)
        j--;
      comparaciones++;
      if (i <= j) {
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
        j--;
      }
    }
    return i;
  }

    public int getComparaciones() {
        return this.comparaciones;
    }
}
