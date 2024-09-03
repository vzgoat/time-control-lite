package systemPonto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ViewRegistroPontos {

    private JFrame frame;  // variável para armazenar a janela principal da interface gráfica
    private boolean isAdmin;  // variável para indicar se o usuário é administrador
    private JLabel lblHoraAtual;  // variável para o JLabel que mostrará a hora atual

    // ponto de entrada do programa
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewRegistroPontos window = new ViewRegistroPontos(false);  // cria uma nova instância com isAdmin como falso
                    window.frame.setVisible(true);  // torna a janela visível
                } catch (Exception e) {
                    e.printStackTrace();  // imprime a pilha de erros se ocorrer uma exceção
                }
            }
        });
    }

    // construtor que aceita um argumento booleano
    public ViewRegistroPontos(boolean isAdmin) {
        this.isAdmin = isAdmin;  // define o valor de isAdmin
        initialize();  // chama o método para configurar a interface gráfica
        iniciarAtualizacaoHora();  // chama o método para iniciar a atualização da hora
    }

    // inicializa a interface gráfica
    private void initialize() {
        frame = new JFrame();  // cria a janela principal
        frame.setBounds(100, 100, 800, 600);  // define a posição e o tamanho da janela (x, y, largura, altura)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // define que a janela será fechada ao clicar no botão de fechar
        frame.getContentPane().setLayout(null);  // define o layout como nulo, permitindo definir posições e tamanhos manualmente
        frame.setResizable(false);  // impede que a janela seja redimensionada
        frame.setLocationRelativeTo(null);  // centraliza a janela na tela
        
        // cria e configura o rótulo para mostrar a hora atual
        lblHoraAtual = new JLabel();
        lblHoraAtual.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
        lblHoraAtual.setBounds(10, 475, 400, 23);  // define a posição e o tamanho do rótulo
    	frame.getContentPane().add(lblHoraAtual);  // adiciona o rótulo à janela

        // cria e configura o rótulo da tela
        JLabel lblMensagem = new JLabel("Registre seu ponto");
        lblMensagem.setForeground(new Color(64, 128, 128));
        lblMensagem.setFont(new Font("JetBrains Mono", Font.BOLD, 35));
        lblMensagem.setBounds(196, 34, 384, 68);  // define a posição e o tamanho do rótulo
        frame.getContentPane().add(lblMensagem);  // adiciona o rótulo à janela

        // cria e configura o botão para registrar chegada
        JButton btnRegistrarChegada = new JButton("Registrar Chegada");
        btnRegistrarChegada.setBounds(291, 113, 200, 40);  // define a posição e o tamanho do botão
        frame.getContentPane().add(btnRegistrarChegada);  // adiciona o botão à janela

        // cria e configura o botão para registrar pausa
        JButton btnRegistrarPausa = new JButton("Registrar Pausa");
        btnRegistrarPausa.setBounds(291, 173, 200, 40);  // define a posição e o tamanho do botão
        frame.getContentPane().add(btnRegistrarPausa);  // adiciona o botão à janela

        // cria e configura o botão para registrar saída
        JButton btnRegistrarSaida = new JButton("Registrar Saída");
        btnRegistrarSaida.setBounds(291, 233, 200, 40);  // define a posição e o tamanho do botão
        frame.getContentPane().add(btnRegistrarSaida);  // adiciona o botão à janela

        // cria e configura o botão para cadastrar usuários
        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        btnCadastrarUsuario.setBounds(632, 527, 142, 23);  // define a posição e o tamanho do botão
        btnCadastrarUsuario.setEnabled(isAdmin);  // ativa ou desativa o botão com base no valor de isAdmin
        frame.getContentPane().add(btnCadastrarUsuario);  // adiciona o botão à janela

        // cria e configura o botão de logout
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(10, 527, 74, 23);  // define a posição e o tamanho do botão
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // fecha a janela atual
                ViewHomeScreen loginScreen = new ViewHomeScreen(isAdmin);  // cria uma nova instância da tela de login
                loginScreen.getFrame().setVisible(true);  // torna a janela de login visível
            }
        });
        frame.getContentPane().add(btnLogout);  // adiciona o botão à janela
        
        // cria e configura o painel do rodapé
        JPanel panelFooter = new JPanel();
        panelFooter.setBackground(new Color(64, 128, 128));
        panelFooter.setForeground(new Color(64, 128, 128));
        panelFooter.setBounds(0, 509, 784, 52);
        frame.getContentPane().add(panelFooter);

        // adiciona ação ao botão de registrar chegada
        btnRegistrarChegada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LocalDateTime agora = LocalDateTime.now();  // obtém a data e hora atual
                String dataHoraFormatada = formatarDataHora(agora);  // formata a data e hora
                JOptionPane.showMessageDialog(null, "Chegada registrada: " + dataHoraFormatada);  // exibe uma mensagem de sucesso
            }
        });

        // adiciona ação ao botão de registrar pausa
        btnRegistrarPausa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LocalDateTime agora = LocalDateTime.now();  // obtém a data e hora atual
                String dataHoraFormatada = formatarDataHora(agora);  // formata a data e hora
                JOptionPane.showMessageDialog(null, "Pausa registrada: " + dataHoraFormatada);  // exibe uma mensagem de sucesso
            }
        });

        // adiciona ação ao botão de registrar saída
        btnRegistrarSaida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LocalDateTime agora = LocalDateTime.now();  // obtém a data e hora atual
                String dataHoraFormatada = formatarDataHora(agora);  // formata a data e hora
                JOptionPane.showMessageDialog(null, "Saída registrada: " + dataHoraFormatada);  // exibe uma mensagem de sucesso
            }
        });

        // adiciona ação ao botão de cadastrar usuário
        btnCadastrarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewCadastroUsuarios cadastroUsuario = new ViewCadastroUsuarios();  // cria uma nova instância da tela de cadastro de usuários
                cadastroUsuario.mostrarTela();  // torna a tela de cadastro de usuários visível
            }
        });
    }

    // método para iniciar a atualização da hora
    private void iniciarAtualizacaoHora() {
        Timer timer = new Timer(1000, new ActionListener() {  // cria um Timer que dispara a cada segundo
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime agora = LocalDateTime.now();  // obtém a data e hora atual
                String horaFormatada = formatarDataHora(agora);  // formata a data e hora
                lblHoraAtual.setText(horaFormatada);  // atualiza o JLabel com a hora formatada
            }
        });
        timer.start();  // inicia o Timer
    }

    // método para formatar a data e hora
    private String formatarDataHora(LocalDateTime dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  // define o formato da data e hora
        return dataHora.format(formatter);  // formata e retorna a data e hora
    }

    // método para mostrar a tela
    public void mostrarTela() {
        frame.setVisible(true);  // torna a janela visível
    }
}
