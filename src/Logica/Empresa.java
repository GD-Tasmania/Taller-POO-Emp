package Logica;

import java.util.ArrayList;

public class Empresa {
	private String nombre;
	private ArrayList<Empleado> listaEmpleados;
	private ArrayList<Departamento> listaDepartamentos;
	private ArrayList<Proyecto> listaProyectos;
	
	public Empresa(String nombre) {
		this.nombre = nombre;
		this.listaEmpleados = new ArrayList<>();
		this.listaDepartamentos = new ArrayList<>();
		this.listaProyectos = new ArrayList<>();
	}

	/* ---------- EMPLEADOS ---------- */
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
	
	/* ---------- DEPARTAMENTOS ---------- */
	public ArrayList<Departamento> listarDepartamentos(){
		return this.listaDepartamentos;
	}
	
	public void agregarDepartamento(Departamento departamento) {
		this.listaDepartamentos.add(departamento);
	}
	
	public Departamento buscarDepartamento(String nombre) {
		for (Departamento departamento : this.listaDepartamentos) {
			if(departamento.getNombre().equalsIgnoreCase(nombre)) {
				return departamento;
			}
		}
		return null;
	}
	
	public void actualizarDepartamento(Departamento departamento, String nombre) {
		departamento.setNombre(nombre);
	}
	
	public void eliminarDepartamento(Departamento departamento) {
		this.listaDepartamentos.remove(departamento);
	}
	
	public void agregarEmpleadoEnDepartamento(Departamento departamento, Empleado empleado) {
		departamento.agregarEmpleado(empleado);
	}
	
	public ArrayList<Empleado> listarEmpleadosPorDepartamento(Departamento departamento) {
		ArrayList<Empleado> listaEmpleadosDepartamento = new ArrayList<>();
		for (Empleado d : departamento.getListaEmpleados()) {
			listaEmpleadosDepartamento.add(d);
		}
		return listaEmpleadosDepartamento;
	}
	
	public Departamento departamentoConMasEmpleados() {
		Departamento departamentoMasEmpleados = this.listaDepartamentos.get(0);
		for (Departamento departamento : this.listaDepartamentos) {
			if(departamento.numeroEmpleados()>departamentoMasEmpleados.numeroEmpleados()) {
				departamentoMasEmpleados = departamento;
			}
		}
		return departamentoMasEmpleados;
	}
	
	/* ---------- PROYECTOS ---------- */
	public ArrayList<Proyecto> listarProyectos(){
		return this.listaProyectos;
	}
	
	public void agregarProyecto(Proyecto proyecto) {
		this.listaProyectos.add(proyecto);
	}
	
	public Proyecto buscarProyecto(String nombre) {
		for (Proyecto proyecto : this.listaProyectos) {
			if(proyecto.getNombre().equalsIgnoreCase(nombre)) {
				return proyecto;
			}
		}
		return null;
	}
	
	public void actualizarProyecto(Proyecto proyecto, String nombre, Empleado responsable, int duracionMeses, double costo) {
		proyecto.setNombre(nombre);
		proyecto.setResponsable(responsable);
		proyecto.setDuracionMeses(duracionMeses);
		proyecto.setCosto(costo);
	}
	
	public void eliminarProyecto(Proyecto proyecto) {
		this.listaProyectos.remove(proyecto);
	}
	
	public void agregarEmpleadoEnProyecto(Proyecto proyecto, Empleado empleado) {
		proyecto.agregarEmpleado(empleado);
	}
	
	public ArrayList<Empleado> listaEmpleadosPorProyecto(Proyecto proyecto) {
		return proyecto.getListaEmpleados();
	}
	
	public Proyecto proyectoMasLargo() {
		Proyecto proyectoMasLargo = this.listaProyectos.get(0);
		for (Proyecto proyecto : this.listaProyectos) {
			if(proyecto.getDuracionMeses()>proyectoMasLargo.getDuracionMeses()) {
				proyectoMasLargo = proyecto;
			}
		}
		return proyectoMasLargo;
	}
	
	public double promedioCostoProyectos() {
		double costoProyectos = 0;
		for (Proyecto proyecto : this.listaProyectos) {
			costoProyectos+=proyecto.getCosto();
		}
		return costoProyectos/this.listaProyectos.size();
	}

	@Override
	public String toString() {
		return "ListaEmpleados: \n" + listaEmpleados + "\n";
	}
	
	
}
