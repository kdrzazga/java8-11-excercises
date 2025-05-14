package org.kd.swingcalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField display;
    private JPanel panel;
    private String currentInput = "";
    private String previousInput = "";
    private Operator currentOperator = null;

    enum Operator {
        ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        public static Operator fromSymbol(String s) {
            for (Operator op : values()) {
                if (op.symbol.equals(s)) {
                    return op;
                }
            }
            return null;
        }
    }

    public Main() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 300);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);

        panel = new JPanel(new GridBagLayout());
        var gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(display, gbc);

        createButtons(gbc);

        add(panel);
    }

    private void createButtons(GridBagConstraints gbc) {
        String[][] buttons = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "C", "+"},
                {"="}
        };

        // Add buttons
        int row = 1;
        for (String[] rowButtons : buttons) {
            int col = 0;
            for (String text : rowButtons) {
                var btn = new JButton(text);
                btn.setFont(new Font("Arial", Font.BOLD, 16));
                btn.addActionListener(this);
                gbc.gridx = col;
                gbc.gridy = row;
                gbc.gridwidth = (text.equals("=")) ? 4 : 1;
                gbc.fill = GridBagConstraints.BOTH;
                if (text.equals("=")) {
                    gbc.insets = new Insets(5, 5, 5, 5);
                } else {
                    gbc.insets = new Insets(2, 2, 2, 2);
                }
                this.panel.add(btn, gbc);
                col++;
            }
            row++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9.]")) {
            // Append digits or dot
            currentInput += cmd;
            updateDisplay();
        } else if (cmd.equals("C")) {
            clear();
        } else if (cmd.equals("=")) {
            computeResult();
        } else if (isOperator(cmd)) {
            handleOperator(cmd);
        }
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private void handleOperator(String opSymbol) {
        if (!currentInput.isEmpty()) {
            if (!previousInput.isEmpty() && currentOperator != null) {
                computeIntermediate();
            } else {
                previousInput = currentInput;
            }
            currentInput = "";
        }
        currentOperator = Operator.fromSymbol(opSymbol);
        updateDisplay();
    }

    private void computeIntermediate() {
        double a = Double.parseDouble(previousInput);
        double b = Double.parseDouble(currentInput);
        double result;

        switch (currentOperator) {
            case ADD -> result = a + b;
            case SUBTRACT -> result = a - b;
            case MULTIPLY -> result = a * b;
            case DIVIDE -> result = b != 0 ? a / b : 0;
            default -> result = 0;
        }
        previousInput = Double.toString(result);
    }

    private void computeResult() {
        if (currentOperator != null && !previousInput.isEmpty() && !currentInput.isEmpty()) {
            computeIntermediate();
            display.setText(previousInput);
            currentInput = previousInput;
            previousInput = "";
            currentOperator = null;
        }
    }

    private void clear() {
        currentInput = "";
        previousInput = "";
        currentOperator = null;
        updateDisplay();
    }

    private void updateDisplay() {
        String text = previousInput;
        if (currentOperator != null) {
            text += " " + currentOperator.symbol + " ";
        }
        text += currentInput;
        display.setText(text);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var calculator = new Main();
            calculator.setVisible(true);
        });
    }
}
