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

public class ViewCadastro extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JTextField textFieldName;
    private JTextField textFieldEmail;


    public ViewCadastro(Connect connect) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(20, 50, 70, 20);
        contentPane.add(labelPassword);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(100, 50, 150, 20);
        contentPane.add(textFieldPassword);

     
        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(20, 80, 70, 20);
        contentPane.add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(100, 80, 150, 20);
        contentPane.add(textFieldName);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(20, 110, 70, 20);
        contentPane.add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(100, 110, 150, 20);
        contentPane.add(textFieldEmail);

       
        JButton buttonRegister = new JButton("Register");
        buttonRegister.setBounds(100, 140, 70, 20);
        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          
                String name = textFieldName.getText();
                String email = textFieldEmail.getText();
                String password = textFieldPassword.getText();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
                    return;
                }
                else {
            		try {
						connect.cadastro(name, email, password);
						JOptionPane.showMessageDialog(null, "Registration successful!");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
                }
      
               
            }
        });
        
        contentPane.add(buttonRegister);

        getContentPane().setBackground(new Color(255, 255, 255)); 
        getContentPane().setFont(new Font("Arial", Font.BOLD, 14));
        getContentPane().setForeground(new Color(0, 0, 0)); 
        
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

            
