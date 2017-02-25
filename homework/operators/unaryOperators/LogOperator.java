package homework.operators.unaryOperators;

import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.unaryOperators.IUnaryOperator;
import homework.operands.Operand;
import homework.operators.Operator;
import homework.operators.Operators;

/**
 * Implementation of LogOperator.
 *
 * @author Alexandru Lincan
 */
public final class LogOperator extends Operator
    implements IUnaryOperator<Double> {
  /**
   * Constructor for initializing a log operator with a given symbol.
   *
   * @param symbol
   *          the operator symbol
   */
  public LogOperator(final String symbol) {
    super(symbol);
  }

  @Override
  public int getPriority() {
    return Operators.LOG.getPriority();
  }

  @Override
  public IOperand<Double> calculate(final Double operand) {
    return new Operand(Math.log(operand));
  }
}
