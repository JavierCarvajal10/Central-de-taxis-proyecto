/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: CentralDeTaxisTest.java 1328 2010-09-30 21:00:09Z dav-vill $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_taxis
 * Autor: Yeisson Oviedo - 26/Ene/2010
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.taxis.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.taxis.mundo.CentralDeTaxis;
import uniandes.cupi2.taxis.mundo.Solicitud;
import uniandes.cupi2.taxis.mundo.Taxi;

/**
 * Esta es la clase usada para verificar que los métodos de la clase CentralDeTaxis estén correctamente implementados
 */
public class CentralDeTaxisTest extends TestCase
{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Es la clase donde se harán las pruebas
	 */
	private CentralDeTaxis centralDeTaxis;

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Construye un nuevo CentralDeTaxis vacío
	 * 
	 */
	private void setupEscenario1( )
	{
		centralDeTaxis = new CentralDeTaxis( );
	}

	/**
	 * Construye un nuevo CentralDeTaxis con una solicitud creada y un taxi creados en la misma zona 
	 */
	private void setupEscenario2( )
	{
		centralDeTaxis = new CentralDeTaxis( );
		try {
			centralDeTaxis.agregarSolicitud("n1", "c1", "t1", "d1", CentralDeTaxis.ZONA_NORTE);
			centralDeTaxis.agregarTaxi( "m1", 1, "ABC-123", "np1", "cp1", CentralDeTaxis.ZONA_NORTE );
		} catch (Exception e) {
			fail("No se debería lanzar ninguna excepción" );
		}

	}

	/**
	 * Construye un nuevo CentralDeTaxis con una solicitud y un taxi en la misma zona y un taxi en una zona distinta 
	 */
	private void setupEscenario3( )
	{
		setupEscenario2();
		try
		{
			centralDeTaxis.agregarTaxi( "m2", 2, "DEF-456", "np2", "cp2", CentralDeTaxis.ZONA_OCCIDENTE);
		}
		catch( Exception e )
		{
			fail( "No se debería lanzar ninguna excepción" );
		}
	}
	
	/**
	 * Verifica que al crear la CentralDeTaxis se creen los vectores taxis y solicitudes, cada uno sin elementos <br> 
	 */
	public void testCentralDeTaxis()
	{
	    setupEscenario1( );
	    ArrayList solicitudes= centralDeTaxis.darListaSolicitudes( );
	    ArrayList taxis= centralDeTaxis.darListaTaxis( );
	    assertTrue( "El vector de solictudes debe ser diferente de null", solicitudes!=null );
	    assertEquals( "El vector de solicitudes no debe tener elementos", 0,solicitudes.size( ) );
	    assertTrue( "El vector de taxis debe ser diferente de null", taxis!=null );
	    assertEquals( "El vector de taxis no debe tener elementos", 0,taxis.size( ) );
	}
	
	/**
	 * Verifica que se retorne el vector de solicitudes y que tenga el número de elementos esperado
	 */
	public void testDarListaSolicitudes()
	{
	    setupEscenario2( );
	    ArrayList solicitudes= centralDeTaxis.darListaSolicitudes( );
	    assertTrue( "El vector de solictudes debe ser diferente de null", solicitudes!=null );
	    assertEquals( "El vector de solicitudes debe tener elementos", 1,solicitudes.size( ) );
 
	}
	
	/**
	 * Verifica que se retorne el vector de taxis y que tenga el número de elementos esperado
	 */
	public void testDarListaTaxis()
	{
	    setupEscenario2( );
	    ArrayList taxis= centralDeTaxis.darListaTaxis( );
        assertTrue( "El vector de solictudes debe ser diferente de null", taxis!=null );
        assertEquals( "El vector de solicitudes debe tener elementos", 1,taxis.size( ) );
	}

