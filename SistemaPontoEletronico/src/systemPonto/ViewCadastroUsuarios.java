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

    private JFrame frame; 
    private JTextField txtNome; 
    private JTextField txtFuncao;  
    private JTextField txtId;  
    private JTextField txtSenha;  

    
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

    public ViewCadastroUsuarios() {
        initialize();  
    }

    private void initialize() {
        frame = new JFrame(); 
        frame.setBounds(100, 100, 800, 600);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.getContentPane().setLayout(null);  
        frame.setResizable(false); 
        frame.setLocationRelativeTo(null); 

        JLabel lblNome = new JLabel("Nome:");  
        lblNome.setHorizontalAlignment(SwingConstants.CENTER);
        lblNome.setBounds(218, 180, 100, 30);  
        frame.getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setHorizontalAlignment(SwingConstants.CENTER);
        txtNome.setBounds(302, 180, 300, 30); 
        frame.getContentPane().add(txtNome);  

        JLabel lblFilial = new JLabel("Filial:");  
        lblFilial.setHorizontalAlignment(SwingConstants.CENTER);
        lblFilial.setBounds(218, 221, 100, 30); 
        frame.getContentPane().add(lblFilial);  

        txtFuncao = new JTextField();  
        txtFuncao.setHorizontalAlignment(SwingConstants.CENTER);
        txtFuncao.setBounds(302, 221, 300, 30);  
        frame.getContentPane().add(txtFuncao); 
        
        JLabel lblId = new JLabel("ID:"); 
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setBounds(218, 262, 100, 30);  
        frame.getContentPane().add(lblId);  

        txtId = new JTextField(); 
        txtId.setHorizontalAlignment(SwingConstants.CENTER);
        txtId.setBounds(302, 262, 300, 30);  
        frame.getContentPane().add(txtId);  

        JLabel lblSenha = new JLabel("Senha:");  
        lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
        lblSenha.setBounds(218, 313, 100, 30); 
        frame.getContentPane().add(lblSenha);  

        txtSenha = new JTextField();  
        txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
        txtSenha.setBounds(302, 313, 300, 30); 
        frame.getContentPane().add(txtSenha);  

        JButton btnCadastrar = new JButton("Cadastrar"); 
        btnCadastrar.setBounds(624, 520, 150, 30); 
        btnCadastrar.addActionListener(new ActionListener() {
          
        	// verificador de campos preenchidos
        	public void actionPerformed(ActionEvent e) {
            	
                if (txtNome.getText().isEmpty() || txtFuncao.getText().isEmpty() || txtId.getText().isEmpty() || txtSenha.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                   
                    frame.dispose();
                    // outras opções ->
                    
                    // redirecionar para outra tela
                    // ViewHomeScreen homeScreen = new ViewHomeScreen();
                    // homeScreen.getFrame().setVisible(true);
                }
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
        
        /*JButton btnVoltar = new JButton("Voltar");  // cria um botão para voltar à tela de registros
        btnVoltar.setBounds(120, 520, 100, 30);  // define a posição e o tamanho do botão
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();  // fecha a janela atual
                ViewRegistroPontos registroPontosScreen = new ViewRegistroPontos();  // cria uma nova instância da tela de registro de pontos
                registroPontosScreen.mostrarTela();  // torna a janela de registros visível
            }
        });
        frame.getContentPane().add(btnVoltar);  // adiciona o botão à janela
        */
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
