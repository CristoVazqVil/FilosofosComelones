//Cristopher Vázquez Villa

public class Tenedor {
    private boolean disponible = true;

    public Tenedor() {
    }

    public synchronized void agarrar() throws InterruptedException {
        while (!disponible) {
            wait();
        }
        disponible = false;
    }

    public synchronized void soltar() {
        disponible = true;
        notify();
    }
}
