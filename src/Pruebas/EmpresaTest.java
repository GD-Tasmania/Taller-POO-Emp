package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Logica.Empleado;
import Logica.Empresa;

class EmpresaTest {

	@Test
    public void datosCompletos() {
        //LOG.info("Iniciado test datosCompletos");
        Empleado empleado = new Empleado("Paco", 19, 1000, 100);

        assertAll("Empleado",
        () -> assertEquals("Paco", empleado.getNombre()),
        () -> assertEquals(19, empleado.getEdad()),
        () -> assertEquals(1000, empleado.getSalarioBase()),
        () -> assertEquals(100, empleado.getComisiones())
        );

        //LOG.info("Finalizando test datosCompletos");
    }
	
    @Test
    public void datosVacios() {
        //LOG.info("Inicio test datosVcios");
    	Empleado empleado1 = new Empleado("Paco", 19, 1000, 100);
        assertThrows(Throwable.class, () -> new Empleado("", 0, 0, 0));
        //LOG.info("Fin test datosVcios");
    }
    
    public void agregarEmpleado() {
    	Empresa empresa = new Empresa("HP");
    	Empleado empleado = new Empleado("Paco", 19, 1000, 100);
    	
    	empresa.agregarEmpleado(empleado);
    	assertTrue(empresa.listarEmpleados().contains(empleado));
    }
    
    @Test
    public void eliminarEmpleado() {
    	Empresa empresa = new Empresa("HP");
    	Empleado empleado1 = new Empleado("Paco", 19, 1000, 100);
    	Empleado empleado2 = new Empleado("Pedro", 29, 2000, 200);
    	empresa.agregarEmpleado(empleado1);
    	empresa.agregarEmpleado(empleado2);
    	
    	empresa.eliminarEmpleado(empleado1);
    	
    	assertFalse(empresa.listarEmpleados().contains(empleado1));
    	assertEquals(1, empresa.listarEmpleados().size());
    }

}
