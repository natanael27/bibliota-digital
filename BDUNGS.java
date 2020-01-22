import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

public class BDUNGS {
		
	private HashMap<Integer, Estante> biblioteca;
		

		public BDUNGS(int NroEstantes, int Ancho) {
			biblioteca=new HashMap<Integer,Estante>();
			for(int i=1;i<=NroEstantes;i++) {
				Estante e= new Estante(i, Ancho);
				biblioteca.put(i,e);
			}
		}
		public void rotularEstante(String categ, int NOrden) {
			if(biblioteca.get(NOrden).getCategoria()==null || biblioteca.get(NOrden).EstaVacio()) {
				biblioteca.get(NOrden).setCategoria(categ);
			}else {
					throw new RuntimeException("el estante ya esta rotulado ");
				}
			}
	 
		public void ingresarLibro(String isbn, String categ, String nombre, int anch) {
		 	int cont =0;
		 	for( Estante e :biblioteca.values()) {
		 		if(e.getCategoria()!= null && e.getCategoria().equals(categ) && e.EntraEnEstante(anch) && cont==0) {
		 			Libro l= new Libro(isbn,categ,nombre,anch);
					e.AgregarLibro(l);
					cont++;
					}
			     }
		 	if(cont ==0) {
		 		throw new RuntimeException("el libro no pudo ingresarse!! la categoria no existe o no hay espacio disponible!");
		 	}
		      }
		
		public void eliminarLibro(String isbn) {
			for(Estante e: biblioteca.values()) {
				if(e.getListaLibros().containsKey(isbn)){
					e.eliminarLibro(isbn);
				}
			}
		}

		public double espacioLibre(int NOrden) {
			double el=0;
			if(biblioteca.get(NOrden).getCategoria()!=null) {
					el= biblioteca.get(NOrden).getLugarDisp();
			}
			if(biblioteca.get(NOrden).getCategoria()==null) {
				throw new RuntimeException("estante sin rotular");
		}
			return el;
		}
		
		
	
		public HashMap<String, Integer> verLibrosCategoria(String categ) {
			HashMap<String, Integer> LxCateg= new HashMap<String, Integer>();
			int cont = 0;
			for (Estante e: biblioteca.values()) {
				for(Libro l: e.getListaLibros().values()) {
					if(e.getCategoria().equals(categ)) {
						
						LxCateg.put(l.getISBC(),++cont);
						
					}
				}
			}
			if(LxCateg.size()==0) {
				throw new RuntimeException("no contiene la categoria");
			}
			return LxCateg;
		}	
	 
	 
@Override
	public String toString() {
		StringBuilder s= new StringBuilder();
		java.util.Iterator<Entry<Integer, Estante>> it = biblioteca.entrySet().iterator();
		while(it.hasNext()) {
			s.append(it.next().toString()+"\n");
		}
		
		 return s.toString();
		 
	 }
	
	public int reacomodarCategoria(String categ) {
		 int libres = 0;
		 ArrayList<Estante> listaCateg = new ArrayList<Estante>();
		 for(Estante e : biblioteca.values()) {
			 if(e.getCategoria()!=null && e.getCategoria().equals(categ)) {
				 listaCateg.add(e);
			 }
		 }
		 Collections.sort(listaCateg);
		 liberarEstante(listaCateg);
		 for(Estante e : listaCateg) {
			 if(e.EstaVacio()) {
				 libres++;
			 }
		 }
		 return libres;
	 }
	private void liberarEstante(ArrayList<Estante> listaDeEstXCateg) {
		for(int i =0; i<listaDeEstXCateg.size()-1;i++) {
			for(Libro l: listaDeEstXCateg.get(i+1).listaLib()) {
				if(l.getAncho()<=listaDeEstXCateg.get(i).getLugarDisp()) {
					listaDeEstXCateg.get(i).AgregarLibro(l);
					listaDeEstXCateg.get(i+1).eliminarLibro(l.getISBC());
				}
			}
		}		
	}
}
			
			
		
	
		
