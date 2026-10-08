import Habitacions.Porta;
import Habitacions.habitacio;
import Objectes.objecte;
import java.util.Scanner;

public class joc {
    public static Scanner scanner = new Scanner(System.in);

    private int instruccionsPerMorir = -1;
    public static void main(String[] args) {
        joc inici = new joc();
        inici.start();
    }
    public void start() {
        mostrarHistoria();
        habitacio[] habitacions = crearHabitacions();

        Porta[] portes = crearPortes(habitacions);

        assignarPortes(habitacions, portes);

        objecte[] objectes = crearObjectes();

        assignarObjectes(habitacions, objectes);

        jugador jugador1 = crearJugador(habitacions);

        Alien alien1 = crearAlien(habitacions);

        Company companyia1 = crearCompany(habitacions);

        Ordinador ordinador1 = new Ordinador("iHall");

        iniciarPartida(jugador1, alien1, companyia1, ordinador1, habitacions);
    }

    public void mostrarHistoria() {

        System.out.println();

        escriureLent("ANY 2120 D.C.", 30);
        System.out.println();

        escriureLent("La nau PiaXXII explora l'espai inhòspit en direcció al planeta SUMMEM on es creu que hi poden haver les condicions idònies per arrelar una nova vida, que ja no és possible dur a terme en el planeta Pia. " + "Després d'un llarg període d'hivernació provocada pel llarg viatge al planeta SUMMEM, el cap de la tripulació de la PiaXXII es desperta del son induït. " + "L'ordinador de la nau iHall ha detectat una anomalia en el sistema i necessita de la intervenció del cap de la tripulació per resoldre'l.", 5);

        System.out.println();

        escriureLent("- Que tal ha dormit capità Bond? Em sap greu destorbar-lo però he detectat una anomalia a la nau. Sembla ser que se'ns gira feina.", 5);
        System.out.println();
        escriureLent("- Coi de ferralla \"intel·ligent\"! - En Bond està altament irritat ja que el somni no podia ser d'allò més excitant i realista... Espero que hagi estat indispensable haver-me destorbat el son! Sinó prepara't perquè et programi unes quantes sessions de Treball cooperatiu amb un pedagog inspirat...",5);
        System.out.println();
        escriureLent("- Li garanteixo, capità Bond, que no és una falsa alarma. No m'arriscaria a patir un càstig similar...",5);
        System.out.println();
        escriureLent("- Està bé, iHall - murmurà el capità ja més despert i calmat - donem l'informe de la situació i anem per feina! Que vull tornar a agafar el son.",5);
        System.out.println();
        escriureLent("iHall procedeix a explicar detalladament la situació al capità. Resulta que hem xocat amb un petit aeròlit que ha provocat petits danys al sistema de propulsió de la nau que requereixen de la intervenció humana.",5);
        System.out.println();
        escriureLent("Des dels dormitoris cal arribar a la zona de motors i propulsió. Les diferents zones estan unides per portes automàtiques que cal obrir amb la targeta personal de cada un dels tripulants però en Bond no recorda on l'ha deixat. Sense la targeta, depèn al 100% de la comunicació amb iHall perquè li vagi obrint les portes entre zones.",5);
        System.out.println();
        escriureLent("Darrerament però iHall està un pel transposat i en moltes ocasions no fa cas a en Bond i el posa a prova donant-li pistes o indicacions falses. Potser pot intentar agafar alguna de les targetes dels companys o intentar buscar-la per la nau.",5);
        System.out.println();
        escriureLent("Per aconseguir reparar els motors, cal posar-se el vestit d'astronauta que està al vestuari. Sense ell no es podria sobreviure a l'exterior de la nau. Compte però que, revivint la famosa saga d'en Ridley Scott, tenim un Alien donant voltes per la nau.",5);
        System.out.println();
        escriureLent("Se'l coneix amb el nom de \"Malien\", i s'ha colat a la nau per intentar sabotejar la missió. En Malien només té un punt dèbil, li agraden els dònuts! Per tant, si ens trobem amb ell, potser serà l'única manera de poder-lo distreure perquè ens deixi tranquils.",5);
        System.out.println();
        escriureLent("Necessitarem una eina especial per poder reparar els motors. L'eina està al taller de la nau.",5);
        System.out.println();
        escriureLent("Un cop arreglem els propulsors del motor, haurem de córrer cap a la zona de la sala de comandaments per posar novament en marxa els motors.",5);
        System.out.println();
        escriureLent("Podrà en Bond amb en Malien? Podrà reparar els motors i aconseguir prosseguir la seva missió el PiaXXII cap a SUMMEM?",20);
        System.out.println();
        System.out.println("========================================");
        System.out.println("          COMENÇA L'AVENTURA");
        System.out.println("========================================");
        System.out.println();
    }

