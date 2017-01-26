package hexgame;

/**
 *
 * @author Danny Huang
 */
public class Move{
    
    private int handIndex;  //the card that is played
    private Target target;  //the target of the card played

    public Move(int index, Target target){
        this.handIndex = index;
        this.target = target;
    }
    
    public int getIndex(){
        return handIndex;
    }
    
    public Target getTarget(){
        return target;
    }
}
