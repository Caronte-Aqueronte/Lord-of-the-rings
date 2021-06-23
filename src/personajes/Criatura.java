package src.personajes;

public class Criatura {

    private int vida;
    private String nombre;
    private int armadura;
    private int ataque;
    private boolean vivoOMuerto;
    private String[] nombres = {"Caronte", "Leonisio", "Berserk", "Balquiria", "Urgot", "Ter", "Mordekaiser", "Krono", "Apolo", "Skoly", "Kira",
        "Legolas", "Misthios", "Dragma", "Eaco", "Morbidius", "Whisper", "Whistle"};

    /**
     * Constructor
     *
     * @param vida
     * @param nombre
     * @param armadura
     * @param vivoOMuerto
     */
    public Criatura(int vida, String nombre, int armadura, boolean vivoOMuerto) {
        this.vida = vida;
        this.nombre = nombre;
        this.armadura = armadura;
        this.vivoOMuerto = vivoOMuerto;
    }

  
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public boolean isVivoOMuerto() {
        return vivoOMuerto;
    }

    public void setVivoOMuerto(boolean vivoOMuerto) {
        this.vivoOMuerto = vivoOMuerto;
    }

    public String[] getNombres() {
        return nombres;
    }

    /**
     * Getters y setters
     */
    public void setNombres(String[] nombres) {  
        this.nombres = nombres;
    }

    public String elegirNombre() {
        int posicion = (int) (Math.random() * (17 - 0 + 1) + 0);
        nombre = nombres[posicion];
        return nombre;
    }

    public int asignarArmadura() {
        int armadura = (int) (Math.random() * (70 - 60 + 1) + 60);
        return armadura;
    }
}
