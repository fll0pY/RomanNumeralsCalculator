package homework.operators;

import java.util.HashMap;

import homework.interfaces.IToken;
import homework.interfaces.operators.IOperator;
import homework.interfaces.operators.IOperatorsFactory;
import homework.operators.binaryOperators.DivisionOperator;
import homework.operators.binaryOperators.MinusOperator;
import homework.operators.binaryOperators.MultiplicationOperator;
import homework.operators.binaryOperators.PlusOperator;
import homework.operators.binaryOperators.PowerOperator;
import homework.operators.unaryOperators.LogOperator;
import homework.operators.unaryOperators.SqrtOperator;

/**
 * Implementation of IOperatorsFactory as a singleton.
 *
 * @author Alexandru Lincan
 */
public final class OperatorsFactory implements IOperatorsFactory {
  /**
   * The unique instance of the singleton.
   */
  private static OperatorsFactory instance = null;

  /**
   * Private constructor for the singleton.
   */
  private OperatorsFactory() {
  }

  /**
   * Returns the instance of the singleton server.
   *
   * @return the instance of the singleton
   */
  public static OperatorsFactory getInstance() {
    if (instance == null) {
      instance = new OperatorsFactory();
    }
    return instance;
  }

  @Override
  public IOperator createOperator(final String token) {
    if (token.equals(BINARY_OPERATORS.get(Operators.PLUS))) {
      return new PlusOperator(token);
    }
    if (token.equals(BINARY_OPERATORS.get(Operators.MINUS))) {
      return new MinusOperator(token);
    }
    if (token.equals(BINARY_OPERATORS.get(Operators.MULTIPLICATION))) {
      return new MultiplicationOperator(token);
    }
    if (token.equals(BINARY_OPERATORS.get(Operators.DIVISION))) {
      return new DivisionOperator(token);
    }
    if (token.equals(BINARY_OPERATORS.get(Operators.POWER))) {
      return new PowerOperator(token);
    }
    if (token.equals(UNARY_OPERATORS.get(Operators.SQRT))) {
      return new SqrtOperator(token);
    }
    if (token.equals(UNARY_OPERATORS.get(Operators.LOG))) {
      return new LogOperator(token);
    }

    return null;
  }

  @Override
  public boolean isOperator(final IToken token) {
    return (UNARY_OPERATORS.containsValue(token.getSymbol())
        || BINARY_OPERATORS.containsValue(token.getSymbol()));
  }

  @Override
  public boolean isUnaryOperator(final IOperator operator) {
    return UNARY_OPERATORS.containsValue(operator.getSymbol());
  }

  @Override
  public boolean isBinaryOperator(final IOperator operator) {
    return BINARY_OPERATORS.containsValue(operator.getSymbol());
  }

  /**
   * Map with unary operators and their symbols.
   */
  private static final HashMap<Operators, String> UNARY_OPERATORS;
  static {
    UNARY_OPERATORS = new HashMap<Operators, String>();
    UNARY_OPERATORS.put(Operators.SQRT, "sqrt");
    UNARY_OPERATORS.put(Operators.LOG, "log");
  }

  /**
   * Returns true if the token is an operator.
   *
   * @param token
   *          the token to check
   * @return true if the token is an operator
   */
  public boolean isOperator(final String token) {
    return (UNARY_OPERATORS.containsValue(token)
        || BINARY_OPERATORS.containsValue(token));
  }

  /**
   * Map with binary operators and their symbols.
   */
  private static final HashMap<Operators, String> BINARY_OPERATORS;
  static {
    BINARY_OPERATORS = new HashMap<Operators, String>();
    BINARY_OPERATORS.put(Operators.PLUS, "+");
    BINARY_OPERATORS.put(Operators.MINUS, "-");
    BINARY_OPERATORS.put(Operators.MULTIPLICATION, "*");
    BINARY_OPERATORS.put(Operators.DIVISION, "/");
    BINARY_OPERATORS.put(Operators.POWER, "^");
  }
}
