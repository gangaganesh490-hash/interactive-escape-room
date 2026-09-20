import java.util.ArrayList;

public class Inventory {

    ArrayList<String> items;

    // Constructor
    public Inventory() {

        items = new ArrayList<String>();
    }

    // Add item
    public void addItem(String item) {

        items.add(item);
    }

    // Check item
    public boolean hasItem(String item) {

        return items.contains(item);
    }

    // Get all items
    public String getItems() {

        if (items.size() == 0) {
            return "No items";
        }

        return items.toString();
    }
}