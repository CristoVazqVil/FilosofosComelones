import java.util.Random;

//Cristopher Vázquez Villa

public class Filosofo implements Runnable {
    private final int id;
    private final Tenedor tenedorIzquierdo;
    private final Tenedor tenedorDerecho;
    private final Random random;

    public Filosofo(int id, Tenedor tenedorIzquierdo, Tenedor tenedorDerecho) {
        this.id = id;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Filósofo " + id + " se prepara para comer...");
                Thread.sleep(random.nextInt(1000));
                agarrarTenedores();
                comer();
                pensar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando...");
        Thread.sleep(random.nextInt(1000));
    }

    private void agarrarTenedores() throws InterruptedException {
        tenedorIzquierdo.agarrar();
        System.out.println("Filósofo " + id + " agarra su tenedor izquierdo.");
        tenedorDerecho.agarrar();
        System.out.println("Filósofo " + id + " agarra su tenedor derecho.");
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comiendo...");
        Thread.sleep(random.nextInt(1000));
        System.out.println("Filósofo " + id + " dejó comer.");
        tenedorDerecho.soltar();
        tenedorIzquierdo.soltar();
    }

}