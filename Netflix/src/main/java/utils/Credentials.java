package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Credentials {

	private final static String appSettingsFile = "assets/appsettings.json";

	private static String readFromFile(String keyword) {
		List<String> list;

		try {
			list = Files.readAllLines(new File(appSettingsFile).toPath());
			String appsettingsContent = "";
			for (var l : list) {
				appsettingsContent += l;
			}
			JsonObject jsonObject = JsonParser.parseString(appsettingsContent).getAsJsonObject();

			return jsonObject.get(keyword).getAsString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String correoEmailing() {
		return readFromFile("userEmail");
	}

	public static String passwordEmailing() {
		return readFromFile("passwordEmail");
	}

	public static String getPassDB() {
		return readFromFile("passwordBD");
	}

	public static String getUserDB() {
		return readFromFile("userBD");
	}

	public static String getUrlDB() {
		return readFromFile("urlDB");
	}
}
