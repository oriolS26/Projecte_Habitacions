import Habitacions.Porta;
import Habitacions.habitacio;
import Objectes.objecte;
import java.util.Random;

public class Company {

    protected String nom;
    protected habitacio habitacioActual;
    protected boolean despert;

    public Company(String nom, habitacio habitacioActual) {
        this.nom = nom;
        this.habitacioActual = habitacioActual;
        this.despert = false;
    }

    public String getNom() {
        return nom;
    }

    public habitacio getHabitacioActual() {
        return habitacioActual;
    }

    public void setHabitacioActual(habitacio habitacioActual) {
        this.habitacioActual = habitacioActual;
    }

    public boolean estaDespert() {
        return despert;
    }

    public void despertar() {
        if (!despert) {
            despert = true;

            System.out.println();
            System.out.println("El Company s'ha despertat.");
            System.out.println("Ara es mourà per la nau.");
            System.out.println();
        }
    }

    public void moure(habitacio[] habitacions) {

        if (!despert) {
            return;
        }

        Porta[] portesDisponibles = new Porta[4];
        int quantitatPortes = 0;

        for (int i = 0; i < 4; i++) {

            Porta porta = habitacioActual.obtenirPorta(i);

            if (porta != null && porta.estaOberta()) {
                portesDisponibles[quantitatPortes] = porta;
                quantitatPortes++;
            }
        }

        if (quantitatPortes == 0) {
            return;
        }

        Random random = new Random();

        int portaEscollida = random.nextInt(quantitatPortes);

        habitacio novaHabitacio =
                portesDisponibles[portaEscollida]
                        .obtenirAltraHabitacio(habitacioActual);

        if (novaHabitacio != null) {

            habitacioActual = novaHabitacio;

            System.out.println(
                    "El Company s'ha mogut a: "
                    + habitacioActual.getNom()
            );

            menjarDonuts();
        }
    }

    public void menjarDonuts() {

        if (!habitacioActual.getNom().equalsIgnoreCase("Cuina")) {
            return;
        }

        objecte donuts = habitacioActual.obtenirObjectePerNom("Donuts");

        if (donuts != null) {

            habitacioActual.treureObjecte(donuts);

            System.out.println();
            System.out.println("El Company ha trobat els Donuts.");
            System.out.println("El Company s'ha menjat els Donuts.");
            System.out.println();
        }
    }
}