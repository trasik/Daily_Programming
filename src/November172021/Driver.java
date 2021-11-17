package November172021;

public class Driver {

    public static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        generateAndAddRandomNumbers(6);
        printListAndProperties();

        checkIfListContainsRandomNumber();
        generateAndAddRandomNumbersToTheFront(4);
        printListAndProperties();

        System.out.println("Removed: " + list.removeFirst());
        printListAndProperties();
        System.out.println("Removed: " + list.remove());
        printListAndProperties();
    }

    private static void printListAndProperties() {
        System.out.println();
        System.out.println(list.toString());
        System.out.println("Empty?: " + list.isEmpty());
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println();
    }

    private static void generateAndAddRandomNumbers(int nums) {
        for(int i = 0; i < nums; i++) {
            int randomNum = (int) Math.round(Math.random() * 100 + 1);
            System.out.println("Added: " + randomNum);
            list.add(randomNum);
        }
    }

    private static void generateAndAddRandomNumbersToTheFront(int nums) {
        for(int i = 0; i < nums; i++) {
            int randomNum = (int) Math.round(Math.random() * 100 + 1);
            System.out.println("Added To Front: " + randomNum);
            list.addFirst(randomNum);
        }
    }

    private static void checkIfListContainsRandomNumber() {
        //Generate 100 random numbers
        for(int i = 0; i < 100; i++) {
            int randomNum = (int) Math.round(Math.random() * 100 + 1);
            if(list.contains(randomNum)) {
                System.out.println("Contains: " + randomNum);
            }
        }
        System.out.println();
    }
}
