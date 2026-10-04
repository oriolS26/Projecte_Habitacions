import Habitacions.Porta;
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
        moviments = 2;

        System.out.println(
            "Malien s'ha distret amb els donuts."
        );
    }

    public void incrementarMoviments() {
        moviments++;
    }

    public void moure(habitacio[] habitacions) {

        if (distret) {

            moviments--;

            System.out.println(
                "Malien esta distret. Li queden "
                + moviments
                + " moviments sense moure's."
            );

            if (moviments <= 0) {
                distret = false;

                System.out.println(
                    "Malien ja no esta distret."
                );
            }

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
                "Malien s'ha mogut a: "
                + habitacioActual.getNom()
            );
        }
    }
}