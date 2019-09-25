package SynchroTAb;

public class Compte {
    public double tab[];
    Compte() {
    	tab=new double[100]; 
    	for (int i = 0; i< 100; i++)
    		tab[i]=0;
    }
    
    void incTab() {
    for (int i = 0; i< 100; i++)
    		tab[i]=tab[i]+10.0;
    }
    
    void decTab() {
    for (int i = 0; i< 100; i++)
    		tab[i]=tab[i]-10.0;
    }
    
    
    void printTab() {for (int i = 0; i< 100; i++)
    		System.out.println("tab["+ i + "] =" +tab[i]);
	}
}