package src.heroes;

import src.personajes.Heroe;

public class Elfo extends Heroe {

    public Elfo(String nombre, int armadura) {
        super(250, nombre, armadura, true);
    }  
    @Override
    public String toString(){
        return "Elfo "+getNombre();
    }
}
