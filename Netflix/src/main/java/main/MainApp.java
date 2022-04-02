package main;
import ui.LoginView;
import utils.FileReaderDB;

public class MainApp {
	public static void main(String[] args) {
		//FileReaderDB.llenarBD("netflix_titles.csv");
		new LoginView();
	}
}