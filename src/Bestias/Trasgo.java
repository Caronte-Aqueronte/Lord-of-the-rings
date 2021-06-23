
package src.Bestias;

import src.personajes.Bestia;

public class Trasgo extends Bestia {

    public Trasgo(String nombre, int armadura) {
        super(325, nombre, armadura, true);
    }
    @Override
    public String toString(){
        return "Trasgo "+getNombre();
    }
}
