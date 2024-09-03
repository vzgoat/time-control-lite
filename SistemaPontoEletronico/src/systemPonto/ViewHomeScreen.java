package systemPonto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewHomeScreen {

    private JFrame frame;  // variável para armazenar a janela principal da interface gráfica
    private JTextField txtLogin;  // campo de texto para o login
    private JPasswordField txtPassword;  // campo de texto para a senha
    private boolean isAdmin;  // variável para indicar se o usuário é administrador

    // ponto de entrada do programa
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewHomeScreen window = new ViewHomeScreen(false);  // cria uma nova instância com isAdmin como falso
                    window.frame.setVisible(true);  // torna a janela visível
                } catch (Exception e) {
                    e.printStackTrace();  // imprime a pilha de erros se ocorrer uma exceção
                }
            }
        });
    }

    // construtor que aceita um argumento booleano
    public ViewHomeScreen(boolean isAdmin) {
        this.isAdmin = isAdmin;  // define o valor de isAdmin
        initialize();  // chama o método para configurar a interface gráfica
    }

    // inicializa a interface gráfica
    private void initialize() {
        frame = new JFrame();  // cria a janela principal
        frame.setBounds(100, 100, 800, 600);  // define a posição e o tamanho da janela (x, y, largura, altura)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // define que a janela será fechada ao clicar no botão de fechar
        frame.getContentPane().setLayout(null);  // define o layout como nulo, permitindo definir posições e tamanhos manualmente
        frame.setResizable(false);  // impede que a janela seja redimensionada
        frame.setLocationRelativeTo(null);  // centraliza a janela na tela
        
        JLabel lblLOGIN = new JLabel("LOGIN");
        lblLOGIN.setForeground(new Color(64, 128, 128));
        lblLOGIN.setFont(new Font("JetBrains Mono", Font.BOLD, 35));
        lblLOGIN.setHorizontalAlignment(SwingConstants.CENTER);
        lblLOGIN.setBackground(new Color(64, 128, 128));
        lblLOGIN.setBounds(498, 23, 164, 134);
        frame.getContentPane().add(lblLOGIN);

        JLabel lblLogin = new JLabel("Login");  // cria um rótulo de texto para o login
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setBounds(427, 211, 45, 30);  // define a posição e o tamanho do rótulo (x, y, largura, altura)
        frame.getContentPane().add(lblLogin);  // adiciona o rótulo à janela

        txtLogin = new JTextField();  // cria um campo de texto para o login
        txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
        txtLogin.setBounds(427, 252, 300, 40);  // define a posição e o tamanho do campo de texto (x, y, largura, altura)
        frame.getContentPane().add(txtLogin);  // adiciona o campo de texto à janela
        txtLogin.setColumns(10);  // define o número de colunas visíveis no campo de texto

        JLabel lblPassword = new JLabel("Senha");  // cria um rótulo de texto para a senha
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setBounds(427, 311, 45, 30);  // define a posição e o tamanho do rótulo
        frame.getContentPane().add(lblPassword);  // adiciona o rótulo à janela

        txtPassword = new JPasswordField();  // cria um campo de senha para ocultar os caracteres digitados
        txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
        txtPassword.setBounds(427, 352, 300, 40);  // define a posição e o tamanho do campo de senha (x, y, largura, altura)
        frame.getContentPane().add(txtPassword);  // adiciona o campo de senha à janela

        JButton btnEntrar = new JButton("Entrar");  // cria um botão para fazer login
        btnEntrar.setBounds(477, 421, 200, 40);  // define a posição e o tamanho do botão
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // verifica se o login e senha estão corretos
                if (checkLogin(txtLogin.getText(), new String(txtPassword.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Bem-Vindo ao Sistema!");  // exibe uma mensagem de sucesso
                    frame.dispose();  // fecha a janela atual
                    ViewRegistroPontos registroPontos = new ViewRegistroPontos(isAdmin);  // cria uma nova instância da tela de registro de pontos
                    registroPontos.mostrarTela();  // torna a tela de registro de pontos visível
                } else if (checkAdmin(txtLogin.getText(), new String(txtPassword.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Bem-Vindo Administrador!");  // exibe uma mensagem de sucesso para administradores
                    frame.dispose();  // fecha a janela atual
                    ViewCadastroUsuarios cadastroUsuarios = new ViewCadastroUsuarios();  // cria uma nova instância da tela de cadastro de usuários
                    cadastroUsuarios.mostrarTela();  // torna a tela de cadastro de usuários visível
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou Senha incorretos", "Erro", JOptionPane.WARNING_MESSAGE);  // exibe uma mensagem de erro
                }
            }

            // método para verificar login de usuário
            public boolean checkLogin(String login, String senha) {
                return login.equals("usuario") && senha.equals("123");  // verifica se o login e senha são válidos para usuários comuns
            }

            // método para verificar login de administrador
            public boolean checkAdmin(String login, String senha) {
                return login.equals("admin") && senha.equals("8956");  // verifica se o login e senha são válidos para administradores
            }
        });
        frame.getContentPane().add(btnEntrar);  // adiciona o botão à janela

        JButton btnLogout = new JButton("Logout");  // cria um botão para fazer logout
        btnLogout.setBounds(10, 510, 100, 40);  // define a posição e o tamanho do botão
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // fecha a janela atual
                ViewHomeScreen loginScreen = new ViewHomeScreen(isAdmin);  // cria uma nova instância da tela de login
                loginScreen.getFrame().setVisible(true);  // torna a janela de login visível
            }
        });
        frame.getContentPane().add(btnLogout);  // adiciona o botão à janela
        
        JPanel panelBorda = new JPanel();
        panelBorda.setBackground(new Color(64, 128, 128));
        panelBorda.setBounds(-2, -4, 396, 560);
        frame.getContentPane().add(panelBorda);
        
        JPanel panelTelaLogin = new JPanel();
        panelTelaLogin.setBounds(394, -4, 390, 565);
        frame.getContentPane().add(panelTelaLogin);
    }

    // método para obter a janela principal
    public JFrame getFrame() {
        return frame;  // retorna a janela principal
    }
}
