package homework.operators.binaryOperators;

import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.binaryOperators.IBinaryOperator;
import homework.operands.Operand;
import homework.operators.Operator;
import homework.operators.Operators;

/**
 * The implementation of MinusOperator.
 *
 * @author fll0pY
 */
public final class MinusOperator extends Operator
    implements IBinaryOperator<Double> {
  /**
   * Constructor for initializing a minus operator with a given symbol.
   *
   * @param symbol
   *          the operator symbol
   */
  public MinusOperator(final String symbol) {
    super(symbol);
  }

  @Override
  public int getPriority() {
    return Operators.MINUS.getPriority();
  }

  @Override
  public IOperand<Double> calculate(final Double leftOperand,
      final Double rightOperand) {
    return new Operand(leftOperand - rightOperand);
  }
}
