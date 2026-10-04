import Habitacions.Porta;
import Habitacions.habitacio;
import java.util.Random;

public class Alien {

    protected String nom;
    protected habitacio habitacioActual;
    protected int moviments;
    protected boolean distret;
    protected int movimentsDistret;

    public Alien(String nom, habitacio habitacioActual) {

        this.nom = nom;
        this.habitacioActual = habitacioActual;
        this.moviments = 0;
        this.distret = false;
        this.movimentsDistret = 0;
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
        movimentsDistret = 2;

        System.out.println(
            "Malien s'ha distret amb els donuts."
        );
    }

    public void incrementarMoviments() {
        moviments++;
    }

    public void moure(habitacio[] habitacions) {

        if (distret) {

            movimentsDistret--;

            System.out.println("Malien esta distret. No es mou.");

            if (movimentsDistret <= 0) {

                distret = false;

                System.out.println("Malien ja no esta distret.");
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

            System.out.println(
                "Malien no te cap porta oberta per moure's."
            );

            return;
        }

        Random random = new Random();

        int portaEscollida = random.nextInt(quantitatPortes);

        habitacio novaHabitacio =
                portesDisponibles[portaEscollida]
                        .obtenirAltraHabitacio(habitacioActual);

        if (novaHabitacio != null) {

            habitacioActual = novaHabitacio;

            moviments++;

            System.out.println();
            System.out.println(
                "Malien s'ha mogut a: "
                + habitacioActual.getNom()
            );
            System.out.println();
        }
    }
}