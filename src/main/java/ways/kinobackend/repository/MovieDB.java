package ways.kinobackend.repository;
import ways.kinobackend.model.Movie;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.SQLException;

public class MovieDB {

    public void addMovie(Movie movie) {
        Connection con = ConnectionManager.getConnection();
        String SQLScript = "INSERT INTO movies (title, duration, director, image, genre, description, pegi) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(SQLScript);
            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getDuration());
            ps.setString(3, movie.getDirector());
            ps.setString(4, movie.getImage());
            ps.setString(5, movie.getGenre());
            ps.setString(6, movie.getDescription());
            ps.setString(7, movie.getPegi());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void editMovie(Movie movie) {
        Connection con = ConnectionManager.getConnection();
        String SQLScript = "UPDATE movies SET title=?, duration=?, director=?, image=?, genre=?, description=?, pegi=? WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(SQLScript);
            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getDuration());
            ps.setString(3, movie.getDirector());
            ps.setString(4, movie.getImage());
            ps.setString(5, movie.getGenre());
            ps.setString(6, movie.getDescription());
            ps.setString(7, movie.getPegi());
            ps.setInt(8, movie.getId()); // Assuming ID is the primary key for the movies table

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated == 0) {
                throw new RuntimeException("Movie with ID " + movie.getId() + " not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating the movie with ID " + movie.getId(), e);
        }
    }

    public void deleteMovie(int movieId) {
        Connection con = ConnectionManager.getConnection();
        String SQLScript = "DELETE FROM movies WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(SQLScript);
            ps.setInt(1, movieId);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted == 0) {
                throw new RuntimeException("Movie with ID " + movieId + " not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting the movie with ID " + movieId, e);
        }
    }

    public Movie getMovieById(int movieId) {
        Connection con = ConnectionManager.getConnection();
        String SQLScript = "SELECT * FROM movies WHERE id=?";
        Movie movie = null;

        try {
            PreparedStatement ps = con.prepareStatement(SQLScript);
            ps.setInt(1, movieId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDuration(rs.getInt("duration"));
                movie.setDirector(rs.getString("director"));
                movie.setImage(rs.getString("image"));
                movie.setGenre(rs.getString("genre"));
                movie.setDescription(rs.getString("description"));
                movie.setPegi(rs.getString("pegi"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving movie with ID " + movieId, e);
        }

        return movie;
    }






public class ConnectionManager {

        private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
        private static final String USERNAME = "your_username";
        private static final String PASSWORD = "your_password";

        public static Connection getConnection() {
            try {
                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting to the database", e);
            }
        }
    }
}








