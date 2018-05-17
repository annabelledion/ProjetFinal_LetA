package planetes;

import dechets.*;
import vaisseaux.Vaisseaux;
import utile.AttXML;

/**
 * Created by DioAn1730700 on 2018-04-26.
 */
public class PlaneteNoir extends Planete {

    public PlaneteNoir() {
        this.type = "noir";
        this.nom = "Endor";
    }
    public void charger(Vaisseaux v) {
        super.charger(v);

        int matiere = 0;

        int probGado = AttXML.getNoirProbGado();
        int probPluto = AttXML.getNoirProbPluto();
        int probNeptu = AttXML.getNoirProbNeptu();
        int probTerbi = AttXML.getNoirProbTerbi();
        int probThuli = AttXML.getNoirProbThuli();

        for (int i=0; i<v.getQuantiteMax(); i++){
            matiere = (int) (Math.random()*100);
            if (matiere < probGado){
                v.getMatiere().add(new Gadolinium());
            }
            else if (matiere >= probGado && matiere < probGado + probNeptu){
                v.getMatiere().add(new Neptunium());
            }
            else if (matiere >= probGado + probNeptu && matiere < probGado + probNeptu + probPluto){
                v.getMatiere().add(new Neptunium());
            }
            else if (matiere >= probGado + probNeptu + probPluto && matiere < probGado + probNeptu + probPluto + probTerbi){
                v.getMatiere().add(new Terbium());
            }
            else if (matiere >= probGado + probNeptu + probPluto + probTerbi && matiere < probGado + probNeptu + probPluto + probTerbi + probThuli){
                v.getMatiere().add(new Thulium());
            }
        }
    }
}
