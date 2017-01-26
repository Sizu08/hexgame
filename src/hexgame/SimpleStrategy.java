package hexgame;

/**
 *
 * @author Danny Huang
 */
public class SimpleStrategy implements Strategy {
    
    public Move getMove(Player player, Player opponent){
        for(int i = 0; i<player.getHand().size();i++){
            if(player.getHand().get(i).playable(player)){ //player.getHand().get(i) refers to the card
                Move move = new Move(i,Target.NONE);
                return move;
            }
        }
        
        System.out.println("No valid moves");
        Move move = new Move(-1,Target.NONE); //cannot find a move returns move with index -1
        return move;
    }
}
