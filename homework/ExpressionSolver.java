package homework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import homework.brackets.BracketsFactory;
import homework.interfaces.IToken;
import homework.interfaces.brackets.IBracket;
import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.IOperator;
import homework.interfaces.operators.binaryOperators.IBinaryOperator;
import homework.interfaces.operators.unaryOperators.IUnaryOperator;
import homework.operands.OperandsFactory;
import homework.operators.OperatorsFactory;

/**
 * Static class for resolving expressions with roman numbers.
 *
 * @author Alexandru Lincan
 */
public final class ExpressionSolver {

  /**
   * Private constructor for this utility static class.
   */
  private ExpressionSolver() {
  }

  /**
   * Converts an infix expression to a postfix expression.
   *
   * @param expression
   *          an array with the expression tokens
   * @return a queue with the postfix form of the expression.
   */
  public static Queue<IToken>
      convertToPolishNotation(final String[] expression) {
    OperandsFactory operandsFactory = OperandsFactory.getInstance();
    OperatorsFactory operatorsFactory = OperatorsFactory.getInstance();
    BracketsFactory bracketsFactory = BracketsFactory.getInstance();

    Queue<IToken> postfixExp = new LinkedList<IToken>();
    Stack<IToken> operatorStack = new Stack<IToken>();

    for (String token : expression) {
      if (operatorsFactory.isOperator(token)) {
        IOperator operatorToken = operatorsFactory.createOperator(token);

        while (!operatorStack.empty()
            && operatorsFactory.isOperator(operatorStack.peek())
            && operatorToken.getPriority() <= ((IOperator) operatorStack.peek())
                .getPriority()) {
          postfixExp.add(operatorStack.pop());
        }

        operatorStack.push(operatorToken);
        continue;
      }

      if (bracketsFactory.isBracket(token)) {
        IBracket bracketToken = bracketsFactory.createBracket(token);

        if (bracketsFactory.isOpenedBracket(bracketToken)) {
          operatorStack.push(bracketToken);
          continue;
        }

        while (!operatorStack.empty()
            && !bracketsFactory.isBracket(operatorStack.peek())) {
          postfixExp.add(operatorStack.pop());
        }
        if (operatorStack.isEmpty() || !bracketsFactory
            .isBracketPair((IBracket) operatorStack.peek(), bracketToken)) {
          throw new IllegalArgumentException(
              "Argument 'expression' is not valid.");
        }
        operatorStack.pop();
        continue;
      }

      // If the token is a number
      IOperand<Double> operandToken = operandsFactory.createOperand(token);
      postfixExp.add((operandToken));
    }

    while (!operatorStack.empty()) {
      if (!operatorsFactory.isOperator(operatorStack.peek())) {
        throw new IllegalArgumentException(
            "Argument 'expression' is not valid.");
      }
      postfixExp.add(operatorStack.pop());
    }

    return postfixExp;
  }

  /**
   * Evaluates an expression with roman numbers.
   *
   * @param expression
   *          the expression to evaluate
   * @return the result as a roman number
   */
  @SuppressWarnings("unchecked")
  public static String evaluateExpression(final String[] expression) {
    OperatorsFactory operatorsFactory = OperatorsFactory.getInstance();
    OperandsFactory operandsFactory = OperandsFactory.getInstance();
    Queue<IToken> postfixExp = convertToPolishNotation(expression);
    Stack<IOperand<Double>> operandStack = new Stack<IOperand<Double>>();

    while (!postfixExp.isEmpty()) {
      IToken token = postfixExp.poll();

      if (operatorsFactory.isOperator(token)) {
        IOperand<Double> firstOperand;
        IOperator operator = (IOperator) token;

        if (operatorsFactory.isUnaryOperator(operator)) {
          IUnaryOperator<Double> unaryOperator
              = (IUnaryOperator<Double>) operator;
          firstOperand = operandStack.pop();
          operandStack
              .push(unaryOperator.calculate(firstOperand.getSymbolValue()));
        }

        if (operatorsFactory.isBinaryOperator(operator)) {
          IBinaryOperator<Double> binaryOperator
              = (IBinaryOperator<Double>) operator;
          IOperand<Double> secondOperand = operandStack.pop();
          firstOperand = operandStack.pop();

          try {
            operandStack.push(binaryOperator.calculate(
                firstOperand.getSymbolValue(), secondOperand.getSymbolValue()));
          } catch (IllegalArgumentException e) {
            return Server.IMPOSSIBLE_EQUATION;
          }

        }

      } else {
        operandStack.push((IOperand<Double>) token);
      }
    }

    return operandsFactory
        .convertToRomanNumber(operandStack.pop().getSymbolValue()).getSymbol();
  }
}
