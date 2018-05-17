package utile;

import sun.applet.Main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by BonLa1731834 on 2018-05-10.
 */
public class EcritureFichier {

    public static String texte = "";


    public static void affichageSimulation(String t){

        texte = (texte + "\n" + t);
    }
}


