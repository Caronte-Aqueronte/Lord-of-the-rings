package src.personajes;

public class Bestia extends Criatura {

    public Bestia(int vida, String nombre, int armadura, boolean vivoOmuerto) {
        super(vida, nombre, armadura, vivoOmuerto);
    }

    @Override
    public int getAtaque() {
        int dado1 = (int) (Math.random() * (100 - 0 + 1) + 0);
        return dado1;
    }
}
