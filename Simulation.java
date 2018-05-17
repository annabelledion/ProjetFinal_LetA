import org.xml.sax.SAXParseException;
import planetes.*;
import utile.EcritureFichier;
import utile.Serveur;
import vaisseaux.VaisseauLeger;
import vaisseaux.VaisseauLourd;
import vaisseaux.VaisseauNormal;
import vaisseaux.Vaisseaux;
import utile.AttXML;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSerializer.UTF_8;

/**
 * Created by DioAn1730700 on 2018-04-26.
 */
public class Simulation {

    public static ArrayList<Planete> tabPlanetes = new ArrayList<>();
    public static ArrayList<CentreTri> tabCentreTri = new ArrayList<>();
    public static Queue<Vaisseaux> tabVaisseaux = new LinkedList<>();
    public static boolean life = true;

    public static void main(String[] args) throws Exception {

        /*
        apres avoir lance la simulation, il faut attendre assez longtemps
        pour que le fichier soit complet, sinon
        il manque une partie de la fin
         */


        try {
            Socket socket = new Socket("127.0.0.1", 8080);

            InputStream fluxEntrant = socket.getInputStream();
            BufferedReader entree = new BufferedReader(
                    new InputStreamReader(fluxEntrant));

            String message = "";

            for (int i = 0; i<78; i++){
                message = entree.readLine();
                Files.write(Paths.get("ControleClient.xml"), (message + System.lineSeparator()).getBytes(UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);

                if (i==77){
                message = "</simulation>";
                    Files.write(Paths.get("ControleClient.xml"), (message + System.lineSeparator()).getBytes(UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                }
            }

            client();

            OutputStream fluxSortant = socket.getOutputStream();
            OutputStreamWriter sortie = new OutputStreamWriter(fluxSortant);


            sortie.write(EcritureFichier.texte);
            sortie.flush();

            Files.delete(Paths.get("ControleClient.xml"));
        }
        catch (IOException e){ }
        catch (Exception e) { e.printStackTrace(); }
    }
    public static void client() throws Exception {
        try {
            AttXML.constructionXML();

        } catch (SAXParseException e) {

        }

        //creation des planètes
        for (int i = 0; i < AttXML.getNbPlanetes(); i++) {
            tabPlanetes.add(nouvPlanete());
        }

        //création des vaisseaux
        for (int i = 0; i < AttXML.getNbLeger(); i++) {
            char a = (char)(i+65);
            tabVaisseaux.add(new VaisseauLeger("Bébé vaisseau " + a));
        }
        for (int i = 0; i < AttXML.nbNormal; i++) {
            char a = (char)(i+65);
            tabVaisseaux.add(new VaisseauNormal("Maman vaisseau " + a));
        }
        for (int i = 0; i < AttXML.getNbLourd(); i++) {
            char a = (char)(i+65);
            tabVaisseaux.add(new VaisseauLourd("Papa vaisseau " + a));
        }


        //disponibilité vaisseau
        EcritureFichier.affichageSimulation("Il y a " + AttXML.getNbVaisseaux() + " vaisseaux disponibles");
        EcritureFichier.affichageSimulation("\n");

        //création des centres de tris
        for (int i = 0; i < AttXML.getNbCentreTris(); i++) {
            CentreTri centreTri = new CentreTri("Centre de tris " + (i + 1));
            tabCentreTri.add(centreTri);
        }

        //disponibilité centres tri
        EcritureFichier.affichageSimulation("Il y a " + tabCentreTri.size() + " centres de tris disponibles");
        EcritureFichier.affichageSimulation("\n");

        try {
            while (life == true) {

                //lancement vaisseaux

                Vaisseaux enCours = null;
                for (int i = 0; i < AttXML.getNbVaisseaux(); i++) {
                    int planete = (int) (Math.random() * 5);

                    EcritureFichier.affichageSimulation("Envoie d'un nouveau vaisseau");


                    enCours = tabVaisseaux.poll();
                    //charge
                    tabPlanetes.get(planete).charger(enCours);
                    Vaisseaux.algo(enCours.getMatiere());
                    enCours.afficher();
                    EcritureFichier.affichageSimulation("Les déchets proviennent de la planète : " + tabPlanetes.get(planete).getNom());
                    EcritureFichier.affichageSimulation("En direction du centre de tri: " + enCours.getCentreActu());
                    EcritureFichier.affichageSimulation("\n");

                    //décharge
                    tabCentreTri.get(enCours.getCentreActu()).déchargeDechets(enCours);
                    //enCours.afficher();
                }
                //arrête de la simulation
                EcritureFichier.affichageSimulation("\n");
                EcritureFichier.affichageSimulation("--------------------");
                EcritureFichier.affichageSimulation("SIMULATION TERMINÉE");
                EcritureFichier.affichageSimulation("--------------------");
                for (int i = 0; i < tabCentreTri.size(); i++) {
                    tabCentreTri.get(i).afficher();
                }
                life = false;
            }
        } catch (Exceptions.DernierCentreTris dernierCentreTris) {
            EcritureFichier.affichageSimulation("\n");
            EcritureFichier.affichageSimulation("**ERREUR**");
            EcritureFichier.affichageSimulation("Il n'y a plus de prochain centre de tri où recycler");
            EcritureFichier.affichageSimulation("--------------------");

            life = false;
        } catch (Exceptions.CentreTrisPlein centreTrisPlein) {
            EcritureFichier.affichageSimulation("\n");
            EcritureFichier.affichageSimulation("**ERREUR**");
            EcritureFichier.affichageSimulation("Centre de tris plein");
            EcritureFichier.affichageSimulation("--------------------");

            life = false;
        } catch (Exceptions.ListeVideCentreTris listeVideCentreTris) {
            EcritureFichier.affichageSimulation("\n");
            EcritureFichier.affichageSimulation("**ERREUR**");
            EcritureFichier.affichageSimulation("Il n'y a pas de vaisseaux en attente dans le centre de tris ");
            EcritureFichier.affichageSimulation("--------------------");

            life = false;
        }
    }

    public static void envoieRecyclage(Vaisseaux vaisseauRecyc)
            throws Exceptions.DernierCentreTris, Exceptions.ListeVideCentreTris, Exceptions.CentreTrisPlein {
        vaisseauRecyc.afficher();

        if (vaisseauRecyc.getCentreActu() == tabCentreTri.size()) {
            throw new Exceptions.DernierCentreTris();
        } else {
            tabCentreTri.get(vaisseauRecyc.getCentreActu()).déchargeDechets(vaisseauRecyc);
            EcritureFichier.affichageSimulation("Centre de tri: " + vaisseauRecyc.getCentreActu());
            EcritureFichier.affichageSimulation("\n");
            CentreTri.neptu = true;
            CentreTri.pluto = true;
            CentreTri.gado = true;
            CentreTri.terbi = true;
            CentreTri.thuli = true;
        }
    }



    public static void envoie(Vaisseaux enCours2)
        throws Exceptions.CentreTrisPlein, Exceptions.ListeVideCentreTris, Exceptions.DernierCentreTris{
            int planete = (int) (Math.random() * 5);

            //charge
        tabPlanetes.get(planete).charger(enCours2);
            Vaisseaux.algo(enCours2.getMatiere());
            enCours2.afficher();
            EcritureFichier.affichageSimulation("Les déchets proviennent de la planète : " + tabPlanetes.get(planete).getNom());

            //décharge
            if (tabCentreTri.get(enCours2.getCentreActu()).attente.size() == CentreTri.attenteMax){
                throw new Exceptions.CentreTrisPlein();
            }
            else {
                tabCentreTri.get(enCours2.getCentreActu()).déchargeDechets(enCours2);
                enCours2.afficher();
            }

        }

        public static Planete nouvPlanete (){
        int aleatoire =(int) (Math.random()*5);
        Planete planete = null;
        if (aleatoire==0){
            planete = new PlaneteBleue();
        }
        else if (aleatoire==1){
            planete = new PlaneteJaune();
        }
        else if (aleatoire==2){
            planete = new PlaneteNoir();
        }
        else if (aleatoire==3){
            planete = new PlaneteRouge();
        }
        else if (aleatoire==4){
            planete = new PlaneteVerte();
        }

        return planete;
    }


}
