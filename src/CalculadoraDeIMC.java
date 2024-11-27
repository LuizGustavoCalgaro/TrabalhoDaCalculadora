import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraDeIMC {
    private  JFrame MainPanel;
    private JTextField txtEntradaPeso;
    private JTextField txtEntradaDeAltura; // Corrigir a variável para o campo de altura
    private JButton btnCalcularIMC;
    private JLabel txtResultadoIMC;

    public CalculadoraDeIMC() {
        inicializarComponentes();

        // Ação do botão "Calcular IMC"
        btnCalcularIMC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    private void inicializarComponentes() {
        // Inicializa o painel principal
        MainPanel = new JFrame("Calculadora de IMC");
        MainPanel.setLayout(new BorderLayout());

        // Painel de entrada de dados
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Calculadora de IMC"));

        inputPanel.add(new JLabel("Peso (kg):"));
        txtEntradaPeso = new JTextField(15);
        inputPanel.add(txtEntradaPeso);

        inputPanel.add(new JLabel("Altura (m):"));
        txtEntradaDeAltura = new JTextField(15); // Corrigindo o campo de altura
        inputPanel.add(txtEntradaDeAltura);

        btnCalcularIMC = new JButton("Calcular IMC");
        inputPanel.add(btnCalcularIMC);

        // Adiciona o painel de entrada ao painel principal
        MainPanel.add(inputPanel, BorderLayout.NORTH);

        // Painel para exibir o resultado
        txtResultadoIMC = new JLabel("Insira peso e altura para calcular o IMC", SwingConstants.CENTER);
        txtResultadoIMC.setBorder(BorderFactory.createTitledBorder("Resultado"));
        MainPanel.add(txtResultadoIMC, BorderLayout.CENTER);
    }

    private void calcularIMC() {
        String pesoTexto = txtEntradaPeso.getText().trim();
        String alturaTexto = txtEntradaDeAltura.getText().trim().replace(',' , '.'); // Corrigindo para pegar o texto de txtEntradaDeAltura

        try {
            // Converte os textos para números
            double peso = Double.parseDouble(pesoTexto);
            double altura = Double.parseDouble(alturaTexto);

            // Verifica se os valores são válidos
            if (peso <= 0 || altura <= 0) {
                throw new IllegalArgumentException("Peso e altura devem ser maiores que zero.");
            }

            // Calcula o IMC
            double imc = peso / (altura * altura);
            String categoria = determinarCategoriaIMC(imc);

            // Exibe o resultado
            txtResultadoIMC.setText(String.format("IMC: %.2f - Categoria: %s", imc, categoria));
        } catch (NumberFormatException ex) {
            showMessage("Por favor, insira valores numéricos válidos.");
        } catch (IllegalArgumentException ex) {
            showMessage(ex.getMessage());
        }
    }

    private String determinarCategoriaIMC(double imc) {
        if (imc < 18.5) {
            return "Baixo peso";
        } else if (imc < 24.9) {
            return "Normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(MainPanel, message, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        // Cria a instância da aplicação
        CalculadoraDeIMC calculadoraIMC = new CalculadoraDeIMC();

        // Configura a janela principal
        calculadoraIMC.MainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Usa o MainPanel
        calculadoraIMC.MainPanel.pack(); // Ajusta o tamanho do JFrame
        calculadoraIMC.MainPanel.setVisible(true); // Exibe a janela
    }}
