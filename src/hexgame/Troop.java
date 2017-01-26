package hexgame;

import java.util.ArrayList;

/**
 *
 * @author Danny Huang
 */
public class Troop extends Card{
    
    int attack;
    int defense;
    
    public Troop(String name, int cost, ArrayList<Resource> treshold, Rarity rarity, String set, int number, Shard shard, int attack, int defense){
        super(name,cost,treshold,rarity,set,number, shard, "troop");
        
        this.attack = attack;
        this.defense = defense;
        
    }
    
    public int getAttack(){
        return attack;
    }
    
    public int getDefense(){
        return defense;
    }
    
    public String getInfo(){
        return(String.valueOf(attack)+"/"+String.valueOf(defense));
    }
}
