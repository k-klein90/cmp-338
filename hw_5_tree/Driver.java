package hw_5_tree;

import java.util.ArrayList;
import java.util.Random;

public class Driver {

    private Tree<String> tree;

    private ArrayList<Item<String>> generateListOfTreeItems(){
        ArrayList<Item<String>> treeItems = new ArrayList<>();
        Random random = new Random();
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "abcdefghijklmnopqrstuvwxyz" +
                "0123456789";
        int index;
        for (int i = 0; i < 131_071; i++) { //131,071 = 2^17-1
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < 20; j++) {
                index = random.nextInt(62);
                stringBuilder.append(alphaNumericString.charAt(index));
            }
            String string = stringBuilder.toString();
            treeItems.add(new Item<>(string));
        }
        return treeItems;
    }

    public static void main(String[] args){
        Driver driver = new Driver();
        driver.tree = new Tree<>();

        driver.tree.populateBST(driver.generateListOfTreeItems());
        TreeIterator<String> iterator = new TreeIterator<>(driver.tree);
        System.out.println("Unbalanced tree height: " + driver.tree.getHeight());
        for (int i = 0; i < 10; i++){
            Item<String> item = iterator.next();
            System.out.println( "String: " + item.getValue() +
                    "; key: " + item.getKey());
        }

        driver.tree.balanceBST();
        iterator = new TreeIterator<>(driver.tree);
        System.out.println("Balanced tree height: " + driver.tree.getHeight());
        for (int i = 0; i < 10; i++){
            Item<String> item = iterator.next();
            System.out.println( "String: " + item.getValue() +
                    "; key: " + item.getKey());
        }

        Item<String> testItem = new Item<>("bvXtNi9NN1RfTt1HZD7h");
        System.out.println("Test item: bvXtNi9NN1RfTt1HZD7h");
        driver.tree.insertItem(testItem);
        System.out.println( "Item inserted. Test using findItem(): " +
                driver.tree.findItem(testItem.getKey()).getValue());
        driver.tree.deleteItem(testItem.getKey());
        System.out.print("Item deleted. Test using findItem(): ");
        System.out.println(driver.tree.findItem(testItem.getKey()).getValue()); //an exception should be thrown here
    }

}