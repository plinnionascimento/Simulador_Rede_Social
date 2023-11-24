package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.Simulador.Connect;

public class ViewPrimeiraTela extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldEmail;
    private JTextField textFieldPassword;

    public ViewPrimeiraTela(Connect connect) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelEmail = new JLabel("E-mail:");
        labelEmail.setBounds(20, 20, 70, 20);
        contentPane.add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(100, 20, 150, 20);
        contentPane.add(textFieldEmail);

        JLabel labelPassword = new JLabel("Senha:");
        labelPassword.setBounds(20, 50, 70, 20);
        contentPane.add(labelPassword);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(100, 50, 150, 20);
        contentPane.add(textFieldPassword);

        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(100, 80, 70, 20);
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            
            	String email = textFieldEmail.getText();
            	String password = textFieldPassword.getText();
            	
            	if (email.isEmpty() || password.isEmpty() ) {
            		JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
            		return;
            	}
            	else {
            		try {
            			boolean login = connect.login(email, password);
            			if(login == true) {
            				dispose();
            				ViewSegundaTela acesso = new ViewSegundaTela(connect);
                            acesso.setVisible(true);
            			}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
            	}
            }
        });
        contentPane.add(buttonLogin);

        JButton buttonRegister = new JButton("Register");
        buttonRegister.setBounds(180, 80, 70, 20);
        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	ViewCadastro telaCadastro = new ViewCadastro(connect);
            	telaCadastro.setVisible(true);
            }
            
       
        
        });
        contentPane.add(buttonRegister);

        getContentPane().setBackground(new Color(255, 255, 255)); 
        getContentPane().setFont(new Font("Arial", Font.BOLD, 14));
        getContentPane().setForeground(new Color(0, 0, 0)); 
        
           }
    
}

