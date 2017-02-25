package homework;

import homework.interfaces.IToken;

/**
 * Implementation of IToken interface.
 *
 * @author Alexandru Lincan
 */
public class Token implements IToken {
  /**
   * The symbol of the token.
   */
  private String symbol;

  /**
   * Default constructor.
   */
  public Token() {
  }

  /**
   * Constructor for initalizing with a symbol.
   *
   * @param sym
   *          the symbol to initialize with
   */
  public Token(final String sym) {
    symbol = sym;
  }

  @Override
  public final String getSymbol() {
    return symbol;
  }

  @Override
  public final void setSymbol(final String newSymbol) {
    symbol = newSymbol;
  }
}
