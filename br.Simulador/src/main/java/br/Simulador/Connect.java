package br.Simulador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.amigos;


public class Connect  { 
	public Connection conn;

	public Connect() {
        try {
          
        	String url = "jdbc:sqlite:C:/Users/Plinio.Nascimento/Documents/JAVA/Simulador_Rede_Social/Simulador_rede_social";
        
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        
        }
    }
    public void conectar () throws SQLException { 
		 Statement statement = conn.createStatement();
		 ResultSet rs = statement.executeQuery("SELECT * FROM usuarios");
		 
		 while(rs.next()) {
		    // Ler os dados inseridos
			System.out.println("NOME DO CARA  : " + rs.getString("nome"));
			System.out.println("IDENTIFICAÇÃO : " + rs.getString("email"));
		  }
    	
    }
    
    public void cadastro (String nome, String email,String senha) throws SQLException {
    	String query = "INSERT INTO usuarios (nome, email, senha) VALUES ('"+ nome + "', '"+email+"','"+senha+"');";
    	Statement statement = conn.createStatement();
    	//statement.execute("INSERT INTO usuarios (nome, email, senha) VALUES ('João da Silva', 'joao.silva@email.com', '123456');");
    	statement.execute(query);
    	
    }
    
    public boolean login(String email, String senha) throws SQLException {
    	String query = "SELECT * FROM usuarios WHERE email = '"+email+"';";
    	Statement statement = conn.createStatement();
    	ResultSet rs = statement.executeQuery(query);
    	
    	if (senha.equals(rs.getString("senha"))){
    		return true;
    		
    	}
    	else {
    		return false;
    		
    	}
    }
	/**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        connect();
//    }
	public Object getUsuarioLogado() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	public void ExcluirAmigos(String emailAmigo) {
		// TODO Auto-generated method stub
		
	}
	public void enviarMensagem(String emailDestinatario, String mensagem) {
		// TODO Auto-generated method stub
		
	}
	public List<amigos> getAmigosAdicionados() {
		// TODO Auto-generated method stub
		return null;
	}
}
