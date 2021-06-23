package src.personajes;

public class Criatura {

    private int vida;
    private String nombre;
    private int armadura;
    private int ataque;
    private boolean vivoOMuerto;


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

    /**
     * Getters y setters
     */
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

    public boolean isVivoOMuerto() {
        return vivoOMuerto;
    }

    public void setVivoOMuerto(boolean vivoOMuerto) {
        this.vivoOMuerto = vivoOMuerto;
    }

    public int getAtaque(){
        return 0;
    }
}
