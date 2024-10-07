/*package systemPonto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ViewAdmin {

    private JFrame frame;  
  
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

    public ViewAdmin() {
        initialize();  
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.getContentPane().setLayout(null);  

        JLabel lblAdmin = new JLabel("Área do Administrador");  
        lblAdmin.setBounds(150, 30, 150, 25);  
        frame.getContentPane().add(lblAdmin); 

        JButton btnCadastrarUsuarios = new JButton("Cadastrar Usuários");  
        btnCadastrarUsuarios.setBounds(150, 80, 150, 25);
        btnCadastrarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewCadastroUsuarios cadastroUsuarios = new ViewCadastroUsuarios(); 
                cadastroUsuarios.mostrarTela();  
            }
        });
        frame.getContentPane().add(btnCadastrarUsuarios); 
        
        // TESTE PARA TELA ADMIN
        
        JButton btnVisualizarRegistros = new JButton("Visualizar Registros"); 
        btnVisualizarRegistros.setBounds(150, 120, 150, 25);  
        btnVisualizarRegistros.addActionListener(new ActionListener() {
           
        	public void actionPerformed(ActionEvent e) {
                // lógica para visualizar registros (ainda não implementada)
                JOptionPane.showMessageDialog(null, "test");  
            }
        });
        frame.getContentPane().add(btnVisualizarRegistros);  
    }

    public void mostrarTela() {
        frame.setVisible(true); 
    }
}
*/