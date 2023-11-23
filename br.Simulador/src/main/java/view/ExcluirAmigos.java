package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.Simulador.Connect;

public class ExcluirAmigos extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldFriendEmail;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ExcluirAmigos frame = new ExcluirAmigos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ExcluirAmigos(Connect connect) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Friend's email label and text field
        JLabel labelFriendEmail = new JLabel("Amigo para excluir:");
        labelFriendEmail.setBounds(20, 20, 100, 20);
        contentPane.add(labelFriendEmail);

        textFieldFriendEmail = new JTextField();
        textFieldFriendEmail.setBounds(130, 20, 150, 20);
        contentPane.add(textFieldFriendEmail);


        JButton buttonSearch = new JButton("Buscar");
        buttonSearch.setBounds(290, 20, 70, 20);
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
                        // Display confirmation before removing the friend
                        int confirm = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir o amigo " + friendName + "?", "Excluir amigo", JOptionPane.YES_NO_OPTION);

                        if (confirm == JOptionPane.YES_OPTION) {
                            // Implement code to remove the friend from the database
                            // Display a message upon successful removal of the friend
                            JOptionPane.showMessageDialog(null, "Amigo removido com sucesso!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        contentPane.add(buttonSearch);
    }
}

