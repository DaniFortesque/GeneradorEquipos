
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
	public void setApellidos(String apellido1, String apellido2) {
		this.apellidos=apellido1+" "+apellido2;
	}
	public void setPosicion(String posicion) {
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
	
	public String getEquipo() {
		return "|"+this.dorsal+"| "+this.apellidos+", "+this.nombre+" - "+this.posicion;
	}
	

}
