import Habitacions.habitacio;
import java.util.Random;

public class Ordinador {

    private String nom;
    private habitacio habitacioLlanterna;
    private Random random;

    public Ordinador(String nom) {
        this.nom = nom;
        this.random = new Random();
    }

    public String getNom() {
        return nom;
    }

    public void setHabitacioLlanterna(habitacio habitacioLlanterna) {
        this.habitacioLlanterna = habitacioLlanterna;
    }

    public habitacio getHabitacioLlanterna() {
        return habitacioLlanterna;
    }

    public habitacio dirOnEstaLlanterna(habitacio[] habitacions) {

        int probabilitat = random.nextInt(100);

        if (probabilitat < 50) {

            return habitacioLlanterna;

        } else {

            return habitacions[random.nextInt(habitacions.length)];
        }
    }

    public void parlar() {

        System.out.println(
            "Soc iHall, l'ordinador de la PiaXXII."
        );
    }
}