package ufc.ia.cvas.main;

import ufc.ia.cvas.algorithm.Kruskal;

public class Main {

	public static void main(String[] args) {
		int numeroPontos = 17;
		Kruskal k = new Kruskal(numeroPontos);	
		k.getMenorGrafo();
	}

}
