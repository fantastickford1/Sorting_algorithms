package Core;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Karlos on 1/18/2016.
 */
public class AlphaData {

    public SimpleStringProperty metod;
    public SimpleDoubleProperty comparaciones;
    public SimpleIntegerProperty comparacionesR;
    public SimpleIntegerProperty iteraciones;
    public SimpleIntegerProperty iteracionesR;

    public AlphaData(String metod,double comp){
        this.metod = new SimpleStringProperty(metod);
        this.comparaciones = new SimpleDoubleProperty(comp);
        this.comparacionesR = new SimpleIntegerProperty();
        this.iteraciones = new SimpleIntegerProperty();
        this.iteracionesR = new SimpleIntegerProperty();
    }

    public void setMetod(String name){
        this.metod.set(name);
    }

    public void setComparaciones(double comparaciones){
        this.comparaciones.set(comparaciones);
    }

    public void setComparacionesReales(int compR){ this.comparacionesR.set(compR);}

    public void setIteraciones(int iteraciones){ this.iteraciones.set(iteraciones);}

    public void setIteracionesReales(int iteracionesReales){ this.iteracionesR.set(iteracionesReales);}

    public String getMetod(){
        return this.metod.get();
    }

    public double getComparaciones(){
        return this.comparaciones.get();
    }

    public int getComparacionesReales(){ return this.comparacionesR.get();}

    public int getIteraciones(){
        return this.iteraciones.get();
    }

    public int getIteracionesReales(){ return this.iteracionesR.get();}

}
