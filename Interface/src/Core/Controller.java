package Core;

import Sorting.*;
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

    @FXML
    TextArea textarea;
    @FXML
    TableView table;
    @FXML
    TableColumn tableColumnM,tableColumnOp,tableColumnIt,tableColumnIn;
    @FXML
    ChoiceBox<String> choice;

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
    }

    @FXML private void sort(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choice.getItems().addAll("Burbuja","Insercion","Merge","Quicksort");
    }

}
