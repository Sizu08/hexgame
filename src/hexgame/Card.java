package hexgame;

import java.util.ArrayList;
/**
 *
 * @author Danny Huang
 */
public class Card {
    
    private String name;
    private int cost;
    private ArrayList<Resource> treshold;
    private Shard shard;
    private Rarity rarity;
    private String set;
    private int number;
    private String type;
    
    public Card(String name, int cost, ArrayList<Resource> treshold, Rarity rarity, String set, int number, Shard shard, String type){
        this.name = name;
        this.cost = cost;
        this.treshold = treshold;
        this.rarity = rarity;
        this.set = set;
        this.number = number;
        this.shard = shard;
        this.type = type;
    }
    
    public Boolean playable(Player player ){ //checks if treshold and cost requirements are met returns true if met
        Boolean success = false;
        
        for(int i = 0; i < getTreshold().size();i++){
            for(int j = 0; j < player.getResources().size();j++){
                if(getTreshold().get(i).getShard() == player.getResources().get(j).getShard()) //find the resource that matchs the treshold requirement
                {
                    if(getTreshold().get(i).getCount() > player.getResources().get(j).getCount()){ //comparing the required count with resource count
                       return false;
                    }
                    else{
                                    
                        success = true;
                        break;
                    }
                }
            }
        }
        
        
        
        if(getCost()>player.getTotalResource()){  //check for enough resources
            return false;
        }
        return success;
    }
    
    public String getName(){
        return name;
    }
    
    public String getInfo(){
        return "";
    }
    
    public int getCost(){
        return cost;
    }
    
    public String getType(){
        return type;
    }
    
    public ArrayList<Resource> getTreshold(){
        return treshold;
    }
    
}