    public void escriureLent(String text, int velocitat) {

        for (int i = 0; i < text.length(); i++) {

                System.out.print(text.charAt(i));

                try {
                Thread.sleep(velocitat);
                } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                }
        }

        System.out.println();
    }

    public void mostrarMenu() {
        System.out.println();
        System.out.println("Opcions:");
        System.out.println("1. Moure");
        System.out.println("2. Agafar objecte");
        System.out.println("3. Deixar objecte");
        System.out.println("4. Usar objecte");
        System.out.println("5. Veure inventari");
        System.out.println("6. Parlar amb iHall");
        System.out.println("7. Parlar");
        System.out.println("0. Sortir del joc");

        System.out.print("Escull una opcio: ");
    }

    public habitacio[] crearHabitacions() {

        habitacio tallers = new habitacio("Tallers","Zona on es troben les eines de reparacio.");

        habitacio oficines = new habitacio("Oficines","Zona d'oficines de la nau.");

        habitacio vestuari = new habitacio("Vestuari","Zona on es troba el vestit d'astronauta.");

        habitacio banys = new habitacio("Banys","Banys de la nau.");

        habitacio cuina = new habitacio("Cuina","Zona on es preparen els aliments.");

        habitacio dormitori = new habitacio("Dormitori","Zona on descansa la tripulacio.");

        habitacio comandament = new habitacio("Comandament","Sala principal de control de la nau.");

        habitacio menjador = new habitacio("Menjador","Zona on menja la tripulacio.");

        habitacio salaSortida = new habitacio("Sala Sortida Exterior","Zona d'acces als propulsors.");

        habitacio[] habitacions = {tallers,oficines,vestuari,banys,cuina,dormitori,comandament,menjador,salaSortida};

        return habitacions;
    }

    public Porta[] crearPortes(habitacio[] habitacions) {

        Porta porta1 = new Porta("Porta Tallers - Oficines",habitacions[0],habitacions[1],false);

        Porta porta2 = new Porta("Porta Oficines - Banys",habitacions[1],habitacions[3],false);

        Porta porta3 = new Porta("Porta Vestuari - Comandament",habitacions[2],habitacions[6],false);

        Porta porta4 = new Porta("Porta Comandament - Banys",habitacions[6],habitacions[3],false);

        Porta porta5 = new Porta("Porta Vestuari - Cuina",habitacions[2],habitacions[4],false);

        Porta porta6 = new Porta("Porta Banys - Dormitori",habitacions[3],habitacions[5],false);

        Porta porta7 = new Porta("Porta Cuina - Menjador",habitacions[4],habitacions[7],false);

        Porta porta8 = new Porta("Porta Dormitori - Menjador",habitacions[5],habitacions[7],false);

        Porta porta9 = new Porta("Porta Menjador - Sala Exterior",habitacions[7],habitacions[8],true);

        Porta[] portes = {porta1,porta2,porta3,porta4,porta5,porta6,porta7,porta8, porta9};

        return portes;
    }

    public void assignarPortes(habitacio[] habitacions, Porta[] portes) {

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
        portes[1].obrir();
        portes[2].obrir();
        portes[3].obrir();
        portes[4].obrir();
        portes[5].obrir();
        portes[6].obrir();
        portes[7].obrir();
    }

    public objecte[] crearObjectes() {

        objecte eina = new objecte(1, "Eina");

        objecte llanterna = new objecte(2, "Llanterna");

        objecte vestit = new objecte(3, "Vestit espacial");

        objecte targeta = new objecte(4, "Targeta identificadora");

        objecte targetaCompany = new objecte(5, "Targeta del company");

        objecte donuts = new objecte(6, "Donuts");

        objecte[] objectes = {eina, llanterna, vestit, targeta, targetaCompany, donuts};

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

        return new jugador("Bond", habitacions[5]);
    }

    public Alien crearAlien(habitacio[] habitacions) {

        return new Alien("Malien", habitacions[7]);
    }

    public Company crearCompany(habitacio[] habitacions) {

        return new Company("Company", habitacions[5]);
    }

    public void iniciarPartida(jugador jugador1, Alien alien1, Company companyia1, Ordinador ordinador1, habitacio[] habitacions) {

        int comptadorMoviments = 0;

        instruccionsPerMorir = -1;

        boolean continuar = true;



        while (continuar) {

                jugador1.getHabitacioActual().mostrarDeescripcio();

                mostrarMenu();

                int opcio = demanarNumero(0, 7);

                boolean cuentaAtrasActiva = instruccionsPerMorir > 0;

                if (opcio == 0) {

                continuar = false;

                } else if (opcio == 1) {

                comptadorMoviments = moureJugador(jugador1, comptadorMoviments, alien1, companyia1, habitacions);
                
                if (comptadorMoviments == -1) {
                continuar = false;
                }

                } else if (opcio == 2) {

                agafarObjecte(jugador1, companyia1);

                } else if (opcio == 3) {

                deixarObjecte(jugador1);

                } else if (opcio == 4) {

                usarObjecte(jugador1, alien1);

                } else if (opcio == 5) {

                jugador1.mostrarInventari();

                } else if (opcio == 6) {

                parlarAmbIHall(jugador1, alien1, ordinador1, habitacions);

                } else if (opcio == 7) {

                parlar(jugador1, alien1, companyia1);

                } else {

                System.out.println("Opcio incorrecta.");
                }

                if (continuar && cuentaAtrasActiva && opcio >= 1 && opcio <= 7) {

                        instruccionsPerMorir--;

                        if (instruccionsPerMorir <= 0) {

                                System.out.println();
                                System.out.println("El Malien petit surt del teu estomac...");
                                System.out.println("HAS MORT.");
                                System.out.println();

                                continuar = false;

                        } else {

                                System.out.println();
                                System.out.println(
                                    "Notes un dolor a l'estomac... Et queden "
                                    + instruccionsPerMorir + " instruccions."
                                );
                        }
                }
        }

        System.out.println();
        System.out.println("Has sortit del joc.");
    }

    public int demanarNumero(int minim, int maxim) {

        int numero = 0;
        boolean correcte = false;

        while (!correcte) {

                try {

                numero = scanner.nextInt();

                if (numero >= minim && numero <= maxim) {

                        correcte = true;

                } else {

                        System.out.println("Has d'introduir un numero entre "
                                + minim + " i " + maxim);
                }

                } catch (InputMismatchException e) {

                System.out.println("Has d'introduir un numero.");
                scanner.nextLine();
                }
        }

        return numero;
    }

    public int moureJugador(jugador jugador1, int comptadorMoviments,Alien alien1,Company companyia1, habitacio[] habitacions) {

        System.out.print("Escull una porta: ");

        int numeroPorta = scanner.nextInt();
        habitacio habitacioAnterior = jugador1.getHabitacioActual();

        jugador1.moure(numeroPorta - 1);

        if (jugador1.getHabitacioActual() == habitacioAnterior) {

                return comptadorMoviments;
        }

        comptadorMoviments++;

        if (comprobarMalien(jugador1, alien1)) {
                return -1;
        }

        if (comptadorMoviments % 2 == 0) {

                alien1.moure(habitacions);

        if (comprobarMalien(jugador1, alien1)) {
                return -1;
        }
        }

        if (companyia1.estaDespert()) {

                companyia1.moure(habitacions);
        }

        if (comprobarCompanyMalien(companyia1, alien1)) {
                return -1;
        }

        return comptadorMoviments;
    }

    public void agafarObjecte(jugador jugador1, Company companyia1) {

        System.out.print("Escull un objecte: ");

        int numeroObjecte = scanner.nextInt();

        objecte seleccionat = jugador1.getHabitacioActual().obtenirObjecte(numeroObjecte);

        if (seleccionat != null
                && seleccionat.getNom().equalsIgnoreCase("Targeta del company")
                && !companyia1.estaDespert()) {

            System.out.println("El Company porta la targeta posada i dorm. " + "Cal despertar-lo primer (Parlar).");

            return;
        }

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

                objecte seleccionat = jugador1.obtenirObjecteInventari(numeroObjecte);

                jugador1.usarObjecte(numeroObjecte);

                if (seleccionat != null
                        && seleccionat.getNom().equalsIgnoreCase("Eina")
                        && jugador1.getHabitacioActual() == alien1.getHabitacioActual()
                        && instruccionsPerMorir < 0) {

                        instruccionsPerMorir = 7;

                        System.out.println();
                        System.out.println("Has atacat el Malien amb l'eina.");
                        System.out.println("Se't cola directament per la gola!");
                        System.out.println("Et queden 7 instruccions.");
                }
        }

        public void parlarAmbIHall(
                jugador jugador1,
                Alien alien1,
                Ordinador ordinador1,
                habitacio[] habitacions) {

                System.out.println();
                System.out.println("Que vols preguntar a iHall?");
                System.out.println("1. On es el Malien?");
                System.out.println("2. On es la llanterna?");
                System.out.println("3. Obrir una porta");
                System.out.print("Escull una opcio: ");

                int opcio = scanner.nextInt();

                if (opcio == 1) {

                        ordinador1.dirOnEstaMalien(alien1);

                } else if (opcio == 2) {

                        ordinador1.dirOnEstaLlanterna(habitacions);

                } else if (opcio == 3) {

                        System.out.print("Quina porta vols que obri: ");

                        int numeroPorta = scanner.nextInt();

                        ordinador1.obrirPorta(jugador1.getHabitacioActual().obtenirPorta(numeroPorta - 1));

                } else {

                        System.out.println("iHall: No t'he entes.");
                }
        }

        public boolean comprobarMalien(jugador jugador1, Alien alien1) {

                if (alien1.estaDistret()) {
                        return false;
                }

                if (jugador1.getHabitacioActual() == alien1.getHabitacioActual()) {

                        System.out.println();
                        System.out.println("=================================");
                        System.out.println("     T'HA PILLAT EL MALIEN!");
                        System.out.println("=================================");
                        System.out.println();

                        if (jugador1.teDonuts()) {

                        System.out.println("Tens donuts.");
                        System.out.println("Vols donar-li els donuts al Malien?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        System.out.print("Escull una opcio: ");

                        int opcio = scanner.nextInt();

                        if (opcio == 1) {

                                jugador1.donarDonuts(alien1);

                                System.out.println();
                                System.out.println("Has pogut escapar!");
                                System.out.println();

                                return false;

                        } else {

                                System.out.println();
                                System.out.println("No li has donat els donuts.");
                                System.out.println("El Malien t'ha atrapat.");
                                System.out.println("HAS MORT.");
                                System.out.println();

                                return true;
                        }

                        } else {

                        System.out.println();
                        System.out.println("No tens donuts.");
                        System.out.println("El Malien t'ha atrapat.");
                        System.out.println("HAS MORT.");
                        System.out.println();

                        return true;
                        }
                }

                return false;
        }

        public boolean comprobarCompanyMalien(Company companyia1, Alien alien1) {

                if (!companyia1.estaDespert() || alien1.estaDistret()) {
                        return false;
                }

                if (companyia1.getHabitacioActual() == alien1.getHabitacioActual()) {

                        System.out.println();
                        System.out.println("=================================");
                        System.out.println("  EL MALIEN HA TROBAT EL COMPANY!");
                        System.out.println("=================================");
                        System.out.println();
                        System.out.println("FI DE LA PARTIDA.");
                        System.out.println();

                        return true;
                }

                return false;
        }

    public void parlar(jugador jugador1, Alien alien1, Company companyia1) {

        if (jugador1.getHabitacioActual() == alien1.getHabitacioActual()) {

                System.out.println("Malien: Grrrrr...");

        } else if (jugador1.getHabitacioActual() == companyia1.getHabitacioActual()) {

                if (!companyia1.estaDespert()) {

                        companyia1.despertar();

                } else {

                        System.out.println("Company: Hola Bond!");
                }
        } else {

                System.out.println("No hi ha cap personatge en aquesta habitacio.");
        }
    }


}