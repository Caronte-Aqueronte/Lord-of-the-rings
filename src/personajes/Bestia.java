package src.personajes;

public class Bestia extends Criatura {

    public Bestia(int vida, String nombre, int armadura, boolean vivoOmuerto) {
        super(vida, nombre, armadura, vivoOmuerto);
    }

    public int asignarAtaque() {
        int dado1 = (int) (Math.random() * (90 - 0 + 1) + 0);
        return dado1;
    }
}
