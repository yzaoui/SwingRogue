public class Enemy extends Entity{
    private int hp, maxhp;
    int xpos, ypos, deaths;
    
    public Enemy(String na) {
        name = na;
        xpos = (int)(Math.random() * Rogue.columns);
        ypos = (int)(Math.random() * Rogue.rows);
        maxhp = 10; hp = maxhp;
        deaths = 0;
    }
    
    public void death() {
        //Geometric series for health upgrade in the form of S = ar^(n-1) (Learned in math class)
        //Skeleton gets 20% more health each death to increase challenge
        deaths++;
        maxhp = (int) (10 * (Math.pow(1.2, (double) deaths)));
        hp = maxhp;
    }
    
    public void setX(int x) { //Set RELATIVE x position
        xpos += x;
    }
    
    public void setXabs(int x) { //Set ABSOLUTE x position
        xpos = x;
    } 
    
    public void setY(int y) { //Set RELATIVE y position
        ypos += y;
    }
    
    public void setYabs(int y) { //Set ABSOLUTE y position
        ypos = y;
    }
    
    public int getX() {
        return xpos;
    }
    
    public int getY() {
        return ypos;
    }
    
    public int getHP() {
        return hp;
    }
    
    public int getMaxHP() {
        return maxhp;
    }
    
    public void setHP(int hp) {
        this.hp = hp;
    }
    
    public void addHP(int hp) {
        this.hp += hp;
    }
}
