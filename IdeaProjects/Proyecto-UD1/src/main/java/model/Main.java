package model;

import gui.Login;

public class Main {
	public static void main(String[] args) {
		App app = new App();
		Login login = new Login(app);
		login.setVisible(true);
	}

	String name = "admin";
	String passwd = "admin";
	String passwdHash = User.PassHashGen.PassHashGen(passwd);
	int age = 19;
	String mail = "admin@admin.com";
	User usuario = new User(name, passwdHash, age, mail);

}