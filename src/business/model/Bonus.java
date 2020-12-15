package business.control;

import business.control.CompTime;


public class Bonus implements CompTime {
    
    public double calcularPreco(int extra) {
		return extra * 18;
	}

}