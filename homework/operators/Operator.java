package homework.operators;

import homework.Token;
import homework.interfaces.operators.IOperator;

/**
 * Implementation of IOperator interface.
 *
 * @author Alexandru Lincan
 */
public abstract class Operator extends Token implements IOperator {
  /**
   * Constructor for initializing an operator with a given symbol.
   *
   * @param symbol
   *          the operator symbol
   */
  public Operator(final String symbol) {
    super(symbol);
  }
}
