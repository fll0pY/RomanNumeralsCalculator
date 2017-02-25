package homework;

import java.util.ArrayList;
import java.util.List;

import homework.interfaces.IServer;
import homework.operators.OperatorsFactory;

/**
 * Singleton for resolving a set of expressions.
 *
 * @author Alexandru Lincan
 */
public final class Server implements IServer {
  /**
   * List with the results of the published equations.
   */
  private List<String> results;

  /**
   * List with valid operators for the current data set.
   */
  private List<String> operators;

  /**
   * Impossible equation result.
   */
  public static final String IMPOSSIBLE_EQUATION = "IMPOSSIBRU";

  /**
   * The unique instance of the singleton.
   */
  private static Server instance = null;

  /**
   * Private constructor for the singleton.
   */
  private Server() {
    results = new ArrayList<String>();
    operators = new ArrayList<String>();
  }

  /**
   * Returns the instance of the singleton server.
   *
   * @return the instance of the singleton
   */
  public static Server getInstance() {
    if (instance == null) {
      instance = new Server();
    }
    return instance;
  }

  @Override
  public boolean canPublish(final String[] tokens) {
    OperatorsFactory operatorsFactory = OperatorsFactory.getInstance();
    for (String token : tokens) {
      if (operatorsFactory.isOperator(token) && !operators.contains(token)) {
        return false;
      }
    }

    return true;
  }

  @Override
  public void publish(final String command) {
    String[] tokens = command.split(" ");
    if (canPublish(tokens)) {
      results.add(ExpressionSolver.evaluateExpression(tokens));
    } else {
      results.add(IMPOSSIBLE_EQUATION);
    }
  }

  @Override
  public void subscribe(final String operator) {
    operators.add(operator);
  }

  @Override
  public List<String> getResults() {
    return results;
  }
}
