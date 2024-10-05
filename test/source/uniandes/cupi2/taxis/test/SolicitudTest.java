/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: SolicitudTest.java 1328 2010-09-30 21:00:09Z dav-vill $
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
import uniandes.cupi2.taxis.mundo.Solicitud;
import uniandes.cupi2.taxis.mundo.Taxi;

/**
 * Clase que valida que los m�todos de la clase Solicitud, se encuentran bien implementados
 */
public class SolicitudTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se har�n las pruebas
     */
    private Solicitud solicitud;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye una nueva infracci�n con c�digo 12547 y valor 2500
     */
    private void setupEscenario1( )
    {
        solicitud = new Solicitud( "u1", "c1", "t1", "d1", CentralDeTaxis.ZONA_SUR);
    }

    /**
     * Prueba 1 Este m�todo se encarga de verificar el m�todo constructor<br>
     * <b> M�todos a probar: </b> <br>
     * Solicitud()<br>
     * darTelefono()<br>
     * darDireccion()<br>
     * darZona()<br>
     * darUsuario()<br>     
     * <b> Objetivo: </b> Probar construcci�n correcta del objeto Infracci�n de Tr�nsito<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Creaci�n de una instancia valida de infracci�n de tr�nsito<br>
     */
    public void testSolicitud( )
    {
        setupEscenario1( );
        assertEquals( "Tel�fono de la solicitud no inicializado correctamente.", solicitud.darTelefono(), "t1");
        assertEquals( "Direcci�n de la solicitud no inicializado correctamente.", solicitud.darDireccion(), "d1");
        assertEquals( "Zona no inicializada correctamente.", solicitud.darZona(), CentralDeTaxis.ZONA_SUR);
        assertEquals( "Los datos del usuario no son correctos.", solicitud.darNombre(), "u1");
        assertEquals( "Los datos del usuario no son correctos.", solicitud.darCedula(), "c1");        
    }
    
    
    /**
     * Prueba 1 Este m�todo se encarga de verificar el m�todo asignarTaxi()<br>
     * <b> M�todos a probar: </b> <br>
     * asignarTaxi()<br>
     * darTaxi()<br>
     * <b> Objetivo: </b> Probar el funcionamiento correcto del m�todo<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Antes de asignar taxi el resultado de darTaxi() debe ser null. Despu�s de asignarlo debe corresponder al objeto indicado<br>
     */
    public void testAsignarTaxi()
    {
        setupEscenario1( );
        assertEquals( "El taxi asignado debe ser inicialmente null.", solicitud.darTaxi(), null);
        
        Taxi t = new Taxi("m1", 1, "p1", "np1", "cp1", CentralDeTaxis.ZONA_OCCIDENTE);
        solicitud.asignarTaxi(t);
        
        assertEquals("El taxi retornado no corresponde al asignado", t, solicitud.darTaxi());
    }
    
    /**
     * Verifica que todos los m�todos dar retornen los valores esperados
     */
    public void testMetodosDar()
    {
        setupEscenario1( );
        assertEquals("La c�dula es incorrecta" ,"c1", solicitud.darCedula( ) );
        assertEquals("La direcci�n es incorrecta","d1",solicitud.darDireccion( ));
        assertEquals("El nombre es incorrecto","u1",solicitud.darNombre( ));
        assertNull("La solicitud no tiene ning�n taxi asignado",solicitud.darTaxi( ));
        assertEquals("El tel�fono es incorrecto","t1",solicitud.darTelefono( ));
        assertEquals("La zona es incorrecta",CentralDeTaxis.ZONA_SUR,solicitud.darZona( ));
    }
}
