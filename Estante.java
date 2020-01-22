
import java.util.ArrayList;
import java.util.HashMap;

public class Estante implements Comparable<Estante>{
		private int NroDeOrd;
		private String Categoria;
		private int Ancho;
		private HashMap<String,Libro> ListaDeLibros;
		private double lugarDisponible;
		
		public Estante(int nroOrd, int anch) {
			this.NroDeOrd=nroOrd;
			this.Ancho=anch;
			ListaDeLibros = new HashMap<String,Libro>();
			lugarDisponible = anch;
			}
		public void AgregarLibro(Libro l) {
				ListaDeLibros.put(l.getISBC(), l);
				lugarDisponible -= l.getAncho();
			}
		public boolean EntraEnEstante(int anchoL) {
			return(this.lugarDisponible>anchoL);
		}
		
		public void eliminarLibro(String isbn) {
			lugarDisponible += ListaDeLibros.get(isbn).getAncho();
			this.ListaDeLibros.remove(isbn);
		}

		public boolean EstaVacio() {
			return (this.Ancho== this.lugarDisponible);
		}
		
		public String getCategoria() {
			return this.Categoria;
		}
		public void setCategoria(String categoria) {
			Categoria = categoria;
		}
		public int getNroDeOrden() {
			return this.NroDeOrd;
		}
		public int getAncho() {
			return this.Ancho;
		}
		public double getLugarDisp() {
			return this.lugarDisponible;
		}
		public HashMap<String,Libro> getListaLibros(){
			return this.ListaDeLibros;
		}
		public ArrayList<Libro> listaLib(){
			ArrayList<Libro> lib = new ArrayList<Libro>();
			lib.addAll(this.ListaDeLibros.values());
			return lib;
		}

	@Override
	public String toString() {
		return "Estante nro:"+ this.NroDeOrd+ " ,Categoria:"+this.Categoria+ " ,Cantidad de libros: "+ListaDeLibros.size();
	}
@Override
public int compareTo(Estante e) {
	if(e.getLugarDisp()<this.lugarDisponible) {
		return 1;
	}
	if(e.getLugarDisp()>this.lugarDisponible) {
		return -1;
	}
	return 0;
}
	
}
