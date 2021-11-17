package November172021;

public class Driver {

    public static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("Empty?: " + list.isEmpty());
        generateAndAddRandomNumbers(10);
        System.out.println("Empty?: " + list.isEmpty());
        System.out.println(list.toString());
        checkIfListContainsRandomNumber();
    }

    private static void generateAndAddRandomNumbers(int nums) {
        for(int i = 0; i < nums; i++) {
            int randomNum = (int) Math.round(Math.random() * 100 + 1);
            System.out.println("Added: " + randomNum);
            list.add(randomNum);
        }
    }

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
}
