package homework.operands;

import homework.Token;
import homework.interfaces.operands.IOperand;

/**
 * Implementation of IOperand interface.
 *
 * @author Alexandru Lincan
 */
public class Operand extends Token implements IOperand<Double> {
  /**
   * The value of the operand.
   */
  private Double value;

  /**
   * Constructor for initializing with a value.
   *
   * @param val
   *          the value to initialize with
   */
  public Operand(final Double val) {
    value = val;
  }

  /**
   * Constructor for initializing with a symbol.
   *
   * @param symbol
   *          the symbol of the operand.
   */
  public Operand(final String symbol) {
    super(symbol);
  }

  @Override
  public final Double getSymbolValue() {
    return value;
  }

  @Override
  public final void setSymbolValue(final Double newValue) {
    value = newValue;
  }
}
