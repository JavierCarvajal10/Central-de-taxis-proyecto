/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: CentralDeTaxis.java 1325 2010-09-30 19:45:27Z dav-vill $
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

import java.util.ArrayList;

/**
 * Clase principal del sistema de la central de taxis
 */
public class CentralDeTaxis
{
	
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	// TODO: Declaraci�n y documentaci�n de la constante ZONA_OCCIDENTE. Valor: "Occidente"
    private static final String ZONA_OCCIDENTE = "Occidente";

    // TODO: Declaraci�n y documentaci�n de la constante ZONA_ORIENTE. Valor: "Oriente"
    private static final String ZONA_ORIENTE = "Oriente";

    // TODO: Declaraci�n y documentaci�n de la constante ZONA_NORTE. Valor: "Norte"
    private static final String ZONA_NORTE = "Norte";

    // TODO: Declaraci�n y documentaci�n de la constante ZONA_SUR. Valor: "Sur"
    private static final String ZONA_SUR = "Sur";

	
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    // TODO: Declaraci�n y documentaci�n del atributo que representa una contenedora de taxis. Nombre: taxis
    private ArrayList<Taxi> taxis;

    // TODO: Declaraci�n y documentaci�n del atributo que representa una contenedora de solicitudes. Nombre: solicitudes
    private ArrayList<Solicitud> solicitudes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * 
     * Constructor que inicializa la central de taxis. <br>
     * <b> post: </b> Se inicializa las contenedoras de taxis y solicitudes vac�as <br>
     */
    // TODO: Escribir la signatura y el cuerpo del m�todo constructor para que cumpla las responsabilidades asignadas

    public CentralDeTaxis(ArrayList<Taxi> taxis, ArrayList<Solicitud> solicitudes) {
        this.taxis = taxis;
        this.solicitudes = solicitudes;
    }


    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * M�todo para agregar una solicitud al sistema <br>
     * <b>pre: </b> La lista de solicitudes se encuentra inicializada. <br>
     * <b>post:</b> La solicitud se agrega a la lista de solicitudes.<br>
     * @param nombreP El nombre de la persona que solicita el servicio - nombre != null
     * @param cedulaP La identificaci�n de la persona que solicita el servicio - cedulaP != null
     * @param telefonoP El tel�fono desde donde se realiza la solicitud - telefonoP != null 
     * @param direccionP La direcci�n a donde se solicita el servicio - direccionP != null
     * @param zonaP La zona de la ciudad a la que corresponde la direcci�n - zonaP != null
     * && (zonaP == CentralDeTaxis.ZONA_OCCIDENTE || zonaP == CentralDeTaxis.ZONA_NORTE ||
     * zonaP == CentralDeTaxis.ZONA_ORIENTE || zonaP == CentralDeTaxis.ZONA_SUR )
     * @throws Exception En caso de que ya exista una solicitud con la misma c�dula. <br>
     *                   En caso de que ya exista una solicitud con el mismo tel�fono.
     */
    
    // TODO: Escribir la signatura y el cuerpo del m�todo agregarSolicitud para que cumpla las responsabilidades asignadas
    public void agregarSolicitud (String nombreP,String cedulaP,String telefonoP,String direccionP,String zonaP) throws Exception {

        for (Solicitud todasLasSolicitudes : solicitudes){
            if (cedulaP.equals(todasLasSolicitudes.darCedula())){
                throw new Exception("Ya existe una solicitud con la misma cedula");
            }
            if (telefonoP.equals(todasLasSolicitudes.darTelefono())){
                throw new Exception("Ya existe una solicitud con el mismo telefono.");
            }
        }

        //Crear una instancia nueva
        Solicitud solicitudNueva = new Solicitud(nombreP, cedulaP, telefonoP, direccionP, zonaP);

        //Añade la solicitud al arrayList<solicitudes>
        solicitudes.add(solicitudNueva);

    }

    
    // TODO: Escribir el contrato, la signatura y el cuerpo del m�todo agregarTaxi para que cumpla las responsabilidades asignadas.
    // La responsabilidad del m�todo es agregar un taxi a la lista de taxis, dados la marca, el ano, la placa, el nombre del propietario
    // , la c�dula del propietario, y la zona de trabajo.
    // Las posibles condiciones de reporte de error son:
    // 1. Que ya exista un taxi registrado con la misma placa
    public void agregarTaxi(String marcaP, int anioP, String placaP, String nombrePropietarioP,String cedulaPropietarioP, String zonaP) throws Exception {

        for (Taxi taxiValidacion : taxis){
            if (placaP.equals(taxiValidacion.darPlaca())){
                throw new Exception ("Ya existe un taxi registrado con la misma placa");
            }
        }

        //Se crea un objeto de la clase Taxi
        Taxi taxiAgregar = new Taxi(marcaP, anioP, placaP, nombrePropietarioP, cedulaPropietarioP, zonaP);

        //Se agregar el objeto "taxiAgregar" al arrayList taxis.
        taxis.add(taxiAgregar);
    }
	
