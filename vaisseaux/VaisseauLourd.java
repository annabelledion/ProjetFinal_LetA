package vaisseaux;

import java.util.ArrayList;

/**
 * Created by DioAn1730700 on 2018-04-26.
 */
public class VaisseauLourd extends Vaisseaux{

    public VaisseauLourd(String nom) {
        this.type = "lourd";
        this.nom = nom;
        this.quantiteMax = 30;
    }
}
