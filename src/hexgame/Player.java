package hexgame;

import java.util.ArrayList;

/**
 *
 * @author Danny Huang
 */
public class Player{
    
    private String name;    //user name
    private String cname;   //champion name
    private ArrayList<Card> hand;
    private ArrayList<Card> field;
    private ArrayList<Resource> resources;
    private Strategy strategy;
    private int life;
    
    public void displayInfo(){
        
        System.out.println(name+"'s life:"+life);
        System.out.println(name+"'s resources:");
        
        for(int i = 0; i < resources.size(); i++){
            resources.get(i).display();
        }
        System.out.println();
        
        System.out.println(name+"'s hand:");
        for(int i = 0; i< hand.size(); i++){
            
            System.out.println(hand.get(i).getName()+" "+hand.get(i).getInfo());
        }
        System.out.println();
        
        showField();
        
    }
    
    public ArrayList<Card> getField(){
        return field;
    }
    
    public void showField(){
        System.out.println(name+"'s field:");
        for(int i = 0; i< field.size(); i++){
            System.out.println(field.get(i).getName()+" "+field.get(i).getInfo());
        }
        System.out.println();
    }
    
    public void addResource(Shard shard, int num){   //gives player num of Shard resource
        
        Resource resource = new Resource(shard, num);
        resources.add(resource);
    }
    
    public Player(String name, String cname, int life, ArrayList<Card> hand, StrategyType strategyType){
        this.name = name;
        this.cname = cname;
        this.life = life;     
        this.hand = hand;
        
        resources = new ArrayList<Resource>();
        field = new ArrayList<Card>();
        
        switch(strategyType){
            case SIMPLE:
                strategy = new SimpleStrategy();
                break;
            case DEFENSE:
                strategy = new DefenseStrategy();
                break;
        }
    }
    
    public int doMove(Move move){ //returns 0 if move success
        
        Card card = hand.get(move.getIndex());

        if(move.getIndex()<0)
            return -1; //failed move
        
        switch(move.getTarget()){
            case NONE:  //game only accounts for no target cards at the moment
                if(!card.playable(this)){
                    return -1;
                }
                    
                System.out.println("!!!!Played "+hand.get(move.getIndex()).getName()+" onto the field.!!!!");
                System.out.println();
                field.add(hand.get(move.getIndex()));
                hand.remove(move.getIndex());

                break;
            default:
                break;
        }
        
        /*
        if(!playable(card, resources)){
            System.out.println("Cannot play this card");
            return -1;
        }*/
        
        return 0;//successful move
    }
    
    public int bounceCard(int n){
        if(n <= field.size()){
            hand.add(field.get(n));
            field.remove(n);
            return 0;
        }
        else
            return -1;
    }
    
    public int nextMove(Player Opponent){
        Move move = strategy.getMove(this, Opponent);
        if(move.getIndex()<0)
            System.out.println("No valid moves");
        
        return doMove(move);
    }
    
    public ArrayList<Resource> getResources(){
        return resources;
    }
    
    public int getTotalResource(){ //calculates how many resources the player has 
        int count = 0;
        for(int i = 0; i < resources.size();i++){
            count+=resources.get(i).getCount();
        }
        
        return count;
    }
    
    public int getLife(){
        return life;
    }
    
    public void setLife(int n){
        life = n;
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    }
}
