package business.model;

public class Bonus implements CompTime {
    public double calcularPreco(int extra) {
		return extra * 18;
	}
}