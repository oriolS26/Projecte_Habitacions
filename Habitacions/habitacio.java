package Habitacions;

public class habitacio {
    
    protected String nom;
    protected String descripcio;

    public habitacio(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
    }

    public String getNom() {
        return nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void mostrarDeescripcio() {
        System.out.println();
        System.out.println("===============================");
        System.out.println("                   " + nom);
        System.out.println("===============================");
        System.out.println();
        System.out.println(descripcio);
        System.out.println();
    }
}
