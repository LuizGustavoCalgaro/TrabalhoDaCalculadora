import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDeContatos {
    private JPanel panelMain;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JButton btnAdicionarContato;
    private JLabel txtExibirContato;
    private JButton btnRemoverContato;
    private String nome1;
    private String nome2;
    private JList<String> listaContatos;
    private DefaultListModel<String> listaModel;

    public CadastroDeContatos () {
        listaModel = new DefaultListModel<>();
        inicializarComponentes();

        btnAdicionarContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAdicionarContato();
            }
        });
        btnRemoverContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removercontato();
            }
        });
    }
    private void inicializarComponentes() {
        panelMain = new JPanel(new BorderLayout());


        JPanel painelsuperior = new JPanel(new GridLayout(4, 2, 5 , 5));
        painelsuperior.setBorder(BorderFactory.createTitledBorder( "Cadastro de contatos"));

        painelsuperior.add(new JLabel("Nome:"));
        txtNome = new JTextField(15);
        painelsuperior.add(txtNome);

        painelsuperior.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField(15);

        painelsuperior.add(txtTelefone);

        painelsuperior.add(new JLabel("E-mail"));
        txtEmail = new JTextField(15);

        painelsuperior.add(txtEmail);


        btnAdicionarContato= new JButton("Adicionar Contatos");
        painelsuperior.add(btnAdicionarContato);

        btnRemoverContato = new JButton("Remover Contato");
        painelsuperior.add(btnRemoverContato);

        panelMain.add(painelsuperior , BorderLayout.NORTH);

        //Aqui eu crio um List usar esse como modelo
        listaContatos = new JList<>(listaModel);
        JScrollPane scrollPane= new JScrollPane(listaContatos);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Contatos"));
        panelMain.add(scrollPane , BorderLayout.CENTER);
    }
    private void btnAdicionarContato() {
        String nome = txtNome.getText().trim();
        String telefone = txtTelefone.getText().trim();
        String email = txtEmail.getText().trim();

        if (nome.isEmpty() ||telefone.isEmpty() || email.isEmpty()) {
            showMessage("Todos os campos devem ser preenchidos.");
            return;
        }

        String contato = String.format("Nome: %s | telefone: %s | E-mail: %s", nome , telefone , email);
        listaModel.addElement(contato);

        // seta como "" e limpa os campo ;
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
    }

    private void removercontato() {
        int indexSelecionado = listaContatos.getSelectedIndex();
        if (indexSelecionado == -1) {
            showMessage("Selecione um contato para remover.");
            return;
        }
        listaModel.remove(indexSelecionado);
    }
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(panelMain, message, "Atenção", JOptionPane.WARNING_MESSAGE);
    }
    public static void main (String[] args){
        JFrame frame = new JFrame("Cadastro de Contato");
        CadastroDeContatos cadastro = new CadastroDeContatos();
        frame.setContentPane(cadastro.panelMain);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);}}