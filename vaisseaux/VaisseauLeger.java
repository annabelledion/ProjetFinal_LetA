package vaisseaux;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by DioAn1730700 on 2018-04-26.
 */
public class VaisseauLeger extends Vaisseaux {

    public VaisseauLeger(String nom) {
        this.type = "léger";
        this.nom = nom;
        this.quantiteMax = 10;
    }
}
