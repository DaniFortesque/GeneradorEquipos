import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class Principal {

	public static Jugador[] equipo = {}; //Creamos una variable global ya que va a ser compartida por todo el programa
	
	public static void main(String[] args) {		
		menu();
	}
	
	public static void menu(){
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		while(!salir) {
			System.out.println("Introduce una opcion:");
			System.out.println("(1) Generar equipo");
			System.out.println("(2) Imprimir Equipo");
			System.out.println("(3) Salir");
			int opcion= sc.nextInt();
			switch (opcion) {
				case 1: //Genera el equipo, lo imprime en consola y lo guarda en un txt
					equipo = generarEquipos();
					imprimirEquipo(equipo);
					guardarEquipo(equipo);
				case 2:
					
					
			}
		}
	}
	
	//////EJERCICIO 1 - GENERADOR DE EQUIPOS//////
	public static Jugador[] generarEquipos() {
		Scanner sc = new Scanner(System.in);
		String[] nombre = {"Rafa","Carmen","David","Alberto","Guille","Alejandro", "Jorge", "Furgen", "Adrian", "Berta", "Marileni", "Marta", "Ana Cristina", "Marian", "Susana", "Dani"};
		String[] apellidos = {"Marquez", "Molina", "Martinez", "Sanchez", "Puerta","Yepes", "Perez","Lopez", "Carrillo", "Tunez", "Rodriguez", "Lozano", "Moreno", "Marin", "Iglesias", "Box", "Gutierrez", "Torres", "Fuentes", "Cross", "Mendizabal", "Tapias", "Carvajal"};
		
		System.out.println("¿Cuantos jugadores quieres que tenga tu equipo?");
		int numeroJugadores = sc.nextInt();
		
		Jugador[] equipo = new Jugador[numeroJugadores];
		for(int i=0; i<numeroJugadores; i++) { //Este for va generando los jugadores y los añade en una posicion de la array
			Jugador jugador = new Jugador("","","",i+1);
			jugador.setNombre(nombre[(int) (Math.random()*16)]);
			jugador.setApellidos(apellidos[(int) (Math.random()*22)], apellidos[(int) (Math.random()*22)]);
			jugador.setPosicion(probabilidadPosicion((int) (Math.random()*9)));
			jugador.setDorsal(i+1);
			equipo[i]=jugador;
		}
		return equipo;
	}
	
	public static String probabilidadPosicion(int i){ //Establece probabilidades a cada posicion
		if(i==0) { //10%
			return "Portero";
		}else if(i>0 && i<4) { //30%
			return "Defensa";
		}else if(i>=4 && i<7) { //30%
			return "Centrocampista";	
		}else { //30%
			return "Delantero";
		}
	}
	
	public static void imprimirEquipo(Jugador[] equipo) {
		//System.out.println("Nombre            Apellidos            Dorsal/Posicion");
		for(int i=0; i<equipo.length; i++) { //imprimimos en pantalla el equipo
			System.out.println(equipo[i].getJugador());
		}
	}
	
	public static void guardarEquipo(Jugador[] equipo) { //ESta funcion crea un txt y guarda el equipo en el
		try {
			String sCarpAct = System.getProperty("user.dir");
			File carpeta = new File(sCarpAct);
			String ruta = carpeta+"/src/MiEquipo.txt";
	        
	        File file = new File(ruta);
	        // Si el archivo no existe es creado
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        
	        FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0; i<equipo.length; i++) {
            	bw.write(equipo[i].getDorsal()+"/"+equipo[i].getNombre()+"/"+equipo[i].getApellidos()+"/"+equipo[i].getDorsal()+"\n");
            }
            bw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}

//https://decodigo.com/java-crear-archivos-de-texto --- crear archivo de texto y escribir
