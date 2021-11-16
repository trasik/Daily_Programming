package November162021;

public class Driver {

    public static SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

    public static void checkIfListContainsRandomNumber() {
        //Generate 100 random numbers
        for(int i = 0; i < 100; i++) {
            int randomNum = (int) Math.round(Math.random() * 100 + 1);
            if(list.contains(randomNum)) {
                System.out.println("Contains: " + randomNum);
            }
        }
        System.out.println();
    }

    public static void addRandomNumbersToTheFrontOfList(int size) {
        for(int i = 0; i < size; i++) {
            int randomNum = (int) Math.round(Math.random() * 100 + 1);
            System.out.println("Added To Front: " + randomNum);
            list.addFirst(randomNum);
        }
        System.out.println();
    }

    public static void addRandomNumbersToTheEndOfList(int size) {
        for(int i = 0; i < size; i++) {
            int randomNum = (int) Math.round(Math.random() * 100 + 1);
            System.out.println("Added To Back: " + randomNum);
            list.add(randomNum);
        }
        System.out.println();
    }

    public static void removeFromTheFrontOfList(int size) {
        for(int i = 0; i < size; i++) {
            SinglyLinkedNode<Integer> removed = list.removeFirst();
            System.out.println("Removed: " + removed.toString());
        }
        System.out.println();
    }

    public static void printListAndProperties() {
        list.printList();
        System.out.println();
        System.out.println("Size: " + list.getSize());
        System.out.println("Empty?: " + list.isEmpty());
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Empty?: " + list.isEmpty());
        System.out.println();

        //Generate random numbers and add to the front of the list
        addRandomNumbersToTheFrontOfList(6);
        printListAndProperties();

        //Remove a certain number of nodes from the front of the list
        removeFromTheFrontOfList(3);
        printListAndProperties();

        //Check if the list contains any of the randomly generated numbers
        checkIfListContainsRandomNumber();

        addRandomNumbersToTheEndOfList(4);
        printListAndProperties();

        //Get Nodes based on a given index
        for(int i = 0; i < list.getSize(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
