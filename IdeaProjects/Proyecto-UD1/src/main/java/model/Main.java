package model;

import gui.Login;

public class Main {
	public static void main(String[] args) {
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