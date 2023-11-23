package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.Simulador.Connect;
import model.amigos;

public class ViewSegundaTela extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu userMenu;
    private JMenuItem addFriendMenuItem;
    private JMenuItem deleteFriendMenuItem;
    private JMenuItem sendMessageMenuItem;
    private JMenuItem checkAddedFriendsMenuItem;

    public ViewSegundaTela(Connect connect) {
        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        menuBar = new JMenuBar();

        userMenu = new JMenu("Usuário");
        menuBar.add(userMenu);

        addFriendMenuItem = new JMenuItem("Adicionar amigo");
        addFriendMenuItem.addActionListener(this); // Add action listener
        userMenu.add(addFriendMenuItem);

        deleteFriendMenuItem = new JMenuItem("Excluir amigo");
        deleteFriendMenuItem.addActionListener(this); // Add action listener
        userMenu.add(deleteFriendMenuItem);

        sendMessageMenuItem = new JMenuItem("Enviar mensagem");
        sendMessageMenuItem.addActionListener(this); // Add action listener
        userMenu.add(sendMessageMenuItem);

        checkAddedFriendsMenuItem = new JMenuItem("Verificar amigos adicionados");
        checkAddedFriendsMenuItem.addActionListener(this); // Add action listener
        userMenu.add(checkAddedFriendsMenuItem);

        setJMenuBar(menuBar);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFriendMenuItem) {
            Connect connect = null;
			AdicionarAmigos telaAdicionarAmigo = new AdicionarAmigos(connect);
            telaAdicionarAmigo.setVisible(true);
        } else if (e.getSource() == deleteFriendMenuItem) {
            JOptionPane.showMessageDialog(null, "Excluir amigo ainda não implementado.");
        } else if (e.getSource() == sendMessageMenuItem) {
            JOptionPane.showMessageDialog(null, "Enviar mensagem ainda não implementado.");
        } else if (e.getSource() == checkAddedFriendsMenuItem) {
            JOptionPane.showMessageDialog(null, "Verificar amigos adicionados ainda não implementado.");
        }
    }

    public static void main(String[] args) {
        new ViewSegundaTela(null);
    }
    
    public void actionPerformed1(ActionEvent e) {
        if (e.getSource() == addFriendMenuItem) {
       
            String username = JOptionPane.showInputDialog("Digite o nome de usuário do amigo:");

          
          amigos.add(username);

      
            JOptionPane.showMessageDialog(this, "Amigo adicionado com sucesso!");
        }
    }

}
