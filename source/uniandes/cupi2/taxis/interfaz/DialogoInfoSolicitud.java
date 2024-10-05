/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoInfoSolicitud.java 1129 2010-02-16 23:58:41Z y-oviedo $
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.taxis.mundo.CentralDeTaxis;
import uniandes.cupi2.taxis.mundo.Solicitud;

/**
 * Diálogo para agregar un vehículo
 */
public class DialogoInfoSolicitud extends JDialog implements ActionListener
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante para la serialización
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Comando agregar solicitud
	 */
	private static final String AGREGAR = "AGREGAR";

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


	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------

	/**
	 * Botón agregar
	 */
	private JButton btnAgregar;

	/**
	 * Botón cancelar
	 */
	private JButton btnVolver;

	/**
	 * Texto teléfono
	 */
	private JTextField txtTelefono;

	/**
	 * Texto dirección
	 */
	private JTextField txtDireccion;

	/**
	 * Combo para la zona de la ciudad correspondiente a la solicitud
	 */
	private JComboBox comboZona;


	/**
	 * Texto usuario
	 */
	private JTextField txtUsuario;    

	/**
	 * Texto taxi asignado
	 */
	private JTextField txtTaxi;

	/**
	 * Texto con la cédula del usuario
	 */
	private JTextField txtCedula;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del diálogo.
	 * @param nPrincipal Ventana principal de la aplicación. nPrincipal != null.
	 * @param s Solicitud a desplegar. Si es null, el dialogo se muestra en modo agregar
	 */
	public DialogoInfoSolicitud( InterfazCentralDeTaxis nPrincipal, Solicitud s )
	{
		super( nPrincipal, true );
		principal = nPrincipal;

		setSize(300, 350);        
		setLocationRelativeTo( principal );
		setLayout(new BorderLayout());        

		JPanel pnlCentral = new JPanel( new GridLayout(0,1));
		pnlCentral.setBorder(new TitledBorder("Datos Solicitud"));

		JLabel aux;

		aux = new JLabel("Telefono:");
		pnlCentral.add(aux);

		txtTelefono = new JTextField();	
		pnlCentral.add(txtTelefono);

		aux = new JLabel("Dirección:");
		pnlCentral.add(aux);

		txtDireccion = new JTextField();
		pnlCentral.add(txtDireccion);

		aux = new JLabel("Zona:");
		pnlCentral.add(aux);

		comboZona = new JComboBox();
		comboZona.addItem(CentralDeTaxis.ZONA_NORTE);
		comboZona.addItem(CentralDeTaxis.ZONA_ORIENTE);
		comboZona.addItem(CentralDeTaxis.ZONA_OCCIDENTE);
		comboZona.addItem(CentralDeTaxis.ZONA_SUR);
		pnlCentral.add(comboZona);

		aux = new JLabel("Usuario:");
		pnlCentral.add(aux);

		txtUsuario = new JTextField();
		pnlCentral.add(txtUsuario);

		aux = new JLabel("Cédula Usuario:");
		pnlCentral.add(aux);

		txtCedula = new JTextField();
		pnlCentral.add(txtCedula);

		aux = new JLabel("Taxi:");
		pnlCentral.add(aux);

		txtTaxi = new JTextField();
		txtTaxi.setEditable(false);
		pnlCentral.add(txtTaxi);

		add( pnlCentral, BorderLayout.CENTER );

		JPanel pnlBotones = new JPanel(new GridLayout(1,2));
		btnAgregar = new JButton("Agregar", new ImageIcon("data/imagenes/agregar.png"));
		btnAgregar.setActionCommand(AGREGAR);
		btnAgregar.addActionListener(this);
		pnlBotones.add(btnAgregar);

		btnVolver = new JButton("Volver", new ImageIcon("data/imagenes/volver.png"));
		btnVolver.setActionCommand(VOLVER);        
		btnVolver.addActionListener(this);
		pnlBotones.add(btnVolver);

		add(pnlBotones, BorderLayout.SOUTH);

		if (s != null)
			mostrarDetalles (s);
		else
			agregarSolicitud();
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Coloca el dialogo en el modo agregar 
	 */
	private void agregarSolicitud() 
	{
		setTitle("Agregar Solicitud");
		btnAgregar.setEnabled(true);
	}

	/**
	 * Coloca el dialogo en modo mostrar detalles y despliega los detalles de una solicitud
	 * @param s Solicitud con detalles a mostrar
	 */
	private void mostrarDetalles(Solicitud s)
	{
		setTitle("Detalles Solicitud");
		btnAgregar.setEnabled(false);
		txtTelefono.setText(s.darTelefono());
		txtTelefono.setEditable(false);
		txtDireccion.setText(s.darDireccion());
		txtDireccion.setEditable(false);
		txtUsuario.setText(s.darNombre());
		txtUsuario.setEditable(false);
		txtCedula.setText(s.darCedula());
		txtCedula.setEditable(false);
		comboZona.setSelectedItem(s.darZona());
		comboZona.setEnabled(false);
		String taxi = (s.darTaxi() == null ? "No asignado": s.darTaxi().darPlaca());
		txtTaxi.setText(taxi);
		txtTaxi.setEditable(false);
	}

	/**
	 * Manejo de eventos de los botones
	 * @param e Acción que generó el evento. e != null.
	 */
	public void actionPerformed( ActionEvent e )
	{
		if( AGREGAR.equals( e.getActionCommand( ) ) )
		{
			if (txtUsuario.getText().equals("") || txtCedula.getText().equals("") || txtTelefono.getText().equals("") || txtDireccion.getText().equals(""))
			{
				JOptionPane.showMessageDialog(principal, "Se deben diligenciar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if( principal.agregarSolicitud(txtUsuario.getText(), txtCedula.getText(), txtTelefono.getText(), txtDireccion.getText(), (String) comboZona.getSelectedItem() ))
				setVisible( false );
		}
		else if( VOLVER.equals( e.getActionCommand( ) ) )
		{
			setVisible( false );
		}
	}
}
