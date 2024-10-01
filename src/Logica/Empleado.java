package Logica;

public class Empleado {
	private String nombre;
	private int edad;
	private double salarioBase;
	private double comisiones;
	
	public Empleado(String nombre, int edad, double salarioBase, double comisiones) {
		this.nombre = nombre;
		this.edad = edad;
		this.salarioBase = salarioBase;
		this.comisiones = comisiones;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	public double getComisiones() {
		return comisiones;
	}
	public void setComisiones(double comisiones) {
		this.comisiones = comisiones;
	}
	
	public double calcularSalarioTotal() {
		return this.salarioBase+this.comisiones;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", salarioBase=" + salarioBase + ", comisiones="
				+ comisiones + "]\n";
	}
	
	
}
