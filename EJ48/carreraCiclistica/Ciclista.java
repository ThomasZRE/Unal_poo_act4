public abstract class Ciclista {
    private int identificador; 
    private String nombre;
    private int tiempoAcumulado = 0;

    // Constructor clase ciclista
    public Ciclista(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    abstract String mostrarTipo();

    protected int getIdentificador() {
        return identificador;
    }

    protected void setIdentificador() {
        this.identificador = identificador;
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected int getPosicionGeneral(int posicionGeneral) {
        return posicionGeneral;
    }

    protected void setPosicionGeneral(int posicionGeneral) {
        posicionGeneral = posicionGeneral;
    }

    protected int getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    protected void setTiempoAcumulado(int tiempoAcumulado) {
        this.tiempoAcumulado = tiempoAcumulado;
    }


    protected void mostrar() {
        System.out.println("Identificador: " + identificador);
        System.out.println("Nombre: " + nombre);
        System.out.println("Tiempo acumulado: " + tiempoAcumulado);
    }
}

