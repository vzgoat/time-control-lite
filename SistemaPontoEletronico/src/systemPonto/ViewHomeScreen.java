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

    private JFrame frame;  
    private JTextField txtLogin;  
    private JPasswordField txtPassword;  
    private boolean isAdmin;   

     
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewHomeScreen window = new ViewHomeScreen(false);   
                    window.frame.setVisible(true);   
                } catch (Exception e) {
                    e.printStackTrace();  // imprime a pilha de erros se ocorrer uma exceção
                }
            }
        });
    }

    // construtor que aceita um argumento booleano
    public ViewHomeScreen(boolean isAdmin) {
        this.isAdmin = isAdmin;   
        initialize();   
    }

    // inicializa a interface gráfica
    private void initialize() {
        frame = new JFrame();   
        frame.setBounds(100, 100, 800, 600);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.getContentPane().setLayout(null);   
        frame.setResizable(false);   
        frame.setLocationRelativeTo(null);   
        
        // configurando o rótulo da tela
        JLabel lblLOGIN = new JLabel("LOGIN");
        lblLOGIN.setForeground(new Color(64, 128, 128));
        lblLOGIN.setFont(new Font("JetBrains Mono", Font.BOLD, 35));
        lblLOGIN.setHorizontalAlignment(SwingConstants.CENTER);
        lblLOGIN.setBackground(new Color(64, 128, 128));
        lblLOGIN.setBounds(498, 23, 164, 134);
        frame.getContentPane().add(lblLOGIN);

        JLabel lblLogin = new JLabel("Login");   
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setBounds(427, 211, 45, 30);   
        frame.getContentPane().add(lblLogin);   

        txtLogin = new JTextField();   
        txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
        txtLogin.setBounds(427, 252, 300, 40);   
        frame.getContentPane().add(txtLogin);   
        txtLogin.setColumns(10);   

        JLabel lblPassword = new JLabel("Senha");   
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setBounds(427, 311, 45, 30);   
        frame.getContentPane().add(lblPassword);   

        txtPassword = new JPasswordField();   
        txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
        txtPassword.setBounds(427, 352, 300, 40);   
        frame.getContentPane().add(txtPassword);   

        
        JButton btnEntrar = new JButton("Entrar");   
        btnEntrar.setBounds(477, 421, 200, 40);   
        
        btnEntrar.addActionListener(new ActionListener() {
            
        // actionPermofed btnENTRAR
        	
        	public void actionPerformed(ActionEvent e) {
            
        		// verificador de login e senha 
                if (checkLogin(txtLogin.getText(), new String(txtPassword.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Bem-Vindo ao Sistema!");   
                    frame.dispose();   
                    ViewRegistroPontos registroPontos = new ViewRegistroPontos(isAdmin);   
                    registroPontos.mostrarTela();  // torna a tela de registro de pontos visível
      
                } else if (checkAdmin(txtLogin.getText(), new String(txtPassword.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Bem-Vindo Administrador!");  //  
                    frame.dispose();   
                    ViewRegistroPontos registroPontos = new ViewRegistroPontos(true);   
                    registroPontos.mostrarTela();   
                
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou Senha incorretos", "Erro", JOptionPane.WARNING_MESSAGE);  // exibe uma mensagem de erro
                }
            }

            /* ------- usuários teste ------- */
           
        	public boolean checkLogin(String login, String senha) {
                return login.equals("usuario") && senha.equals("123");  // verifica se o login e senha são válidos para usuários comuns
            }

          
            public boolean checkAdmin(String login, String senha) {
                return login.equals("admin") && senha.equals("8956");  // verifica se o login e senha são válidos para administradores
            }
        });
        
        frame.getContentPane().add(btnEntrar);  
        /*-------------------------------------------------------------------------------------------------------*/        

        // Determinando actionListener e actionPerformed
        JButton btnLogout = new JButton("Logout");   
        btnLogout.setBounds(10, 510, 100, 40);   
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();   
                ViewHomeScreen loginScreen = new ViewHomeScreen(isAdmin);   
                loginScreen.getFrame().setVisible(true);   
            }
        });
        frame.getContentPane().add(btnLogout);   
        
        JPanel panelBorda = new JPanel();
        panelBorda.setBackground(new Color(64, 128, 128));
        panelBorda.setBounds(-2, -4, 396, 560);
        frame.getContentPane().add(panelBorda);
        
        JPanel panelTelaLogin = new JPanel();
        panelTelaLogin.setBounds(394, -4, 390, 565);
        frame.getContentPane().add(panelTelaLogin);
    }

    
    public JFrame getFrame() {
        return frame; 
    }
}

