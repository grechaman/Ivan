package com.company;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {

    private JButton numbers[] = new JButton[10];
    private Font font = new Font("SantSerif", Font.BOLD, 20);
    private JTextField output = new JTextField();
    private JButton backspace = new JButton("<x"), equally = new JButton("=");
    private JButton plus = new JButton("+"), minus = new JButton("-"), multiply = new JButton("*"), divide = new JButton("/");
    private JButton delete = new JButton("C");
//    private JButton dot = new JButton(".");
//    private JButton plusminus = new JButton("+/-");

    public Panel(){
        setLayout(null);
        setFocusable(true);
        grabFocus();

//        dot.setBounds(130,310,60,50);
//        dot.setFont(font);
//        add(dot);
//
//        plusminus.setBounds(10,310,60,50);
//        plusminus.setFont(font);
//        add(plusminus);

        backspace.setBounds(130,70,60,50);
        backspace.setFont(font);
        add(backspace);

        equally.setBounds(190,310,60,50);
        equally.setFont(font);
        add(equally);

        plus.setBounds(190,190,60,50);
        plus.setFont(font);
        add(plus);

        minus.setBounds(190,250,60,50);
        minus.setFont(font);
        add(minus);
//
        multiply.setBounds(190,70,60,50);
        multiply.setFont(font);
        add(multiply);

        divide.setBounds(190,130,60,50);
        divide.setFont(font);
        add(divide);
//
        delete.setBounds(70,70,60,50);
        delete.setFont(font);
        add(delete);

        numbers[0] = new JButton("0");
        numbers[0].setBounds( 70,310,60,50);
        numbers[0].setFont(font);
        add(numbers[0]);


        for(int y = 0; y < 3; y++ ){
            for (int x = 0; x < 3; x++){
                numbers[y * 3 + x + 1] = new JButton((y * 3 + x +1)+"");
                numbers[y * 3 + x + 1].setBounds(x * (50+10)+10,250-(60 * y),60,50);
                numbers[y * 3 + x + 1].setFont(font);
                add(numbers[y * 3 + x + 1]);

            }
        }
        output.setBounds(10,10,240,50);
        output.setFont(font);
        output.setEditable(false);
        add(output);

        ActionListener l = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            output.setText(output.getText() + b.getText());

        };
        backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = output.getText();
                output.setText(temp.substring( 0 ,temp.length()-1));
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(null);

            }
        });
//        dot.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                output.setText(output.getText() + ".");
//
//            }
//        });

        for(JButton b : numbers){
            b.addActionListener(l);
        }
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent e) {
                char symbol = e.getKeyChar();

                if(!Character.isDigit(symbol))
                    return;
                output.setText(output.getText() + symbol);

            }
        });
        final int[] num1 = {0};
        final String[] operation = {"+"};

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               num1[0] = Integer.valueOf(output.getText());
               output.setText("");
               operation[0] = "+";
            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1[0] = Integer.valueOf(output.getText());
                output.setText("");
                operation[0] = "-";
            }
        });
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1[0] = Integer.valueOf(output.getText());
                output.setText("");
                operation[0] = "*";
            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1[0] = Integer.valueOf(output.getText());
                output.setText("");
                operation[0] = "/";
            }
        });
        equally.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num2 = Integer.valueOf(output.getText());
                if("+".equals(operation[0])){
                    output.setText(num1[0] + num2 + "");
                }
                if("-".equals(operation[0])){
                    output.setText(num1[0] - num2 + "");
                }
                if("*".equals(operation[0])){
                    output.setText(num1[0] * num2 + "");
                }
                if("/".equals(operation[0])){
                    output.setText(num1[0] / num2 + "");
                }
                num1[0] = 0;
                operation[0] = "+";
            }
        });
    }
}
