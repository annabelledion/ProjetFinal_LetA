package utile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSerializer.UTF_8;

public class Serveur {


    public static void main(String[] args) {
        serveur();
    }

    public static void serveur(){

        try {
            ServerSocket serveur = new ServerSocket(8080);

            while (true){

                Socket socket = serveur.accept();

                OutputStream fluxSortant = socket.getOutputStream();
                OutputStreamWriter sortie = new OutputStreamWriter(fluxSortant);
                String xml = new String(Files.readAllBytes(Paths.get("Controle.xml")));
                sortie.write(xml);
                sortie.flush();

                InputStream fluxEntrant = socket.getInputStream();
                BufferedReader entree = new BufferedReader(
                        new InputStreamReader(fluxEntrant));
                String message ="";


                //création du fichier.dat
                Date date = new Date();
                DateFormat dateFormat= new SimpleDateFormat("yyyyMMddHHmmss");

                try {

                    for (int i = 0; i < 1000; i++){
                        message = entree.readLine();
                        Files.write(Paths.get("Simulation_" + dateFormat.format(date)+ ".dat"), (message + System.lineSeparator()).getBytes(UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                    }

                }
                catch (IOException e )
                {

                }
            }
        } catch (IOException e){

        }
    }
}
