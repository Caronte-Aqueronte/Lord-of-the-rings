package src.personajes;

public class Heroe extends Criatura {

    public Heroe(int vida, String nombre, int armadura, boolean vivoOMuerto) {
        super(vida, nombre, armadura, vivoOMuerto);
    }

   @Override
    public int getAtaque() {
        int dado1 = (int) (Math.random() * (100 - 0 + 1) + 0);
        int dado2 = (int) (Math.random() * (100 - 0 + 1) + 0);
        if(dado1 > dado2){
            return dado1;
        }
        return dado2;
    }
}
