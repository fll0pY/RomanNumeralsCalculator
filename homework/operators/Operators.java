package homework.operators;

/**
 * Enumeration with the priority of each operator.
 *
 * @author Alexandru Lincan
 */
public enum Operators {
  PLUS(0),
  MINUS(0),
  MULTIPLICATION(1),
  DIVISION(1),
  POWER(2),
  LOG(3),
  SQRT(3);

  /**
   * The priority of an operator.
   */
  private final int priority;

  /**
   * Constructor for int value.
   *
   * @param newValue
   *          the int value
   */
  Operators(final int newValue) {
    priority = newValue;
  }

  /**
   * Returns the priority of an operator.
   *
   * @return the priority
   */
  public int getPriority() {
    return priority;
  }
}
