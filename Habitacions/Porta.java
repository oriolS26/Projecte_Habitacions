package Habitacions;

public class Porta {

    private String nom;
    private habitacio habitacio1;
    private habitacio habitacio2;
    private boolean oberta;
    private boolean necessitaTargeta;

    public Porta(String nom, habitacio habitacio1, habitacio habitacio2, boolean necessitaTargeta) {
        this.nom = nom;
        this.habitacio1 = habitacio1;
        this.habitacio2 = habitacio2;
        this.oberta = false;
        this.necessitaTargeta = necessitaTargeta;
    }

    public String getNom() {
        return nom;
    }

    public boolean estaOberta() {
        return oberta;
    }

    public void obrir() {
        oberta = true;
    }

    public boolean necessitaTargeta() {
        return necessitaTargeta;
    }

    public void tancar() {
        oberta = false;
        System.out.println("La porta s'ha tancat.");
    }

    public habitacio obtenirAltraHabitacio(habitacio habitacioActual) {

        if (habitacioActual == habitacio1) {
            return habitacio2;
        }

        if (habitacioActual == habitacio2) {
            return habitacio1;
        }

        return null;
    }
}