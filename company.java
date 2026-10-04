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

        Random random = new Random();

        habitacio novaHabitacio =
                habitacions[random.nextInt(habitacions.length)];

        habitacioActual = novaHabitacio;
    }

    public void agafarDonuts() {

        teDonuts = true;

        System.out.println(
            nom + " ha trobat els donuts i se'ls ha menjat."
        );
    }
}