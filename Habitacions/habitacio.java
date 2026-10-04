package Habitacions;

import Objectes.objecte;



public class habitacio {

    protected String nom;
    protected String descripcio;
    protected Porta[] portes;
    protected objecte[] objectes;

    public habitacio(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.portes = new Porta[4];
        this.objectes = new objecte[6];
    }

    public String getNom() {
        return nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void afegirPorta(Porta porta) {

        for (int i = 0; i < portes.length; i++) {

            if (portes[i] == null) {
                portes[i] = porta;
                return;
            }
        }
    }

    public Porta obtenirPorta(int numero) {

        if (numero < 0 || numero >= portes.length) {
            return null;
        }

        return portes[numero];
    }

    public void afegirObjecte(objecte objecte) {

    for (int i = 0; i < objectes.length; i++) {

            if (objectes[i] == null) {
                objectes[i] = objecte;
                return;
            }
        }

        System.out.println("No hi ha espai per aquest objecte.");
    }

    public objecte obtenirObjecte(int numero) {

        if (numero < 1 || numero > objectes.length) {
            return null;
        }

        return objectes[numero - 1];
    }

    public void treureObjecte(objecte objecte) {

        for (int i = 0; i < objectes.length; i++) {
            if (objectes[i] == objecte) {
                objectes[i] = null;
                return;
            }
        }
    }

    public void mostrarObjectes() {

        boolean hiHaObjectes = false;

        System.out.println("Objectes de l'habitacio:");

        for (int i = 0; i < objectes.length; i++) {

            if (objectes[i] != null) {

                System.out.println(
                    (i + 1) + ". " + objectes[i].getNom()
                );

                hiHaObjectes = true;
            }
        }

        if (!hiHaObjectes) {
            System.out.println("No hi ha objectes.");
        }

        System.out.println();
    }

    public void mostrarDeescripcio() {

        System.out.println();
        System.out.println("===============================");
        System.out.println("           " + nom);
        System.out.println("===============================");
        System.out.println();
        System.out.println(descripcio);
        System.out.println();

        System.out.println("Portes:");

        for (int i = 0; i < portes.length; i++) {

            if (portes[i] != null) {

                String estat;

                if (portes[i].estaOberta()) {
                    estat = "oberta";
                } else {
                    estat = "tancada";
                }

                System.out.println(
                    (i + 1) + ". "
                    + portes[i].getNom()
                    + " - "
                    + estat
                );
            }
        }
        System.out.println();

        mostrarObjectes();
    }
}