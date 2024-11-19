import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class Calculadora {
    private JButton BtnC;
    private JButton Btn4;
    private JButton Btn1;
    private JButton Btn0;
    private JButton Btn3;
    private JButton Btn2;
    private JButton Btn5;
    private JButton Btn6;
    private JButton BtnSomar;
    private JButton BtnX;
    private JButton BtnMenos;
    private JButton BtnIgual;
    private JButton BtnDividir;
    private JButton Btn9;
    private JButton Btn8;
    private JButton Btn7;
    private JTextField Resultado;
    private JPanel panelMain;

    private double num1 = 0;
    private double num2 = 0;
    private String operador = "";

    public Calculadora (){
        Btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Resultado.setText(Resultado.getText() + 0 );
            }
        });

        Btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Resultado.setText(Resultado.getText() + 1 );
            }
        });

        Btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Resultado.setText(Resultado.getText() + 2 );
            }
        });

        Btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Resultado.setText(Resultado.getText() + 3 );
            }
        });

        Btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Resultado.setText(Resultado.getText() + 4 );
            }
        });

        Btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Resultado.setText(Resultado.getText() + 5 );
            }
        });

        Btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Resultado.setText(Resultado.getText() + 6 );
            }
        });

        Btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Resultado.setText(Resultado.getText() + 7 );
            }
        });

        Btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Resultado.setText(Resultado.getText() + 8 );
            }
        });

        Btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Resultado.setText(Resultado.getText() + 9 );
            }
        });

        BtnSomar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               if (!Resultado.getText().isEmpty()){
                   num1 = Double.parseDouble(Resultado.getText());
                   operador = "+";
                   Resultado.setText("");
            }
            }});

        BtnMenos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Resultado.getText().isEmpty()){
                    num1 = Double.parseDouble(Resultado.getText());
                    operador = "-";
                    Resultado.setText("");
                }
            }});

        BtnDividir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Resultado.getText().isEmpty()){
                    num1 = Double.parseDouble(Resultado.getText());
                    operador = "/";
                    Resultado.setText("");
                }
            }});

        BtnX.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Resultado.getText().isEmpty()){
                    num1 = Double.parseDouble(Resultado.getText());
                    operador = "*";
                    Resultado.setText("");
                }
            }});

        BtnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Resultado.getText().isEmpty()){
                 num2 = Double.parseDouble(Resultado.getText());
                 double resultado = 0;

                 if (operador.equals("+")){
                     resultado = (num1 + num2);
                 }else if (operador.equals("-")) {
                     resultado = (num1 - num2);
                 } else if (operador.equals("*")) {
                     resultado = (num1 * num2);
                 } else if (operador.equals("/")) {
                     if (num2 != 0) {
                         resultado = (num1 / num2);
                     } else {
                         Resultado.setText("Erro");
                         return;
                     }
                 }


                Resultado.setText(String.valueOf(resultado));
                num1 = resultado;
                operador = "";}

            }
        });



        BtnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Resultado.setText("");
                num1 = 0;
                num2 = 0;
                operador = "";
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new Calculadora().panelMain);
        frame.setSize(400,400);
        frame.setVisible(true);
    }}

