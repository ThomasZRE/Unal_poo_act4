public class Escalador extends Ciclista {
    private double aceleraciónPromedio;
    private double gradoRampa;

    public Escalador(int identificador, String nombre, double
        aceleraciónPromedio, double gradoRampa) {
        super(identificador, nombre);
        this.aceleraciónPromedio = aceleraciónPromedio;
        this.gradoRampa = gradoRampa;
    }

    protected double getAceleraciónPromedio() {
        return aceleraciónPromedio;
    }

    protected void setAceleraciónPromedio(double aceleraciónPromedio) {
        this.aceleraciónPromedio = aceleraciónPromedio;
    }

    protected double getGradoRampa() {
        return gradoRampa;
    }

    protected void setGradoRampa(double gradoRampa) {
        this.gradoRampa = gradoRampa;
    }

    protected void mostrar() {
        super.mostrar();
        System.out.println("Aceleración promedio = " + aceleraciónPromedio);
        System.out.println("Grado de rampa = " + gradoRampa);
    }

    protected String mostrarTipo() {
        return "Es un escalador";
    }

}


