import javax.swing.*;

public class Calculadora {
    private JButton cButton;
    private JButton Btn4;
    private JButton Btn1;
    private JButton Btn0;
    private JButton Btn3;
    private JButton Btn2;
    private JButton Btn5;
    private JButton Btn6;
    private JButton BtnMais;
    private JButton BtnX;
    private JButton BtnMenos;
    private JButton BtnIgual;
    private JButton BtnDividir;
    private JButton Btn9;
    private JButton Btn8;
    private JButton Btn7;
    private JTextField Resultado;
    private JPanel panelMain;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new Calculadora().panelMain);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
