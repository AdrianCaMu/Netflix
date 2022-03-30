package ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import models.User;
import utils.Emailing;
import utils.Hash;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import dao.UserDAO;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class LoginView {

	// Propiedades
	private JFrame frmLogin;
	private JTextField tfUser;
	private JButton btnLogin;
	private JButton btnRegister;
	private JLabel lblCorreo;
	private JLabel lblPasswd;
	private JPasswordField pfPassword;
	private JLabel lblErrorMessage;
	private UserDAO usuarioDAO;
	private JButton btnRecuperarPasswd;
	private JLabel lblFondo;

	/**
	 * Create the application.
	 */
	public LoginView() {
		usuarioDAO = new UserDAO();
		initialize();
		this.frmLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		configureUIComponents();
		configureListener();
	}

	/**
	 * configuracion de los distintos elementos de la pantalla
	 */
	private void configureUIComponents() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmLogin.setIconImage(
				Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/utils/images/netflix_icon.png")));
		frmLogin.setBounds(100, 100, 900, 750);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		this.btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon(LoginView.class.getResource("/utils/images/Login.png")));
		btnLogin.setBounds(482, 449, 200, 85);
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setOpaque(false);
		frmLogin.getContentPane().add(btnLogin);

		btnRegister = new JButton("");
		btnRegister.setIcon(new ImageIcon(LoginView.class.getResource("/utils/images/Register.png")));
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setBounds(224, 449, 200, 85);
		btnRegister.setBorderPainted(false);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setFocusPainted(false);
		btnRegister.setOpaque(false);
		frmLogin.getContentPane().add(btnRegister);

		tfUser = new JTextField();
		tfUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfUser.setHorizontalAlignment(SwingConstants.CENTER);
		tfUser.setForeground(new Color(56, 109, 185));
		tfUser.setBackground(Color.WHITE);
		tfUser.setBounds(458, 300, 179, 38);
		frmLogin.getContentPane().add(tfUser);
		tfUser.setColumns(10);

		lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.DARK_GRAY);
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCorreo.setBounds(286, 297, 108, 38);
		frmLogin.getContentPane().add(lblCorreo);

		lblPasswd = new JLabel("Password");
		lblPasswd.setForeground(Color.DARK_GRAY);
		lblPasswd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswd.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPasswd.setBounds(235, 341, 162, 38);
		frmLogin.getContentPane().add(lblPasswd);

		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		pfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pfPassword.setForeground(new Color(56, 109, 185));
		pfPassword.setBackground(Color.WHITE);
		pfPassword.setBounds(458, 348, 179, 38);
		frmLogin.getContentPane().add(pfPassword);

		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(235, 410, 402, 38);
		frmLogin.getContentPane().add(lblErrorMessage);
		
		btnRecuperarPasswd = new JButton("");
		btnRecuperarPasswd.setIcon(new ImageIcon(LoginView.class.getResource("/utils/images/ForgottenPasswd.png")));
		btnRecuperarPasswd.setOpaque(false);
		btnRecuperarPasswd.setFocusPainted(false);
		btnRecuperarPasswd.setContentAreaFilled(false);
		btnRecuperarPasswd.setBorderPainted(false);
		btnRecuperarPasswd.setBackground(Color.WHITE);
		btnRecuperarPasswd.setBounds(355, 544, 200, 85);
		frmLogin.getContentPane().add(btnRecuperarPasswd);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(LoginView.class.getResource("/utils/images/fondo.png")));
		lblFondo.setBounds(0, 0, 886, 731);
		frmLogin.getContentPane().add(lblFondo);
	}

	/**
	 * configuracion de la activacion de los botones
	 */
	private void configureListener() {
		// boton login para acceder a la pokedex
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});

		// Enter tras poner user para ir al campo contraseña
		tfUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					pfPassword.requestFocus();
				}
			}
		});

		// Enter tras poner contraseña para acceder a la pokedex
		pfPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkLogin();
				}
			}
		});

		// vamos a la pagina de registro para crear una cuenta nueva
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setVisible(false);
				new RegisterView(frmLogin);
			}
		});
		
		//recuperar contraseña olvidada
		btnRecuperarPasswd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
				new RecuperarView();
			}
		});
	}

	/**
	 * comprueba si el usuario y la contraseña son correctos
	 */
	private void checkLogin() {

		String correo = tfUser.getText();
		String passwd = new String(pfPassword.getPassword());
		String passwdCodified  = Hash.HashIt(passwd, "123456");	

		try {
		
			boolean logicaCorrecto = usuarioDAO.login(correo, passwdCodified);
			if (logicaCorrecto) {
				frmLogin.dispose();
				new NetflixView(correo, frmLogin);
			} else {
				lblErrorMessage.setText("ERROR: correo o contraseña incorrectos.");
			}
		
		}catch(Exception e) {
			lblErrorMessage.setText("ERROR: correo o contraseña incorrectos.");
		}
		

	}
}