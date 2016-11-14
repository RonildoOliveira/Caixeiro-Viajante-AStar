package ufc.ia.cvas.main;

import java.util.ArrayList;

import ufc.ia.cvas.algorithm.Kruskal;
import ufc.ia.cvas.entity.Cidade;
import ufc.ia.cvas.util.ManipuladorArquivos;

public class Main {

	public static int QUTD_PONTOS = 10;
	public static ManipuladorArquivos mArq = new ManipuladorArquivos();
	public static ArrayList<Cidade> listaCidades;
	public static ArrayList<Cidade> subListaCidades;
	
	
	public static void main(String[] args) {
		
		mArq.gerarPontos(QUTD_PONTOS);
		listaCidades = mArq.carregar();
		//Collections.shuffle(listaCidades);
		//listaCidades.remove(0);
		
		subListaCidades = new ArrayList<Cidade>();
		Kruskal k;
		
		for (int i = 0; i < listaCidades.size(); i++) {
			
			subListaCidades = new ArrayList<Cidade>();
			
			for (int j = 0; j < i; j++) {
				subListaCidades.add(listaCidades.get(j));
			}
			k = new Kruskal(subListaCidades);
			k.getMenorGrafo();
			
		}
				
		//Escreve o grafo resultante numa pagina HTML
		ManipuladorArquivos manipArq = new ManipuladorArquivos();
		manipArq.escreverResultado(cidadesToJS(subListaCidades));
	}
	
	//Mapeia os nos (cidades) e escreve o diagrama
	public static String cidadesToJS (ArrayList<Cidade> listaCidades){

		String nodesHTML = "";
		
		for (int i = 0; i < listaCidades.size(); i++) {
			nodesHTML += "{name: '"+listaCidades.get(i).getNome()+"', "
					+ "row: "+listaCidades.get(i).getX()+" , "
					+ "column: "+listaCidades.get(i).getY()+", connectsTo: "
							+ "'"+listaCidades.get(i+1).getNome()+"'},";

			if(i == listaCidades.size()-2){
				nodesHTML += "{name: '"+listaCidades.get(i+1).getNome()+"', "
						+ "row: "+listaCidades.get(i+1).getX()+" , "
						+ "column: "+listaCidades.get(i+1).getY()+", "
						+ "connectsTo: '"+listaCidades.get(0).getNome()+"'}";
				break;
			}
		}
		
		return nodesHTML;
	}
	
	
}
