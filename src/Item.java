public class Item extends Entity implements Comparable{
    private int restoreValue;
    String[] inv;
    
    public Item(String na) {
        if (!na.equals("")) {
            inv = ItemFile.getValues(na);
            name = inv[0];
            restoreValue = Integer.parseInt(inv[1]);
        } else {
            name = "";
        }
    }
    
    public Item() {
        inv = ItemFile.getValues();
        name = inv[0];
        restoreValue = Integer.parseInt(inv[1]);
    }
    
    public int restore() {
        return restoreValue;
    }
    
    public void kill() {
        name = "";
        restoreValue = 0;
    }
    
    @Override
    public int compareTo(Object o) {
        Item i = (Item)o;
        
        if (this.equals(i)) {
            return 0;
        }
        
        if (this.toString().compareToIgnoreCase(i.toString()) < 0 || i.toString().equals("")) {
            return -1;
        }  else {
            return 1;
        }
    }
}
