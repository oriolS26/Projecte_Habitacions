import Habitacions.Porta;
import Habitacions.habitacio;
import Objectes.objecte;

public class jugador {
    private String nom;
    private habitacio habitacioActual;
    private inventari inventari;

    public jugador(String nom, habitacio habitacioActual) {
        this.nom = nom;
        this.habitacioActual = habitacioActual;
        this.inventari = new inventari();
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

                habitacio novaHabitacio = portaEscollida.obtenirAltraHabitacio(habitacioActual);
                habitacioActual = novaHabitacio;
            
                System.out.println();
                System.out.println( "Has anat a: " + habitacioActual.getNom());

            } else {
                System.out.println("La porta esta tancada.");
            }
        }
    }

    public void agafarObjecte(int numeroObjecte) {

        objecte objecte = habitacioActual.obtenirObjecte(numeroObjecte);

        if (objecte == null) {

            System.out.println("Aquest objecte no existeix en aquesta habitacio.");

        } else {
            boolean afegit = inventari.afegirObjecte(objecte);

            if (afegit) {
                habitacioActual.treureObjecte(objecte);
            }
        }
    }

    public void deixarObjecte(int numeroObjecte) {

        objecte objecte =
                inventari.obtenirObjecte(numeroObjecte);

        if (objecte == null) {

            System.out.println(
                "Aquest objecte no existeix a l'inventari."
            );

        } else {

            inventari.treureObjecte(objecte);

            habitacioActual.afegirObjecte(objecte);
        }
    }

    public void usarObjecte(int numeroObjecte) {

        objecte objecte =
                inventari.obtenirObjecte(numeroObjecte);

        if (objecte == null) {

            System.out.println(
                "Aquest objecte no existeix a l'inventari."
            );

        } else {

            objecte.usar();
        }
    }

    public void mostrarInventari() {
        inventari.mostrarInventari();
    }
}