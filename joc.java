import java.util.Scanner;
import Habitacions.Porta;
import Habitacions.habitacio;

public class joc {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        joc inici = new joc();
        inici.start();
    }
    public void start() {
        habitacio tallers = new habitacio(
                "Tallers",
                "Zona on es troben les eines de reparacio."
        );

        habitacio oficines = new habitacio(
                "Oficines",
                "Zona d'oficines de la nau."
        );

        habitacio vestuari = new habitacio(
                "Vestuari",
                "Zona on es troba el vestit d'astronauta."
        );

        habitacio banys = new habitacio(
                "Banys",
                "Banys de la nau."
        );

        habitacio cuina = new habitacio(
                "Cuina",
                "Zona on es preparen els aliments."
        );

        habitacio dormitori = new habitacio(
                "Dormitori",
                "Zona on descansa la tripulacio."
        );

        habitacio comandament = new habitacio(
                "Comandament",
                "Sala principal de control de la nau."
        );

        habitacio menjador = new habitacio(
                "Menjador",
                "Zona on menja la tripulacio."
        );

        habitacio salaSortida = new habitacio(
                "Sala Sortida Exterior",
                "Zona d'acces als propulsors."
        );


        // CREAR PORTES

        Porta porta1 = new Porta(
                "Porta Tallers - Oficines",
                tallers,
                oficines
        );

        Porta porta2 = new Porta(
                "Porta Oficines - Banys",
                oficines,
                banys
        );

        Porta porta3 = new Porta(
                "Porta Vestuari - Comandament",
                vestuari,
                comandament
        );

        Porta porta4 = new Porta(
                "Porta Comandament - Banys",
                comandament,
                banys
        );

        Porta porta5 = new Porta(
                "Porta Vestuari - Cuina",
                vestuari,
                cuina
        );

        Porta porta6 = new Porta(
                "Porta Banys - Dormitori",
                banys,
                dormitori
        );

        Porta porta7 = new Porta(
                "Porta Cuina - Menjador",
                cuina,
                menjador
        );

        Porta porta8 = new Porta(
                "Porta Dormitori - Menjador",
                dormitori,
                menjador
        );

        Porta porta9 = new Porta(
                "Porta Menjador - Sala Exterior",
                menjador,
                salaSortida
        );



        tallers.afegirPorta(porta1);

        oficines.afegirPorta(porta1);
        oficines.afegirPorta(porta2);

        vestuari.afegirPorta(porta3);
        vestuari.afegirPorta(porta5);

        banys.afegirPorta(porta2);
        banys.afegirPorta(porta4);
        banys.afegirPorta(porta6);

        cuina.afegirPorta(porta5);
        cuina.afegirPorta(porta7);

        dormitori.afegirPorta(porta6);
        dormitori.afegirPorta(porta8);

        comandament.afegirPorta(porta3);
        comandament.afegirPorta(porta4);

        menjador.afegirPorta(porta7);
        menjador.afegirPorta(porta8);
        menjador.afegirPorta(porta9);

        salaSortida.afegirPorta(porta9);


        porta1.obrir();
        porta2.obrir();
        porta3.obrir();
        porta4.obrir();
        porta5.obrir();
        porta6.obrir();
        porta7.obrir();
        porta8.obrir();
        porta9.obrir();



        jugador jugador1 = new jugador(
                "Bond",
                dormitori
        );

        boolean continuar = true;

        while (continuar) {

            jugador1.getHabitacioActual().mostrarDeescripcio();

            System.out.println("0. Sortir del joc");
            System.out.print("Escull una porta: ");

            int opcio = scanner.nextInt();

            if (opcio == 0) {

                continuar = false;

            } else {

                jugador1.moure(opcio - 1);
            }
        }

        System.out.println();
        System.out.println("Has sortit del joc.");
    }
        

    public void mostrarMenu() {
        
    }

}