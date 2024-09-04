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

    private JFrame frame;  
    private boolean isAdmin;  
    private JLabel lblHoraAtual; 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewRegistroPontos window = new ViewRegistroPontos(false);  
                    window.frame.setVisible(true);  
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public ViewRegistroPontos(boolean isAdmin) {
        this.isAdmin = isAdmin;  
        initialize();  
        iniciarAtualizacaoHora();
    }

    private void initialize() {
        frame = new JFrame(); 
        frame.setBounds(100, 100, 800, 600);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.getContentPane().setLayout(null);  
        frame.setResizable(false);  
        frame.setLocationRelativeTo(null);  
        
        // cria e configura para mostrar a hora atual
        lblHoraAtual = new JLabel();
        lblHoraAtual.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
        lblHoraAtual.setBounds(10, 475, 400, 23); 
    	frame.getContentPane().add(lblHoraAtual);  

        // cria e configura o rótulo da tela
        JLabel lblMensagem = new JLabel("Registre seu ponto");
        lblMensagem.setForeground(new Color(64, 128, 128));
        lblMensagem.setFont(new Font("JetBrains Mono", Font.BOLD, 35));
        lblMensagem.setBounds(196, 34, 384, 68);  
        frame.getContentPane().add(lblMensagem);  
        
        // cria e configura o botão para registrar chegada
        JButton btnRegistrarChegada = new JButton("Registrar Chegada");
        btnRegistrarChegada.setBounds(291, 113, 200, 40);  
        frame.getContentPane().add(btnRegistrarChegada);  

        // cria e configura o botão para registrar pausa
        JButton btnRegistrarPausa = new JButton("Registrar Pausa");
        btnRegistrarPausa.setBounds(291, 173, 200, 40);  
        frame.getContentPane().add(btnRegistrarPausa); 

        // cria e configura o botão para registrar saída
        JButton btnRegistrarSaida = new JButton("Registrar Saída");
        btnRegistrarSaida.setBounds(291, 233, 200, 40);  
        frame.getContentPane().add(btnRegistrarSaida);  
        
        // configura o botão para cadastrar usuários
        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        btnCadastrarUsuario.setBounds(632, 527, 142, 23);  
        btnCadastrarUsuario.setEnabled(isAdmin);  // ativa ou desativa o botão com base no valor de isAdmin
        frame.getContentPane().add(btnCadastrarUsuario);  

        // cria e configura o botão de logout
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(10, 527, 74, 23);  
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  
                ViewHomeScreen loginScreen = new ViewHomeScreen(isAdmin);  
                loginScreen.getFrame().setVisible(true);  
            }
        });
        frame.getContentPane().add(btnLogout);  
        
        // configura o footer
        JPanel panelFooter = new JPanel();
        panelFooter.setBackground(new Color(64, 128, 128));
        panelFooter.setForeground(new Color(64, 128, 128));
        panelFooter.setBounds(0, 509, 784, 52);
        frame.getContentPane().add(panelFooter);

        // actionListener botão de registrar chegada
        btnRegistrarChegada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LocalDateTime agora = LocalDateTime.now();  // obtém a data e hora atual
                String dataHoraFormatada = formatarDataHora(agora);  // formata a data e hora
                JOptionPane.showMessageDialog(null, "Chegada registrada: " + dataHoraFormatada);  // exibe uma mensagem de sucesso
            }
        });

        // actionListener botão de registrar pausa
        btnRegistrarPausa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LocalDateTime agora = LocalDateTime.now();  // obtém a data e hora atual
                String dataHoraFormatada = formatarDataHora(agora);  // formata a data e hora
                JOptionPane.showMessageDialog(null, "Pausa registrada: " + dataHoraFormatada);  // exibe uma mensagem de sucesso
            }
        });

        // actionListener botão de registrar saída
        btnRegistrarSaida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LocalDateTime agora = LocalDateTime.now();  // obtém a data e hora atual
                String dataHoraFormatada = formatarDataHora(agora);  // formata a data e hora
                JOptionPane.showMessageDialog(null, "Saída registrada: " + dataHoraFormatada);  // exibe uma mensagem de sucesso
            }
        });

        // actionListener botão de cadastrar usuário
        btnCadastrarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewCadastroUsuarios cadastroUsuario = new ViewCadastroUsuarios();  // cria uma nova instância da tela de cadastro de usuários
                cadastroUsuario.mostrarTela();  // torna a tela de cadastro de usuários visível
            }
        });
    }

    // método para iniciar a atualização da hora
    private void iniciarAtualizacaoHora() {
        Timer timer = new Timer(1000, new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime agora = LocalDateTime.now();  // obtém a data e hora atual do PC
                String horaFormatada = formatarDataHora(agora);  // formata a data e hora
                lblHoraAtual.setText(horaFormatada);  // atualiza o JLabel com a hora formatada
            }
        });
        timer.start();  // inicio do relógio
    }

    // método formatação da data e hora
    private String formatarDataHora(LocalDateTime dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        return dataHora.format(formatter);  // formata e retorna a data e hora
    }

    public void mostrarTela() {
        frame.setVisible(true);  
    }
}