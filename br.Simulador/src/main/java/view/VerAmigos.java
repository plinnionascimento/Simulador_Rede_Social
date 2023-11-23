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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.Simulador.Connect;

public class VerAmigos extends JFrame {

    private JPanel contentPane;
    private JTable tableFriends;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VerAmigos frame = new VerAmigos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VerAmigos() {
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

        JButton buttonViewFriends = new JButton("Ver lista de amigos");
        buttonViewFriends.setBounds(20, 240, 150, 20);
        buttonViewFriends.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
            }
        });
        contentPane.add(buttonViewFriends);

        // Button to view friend requests
        JButton buttonViewFriendRequests = new JButton("Ver solicitação de amizade");
        buttonViewFriendRequests.setBounds(180, 240, 150, 20);
        buttonViewFriendRequests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement code to display the friend requests
                // ...
            }
        });
        contentPane.add(buttonViewFriendRequests);
    }
}
