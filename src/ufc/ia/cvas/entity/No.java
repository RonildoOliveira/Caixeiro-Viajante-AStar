package ufc.ia.cvas.entity;

class No {
  int grau;
  int indice;
  No pai;

  public No(int grau, int id, No pai) {
    this.grau = grau;
    this.indice = id;
    this.pai = pai;
  }
}
