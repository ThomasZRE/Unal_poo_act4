package Act5.EJ83;

public class Cilindro extends FiguraGeometrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;

        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        double volumen = Math.PI * altura * Math.pow(radio, 2.0);
        return volumen;
    }

    public double calcularSuperficie() {
        double areaLado1 = 2.0 * Math.PI * radio * altura;
        double areaLado2 = 2.0 * Math.PI * Math.pow(radio, 2.0);
        return areaLado1 + areaLado2;
    }
}
