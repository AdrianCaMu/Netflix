package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import dao.UserDAO;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NetflixView {

	// Propiedades
	private JFrame parent;
	private String correo;
	private JFrame frmNetflix;
	private UserDAO usuarioDAO;
	private JTextField textField;
	private JLabel lblBuscador;
	private JLabel lblType;
	private JComboBox comboBox;
	private JLabel lblTitle;
	private JLabel lblDirector;
	private JLabel lblCast;
	private JLabel lblCountry;
	private JLabel lblDateAdded;
	private JLabel lblReleaseYear;
	private JLabel lblRating;
	private JLabel lblDurating;
	private JLabel lblListedIn;
	private JLabel lblDescription;
	private JButton btnVolver;
	private JButton btnNext;
	private JButton btnPreview;
	
	/**
	 * Create the application.
	 */
	public NetflixView(String correo, JFrame parent) {
		this.correo = correo;
		this.parent = parent;
		usuarioDAO = new UserDAO();
		initialize();
		this.frmNetflix.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNetflix = new JFrame();
		frmNetflix.getContentPane().setLayout(null);
		
		lblBuscador = new JLabel("Buscador");
		lblBuscador.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBuscador.setBounds(31, 627, 107, 43);
		frmNetflix.getContentPane().add(lblBuscador);
		
		comboBox = new JComboBox();
		comboBox.setBounds(154, 627, 214, 43);
		frmNetflix.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(378, 627, 313, 43);
		frmNetflix.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblType.setBounds(31, 209, 390, 35);
		frmNetflix.getContentPane().add(lblType);
		
		lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(31, 255, 390, 35);
		frmNetflix.getContentPane().add(lblTitle);
		
		lblDirector = new JLabel("Director:");
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDirector.setBounds(431, 209, 390, 35);
		frmNetflix.getContentPane().add(lblDirector);
		
		lblCast = new JLabel("Cast:");
		lblCast.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCast.setBounds(31, 301, 790, 35);
		frmNetflix.getContentPane().add(lblCast);
		
		lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCountry.setBounds(431, 255, 390, 35);
		frmNetflix.getContentPane().add(lblCountry);
		
		lblDateAdded = new JLabel("Date added:");
		lblDateAdded.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDateAdded.setBounds(31, 347, 390, 35);
		frmNetflix.getContentPane().add(lblDateAdded);
		
		lblReleaseYear = new JLabel("Release year:");
		lblReleaseYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReleaseYear.setBounds(431, 347, 390, 35);
		frmNetflix.getContentPane().add(lblReleaseYear);
		
		lblRating = new JLabel("Rating:");
		lblRating.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRating.setBounds(31, 393, 390, 35);
		frmNetflix.getContentPane().add(lblRating);
		
		lblDurating = new JLabel("Duration:");
		lblDurating.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDurating.setBounds(431, 393, 390, 35);
		frmNetflix.getContentPane().add(lblDurating);
		
		lblListedIn = new JLabel("Listed In:");
		lblListedIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListedIn.setBounds(31, 449, 390, 35);
		frmNetflix.getContentPane().add(lblListedIn);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescription.setBounds(31, 495, 790, 35);
		frmNetflix.getContentPane().add(lblDescription);
		
		btnVolver = new JButton("Cerrar Sesi\u00F3n");
		btnVolver.setBounds(701, 629, 120, 41);
		frmNetflix.getContentPane().add(btnVolver);
		
		btnNext = new JButton(">");
		btnNext.setBounds(431, 36, 390, 49);
		frmNetflix.getContentPane().add(btnNext);
		
		btnPreview = new JButton("<");
		btnPreview.setBounds(31, 36, 390, 49);
		frmNetflix.getContentPane().add(btnPreview);
		configureUIComponents();
		configureListener();
	}

	/**
	 * configuracion de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmNetflix = new JFrame();
		frmNetflix.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmNetflix.setIconImage(
				Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/utils/images/netflix_icon.png")));
		frmNetflix.setBounds(100, 100, 900, 750);
		frmNetflix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNetflix.getContentPane().setLayout(null);
	}

	/**
	 * configuracion de la activacion de los botones
	 */
	private void configureListener() {
	}
}