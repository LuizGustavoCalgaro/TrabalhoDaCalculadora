import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculadoraDeMedias {
    private JPanel panelMain;
    private JTextField txtAdicionarNota;
    private JTextArea txtListaNotas;
    private JButton txtCalcularMedia;
    private JLabel btnAntesCalculoMedia;
    private JLabel txtAprovado;
    private JLabel txtnotas;

    private ArrayList<Double> notas;   // Lista de notas

    public CalculadoraDeMedias() {
        notas = new ArrayList<>(); // Inicializa a lista de notas

        // Inicializando os componentes se não estiverem sendo inicializados pela IDE
        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout()); // Defina o layout do painel principal

        txtAdicionarNota = new JTextField();
        txtListaNotas = new JTextArea();
        txtCalcularMedia = new JButton("Calcular Média");
        btnAntesCalculoMedia = new JLabel("Média: -");
        txtAprovado = new JLabel("Status: -");
        txtnotas = new JLabel("Notas:");

        // Adicionando os componentes ao painel
        panelMain.add(txtAdicionarNota, BorderLayout.NORTH);
        panelMain.add(new JScrollPane(txtListaNotas), BorderLayout.CENTER);
        panelMain.add(txtCalcularMedia, BorderLayout.SOUTH);

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2, 1));
        labelPanel.add(btnAntesCalculoMedia);
        labelPanel.add(txtAprovado);
        panelMain.add(labelPanel, BorderLayout.EAST);

        // Ação para adicionar nota ao pressionar "Enter" no campo de texto
        txtAdicionarNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double nota = Double.parseDouble(txtAdicionarNota.getText());
                    if (nota < 0 || nota > 10) {
                        JOptionPane.showMessageDialog(txtAdicionarNota, "Digite uma nota entre 0 e 10!", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        notas.add(nota); // Adiciona a nota à lista
                        atualizarListaNotas(); // Atualiza a área de texto com as notas
                        txtAdicionarNota.setText(""); // Limpa o campo de texto
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(txtAdicionarNota, "Digite um valor numérico válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação para calcular a média ao clicar no botão
        txtCalcularMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notas.isEmpty()) {
                    btnAntesCalculoMedia.setText("Média: -");
                    txtAprovado.setText("Status: Nenhuma nota adicionada");
                    return;
                }

                // Calcula a média
                double soma = 0;
                for (double nota : notas) {
                    soma += nota;
                }
                double media = soma / notas.size();

                // Atualiza os labels com a média e o status
                btnAntesCalculoMedia.setText(String.format("Média: %.2f", media));
                txtAprovado.setText(media >= 7.0 ? "Status: Aprovado" : "Status: Reprovado");
            }
        });
    }

    // Método para atualizar a lista de notas na área de texto
    private void atualizarListaNotas() {
        StringBuilder sb = new StringBuilder();
        for (double nota : notas) {
            sb.append(nota).append("\n");
        }
        txtListaNotas.setText(sb.toString());
    }

    public static void main(String[] args) {
        // Cria o JFrame e adiciona o painel principal
        JFrame frame = new JFrame("Calculadora de Médias");
        CalculadoraDeMedias calculadora = new CalculadoraDeMedias();
        frame.setContentPane(calculadora.panelMain); // Associa o painel criado
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no "X"
        frame.setSize(400, 400); // Define o tamanho da janela
        frame.setVisible(true); // Torna o frame visível
    }
}
