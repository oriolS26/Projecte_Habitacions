import Habitacions.Porta;
import Habitacions.habitacio;
import java.util.Random;

public class Ordinador {

    protected String nom;

    public Ordinador(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void dirOnEstaMalien(Alien alien1) {

        System.out.println();
        System.out.println("iHall: El Malien es troba a:");
        System.out.println(alien1.getHabitacioActual().getNom());
        System.out.println();
    }

    public void dirOnEstaLlanterna(habitacio[] habitacions) {

        habitacio habitacioReal = null;

        for (int i = 0; i < habitacions.length; i++) {

            if (habitacions[i].obtenirObjectePerNom("Llanterna") != null) {
                habitacioReal = habitacions[i];
                break;
            }
        }

        System.out.println();

        if (habitacioReal == null) {
            System.out.println(
                "iHall: La llanterna ja no es a cap sala de la nau."
            );
            System.out.println();
            return;
        }

        Random random = new Random();

        if (random.nextBoolean()) {

            System.out.println("iHall: La llanterna es troba a:");
            System.out.println(habitacioReal.getNom());

        } else {

            habitacio habitacioFalsa = habitacioReal;

            while (habitacioFalsa == habitacioReal) {
                habitacioFalsa = habitacions[random.nextInt(habitacions.length)];
            }

            System.out.println("iHall: La llanterna es troba a:");
            System.out.println(habitacioFalsa.getNom());
        }

        System.out.println();
    }

    public void obrirPorta(Porta porta) {

        if (porta == null) {
            System.out.println("iHall: Aquesta porta no existeix.");
            return;
        }

        if (porta.estaOberta()) {
            System.out.println("iHall: Aquesta porta ja està oberta.");
            return;
        }

        porta.obrir();

        System.out.println();
        System.out.println("iHall: He obert la porta.");
        System.out.println("Recorda que aquesta nau és meva.");
        System.out.println();
    }
}