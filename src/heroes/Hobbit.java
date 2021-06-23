
package src.heroes;

import src.personajes.Heroe;

public class Hobbit extends Heroe {

    public Hobbit(String nombre, int armadura) {
        super(200, nombre, armadura, true);
    }
    @Override
    public String toString(){
        return "Hobbit "+getNombre();
    }
}
