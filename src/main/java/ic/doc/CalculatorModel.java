package ic.doc;

import java.util.Enumeration;
import java.util.Stack;

public class CalculatorModel {
  private Stack<Integer> stack;

  public CalculatorModel() {
    this.stack = new Stack<>();
  }

  public String updateExpression(String input) {
    if (isOperator(input) && stack.size() < 2) {
      return "Invalid Input!";
    } else if (Character.isDigit(input.charAt(0))) {
      addInteger(Integer.parseInt(input));
    } else if (isOperator(input)) {
      int left = stack.pop();
      int right = stack.pop();
      int output = evaluateExpression(input, left, right);
      addInteger(output);
    }
    return stackItems();
  }

  private int evaluateExpression(String input, int left, int right) {
    int returnValue;
    if (input.equals("+")) {
      returnValue = addExpression(left, right);
    } else {
      returnValue = subtractExpression(left, right);
    }
    return returnValue;
  }

  public String stackItems() {
    String output = "";
    Enumeration enu = stack.elements();
    while (enu.hasMoreElements()) {
      output += enu.nextElement() + " ";
    }
    return output;
  }

  private boolean isOperator(String input) {
    return input.equals("+") || input.equals("-");
  }

  private void addInteger(int input) {
    stack.push(input);
  }

  private int subtractExpression(int left, int right) {
    return right - left;
  }

  public int addExpression(int left, int right) {
    return left + right;
  }
}
