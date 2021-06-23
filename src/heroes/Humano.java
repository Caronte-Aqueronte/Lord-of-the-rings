package src.heroes;

import src.personajes.Heroe;

public class Humano extends Heroe {

    public Humano(String nombre, int armadura) {
        super(180, nombre, armadura, true);
    }
@Override
    public String toString(){
        return "Humano "+getNombre();
    }
}
