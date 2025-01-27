public class Contrarrelojista extends Ciclista {
    // Atributo que define la velocidad máxima de un contrarrelojista
    private double velocidadMáxima;

    public Contrarrelojista(int identificador, String nombre, double velocidadMáxima) {
        super(identificador, nombre);
        this.velocidadMáxima = velocidadMáxima;
    }

    protected double getVelocidadMáxima() {
        return velocidadMáxima;
    }

    public void setVelocidadMáxima(double velocidadMáxima) {
        this.velocidadMáxima = velocidadMáxima;
    }

    protected void mostrar() {
        super.mostrar(); // Invoca el método imprimir de la clase padre
        System.out.println("Aceleración promedio = " +
        velocidadMáxima);
    }

    protected String mostrarTipo() {
        return "Es un constrarrelojista";
    }
}