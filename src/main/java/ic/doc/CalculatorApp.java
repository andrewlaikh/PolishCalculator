package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {
  private CalculatorView view = new CalculatorView(new CalculatorController());
  private CalculatorModel model = new CalculatorModel();

  private class CalculatorController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      String buttonPressed = actionEvent.getActionCommand();
      String updatedString = model.updateExpression(buttonPressed);
      view.update(updatedString);
    }
  }

  public static void main(String[] args) {
    new CalculatorApp();
  }
}
