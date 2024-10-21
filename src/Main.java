import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import Logica.Departamento;
import Logica.Empleado;
import Logica.Empresa;
import Logica.Proyecto;

public class Main {
	public static Empresa emp = new Empresa("Empresa1");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		String menu = menu();
		
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
			if (opcion >= 1 && opcion <= 4) {
				int opcSubMenu = Integer.parseInt(JOptionPane.showInputDialog(null, getSubMenu(opcion)));
				opcionesSubMenu(opcion, opcSubMenu);
			}
		} while(opcion != 5);
	}
	
	/* ---------- MENUS ---------- */
	private static String menu() {
		String menu = "Ingrese una opcion:\n"
				+ "1. Empleados.\n"
				+ "2. Departamentos.\n"
				+ "3. Proyectos.\n"
				+ "4. Funcionalidades.\n"
				+ "5. Salir.";
		return menu;
	}
	
	private static String getSubMenu(int menu) {
		String subMenu = "Ingrese una opcion:\n";
		switch (menu) {
		case 1:
			subMenu += "1. Lista de empleados.\n"
					+ "2. Agregar empleado.\n"
					+ "3. Actualizar empleado.\n"
					+ "4. Eliminar empleado.\n"
					+ "5. Volver";
			break;
		case 2:
			subMenu += "1. Lista de departamentos.\n"
					+ "2. Agregar departamento.\n"
					+ "3. Actualizar departamento.\n"
					+ "4. Eliminar departamento.\n"
					+ "5. Listar empleados por departamento.\n"
					+ "6. Agregar empleado a departamento.\n"
					+ "7. Volver";
			break;
		case 3:
			subMenu += "1. Lista de proyectos.\n"
					+ "2. Agregar proyecto.\n"
					+ "3. Actualizar proyecto.\n"
					+ "4. Eliminar proyecto.\n"
					+ "5. Listar empleados por proyecto.\n"
					+ "6. Agregar empleado a proyecto.\n"
					+ "7. Volver";
			break;
		case 4:
			subMenu += "1. Calcular nomina total.\n"
					+ "2. Empleado con mejor sueldo.\n"
					+ "3. Empleado con mas comisiones.\n"
					+ "4. Promedio de salarios.\n"
					+ "5. Listar empleados por rango de salario.\n"
					+ "6. Departamento con mas empleados.\n"
					+ "7. Proyecto mas largo.\n"
					+ "8. Promedio de costo de proyectos.\n"
					+ "9. Volver.";
			break;
		default:
			break;
		}
		return subMenu;
	}
	
	private static void opcionesSubMenu(int opcion, int subMenu) {
		switch (opcion) {
		case 1:
			opcionesEmpleados(subMenu);
			break;
		case 2:
			opcionesDepartamentos(subMenu);
			break;
		case 3:
			opcionesProyectos(subMenu);
			break;
		case 4:
			opcionesFuncionalidades(subMenu);
			break;
		default:
			break;
		}
	}
	
	/* ---------- EMPLEADOS ---------- */
	public static void opcionesEmpleados(int subMenu) {
		switch (subMenu) {
		case 1:
			listaEmpleados();
			break;
		case 2:
			agregarEmpleado();
			break;
		case 3:
			actualizarEmpleado();
			break;
		case 4:
			eliminarEmpleado();
			break;
		default:
			break;
		}
	}
	
	public static void listaEmpleados() {
		System.out.println(emp.listarEmpleados().toString());
	}
	
	public static void agregarEmpleado() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad: "));
		double salarioBase = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario base: "));
		double comisiones = Double.parseDouble(JOptionPane.showInputDialog("Ingrese las comisiones: "));
            
		Empleado e = new Empleado(nombre, edad, salarioBase, comisiones);
        emp.agregarEmpleado(e);
	}
	
	public static void actualizarEmpleado() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
		Empleado empleado = emp.buscarEmpleado(nombre);
		
		if(empleado != null) {
			nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
			int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad: "));
			double salarioBase = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario base: "));
			double comisiones = Double.parseDouble(JOptionPane.showInputDialog("Ingrese las comisiones: "));
			
			emp.actualizarEmpleado(empleado, nombre, edad, salarioBase, comisiones);
			JOptionPane.showMessageDialog(null, "Empleado actualizado");
		} else {
			JOptionPane.showMessageDialog(null, "El empleado no existe");
		}
	}
	
	public static void eliminarEmpleado() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
		Empleado empleado = emp.buscarEmpleado(nombre);
		
		if(empleado != null) {
			emp.eliminarEmpleado(empleado);
			JOptionPane.showMessageDialog(null, "Empleado eliminado con exito");
		} else {
			JOptionPane.showMessageDialog(null, "El empleado no existe");
		}
	}
	
	/* ---------- DEPARTAMENTOS ---------- */
	public static void opcionesDepartamentos(int subMenu) {
		switch (subMenu) {
		case 1:
			listaDepartamentos();
			break;
		case 2:
			agregarDepartamento();
			break;
		case 3:
			actualizarDepartamento();
			break;
		case 4:
			eliminarDepartamento();
			break;
		case 5:
			listaEmpleadosPorDepartamento();
			break;
		case 6:
			agregarEmpleadoEnDepartamento();
			break;
		default:
			break;
		}
	}
	
	public static void listaDepartamentos() {
		System.out.println(emp.listarDepartamentos().toString());
	}
	
	public static void agregarDepartamento() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
		Departamento d = new Departamento(nombre);
        emp.agregarDepartamento(d);
	}
	
	public static void actualizarDepartamento() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del departamento: ");
		Departamento departamento = emp.buscarDepartamento(nombre);
		
		if(departamento != null) {
			nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
			emp.actualizarDepartamento(departamento, nombre);
			JOptionPane.showMessageDialog(null, "Departamento actualizado");
		} else {
			JOptionPane.showMessageDialog(null, "El departamento no existe");
		}
	}
	
	public static void eliminarDepartamento() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del departamento:");
		Departamento departamento = emp.buscarDepartamento(nombre);
		
		if(departamento != null) {
			emp.eliminarDepartamento(departamento);
			JOptionPane.showMessageDialog(null, "Departamento eliminado con exito");
		} else {
			JOptionPane.showMessageDialog(null, "El departamento no existe");
		}
	}
	
	public static void agregarEmpleadoEnDepartamento() {
		String nombreD = JOptionPane.showInputDialog("Ingrese el nombre del departamento:");
		Departamento departamento = emp.buscarDepartamento(nombreD);
		
		if(departamento != null) {
			String nombreE = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
			Empleado empleado = emp.buscarEmpleado(nombreE);
			
			if(empleado != null) {
				emp.agregarEmpleadoEnDepartamento(departamento, empleado);
				JOptionPane.showMessageDialog(null, "Empleado agregado con exito");
			} else {
				JOptionPane.showMessageDialog(null, "El empleado no existe");
			}
		} else {
			JOptionPane.showMessageDialog(null, "El departamento no existe");
		}
	}
	
	public static void listaEmpleadosPorDepartamento() {
		String nombreD = JOptionPane.showInputDialog("Ingrese el nombre del departamento:");
		Departamento departamento = emp.buscarDepartamento(nombreD);
		
		if(departamento != null) {
			System.out.println(emp.listarEmpleadosPorDepartamento(departamento).toString());
			JOptionPane.showMessageDialog(null, "Departamento: "+nombreD+"\n"+emp.listarEmpleadosPorDepartamento(departamento).toString());
		} else {
			JOptionPane.showMessageDialog(null, "El departamento no existe");
		}
	}
	
	/* ---------- PROYECTOS ---------- */
	public static void opcionesProyectos(int subMenu) {
		switch (subMenu) {
		case 1:
			listaProyetos();
			break;
		case 2:
			agregarProyeto();
			break;
		case 3:
			actualizarProyeto();
			break;
		case 4:
			eliminarProyeto();
			break;
		case 5:
			listaEmpleadosPorProyeto();
			break;
		case 6:
			agregarEmpleadoEnProyeto();
			break;
		default:
			break;
		}
	}
	
	public static void listaProyetos() {
		System.out.println(emp.listarProyectos().toString());
	}
	
	public static void agregarProyeto() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del proyecto: ");
		int duracionMeses = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duracion en meses: "));
		double costo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo: "));
		String responsable = JOptionPane.showInputDialog("Ingrese el nombre del responsable del proyecto: ");
		Empleado empleado = emp.buscarEmpleado(responsable);
		
		if(empleado != null) {
			Proyecto p = new Proyecto(nombre, empleado, duracionMeses, costo);
	        emp.agregarProyecto(p);
			JOptionPane.showMessageDialog(null, "Proyecto agregado");
		} else {
			JOptionPane.showMessageDialog(null, "El responsable no existe");
		}
	}
	
	public static void actualizarProyeto() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del proyecto: ");
		Proyecto proyecto = emp.buscarProyecto(nombre);
		
		if(proyecto != null) {
			nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
			int duracionMeses = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duracion en meses: "));
			double costo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo: "));
			String responsable = JOptionPane.showInputDialog("Ingrese el nombre del responsable del proyecto: ");
			Empleado empleado = emp.buscarEmpleado(responsable);
			
			if(empleado != null) {
				emp.actualizarProyecto(proyecto, nombre, empleado, duracionMeses, costo);
				JOptionPane.showMessageDialog(null, "Proyecto actualizado");
			} else {
				JOptionPane.showMessageDialog(null, "El responsable no existe");
			}
		} else {
			JOptionPane.showMessageDialog(null, "El proyecto no existe");
		}
	}
	
	public static void eliminarProyeto() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del proyecto:");
		Proyecto proyecto = emp.buscarProyecto(nombre);
		
		if(proyecto != null) {
			emp.eliminarProyecto(proyecto);
			JOptionPane.showMessageDialog(null, "Proyecto eliminado con exito");
		} else {
			JOptionPane.showMessageDialog(null, "El proyecto no existe");
		}
	}
	
	public static void agregarEmpleadoEnProyeto() {
		String nombreP = JOptionPane.showInputDialog("Ingrese el nombre del proyecto:");
		Proyecto proyecto = emp.buscarProyecto(nombreP);
		
		if(proyecto != null) {
			String nombreE = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
			Empleado empleado = emp.buscarEmpleado(nombreE);
			
			if(empleado != null) {
				emp.agregarEmpleadoEnProyecto(proyecto, empleado);
				JOptionPane.showMessageDialog(null, "Empleado agregado con exito");
			} else {
				JOptionPane.showMessageDialog(null, "El empleado no existe");
			}
		} else {
			JOptionPane.showMessageDialog(null, "El proyecto no existe");
		}
	}
	
	public static void listaEmpleadosPorProyeto() {
		String nombreP = JOptionPane.showInputDialog("Ingrese el nombre del proyecto:");
		Proyecto proyecto = emp.buscarProyecto(nombreP);
		
		if(proyecto != null) {
			System.out.println(emp.listaEmpleadosPorProyecto(proyecto).toString());
			JOptionPane.showMessageDialog(null, "Departamento: "+nombreP+"\n"+emp.listaEmpleadosPorProyecto(proyecto).toString());
		} else {
			JOptionPane.showMessageDialog(null, "El proyecto no existe");
		}
	}
	
	/* ---------- FUNCIONALIDADES REQUERIDAS ---------- */
	public static void opcionesFuncionalidades(int subMenu) {
		switch (subMenu) {
		case 1:
			calcularNominaTotal();
			break;
		case 2:
			empleadoConMejorSueldo();
			break;
		case 3:
			empleadoConMasComisiones();
			break;
		case 4:
			promedioSalario();
			break;
		case 5:
			listarEmpleadosPorRangoSalarial();
			//emp.ajustarSalario(20, emp.buscarEmpleado("tito"));
			break;
		case 6:
			departamentoConMasEmpleados();
			break;
		case 7:
			proyectoMasLargo();
			break;
		case 8:
			promedioCostoProyectos();
			break;
		default:
			break;
		}
	}
	
	public static void calcularNominaTotal() {
		String mensaje = "La nomina total es de: "+emp.calcularNominaTotal();
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static void empleadoConMejorSueldo() {
		String mensaje = "El empleado con mejor sueldo es: "+emp.empleadoConMejorSueldo().toString();
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static void empleadoConMasComisiones() {
		String mensaje = "El empleado con mas comisiones es: "+emp.empleadoConMasComisiones().toString();
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static void promedioSalario() {
		String mensaje = "El promedio del salario es de: "+emp.promedioSalario();
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static void listarEmpleadosPorRangoSalarial() {
		double salarioMin = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario minimo: "));
		double salarioMax = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario maximo: "));
		String mensaje = emp.listarEmpleadosPorRangoSalarial(salarioMin, salarioMax).toString();
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static void departamentoConMasEmpleados() {
		String mensaje = "El departamento con mas empleados es: "+emp.departamentoConMasEmpleados().toString();
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static void proyectoMasLargo() {
		String mensaje = "El proyecto mas largo es: "+emp.proyectoMasLargo().toString();
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static void promedioCostoProyectos() {
		String mensaje = "El promedio de costo de los proyectos es de: "+emp.promedioCostoProyectos();
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
