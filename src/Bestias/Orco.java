
package src.Bestias;

import src.personajes.Bestia;

public class Orco extends Bestia {

    public Orco(String nombre, int armadura) {
        super(300, nombre, armadura, true);
    }
    
    @Override
    public String toString(){
        return "Orco "+getNombre();
    }
}
