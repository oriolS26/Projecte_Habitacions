import Habitacions.Porta;
import Habitacions.habitacio;


public class jugador {
    private String nom;
    private habitacio habitacioActual;

    public jugador(String nom, habitacio habitacioActual) {
        this.nom = nom;
        this.habitacioActual = habitacioActual;
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

    public void SetNom(String nom) {
        this.nom = nom;
    }
    
    public void moure(int numeroPorta) {

        Porta portaEscollida = habitacioActual.obtenirPorta(numeroPorta);

        if(portaEscollida == null) {

            System.out.println("Aquesta porta no existeix en aquesta habitacio.");

            } else {

            if (portaEscollida.estaOberta()) {

                habitacio novaHabitacio = 
                    portaEscollida.obtenirAltraHabitacio(habitacioActual);

                habitacioActual = novaHabitacio;
            
            System.out.println();
            System.out.println( "Has anat a: " + habitacioActual.getNom());
                } else {

                System.out.println("La porta esta tancada.");
                }
            }
    }
}