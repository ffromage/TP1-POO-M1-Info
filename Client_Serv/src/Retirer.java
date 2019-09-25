package SynchroTAb;

/**
 * Thread qui retire
 */
public class Retirer extends Thread {
    private Compte t;

    public Retirer(Compte i) {
	t=i;
    }

    public void run() {
	for (int j = 0; j <10000; j++)
	   t.decTab();
    }
}
