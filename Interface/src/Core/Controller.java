package Core;

import Sorting.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextArea textarea;
    @FXML
    private TableView table;
    @FXML
    private ChoiceBox<String> choice;

    private TableColumn metd, comp, compR, iter, iterR;

    //Sorting objects//
    Burbuja bubble;
    Merge mergeSort;
    InsercionYSeleccion insertion;
    Quicksort quicksort;
    //Objects//
    FileChooser fileChooser;
    File file;
    FileReader fr;
    BufferedReader br;
    Stage stage;
    ObservableList<AlphaData> datas;
    AlphaData burbujaData;
    AlphaData insercionData;
    AlphaData mergeData;
    AlphaData quickData;

    //data//
    String line;
    String data;
    String[] allData;
    boolean bandera;
    int[] allInt;
    int[] allIntOrder;

    private boolean ordenamiento(int[] array){

        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                System.out.println("El arreglo esta desordenado");
                return false;
            }
        }
        System.out.println("El arreglo esta ordenado ascendentemente 1...10");
        return true;
    }

    @FXML private void openFile(){
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT","*.txt")
        );
        file = fileChooser.showOpenDialog(stage);
        if (file != null){
            ReadFile(file);
        }
    }

    private void ReadFile(File file){
        data = "";
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null){
                data += line + ",";
            }

            allData = data.split(",");
            allInt = new int[allData.length];
            int a = 0;
            for (String sw: allData) {
                allInt[a] = Integer.parseInt(sw);
                a++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textarea.setEditable(false);
        textarea.setText("");
        for (int w: allInt) {
            textarea.appendText(String.valueOf(w) + "\n");
        }
        bandera = ordenamiento(allInt);
        complex();

    }

    private void complex(){
        ////////////////////////////////Comparaciones//////////////////////////////////////
        double burbuja = (Math.pow(allInt.length,2)-allInt.length)/2;
        //double insercion = (Math.pow(allInt.length, 2) - allInt.length) / 4;
        //double merge = allInt.length * (Math.log(allInt.length));
        double merge = allInt.length * (Math.log(allInt.length) / Math.log(2));
        double quicksort = allInt.length * (Math.log(allInt.length));
        double insercion=0;
        ////////////////////////////////////Intercambios////////////////////////////////
        double insercionIter = 0;
        double quicksortIter = Math.pow(allInt.length,2); //allInt.length * (Math.log(allInt.length)); //Peor caso
        double mergeIter = allInt.length * (Math.log(allInt.length));
        ////////////////////////////////////////////////////////////////////

        if(bandera) {//ES EL MEJOR CASO ORDENADO
            insercionIter = allInt.length;
            insercion =allInt.length;

        }else{// PERO CASO ORDENADO ARBITRARIAMENTE O INVERSAMENTE
            insercion = (Math.pow(allInt.length,2))/4;
            insercionIter = (Math.pow(allInt.length,2))/8;
        }


        burbujaData = new AlphaData("Burbuja",burbuja,0,burbuja,0);
        insercionData = new AlphaData("Insercion",insercion,0,insercionIter,0);
        mergeData = new AlphaData("Merge",merge,0,mergeIter,0);
        quickData = new AlphaData("Quicksort",quicksort,0,quicksortIter,0);


        datas = FXCollections.observableArrayList(
                burbujaData, insercionData,mergeData,quickData
        );

        metd.setCellValueFactory(
                new PropertyValueFactory<>("metod")
        );
        comp.setCellValueFactory(
                new PropertyValueFactory<>("comparaciones")
        );
        compR.setCellValueFactory(
                new PropertyValueFactory<>("comparacionesR")
        );
        iter.setCellValueFactory(
                new PropertyValueFactory<>("intercambios")
        );
        iterR.setCellValueFactory(
                new PropertyValueFactory<>("intercambiosR")
        );

        table.setItems(datas);

    }

    @FXML private void sort(){

        allIntOrder = allInt;

        int comparacionesR = 0;

        bubble = new Burbuja();
        insertion = new InsercionYSeleccion();
        quicksort = new Quicksort();
        mergeSort = new Merge();

        if(choice.getValue() == "Burbuja"){
            bubble.burbuja(allIntOrder);
            comparacionesR = bubble.getComparaciones();
            burbujaData.setComparacionesReales(comparacionesR);
            System.out.println("Comparaciones de Burbuja: "+comparacionesR);
            System.out.println("Intercambios de burbuja: " +bubble.getIntercambios());
        }
        if(choice.getValue() == "Insercion"){
            //insertion.InsercionSort(allInt);
            allIntOrder = insertion.ordenarInsercion(allIntOrder);
            comparacionesR = insertion.getComparaciones();
            insercionData.setComparacionesReales(comparacionesR);
            System.out.println("Comparaciones de Insercion: "+comparacionesR);
            System.out.println("Intercambios de Insercion: " +insertion.getIntercambios());
        }
        if(choice.getValue() == "Merge"){
            allIntOrder=mergeSort.merge_sort(allIntOrder);
            comparacionesR = mergeSort.getComparaciones();
            mergeData.setComparacionesReales(comparacionesR);
            System.out.println("Comparaciones de Merge: "+comparacionesR);
            System.out.println("Intercambios de Merge: " +mergeSort.getIntercambios());

        }
        if(choice.getValue() == "Quicksort"){
            quicksort.quickSort(allIntOrder,0,allData.length-1);
            comparacionesR = quicksort.getComparaciones();
            quickData.setComparacionesReales(comparacionesR);
            System.out.println("Comparaciones de QuickSOrt: "+comparacionesR);
            System.out.println("Intercambios de QuickSort " +quicksort.getIntercambios());

        }

        //////////////////////////////////////////////////////////
        table.getItems().clear();
        datas.removeAll();

        datas = FXCollections.observableArrayList(
                burbujaData, insercionData,mergeData,quickData
        );

        metd.setCellValueFactory(
                new PropertyValueFactory<>("metod")
        );
        comp.setCellValueFactory(
                new PropertyValueFactory<>("comparaciones")
        );
        compR.setCellValueFactory(
                new PropertyValueFactory<>("comparacionesR")
        );
        iter.setCellValueFactory(
                new PropertyValueFactory<>("intercambios")
        );
        iterR.setCellValueFactory(
                new PropertyValueFactory<>("intercambiosR")
        );

        table.setItems(datas);

        ////////////////////////////////////////////////////////



        textarea.setText("");
        for (int w: allIntOrder) {
            textarea.appendText(String.valueOf(w) + "\n");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choice.getItems().addAll("Burbuja","Insercion","Merge","Quicksort");

        metd = new TableColumn("Métodos");
        comp = new TableColumn("No.Comparaciones(Fórmula)");
        compR = new TableColumn("No. Comparaciones Reales");
        iter = new TableColumn("No. Intercambios(Fórmula)");
        iterR = new TableColumn("No. Intercambios Reales");


        table.getColumns().addAll(metd, comp, compR, iter, iterR);
    }

}
