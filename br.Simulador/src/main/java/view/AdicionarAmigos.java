package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.Simulador.Connect;

public class AdicionarAmigos extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldFriendEmail;
    private JTextField textFieldFriendName;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdicionarAmigos frame = new AdicionarAmigos(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdicionarAmigos(Connect connect) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        


        JLabel labelFriendEmail = new JLabel("Email de amigos:");
        labelFriendEmail.setBounds(20, 20, 70, 20);
        contentPane.add(labelFriendEmail);

        textFieldFriendEmail = new JTextField();
        textFieldFriendEmail.setBounds(100, 20, 150, 20);
        contentPane.add(textFieldFriendEmail);


        JButton buttonSearch = new JButton("Buscar");
        buttonSearch.setBounds(255, 20, 70, 20);
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String friendEmail = textFieldFriendEmail.getText();
            
                try {
                    Connect connect = new Connect();
                    String sql = "SELECT nome, email FROM usuarios WHERE email = ?";
                    PreparedStatement statement = ((Statement) connect).getConnection().prepareStatement(sql);
                    statement.setString(1, friendEmail);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        String friendName = resultSet.getString("nome");
                        textFieldFriendName.setText(friendName);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        contentPane.add(buttonSearch);

        JLabel labelFriendName = new JLabel("Nome do amigo:");
        labelFriendName.setBounds(20, 50, 70, 20);
        contentPane.add(labelFriendName);

        textFieldFriendName = new JTextField();
        textFieldFriendName.setBounds(100, 50, 150, 20);
        contentPane.add(textFieldFriendName);


        JButton buttonSendRequest = new JButton("Enviar pedido");
        buttonSendRequest.setBounds(255, 50, 70, 20);
        buttonSendRequest.addActionListener(new SendRequestListener()); 

        class SendRequestListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
 
                String friendEmail = textFieldFriendEmail.getText();
             
                JOptionPane.showMessageDialog(null, "Pedido de amizade enviado!");
            }
        }
        		
        		class MyButtonListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                
            }
        }
    
    
    JButton buttonVoltar = new JButton("Voltar");
    buttonVoltar.setBounds(180, 140, 70, 20);
    buttonVoltar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	dispose();
        	ViewPrimeiraTela login = new ViewPrimeiraTela(connect);
        	login.setVisible(true);
        }
        
   
    
    });
    contentPane.add(buttonVoltar);
}
}

