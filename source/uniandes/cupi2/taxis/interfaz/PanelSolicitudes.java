/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelSolicitudes.java 1333 2010-09-30 23:34:13Z dav-vill $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_taxis
 * Autor: Yeisson Oviedo - 26/Ene/2010
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.taxis.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.taxis.mundo.Solicitud;

/**
 * Panel para visualizar las solicitudes
 */
public class PanelSolicitudes extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para la serialización
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Comando del botón ver
     */
    private static final String VER = "Ver";
    
    /**
     * Comando del botón agregar
     */
    private static final String AGREGAR = "Agregar";
    
    /**
     * Comando del botón eliminar
     */
    private static final String ELIMINAR = "Eliminar";

    /**
     * Comando para asignar una solicitud
     */
	private static final String ASIGNAR = "Asignar";    

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia a la ventana principal
     */
	private InterfazCentralDeTaxis principal;
    
    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * La lista de las solicitudes
     */
    private JList lstSolicitudesRegistradas;

    /**
     * Botón para ver los detalles de una solicitud
     */
	private JButton btnVer;

	/**
	 * Botón para agregar una nueva solicitud
	 */
	private JButton btnAgregar;

	/**
	 * Botón para eliminar una solicitud
	 */
	private JButton btnEliminar;
	
	/**
	 * Botón para asignar una solicitud a un taxi
	 */
	private JButton btnAsignarSolicitud;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param principalP Referencia a la interfaz principal
     */
    public PanelSolicitudes( InterfazCentralDeTaxis principalP )
    {
    	principal = principalP;
    	setLayout( new BorderLayout() );
        setBorder( new TitledBorder( "Información de Solicitudes" ) );
        
        
        //Inicialización de la imagen superior
        JLabel lblImagenTaxi = new JLabel(new ImageIcon("data/imagenes/solicitudGrande.png"));
        add(lblImagenTaxi, BorderLayout.NORTH);

    	//Inicialización de la lista en la mitad
        JScrollPane scrSolicitudes = new JScrollPane( );
        lstSolicitudesRegistradas = new JList( );
        lstSolicitudesRegistradas.setBorder( BorderFactory.createTitledBorder( "Listado Solicitudes" ) );
        scrSolicitudes.setViewportView( lstSolicitudesRegistradas );
        add( scrSolicitudes, BorderLayout.CENTER );
        
        //Inicialización de los elementos al final
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new GridLayout(1,4, 20, 0));
        pnlBotones.setBorder(new TitledBorder("Detalle Solicitud"));
        btnVer = new JButton("Ver", new ImageIcon("data/imagenes/ver.png"));
        btnVer.setActionCommand(VER);
        btnVer.addActionListener(this);
        btnAgregar = new JButton("Agregar", new ImageIcon("data/imagenes/agregar.png"));
        btnAgregar.setActionCommand(AGREGAR);
        btnAgregar.addActionListener(this);
        btnAsignarSolicitud = new JButton("Asignar", new ImageIcon("data/imagenes/asignar.png"));
        btnAsignarSolicitud.setActionCommand(ASIGNAR);
        btnAsignarSolicitud.addActionListener(this);
        btnEliminar = new JButton("Eliminar", new ImageIcon("data/imagenes/eliminar.png"));
        btnEliminar.setActionCommand(ELIMINAR);
        btnEliminar.addActionListener(this);

        pnlBotones.add(btnVer);
        pnlBotones.add(btnAgregar);        
        pnlBotones.add(btnAsignarSolicitud);
        pnlBotones.add(btnEliminar);

        add( pnlBotones, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza el listado de solicitudes desplegadas
     * @param solicitudes El listado de taxis
     */
    public void actualizar( ArrayList solicitudes )
    {
        lstSolicitudesRegistradas.setListData( solicitudes.toArray( ) );
    }

    /**
     * Método para manejar los eventos de los botones
     */
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if (cmd.equals(VER))
	    {
			Solicitud s = (Solicitud) lstSolicitudesRegistradas.getSelectedValue();
			if (s == null)
		    {
				JOptionPane.showMessageDialog(principal, "No hay ninguna solicitud seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
		    }
			else
		    {
				DialogoInfoSolicitud dialogo = new DialogoInfoSolicitud(principal, s);
				dialogo.setVisible(true);	
		    }
	    }
		else if (cmd.equals(AGREGAR))
	    {
			DialogoInfoSolicitud dialogo = new DialogoInfoSolicitud(principal, null);
			dialogo.setVisible(true);	
	    }
		else if (cmd.equals(ASIGNAR))
	    {
			Solicitud s = (Solicitud) lstSolicitudesRegistradas.getSelectedValue();
			if (s == null)
		    {
				JOptionPane.showMessageDialog(principal, "No hay ninguna solicitud seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
		    }
			else
		    {
			    if(principal.darTaxis( ).size( )==0)
			        JOptionPane.showMessageDialog(principal, "No hay ningún taxi creado", "Error", JOptionPane.WARNING_MESSAGE);
			    else
			    {
			        DialogoAsignarSolicitud dialogo = new DialogoAsignarSolicitud(principal, s, principal.darTaxis());
	                dialogo.setVisible(true);   
			    }
			    
		    }	    
		}
		else if (cmd.equals(ELIMINAR))
	    {
			Solicitud s = (Solicitud) lstSolicitudesRegistradas.getSelectedValue();
			if (s == null)
		    {
				JOptionPane.showMessageDialog(principal, "No hay ninguna solicitud seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
		    }
			else
		    {
				if ( JOptionPane.showOptionDialog(principal, "¿Está seguro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si") == JOptionPane.OK_OPTION)
					principal.eliminarSolicitud(s.darTelefono());				
		    }
	    }		
	}
}
