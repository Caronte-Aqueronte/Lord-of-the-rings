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

    public void nuevaPartida() {
        int contador = 0;
        System.out.println("Llenando Ejercitos");
        llenarHeroes();
        llenarBestias();
        mostrarEjercitos();
        while(true){
            esperar(2);
            pelear(heroes[contador], bestias[contador]);
            contador++;
        }
    }

    public void llenarHeroes() {
        int random;
        int escudo;
        for (int x = 0; x < heroes.length; x++) {
            random = generarNumeroAleatorio(1, 3);
            escudo = generarNumeroAleatorio(60, 70);
            switch (random) {
                case 1:
                    heroes[x] = new Elfo(nombres[x], escudo);
                    break;
                case 2:
                    heroes[x] = new Hobbit(nombres[x], escudo);
                    break;
                case 3:
                    heroes[x] = new Humano(nombres[x], escudo);
                    break;
            }
        }
    }

    public void llenarBestias() {
        int random;
        int escudo;
        for (int x = 0; x < heroes.length; x++) {
            random = generarNumeroAleatorio(1, 2);
            escudo = generarNumeroAleatorio(60, 70);
            switch (random) {
                case 1:
                    bestias[x] = new Orco(nombres[x + 9], escudo);
                    break;
                case 2:
                    bestias[x] = new Trasgo(nombres[x + 9], escudo);
                    break;
            }
        }
    }

    public int generarNumeroAleatorio(int min, int max) {
        int numero = (int) (Math.random() * (max - min + 1) + min);
        return numero;
    }

    public void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarEjercitos() {
        esperar(1);
        System.out.println("\nEjercito de Heroes\n");
        for (int x = 0; x < heroes.length; x++) {
            System.out.println(heroes[x].toString());
        }
        esperar(1);
        System.out.println("\nEjercito de Bestias\n");
        for (int x = 0; x < bestias.length; x++) {
            System.out.println(bestias[x].toString());
        }
    }

    public void pelear(Heroe heroe, Bestia bestia) {
        int ataqueHeroe = heroe.getAtaque();
        int armaduraHeroe = heroe.getArmadura();
        int ataqueBestia = bestia.getAtaque();
        int armaduraBestia = bestia.getArmadura();
        int damage;
        
        //aqui vemos si se cunplen con las consdiciones de ataque
        if(heroe instanceof Elfo && bestia instanceof Orco){
            ataqueHeroe += 10;
        }else if(heroe instanceof Hobbit && bestia instanceof Trasgo){
            ataqueHeroe -=5;
        }else if(bestia instanceof Orco){
            armaduraHeroe = armaduraHeroe - (int)(armaduraHeroe * 0.1);
        }
        //
        System.out.println("\nPelea entre el Heroe "+heroe.toString()+" (Vida: "+ heroe.getVida()+")"+" y la Bestia "+bestia.toString()+" (Vida: "+bestia.getVida()+")");
        System.out.println("El Heroe " + heroe.toString()+" se prepara para atacar");
        if (ataqueHeroe > armaduraBestia) {
            damage = ataqueHeroe - armaduraBestia;
            bestia.setVida(bestia.getVida() - damage);
            System.out.println("El Heroe " + heroe.toString()+" causo "+damage+ "puntos de daño al enemigo");
        } else {
            System.out.println("El Heore " + heroe.toString() + " no causo daño a la Bestia: " + bestia.toString());
        }
        esperar(2);
        System.out.println("La Bestia " + bestia.toString()+" se prepara para pelear");
        if (ataqueBestia > armaduraHeroe) {
            damage = ataqueBestia - armaduraHeroe;
            heroe.setVida(heroe.getVida() - damage);
            System.out.println("La Bestia " + bestia.toString()+" causo "+damage+ "puntos de daño al enemigo");
        } else {
            System.out.println("La Bestia " + bestia.toString() + " no causo daño al Heroe: " + heroe.toString());
        }
         System.out.println("FIN de la pelea entre el Heroe "+heroe.toString()+" (Vida: "+ heroe.getVida()+")"+" y la Bestia "+bestia.toString()+" (Vida: "+bestia.getVida()+")\n");
    }
}
