import Habitacions.Porta;
import Habitacions.habitacio;
import Objectes.objecte;

public class jugador {
    private String nom;
    private habitacio habitacioActual;
    private inventari inventari;
    private boolean tallerIluminat;
    private boolean propulsorsReparats;
    private boolean vestitPosat;
    private boolean llanternaEncesa;

    public jugador(String nom, habitacio habitacioActual) {
        this.nom = nom;
        this.habitacioActual = habitacioActual;
        this.inventari = new inventari();
        this.tallerIluminat = false;
        this.propulsorsReparats = false;
        this.vestitPosat = false;
        this.llanternaEncesa = false;
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

    public boolean isTallerIluminat() {
        return tallerIluminat;
    }

    public boolean isPropulsorsReparats() {
        return propulsorsReparats;
    }

    public boolean isVestitPosat() {
        return vestitPosat;
    }

    public boolean isLlanternaEncesa() {
        return llanternaEncesa;
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
                if (portaEscollida.estaOberta()) {

            habitacio novaHabitacio =
                    portaEscollida.obtenirAltraHabitacio(
                            habitacioActual
                    );

            habitacioActual = novaHabitacio;

            System.out.println();
            System.out.println(
                "Has anat a: " + habitacioActual.getNom()
            );

            } else {

                    if (portaEscollida.necessitaTargeta()) {

                        if (inventari.comprovarObjecte("Targeta identificadora") || inventari.comprovarObjecte("Targeta del company")) {

                            portaEscollida.obrir();

                            habitacio novaHabitacio =
                                    portaEscollida.obtenirAltraHabitacio(
                                            habitacioActual
                                    );

                            habitacioActual = novaHabitacio;

                            System.out.println(
                                "Has utilitzat la targeta i has obert la porta."
                            );

                            System.out.println(
                                "Has anat a: " + habitacioActual.getNom()
                            );

                        } else {

                            System.out.println(
                                "Aquesta porta necessita una targeta."
                            );
                        }

                    } else {

                        System.out.println(
                            "La porta esta tancada."
                        );
                    }
                }
            }
        }
    }

    public void agafarObjecte(int numeroObjecte) {

        objecte objecte = habitacioActual.obtenirObjecte(numeroObjecte);

        if (objecte == null) {

            System.out.println("Aquest objecte no existeix en aquesta habitacio.");

        } else {

            if (objecte.getNom().equalsIgnoreCase("Eina")) {

                if (!llanternaEncesa) {

                    System.out.println(
                        "Esta massa fosc per trobar l'eina."
                    );

                    return;
                }
            }

            boolean afegit =
                    inventari.afegirObjecte(objecte);

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

        objecte objecte = inventari.obtenirObjecte(numeroObjecte);

        if (objecte == null) {

            System.out.println(
                "Aquest objecte no existeix a l'inventari."
            );

        } else {

            if (objecte.getNom().equalsIgnoreCase("Llanterna")) {

                usarLlanterna();

            } else if (objecte.getNom().equalsIgnoreCase("Vestit espacial")) {

                usarVestit();

            } else if (objecte.getNom().equalsIgnoreCase("Eina")) {

                usarEina();

            } else if (objecte.getNom().equalsIgnoreCase("Targeta identificadora")) {

                usarTargeta();

            } else if (objecte.getNom().equalsIgnoreCase("Targeta del company")) {

                usarTargetaCompany();

            } else if (objecte.getNom().equalsIgnoreCase("Donuts")) {

                usarDonuts();
            }
        }
    }

    private void usarLlanterna() {

        if (habitacioActual.getNom().equalsIgnoreCase("Tallers")) {

            if (!llanternaEncesa) {

                llanternaEncesa = true;

                System.out.println(
                    "Has encès la llanterna."
                );

                System.out.println(
                    "Ara pots veure l'interior dels tallers."
                );

            } else {

                System.out.println(
                    "La llanterna ja està encesa."
                );
            }

        } else {

            System.out.println(
                "No necessites utilitzar la llanterna aquí."
            );
        }
    }

    private void usarVestit() {

        if (habitacioActual.getNom().equalsIgnoreCase("Sala Sortida Exterior")) {

            vestitPosat = true;

            System.out.println(
                "T'has posat el vestit espacial."
            );

            System.out.println(
                "Ara pots sortir a la zona exterior."
            );

        } else {

            System.out.println(
                "No cal posar-se el vestit espacial aquí."
            );
        }
    }

    private void usarEina() {

        if (habitacioActual.getNom().equalsIgnoreCase("Sala Sortida Exterior")) {

            if (!vestitPosat) {

                System.out.println(
                    "No pots reparar els propulsors sense el vestit espacial."
                );

            } else if (!propulsorsReparats) {

                propulsorsReparats = true;

                System.out.println(
                    "Has utilitzat l'eina per reparar els propulsors."
                );

                System.out.println(
                    "Els propulsors han estat reparats."
                );

            } else {

                System.out.println(
                    "Els propulsors ja estan reparats."
                );
            }

        } else {

            System.out.println(
                "Aquí no pots utilitzar l'eina per reparar els propulsors."
            );
        }
    }

    private void usarTargeta() {

        System.out.println(
            "Has utilitzat la targeta identificadora."
        );

        System.out.println(
            "La targeta et permetrà obrir portes restringides."
        );
    }

    private void usarTargetaCompany() {

        System.out.println(
            "Has utilitzat la targeta del company."
        );

        System.out.println(
            "Aquesta targeta permet accedir a zones restringides."
        );
    }

    private void usarDonuts() {

        System.out.println(
            "Has tret els donuts."
        );

        System.out.println(
            "Poden servir per distreure algú..."
        );
    }

    public void mostrarInventari() {
        inventari.mostrarInventari();
    }
}
