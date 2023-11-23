package view;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import br.Simulador.Connect;

public class EnviarMensagem extends JFrame {

    private JPanel contentPane;
    private JTable tableFriends;
    private JTextArea textAreaMensagem;
	protected AbstractButton textAreaEmail;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EnviarMensagem frame = new EnviarMensagem();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EnviarMensagem(Connect connect) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Table to display friends
        tableFriends = new JTable();
        tableFriends.setBounds(20, 20, 400, 200);
        contentPane.add(tableFriends);

        // Text area to enter the message
        textAreaMensagem = new JTextArea();
        textAreaMensagem.setBounds(20, 240, 400, 40);
        contentPane.add(textAreaMensagem);

        // Button to send the message
        JButton buttonEnviar = new JButton("Enviar");
        buttonEnviar.setBounds(20, 280, 100, 20);
        buttonEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected friend
                int selectedRow = tableFriends.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(EnviarMensagem.this, "Selecione um amigo para enviar a mensagem.");
                    return;
                }

                // Get the friend's email address
                String email = (String) tableFriends.getValueAt(selectedRow, 1);

                // Send the message
                try {
                    Connect connect = new Connect();
                    String sql = "INSERT INTO mensagens (remetente_email, destinatario_email, mensagem) VALUES (?, ?, ?)";
                    PreparedStatement statement = ((Object) connect.getConnection()).prepareStatement(sql);
                    statement.setString(1, ((Object) connect.getUsuarioLogado()).getEmail());
                    statement.setString(2, email);
                    statement.setString(3, textAreaMensagem.getText());
                    statement.execute();

                    // Display a confirmation message
                    JOptionPane.showMessageDialog(EnviarMensagem.this, "Mensagem enviada com sucesso.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        contentPane.add(buttonEnviar);
        
     // Button to view friend list
        JButton buttonViewFriends = new JButton("Ver lista de amigos");
        buttonViewFriends.setBounds(20, 240, 150, 20);
        buttonViewFriends.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement code to display the list of friends
                // ...
            }
        });
        contentPane.add(buttonViewFriends);

        
     // Add a button to the table to select a friend
        JButton buttonSelectFriend = new JButton("Selecionar");
        buttonSelectFriend.setBounds(100, 20, 80, 20);
        buttonSelectFriend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected row
                int selectedRow = tableFriends.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(EnviarMensagem.this, "Selecione um amigo para enviar a mensagem.");
                    return;
                }

                // Get the friend's email address
                String email = (String) tableFriends.getValueAt(selectedRow, 1);

                // Set the email address of the selected friend
                textAreaEmail.setText(email);
            }
        });
        tableFriends.add(buttonSelectFriend);

    }
}
