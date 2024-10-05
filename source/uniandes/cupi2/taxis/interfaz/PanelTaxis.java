/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelTaxis.java 1334 2010-09-30 23:34:18Z dav-vill $
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

import uniandes.cupi2.taxis.mundo.Taxi;

/**
 * Panel para visualizar los taxis
 */
public class PanelTaxis extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para la serializaci�n
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Comando del bot�n ver
     */
    private static final String VER = "Ver";
    
    /**
     * Comando del bot�n agregar
     */
    private static final String AGREGAR = "Agregar";
    
    /**
     * Comando del bot�n eliminar
     */
    private static final String ELIMINAR = "Eliminar";    

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
     * La lista de taxis registrados
     */
    private JList lstTaxisRegistrados;

    /**
     * Bot�n para ver los detalles de un taxi
     */
	private JButton btnVer;

	/**
	 * Bot�n para agregar un taxi nuevo
	 */
	private JButton btnAgregar;

	/**
	 * Bot�n para eliminar un taxi
	 */
	private JButton btnEliminar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param principalP Referencia a la interfaz
     */
    public PanelTaxis( InterfazCentralDeTaxis principalP )
    {
    	principal = principalP;
    	setLayout( new BorderLayout() );
        setBorder( new TitledBorder( "Informaci�n de Taxis" ) );
        
        
        //Inicializaci�n de la imagen superior
        JLabel lblImagenTaxi = new JLabel(new ImageIcon("data/imagenes/taxiGrande.png"));
        add(lblImagenTaxi, BorderLayout.NORTH);

    	//Inicializaci�n de la lista en la mitad
        JScrollPane scrVehiculosRegistrados = new JScrollPane( );
        lstTaxisRegistrados = new JList( );
        lstTaxisRegistrados.setBorder( BorderFactory.createTitledBorder( "Listado Taxis" ) );
        scrVehiculosRegistrados.setViewportView( lstTaxisRegistrados );
        add( scrVehiculosRegistrados, BorderLayout.CENTER );
        
        //Inicializaci�n de los elementos al final
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new GridLayout(1,3, 20, 0));
        pnlBotones.setBorder(new TitledBorder("Detalle Taxi"));
        btnVer = new JButton("Ver", new ImageIcon("data/imagenes/ver.png"));
        btnVer.setActionCommand(VER);
        btnVer.addActionListener(this);
        btnAgregar = new JButton("Agregar", new ImageIcon("data/imagenes/agregar.png"));
        btnAgregar.setActionCommand(AGREGAR);
        btnAgregar.addActionListener(this);
        btnEliminar = new JButton("Eliminar", new ImageIcon("data/imagenes/eliminar.png"));
        btnEliminar.setActionCommand(ELIMINAR);
        btnEliminar.addActionListener(this);

        pnlBotones.add(btnVer);
        pnlBotones.add(btnAgregar);
        pnlBotones.add(btnEliminar);

        add( pnlBotones, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza el listado de taxis mostrado
     * @param taxis El listado de taxis
     */
    public void actualizar( ArrayList taxis )
    {
        lstTaxisRegistrados.setListData( taxis.toArray( ) );
    }

    /**
     * M�todo para manejar los eventos de los botones 
     */
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if (cmd.equals(VER))
	    {
			Taxi t = (Taxi) lstTaxisRegistrados.getSelectedValue();
			if (t == null)
		    {
				JOptionPane.showMessageDialog(principal, "No hay ning�n taxi seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
		    }
			else
		    {
				DialogoInfoTaxi dialogo = new DialogoInfoTaxi(principal, t);
				dialogo.setVisible(true);	
		    }
	    }
		else if (cmd.equals(AGREGAR))
	    {
			DialogoInfoTaxi dialogo = new DialogoInfoTaxi(principal, null);
			dialogo.setVisible(true);	
	    }
		else if (cmd.equals(ELIMINAR))
	    {
			Taxi t = (Taxi) lstTaxisRegistrados.getSelectedValue();
			if (t == null)
		    {
				JOptionPane.showMessageDialog(principal, "No hay ning�n taxi seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
		    }
			else
		    {
				if (JOptionPane.showOptionDialog(principal, "�Est� seguro de eliminar el taxi?", "Confirmaci�n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si") == JOptionPane.OK_OPTION)
					principal.eliminarTaxi (t.darPlaca());				
		    }
	    }		
	}
}
