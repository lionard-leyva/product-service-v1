package salon;

import org.junit.jupiter.api.MethodOrderer;

import java.util.Random;

public class WomanSalon implements Runnable {

    private Salon salon;
    private final String name;

    public WomanSalon(Salon salon, String name) {
        this.salon = salon;
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            Client client = salon.getClient();
            System.out.println(name + " is waiting for a client" + client.getName());
            int timeAttendance = random.nextInt(10) + 1;
            try {
                Thread.sleep(timeAttendance * 1000);
                System.out.println(name + " finish attending the client " + client.getName() + "in " + timeAttendance + " seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
