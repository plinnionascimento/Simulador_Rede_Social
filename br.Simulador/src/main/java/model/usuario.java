package model;

	
	import java.sql.*;

import br.Simulador.User;

	public class usuario {
	    private int id;
	    private String name;
	    private String email;
	    private String password;

	    public void setId(int id) {
	        this.id = id;
	    }

	    public usuario(String name, String email, String password) {
	        this.name = name;
	        this.email = email;
	        this.password = password;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void save() {
	        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Plinio.Nascimento/Downloads/Simulador_rede_social");
	             PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (name, email, password) VALUES (?, ?, ?)")) {
	            statement.setString(1, name);
	            statement.setString(2, email);
	            statement.setString(3, password);

	            statement.executeUpdate();

	            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    id = generatedKeys.getInt(1);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void update() {
	        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Plinio.Nascimento/Downloads/Simulador_rede_social");
	             PreparedStatement statement = connection.prepareStatement("UPDATE Users SET name = ?, email = ?, password = ? WHERE id = ?")) {
	            statement.setString(1, name);
	            statement.setString(2, email);
	            statement.setString(3, password);
	            statement.setInt(4, id);

	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void delete() {
	        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Plinio.Nascimento/Downloads/Simulador_rede_social");
	             PreparedStatement statement = connection.prepareStatement("DELETE FROM Users WHERE id = ?")) {
	            statement.setInt(1, id);

	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void addAmigo(usuario amigo) {
	        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Plinio.Nascimento/Downloads/Simulador_rede_social");
	             PreparedStatement statement = connection.prepareStatement("INSERT INTO Friends (user_id, friend_id) VALUES (?, ?)")) {
	            statement.setInt(1, id);
	            User friend = null;
				statement.setInt(2, friend.getId());

	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void removeamigo(User amigo) {
	        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Plinio.Nascimento/Downloads/Simulador_rede_social");
	             PreparedStatement statement = connection.prepareStatement("DELETE FROM Friends WHERE user_id = ? AND friend_id = ?")) {
	            statement.setInt(1, id);
	            User friend = null;
				statement.setInt(2, friend.getId());

	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void sendMessagm(User receiver, String message) {
	        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Plinio.Nascimento/Downloads/Simulador_rede_social");
	             PreparedStatement statement = connection.prepareStatement("INSERT INTO Messages (sender_id, receiver_id, message) VALUES (?, ?, ?)")) {
	            statement.setInt(1, id);
	            statement.setInt(2, receiver.getId());
	            statement.setString(3, message);

	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



