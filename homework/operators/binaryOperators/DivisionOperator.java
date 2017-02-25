package homework.operators.binaryOperators;

import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.binaryOperators.IBinaryOperator;
import homework.operands.Operand;
import homework.operators.Operator;
import homework.operators.Operators;

/**
 * Implementation of DivisionOperator.
 *
 * @author Alexandru Lincan
 */
public final class DivisionOperator extends Operator
    implements IBinaryOperator<Double> {
  /**
   * Constructor for initializing a division operator with a given symbol.
   *
   * @param symbol
   *          the operator symbol
   */
  public DivisionOperator(final String symbol) {
    super(symbol);
  }

  @Override
  public int getPriority() {
    return Operators.DIVISION.getPriority();
  }

  @Override
  public IOperand<Double> calculate(final Double leftOperand,
      final Double rightOperand) {
    if (rightOperand == 0) {
      throw new IllegalArgumentException("Argument 'rightOperand' is zero.");
    }
    return new Operand(leftOperand / rightOperand);
  }
}
