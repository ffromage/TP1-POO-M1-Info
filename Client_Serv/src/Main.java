package SynchroTAb;

public class Main {
	 public static void  main(String args[]){
			Deposer threadsD[] = new Deposer[100];
			Retirer threadsR[] = new Retirer[100];
		      
			Compte t = new Compte();


			for (int j = 0; j < 100; j++) {
			    threadsD[j]=new Deposer(t);	    
			    threadsR[j]=new Retirer(t);	    
			}

			for (int j = 0; j < 100; j++) {
			    threadsD[j].start();
			    threadsR[j].start();
			}
		      
		      try {
			  for (int j = 0; j < 100; j++) {
			      threadsD[j].join();
			      threadsR[j].join();
			  }
		      } catch (Exception e ) {
		      }

		      t.printTab();
		      System.exit(0);	     
		  }		  
}
