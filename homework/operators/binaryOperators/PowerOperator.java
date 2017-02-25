package homework.operators.binaryOperators;

import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.binaryOperators.IBinaryOperator;
import homework.operands.Operand;
import homework.operators.Operator;
import homework.operators.Operators;

/**
 * Implementation of PowerOperator.
 *
 * @author Alexandru Lincan
 */
public final class PowerOperator extends Operator
    implements IBinaryOperator<Double> {
  /**
   * Constructor for initializing a power operator with a given symbol.
   *
   * @param symbol
   *          the operator symbol
   */
  public PowerOperator(final String symbol) {
    super(symbol);
  }

  @Override
  public int getPriority() {
    return Operators.POWER.getPriority();
  }

  @Override
  public IOperand<Double> calculate(final Double leftOperand,
      final Double rightOperand) {
    return new Operand(Math.pow(leftOperand, rightOperand));
  }
}
