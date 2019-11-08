public class Inventory {
    static Item[] inventory;
    final int inventorySize = 8;//Maximum slots allowed on window, modify if window becomes bigger
    int bottom;
    
    public Inventory() {
        inventory = new Item[inventorySize];
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Item("");
        }
        bottom = 0;
    }
    
    public void add(Item item) {
        inventory[bottom] = item;
        bottom++;
        sort(inventory);
    }
    
    public Item get(int index) {
        return inventory[index];
    }
    
    public void kill(int index) {
        inventory[index].kill();
        for (int i = index; i < inventory.length - 1; i++) {
            inventory[i] = inventory[i + 1];
        }
        bottom--;
        sort(inventory);
    }
    
    public int size() {
        return inventorySize;
    }
    
    /**
     * Searches inventory for specified item.
     * Returns -1 if not found, or index if found.
     */
    public int search(String name) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].toString().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    
    public void sort() {
        sort(inventory);
    }
    
    private static void sort(Item[] items) {//Insertion Sort
        Item temp;
        int previousIndex;
        
        for (int i = 1; i < items.length; i++) {
            temp = items[i];
            previousIndex = i - 1;
            while ((items[previousIndex].compareTo(temp) > 0) && (previousIndex > 0)) {
                items[previousIndex + 1] = items[previousIndex];
                previousIndex -= 1;
            }
            if (items[previousIndex].compareTo(temp) > 0) {
                items[previousIndex + 1] = items[previousIndex];
                items[previousIndex] = temp;
            } else {
                items[previousIndex + 1] = temp;
            }
        }
    }
}
