package Objectes;

public class objecte {

    private int id;
    private String nom;
    private boolean disponible;
    private boolean alInventari;

    public objecte(int id, String nom) {

        this.id = id;
        this.nom = nom;
        this.disponible = true;
        this.alInventari = false;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public boolean estaAlInventari() {
        return alInventari;
    }

    public void agafar() {

        disponible = false;
        alInventari = true;
    }

    public void deixar() {

        disponible = true;
        alInventari = false;
    }

    public void usar() {

        System.out.println("Has utilitzat: " + nom);
    }
}