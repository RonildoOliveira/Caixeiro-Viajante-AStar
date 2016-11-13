package ufc.ia.cvas.algorithm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import ufc.ia.cvas.entity.Aresta;
import ufc.ia.cvas.entity.Cidade;
import ufc.ia.cvas.entity.ConjuntoDisjunto;

public class Kruskal {
	private static float menorCaminho = 0;
	private ArrayList<Aresta> grafoGerado;
	ArrayList<Aresta> menorGrafo;
	private ArrayList<Cidade> listaCidades;
	private static ArrayList<Aresta> listaArestas;
	private ConjuntoDisjunto conjuntoDisjunto;

	private int numeroPontos;
	private int maxArestas;
	
	ArrayList<Aresta> melhoresArestas; 
	
	public Kruskal(ArrayList<Cidade> listaCidades) {

		this.numeroPontos = listaCidades.size();
		System.out.println("QTD.: SALTOS: " + numeroPontos);
		
		//Utilizando o metodo das diagonais de um poligono
		maxArestas = geraMaximoDiagonais(numeroPontos);

		this.listaCidades = listaCidades;
	    listaArestas = new ArrayList<Aresta>(maxArestas);
	    
	    melhoresArestas = new ArrayList<Aresta>();
	    	    
	    gerarArvoreMinima(listaCidades);
	    
	    melhoresArestas.addAll(getMenorGrafo());
	    
	    /**MELHORES ARESTAS DA ITERACAO**/
//	    for (Aresta a : melhoresArestas) {
//			System.out.println(a.toString());
//		}
				    
	}

	private int geraMaximoDiagonais(int pontos){
		return (pontos * (pontos - 1)) / 2;
	}
	
	/** GERADOR DE ARVORE MINIMA **/
	public float gerarArvoreMinima(ArrayList<Cidade> listaCidades) {
		menorGrafo = new ArrayList<Aresta>();
				  
	    //Matriz de Adjacência
	    for (int i = 0; i < listaCidades.size(); i++) {
	      for (int j = 0; j < listaCidades.size(); j++) {
	        if (i != j){
	        	Cidade u = listaCidades.get(i);
	        	Cidade v = listaCidades.get(j);
	        	
	        	Aresta arestaAux = new Aresta(u, v, Cidade.getDistanciaDuasCidades(u, v));
	        	listaArestas.add(arestaAux);
	        	
	        	DecimalFormat df = new DecimalFormat("#.00");
	        	
	        	/** LOG DO PROCESSO GERAL **/
//	        	System.out.print("[("+listaArestas.get(i).getU().getX()+","+listaArestas.get(i).getU().getY()+")");
//		    	System.out.print("("+listaArestas.get(i).getV().getX()+","+listaArestas.get(i).getV().getY()+")");
//		    	System.out.println("("+df.format(listaArestas.get(i).getPeso())+")]");
	        }        
	      }
	    }

	    conjuntoDisjunto = new ConjuntoDisjunto(listaCidades);
	    
	    grafoGerado = new ArrayList<Aresta>();

	    //Ordena arestas crescentemente
	    Collections.sort(listaArestas);

	    //Kruskal
	    for (Aresta e : listaArestas) {
	      Cidade u = e.getU();
	      Cidade v = e.getV();
	      if (conjuntoDisjunto.procurar(u.getNo()) != 
	          conjuntoDisjunto.procurar(v.getNo())) { // u e v não sao do mesmo conjunto
	        grafoGerado.add(e);	        
	        conjuntoDisjunto.unir(u.getNo(), v.getNo());
	      }
	    }
	    
	    int cont = 1;
	    for (Aresta e : grafoGerado) {
	    	
	    	System.out.print("Aresta: "+cont++);
	    	System.out.print(" - U"+"("+e.getU().getX()+","+e.getU().getY()+")");
	    	System.out.println(" - V"+"("+e.getV().getX()+","+e.getV().getY()+")");
	    	    	
	    	menorCaminho += Math.sqrt(e.getPeso());
	    }	    
	    
	    //System.out.println("Tamanho da arvore: "+ grafoGerado.size());
	    
	    //REMOVER ARESTAS COINCIDENTES
	    for (Aresta aresta : grafoGerado) {
			if(aresta.getU().getX() == aresta.getV().getX() &&
			   aresta.getU().getY() == aresta.getV().getY()){
			}else{
				menorGrafo.add(aresta);
			}
			
		}
	    
	    System.out.println("PERCURSO: "+ menorGrafo.size());
	    System.out.println("\tCOMPRIMENTO: "+menorCaminho);
	    return menorCaminho;
	  }
	  
	  public ArrayList<Aresta> getMenorGrafo(){
		  return this.grafoGerado;
	  }
	
}
	