    /**
     * M�todo que elimina una solicitud del sistema <br>
     * <b>pre:</b> La lista de solicitudes se encuentra inicializada 
     * <b>post:</b> La solicitud se elimina de la lista<br>
     * @param telefonoP El n�mero de tel�fono correspondiente a la solicitud - telefonoP != null
     * @throws Exception En caso de que no exista una solicitud con el n�mero de tel�fono dado
     */
    // TODO: Escribir la signatura y el cuerpo del m�todo eliminarSolicitud para que cumpla las responsabilidades asignadas
    public void eliminarSolicitud(String telefonoP) throws Exception {

        for (Solicitud solicitudAEliminar : solicitudes){
            if (telefonoP.equals(solicitudAEliminar.darTelefono())){
                solicitudes.remove(solicitudAEliminar);
                return;
            }
        }

        throw new Exception("No se encontro ninguna solicitud con ese numero de telefono.");
    }
    
    /**
     * Elimina un taxi de la central
     * <b>pre:</b> La lista de taxis se encuentra inicializada 
     * <b>post:</b> El taxi se elimina de la lista<br> 
     * @param placaP Placa del taxi a eliminar. placaP != null
     * @throws Exception Si no existe un taxi con la placa indicada
     *                   Si el taxi indicado se encuentra asignado a una solicitud
     */
    // TODO: Escribir la signatura y el cuerpo del m�todo eliminarTaxi para que cumpla las responsabilidades asignadas
    public void eliminarTaxi(String placaP) throws Exception {

        //Este for me recorre solicitudes para verificar si el taxi se encuentra asignado
        for (int i = 0; i < solicitudes.size(); i++){
            Solicitud verificarSolicitud = solicitudes.get(i);

            //Si el taxi se encuentra asignado a una solicitud
            if (verificarSolicitud.darTaxi() != null && verificarSolicitud.darTaxi().equals(placaP)){
                throw new Exception("El taxi se encuentra asignado a una solicitud y no puede ser eliminado");
            }
        }

        //Hacer un for para recorrer la lista "taxis"
        for (int i = 0; i < taxis.size(); i++){
            Taxi taxiAEliminar = taxis.get(i); //Guardar todos los elementos del arrayList en "taxiAEliminar"

            //Se procede a validar si taxiAEliminar.darPlaca coincide con la placa que se paso por parametro
            if (placaP.equals(taxiAEliminar.darPlaca())){
                taxis.remove(i);  //Si coinciden la placas, procede a eliminarse ese objeto de la lista "taxis"
                return;
            }
        }

        throw new Exception("No existe un taxi con la placa indicada");
    }
    
    
    // TODO: Escribir el contrato del m�todo buscarTaxi
    public int buscarTaxi( String placaP )
    {
        for( int i = 0; i < taxis.size( ); i++ )
        {
            Taxi t = ( Taxi )taxis.get( i );
            if( t.darPlaca( ).equals( placaP ) )
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Busca una solicitud en el sistema dado un n�mero de tel�fono
     * <b>pre:</b> La lista de solicitudes se encuentra inicializada
     * @param telefonoP El tel�fono de la solicitud a buscar
     * @return La solicitud correspondiente o null si no la encuentra
     */
    // TODO: Escribir la signatura y el cuerpo del m�todo buscarSolicitudPorTelefono para que cumpla las responsabilidades asignadas

    
    
    
    
    // TODO: Escribir el contrato, la signatura y el cuerpo del m�todo buscarSolicitudPorCedula para que cumpla las responsabilidades asignadas.
    // La responsabilidad del m�todo es buscar una solicitud dada la c�dula del solicitante. Si no se encuentra la solicitud retorna null.
    // Tenga en cuenta que debe retornar un objeto de tipo Solicitud

    
    
    // TODO: Escribir el contrato, la signatura y el cuerpo del m�todo asignarSolicitud para que cumpla las responsabilidades asignadas.
    // La responsabilidad del m�todo es asignar un taxi a una solicitud, dados la placa del taxi y el tel�fono de la solicitud. 
    // Se asigna el taxi con la placa dada, a la solicitud con el tel�fono dado.
    // Las posibles condiciones de reporte de error son:
    // 1. Si no existe ninguna solicitud con el n�mero de tel�fono indicado
    // 2. Si la solicitud ya tiene asignado un taxi
    // 3. Si no existe un taxi con la placa indicada
    // 4. Si el taxi indicado no trabaja en la zona para la que la solicitud se realiz�
    // 5. Si el taxi indicado ya ha sido asignado a otra solicitud
    

   

    // TODO: Escribir el contrato del m�todo darListaTaxis
    public ArrayList darListaTaxis( )
    {
        return taxis;
    }

    // TODO: Escribir el contrato del m�todo darListaSolicitudes
    public ArrayList darListaSolicitudes(  )
    {
        return solicitudes;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------
    /**
     * M�todo para la extensi�n 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}