/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazCentralDeTaxis.java 1129 2010-02-16 23:58:41Z y-oviedo $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_taxis
 * Autor: Yeisson Oviedo - 26/Ene/2010
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.taxis.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import uniandes.cupi2.taxis.mundo.CentralDeTaxis;
/**
 * Esta es la ventana principal de la aplicaci�n.
 */
public class InterfazCentralDeTaxis extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Constante para la serializaci�n
     */
    private static final long serialVersionUID = 1L;

    /**
     * Clase principal del mundo
     */
    private CentralDeTaxis centralDeTaxis;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la imagen del encabezado
     */
    private PanelImagen panelImagen;

    /**
     * Tabs con la informaci�n de usuarios, taxis y solicitudes
     */
    private JTabbedPane tbpOpciones;

    /**
     * Panel con la informaci�n de los taxis
     */
    private PanelTaxis panelTaxis;

    /**
     * Panel con la informaci�n de las solicitudes
     */
	private PanelSolicitudes panelSolicitudes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la interfaz de la aplicaci�n
     */
    public InterfazCentralDeTaxis( )
    {    	    		
        // Crea la clase principal
        centralDeTaxis = new CentralDeTaxis( );

        // Construye la ventana
        setTitle( "Central de Taxis Cupi2" );
        setLayout( new BorderLayout( ) );
        setSize( 700, 830 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo( null );

        // Creaci�n de los paneles aqu�
        panelImagen = new PanelImagen( );        
        
        JPanel panelIzquierda = new JPanel();
        setBackground( Color.BLACK );        
        JLabel imagen = new JLabel( );
        imagen.setIcon( new ImageIcon( "data/imagenes/bannerLateral.png" ));
        panelIzquierda.add( imagen );


        JPanel principal = new JPanel();
        principal.setLayout(new BorderLayout());
        panelTaxis = new PanelTaxis( this );
        panelSolicitudes = new PanelSolicitudes(this); 
        
        tbpOpciones = new JTabbedPane( );
        tbpOpciones.setTabPlacement( JTabbedPane.TOP );
        tbpOpciones.addTab( "Solicitudes", new ImageIcon( "./data/imagenes/solicitud.png" ), panelSolicitudes );
        tbpOpciones.addTab( "Taxis", new ImageIcon( "./data/imagenes/taxi.png" ), panelTaxis );       
        principal.add( tbpOpciones, BorderLayout.CENTER );

        panelExtension = new PanelExtension( this );
        principal.add( panelExtension, BorderLayout.SOUTH );

        //Agregar los paneles en el orden correspondiente
        add(panelImagen, BorderLayout.NORTH );
        add(principal, BorderLayout.CENTER);
        add(panelIzquierda, BorderLayout.WEST);        
        
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------  

    /**
     * M�todo para agregar un taxi
     * @param marcaP El modelo del taxi
     * @param anioP El a�o del taxi
     * @param placaP la placa del taxi
     * @param zonaP El n�mero del motor del taxi
     * @param cedulaP El n�mero de chasis del taxi
     * @param nombrePropietarioP La identificaci�n del propietario del taxi
     * @return Verdadero si se agrega el taxi o falso en caso de encontrar una excepci�n
     */
    public boolean agregarTaxi( String marcaP, int anioP, String placaP, String zonaP, String cedulaP, String nombrePropietarioP )
    {
        try
        {
            centralDeTaxis.agregarTaxi( marcaP, anioP, placaP, nombrePropietarioP, cedulaP, zonaP );
            panelTaxis.actualizar( centralDeTaxis.darListaTaxis( ) );
        }
        catch( Exception e )
        {
            mostrarException( e );
            return false;
        }
        return true;
    }
    
    /**
     * M�todo para eliminar un taxi del sistema
     * @param placaP Placa del taxi a eliminar
     */
	public void eliminarTaxi(String placaP) {
		try {
			centralDeTaxis.eliminarTaxi(placaP);
			panelTaxis.actualizar( centralDeTaxis.darListaTaxis( ) );
		} catch (Exception e) {
			mostrarException(e);
		}
	}

    /**
     * Agrega una solicitud en el sistema
     * @param nombreP Los nombres de la persona que solicita - nombre != null
     * @param cedulaP La identificaci�n de la persona - cedulaP != null
     * @param telefonoP El tel�fono desde donde se realiza la solicitud - telefonoP != null 
     * @param direccionP La direcci�n a donde se solicita el servicio - direccionP != null
     * @param zonaP La zona de la ciudad a la que corresponde la direcci�n - zonaP != null && (zonaP == CentralDeTaxis.ZONA_OCCIDENTE || zonaP == CentralDeTaxis.ZONA_NORTE || zonaP == CentralDeTaxis.ZONA_ORIENTE || zonaP == CentralDeTaxis.ZONA_SUR )
     * @return Verdadero si se agrega la solicitud o falso en caso de encontrar una excepci�n
     */
    public boolean agregarSolicitud( String nombreP, String cedulaP, String telefonoP, String direccionP, String zonaP)
    {
        try
        {
            centralDeTaxis.agregarSolicitud( nombreP, cedulaP, telefonoP, direccionP, zonaP);
            panelSolicitudes.actualizar( centralDeTaxis.darListaSolicitudes() );
        }
        catch( Exception e )
        {
            mostrarException( e );
            return false;
        }
        return true;
    }
    
    /**
     * M�todo para eliminar una solicitud del sistema
     * @param telefonoP Tel�fono desde donde se realiz� la solicitud
     */
	public void eliminarSolicitud(String telefonoP) {
		try {
			centralDeTaxis.eliminarSolicitud(telefonoP);
			panelSolicitudes.actualizar( centralDeTaxis.darListaSolicitudes() );
		} catch (Exception e) {
			mostrarException(e);
		}		
	}
	
	/**
	 * M�todo para asignar una solicitud a un taxi
	 * @param placaP Placa del taxi
	 * @param telefonoP Tel�fono desde donde se realiz� la solicitud
	 * @return Retorna true si se logr� asignar correctamente la solicitud, false en caso contrario
	 */
	public boolean asignarSolicitud(String placaP, String telefonoP) {
		try{
			centralDeTaxis.asignarSolicitud(placaP, telefonoP);
			panelSolicitudes.actualizar( centralDeTaxis.darListaSolicitudes() );
		}		
		catch (Exception e) {
			mostrarException(e);
			return false;
		}		
		return true;
	}

	/**
	 * M�todo utilitario para retornar el listado de taxis
	 * @return El listado de taxis 
	 */
	public ArrayList darTaxis() {
		return centralDeTaxis.darListaTaxis();
	}
	
    /**
     * M�todo que muestra un dialogo de error con el mensaje de una excepci�n
     * @param ex La excepci�n para mostrar
     */
    public void mostrarException( Exception ex )
    {
        JOptionPane.showMessageDialog( this, ex.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
    }     

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = centralDeTaxis.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = centralDeTaxis.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {
        InterfazCentralDeTaxis interfaz = new InterfazCentralDeTaxis( );
        interfaz.setVisible( true );
    }
}