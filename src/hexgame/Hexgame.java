package hexgame;

import java.util.ArrayList;

/**
 *
 * @author Danny Huang
 */
public class Hexgame {
    
    private static ArrayList<Card> createHand(){
        ArrayList<Resource> treshold = new ArrayList<>();
        Resource resource = new Resource(Shard.WILD,1);
        treshold.add(resource);
        Troop troop1 = new Troop("Shin'hare Militia",1,treshold,Rarity.COMMON,"Shards of Fate",324,Shard.WILD,1,2);
        
        treshold = new ArrayList<>();
        resource = new Resource(Shard.WILD,1);
        treshold.add(resource);
        
        Troop troop2 = new Troop("Shin'hare Militia",1,treshold,Rarity.COMMON,"Shards of Fate",324,Shard.WILD,1,2);
        
        treshold = new ArrayList<>();
        resource = new Resource(Shard.WILD,1);
        treshold.add(resource);
        
        Troop troop3 = new Troop("Keeper of the Wounded Petal",1,treshold,Rarity.UNCOMMON,"Shattered Destiny",0,Shard.WILD,1,1);
        
        treshold = new ArrayList<>();
        resource = new Resource(Shard.WILD,1);
        treshold.add(resource);
        Troop troop4 = new Troop("Boulder Brute",5,treshold,Rarity.COMMON,"Shards of Fate",284,Shard.WILD,4,4);
        
        treshold = new ArrayList<>();
        resource = new Resource(Shard.RUBY,2);
        treshold.add(resource);
        Troop troop5 = new Troop("Te'talca, High Cleric",5,treshold,Rarity.TOKEN,"Shards of Fate",0,Shard.RUBY,5,5);
        
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(troop1);
        hand.add(troop2);
        hand.add(troop3);
        hand.add(troop4);
        hand.add(troop5);
        
        return hand;
    }
    
    public static void main(String[] args) {

            ArrayList<Card> hand = createHand();
            Player player = new Player("Player","Fahrny",1,hand,StrategyType.DEFENSE); //player runs defense strategy and life is set to 1
            
            player.addResource(Shard.WILD,10);
            player.displayInfo();
            
            hand = createHand();
            Player opponent = new Player("Opponent","Kishimoto",20,hand,StrategyType.SIMPLE); //opponent runs simple strategy
            
            opponent.addResource(Shard.WILD,3);
            opponent.displayInfo();
            
            opponent.nextMove(player); //simply plays the first playable card
            
            System.out.println("=========CHUMP BLOCKER STRATEGY, WHEN playerfield < opponent field and in lethal range==============");
            
            player.displayInfo();
            opponent.displayInfo();
            
            player.nextMove(opponent); //since player has less cards than opponent on the field and is in lethal range he plays the 
                                       //cheapest card so he can play another cheap card afterwards to "chump block"
            
            
            System.out.println("=========STRONGEST DEFENDER STRATEGY, WHEN playerfield > opponent field and wants to play a defensively strong card==============");

            player.displayInfo();
            
            System.out.println("%%%%Bounce opponent's monster back to hand for demonstration%%%%");
            opponent.bounceCard(0); //returns opponent's troop to hand to demonstrate when player has more troops
            opponent.displayInfo();
            
            player.nextMove(opponent);         
            player.displayInfo();
            
            //this successfully plays the very defensive Boulder Brute and ignores the even more defensiive
            //Te'talca, High Cleric because she is not playable
    }

}
