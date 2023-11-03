package model;

import gui.Login;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		App app = new App();
		Login login = new Login(app);
		login.setVisible(true);
	}

	String name = "admin";
	String password = "admin";
	String age = "0";
	String mail = "admin@admin.local";
	User usuario = new User(name, password, age, mail);

}