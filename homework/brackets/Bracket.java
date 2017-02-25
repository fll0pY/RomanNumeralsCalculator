package homework.brackets;

import homework.Token;
import homework.interfaces.brackets.IBracket;

/**
 * Implementation of IBracket interface.
 *
 * @author Alexandru Lincan
 */
public class Bracket extends Token implements IBracket {
  /**
   * Constructor for brackets.
   *
   * @param symbol
   *          the bracket
   */
  public Bracket(final String symbol) {
    super(symbol);
  }
}
