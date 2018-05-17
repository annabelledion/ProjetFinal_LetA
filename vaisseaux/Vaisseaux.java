package vaisseaux;

import dechets.Dechets;
import utile.EcritureFichier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by DioAn1730700 on 2018-04-26.
 */
public class Vaisseaux implements Serializable {

    protected String type;
    protected String nom;
    protected int quantiteMax;
    protected ArrayList<Dechets> matiere = new ArrayList<>();
    protected String statut;
    protected int gadoli;
    protected int neptu;
    protected int pluto;
    protected int terbi;
    protected int thuli;
    protected int centreActu =0;

    public int getCentreActu() {
        return centreActu;
    }

    public void setCentreActu(int centreActu) {
        this.centreActu = centreActu;
    }
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
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
    public int getQuantiteMax() {
        return quantiteMax;
    }
    public void setQuantiteMax(int quantiteMax) {
        this.quantiteMax = quantiteMax;
    }
    public ArrayList<Dechets> getMatiere() {
        return matiere;
    }
    public void setMatiere(ArrayList<Dechets> matiere) {
        this.matiere = matiere;
    }

        public static void algo(ArrayList<Dechets> liste) {
        //plus lourd au plus léger
            Dechets matiere = null;
            int index;
            for (int i = 0; i < liste.size(); i++) {
                matiere = liste.get(i);
                index = i;
                for (int j = i; j < liste.size(); j++) {
                    if (liste.get(j).compareTo(liste.get(index)) < 0) {
                        matiere = liste.get(j);
                        index = j;
                    }
                }
                liste.remove(index);
                liste.add(i, matiere);

                //Collections.sort(matiere);
            }
        }
    public  void afficher(){

        for (Dechets d : matiere) {
            if (d.getType().equals("Gadolinium")){
                gadoli++;
            }
            else if (d.getType().equals("Neptunium")){
                neptu++;
            }
            else if (d.getType().equals("Plutonium")){
                pluto++;
            }
            else if (d.getType().equals("Terbium")){
                terbi++;
            }
            else if (d.getType().equals("Thulium")){
                thuli++;
            }
        }
        if (matiere.size() == 0){
            EcritureFichier.affichageSimulation("Le " + nom + " est déchargé");
            EcritureFichier.affichageSimulation("\n");
        }else {
            EcritureFichier.affichageSimulation("Le " + nom + " est chargé de : ");
            EcritureFichier.affichageSimulation("Gadolinium : " + gadoli);
            EcritureFichier.affichageSimulation("Neptunium : " + neptu);
            EcritureFichier.affichageSimulation("Plutonium : " + pluto);
            EcritureFichier.affichageSimulation("Terbium : " + terbi );
            EcritureFichier.affichageSimulation("Thulium : " + thuli );


        }
    }
    public void decharger(){
        gadoli = 0;
        neptu = 0;
        pluto = 0;
        terbi = 0;
        thuli = 0;
        matiere.clear();
    }
}


