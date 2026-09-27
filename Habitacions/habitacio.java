package Habitacions;

public class habitacio {

    protected String nom;
    protected String descripcio;
    protected Porta[] portes;

    public habitacio(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.portes = new Porta[4];
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

                String estat = portes[i].estaOberta()
                        ? "oberta"
                        : "tancada";

                System.out.println(
                    (i + 1) + ". "
                    + portes[i].getNom()
                    + " - "
                    + estat
                );
            }
        }

        System.out.println();
    }
}