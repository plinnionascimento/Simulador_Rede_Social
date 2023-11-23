package br.Simulador;


	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	import model.usuario;


	public class Rede_social {
	    private static final String INSERT_USER_QUERY = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
	    private static final String SELECT_USER_QUERY = "SELECT * FROM users WHERE email = ? AND password = ?";
	    private static final String INSERT_FRIENDSHIP_QUERY = "INSERT INTO friendship (user_id, friend_id) VALUES (?, ?)";
	    private static final String SELECT_FRIENDS_QUERY = "SELECT u.* FROM users u " +
	            "INNER JOIN friendship f ON u.id = f.friend_id " +
	            "WHERE f.user_id = ? " +
	            "UNION " +
	            "SELECT u.* FROM users u " +
	            "INNER JOIN friendship f ON u.id = f.user_id " +
	            "WHERE f.friend_id = ?";
	    private static final String DELETE_FRIENDSHIP_QUERY = "DELETE FROM friendship WHERE user_id = ? AND friend_id = ?";
	    private static final String INSERT_MESSAGE_QUERY = "INSERT INTO messages (sender_id, receiver_id, message_text) VALUES (?, ?, ?)";
	    private static final String DELETE_MESSAGE_QUERY = "DELETE FROM messages WHERE receiver_id = ? AND id = ?";
	    private static final String SELECT_WHO_SENT_MESSAGE_QUERY = "SELECT u.name from users u INNER JOIN messages m ON u.id =  m.sender_id WHERE m.sender_id = ? AND m.receiver_id = ?";
	    private static final String SELECT_ALL_MESSAGES = "SELECT m.id as id_mensagem,m.message_text, m.receiver_id, m.sender_id, u.name as friend_name, u.id FROM messages m INNER JOIN users u ON u.id = m.receiver_id WHERE m.receiver_id = ?";

	    private Connection connection;

	    public Rede_social(Connection connection) {
	        this.connection = connection;
	    }

	    public void cadastrarUsuario(usuario user) {
	        try (PreparedStatement statement = connection.prepareStatement(INSERT_USER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
	            statement.setString(1, user.getName());
	            statement.setString(2, user.getEmail());
	            statement.setString(3, user.getPassword());
	            int affectedRows = statement.executeUpdate();
	            if (affectedRows > 0) {
	                try (ResultSet resultSet = statement.getGeneratedKeys()) {
	                    if (resultSet.next()) {
	                        int userId = resultSet.getInt(1);
	                        user.setId(userId);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
	        }
	    }

	    public User login(String email, String senha) {
	        try (PreparedStatement statement = connection.prepareStatement(SELECT_USER_QUERY)) {
	            statement.setString(1, email);
	            statement.setString(2, senha);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    int userId = resultSet.getInt("id");
	                    String nome = resultSet.getString("name");
	                    String userEmail = resultSet.getString("email");
	                    String userSenha = resultSet.getString("password");
	                    User user = new User(nome, userEmail, userSenha);
	                    user.setId(userId);
	                    return user;
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao fazer login: " + e.getMessage());
	        }
	        return null;
	    }

	 

}
