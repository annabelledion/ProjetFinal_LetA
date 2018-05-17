package vaisseaux;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by DioAn1730700 on 2018-04-26.
 */
public class VaisseauNormal extends Vaisseaux {

    public VaisseauNormal(String nom) {
        this.type = "normal";
        this.nom = nom;
        this.quantiteMax = 20;
    }
}
