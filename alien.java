public class Alien {
    protected String nom;
    protected Habitacions.habitacio habitacioActual;
    protected int moviments;
    protected boolean distret;

    public Alien(String nom, Habitacions.habitacio habitacioActual) {
        this.nom = nom;
        this.habitacioActual = habitacioActual;
        this.moviments = 0;
        this.distret = false;
    }

    public String getNom() {
        return nom;
    }

    public Habitacions.habitacio getHabitacioActual() {
        return habitacioActual;
    }

    public void setHabitacioActual(Habitacions.habitacio habitacioActual) {
        this.habitacioActual = habitacioActual;
    }

    public int getMoviments() {
        return moviments;
    }


}