	/**
	 * Prueba 1 verificar el método agregar solicitud
	 */
	public void testAgregarSolicitud( )
	{
		setupEscenario1( );
		try
		{
			centralDeTaxis.agregarSolicitud("n1", "c1", "t1", "d1", CentralDeTaxis.ZONA_NORTE);
		}
		catch( Exception e )
		{
			fail( "No se debería lanzar ninguna excepción" );
		}
		
		Solicitud s = (Solicitud) centralDeTaxis.darListaSolicitudes().get(0);

		assertEquals( "El nombre de la persona está errado", s.darNombre( ), "n1" );
		assertEquals( "La identificación de la persona está errada", s.darCedula( ), "c1" );		
		assertEquals("La dirección no es correcta", s.darDireccion(), "d1");
		assertEquals("El teléfono no es correcto", s.darTelefono(), "t1");
		assertEquals("La zona no es correcta", s.darZona(),CentralDeTaxis.ZONA_NORTE);		
	}

	/**
	 * Prueba 2 verificar casos de error en el método agregar solicitud
	 * Caso de error: Agregar solicitud ya existente
	 */
	public void testAgregarSolicitud2( ){
		setupEscenario2( );

		try
		{
			centralDeTaxis.agregarSolicitud("n1", "c1", "t1", "d1", CentralDeTaxis.ZONA_NORTE);
			fail( "No se deberia agregar la solicitud" );
		}
		catch( Exception e )
		{
			
		}

	}

	/**
	 * Prueba 3 verificar el método agregar taxi
	 */
	public void testAgregarTaxi( )
	{
		setupEscenario1( );
		try
		{
			centralDeTaxis.agregarTaxi( "m1", 1, "ABC-123", "np1", "cp1", CentralDeTaxis.ZONA_NORTE );
		}
		catch( Exception e )
		{
			fail( "No se debería lanzar ninguna excepción" );
		}

		Taxi t = (Taxi) centralDeTaxis.darListaTaxis().get(0);
		assertEquals("El año no es correcto", t.darAnio(), 1);
		assertEquals("La cédula del propietario no es correcta", t.darCedulaPropietario(), "cp1");
		assertEquals("La marca no es correcta", t.darMarca(), "m1");
		assertEquals("El nombre del propietario no es correcto", t.darNombrePropietario(), "np1");
		assertEquals("La placa no es correcta", t.darPlaca(), "ABC-123");
		assertEquals("La zona no es correcta", t.darZona(), CentralDeTaxis.ZONA_NORTE);
		

	}

	/**
	 * Prueba 4 verificar casos de error en el método agregar taxi
	 * Caso de error: Agregar taxi existente
	 */
	public void testAgregarTaxi2( )
	{
		setupEscenario2( );
		try
		{
			centralDeTaxis.agregarTaxi( "m1", 1, "ABC-123", "np1", "cp1", CentralDeTaxis.ZONA_NORTE );
			fail( "No se debería agregar un taxi repetido" );
		}
		catch( Exception e )
		{
			
		}		
	}
	
	/**
	 * Prueba 5 verificar el método eliminar taxi
	 */
	public void testEliminarTaxi( )
	{
		setupEscenario2( );
		try
		{
			centralDeTaxis.eliminarTaxi("ABC-123");
		}
		catch( Exception e )
		{
			fail("No se debería lanzar ninguna excepción");
		}
		
		if (centralDeTaxis.darListaTaxis().size() != 0)
			fail("No se elimino el taxi");		
	}
	
	/**
	 * Prueba 6 verificar casos de error en el método eliminar taxi
	 * Caso de error: eliminar taxi no existente
	 */
	public void testEliminarTaxi2( ){
		setupEscenario1();
		try
		{
			centralDeTaxis.eliminarTaxi("ABC-123");
			fail("Se debería lanzar una excepción pues el taxi no existe");
		}
		catch( Exception e )
		{
		}				
		
	}
	
	/**
	 * Prueba 7 verificar el método eliminar solicitud
	 */
	public void testEliminarSolicitud( )
	{
		setupEscenario2( );
		try
		{
			centralDeTaxis.eliminarSolicitud("t1");
		}
		catch( Exception e )
		{
			fail("No se debería lanzar ninguna excepción");
		}
		
		if (centralDeTaxis.darListaSolicitudes().size() != 0)
			fail("No se elimino el taxi");		
	}

