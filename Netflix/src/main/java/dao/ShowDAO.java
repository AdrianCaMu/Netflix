package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Show;

public class ShowDAO extends AbstractDAO {
	public ShowDAO() {
		super();
	}
	
	public ArrayList<Show> getAll() {
		final String QUERY = "SELECT id, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description "
				+ "FROM Series";
		ArrayList<Show> series = new ArrayList<Show>();
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			
			while (rs.next()) {
				String show_id = rs.getString("id");
				String type = rs.getString("type");
				String title = rs.getString("tittle");
				String director = rs.getString("director");
				String cast = rs.getString("cast");
				String country = rs.getString("country");
				String date_added = rs.getString("date_added");
				String release_year = rs.getString("release_year");
				String rating = rs.getString("rating");
				String duration = rs.getString("duration");
				String listed_in = rs.getString("listed_in");
				String description = rs.getString("description");
				
				Show s = new Show(show_id, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description);	
				series.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return series;
	}

	public void insert(Show s) {
		final String INSERT = "INSERT INTO Series(id, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description)"
				+ " VALUES('" + s.getShow_id() + "', '" + s.getType() + "', '" + s.getTitle() + "', '" + s.getDirector()
				+ "', '" + s.getCast() + "', '" + s.getCountry() + "', '" + s.getDate_added() + "', '"
				+ s.getRelease_year() + "', '" + s.getRating() + "', '" + s.getDuration() + "', '" + s.getListed_in()
				+ "', '" + s.getDescription() + "')";
		try {
			stmt.executeUpdate(INSERT);

		} catch (SQLException e) {
			System.out.println("El elemento no se ha podido introducir");
		}
	}

	public void delete(Show s) {
		final String DELETE = "delete from Series where id = " + s.getShow_id();
		try {
			stmt.executeUpdate(DELETE);
		} catch (Exception e) {
			System.out.println("El elemento no se ha podido eliminar");
		}
	}
}
