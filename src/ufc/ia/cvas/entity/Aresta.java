package ufc.ia.cvas.entity;

import java.util.List;

public class Aresta implements Comparable<Object> {
	
	private double peso;
	private Cidade u, v;
	private boolean visitado;

	public Aresta(Cidade u, Cidade v) {
		this.u = u;
		this.v = v;
		this.visitado = false;
	}

	public Aresta(Cidade u, Cidade v, double peso) {
		this(u, v);
		this.peso = peso;
	}

	public double getPeso() { 
		return this.peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Cidade getU() {
		return this.u; 
	}

	public Cidade getV() {
		return this.v;
	}

	public int compareTo(Object o) {
		Aresta arestaAux = (Aresta) o;

		if (this.getPeso() < arestaAux.getPeso())
			return -1;
		else if (this.getPeso() > arestaAux.getPeso())
			return 1;
		else
			return 0;

	}

	public static double sum(List<Aresta> listaArestas) {
		float somatorioPesos = 0;

		for (Aresta aresta : listaArestas) {
			somatorioPesos += aresta.getPeso();
		}

		return somatorioPesos;
	}


	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setU(Cidade u) {
		this.u = u;
	}

	public void setV(Cidade v) {
		this.v = v;
	}

	public String toString(){
		return u.getNome() + " - " + v.getNome();
	}
}
