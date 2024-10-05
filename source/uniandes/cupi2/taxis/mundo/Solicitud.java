/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Solicitud.java 1342 2010-10-05 14:26:20Z carl-veg $
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
 * Clase que representa una solicitud en el sistema
 */
public class Solicitud
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    
    // TODO: Declaraci�n y documentaci�n de taxi a atender la solicitud. Nombre: taxi, Tipo: Taxi
    private String taxi;

    // TODO: Declaraci�n y documentaci�n del nombre del solicitante. Nombre: nombre, Tipo: String
    private String nombre;

    // TODO: Declaraci�n y documentaci�n de la c�dula del solicitante. Nombre: cedula, Tipo: String
    private String cedula;
    
    // TODO: Declaraci�n y documentaci�n del tel�fono del solicitante. Nombre: telefono, Tipo: String
    private String telefono;
    
    // TODO: Declaraci�n y documentaci�n de la direcci�n del solicitante. Nombre: direccion, Tipo: String
    private String direccion;

    // TODO: Declaraci�n y documentaci�n de la zona de residencia del solicitante. Nombre: zona, Tipo: String
    private String zona;
	
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

	// TODO: Escribir el contrato del m�todo constructor
    public Solicitud(String nombreP, String cedulaP, String telefonoP, String direccionP, String zonaP )
    {
        nombre = nombreP;
        cedula = cedulaP;
        telefono = telefonoP;
        direccion = direccionP;
        zona = zonaP;
        taxi = null;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    
    /**
     * Asigna el taxi que recibe por par�metro a la solicitud
     * @param taxiP El taxi que atender� la solicitud
     */
    // TODO: Escribir la signatura y el cuerpo del m�todo asignarTaxi para que cumpla las responsabilidades asignadas
   public void asignarTaxi(String taxiP){
       Taxi nuevoTaxi = new Taxi()
   }
    
    /**
     * Retorna el taxi al que est� asignada esta solicitud
     * <b>post: </b> Retorna el taxi asignado a la solicitud<br>
     * @return El taxi asignado. Null si la solicitud a�n no ha sido asignada a un taxi
     */
    public String darTaxi()
    {
    	return taxi;
    }
    
    /**
     * Retorna la identificaci�n de la persona
     * <b>post: </b> Retorna la c�dula a quien est� asignado el servicio <br>
     * @return La identificaci�n
     */
    public String darCedula( )
    {
        return cedula;
    }

    /**
     * Retorna el nombre de la persona
     * <b>post: </b> Retorna el nombre de la persona <br>
     * @return El nombre de la persona
     */
    public String darNombre( )
    {
        return nombre;
    }
    
    /**
     * Retorna el tel�fono de la persona
     * <b>post: </b> Retorna el tel�fono <br>
     * @return El tel�fono de la persona
     */
    public String darTelefono( )
    {
        return telefono;
    }
    
    /**
     * Retorna la direcci�n de la persona
     * <b>post: </b> Retorna la direcci�n <br>
     * @return La direcci�n de la persona
     */
    public String darDireccion( )
    {
        return direccion;
    }
    
    /**
     * Retorna la zona donde vive la persona
     * <b>post: </b> Retorna la zona <br>
     * @return La zona de la persona
     */
    public String darZona( )
    {
        return zona;
    }
	
    /**
     * M�todo que retorna la representaci�n textual de la solicitud
     * <b>post: </b> Retorna la representaci�n textual de la solicitud<br>
     * @return La representaci�n textual de la solicitud, el tel�fono desde donde se realiz� seguido de la direcci�n a atender
     */
    public String toString( )
    {
        String representacion=telefono + " - "+ direccion;
        if(taxi!=null)
            representacion+=" - Solicitud Asignada";
        return representacion;
        
    }

}
