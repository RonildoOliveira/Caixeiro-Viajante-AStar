package ufc.ia.cvas.entity;

public class Cidade {
	
	private float x;
	private float y;
	private String nome;
	
	private float h;
	private No no;
	
	private boolean visitado;
	
	public Cidade(String nome, float x2, float y2) {
		this.nome = nome;
		this.x = x2;
		this.y = y2;
		this.h = 0;
		this.visitado = false;
	}
	
	public float getX() {	return x; }
	public float getY() {	return y; }
	public String getNome() { return nome; }
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getDistancia(Cidade cidade){
		double x = this.getX()-cidade.getX();
		double y = this.getY()-cidade.getY();
		
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public static double getDistanciaDuasCidades(Cidade a, Cidade b){
		double x = a.getX()-b.getX();
		double y = a.getY()-b.getY();
		
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public No getNo() {
		return no;
	}

	public void setNo(No no) {
		this.no = no;
	}
	
	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	
	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public String toString(){
		return this.nome;
	}
	
}
