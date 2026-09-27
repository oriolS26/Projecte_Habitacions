import java.util.Scanner;
import Habitacions.*;

public class Joc {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Joc inici = new Joc();
        inici.start();
    }

    public void start() {

        String estatPartida = "";

        Jugador jugador1 = new Jugador();
        Alien alien1 = new Alien();
        Company companyia1 = new Company();
        Ordinador ordinador1 = new Ordinador();
        Inventari inventari1 = new Inventari();

        int ComptadorMoviments = 0;


        // HABITACIONS

        comandament comandament1 = new comandament();
        oficines oficines1 = new oficines();
        tallers tallers1 = new tallers();
        vestuari vestuari1 = new vestuari();
        cuina cuina1 = new cuina();
        menjador menjador1 = new menjador();
        banys banys1 = new banys();
        dormitori dormitori1 = new dormitori();
        salaSortidaExterior salaExterior1 = new salaSortidaExterior();
        propulsors propulsors1 = new propulsors();
    }

    public void mostrarMenu() {

    }
}