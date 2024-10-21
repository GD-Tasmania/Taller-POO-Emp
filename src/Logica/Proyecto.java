package Logica;

import java.util.ArrayList;

public class Proyecto {
	private String nombre;
	private Empleado responsable;
	private int duracionMeses;
	private double costo;
	private ArrayList<Empleado> listaEmpleados;
	
	public Proyecto(String nombre, Empleado responsable, int duracionMeses, double costo) {
		this.nombre = nombre;
		this.responsable = responsable;
		this.duracionMeses = duracionMeses;
		this.costo = costo;
		this.listaEmpleados = new ArrayList<>();
	}
	
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	public Empleado getResponsable() { return responsable; }
	public void setResponsable(Empleado responsable) { this.responsable = responsable; }
	
	public int getDuracionMeses() { return duracionMeses; }
	public void setDuracionMeses(int duracionMeses) { this.duracionMeses = duracionMeses; }
	
	public double getCosto() { return costo; }
	public void setCosto(double costo) { this.costo = costo; }
	
	public ArrayList<Empleado> getListaEmpleados() { return listaEmpleados; }
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) { this.listaEmpleados = listaEmpleados; }
	
	public void asignarEmpleadoResponsable(Empleado empleado) {
		responsable = empleado;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		this.listaEmpleados.add(empleado);
	}

	@Override
	public String toString() {
		return "Proyecto [nombre=" + nombre + ", responsable=" + responsable + ", duracionMeses=" + duracionMeses
				+ ", costo=" + costo + ", listaEmpleados=" + listaEmpleados + "]";
	}
}
