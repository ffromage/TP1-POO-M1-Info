
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Threads extends Thread{

	
	private Socket client;
	Scanner sc = new Scanner(System.in);
	char C[] ;
	Object str ;
	
	public Threads(String name,Socket client){
		super(name) ;
		this.client = client ;
		
	}
	
	public void run(){
		 System.out.println("Client connecté ("+this.getName()+"): "+client.getInetAddress().toString());
		
		 OutputStream out ;
		 ObjectOutputStream objOut ;
		 InputStream in ;
		 ObjectInputStream objIn ;

		 synchronized (this) { 
			 
		     try {
			    out = client.getOutputStream();
			    objOut = new ObjectOutputStream(out);
			    objOut.writeObject((Serv.L).getFirst());
			    System.out.println("Paquet envoyé ("+this.getName()+") :"+(Serv.L).getFirst());
			    Serv.L.remove() ;
			    System.out.println("Liste : "+Serv.L);
		    } catch (IOException e1) {
			    // TODO Auto-generated catch block
			    e1.printStackTrace();
		    }
		
		 }
		
		 
		 synchronized (this) { 
			 
			 
		     try {
			    in = client.getInputStream();
			    objIn = new ObjectInputStream(in);
			    Serv.Ls.add((Object)objIn.readObject());
			    System.out.println("Paquet reçu ("+this.getName()+") :"+Serv.Ls);
		    } catch (IOException e1) {
			    // TODO Auto-generated catch block
			    e1.printStackTrace();
		    } catch (ClassNotFoundException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
		    }
				 
		 }
	
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
