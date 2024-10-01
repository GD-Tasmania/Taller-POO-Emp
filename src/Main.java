import javax.swing.JOptionPane;

import Logica.Empleado;
import Logica.Empresa;

public class Main {
	public static Empresa emp = new Empresa("Empresa1");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		String menu = menu();
		
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
			if (opcion >= 1 && opcion <= 2) {
				int opcSubMenu = Integer.parseInt(JOptionPane.showInputDialog(null, getSubMenu(opcion)));
				opcionesSubMenu(opcion, opcSubMenu);
			}
		} while(opcion != 3);
	}
	
	/* MENUS */
	private static String menu() {
		String menu = "Ingrese una opcion:\n"
				+ "1. Empleados.\n"
				+ "2. Funcionalidades.\n"
				+ "3. Salir.";
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
			subMenu += "1. Calcular nomina total.\n"
					+ "2. Empleado con mejor sueldo.\n"
					+ "3. Empleado con mas comisiones.\n"
					+ "4. Promedio de salarios.\n"
					+ "5. Listar empleados por rango de salario.\n"
					+ "6. Volver.";
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
			opcionesFuncionalidades(subMenu);
			break;
		default:
			break;
		}
	}
	
	/* ENTRENADORES */
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
		System.out.println(emp.toString());
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
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del entrenador:");
		
		Empleado empleado = emp.buscarEmpleado(nombre);
		
		if(empleado != null) {
			emp.eliminarEmpleado(empleado);
			JOptionPane.showMessageDialog(null, "Empleado eliminado con exito");
		} else {
			JOptionPane.showMessageDialog(null, "El empleado no existe");
		}
	}
	
	/* FUNCIONALIDADES REQUERIDAS */
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
}
