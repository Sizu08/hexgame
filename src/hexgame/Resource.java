package hexgame;

/**
 *
 * @author Danny Huang
 */
public class Resource {
    
    private Shard shard;
    private int count;
    
    public Resource(Shard shard, int count){
        this.shard = shard;
        this.count = count;
    }
    
    public void display(){
        System.out.println(shard+" : "+count);
    }
    
    public int getCount(){
        return count;
    }
    
    public Shard getShard(){
        return shard;
    }
}
