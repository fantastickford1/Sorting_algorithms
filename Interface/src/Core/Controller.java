package Core;

import Sorting.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    Burbuja bubble;
    Merge mergeSort;
    OrdenamientoInsercion insertion;
    FileChooser fileChooser;
    File file;
    FileReader fr;
    BufferedReader br;
    Stage stage;

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
        String text;
        String all = "";
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            while ((text = br.readLine()) != null){
                all = all + text;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(all);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
