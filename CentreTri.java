import dechets.*;
import utile.AttXML;
import utile.EcritureFichier;
import vaisseaux.Vaisseaux;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by DioAn1730700 on 2018-04-26.
 */
public class CentreTri implements Serializable{

    protected int matrecyclage;
    protected Queue<Vaisseaux> attente = new LinkedList<>();
    protected Stack<Dechets> pileNep = new Stack<>();
    protected Stack<Dechets> pilePluto = new Stack<>();
    protected Stack<Dechets> pileTerbi = new Stack<>();
    protected Stack<Dechets> pileThul = new Stack<>();
    protected Stack<Dechets> pileGado = new Stack<>();
    protected String nom;
    //à changer au besoin
    public static int attenteMax = 5;

    public Stack<Dechets> getPileNep() {
        return pileNep;
    }

    public void setPileNep(Stack<Dechets> pileNep) {
        this.pileNep = pileNep;
    }

    public Stack<Dechets> getPilePluto() {
        return pilePluto;
    }

    public void setPilePluto(Stack<Dechets> pilePluto) {
        this.pilePluto = pilePluto;
    }

    public Stack<Dechets> getPileTerbi() {
        return pileTerbi;
    }

    public void setPileTerbi(Stack<Dechets> pileTerbi) {
        this.pileTerbi = pileTerbi;
    }

    public Stack<Dechets> getPileThul() {
        return pileThul;
    }

    public void setPileThul(Stack<Dechets> pileThul) {
        this.pileThul = pileThul;
    }

    public Stack<Dechets> getPileGado() {
        return pileGado;
    }

    public void setPileGado(Stack<Dechets> pileGado) {
        this.pileGado = pileGado;
    }
    public Queue<Vaisseaux> getAttente() {return attente;}

    public void setAttente(Queue<Vaisseaux> attente) {this.attente = attente;}

    public CentreTri(String nom) {
        this.nom = nom;
    }

    public int getMatrecyclage() {
        return matrecyclage;
    }

    public void setMatrecyclage(int matrecyclage) {
        this.matrecyclage = matrecyclage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static boolean neptu = true;
    public static boolean pluto = true;
    public static boolean gado = true;
    public static boolean terbi = true;
    public static boolean thuli = true;
    public static boolean exception = true;


    public void déchargeDechets(Vaisseaux vaisseaux)
            throws Exceptions.ListeVideCentreTris, Exceptions.DernierCentreTris, Exceptions.CentreTrisPlein{

        //à changer au besoin
        int nbMax = 1000;

        for(int i = 0; i < vaisseaux.getMatiere().size(); i++){

            if (vaisseaux.getMatiere().get(i).getType().equals("Gadolinium") && gado == true){
                    if (pileGado.size()<nbMax){
                        pileGado.add(new Gadolinium());
                    }
                    else {
                        EcritureFichier.affichageSimulation("La pile de Gadolinium est pleine");
                        gado = false;
                        if (attente.size() == 0) {
                            throw new Exceptions.ListeVideCentreTris();
                        }
                        else {
                            recycler(pileGado, AttXML.getGadoRecyc(), attente.poll());
                        } } }
            else if (vaisseaux.getMatiere().get(i).getType().equals("Neptunium") && neptu== true){
                if (pileNep.size()<nbMax){
                    pileNep.add(new Neptunium());
                }else {
                    EcritureFichier.affichageSimulation("La pile de Neptunium est pleine");
                    neptu = false;

                    if (attente.size() == 0) {
                        throw new Exceptions.ListeVideCentreTris();
                    }
                    else {
                        recycler(pileNep, AttXML.getNeptuRecyc(), attente.poll());
                    } } }
            else if (vaisseaux.getMatiere().get(i).getType().equals("Plutonium") && pluto == true){
                if (pilePluto.size()<nbMax){
                    pilePluto.add(new Plutonium());
                }
                else {
                    EcritureFichier.affichageSimulation("La pile de Plutonium est pleine");
                    pluto =false;
                    if (attente.size() == 0) {
                        throw new Exceptions.ListeVideCentreTris();
                    }
                    else {
                        recycler(pilePluto, AttXML.getPlutoRecyc(), attente.poll());
                    } } }
            else if (vaisseaux.getMatiere().get(i).getType().equals("Terbium") && terbi == true){
                if (pileTerbi.size()<nbMax){
                    pileTerbi.add(new Terbium());
                }
                else {
                    EcritureFichier.affichageSimulation("La pile de Terbium est pleine");
                    terbi = false;
                    if (attente.size() == 0) {
                        throw new Exceptions.ListeVideCentreTris();
                    }
                    else {
                        recycler(pileTerbi, AttXML.getTerbiRecyc(), attente.poll());
                    } } }
            else if (vaisseaux.getMatiere().get(i).getType().equals("Thulium") && thuli == true){
                if (pileThul.size()<nbMax){
                    pileThul.add(new Thulium());
                }
                else {
                    EcritureFichier.affichageSimulation("La pile de Thulium est pleine");
                    thuli = false;
                    if (attente.size() == 0) {
                        throw new Exceptions.ListeVideCentreTris();
                    }
                    else {
                        recycler(pileThul, AttXML.getThuliRecyc(), attente.poll());
                    } } }
            if (i == (vaisseaux.getMatiere().size()-1)){
                vaisseaux.decharger();
                if (attente.size() == attenteMax){
                    attente.peek().setCentreActu(attente.peek().getCentreActu() + 1);
                    EcritureFichier.affichageSimulation("Vaisseau de la liste d'attente envoyé sur une nouvelle planète");
                    EcritureFichier.affichageSimulation("\n");
                    Simulation.envoie(attente.poll());

                    attente.add(vaisseaux);

                } else {
                    attente.add(vaisseaux);
                }
            }
        }
    }
    public void recycler(Stack<Dechets> p, int recyc, Vaisseaux vaisseaux)
                throws Exceptions.DernierCentreTris, Exceptions.ListeVideCentreTris, Exceptions.CentreTrisPlein{


        EcritureFichier.affichageSimulation("Appel d'un vaisseau en attente: " + vaisseaux.getNom());
        EcritureFichier.affichageSimulation("\n");

        int pourcentage = (((recyc*p.size())/100));
        for (int i=0; i<pourcentage; i++){
            vaisseaux.getMatiere().add(p.pop());
        }
        vaisseaux.setCentreActu(vaisseaux.getCentreActu()+1);
        Simulation.envoieRecyclage(vaisseaux);

        }


    public void afficher(){

        EcritureFichier.affichageSimulation("Vaisseaux en attente d'un départ : " + attente.size());
        EcritureFichier.affichageSimulation(nom);
        EcritureFichier.affichageSimulation(pileGado.size() + " Gadolinium");
        EcritureFichier.affichageSimulation(pileNep.size() + " Neptunium");
        EcritureFichier.affichageSimulation(pilePluto.size() + " Plutonium");
        EcritureFichier.affichageSimulation(pileTerbi.size() + " Terbium");
        EcritureFichier.affichageSimulation(pileThul.size() + " Thulium");
        EcritureFichier.affichageSimulation("\n");
        EcritureFichier.affichageSimulation("--------------------");
    }

    }



