public class Player extends Enemy {
    private int maxhp, exp, maxExp, level = 1;
    
    public Player () {
        super("2");
        setHP(17);
        maxhp = 17;
        xpos = 4;
        ypos = 7;
        exp = 0;
        maxExp = 10;
    }
    
    public void setDirection(String dir) {
        name = dir;
    }
    
    @Override
    public int getMaxHP() {
        return maxhp;
    }
    
    public int getEXP() {
        return exp;
    }
    
    public void addEXP(int x) {
        exp += x;
    }
    
    public int getMaxEXP() {
        return maxExp;
    }
    
    public int getLevel() {
        return level;
    }
    
    /**
     * Check if leveled up.
     * If so, increase various stats.
     */
    public boolean check() {
        if (exp >= maxExp) {
            level++;
            maxExp *= 1.5;
            exp = 0;
            maxhp *= 1.5;
            setHP(maxhp);
            return true;
        }
        return false;
    }
    
    public void consume(Item item) {
        addHP(item.restore());
        if (getHP() > maxhp) {//HP cannot surpass Max HP
            setHP(maxhp);
        }
    }
}
