import Habitacions.habitacio;
import java.util.Random;

public class Alien {

    protected String nom;
    protected habitacio habitacioActual;
    protected int moviments;
    protected boolean distret;

    public Alien(String nom, habitacio habitacioActual) {

        this.nom = nom;
        this.habitacioActual = habitacioActual;
        this.moviments = 0;
        this.distret = false;
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

    public int getMoviments() {
        return moviments;
    }

    public boolean estaDistret() {
        return distret;
    }

    public void distreure() {
        distret = true;
    }

    public void incrementarMoviments() {
        moviments++;
    }

    public void moure(habitacio[] habitacions) {

        if (distret) {
            return;
        }

        Random random = new Random();

        habitacio novaHabitacio =
                habitacions[random.nextInt(habitacions.length)];

        habitacioActual = novaHabitacio;
    }
}