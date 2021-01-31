import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
			System.out.println("(2) Cargar Equipo");
			System.out.println("(3) imprimir jugador");
			int opcion= sc.nextInt();
			switch (opcion) {
				case 1: //Genera el equipo, lo imprime en consola y lo guarda en un txt
					equipo = generarEquipos();
					imprimirEquipo(equipo);
					guardarEquipo(equipo);
					break;
				case 2:
					cargarEquipo();
					break;
				case 3:
					System.out.println(equipo[3].getJugador());
					break;
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
		
		equipo = new Jugador[numeroJugadores];
		for(int i=0; i<numeroJugadores; i++) { //Este for va generando los jugadores y los añade en una posicion de la array
			Jugador jugador = new Jugador("","","",0);
			jugador.setNombre(nombre[(int) (Math.random()*16)]);
			jugador.setApellidos(apellidos[(int) (Math.random()*22)]+" "+apellidos[(int) (Math.random()*22)]);
			jugador.setPosicion(probabilidadPosicion((int) (Math.random()*9)));
			jugador.setDorsal((i+1));
			equipo[i]=jugador;
		}
		return equipo;
	}
	
	public static String probabilidadPosicion(int i){ //Establece probabilidades de aparicion a cada posicion
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
	
	public static void guardarEquipo(Jugador[] equipo) { 			//Esta funcion crea un txt y guarda el equipo en el
		try {														//con un formato especifico para que pueda ser recuperado
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
            	bw.write(equipo[i].getDorsal()+"/"+equipo[i].getNombre()+"/"+equipo[i].getApellidos()+"/"+equipo[i].getPosicion()+"/"+"\n");
            }
            bw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void cargarEquipo() {  //Esta funcion abre el archivo donde se guarda el equipo, lo lee y separa sus atributos
										 //para asignarlos a la clase jugador y darles una posicion en la array equipo
	    FileReader fr = null;
	    BufferedReader br = null;
		String sCarpAct = System.getProperty("user.dir");
		File carpeta = new File(sCarpAct);
		String ruta = carpeta+"/src/MiEquipo.txt";
		
		try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
			 fr = new FileReader(ruta);
			 br = new BufferedReader(fr);
			 br.mark(100000); //ponemos una marca al principio para volver a ella despues

	         // Lectura del fichero
	         String linea;
	         int i=0;
	         while((linea=br.readLine())!=null) { //cuenta el numero de lineas/jugadores para crear la array
	        	 i++;
	         }
	         
	         equipo = new Jugador[i];
	         int contador = 0; //cuenta el numero de '/' que va encontrando al leer la linea
	         String cadena = "";
	         br.reset(); //reseteamos la posicion de lectura a la marca inicial
	         
	         for(int e=0; e<i; e++) { //recorre cada posicion de la array
	        	 Jugador jugador = new Jugador("","","",0); //creamos un jugador 'vacio'
	        	 linea=br.readLine();
	        	 
	        	 for(int a=0; a<linea.length(); a++) { //recorre cada caracter de la linea leida y los separa en atributos
	        		 if (linea.charAt(a)!='/') {
	        			 cadena = cadena+linea.charAt(a); //almacena cada caracter en una cadena hasta que se encuentra con un '/'
	        		 }else if(linea.charAt(a)=='/' && contador==0) {
	        			 jugador.setDorsal(Integer.parseInt(cadena));
	        			 cadena="";
	        			 contador++;
	        		 }else if(linea.charAt(a)=='/' && contador==1) {
	        			 jugador.setNombre(cadena);
	        			 cadena="";
	        			 contador++;
	        		 }else if(linea.charAt(a)=='/' && contador==2) {
	        			 jugador.setApellidos(cadena);
	        			 cadena="";
	        			 contador++;
	        		 }else if(linea.charAt(a)=='/' && contador==3) {
	        			 jugador.setPosicion(cadena); 
	        			 cadena="";
	        			 contador=0;
	        		 }
	        	 }
	        	 equipo[e]=jugador; //se almacena el jugador creado en su posicion de la array
	         }
		}
	      	 catch(Exception e){
	         e.printStackTrace();
	      	 }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	    }
	}
}

//http://chuwiki.chuidiang.org/index.php?title=Generar_n%C3%BAmeros_aleatorios_en_Java --- generar numeros aleatorios
//https://decodigo.com/java-crear-archivos-de-texto --- crear archivo de texto y escribir
//http://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java --- leer un archivo de texto
//http://ayudaitver.blogspot.com/2014/07/uso-basico-del-bufferedreader.html --- uso de los metodos de BufferedReader
