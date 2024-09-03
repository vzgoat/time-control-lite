package systemPonto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;

public class ViewCadastroUsuarios {

    private JFrame frame;  // variável para armazenar a janela principal da interface gráfica
    private JTextField txtNome;  // campo de texto para o nome
    private JTextField txtFuncao;  // campo de texto para a função
    private JTextField txtId;  // campo de texto para o ID
    private JTextField txtSenha;  // campo de texto para a senha

    // método pra inicializar a tela de cadastro de usuários
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewCadastroUsuarios window = new ViewCadastroUsuarios();  // cria uma nova instância da classe ViewCadastroUsuarios
                    window.frame.setVisible(true);  // torna a janela visível
                } catch (Exception e) {
                    e.printStackTrace();  // imprime a pilha de erros se ocorrer uma exceção
                }
            }
        });
    }

    // inicializa a interface gráfica
    public ViewCadastroUsuarios() {
        initialize();  // chama o método para configurar a interface gráfica
    }

    private void initialize() {
        frame = new JFrame();  // cria a janela principal
        frame.setBounds(100, 100, 800, 600);  // define a posição e o tamanho da janela (x, y, largura, altura)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // define que a janela será fechada ao clicar no botão de fechar
        frame.getContentPane().setLayout(null);  // define o layout como nulo, permitindo definir posições e tamanhos manualmente
        frame.setResizable(false);  // impede que a janela seja redimensionada
        frame.setLocationRelativeTo(null);  // centraliza a janela na tela

        JLabel lblNome = new JLabel("Nome:");  // cria um rótulo de texto para o nome
        lblNome.setHorizontalAlignment(SwingConstants.CENTER);
        lblNome.setBounds(218, 180, 100, 30);  // define a posição e o tamanho do rótulo (x, y, largura, altura)
        frame.getContentPane().add(lblNome);  // adiciona o rótulo à janela

        txtNome = new JTextField();  // cria um campo de texto para o nome
        txtNome.setHorizontalAlignment(SwingConstants.CENTER);
        txtNome.setBounds(302, 180, 300, 30);  // define a posição e o tamanho do campo de texto (x, y, largura, altura)
        frame.getContentPane().add(txtNome);  // adiciona o campo de texto à janela

        JLabel lblFilial = new JLabel("Filial:");  // cria um rótulo de texto para a função
        lblFilial.setHorizontalAlignment(SwingConstants.CENTER);
        lblFilial.setBounds(218, 221, 100, 30);  // define a posição e o tamanho do rótulo
        frame.getContentPane().add(lblFilial);  // adiciona o rótulo à janela

        txtFuncao = new JTextField();  // cria um campo de texto para a função
        txtFuncao.setHorizontalAlignment(SwingConstants.CENTER);
        txtFuncao.setBounds(302, 221, 300, 30);  // define a posição e o tamanho do campo de texto
        frame.getContentPane().add(txtFuncao);  // adiciona o campo de texto à janela

        JLabel lblId = new JLabel("ID:");  // cria um rótulo de texto para o ID
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setBounds(218, 262, 100, 30);  // define a posição e o tamanho do rótulo
        frame.getContentPane().add(lblId);  // adiciona o rótulo à janela

        txtId = new JTextField();  // cria um campo de texto para o ID
        txtId.setHorizontalAlignment(SwingConstants.CENTER);
        txtId.setBounds(302, 262, 300, 30);  // define a posição e o tamanho do campo de texto
        frame.getContentPane().add(txtId);  // adiciona o campo de texto à janela

        JLabel lblSenha = new JLabel("Senha:");  // cria um rótulo de texto para a senha
        lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
        lblSenha.setBounds(218, 313, 100, 30);  // define a posição e o tamanho do rótulo
        frame.getContentPane().add(lblSenha);  // adiciona o rótulo à janela

        txtSenha = new JTextField();  // cria um campo de texto para a senha
        txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
        txtSenha.setBounds(302, 313, 300, 30);  // define a posição e o tamanho do campo de texto
        frame.getContentPane().add(txtSenha);  // adiciona o campo de texto à janela

        JButton btnCadastrar = new JButton("Cadastrar");  // cria um botão para cadastrar o usuário
        btnCadastrar.setBounds(624, 520, 150, 30);  // define a posição e o tamanho do botão
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");  // exibe uma mensagem de sucesso
                // aqui você adicionaria o código para cadastrar o usuário
            }
        });
        frame.getContentPane().add(btnCadastrar);  // adiciona o botão à janela

        JButton btnLogout = new JButton("Logout");  // cria um botão para fazer logout
        btnLogout.setBounds(10, 520, 100, 30);  // define a posição e o tamanho do botão
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // fecha a janela atual
                ViewHomeScreen loginScreen = new ViewHomeScreen(false);  // cria uma nova instância da tela de login
                loginScreen.getFrame().setVisible(true);  // torna a janela de login visível
            }
        });
        frame.getContentPane().add(btnLogout);  // adiciona o botão à janela
        
        JLabel lblNovoCadastro = new JLabel("Cadastro de Usuário");
        lblNovoCadastro.setForeground(new Color(64, 128, 128));
        lblNovoCadastro.setFont(new Font("JetBrains Mono", Font.BOLD, 35));
        lblNovoCadastro.setHorizontalAlignment(SwingConstants.CENTER);
        lblNovoCadastro.setBounds(162, 76, 497, 30);
        frame.getContentPane().add(lblNovoCadastro);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 128));
        panel.setBounds(0, 506, 784, 55);
        frame.getContentPane().add(panel);
    }

    // método para mostrar a tela de cadastro de usuários
    public void mostrarTela() {
        frame.setVisible(true);  // torna a janela visível
    }
}
