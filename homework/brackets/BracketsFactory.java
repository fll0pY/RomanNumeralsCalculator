package homework.brackets;

import java.util.HashMap;

import homework.interfaces.IToken;
import homework.interfaces.brackets.IBracket;
import homework.interfaces.brackets.IBracketsFactory;

/**
 * Implementation of IBracketsFactory interface as a singleton.
 *
 * @author Alexandru Lincan
 */
public final class BracketsFactory implements IBracketsFactory {
  /**
   * The unique instance of the singleton.
   */
  private static BracketsFactory instance = null;

  /**
   * Map with matching parentheses.
   */
  private static final HashMap<String, String> BRACKETS_MAP;
  static {
    BRACKETS_MAP = new HashMap<String, String>();
    BRACKETS_MAP.put("(", ")");
    BRACKETS_MAP.put("[", "]");
    BRACKETS_MAP.put("{", "}");
  }

  /**
   * Private constructor for the singleton.
   */
  private BracketsFactory() {
  }

  /**
   * Returns the instance of the BracketsFactory singleton.
   *
   * @return the instance of the BracketsFactory
   */
  public static BracketsFactory getInstance() {
    if (instance == null) {
      instance = new BracketsFactory();
    }
    return instance;
  }

  @Override
  public IBracket createBracket(final String token) {
    return new Bracket(token);
  }

  @Override
  public boolean isBracket(final IToken token) {
    if (BRACKETS_MAP.containsKey(token.getSymbol())
        || BRACKETS_MAP.containsValue(token.getSymbol())) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isOpenedBracket(final IBracket bracket) {
    if (BRACKETS_MAP.containsKey(bracket.getSymbol())) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isClosedBracket(final IBracket bracket) {
    if (BRACKETS_MAP.containsValue(bracket.getSymbol())) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isBracketPair(final IBracket openBracket,
      final IBracket closeBracket) {
    if (BRACKETS_MAP.get(openBracket.getSymbol())
        .equals(closeBracket.getSymbol())) {
      return true;
    }
    return false;
  }

  /**
   * Returns true if the given string token is a bracket.
   *
   * @param token
   *          the string token to check
   * @return true if the given string token is a bracket, false otherwise
   */
  public boolean isBracket(final String token) {
    if (BRACKETS_MAP.containsKey(token) || BRACKETS_MAP.containsValue(token)) {
      return true;
    }
    return false;
  }
}
