package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.ShowDAO;
import models.Show;

/**
 * leer fichero lleno de series y peliculas para añadir a la base de datos
 * @author Adrian Camara Muñoz
 *
 */
public class FileReaderDB {
	
	public static void llenarBD(String name) {

		String filename = name;
		Scanner sc = null;
		ArrayList<Show> shows = new ArrayList<Show>();
		boolean isString = false;
		String trozoString = "";
		String lineaCompleta = "";
		int count = 0;
		int fila = 0;
		ShowDAO ficheros = new ShowDAO();

		try {
			sc = new Scanner(new File(filename), "UTF-8");
			sc.nextLine();// cabecera
			while (sc.hasNextLine()) {
				count = 0;
				String s = sc.nextLine();
				// var trozos = s.split(",");
				// Omite las cadenas internas ""
				var trozos = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				for (String trozo : trozos) {
					if (trozo.startsWith("\"")) {
						trozo = trozo.substring(1, trozo.length());
						trozo = trozo.replaceAll("\"\"", "'");
						isString = true;
					}
					if (trozo.endsWith("\"")) {
						isString = false;
						trozo = trozo.replaceAll("\"\"", "'");
						trozoString += trozo;
						trozo = trozoString;
						trozo = trozo.substring(0, trozo.length() - 1);
						trozoString = "";
					}
					if (!isString) {
						count++;
						lineaCompleta = trozo;
					} else {
						trozoString += trozo + ",";
					}

				}

				// de cada campo del show eliminamos las " y cambiamos las ' por ` para evitar
				// fallos SQL
				for (int i = 0; i < trozos.length; i++) {
					trozos[i] = trozos[i].replace("\"", "");
					trozos[i] = trozos[i].replace("'", "`");
				}

				ficheros.insert(new Show(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], trozos[6],
						trozos[7], trozos[8], trozos[9], trozos[10], trozos[11]));

				shows.add(new Show(trozos[0], trozos[1], trozos[2], trozos[3], trozos[4], trozos[5], trozos[6],
						trozos[7], trozos[8], trozos[9], trozos[10], trozos[11]));
				fila++;
				System.out.println(shows.get(fila - 1));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
		System.out.println(shows.size());
	}
}
