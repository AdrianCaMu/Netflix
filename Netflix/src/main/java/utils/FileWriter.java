package utils;

import java.io.File;
import javax.swing.JOptionPane;

public class FileWriter {
	
	private final static String favoritos = "assets/favoritos.csv";
	private static File file = new File(favoritos);

	public void writer(String show, boolean overwrite) {
		try {
			
			FileWriter fw = new FileWriter(file, overwrite);
			
			
			//comprueba si la serie ya existe en el fichero
			if(checkShow(show)) {
				
			}else {
				JOptionPane.showMessageDialog(null, "Show ya registrado en favoritos");

			}

			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	private boolean checkShow(String show) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
