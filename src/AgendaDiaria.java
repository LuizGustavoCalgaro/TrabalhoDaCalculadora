import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AgendaDiaria {
    private JTextField txtEntradaCompromisso;
    private JSpinner spnDataeHora;
    private JButton btnAdicionarCompromisso;
    private JTable tblCompromissos;
    private JButton btnRemoverCompromisso;
    private DefaultTableModel modeloTabela;
    private JPanel panelMain;

    // Corrigir para ser um construtor da classe
    public AgendaDiaria() {
        // Inicialização dos componentes
        panelMain = new JPanel(); // Inicializa o painel principal

        // Inicializa o campo de data/hora
        spnDataeHora = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spnDataeHora, "dd/MM/yyyy HH:mm");
        spnDataeHora.setEditor(dateEditor);

        // Inicializa a tabela
        String[] colunas = {"Data/Hora", "Descrição"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tblCompromissos = new JTable(modeloTabela);

        // Inicializa os campos de texto e botão
        txtEntradaCompromisso = new JTextField();
        btnAdicionarCompromisso = new JButton("Adicionar Compromisso");
        btnRemoverCompromisso = new JButton("Remover Compromisso");

        // Adiciona os componentes ao painel principal (panelMain)
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(new JScrollPane(tblCompromissos));
        panelMain.add(txtEntradaCompromisso);
        panelMain.add(spnDataeHora);
        panelMain.add(btnAdicionarCompromisso);
        panelMain.add(btnRemoverCompromisso);

        // Ação do botão "Adicionar Compromisso"
        btnAdicionarCompromisso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String compromisso = txtEntradaCompromisso.getText();
                Date dataHora = (Date) spnDataeHora.getValue();
                if (compromisso.isEmpty()) {
                    JOptionPane.showMessageDialog(panelMain, "Por favor, insira um compromisso.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                modeloTabela.addRow(new Object[]{dataHora, compromisso});
                txtEntradaCompromisso.setText(""); // Corrigido: limpa o campo de texto
            }
        });

        // Ação do botão "Remover Compromisso"
        btnRemoverCompromisso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tblCompromissos.getSelectedRow();
                if (linhaSelecionada == -1) {
                    JOptionPane.showMessageDialog(panelMain, "Por favor, selecione um compromisso para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                modeloTabela.removeRow(linhaSelecionada);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diária");
        AgendaDiaria agenda = new AgendaDiaria();
        frame.setContentPane(agenda.panelMain); // Atribui o painel principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
