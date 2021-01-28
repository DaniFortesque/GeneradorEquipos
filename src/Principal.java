import java.util.Scanner;
public class Principal {

<<<<<<< HEAD
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] nombre = {"Rafa","Carmen","David","Alberto", "Guille","Alejandro", "Jorge", "Furgen", "Adrian", "Berta", "Marileni", "Marta", "Ana Cristina", "Marian", "Susana", "Dani"};
		String[] apellidos = {"Marquez", "Molina", "Martinez", "Sánchez", "Puerta", "Pérez","López", "Carrillo", "Tunéz", "Rodriguez", "Lozano", "Moreno", "Marín", "Iglesias", "Box", "Gutierrez", "Torres", "Fuentes", "Cross", "Mendizabal", "Tapias", "Carvajal"};
		String[] posicion = {"Portero", "Defensa", "Centrocampista","Delantero"};
		
		System.out.println("¿Cuantos jugadores quieres que tenga tu equipo?");
		int numeroJugadores = sc.nextInt();
		Jugador[] equipo = new Jugador[numeroJugadores];
		
		
		generarEquipos(equipo, nombre, apellidos, posicion, numeroJugadores);
		
		System.out.println("Tu equipo es: ");
		for(int i=0; i<numeroJugadores; i++) {
			System.out.println(equipo[i].getNombre()+" "+equipo[i].getApellidos()+" "+equipo[i].getPosicion()+" "+equipo[i].getDorsal());
			
		}	
=======
	public static void main(String[] args) {		
		menu();
>>>>>>> e26789eafdf141f81326106be6864738f5d62fd7
	}
	
	public static void menu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una opcion");
		System.out.println("(1) Generar equipo");
		System.out.println("(2) Salir");
		int opcion= sc.nextInt();
		switch (opcion) {
		case 1: 
			Jugador[] equipo = generarEquipos();
			for(int i=0; i<equipo.length; i++) {
				System.out.println(equipo[i].getNombre()+" "+equipo[i].getApellidos()+"  "+equipo[i].getPosicion()+"  "+equipo[i].getDorsal());
			}
		}
	}
	
<<<<<<< HEAD
	public static Jugador[] generarEquipos(Jugador[] equipo, String[] nombre, String[] apellidos, String[] posicion, int numeroJugadores) {
		
=======
	
	public static Jugador[] generarEquipos() {
		Scanner sc = new Scanner(System.in);
		String[] nombre = {"Rafa","Carmen","David","Alberto","Guille","Alejandro", "Jorge", "Furgen", "Adrian", "Berta", "Marileni", "Marta", "Ana Cristina", "Marian", "Susana", "Dani"};
		String[] apellidos = {"Marquez", "Molina", "Martinez", "Sanchez", "Puerta","Yepes", "Perez","Lopez", "Carrillo", "Tunez", "Rodriguez", "Lozano", "Moreno", "Marin", "Iglesias", "Box", "Gutierrez", "Torres", "Fuentes", "Cross", "Mendizabal", "Tapias", "Carvajal"};
		String[] posicion = {"Portero", "Defensa", "Centrocampista","Delantero"};
		
		System.out.println("�Cuantos jugadores quieres que tenga tu equipo?");
		int numeroJugadores = sc.nextInt();
		
		Jugador[] equipo = new Jugador[numeroJugadores];
>>>>>>> e26789eafdf141f81326106be6864738f5d62fd7
		for(int i=0; i<numeroJugadores; i++) {
			Jugador jugador = new Jugador("","","",i+1);
			jugador.setNombre(nombre[(int) (Math.random()*16)]);
			jugador.setApellidos(apellidos[(int) (Math.random()*22)], apellidos[(int) (Math.random()*22)]);
			jugador.setPosicion(posicion[(int) (Math.random()*4)]);
			jugador.setDorsal(i+1);
			equipo[i]=jugador;
		}
		return equipo;
	}

//setNombre(nombre[(int) (Math.random()*16)]),setApellidos(apellidos[(int) (Math.random()*22)]), setPosicion(posicion[(int) (Math.random()*4)]
	

}
