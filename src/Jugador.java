import java.util.Scanner;
public class Jugador {
	
	private String nombre;
	private String apellidos;
	private String posicion;
	private int dorsal;
	
	public Jugador(String nombre, String apellidos, String posicion, int dorsal) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.posicion=posicion;
		this.dorsal=dorsal;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
		
	}
	public void setApellidos(String apellidos) {
		this.apellidos=apellidos;
	}
	public void setPosicion(String posicion) {
		Scanner sc = new Scanner(System.in);
		while(posicion!="Delantero" && posicion!="Defensa" && posicion!="Centrocampista" && posicion!="Portero") {
			System.out.println("La posicion introducida es incorrecta, por favor elige una entre Delantero/Defensa/Portero/Centrocampista");
			posicion = sc.nextLine();
		}
		this.posicion=posicion;
	}
	public void setDorsal(int dorsal) {
		this.dorsal=dorsal;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getApellidos() {
		return this.apellidos;
	}
	public String getPosicion() {
		return this.posicion;
	}
	public int getDorsal() {
		return this.dorsal;
	}
	
	public String getJugador() {
		return "|"+this.dorsal+"| "+this.apellidos+", "+this.nombre+" - "+this.posicion;
	}
	

}
