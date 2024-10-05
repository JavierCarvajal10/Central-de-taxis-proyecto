/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Taxi.java 1324 2010-09-30 19:33:01Z dav-vill $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_taxis
 * Autor: Yeisson Oviedo - 26/Ene/2010
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.taxis.mundo;

/**
 * Clase que representa un taxi en la central
 */
public class Taxi
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
    
    // TODO: Declaraci�n y documentaci�n de la marca del taxi. Nombre: marca, Tipo: String
    private String marca;
    
    // TODO: Declaraci�n y documentaci�n del a�o del taxi. Nombre: anio, Tipo: int
    private int anio;
    
    // TODO: Declaraci�n y documentaci�n de la placa del taxi. Nombre: placa, Tipo: String
    private String placa;

    // TODO: Declaraci�n y documentaci�n del nombre del propietario del taxi. Nombre: nombrePropietario, Tipo: String
    private String nombrePropietario;

    // TODO: Declaraci�n y documentaci�n de la c�dula del propietario del taxi. Nombre: cedulaPropietario, Tipo: String
    private String cedulaPropietario;

    // TODO: Declaraci�n y documentaci�n de la zona de trabajo del taxi. Nombre: cedulaPropietario, Tipo: String
    private String zona;
    

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Constructor que inicializa los atributos con los par�metros de entrada. <br>
     * <b> pre: </b> El formato de la placa es de la forma [A-Z][A-Z][A-Z]-[0-9][0-9][0-9]
     * <b> post: </b> Se inicializaron los datos del veh�culo con los recibidos como par�metro 
     * @param marcaP La marca del veh�culo - marcaP != null
     * @param anioP El a�o de fabricaci�n del taxi - anioP > 0
     * @param placaP La placa del veh�culo - placaP != null
     * @param nombrePropietarioP El nombre del propietario del taxi - nombrePropietarioP != null
     * @param cedulaPropietarioP La c�dula del propietario del taxi - cedulaPropietarioP != null
     * @param zonaP La zona de trabajo del taxi - zonaP != null && (zonaP == CentralDeTaxis.ZONA_OCCIDENTE || zonaP == CentralDeTaxis.ZONA_NORTE || zonaP == CentralDeTaxis.ZONA_ORIENTE || zonaP == CentralDeTaxis.ZONA_SUR )
     */
    
    // TODO: Escribir la signatura y el cuerpo del m�todo constructor para que cumpla las responsabilidades asignadas

    public Taxi(String marcaP, int anioP, String placaP, String nombrePropietarioP, String cedulaPropietarioP, String zonaP) {
        this.marca = marcaP;
        this.anio = anioP;
        this.placa = placaP;
        this.nombrePropietario = nombrePropietarioP;
        this.cedulaPropietario = cedulaPropietarioP;
        this.zona = zonaP;
    }


    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------


    /**
     * M�todo que retorna el nombre del propietario del taxi
     * <b>post: </b> Retorna el nombre del propietario <br>
     * @return El nombre del propietario
     */
    public String darNombrePropietario( )
    {
        return nombrePropietario;
    }

    /**
     * M�todo que retorna la placa del taxi
     * <b>post: </b> Retorna la placa del taxi <br>
     * @return La placa del taxi
     */
    public String darPlaca( )
    {
        return placa;
    }

    /**
     * M�todo que retorna la c�dula del propietario del taxi
     * <b>post: </b> Retorna la c�dula del propietario <br>
     * @return La c�dula del propietario
     */
    public String darCedulaPropietario( )
    {
        return cedulaPropietario;
    }

    /**
     * M�todo que retorna el a�o del taxi
     * <b>post: </b> Retorna el a�o del taxi <br>
     * @return El a�o del taxi
     */
    public int darAnio( )
    {
        return anio;
    }

    /**
     * M�todo que retorna la marca del taxi
     * <b>post: </b> Retorna la marca del taxi <br>
     * @return la marca del taxi
     */
    public String darMarca( )
    {
        return marca;
    }
    
    /**
     * Retorna la zona de trabajo del taxi
     * <b>post: </b> Retorna la zona donde trabaja el taxi <br>
     * @return La zona de trabajo del taxi
     */
    public String darZona()
    {
        return zona;
    }

    /**
     * M�todo que retorna la representaci�n textual del taxi
     * <b>post: </b> Retorna la representaci�n textual del taxi <br>
     * @return La representaci�n textual del taxi, su placa.
     */
    public String toString( )
    {
        return placa;
    }
}
