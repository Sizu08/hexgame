package hexgame;

import java.util.ArrayList;

/**
 *
 * @author Danny Huang
 */

public interface Strategy {
    
    public Move getMove(Player player, Player opponent);
    
}
