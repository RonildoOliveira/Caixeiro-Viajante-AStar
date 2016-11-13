package ufc.ia.cvas.entity;

import java.util.List;

/*
 * Class representing a single edge, holding pointers to the vertices
 * it connects. Also includes facilities for calculating sums of edge
 * weights.
 */
public class Aresta implements Comparable<Object> {
  private float peso;
  private Cidade u, v;

  public Aresta(Cidade u, Cidade v) {
    this.u = u;
    this.v = v;
  }

  public Aresta(Cidade u, Cidade v, float peso) {
    this(u, v);
    this.peso = peso;
  }

  public float getPeso() { 
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

  public static float sum(List<Aresta> listaArestas) {
    float somatorioPesos = 0;
    
    for (Aresta aresta : listaArestas) {
    	somatorioPesos += aresta.getPeso();
    }
    
    return somatorioPesos;
  }
}
