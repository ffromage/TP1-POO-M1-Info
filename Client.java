import java.io.*;
import java.lang.reflect.Field;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
		
	private static String serverhost = "localhost";
	private static int PORT = 50205;
	//Ports disponibles 49152 jusqu'à 65535
	
	public static int i ;
	public static int n ;	
	static Scanner sct = new Scanner(System.in);
	static Object strg ;	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Socket s=null;
		 try {
			 ArrayList<Object> La = new ArrayList<Object>() ;
			 ArrayList<Object> Attrs = new ArrayList<Object>() ;
			 
			 
			     System.out.println("Connexion...");
			     s=new Socket(serverhost,PORT); 
			     // Création du socket
			     System.out.println("Connecté.");
		         // Récupération des flux d’entrée/sortie
			     
			     OutputStream out = s.getOutputStream();
			     ObjectOutputStream objOut = new ObjectOutputStream(out);
			     
			     InputStream in = s.getInputStream();
			     ObjectInputStream objIn = new ObjectInputStream(in);

			     try {
			    	strg= (Object)objIn.readObject();
					System.out.println("Paquet reçu (client"+i+""+ ") :"+strg);
					
					Class<? extends Object> strgclass = strg.getClass();
					Field[] attrs = strgclass.getFields();
					
					La.add("Objet : "+strg);
				    La.add("ObjetClass : "+strgclass);
					for(int i = 0; i < attrs.length; i++)
					{
					    Field f = attrs[i];
					    String ClassName = f.getName() ;
					    Class<?> SuperClass = f.getClass().getSuperclass();
					    Class<?> Type=f.getType();
					 
					  
					    Attrs.add("["+i+"]"+f);
						Attrs.add("ClassNameA["+i+"] : "+ClassName);
						Attrs.add("SuperClassA["+i+"] : "+SuperClass);
						Attrs.add("TypeA["+i+"] : "+Type);
					    n=i;
					}
					La.add("NBRattributs = "+n) ;
					La.add("Attributs : "+Attrs);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			    							     
			     objOut.writeObject(La);
			     System.out.println("Paquet envoyé (client"+i+") :"+La);
			     i++;				
		        s.close();				
		} 
		 catch (IOException e) {System.err.println(e);}
	}

}

