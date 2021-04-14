public class Disco implements Comparable<Disco> {

  // Atributos de la instancia
  private String codigo = "LIBRE";
  private String autor;
  private String titulo;
  private String genero;
  private int duracion; // duración total en minutos


  public Disco() {}

  public Disco(String codigo) {
    this.codigo = codigo;
  }


  public Disco(String codigo, String autor, String titulo, String genero, int duracion) {
    this.codigo = codigo;
    this.autor = autor;
    this.titulo = titulo;
    this.genero = genero;
    this.duracion = duracion;
  }
  

  // Getters y Setters
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getAutor() {
    return autor;
  }
  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getGenero() {
    return genero;
  }
  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getTitulo() {
    return titulo;
  }
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getDuracion() {
    return duracion;
  }
  public void setDuracion(int duracion) {
    this.duracion = duracion;
  }



  @Override
  public boolean equals(Object disco) {
    return this.codigo.equals( ( (Disco)disco ).codigo );
  }

  @Override
  public int compareTo(Disco disco) {
    return this.codigo.compareTo(disco.codigo);
  }


  @Override
  public String toString() {
    String cadena = "\n------------------------------------------";
    cadena += Do.color(true, "m", "b", "\nCódigo: ")    + Do.color(true, "y", "b", this.codigo);
    cadena += Do.color(true, "m", "b", "\nAutor: ")     + Do.color(true, "y", "b", this.autor);
    cadena += Do.color(true, "m", "b", "\nTítulo: ")    + Do.color(true, "y", "b", this.titulo);
    cadena += Do.color(true, "m", "b", "\nGénero: ")    + Do.color(true, "y", "b", this.genero);
    cadena += Do.color(true, "m", "b", "\nDuración: ")  + Do.color(true, "y", "b", this.duracion + " minutos");
    cadena += "\n------------------------------------------\n";
    return cadena;
  }

  
}