	/**
	 * Prueba 8 verificar casos de error en el método eliminar solicitud
	 * Caso de error: Eliminar solicitud inexistente
	 */
	public void testEliminarSolicitud2( )
	{
		setupEscenario1();
		try
		{
			centralDeTaxis.eliminarSolicitud("t1");
			fail("Se debería lanzar una excepción pues la solicitud no existe");
		}
		catch( Exception e )
		{
		}				
	}

	/**
	 * Prueba 9 verificar el método asignar solicitud
	 */
	public void testAsignarSolicitud()
	{
		setupEscenario3( );
		try
		{
			centralDeTaxis.asignarSolicitud("ABC-123", "t1");
		}
		catch( Exception e )
		{
			fail("No se debería lanzar ninguna excepción");
		}				
		try
		{
			centralDeTaxis.asignarSolicitud("ABC-123", "t1");
			fail("Se debería lanzar una excepción pues la solicitud ya tiene un taxi asignado");
		}
		catch( Exception e )
		{
		}				
	}		

	/**
	 * Prueba 10 verificar casos de error en el método asignar solicitud
	 * Caso de error: asignar solicitud con teléfono inexistente 
	 */
	public void testAsignarSolicitud2()
	{
	    setupEscenario3( );
		try
		{
			centralDeTaxis.asignarSolicitud("ABC-123", "teléfono que no existe");
			fail("Se debería lanzar una excepción pues la solicitud no existe");
		}
		catch( Exception e )
		{			
		}				
	}
	
	/**
	 * Prueba 11 verificar casos de error en el método asignar solicitud
	 * Caso de error: asignar solicitud a taxi inexistente 
	 */
	public void testAsignarSolicitud3()
	{
	    setupEscenario3( );
		try
		{
			centralDeTaxis.asignarSolicitud("Placa que no existe", "t1");
			fail("Se debería lanzar una excepción pues el taxi no existe");
		}
		catch( Exception e )
		{
		}
	}
	
	/**
	 * Prueba 12 verificar casos de error en el método asignar solicitud
	 * Caso de error: asignar solicitud con taxi en diferente zona 
	 */
	public void testAsignarSolicitud4()
	{
	    setupEscenario3( );
		try
		{
			centralDeTaxis.asignarSolicitud("DEF-456", "t1");
			fail("Se debería lanzar una excepción pues la zona del taxi y la solicitud no coinciden");
		}
		catch( Exception e )
		{
		}				
	}
		
	
	/**
	 * Prueba 13 Verificar el método buscar taxi con un taxi que si existe y con otro que no existe <br>
	 */
	public void testBuscarTaxi( )
	{
		setupEscenario2( );
		int t = centralDeTaxis.buscarTaxi("ABC-123");
		if (t == -1)
			fail("El taxi si existe");
		t = centralDeTaxis.buscarTaxi("Taxi que no existe");
		if (t != -1)
			fail("El taxi no existe");
	}
	
	/**
	 * Prueba 14 Verificar el método buscar solicitud por teléfono con una solicitud que existe y <br>
	 * otra que no existe
	 */
	public void testBuscarSolicitudPorTelefono( )
	{
		setupEscenario2( );
		Solicitud s = centralDeTaxis.buscarSolicitudPorTelefono("t1");
		if (s == null)
			fail("La solicitud si existe");
		s = centralDeTaxis.buscarSolicitudPorTelefono("telefono que no existe");
		if (s != null)
			fail("La solicitud no existe");
	}
	
	/**
	 * Prueba 15 Verificar el método buscar solicitud por cédula con una cedula que existe u otra <br>
	 * que no existe
	 */
	public void testBuscarSolicitudPorCedula( )
	{
		setupEscenario2( );
		Solicitud s = centralDeTaxis.buscarSolicitudPorCedula("c1");
		if (s == null)
			fail("La solicitud si existe");
		s = centralDeTaxis.buscarSolicitudPorCedula("cedula que no existe");
		if (s != null)
			fail("La solicitud no existe");
	}		
}
