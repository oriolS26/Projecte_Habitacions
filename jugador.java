public class Jugador {
    String nom;
    Habitacio habitacioActual;

    public Jugador(String nom, Habitacio habitacioActual) {
        this.nom = nom;
        this.habitacioActual = habitacioActual;
    }

    public String getNom() {
        return nom;
    }

    public Habitacio getHabitacioActual() {
        return habitacioActual;
    }

    public void setHabitacioActual(Habitacio habitacioActual) {
        this.habitacioActual = habitacioActual;
    }

    public void SetNom(String nom) {
        this.nom = nom;
    }
    
    public void moure(Porta porta) {
        if(porta = true) {

            Habitacio novaHabitacio = porta.obtenirAltreHabitacio(habitacioActual);

            habitacioActual = novaHabitacio;

            System.out.println("Has entrat a la habitació: " + habitacioActual.getNom());
        } else {
            System.out.println("La porta està tancada. No pots passar.");
        }
    }
}
