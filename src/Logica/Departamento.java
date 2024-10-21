package Logica;

import java.util.ArrayList;

public class Departamento {
	private String nombre;
	private ArrayList<Empleado> listaEmpleados;
	
	public Departamento(String nombre) {
		this.nombre = nombre;
		this.listaEmpleados = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		this.listaEmpleados.add(empleado);
	}
	
	public double calcularGastoSalarial() {
		double gastoSalarial = 0;
		for (Empleado empleado : this.listaEmpleados) {
			gastoSalarial+=empleado.calcularSalarioTotal();
		}
		return gastoSalarial;
	}
	
	public int numeroEmpleados() {
		return listaEmpleados.size();
	}

	@Override
	public String toString() {
		return "Departamento [nombre=" + nombre + ", listaEmpleados=" + listaEmpleados + "]";
	}
	
}
