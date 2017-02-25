package homework.operators.binaryOperators;

import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.binaryOperators.IBinaryOperator;
import homework.operands.Operand;
import homework.operators.Operator;
import homework.operators.Operators;

/**
 * Implementation of MultiplicationOperator.
 *
 * @author Alexandru Lincan
 */
public final class MultiplicationOperator extends Operator
    implements IBinaryOperator<Double> {
  /**
   * Constructor for initializing a multiplication operator with a given symbol.
   *
   * @param symbol
   *          the operator symbol
   */
  public MultiplicationOperator(final String symbol) {
    super(symbol);
  }

  @Override
  public int getPriority() {
    return Operators.MULTIPLICATION.getPriority();
  }

  @Override
  public IOperand<Double> calculate(final Double leftOperand,
      final Double rightOperand) {
    return new Operand(leftOperand * rightOperand);
  }
}
