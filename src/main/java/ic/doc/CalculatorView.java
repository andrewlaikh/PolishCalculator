package ic.doc;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView {
  private List<JButton> buttonList;
  private final JTextField textField = new JTextField(15);

  public CalculatorView(ActionListener controller) {
    // Create the frame and panel
    JFrame frame = new JFrame("Polish Calculator");
    frame.setSize(300, 200);
    JPanel panel = new JPanel();
    panel.add(textField);

    // Create the buttons
    buttonList = new ArrayList<>();
    for (int i = 0; i < 10; ++i) {
      String label = Integer.toString(i);
      buttonList.add(new JButton(label));
    }

    buttonList.add(new JButton("+"));
    buttonList.add(new JButton("-"));

    // Add buttons to panel
    for (JButton b : buttonList) {
      b.addActionListener(controller);
      panel.add(b);
    }

    frame.add(panel);
    frame.setVisible(true);
  }

  public void update(String expression) {
    textField.setText(expression);
  }
}
