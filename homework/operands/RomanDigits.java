package homework.operands;

/**
 * Enumeration with roman numbers.
 *
 * @author Alexandru Lincan
 */
public enum RomanDigits {
  I(1),
  V(5),
  X(10),
  L(50),
  C(100),
  D(500),
  M(1000);

  /**
   * The int value of the roman number.
   */
  private final int value;

  /**
   * Constructor for initializing with a int value.
   *
   * @param newValue
   *          the value
   */
  RomanDigits(final int newValue) {
    value = newValue;
  }

  /**
   * Returns the value of the roman number.
   *
   * @return the value
   */
  public int getValue() {
    return value;
  }
}
