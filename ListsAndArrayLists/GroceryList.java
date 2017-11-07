package MasterClass.ListsAndArrayLists56;

import java.util.ArrayList;

public class GroceryList {
    private int[] myNumbers = new int[50];
    private ArrayList<String> groceryList = new ArrayList<String>();

    //getters


    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    // adding something to the list
    public void addGroceryItem(String item) {
        groceryList.add(item);

    }

    // printing method for the list
    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if (position >= 0) {
            modifyGroceryItem(position, newItem);

        }
    }

    // modifying the grocery list method
    private void modifyGroceryItem(int pos, String newItem) {
        groceryList.set(pos, newItem);
        System.out.println("Grocery item " + (pos + 1) + " has been modified");
    }

    // remove a string from the list method
    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position >= 0) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int pos) {
        groceryList.remove(pos);
    }

    // finding a string in the arraylist method
    private int findItem(String searchItem) {
        return groceryList.indexOf(searchItem);

    }

    // helper method for findItem  that is private
    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        return position >= 0;
    }
}
//using all of this method in the main class