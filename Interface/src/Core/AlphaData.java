package Core;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Karlos on 1/18/2016.
 */
public class AlphaData {

    public String getMetod() {
        return metod.get();
    }

    public StringProperty metodProperty() {
        return metod;
    }

    public String getComparaciones() {
        return comparaciones.get();
    }

    public StringProperty comparacionesProperty() {
        return comparaciones;
    }

    public String getComparacionesR() {
        return comparacionesR.get();
    }

    public StringProperty comparacionesRProperty() {
        return comparacionesR;
    }

    public String getIntercambios() {
        return intercambios.get();
    }

    public StringProperty intercambiosProperty() {
        return intercambios;
    }

    public String getIntercambiosR() {
        return intercambiosR.get();
    }

    public StringProperty intercambiosRProperty() {
        return intercambiosR;
    }

    public StringProperty metod;
    public StringProperty comparaciones;
    public StringProperty comparacionesR;
    public StringProperty intercambios;
    public StringProperty intercambiosR;

    public AlphaData(String metod,double comp,int compR, double iter, int iterR){
        this.metod = new SimpleStringProperty(metod);
        this.comparaciones = new SimpleStringProperty(""+comp);
        this.comparacionesR = new SimpleStringProperty(""+compR);
        this.intercambios = new SimpleStringProperty(""+iter);
        this.intercambiosR = new SimpleStringProperty(""+iterR);
    }



}
