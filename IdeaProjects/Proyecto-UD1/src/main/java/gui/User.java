package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.xml.parsers.ParserConfigurationException;

import model.App;
import model.Users;

public class User extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel etiquetaMenuUsuario;
	private JButton btnVerDatos;
	private JButton btnCambiarContraseña;
	private JButton btnBorrarUsuario;
	private JButton btnExportarUsuarios;
	private JButton btnCrearNuevoUsuario;
	private JButton btnCerrarSesion;
	private App app;
	private User currentUser;
	private String nombreUsuario;

	public User(App app, String nombreUsuario) {
		this.app = app;
		this.currentUser = currentUser;
		int paddingLeft = 75;

		setTitle("Aplicación usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		etiquetaMenuUsuario = new JLabel(nombreUsuario, SwingConstants.CENTER);
		etiquetaMenuUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		etiquetaMenuUsuario.setBounds(0, 20, 300, 30);
		contentPane.add(etiquetaMenuUsuario);

		btnVerDatos = new JButton("Ver datos");
		btnVerDatos.setBounds(paddingLeft, 64, 150, 23);
		btnVerDatos.addActionListener(this);
		contentPane.add(btnVerDatos);

		btnCambiarContraseña = new JButton("Cambiar contraseña");
		btnCambiarContraseña.setBounds(paddingLeft, 98, 150, 23);
		btnCambiarContraseña.addActionListener(this);
		contentPane.add(btnCambiarContraseña);

		if(!nombreUsuario.equals("admin")) {
			btnBorrarUsuario = new JButton("Borrar usuario");
			btnBorrarUsuario.setBounds(paddingLeft, 132, 150, 23);
			btnBorrarUsuario.addActionListener(this);
			btnBorrarUsuario.setBackground(Color.decode("#e74c3c"));
			btnBorrarUsuario.setForeground(Color.decode("#ecf0f1"));
			contentPane.add(btnBorrarUsuario);
		}

		btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.setBounds(paddingLeft, 200, 150, 23);
		btnCerrarSesion.addActionListener(this);
		contentPane.add(btnCerrarSesion);

		System.out.println(nombreUsuario);
		if(nombreUsuario.equals("admin")) {
			setBounds(0, 0, 300, 360);

			btnCrearNuevoUsuario = new JButton("Crear nuevo usuario");
			btnCrearNuevoUsuario.setBounds(paddingLeft, 180, 150, 23);
			btnCrearNuevoUsuario.addActionListener(this);
			contentPane.add(btnCrearNuevoUsuario);

			btnExportarUsuarios = new JButton("Exportar usuarios");
			btnExportarUsuarios.setBounds(paddingLeft, 210, 150, 23);
			btnExportarUsuarios.addActionListener(this);
			contentPane.add(btnExportarUsuarios);

			btnCerrarSesion.setBounds(paddingLeft, 270, 150, 23);
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//Boton Ver Datos
		if(e.getSource() == btnVerDatos) {
			app.showUserDetailsWindow();
		}

		//Boton Cambiar Contraseña
		if (e.getSource() == btnCambiarContraseña) {
			app.showChangePasswordWindow();
		}

		if (e.getSource() == btnCrearNuevoUsuario) {
			app.createUserWindow();
		}

		if (e.getSource() == btnBorrarUsuario) {
			app.deleteUserWindow();
			dispose();
		}

		// Boton Exportar Usuarios
		if(e.getSource() == btnExportarUsuarios) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setSelectedFile(new File("users.zip"));
			int value = fileChooser.showOpenDialog(null);
			if (value == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();

				try {
					app.zipExport(file);
				} catch (ParserConfigurationException | IOException ex) {
					throw new RuntimeException(ex);
				}
			}

		}

		// Boton Cerrar Sesion
		if (e.getSource() == btnCerrarSesion) {
			dispose();
			app.closeSession();
		}


	}


}
