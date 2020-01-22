
public class Libro {
	private String Nombre;
	private String ISBC;
	private String Categoria;
	private int Ancho;
	
	public Libro(String isbn,String categ,String nombre,int ancho) {
		this.Ancho=ancho;
		this.Categoria=categ;
		this.ISBC=isbn;
		this.Nombre=nombre;
		
	}
	public String getNombre() {
		return Nombre;
	}

	public String getISBC() {
		return ISBC;
	}

	public String getCategoria() {
		return Categoria;
	}

	public int getAncho() {
		return Ancho;
	}
	
	public String toString() {
		return "Nombre del libro: "+this.Nombre+" ,Categoria:"+this.Categoria+"ISBN: "+this.ISBC;
	}
} 
