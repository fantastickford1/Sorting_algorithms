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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private TextArea textarea;
    @FXML private TableView table;
    @FXML private ChoiceBox<String> choice;
    @FXML TableColumn<AlphaData,String> columnMetodo;
    @FXML TableColumn<AlphaData,String> columnIntercambios;
    @FXML TableColumn<AlphaData,String> columnIntercambiosReales;
    @FXML TableColumn<AlphaData,String> columnComparaciones;
    @FXML TableColumn<AlphaData,String> columnComparacionesReales;


    private TableColumn metd, comp, compR, iter, iterR;

    //Sorting objects//
    Burbuja bubble;
    Merge mergeSort;
    InsercionYSeleccion insertion;
    Quicksort quickSort;
    //Objects//
    FileChooser fileChooser;
    File file;
    FileReader fr;
    BufferedReader br;
    Stage stage;
    ObservableList<AlphaData> datas = FXCollections.observableArrayList();
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

    double burbuja,merge,quicksort,insercion;
    double insercionIter,burbujaIter,quicksortIter,mergeIter;

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
        burbuja = (Math.pow(allInt.length,2)-allInt.length)/2;
        //double insercion = (Math.pow(allInt.length, 2) - allInt.length) / 4;
        //double merge = allInt.length * (Math.log(allInt.length));
        merge = allInt.length * (Math.log(allInt.length) / Math.log(2));
        quicksort = allInt.length * (Math.log(allInt.length));
        insercion=0;
        ////////////////////////////////////Intercambios////////////////////////////////
        insercionIter = 0;
        burbujaIter = Math.pow(allInt.length,2)/8;
        quicksortIter = Math.pow(allInt.length,2); //allInt.length * (Math.log(allInt.length)); //Peor caso
        mergeIter =  allInt.length * (Math.log(allInt.length) / Math.log(2));
        ////////////////////////////////////////////////////////////////////

        if(bandera) {//ES EL MEJOR CASO ORDENADO
            insercionIter = 0;
            //mergeIter=0;
            burbujaIter=0;
            quicksortIter = allInt.length;

            insercion =allInt.length;

        }else{// PERO CASO ORDENADO ARBITRARIAMENTE O INVERSAMENTE
            insercion = (Math.pow(allInt.length,2))/4;
            insercionIter = (Math.pow(allInt.length,2))/8;
        }


        datas.addAll(new AlphaData("Burbuja",burbuja,0,burbujaIter,0));
        datas.addAll(new AlphaData("Insercion",insercion,0,insercionIter,0));
        datas.addAll(new AlphaData("Merge",merge,0,mergeIter,0));
        datas.addAll(new AlphaData("Quicksort",quicksort,0,quicksortIter,0));

        columnMetodo.setCellValueFactory(cellData -> cellData.getValue().metodProperty());
        columnComparaciones.setCellValueFactory(cellData -> cellData.getValue().comparacionesProperty());
        columnComparacionesReales.setCellValueFactory(cellData -> cellData.getValue().comparacionesRProperty());
        columnIntercambios.setCellValueFactory(cellData -> cellData.getValue().intercambiosProperty());
        columnIntercambiosReales.setCellValueFactory(cellData -> cellData.getValue().intercambiosRProperty());
        table.setItems(datas);


    }

    @FXML private void sort(){
        allIntOrder = allInt;

        int comparacionesR = 0;

        bubble = new Burbuja();
        insertion = new InsercionYSeleccion();
        quickSort = new Quicksort();
        mergeSort = new Merge();

        if(choice.getValue() == "Burbuja"){
            bubble.burbuja(allIntOrder);
            comparacionesR = bubble.getComparaciones();
            //burbujaData.setComparacionesReales(comparacionesR);
            datas.addAll(new AlphaData("Burbuja",burbuja,comparacionesR,burbujaIter,bubble.getIntercambios()));
            System.out.println("Comparaciones de Burbuja: "+comparacionesR);
            System.out.println("Intercambios de burbuja: " +bubble.getIntercambios());
        }
        if(choice.getValue() == "Insercion"){
            //insertion.InsercionSort(allInt);
            allIntOrder = insertion.ordenarInsercion(allIntOrder);
            comparacionesR = insertion.getComparaciones();
            //insercionData.setComparacionesReales(comparacionesR);
            datas.addAll(new AlphaData("Insercion",insercion,comparacionesR,insercionIter,insertion.getIntercambios()));
            System.out.println("Comparaciones de Insercion: "+comparacionesR);
            System.out.println("Intercambios de Insercion: " +insertion.getIntercambios());
        }
        if(choice.getValue() == "Merge"){
            allIntOrder=mergeSort.merge_sort(allIntOrder);
            comparacionesR = mergeSort.getComparaciones();
            //mergeData.setComparacionesReales(comparacionesR);
            datas.addAll(new AlphaData("Merge",merge,comparacionesR,mergeIter,mergeSort.getIntercambios()));
            System.out.println("Comparaciones de Merge: "+comparacionesR);
            System.out.println("Intercambios de Merge: " +mergeSort.getIntercambios());

        }
        if(choice.getValue() == "Quicksort"){
            quickSort.quickSort(allIntOrder,0,allData.length-1);
            comparacionesR = quickSort.getComparaciones();
            //quickData.setComparacionesReales(comparacionesR);
            datas.addAll(new AlphaData("Quicksort",quicksort,comparacionesR,quicksortIter,quickSort.getIntercambios()));
            System.out.println("Comparaciones de QuickSOrt: "+comparacionesR);
            System.out.println("Intercambios de QuickSort " + quickSort.getIntercambios());

        }


        textarea.setText("");
        for (int w: allIntOrder) {
            textarea.appendText(String.valueOf(w) + "\n");
        }

        updateTable();

    }

    private void updateTable(){
        clearTable();

        columnMetodo.setCellValueFactory(cellData -> cellData.getValue().metodProperty());
        columnComparaciones.setCellValueFactory(cellData -> cellData.getValue().comparacionesProperty());
        columnComparacionesReales.setCellValueFactory(cellData -> cellData.getValue().comparacionesRProperty());
        columnIntercambios.setCellValueFactory(cellData -> cellData.getValue().intercambiosProperty());
        columnIntercambiosReales.setCellValueFactory(cellData -> cellData.getValue().intercambiosRProperty());

        table.setItems(datas);

    }

    private boolean clearTable(){
        datas.removeAll();
        table.setItems(datas);

        return true;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choice.getItems().addAll("Burbuja","Insercion","Merge","Quicksort");

        //table.getColumns().addAll(metd, comp, compR, iter, iterR);
    }

}
