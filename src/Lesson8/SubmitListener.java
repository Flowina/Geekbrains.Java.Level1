package Lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class SubmitListener implements ActionListener {
    private final JTextField inputField;
    private final StringBuilder sb = new StringBuilder();

    public SubmitListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            float result = calculate(inputField.getText());
            sb.append(inputField.getText()).append(" = " + result);
        } catch (Exception ex) {
            sb.append(inputField.getText()).append(" = " + ex.getMessage());
        } finally {
            inputField.setText(sb.toString());
            sb.setLength(0);
        }
    }

    private float calculate(String input) throws Exception {
        StringBuilder sbFirstOperand = new StringBuilder();
        StringBuilder sbSecondOperand = new StringBuilder();
        char operation = '_';
        boolean isFirstOperand = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (operation != '_') {
                    throw new Exception("Не используйте более одной операции");
                }
                operation = c;
                isFirstOperand = false;
                continue;
            }
            if (isFirstOperand) {
                sbFirstOperand.append(c);
            } else {
                sbSecondOperand.append(c);
            }
        }
        //long operand1 = Long.parseLong(sbFirstOperand.toString());
        Long operand1 = Long.valueOf(sbFirstOperand.toString());
        Long operand2 = Long.valueOf(sbSecondOperand.toString());
        float result = 0;

        switch (operation) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 == 0) {
                    throw new Exception("На 0 делить нельзя!");
                }
                result = operand1.floatValue() / operand2;
                break;
            default:
                throw new Exception("Неизвестная операция");
        }
        return result;
    }

}