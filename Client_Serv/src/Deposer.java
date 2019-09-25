package SynchroTAb;

/**
 * Thread qui depose
 */
public class Deposer extends Thread {
    private Compte t;

    public Deposer(Compte i) {
    	t=i;
    }

    public void run() {
	for (int j = 0; j <10000; j++) {
		t.incTab();
    }
}
}