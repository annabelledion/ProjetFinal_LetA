package planetes;

import dechets.*;
import vaisseaux.Vaisseaux;
import utile.AttXML;

/**
 * Created by DioAn1730700 on 2018-04-26.
 */
public class PlaneteJaune extends Planete {

    public PlaneteJaune() {
        this.type = "jaune";
        this.nom = "Tatooine";
    }
    public void charger(Vaisseaux v) {
        super.charger(v);

        int matiere = 0;

        int probGado = AttXML.getJauneProbGado();
        int probPluto = AttXML.getJauneProbPluto();
        int probNeptu = AttXML.getJauneProbNeptu();
        int probTerbi = AttXML.getJauneProbTerbi();
        int probThuli = AttXML.getJauneProbThuli();

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
