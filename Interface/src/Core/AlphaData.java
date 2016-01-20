package Core;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Karlos on 1/18/2016.
 */
public class AlphaData {

    public SimpleStringProperty metod;
    public SimpleDoubleProperty comparaciones;
    public SimpleIntegerProperty comparacionesR;
    public SimpleDoubleProperty intercambios;
    public SimpleIntegerProperty intercambiosR;

    public AlphaData(String metod,double comp,int compR, double iter, int iterR){
        this.metod = new SimpleStringProperty(metod);
        this.comparaciones = new SimpleDoubleProperty(comp);
        this.comparacionesR = new SimpleIntegerProperty(compR);
        this.intercambios = new SimpleDoubleProperty(iter);
        this.intercambiosR = new SimpleIntegerProperty(iterR);
    }

    public void setMetod(String name){
        this.metod.set(name);
    }
    public String getMetod(){
        return this.metod.get();
    }

    public void setComparaciones(double comparaciones){
        this.comparaciones.set(comparaciones);
    }
    public double getComparaciones(){
        return this.comparaciones.get();
    }

    public void setComparacionesReales(int compR){ this.comparacionesR.set(compR);}
    public int getComparacionesReales(){ return this.comparacionesR.get();}

    public void setIntercambios(int intercambios){ this.intercambios.set(intercambios);}
    public double getIntercambios(){
        return this.intercambios.get();
    }

    public void setIntercambiosReales(int iteracionesReales){ this.intercambiosR.set(iteracionesReales);}
    public int getIntercambiosReales(){ return this.intercambiosR.get();}



}
