//Cristopher Vázquez Villa

public class FilosofosComelones {
    public static void main(String[] args) {
        Tenedor[] tenedores = new Tenedor[5];
        for (int i = 0; i < tenedores.length; i++) {
            tenedores[i] = new Tenedor();
        }
        for (int i = 0; i < tenedores.length; i++) {
            Filosofo filosofo;
            if (i == tenedores.length - 1) {
                filosofo = new Filosofo(i + 1, tenedores[i], tenedores[0]);
            } else {
                filosofo = new Filosofo(i + 1, tenedores[i], tenedores[i + 1]);
            }
            Thread thread = new Thread(filosofo);
            thread.start();
        }
    }
}