package ic.doc;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class CalculatorModelTest {

  private CalculatorModel calculatorModel = new CalculatorModel();

  @Test
  public void addsNumbersToStack() {
    calculatorModel.updateExpression("2");
    calculatorModel.updateExpression("3");
    assertEquals(calculatorModel.stackItems(), "2 3 ");
  }

  @Test
  public void addsExpressionsIntoStackAndAddsThemAccurately() {
    calculatorModel.updateExpression("5");
    calculatorModel.updateExpression("6");
    calculatorModel.updateExpression("+");
    assertEquals(calculatorModel.stackItems(), "11 ");
  }

  @Test
  public void addsExpressionIntoStackAndSubtractsThemAccurately() {
    calculatorModel.updateExpression("9");
    calculatorModel.updateExpression("8");
    calculatorModel.updateExpression("-");
    assertEquals(calculatorModel.stackItems(), "1 ");
  }

  @Test
  public void doesNotAddOrSubtractIfLessThanTwoItemsInStack() {
    assertEquals("Invalid Input!", calculatorModel.updateExpression("+"));
    assertEquals(calculatorModel.updateExpression("8"), "8 ");
    assertEquals("Invalid Input!", calculatorModel.updateExpression("-"));
  }
}
