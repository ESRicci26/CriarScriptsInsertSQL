package javaricci.com.br;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaConcatenator {

    public static void main(String[] args) {
        // Criando a janela principal
        JFrame frame = new JFrame("Concatenador de Texto Scripts INSERT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        // Painel superior com JTextFields
        JPanel topPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel labelChar = new JLabel("Digite o caractere:");
        JTextField textField = new JTextField(5);
        JLabel labelInsertSql = new JLabel("Digite o texto INSERT SQL:");
        JTextField textFieldInsertSql = new JTextField();
        JLabel labelParenteses = new JLabel("Digite o texto dos parênteses:");
        JTextField textFieldParenteses = new JTextField();
        topPanel.add(labelChar);
        topPanel.add(textField);
        topPanel.add(labelInsertSql);
        topPanel.add(textFieldInsertSql);
        topPanel.add(labelParenteses);
        topPanel.add(textFieldParenteses);

        // JTextArea para entrada e saída de texto
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Painel inferior com botões
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton buttonConcatenateChar = new JButton("Concatenar Caractere");
        JButton buttonConcatenateSql = new JButton("Concatenar SQL");

        buttonConcatenateChar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtendo o caractere do JTextField e o texto do JTextArea
                String charInput = textField.getText().trim();
                String textInput = textArea.getText().trim();

                if (charInput.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, digite um caractere.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (textInput.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira texto no campo de texto.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Processando cada linha do texto
                StringBuilder result = new StringBuilder();
                String[] lines = textInput.split("\\n");
                for (String line : lines) {
                    String trimmedLine = line.trim(); // Remove espaços no início e no final da linha
                    result.append(charInput).append(trimmedLine).append(charInput).append("\n");
                }

                // Atualizando o JTextArea com o resultado
                textArea.setText(result.toString().trim());
            }
        });

        buttonConcatenateSql.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtendo os textos dos JTextFields e o JTextArea
                String insertSql = textFieldInsertSql.getText().trim();
                String textInput = textArea.getText().trim();
                String parenteses = textFieldParenteses.getText().trim();

                if (insertSql.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, digite o texto INSERT SQL.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (textInput.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira texto no campo de texto.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (parenteses.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, digite o texto dos parênteses.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Processando cada linha do texto
                StringBuilder result = new StringBuilder();
                String[] lines = textInput.split("\\n");
                for (String line : lines) {
                    String trimmedLine = line.trim(); // Remove espaços no início e no final da linha
                    result.append(insertSql).append(trimmedLine).append(parenteses).append("\n");
                }

                // Atualizando o JTextArea com o resultado
                textArea.setText(result.toString().trim());
            }
        });

        buttonPanel.add(buttonConcatenateChar);
        buttonPanel.add(buttonConcatenateSql);

        // Adicionando os componentes ao frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Tornando a janela visível
        frame.setVisible(true);
    }
}


/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaConcatenator {

    public static void main(String[] args) {
        // Criando a janela principal
        JFrame frame = new JFrame("Concatenador de Texto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Painel superior com JTextField
        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Digite o caractere:");
        JTextField textField = new JTextField(5);
        topPanel.add(label);
        topPanel.add(textField);

        // JTextArea para entrada e saída de texto
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Botão para realizar a operação
        JButton button = new JButton("Concatenar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtendo o caractere do JTextField e o texto do JTextArea
                String charInput = textField.getText().trim();
                String textInput = textArea.getText().trim();

                if (charInput.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, digite um caractere.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (textInput.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira texto no campo de texto.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Processando cada linha do texto
                StringBuilder result = new StringBuilder();
                String[] lines = textInput.split("\\n");
                for (String line : lines) {
                    String trimmedLine = line.trim(); // Remove espaços no início e no final da linha
                    result.append(charInput).append(trimmedLine).append(charInput).append("\n");
                }

                // Atualizando o JTextArea com o resultado
                textArea.setText(result.toString().trim());
            }
        });

        // Adicionando os componentes ao frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        // Tornando a janela visível
        frame.setVisible(true);
    }
}
*/