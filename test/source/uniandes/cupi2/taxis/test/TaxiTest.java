/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: TaxiTest.java 1129 2010-02-16 23:58:41Z y-oviedo $
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

import junit.framework.TestCase;
import uniandes.cupi2.taxis.mundo.CentralDeTaxis;
import uniandes.cupi2.taxis.mundo.Taxi;

/**
 * Clase que valida que los métodos de la clase Taxi se encuentran bien implementados
 */
public class TaxiTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private Taxi taxi;


    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo vehículo
     */
    private void setupEscenario1( )
    {
        taxi = new Taxi( "MAZDA", 2009, "ABC-123", "Jose", "12345678", CentralDeTaxis.ZONA_NORTE);
    }

    /**
     * Prueba 1 Este método se encarga de verificar el método constructor<br>
     * <b> Métodos a probar: </b> <br>
     * Taxi()<br>
     * darMarca()<br>
     * darAnio()<br>
     * darPlaca()<br>
     * darNombrePropietario()<br>
     * darCedulaPropietario()<br>
     * darZona()<br>
     * <b> Objetivo: </b> Probar construcción correcta del objeto Taxi<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Creación de una instancia valida de vehículo<br>
     */
    public void testVehiculo( )
    {
        setupEscenario1( );
        assertEquals( "Marca del vehículo no inicializada correctamente.", taxi.darMarca( ), "MAZDA" );
        assertEquals( "Año del vehículo no inicializado correctamente.", taxi.darAnio( ), 2009 );
        assertEquals( "Placa del vehículo no inicializada correctamente.", taxi.darPlaca( ), "ABC-123" );
        assertEquals( "Nombre del propietario no inicializado correctamente.", taxi.darNombrePropietario( ), "Jose" );
        assertEquals( "Cédula del propietaria no inicializada correctamente.", taxi.darCedulaPropietario( ), "12345678" );
        assertEquals( "Zona del taxi no inicializada correctamente.", taxi.darZona( ), CentralDeTaxis.ZONA_NORTE );                
    }
}
