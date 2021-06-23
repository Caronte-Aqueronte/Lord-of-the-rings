package src.principal;

import src.heroes.*;
import src.personajes.*;
import src.Bestias.*;

public class Principal {

    public static void main(String[] args) {
        Principal principal = new Principal();
    }
    Heroe[] heroes = new Heroe[9];
    Bestia[] bestias = new Bestia[9];
    private String[] nombres = {"Caronte", "Leonisio", "Berserk", "Balquiria", "Urgot", "Ter", "Mordekaiser", "Krono", "Apolo", "Skoly", "Kira",
        "Legolas", "Misthios", "Dragma", "Eaco", "Morbidius", "Whisper", "Whistle"};

    public Principal() {
        nuevaPartida();
    }
    public void nuevaPartida(){
        System.out.println("Llenando Ejercitos");
        llenarHeroes();
        llenarBestias();
    }
    public void llenarHeroes() {
        int random;
        for (int x = 0; x < heroes.length; x++) {
            random = generarNumeroAleatorio(1, 3);
            switch (random) {
                case 1:
                    heroes[x] = new Elfo(nombres[x], generarNumeroAleatorio(60, 70));
                    break;
                case 2:
                    heroes[x] = new Hobbit(nombres[x], generarNumeroAleatorio(60, 70));
                    break;
                case 3:
                    heroes[x] = new Humano(nombres[x], generarNumeroAleatorio(60, 70));
                    break;
            }
        }
    }

    public void llenarBestias() {
        int random;
        for (int x = 0; x < heroes.length; x++) {
            random = generarNumeroAleatorio(1, 2);
            switch (random) {
                case 1:
                    bestias[x] = new Orco(nombres[x+9], generarNumeroAleatorio(60, 70));
                    break;
                case 2:
                    bestias[x] = new Trasgo(nombres[x+9], generarNumeroAleatorio(60, 70));
                    break;
            }
        }
    }

    public int generarNumeroAleatorio(int min, int max) {
        int numero = (int) (Math.random() * (max - min + 1) + min);
        return numero;
    }
}
