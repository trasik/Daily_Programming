package November62021;

import java.util.List;
import java.util.LinkedList;

public class Driver1 {

    // Traverse the list and print each element
    public static void printList(List<Integer> list) {
        for(int element: list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        // Get a random number between 1 and 1000 to add to the list
        for(int i = 0; i < 20; i++) {
            int randomNumber = (int)(Math.random() * 1000) + 1;
            list.add(randomNumber);
        }
        printList(list);
    }
}
