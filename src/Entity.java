abstract class Entity {
    String name;
    
    public Entity() {
        
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object e) {
        Entity testEnt = (Entity)e;
        
        if (testEnt.toString().equalsIgnoreCase(name)) {
            return true;
        } else {
            return false;
        }
    }
}
