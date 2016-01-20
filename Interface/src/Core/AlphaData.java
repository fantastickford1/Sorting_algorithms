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
    public SimpleDoubleProperty iteraciones;
    public SimpleIntegerProperty iteracionesR;

    public AlphaData(String metod,double comp,int compR, double iter, int iterR){
        this.metod = new SimpleStringProperty(metod);
        this.comparaciones = new SimpleDoubleProperty(comp);
        this.comparacionesR = new SimpleIntegerProperty(compR);
        this.iteraciones = new SimpleDoubleProperty(iter);
        this.iteracionesR = new SimpleIntegerProperty(iterR);
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

    public void setIteraciones(int iteraciones){ this.iteraciones.set(iteraciones);}
    public double getIteraciones(){
        return this.iteraciones.get();
    }

    public void setIteracionesReales(int iteracionesReales){ this.iteracionesR.set(iteracionesReales);}
    public int getIteracionesReales(){ return this.iteracionesR.get();}

}
