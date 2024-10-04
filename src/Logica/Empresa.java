package Logica;

import java.util.ArrayList;

public class Empresa {
	private String nombre;
	private ArrayList<Empleado> listaEmpleados;
	
	public Empresa(String nombre) {
		this.nombre = nombre;
		this.listaEmpleados = new ArrayList<>();
	}

	public void agregarEmpleado(Empleado empleado) {
		this.listaEmpleados.add(empleado);
	}
	
	public Empleado buscarEmpleado(String nombre) {
		for (Empleado empleado : this.listaEmpleados) {
			if(empleado.getNombre().equalsIgnoreCase(nombre)) {
				return empleado;
			}
		}
		return null;
	}
	
	public void actualizarEmpleado(Empleado empleado, String nombre, int edad, double salarioBase, double comisiones) {
		empleado.setNombre(nombre);
		empleado.setEdad(edad);
		empleado.setSalarioBase(salarioBase);
		empleado.setComisiones(comisiones);
	}
	
	public void eliminarEmpleado(Empleado empleado) {
		this.listaEmpleados.remove(empleado);
	}
	
	public ArrayList<Empleado> listarEmpleados(){
		return this.listaEmpleados;
	}
	
	public double calcularNominaTotal() {
		double nominaTotal = 0;
		for (Empleado empleado : this.listaEmpleados) {
			nominaTotal+=empleado.calcularSalarioTotal();
		}
		return nominaTotal;
	}
	
	public Empleado empleadoConMejorSueldo() {
		Empleado mejorSueldo = this.listaEmpleados.getFirst();
		for (Empleado empleado : this.listaEmpleados) {
			if(empleado.calcularSalarioTotal()>=mejorSueldo.calcularSalarioTotal()) {
				mejorSueldo = empleado;
			}
		}
		return mejorSueldo;
	}
	
	public Empleado empleadoConMasComisiones() {
		Empleado masComisiones = this.listaEmpleados.getFirst();
		for (Empleado empleado : this.listaEmpleados) {
			if(empleado.getComisiones()>=masComisiones.getComisiones()) {
				masComisiones = empleado;
			}
		}
		return masComisiones;
	}
	
	public double promedioSalario() {
		double sumaSalarios = 0;
		for (Empleado empleado : this.listaEmpleados) {
			sumaSalarios+=empleado.calcularSalarioTotal();
		}
		return sumaSalarios/(this.listaEmpleados.size());
	}
	
	public ArrayList<Empleado> listarEmpleadosPorRangoSalarial(double salarioMin, double salarioMax){
		ArrayList<Empleado> listaEmpleadosRango = new ArrayList<>();
		for (Empleado empleado : this.listaEmpleados) {
			if(empleado.calcularSalarioTotal()>salarioMin && empleado.calcularSalarioTotal()<salarioMax) {
				listaEmpleadosRango.add(empleado);
			}
		}
		return listaEmpleadosRango;
	}
	
	public void ajustarSalario(double porcentajeIncremento, Empleado empleado) {
		double nuevoSalario = empleado.getSalarioBase()+(empleado.getSalarioBase()*porcentajeIncremento/100);
		empleado.setSalarioBase(nuevoSalario);
	}

	@Override
	public String toString() {
		return "ListaEmpleados: \n" + listaEmpleados + "\n";
	}
	
	
}
