public class Jugador {
    String nom;
    Habitacio habitacioActual;

    public Jugador(String nom, Habitacio habitacioInicial) {
        this.nom = nom;
        this.habitacioActual = habitacioInicial;
    }
    
    public void moure(Porta numeroPorta) {

        Porta portaEscollida = habitacioActual.obtenirPorta(numeroPorta);

        if(portaEscollida == null) {

            System.out.println("Aquesta porta no existeix en aquesta habitacio.");

            } else {

            if (portaEscollida.oberta) {

                habitacioActual =
                portaEscollida.obtenirAltraHabitacio(habitacioActual);
            
            System.out.println();
            System.out.println( "Has anat a: " + habitacioActual.nom);
                } else {

                System.out.println("La porta esta tancada.");
                }
            }
    }
}