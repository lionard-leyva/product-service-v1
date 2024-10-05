package salon;

import java.util.LinkedList;
import java.util.Queue;

public class Salon {
    public static final int NUMBER_WOMAN_SALON = 2;
    public static final int NUMBER_CLIENTS = 3;
    private Queue<Client> queueClients = new LinkedList<>();
    final Object lock = new Object();
    private Thread[] womanSalon;

    public Salon() {
        womanSalon = new Thread[NUMBER_WOMAN_SALON];
        for (int i = 0; i < NUMBER_WOMAN_SALON; i++) {
            this.womanSalon[i] = new Thread(new WomanSalon(this, "WomanSalon " + i));
        }
    }

    public void addClient(Client client) {
        synchronized (lock) {
            queueClients.add(client);
            lock.notify();
        }
    }

    public Client getClient() {
        synchronized (lock) {
            while (queueClients.isEmpty()) {
                try {
                    lock.wait(); // el metodo wait se usa para bloquear el thread hasta que se cumpla la condicion que es pasada como parametro
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queueClients.poll(); //el metodo poll devuelve el primer elemento de la cola, y lo elimina de la misma (se elimina el primer elemento de la cola)
        }
    }
}
