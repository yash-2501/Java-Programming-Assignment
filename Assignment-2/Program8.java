//Develop GUI-based Investment Calculator using Swing
import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Program8 extends JFrame {

    private final JLabel principalLabel = new JLabel("Principal Amount:");
    private final JLabel rateLabel = new JLabel("Annual Interest Rate (%):");
    private final JLabel yearsLabel = new JLabel("Number of Years:");
    private final JLabel resultLabel = new JLabel("Future Value: ");

    private final JTextField principalField = new JTextField();
    private final JTextField rateField = new JTextField();
    private final JTextField yearsField = new JTextField();

    private final JButton calculateButton = new JButton("Calculate");

    public Program8() {
        setTitle("Investment Calculator");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(principalLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(principalField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(rateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(rateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(yearsLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(yearsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(calculateButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(resultLabel, gbc);

        calculateButton.addActionListener(e -> calculateFutureValue());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculateFutureValue() {
        try {
            double principal =
                    Double.parseDouble(principalField.getText());

            double rate =
                    Double.parseDouble(rateField.getText()) / 100;

            int years =
                    Integer.parseInt(yearsField.getText());

            double futureValue =
                    principal * Math.pow(1 + rate, years);

            DecimalFormat df = new DecimalFormat("#.##");

            resultLabel.setText(
                    "Future Value: $" + df.format(futureValue)
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Enter valid numbers",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Program8());
    }

    public JLabel getRateLabel() {
        return rateLabel;
    }
}