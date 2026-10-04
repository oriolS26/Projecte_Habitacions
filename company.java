import Habitacions.Porta;
import Habitacions.habitacio;
import java.util.Random;

public class Company {

    private String nom;
    private habitacio habitacioActual;
    private boolean despert;
    private boolean teTargeta;
    private boolean teDonuts;

    public Company(String nom, habitacio habitacioActual) {

        this.nom = nom;
        this.habitacioActual = habitacioActual;
        this.despert = false;
        this.teTargeta = true;
        this.teDonuts = false;
    }

    public String getNom() {
        return nom;
    }

    public habitacio getHabitacioActual() {
        return habitacioActual;
    }

    public boolean estaDespert() {
        return despert;
    }

    public boolean teTargeta() {
        return teTargeta;
    }

    public boolean teDonuts() {
        return teDonuts;
    }

    public void despertar() {

        despert = true;

        System.out.println(
            nom + " s'ha despertat."
        );
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

        int portaEscollida =
                random.nextInt(quantitatPortes);

        habitacio novaHabitacio =
                portesDisponibles[portaEscollida]
                        .obtenirAltraHabitacio(habitacioActual);

        if (novaHabitacio != null) {

            habitacioActual = novaHabitacio;

            System.out.println(
                nom + " s'ha mogut a: "
                + habitacioActual.getNom()
            );
        }
    }

    public void agafarDonuts() {

        teDonuts = true;

        System.out.println(
            nom + " ha trobat els donuts i se'ls ha menjat."
        );
    }
}