package utile;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import planetes.Planete;
import vaisseaux.Vaisseaux;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class AttXML {

    public static int nbPlanetes;
    public static int nbCentreTris;
    public static int nbVaisseaux;

    public static int nbLeger;
    public static int nbNormal;
    public static int nbLourd;

    public static int bleueProbGado;
    public static int bleueProbNeptu;
    public static int bleueProbPluto;
    public static int bleueProbTerbi;
    public static int bleueProbThuli;

    public static int jauneProbGado;
    public static int jauneProbNeptu;
    public static int jauneProbPluto;
    public static int jauneProbTerbi;
    public static int jauneProbThuli;

    public static int noirProbGado;
    public static int noirProbNeptu;
    public static int noirProbPluto;
    public static int noirProbTerbi;
    public static int noirProbThuli;

    public static int rougeProbGado;
    public static int rougeProbNeptu;
    public static int rougeProbPluto;
    public static int rougeProbTerbi;
    public static int rougeProbThuli;

    public static int verteProbGado;
    public static int verteProbNeptu;
    public static int verteProbPluto;
    public static int verteProbTerbi;
    public static int verteProbThuli;

    public static int gadoRecyc;
    public static int gadoMassVol;

    public static int neptuRecyc;
    public static int neptuMassVol;

    public static int plutoRecyc;
    public static int plutoMassVol;

    public static int terbiRecyc;
    public static int terbiMassVol;

    public static int thuliRecyc;
    public static int thuliMassVol;
    public static int getNbPlanetes() {return nbPlanetes; }

    public static void setNbPlanetes(int nbPlanetes) {
        AttXML.nbPlanetes = nbPlanetes;
    }

    public static int getNbCentreTris() {
        return nbCentreTris;
    }

    public static void setNbCentreTris(int nbCentreTris) {
        AttXML.nbCentreTris = nbCentreTris;
    }

    public static int getNbVaisseaux() {
        return nbVaisseaux;
    }

    public static void setNbVaisseaux(int nbVaisseaux) {
        AttXML.nbVaisseaux = nbVaisseaux;
    }

    public static int getNbLeger() {
        return nbLeger;
    }

    public static void setNbLeger(int nbLeger) {
        AttXML.nbLeger = nbLeger;
    }

    public static int getNbNormal() {
        return nbNormal;
    }

    public static void setNbNormal(int nbNormal) {
        AttXML.nbNormal = nbNormal;
    }

    public static int getNbLourd() {
        return nbLourd;
    }

    public static void setNbLourd(int nbLourd) {
        AttXML.nbLourd = nbLourd;
    }

    public static int getBleueProbGado() {
        return bleueProbGado;
    }

    public static void setBleueProbGado(int bleueProbGado) {
        AttXML.bleueProbGado = bleueProbGado;
    }

    public static int getBleueProbNeptu() {
        return bleueProbNeptu;
    }

    public static void setBleueProbNeptu(int bleueProbNeptu) {
        AttXML.bleueProbNeptu = bleueProbNeptu;
    }

    public static int getBleueProbPluto() {
        return bleueProbPluto;
    }

    public static void setBleueProbPluto(int bleueProbPluto) {
        AttXML.bleueProbPluto = bleueProbPluto;
    }

    public static int getBleueProbTerbi() {
        return bleueProbTerbi;
    }

    public static void setBleueProbTerbi(int bleueProbTerbi) {
        AttXML.bleueProbTerbi = bleueProbTerbi;
    }

    public static int getBleueProbThuli() {
        return bleueProbThuli;
    }

    public static void setBleueProbThuli(int bleueProbThuli) {
        AttXML.bleueProbThuli = bleueProbThuli;
    }

    public static int getJauneProbGado() {
        return jauneProbGado;
    }

    public static void setJauneProbGado(int jauneProbGado) {
        AttXML.jauneProbGado = jauneProbGado;
    }

    public static int getJauneProbNeptu() {
        return jauneProbNeptu;
    }

    public static void setJauneProbNeptu(int jauneProbNeptu) {
        AttXML.jauneProbNeptu = jauneProbNeptu;
    }

    public static int getJauneProbPluto() {
        return jauneProbPluto;
    }

    public static void setJauneProbPluto(int jauneProbPluto) {
        AttXML.jauneProbPluto = jauneProbPluto;
    }

    public static int getJauneProbTerbi() {
        return jauneProbTerbi;
    }

    public static void setJauneProbTerbi(int jauneProbTerbi) {
        AttXML.jauneProbTerbi = jauneProbTerbi;
    }

    public static int getJauneProbThuli() {
        return jauneProbThuli;
    }

    public static void setJauneProbThuli(int jauneProbThuli) {
        AttXML.jauneProbThuli = jauneProbThuli;
    }

    public static int getNoirProbGado() {
        return noirProbGado;
    }

    public static void setNoirProbGado(int noirProbGado) {
        AttXML.noirProbGado = noirProbGado;
    }

    public static int getNoirProbNeptu() {
        return noirProbNeptu;
    }

    public static void setNoirProbNeptu(int noirProbNeptu) {
        AttXML.noirProbNeptu = noirProbNeptu;
    }

    public static int getNoirProbPluto() {
        return noirProbPluto;
    }

    public static void setNoirProbPluto(int noirProbPluto) {
        AttXML.noirProbPluto = noirProbPluto;
    }

    public static int getNoirProbTerbi() {
        return noirProbTerbi;
    }

    public static void setNoirProbTerbi(int noirProbTerbi) {
        AttXML.noirProbTerbi = noirProbTerbi;
    }

    public static int getNoirProbThuli() {
        return noirProbThuli;
    }

    public static void setNoirProbThuli(int noirProbThuli) {
        AttXML.noirProbThuli = noirProbThuli;
    }

    public static int getRougeProbGado() {
        return rougeProbGado;
    }

    public static void setRougeProbGado(int rougeProbGado) {
        AttXML.rougeProbGado = rougeProbGado;
    }

    public static int getRougeProbNeptu() {
        return rougeProbNeptu;
    }

    public static void setRougeProbNeptu(int rougeProbNeptu) {
        AttXML.rougeProbNeptu = rougeProbNeptu;
    }

    public static int getRougeProbPluto() {
        return rougeProbPluto;
    }

    public static void setRougeProbPluto(int rougeProbPluto) {
        AttXML.rougeProbPluto = rougeProbPluto;
    }

    public static int getRougeProbTerbi() {
        return rougeProbTerbi;
    }

    public static void setRougeProbTerbi(int rougeProbTerbi) {
        AttXML.rougeProbTerbi = rougeProbTerbi;
    }

    public static int getRougeProbThuli() {
        return rougeProbThuli;
    }

    public static void setRougeProbThuli(int rougeProbThuli) {
        AttXML.rougeProbThuli = rougeProbThuli;
    }

    public static int getVerteProbGado() {
        return verteProbGado;
    }

    public static void setVerteProbGado(int verteProbGado) {
        AttXML.verteProbGado = verteProbGado;
    }

    public static int getVerteProbNeptu() {
        return verteProbNeptu;
    }

    public static void setVerteProbNeptu(int verteProbNeptu) {
        AttXML.verteProbNeptu = verteProbNeptu;
    }

    public static int getVerteProbPluto() {
        return verteProbPluto;
    }

    public static void setVerteProbPluto(int verteProbPluto) {
        AttXML.verteProbPluto = verteProbPluto;
    }

    public static int getVerteProbTerbi() {
        return verteProbTerbi;
    }

    public static void setVerteProbTerbi(int verteProbTerbi) {
        AttXML.verteProbTerbi = verteProbTerbi;
    }

    public static int getVerteProbThuli() {
        return verteProbThuli;
    }

    public static void setVerteProbThuli(int verteProbThuli) {
        AttXML.verteProbThuli = verteProbThuli;
    }

    public static int getGadoRecyc() {
        return gadoRecyc;
    }

    public static void setGadoRecyc(int gadoRecyc) {
        AttXML.gadoRecyc = gadoRecyc;
    }

    public static int getGadoMassVol() {
        return gadoMassVol;
    }

    public static void setGadoMassVol(int gadoMassVol) {
        AttXML.gadoMassVol = gadoMassVol;
    }

    public static int getNeptuRecyc() {
        return neptuRecyc;
    }

    public static void setNeptuRecyc(int neptuRecyc) {
        AttXML.neptuRecyc = neptuRecyc;
    }

    public static int getNeptuMassVol() {
        return neptuMassVol;
    }

    public static void setNeptuMassVol(int neptuMassVol) {
        AttXML.neptuMassVol = neptuMassVol;
    }

    public static int getPlutoRecyc() {
        return plutoRecyc;
    }

    public static void setPlutoRecyc(int plutoRecyc) {
        AttXML.plutoRecyc = plutoRecyc;
    }

    public static int getPlutoMassVol() {
        return plutoMassVol;
    }

    public static void setPlutoMassVol(int plutoMassVol) {
        AttXML.plutoMassVol = plutoMassVol;
    }

    public static int getTerbiRecyc() { return terbiRecyc; }

    public static void setTerbiRecyc(int terbiRecyc) { AttXML.terbiRecyc = terbiRecyc; }

    public static int getTerbiMassVol() {
        return terbiMassVol;
    }

    public static void setTerbiMassVol(int terbiMassVol) {
        AttXML.terbiMassVol = terbiMassVol;
    }

    public static int getThuliRecyc() {
        return thuliRecyc;
    }

    public static void setThuliRecyc(int thuliRecyc) {
        AttXML.thuliRecyc = thuliRecyc;
    }

    public static int getThuliMassVol() {
        return thuliMassVol;
    }

    public static void setThuliMassVol(int thuliMassVol) {
        AttXML.thuliMassVol = thuliMassVol;
    }

    public static void clean(Node node)
    {
        NodeList childNodes = node.getChildNodes();

        for (int n = childNodes.getLength() - 1; n >= 0; n--)
        {
            Node child = childNodes.item(n);
            short nodeType = child.getNodeType();

            if (nodeType == Node.ELEMENT_NODE)
                clean(child);
            else if (nodeType == Node.TEXT_NODE)
            {
                String trimmedNodeVal = child.getNodeValue().trim();
                if (trimmedNodeVal.length() == 0)
                    node.removeChild(child);
                else
                    child.setNodeValue(trimmedNodeVal);
            }
            else if (nodeType == Node.COMMENT_NODE)
                node.removeChild(child);
        }
    }

    public static void constructionXML() throws Exception{
       try {
           File file = new File("ControleClient.xml");
           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbf.newDocumentBuilder();
           Document doc = dBuilder.parse(file);
           Node root = doc.getDocumentElement();
           clean(root);

           String nb = root.getFirstChild().getFirstChild().getNodeValue();
           int nbPlanetes = Integer.parseInt(nb);
           setNbPlanetes(nbPlanetes);

           NodeList vaisseaux = root.getChildNodes().item(3).getChildNodes();
           int nbLeger = Integer.parseInt(vaisseaux.item(0).getFirstChild().getNodeValue());
           int nbNormal = Integer.parseInt(vaisseaux.item(1).getFirstChild().getNodeValue());
           int nbLourd = Integer.parseInt(vaisseaux.item(2).getFirstChild().getNodeValue());
           setNbLeger(nbLeger);
           setNbNormal(nbNormal);
           setNbLourd(nbLourd);
           int nbVaisseaux = nbLeger + nbNormal + nbLourd;
           setNbVaisseaux(nbVaisseaux);


           int nbCentreTris = Integer.parseInt(root.getLastChild().getFirstChild().getNodeValue());
           setNbCentreTris(nbCentreTris);

           Node planetes = root.getChildNodes().item(1);
           Node bleue = planetes.getChildNodes().item(0);
           NodeList planetesProb = bleue.getFirstChild().getChildNodes();
           int probGado = Integer.parseInt(planetesProb.item(0).getFirstChild().getNodeValue());
           int probNeptu = Integer.parseInt(planetesProb.item(1).getFirstChild().getNodeValue());
           int probPluto = Integer.parseInt(planetesProb.item(2).getFirstChild().getNodeValue());
           int probTerbi = Integer.parseInt(planetesProb.item(3).getFirstChild().getNodeValue());
           int probThuli = Integer.parseInt(planetesProb.item(4).getFirstChild().getNodeValue());

           setBleueProbGado(probGado);
           setBleueProbNeptu(probNeptu);
           setBleueProbPluto(probPluto);
           setBleueProbTerbi(probTerbi);
           setBleueProbThuli(probThuli);

           Node jaune = planetes.getChildNodes().item(1);
           NodeList planetesProb2 = jaune.getFirstChild().getChildNodes();
           int probGado2 = Integer.parseInt(planetesProb2.item(0).getFirstChild().getNodeValue());
           int probNeptu2 = Integer.parseInt(planetesProb2.item(1).getFirstChild().getNodeValue());
           int probPluto2 = Integer.parseInt(planetesProb2.item(2).getFirstChild().getNodeValue());
           int probTerbi2 = Integer.parseInt(planetesProb2.item(3).getFirstChild().getNodeValue());
           int probThuli2 = Integer.parseInt(planetesProb2.item(4).getFirstChild().getNodeValue());

           setJauneProbGado(probGado2);
           setJauneProbNeptu(probNeptu2);
           setJauneProbPluto(probPluto2);
           setJauneProbTerbi(probTerbi2);
           setJauneProbThuli(probThuli2);

           Node noir = planetes.getChildNodes().item(2);
           NodeList planetesProb3 = noir.getFirstChild().getChildNodes();
           int probGado3 = Integer.parseInt(planetesProb3.item(0).getFirstChild().getNodeValue());
           int probNeptu3 = Integer.parseInt(planetesProb3.item(1).getFirstChild().getNodeValue());
           int probPluto3 = Integer.parseInt(planetesProb3.item(2).getFirstChild().getNodeValue());
           int probTerbi3 = Integer.parseInt(planetesProb3.item(3).getFirstChild().getNodeValue());
           int probThuli3 = Integer.parseInt(planetesProb3.item(4).getFirstChild().getNodeValue());

           setNoirProbGado(probGado3);
           setNoirProbNeptu(probNeptu3);
           setNoirProbPluto(probPluto3);
           setNoirProbTerbi(probTerbi3);
           setNoirProbThuli(probThuli3);

           Node rouge = planetes.getChildNodes().item(3);
           NodeList planetesProb4 = rouge.getFirstChild().getChildNodes();
           int probGado4 = Integer.parseInt(planetesProb4.item(0).getFirstChild().getNodeValue());
           int probNeptu4 = Integer.parseInt(planetesProb4.item(1).getFirstChild().getNodeValue());
           int probPluto4 = Integer.parseInt(planetesProb4.item(2).getFirstChild().getNodeValue());
           int probTerbi4 = Integer.parseInt(planetesProb4.item(3).getFirstChild().getNodeValue());
           int probThuli4 = Integer.parseInt(planetesProb4.item(4).getFirstChild().getNodeValue());

           setRougeProbGado(probGado4);
           setRougeProbNeptu(probNeptu4);
           setRougeProbPluto(probPluto4);
           setRougeProbTerbi(probTerbi4);
           setRougeProbThuli(probThuli4);

           Node verte = planetes.getChildNodes().item(4);
           NodeList planetesProb5 = verte.getFirstChild().getChildNodes();
           int probGado5 = Integer.parseInt(planetesProb5.item(0).getFirstChild().getNodeValue());
           int probNeptu5 = Integer.parseInt(planetesProb5.item(1).getFirstChild().getNodeValue());
           int probPluto5 = Integer.parseInt(planetesProb5.item(2).getFirstChild().getNodeValue());
           int probTerbi5 = Integer.parseInt(planetesProb5.item(3).getFirstChild().getNodeValue());
           int probThuli5 = Integer.parseInt(planetesProb5.item(4).getFirstChild().getNodeValue());

           setVerteProbGado(probGado5);
           setVerteProbNeptu(probNeptu5);
           setVerteProbPluto(probPluto5);
           setVerteProbTerbi(probTerbi5);
           setVerteProbThuli(probThuli5);

           Node dechets = root.getChildNodes().item(2);

           Node gado = dechets.getChildNodes().item(0);
           int pourcentage = Integer.parseInt(gado.getFirstChild().getFirstChild().getNodeValue());
           int massVol = Integer.parseInt(gado.getLastChild().getFirstChild().getNodeValue());
           setGadoRecyc(pourcentage);
           setGadoMassVol(massVol);

           Node neptu = dechets.getChildNodes().item(1);
           int pourcentage2 = Integer.parseInt(neptu.getFirstChild().getFirstChild().getNodeValue());
           int massVol2 = Integer.parseInt(neptu.getLastChild().getFirstChild().getNodeValue());
           setNeptuRecyc(pourcentage2);
           setNeptuMassVol(massVol2);

           Node pluto = dechets.getChildNodes().item(2);
           int pourcentage3 = Integer.parseInt(pluto.getFirstChild().getFirstChild().getNodeValue());
           int massVol3 = Integer.parseInt(pluto.getLastChild().getFirstChild().getNodeValue());
           setPlutoRecyc(pourcentage3);
           setPlutoMassVol(massVol3);

           Node terbi = dechets.getChildNodes().item(3);
           int pourcentage4 = Integer.parseInt(terbi.getFirstChild().getFirstChild().getNodeValue());
           int massVol4 = Integer.parseInt(terbi.getLastChild().getFirstChild().getNodeValue());
           setTerbiRecyc(pourcentage4);
           setTerbiMassVol(massVol4);

           Node thuli = dechets.getChildNodes().item(4);
           int pourcentage5 = Integer.parseInt(thuli.getFirstChild().getFirstChild().getNodeValue());
           int massVol5 = Integer.parseInt(thuli.getLastChild().getFirstChild().getNodeValue());
           setThuliRecyc(pourcentage5);
           setThuliMassVol(massVol5);

       }catch (NumberFormatException e){

       }

    }

}
