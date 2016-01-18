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
    //Merge mergeSort;
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
    int[] allInt;

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
        complex();
    }

    private void complex(){
        double burbuja = Math.pow(allInt.length,2);
        double insercion = Math.pow(allInt.length,2)/4;
        double merge = allInt.length * (Math.log(allInt.length)/Math.log(2));
        double quicksort = Math.pow(allInt.length,2);
        double quicksortProm = allInt.length * (Math.log(allInt.length)/Math.log(1));

        burbujaData = new AlphaData("Burbuja",burbuja);
        insercionData = new AlphaData("Insercion",insercion);
        mergeData = new AlphaData("Merge",merge);
        quickData = new AlphaData("Quicksort",quicksort);


        datas = FXCollections.observableArrayList(
                burbujaData, insercionData,mergeData,quickData
        );

        metd.setCellValueFactory(
                new PropertyValueFactory<>("metod")
        );
        comp.setCellValueFactory(
                new PropertyValueFactory<>("comparaciones")
        );

        table.setItems(datas);

    }

    @FXML private void sort(){

        int comparacionesR = 0;

        bubble = new Burbuja();
        insertion = new InsercionYSeleccion();
        quicksort = new Quicksort();

       if(choice.getValue() == "Burbuja"){
           bubble.burbuja(allInt);
           comparacionesR = bubble.getComparaciones();
           burbujaData.setComparacionesReales(comparacionesR);
       }
        if(choice.getValue() == "Insercion"){
             insertion.InsercionSort(allInt);
            comparacionesR = insertion.getComparaciones();
            insercionData.setComparacionesReales(comparacionesR);
        }
        if(choice.getValue() == "Merge"){

        }
        if(choice.getValue() == "Quicksort"){
            quicksort.quickSort(allInt,0,allData.length-1);
            comparacionesR = quicksort.getComparaciones();
            quickData.setComparacionesReales(comparacionesR);
        }

        /*compR.setCellValueFactory(
                new PropertyValueFactory<>("comparacionesR")
        );

        table.setItems(datas);
        table.refresh();*/

        textarea.setText("");
        for (int w: allInt) {
            textarea.appendText(String.valueOf(w) + "\n");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choice.getItems().addAll("Burbuja","Insercion","Merge","Quicksort");

        metd = new TableColumn("Metodos");
        comp = new TableColumn("No.Comparaciones(Formula)");
        compR = new TableColumn("No. Comparaciones Reales");
        iter = new TableColumn("No. Iteraciones(Formula)");
        iterR = new TableColumn("No. Iteraciones Reales");


        table.getColumns().addAll(metd, comp, compR, iter, iterR);
    }

}
