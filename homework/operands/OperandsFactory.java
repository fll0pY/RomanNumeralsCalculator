package homework.operands;

import homework.Token;
import homework.interfaces.operands.IOperand;
import homework.interfaces.operands.IOperandsFactory;

/**
 * Implementation of IOperatorsFactory as a singleton.
 *
 * @author Alexandru Lincan
 */
public final class OperandsFactory extends Token
    implements IOperandsFactory<Double> {
  /**
   * The unique instance of the singleton.
   */
  private static OperandsFactory instance = null;

  /**
   * Arab numbers.
   */
  private final int[] numbers
      = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

  /**
   * Roman numbers.
   */
  private final String[] romans = new String[] {"M", "CM", "D", "CD", "C",
      "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

  /**
   * Private constructor for the singleton.
   */
  private OperandsFactory() {
  }

  /**
   * Returns the instance of the OperandsFactory singleton.
   *
   * @return the instance of the OperandsFactory
   */
  public static OperandsFactory getInstance() {
    if (instance == null) {
      instance = new OperandsFactory();
    }
    return instance;
  }

  @Override
  public IOperand<Double> createOperand(final String token) {
    return convertToArabNumber(token);
  }

  @Override
  public IOperand<Double> convertToRomanNumber(final Double arabNumber) {
    Operand romanNumber = new Operand(arabNumber);
    String result = new String();
    if (arabNumber < 0) {
      result += "- ";
    }
    int number = (int) Math.abs(Math.floor(arabNumber));

    while (number > 0) {
      for (int i = 0; i < numbers.length; i++) {
        if (number >= numbers[i]) {
          number -= numbers[i];
          result += romans[i];
          break;
        }
      }
    }

    romanNumber.setSymbol(result);
    return romanNumber;
  }

  @Override
  public IOperand<Double> convertToArabNumber(final String romanNumber) {
    Operand arabNumber = new Operand(romanNumber);

    int result = 0;
    int maxVal = 0;
    for (int i = romanNumber.length() - 1; i >= 0; i--) {
      int val = RomanDigits.valueOf(String.valueOf(romanNumber.charAt(i)))
          .getValue();
      if (val >= maxVal) {
        maxVal = val;
        result += val;
      } else {
        result -= val;
      }
    }
    arabNumber.setSymbolValue(new Double(result));

    return arabNumber;
  }
}
