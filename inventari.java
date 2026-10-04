import Objectes.objecte;

public class inventari {

    private objecte[] objectes;

    public inventari() {

        objectes = new objecte[6];
    }

    public boolean afegirObjecte(objecte objecte) {

        for (int i = 0; i < objectes.length; i++) {

            if (objectes[i] == null) {

                objectes[i] = objecte;

                objecte.agafar();

                System.out.println(
                    "Has agafat: " + objecte.getNom()
                );

                return true;
            }
        }

        System.out.println("L'inventari esta ple.");
        return false;
    }

    public void treureObjecte(objecte objecte) {

        for (int i = 0; i < objectes.length; i++) {

            if (objectes[i] == objecte) {

                objectes[i] = null;

                objecte.deixar();

                System.out.println(
                    "Has deixat: " + objecte.getNom()
                );

                return;
            }
        }

        System.out.println(
            "Aquest objecte no esta a l'inventari."
        );
    }

    public objecte obtenirObjecte(int numero) {

        if (numero < 1 || numero > objectes.length) {

            return null;
        }

        return objectes[numero - 1];
    }

    public boolean comprovarObjecte(String nom) {

        for (int i = 0; i < objectes.length; i++) {

            if (objectes[i] != null) {

                if (objectes[i].getNom().equalsIgnoreCase(nom)) {

                    return true;
                }
            }
        }

        return false;
    }

    public void mostrarInventari() {

        System.out.println();
        System.out.println("===============================");
        System.out.println("          INVENTARI");
        System.out.println("===============================");

        boolean hiHaObjectes = false;

        for (int i = 0; i < objectes.length; i++) {

            if (objectes[i] != null) {

                System.out.println(
                    (i + 1) + ". " + objectes[i].getNom()
                );

                hiHaObjectes = true;
            }
        }

        if (!hiHaObjectes) {

            System.out.println("L'inventari esta buit.");
        }

        System.out.println();
    }
}