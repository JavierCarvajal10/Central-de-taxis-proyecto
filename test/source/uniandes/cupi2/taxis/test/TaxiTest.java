/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: TaxiTest.java 1129 2010-02-16 23:58:41Z y-oviedo $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase que valida que los m�todos de la clase Taxi se encuentran bien implementados
 */
public class TaxiTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se har�n las pruebas
     */
    private Taxi taxi;


    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo veh�culo
     */
    private void setupEscenario1( )
    {
        taxi = new Taxi( "MAZDA", 2009, "ABC-123", "Jose", "12345678", CentralDeTaxis.ZONA_NORTE);
    }

    /**
     * Prueba 1 Este m�todo se encarga de verificar el m�todo constructor<br>
     * <b> M�todos a probar: </b> <br>
     * Taxi()<br>
     * darMarca()<br>
     * darAnio()<br>
     * darPlaca()<br>
     * darNombrePropietario()<br>
     * darCedulaPropietario()<br>
     * darZona()<br>
     * <b> Objetivo: </b> Probar construcci�n correcta del objeto Taxi<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Creaci�n de una instancia valida de veh�culo<br>
     */
    public void testVehiculo( )
    {
        setupEscenario1( );
        assertEquals( "Marca del veh�culo no inicializada correctamente.", taxi.darMarca( ), "MAZDA" );
        assertEquals( "A�o del veh�culo no inicializado correctamente.", taxi.darAnio( ), 2009 );
        assertEquals( "Placa del veh�culo no inicializada correctamente.", taxi.darPlaca( ), "ABC-123" );
        assertEquals( "Nombre del propietario no inicializado correctamente.", taxi.darNombrePropietario( ), "Jose" );
        assertEquals( "C�dula del propietaria no inicializada correctamente.", taxi.darCedulaPropietario( ), "12345678" );
        assertEquals( "Zona del taxi no inicializada correctamente.", taxi.darZona( ), CentralDeTaxis.ZONA_NORTE );                
    }
}
