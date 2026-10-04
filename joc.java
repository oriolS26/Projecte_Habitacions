import Habitacions.Porta;
import Habitacions.habitacio;
import Objectes.objecte;
import java.util.Scanner;

public class joc {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        joc inici = new joc();
        inici.start();
    }
    public void start() {
        habitacio[] habitacions = crearHabitacions();

        Porta[] portes = crearPortes(habitacions);

        assignarPortes(habitacions, portes);

        objecte[] objectes = crearObjectes();

        assignarObjectes(habitacions, objectes);

        jugador jugador1 = crearJugador(habitacions);

        Alien alien1 = crearAlien(habitacions);

        Company companyia1 = crearCompany(habitacions);

        iniciarPartida(
                jugador1,
                alien1,
                companyia1,
                habitacions
        );
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("Opcions:");
        System.out.println("1. Moure");
        System.out.println("2. Agafar objecte");
        System.out.println("3. Deixar objecte");
        System.out.println("4. Usar objecte");
        System.out.println("5. Veure inventari");
        System.out.println("9. Parlar");
        System.out.println("0. Sortir del joc");

        System.out.print("Escull una opcio: ");
    }

    public habitacio[] crearHabitacions() {

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

        habitacio[] habitacions = {
                tallers,
                oficines,
                vestuari,
                banys,
                cuina,
                dormitori,
                comandament,
                menjador,
                salaSortida
        };

        return habitacions;
    }

    public Porta[] crearPortes(habitacio[] habitacions) {

        Porta porta1 = new Porta(
                "Porta Tallers - Oficines",
                habitacions[0],
                habitacions[1],
                false
        );

        Porta porta2 = new Porta(
                "Porta Oficines - Banys",
                habitacions[1],
                habitacions[3]
                ,true
        );

        Porta porta3 = new Porta(
                "Porta Vestuari - Comandament",
                habitacions[2],
                habitacions[6],
                false
        );

        Porta porta4 = new Porta(
                "Porta Comandament - Banys",
                habitacions[6],
                habitacions[3],
                true
        );

        Porta porta5 = new Porta(
                "Porta Vestuari - Cuina",
                habitacions[2],
                habitacions[4],
                false
        );

        Porta porta6 = new Porta(
                "Porta Banys - Dormitori",
                habitacions[3],
                habitacions[5],
                true
        );

        Porta porta7 = new Porta(
                "Porta Cuina - Menjador",
                habitacions[4],
                habitacions[7],
                false

        );

        Porta porta8 = new Porta(
                "Porta Dormitori - Menjador",
                habitacions[5],
                habitacions[7],
                false
        );

        Porta porta9 = new Porta(
                "Porta Menjador - Sala Exterior",
                habitacions[7],
                habitacions[8],
                true
        );

        Porta[] portes = {
                porta1,
                porta2,
                porta3,
                porta4,
                porta5,
                porta6,
                porta7,
                porta8,
                porta9
        };

        return portes;
    }

    public void assignarPortes(
       habitacio[] habitacions,
       Porta[] portes) {

        habitacions[0].afegirPorta(portes[0]);

        habitacions[1].afegirPorta(portes[0]);
        habitacions[1].afegirPorta(portes[1]);

        habitacions[2].afegirPorta(portes[2]);
        habitacions[2].afegirPorta(portes[4]);

        habitacions[3].afegirPorta(portes[1]);
        habitacions[3].afegirPorta(portes[3]);
        habitacions[3].afegirPorta(portes[5]);

        habitacions[4].afegirPorta(portes[4]);
        habitacions[4].afegirPorta(portes[6]);

        habitacions[5].afegirPorta(portes[5]);
        habitacions[5].afegirPorta(portes[7]);

        habitacions[6].afegirPorta(portes[2]);
        habitacions[6].afegirPorta(portes[3]);

        habitacions[7].afegirPorta(portes[6]);
        habitacions[7].afegirPorta(portes[7]);
        habitacions[7].afegirPorta(portes[8]);

        habitacions[8].afegirPorta(portes[8]);

        obrirPortesInicials(portes);
    }

    public void obrirPortesInicials(Porta[] portes) {

        portes[0].obrir();
        portes[4].obrir();
        portes[5].obrir();
        portes[6].obrir();
        portes[7].obrir();
    }

    public objecte[] crearObjectes() {

        objecte eina = new objecte(
                1,
                "Eina"
        );

        objecte llanterna = new objecte(
                2,
                "Llanterna"
        );

        objecte vestit = new objecte(
                3,
                "Vestit espacial"
        );

        objecte targeta = new objecte(
                4,
                "Targeta identificadora"
        );

        objecte targetaCompany = new objecte(
                5,
                "Targeta del company"
        );

        objecte donuts = new objecte(
                6,
                "Donuts"
        );

        objecte[] objectes = {
                eina,
                llanterna,
                vestit,
                targeta,
                targetaCompany,
                donuts
        };

        return objectes;
    }

    public void assignarObjectes(habitacio[] habitacions, objecte[] objectes) {
        habitacions[0].afegirObjecte(objectes[0]);
        habitacions[0].afegirObjecte(objectes[1]);
        habitacions[2].afegirObjecte(objectes[2]);
        habitacions[1].afegirObjecte(objectes[3]);
        habitacions[5].afegirObjecte(objectes[4]);
        habitacions[4].afegirObjecte(objectes[5]);
    }

    public jugador crearJugador(habitacio[] habitacions) {

        return new jugador(
                "Bond",
                habitacions[5]
        );
    }

    public Alien crearAlien(habitacio[] habitacions) {

        return new Alien(
                "Malien",
                habitacions[4]
        );
    }

    public Company crearCompany(habitacio[] habitacions) {

        return new Company(
                "Company",
                habitacions[5]
        );
    }

    public void iniciarPartida(
        jugador jugador1,
        Alien alien1,
        Company companyia1,
        habitacio[] habitacions) {

        int comptadorMoviments = 0;

        boolean continuar = true;

        while (continuar) {

                jugador1.getHabitacioActual().mostrarDeescripcio();

                mostrarMenu();

                int opcio = scanner.nextInt();

                if (opcio == 0) {

                continuar = false;

                } else if (opcio == 1) {

                comptadorMoviments =
                        moureJugador(
                                jugador1,
                                comptadorMoviments,
                                alien1,
                                companyia1,
                                habitacions
                        );

                } else if (opcio == 2) {

                agafarObjecte(jugador1);

                } else if (opcio == 3) {

                deixarObjecte(jugador1);

                } else if (opcio == 4) {

                usarObjecte(jugador1, alien1);

                } else if (opcio == 5) {

                jugador1.mostrarInventari();

                } else if (opcio == 9) {

                parlar(
                        jugador1,
                        alien1,
                        companyia1
                );

                } else {

                System.out.println("Opcio incorrecta.");
                }
        }

        System.out.println();
        System.out.println("Has sortit del joc.");
    }

    public int moureJugador(
        jugador jugador1,
        int comptadorMoviments,
        Alien alien1,
        Company companyia1,
        habitacio[] habitacions) {

        System.out.print("Escull una porta: ");

        int numeroPorta = scanner.nextInt();

        jugador1.moure(numeroPorta - 1);

        comptadorMoviments++;

        if (comptadorMoviments % 2 == 0) {

                alien1.moure(habitacions);
        }

        if (companyia1.estaDespert()) {

        companyia1.moure(habitacions);
}

        return comptadorMoviments;
    }

    public void agafarObjecte(jugador jugador1) {

        System.out.print("Escull un objecte: ");

        int numeroObjecte = scanner.nextInt();

        jugador1.agafarObjecte(numeroObjecte);
    }

    public void deixarObjecte(jugador jugador1) {

        jugador1.mostrarInventari();

        System.out.print("Escull un objecte: ");

        int numeroObjecte = scanner.nextInt();

        jugador1.deixarObjecte(numeroObjecte);
    }

        public void usarObjecte(jugador jugador1, Alien alien1) {

        jugador1.mostrarInventari();

        System.out.print("Escull un objecte: ");

        int numeroObjecte = scanner.nextInt();

        if (numeroObjecte == 6) {

                if (jugador1.getHabitacioActual() == alien1.getHabitacioActual()) {

                jugador1.usarObjecte(numeroObjecte);

                alien1.distreure(); } else {

                jugador1.usarObjecte(numeroObjecte);
                }

        } else {

                jugador1.usarObjecte(numeroObjecte);
        }
        }

    public void parlar(
                jugador jugador1,
                Alien alien1,
                Company companyia1) {

        if (jugador1.getHabitacioActual() ==
                alien1.getHabitacioActual()) {

                System.out.println("Malien: Grrrrr...");

        } else if (jugador1.getHabitacioActual() ==
                companyia1.getHabitacioActual()) {

                System.out.println("Company: Hola Bond!");

        } else {

                System.out.println(
                "No hi ha cap personatge en aquesta habitacio."
                );
        }
    }


}