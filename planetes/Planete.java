package planetes;

import dechets.*;
import vaisseaux.Vaisseaux;

import java.io.Serializable;

/**
 * Created by DioAn1730700 on 2018-04-26.
 */
public class Planete implements Serializable{

    protected String type;
    protected String nom;
    protected int propPluto;
    protected int propThuli;
    protected int propGadoli;
    protected int propTerbi;
    protected int propNeptu;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPropPluto() {
        return propPluto;
    }

    public void setPropPluto(int propPluto) {
        this.propPluto = propPluto;
    }

    public int getPropThuli() {
        return propThuli;
    }

    public void setPropThuli(int propThuli) {
        this.propThuli = propThuli;
    }

    public int getPropGadoli() {
        return propGadoli;
    }

    public void setPropGadoli(int propGadoli) {
        this.propGadoli = propGadoli;
    }

    public int getPropTerbi() {
        return propTerbi;
    }

    public void setPropTerbi(int propTerbi) {
        this.propTerbi = propTerbi;
    }

    public int getPropNeptu() {
        return propNeptu;
    }

    public void setPropNeptu(int propNeptu) {
        this.propNeptu = propNeptu;
    }

    public void charger(Vaisseaux v){}


}
