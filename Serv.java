import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


public class Serv  {
    
	public static  int i = 0 ;
	static int tableauEntier[] = {0,1,2,3,4,5};
	static double tableauDouble[] = {0.0,1.0,2.0,3.0,4.0,5.0};
	static char tableauCaractere[] = {'a','b','c','d','e','f'};
	static String tableauChaine[] = {"test1", "test2", "test3" , "test4" , "test5"};
	static Random rand = new Random() ;
	static int choix1 = tableauEntier[ rand.nextInt(tableauEntier.length)] ;
	static double choix2 = tableauDouble[ rand.nextInt(tableauDouble.length)] ;
	static char choix3 = tableauCaractere[ rand.nextInt(tableauCaractere.length)] ;
	static String choix4 = tableauChaine[ rand.nextInt(tableauChaine.length)] ;
	public static ArrayList<Threads> Ps = new ArrayList<Threads>() ;
	public static LinkedList<Object> L = new LinkedList<Object>();
	public static LinkedList<Object> Ls = new LinkedList<Object>();	
	private static ServerSocket ecoute;
	private static int PORT = 50205;
	//Ports disponibles 49152 jusqu'à 65535
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {			
			L.add(choix1);
			L.add(choix2);
			L.add(choix3);
			L.add(choix4);
			System.out.println("Elements de la liste à envoyer : \n"+ L);			
			// On écoute sur le port <PORT>
			 ecoute=new ServerSocket(PORT);
			 System.out.println("Serveur initialisé");
			 
			while (true) {
			System.out.println("Serveur en attente de connexion sur le port : "+PORT);
			Socket client=ecoute.accept();
			System.out.println("Client connecté(Serveur) : "+client.getInetAddress().toString());			
			Threads  P = new Threads("Thread"+i,client) ;
			P.start();
			Ps.add(P);
			i++;						
			}
		}
		catch (IOException e) {
		 System.err.println(e.getMessage());
		 System.exit(1);
		 }
	}

}

