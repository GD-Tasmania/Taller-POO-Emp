package Logica;

import java.time.LocalDate;

public class Empleado {
	private String nombre;
	private int edad;
	private double salarioBase;
	private double comisiones;	
	private LocalDate fechaIngreso;
	
	public Empleado(String nombre, int edad, double salarioBase, double comisiones) {
		this.nombre = nombre;
		this.edad = edad;
		this.salarioBase = salarioBase;
		this.comisiones = comisiones;
		this.fechaIngreso = LocalDate.now();
	}
	
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
		LocalDate fecha = LocalDate.now();
		int años = fecha.getYear() - this.fechaIngreso.getYear();
		
		return (this.salarioBase+this.comisiones)+(años*50000);
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", salarioBase=" + salarioBase + ", comisiones="
				+ comisiones + ", fecha ingreso="+ fechaIngreso + "]\n";
	}
	
	
}
