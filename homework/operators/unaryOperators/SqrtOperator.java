package homework.operators.unaryOperators;

import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.unaryOperators.IUnaryOperator;
import homework.operands.Operand;
import homework.operators.Operator;
import homework.operators.Operators;

/**
 * Implementation of SqrtOperator.
 *
 * @author Alexandru Lincan
 */
public final class SqrtOperator extends Operator
    implements IUnaryOperator<Double> {
  /**
   * Constructor for initializing a sqrt operator with a given symbol.
   *
   * @param symbol
   *          the operator symbol
   */
  public SqrtOperator(final String symbol) {
    super(symbol);
  }

  @Override
  public int getPriority() {
    return Operators.SQRT.getPriority();
  }

  @Override
  public IOperand<Double> calculate(final Double operand) {
    return new Operand(Math.sqrt(operand));
  }
}
