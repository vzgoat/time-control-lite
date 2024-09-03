package systemPonto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ViewAdmin {

    private JFrame frame;  // variável para armazenar a janela principal da interface gráfica

    // método pra inicializar a tela do admin
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewAdmin window = new ViewAdmin();  // cria uma nova instância da classe ViewAdmin
                    window.frame.setVisible(true);  // torna a janela visível
                } catch (Exception e) {
                    e.printStackTrace();  // imprime a pilha de erros se ocorrer uma exceção
                }
            }
        });
    }

    // inicializa a interface gráfica
    public ViewAdmin() {
        initialize();  // chama o método para configurar a interface gráfica
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);  // define a posição e o tamanho da janela (x, y, largura, altura)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // define que a janela será fechada ao clicar no botão de fechar
        frame.getContentPane().setLayout(null);  // define o layout como nulo, permitindo definir posições e tamanhos manualmente

        JLabel lblAdmin = new JLabel("Área do Administrador");  // cria um rótulo de texto
        lblAdmin.setBounds(150, 30, 150, 25);  // define a posição e o tamanho do rótulo (x, y, largura, altura)
        frame.getContentPane().add(lblAdmin);  // adiciona o rótulo à janela

        JButton btnCadastrarUsuarios = new JButton("Cadastrar Usuários");  // cria um botão para cadastrar usuários
        btnCadastrarUsuarios.setBounds(150, 80, 150, 25);  // define a posição e o tamanho do botão (x, y, largura, altura)
        btnCadastrarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewCadastroUsuarios cadastroUsuarios = new ViewCadastroUsuarios();  // cria uma nova tela para cadastro de usuários
                cadastroUsuarios.mostrarTela();  // chama o método para mostrar a tela de cadastro
            }
        });
        frame.getContentPane().add(btnCadastrarUsuarios);  // adiciona o botão à janela

        JButton btnVisualizarRegistros = new JButton("Visualizar Registros");  // cria um botão para visualizar registros
        btnVisualizarRegistros.setBounds(150, 120, 150, 25);  // define a posição e o tamanho do botão (x, y, largura, altura)
        btnVisualizarRegistros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // lógica para visualizar registros (ainda não implementada)
                JOptionPane.showMessageDialog(null, "test");  // exibe uma caixa de mensagem com o texto "test"
            }
        });
        frame.getContentPane().add(btnVisualizarRegistros);  // adiciona o botão à janela
    }

    // método para mostrar a tela de admin
    public void mostrarTela() {
        frame.setVisible(true);  // torna a janela visível
    }
}
