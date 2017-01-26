package hexgame;

import java.util.ArrayList;

/**
 *
 * @author Danny Huang
 */
public class DefenseStrategy implements Strategy {
    
    public Move getMove(Player player, Player opponent){
        
        if(checkLethal(player,opponent) && cmpField(player,opponent)<=0){ //if lethal on board and player has less or equal troops than opponent
            Move move = new Move(getCheapest(player),Target.NONE);
            return move;
        }
        else{
            Move move = new Move(getMostDefensive(player),Target.NONE);
            return move;
        }
    }
    
    private boolean checkLethal(Player player, Player opponent){
        int totalAttack = 0;
        
        for(int i = 0; i<opponent.getField().size();i++){
            if(opponent.getField().get(i).getType()=="troop"){
                totalAttack+=((Troop)opponent.getField().get(i)).getAttack();
            }
        }
        
        if(player.getLife()<=totalAttack)
            return true;
        else
            return false;
    }
    
    private int cmpField(Player player, Player opponent){ //negative means player is down x cards on the field, positive means player is up x cards on the field
        return player.getField().size()-opponent.getField().size();
    }
    
    private int getMostDefensive(Player player){ //returns hand index of player with most defensive card; returns -1 if no playable troops
        
        int index = -1;
        int max = 0;
        
        for(int i = 0; i<player.getHand().size();i++){
            if(player.getHand().get(i).playable(player) && player.getHand().get(i).getType() == "troop" && ((Troop)player.getHand().get(i)).getDefense() > max){
                max = ((Troop)player.getHand().get(i)).getDefense();
                index = i;
            }
        }
        
        return index;
    }
    
    private int getCheapest(Player player){
        
        int cheapest = -1;
        int index = -1;
        
        for(int i = 0; i<player.getHand().size();i++){
            if(player.getHand().get(i).playable(player) && player.getHand().get(i).getType() == "troop"){
                if(cheapest < 0){
                    cheapest = ((Troop)player.getHand().get(i)).getCost();
                    index = i;
                }
                else if(player.getHand().get(i).playable(player) && player.getHand().get(i).getCost() < cheapest){
                    cheapest = player.getHand().get(i).getCost();
                    index = i;
                }
            }
        }
        
        return index;
    }
    
    
}