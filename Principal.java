
public class Principal {
	public static void main(String[] args) { 
		 BDUNGS bd = new BDUNGS(10, 100); 
		 bd.rotularEstante("Computacion", 1); 
		 bd.rotularEstante("Matematica", 2); 
		 bd.ingresarLibro("9789684443457", "Computacion", "Estructuras de datos", 5);  bd.ingresarLibro("9788415552222", "Computacion", "Estructuras de datos en Java", 7);  bd.ingresarLibro("9389557783457", "Matematica", "Analisis de Funciones", 4); 
		 System.out.println(bd); 
		 bd.eliminarLibro("9389557783457"); 
		      bd.rotularEstante("Análisis Matemático", 2); 
		 System.out.println(bd); 
		 }
}
		  
		  
		  