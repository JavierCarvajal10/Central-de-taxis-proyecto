/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoInfoTaxi.java 1341 2010-10-05 13:35:21Z carl-veg $
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
import uniandes.cupi2.taxis.mundo.Taxi;

/**
 * Diálogo para agregar un taxi
 */
public class DialogoInfoTaxi extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando agregar taxi
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
     * Texto año
     */
    private JTextField txtAnio;
    
    /**
     * Texto cédula propietario
     */
    private JTextField txtCedulaPropietario;
    
    /**
     * Texto marca
     */
    private JTextField txtMarca;
    
    /**
     * Combo con las zonas posibles
     */
    private JComboBox comboZona;
    
    /**
     * Texto placa
     */
    private JTextField txtPlaca;
    
    /**
     * Texto nombre propietario
     */
    private JTextField txtNombrePropietario;	

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo.
     * @param nPrincipal Ventana principal de la aplicación. nPrincipal != null.
     * @param taxiP Taxi con la información a desplegar. Si es null, el dialogo se muestra en modo agregar
     */
    public DialogoInfoTaxi( InterfazCentralDeTaxis nPrincipal, Taxi taxiP )
    {    	
        super( nPrincipal, true );
        principal = nPrincipal;
                
        setLayout(new BorderLayout());
        setSize(300, 350);
        setLocationRelativeTo( nPrincipal );
       
        JPanel pnlCentral = new JPanel( new GridLayout(0,1));
        pnlCentral.setBorder(new TitledBorder("Datos Taxi"));
        
        JLabel aux;
        
        aux = new JLabel("Marca:");
        pnlCentral.add(aux);
        
        txtMarca = new JTextField();
        pnlCentral.add(txtMarca);
        
        aux = new JLabel("Año:");
        pnlCentral.add(aux);
        
        txtAnio = new JTextField();
        pnlCentral.add(txtAnio);

        aux = new JLabel("Placa:");
        pnlCentral.add(aux);
        
        txtPlaca = new JTextField();
        pnlCentral.add(txtPlaca);
        
        aux = new JLabel("Nombre Propietario:");
        pnlCentral.add(aux);
        
        txtNombrePropietario = new JTextField();
        pnlCentral.add(txtNombrePropietario);
        
        aux = new JLabel("Cédula Propietario:");
        pnlCentral.add(aux);

        txtCedulaPropietario = new JTextField();
        pnlCentral.add(txtCedulaPropietario);
        
        aux = new JLabel("Zona:");
        pnlCentral.add(aux);
        
        comboZona = new JComboBox();
        comboZona.addItem(CentralDeTaxis.ZONA_NORTE);
        comboZona.addItem(CentralDeTaxis.ZONA_ORIENTE);
        comboZona.addItem(CentralDeTaxis.ZONA_OCCIDENTE);
        comboZona.addItem(CentralDeTaxis.ZONA_SUR);
        pnlCentral.add(comboZona);
        
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
        
        if (taxiP != null)
        	mostrarDetalles (taxiP);
        else
        	agregarTaxi();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Coloca el dialogo en modo agregar taxi
     */
    private void agregarTaxi() {
    	setTitle("Agregar Taxi");
    	btnAgregar.setEnabled(true);
		
	}

    /**
     * Coloca el dialogo en modo mostrar detalles y despliega los detalles de un taxi
     * @param taxiP Taxi con detalles a mostrar
     */
	private void mostrarDetalles(Taxi taxiP) {
		setTitle("Detalles Taxi");
		btnAgregar.setEnabled(false);
		txtAnio.setText(taxiP.darAnio() + "");
		txtAnio.setEditable(false);
		txtCedulaPropietario.setText(taxiP.darCedulaPropietario());
		txtCedulaPropietario.setEditable(false);
		txtMarca.setText(taxiP.darMarca());
		txtMarca.setEditable(false);
		txtNombrePropietario.setText(taxiP.darNombrePropietario());
		txtNombrePropietario.setEditable(false);
		txtPlaca.setText(taxiP.darPlaca());
		txtPlaca.setEditable(false);
		comboZona.setSelectedItem(taxiP.darZona());
		comboZona.setEnabled(false);
	}

	/**
     * Manejo de eventos de los botones
     * @param e Acción que generó el evento. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( AGREGAR.equals( e.getActionCommand( ) ) )
        {
            int anio = 0;
            try
            {
                anio = Integer.parseInt( txtAnio.getText( ) );
            }
            catch( Exception ex )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado para el año es invalido", "Valor Invalido", JOptionPane.ERROR_MESSAGE );
                return;
            }
            if( !txtPlaca.getText( ).matches( "[A-Z][A-Z][A-Z]-[0-9][0-9][0-9]" ) )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado para la placa es invalido debe tener el formato \n [A-Z][A-Z][A-Z]-[0-9][0-9][0-9]", "Valor Invalido", JOptionPane.ERROR_MESSAGE );
                return;
            }
            if(txtMarca.getText().equals("") || txtPlaca.getText().equals("") || txtCedulaPropietario.getText().equals("") || txtNombrePropietario.getText().equals(""))
            {
            	JOptionPane.showMessageDialog( this, "Se deben diligenciar todos los campos", "Valor Invalido", JOptionPane.ERROR_MESSAGE );
            	return;
            }
            if( principal.agregarTaxi( txtMarca.getText( ), anio, txtPlaca.getText( ), (String)comboZona.getSelectedItem(), txtCedulaPropietario.getText( ), txtNombrePropietario.getText( ) ) )
                setVisible( false );
        }
        else if( VOLVER.equals( e.getActionCommand( ) ) )
        {
            setVisible( false );
        }
    }

}
