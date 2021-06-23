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
        int turno = 1;
        String bandera = "";
        System.out.println("Llenando Ejercitos");
        esperar(1);
        llenarHeroes();
        llenarBestias();
        mostrarEjercitos();
        esperar(1);
        while (bandera.equals("")) {
            bandera = hayGanador();
            if(bandera !=""){
                break;
            }
            if (contador == 0) {
                System.out.println("TURNO: " + turno);
            }

            // esperar(2);
            pelear(heroes[contador], bestias[contador]);
            contador++;

            if (contador == 9) {
                contador = 0;
                turno++;

            }

        }
        System.out.println("\nEl ejercito ganador fue el de " + bandera);
    }

    public String hayGanador() {
        int contadorHeroesVivos = 0;
        int contadorBestiasVivas = 0;
        for (int x = 0; x < 9; x++) {
            if (heroes[x].isVivoOMuerto() == true) {
                contadorHeroesVivos++;
            }
            if (bestias[x].isVivoOMuerto() == true) {
                contadorBestiasVivas++;
            }
        }
        if (contadorHeroesVivos == 0) {
            return "Bestias";
        } else if (contadorBestiasVivas == 0) {
            return "Heroes";
        }
        return "";
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
        // esperar(1);
        System.out.println("\nEjercito de Heroes\n");
        for (int x = 0; x < heroes.length; x++) {
            System.out.println(heroes[x].toString());
        }
        // esperar(1);
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
        System.out.println("\nPelea entre el Heroe " + heroe.toString() + " (Vida: " + heroe.getVida() + ")" + " y la Bestia " + bestia.toString() + " (Vida: " + bestia.getVida() + ")");
        //aqui vemos si se cunplen con las consdiciones de ataque
        if (heroe instanceof Elfo && bestia instanceof Orco) {
            System.out.println("OHHH un ELFO contra un ORCO, el ELFO se enfurece y su ataque aumenta 10 puntos");
            ataqueHeroe += 10;
        }
        if (heroe instanceof Hobbit && bestia instanceof Trasgo) {
            System.out.println("El HOBBIT tiene miedo al TRASGO y disminuye su ataque 5 puntos");
            ataqueHeroe -= 5;
        }
        if (bestia instanceof Orco) {
            System.out.println("Hay un ORCO tengan cuidado pues siminuye 10% de armadura al enemigo");
            armaduraHeroe = armaduraHeroe - (int) (armaduraHeroe * 0.1);
        }
        //
        System.out.println("El Heroe " + heroe.toString() + " se prepara para atacar");
        if (ataqueHeroe > armaduraBestia) {
            damage = ataqueHeroe - armaduraBestia;
            bestia.setVida(bestia.getVida() - damage);
            System.out.println("El Heroe " + heroe.toString() + " causo " + damage + " puntos de daño al enemigo");
        } else {
            System.out.println("El Heore " + heroe.toString() + " no causo daño a la Bestia: " + bestia.toString());
        }
        //esperar(2);
        System.out.println("La Bestia " + bestia.toString() + " se prepara para pelear");
        if (ataqueBestia > armaduraHeroe) {
            damage = ataqueBestia - armaduraHeroe;
            heroe.setVida(heroe.getVida() - damage);
            System.out.println("La Bestia " + bestia.toString() + " causo " + damage + " puntos de daño al enemigo");
        } else {
            System.out.println("La Bestia " + bestia.toString() + " no causo daño al Heroe: " + heroe.toString());
        }
        System.out.println("FIN de la pelea entre el Heroe " + heroe.toString() + " (Vida: " + heroe.getVida() + ")" + " y la Bestia " + bestia.toString() + " (Vida: " + bestia.getVida() + ")\n");
        matar();
        correrEjercitoHeroes();
        correrEjercitoBestias();

    }

    public void matar() {
        for (int x = 0; x < 9; x++) {
            if (heroes[x].getVida() <= 0) {
                heroes[x].setVivoOMuerto(false);
            }
            if (bestias[x].getVida() <= 0) {
                bestias[x].setVivoOMuerto(false);
            }
        }
    }

    public void correrEjercitoHeroes() {
        if (saberSiHayHeroesVivos() == true) {
            int contador = 0;
            for (int x = 0; x < heroes.length; x++) {
                if (heroes[x].isVivoOMuerto() == false) {
                    contador = x + 1;
                    if (contador >= 9) {
                        contador = 0;
                    }
                    while (heroes[x].isVivoOMuerto() == false) {
                        if (heroes[contador].isVivoOMuerto() == true) {
                            heroes[x] = heroes[contador];
                        } else {
                            contador++;
                            if (contador >= 9) {
                                contador = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    public void correrEjercitoBestias() {
        if (saberSiHayBestiasVivas() == true) {
            int contador = 0;
            for (int x = 0; x < bestias.length; x++) {
                if (bestias[x].isVivoOMuerto() == false) {
                    contador = x + 1;
                    if (contador >= 9) {
                        contador = 0;
                    }
                    while (bestias[x].isVivoOMuerto() == false) {
                        if (bestias[contador].isVivoOMuerto() == true) {
                            bestias[x] = bestias[contador];
                        } else {
                            contador++;
                            if (contador >= 9) {
                                contador = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean saberSiHayHeroesVivos() {
        for (int x = 0; x < heroes.length; x++) {
            if (heroes[x].isVivoOMuerto() == true) {
                return true;
            }
        }
        return false;
    }

    public boolean saberSiHayBestiasVivas() {
        for (int x = 0; x < bestias.length; x++) {
            if (bestias[x].isVivoOMuerto() == true) {
                return true;
            }
        }
        return false;
    }

}
