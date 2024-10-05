/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoAsignarSolicitud.java 1336 2010-10-01 14:31:38Z dav-vill $
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.taxis.mundo.Solicitud;
import uniandes.cupi2.taxis.mundo.Taxi;

/**
 * Di�logo para asignar una solicitud a un taxi
 */
public class DialogoAsignarSolicitud extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serializaci�n
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando agregar solicitud
     */
    private static final String ASIGNAR = "ASIGNAR";

    /**
     * Comando para cancelar
     */
    private static final String VOLVER = "VOLVER";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal
     */
    private InterfazCentralDeTaxis principal;
      
    /**
     * Referencia a la solicitud que se est� asignando
     */
	private Solicitud solicitud;
	
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n asignar
     */
    private JButton btnAsignar;
    
    /**
     * Bot�n cancelar
     */
    private JButton btnVolver;
      
    /**
     * Texto n�mero motor
     */
    private JComboBox comboTaxis;
       
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del di�logo.
     * @param nPrincipal Ventana principal de la aplicaci�n. nPrincipal != null.
     * @param solicitudP Solicitud a la que se va a asignar el taxi
     * @param taxis Taxi a asignar
     */
    public DialogoAsignarSolicitud( InterfazCentralDeTaxis nPrincipal, Solicitud solicitudP, ArrayList taxis )
    {
        super( nPrincipal, true );
        
        principal = nPrincipal;
        solicitud = solicitudP;

        setSize(300, 200);
        setLocationRelativeTo( principal );
        setLayout(new BorderLayout());
        setTitle( "Asignar Solicitud" );
        
        JPanel pnlCentral = new JPanel( new GridLayout(0,1));
        pnlCentral.setBorder(new TitledBorder("Asignar Solicitud"));
        
        JLabel aux;
        
        aux = new JLabel("Taxis registrados:");
        pnlCentral.add(aux);
        
        comboTaxis = new JComboBox();
        for (int i = 0; i < taxis.size(); i++)
        	comboTaxis.addItem(taxis.get(i));
        pnlCentral.add(comboTaxis);
                        
        add( pnlCentral, BorderLayout.CENTER );
        
        JPanel pnlBotones = new JPanel(new GridLayout(1,2));
        btnAsignar = new JButton("Asignar", new ImageIcon("data/imagenes/asignar.png"));
        btnAsignar.setActionCommand(ASIGNAR);
        btnAsignar.addActionListener(this);
        pnlBotones.add(btnAsignar);
        
        btnVolver = new JButton("Volver", new ImageIcon("data/imagenes/volver.png"));
        btnVolver.setActionCommand(VOLVER);        
        btnVolver.addActionListener(this);
        pnlBotones.add(btnVolver);
        
        add(pnlBotones, BorderLayout.SOUTH);        
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
       
	/**
     * Manejo de eventos de los botones
     * @param e Acci�n que gener� el evento. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( ASIGNAR.equals( e.getActionCommand( ) ) )
        {
        	Taxi t = (Taxi)comboTaxis.getSelectedItem();
            if( principal.asignarSolicitud(t.darPlaca(), solicitud.darTelefono()));
                setVisible( false );
        }
        else if( VOLVER.equals( e.getActionCommand( ) ) )
        {
            setVisible( false );
        }
    }

}
