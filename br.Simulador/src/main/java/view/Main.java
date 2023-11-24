package view;

import br.Simulador.Connect;

import java.awt.EventQueue;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		Connect connect = new Connect();
        System.out.println("oi");
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewPrimeiraTela frame = new ViewPrimeiraTela(connect);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
		
	}
	
}
