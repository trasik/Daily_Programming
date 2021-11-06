package November62021;

import java.util.Set;
import java.util.HashSet;

public class Driver2 {

    //O(n) Time and Space Complexity
    public static int matchColors(int[] arr) {
        //Use HashSet to keep track of elements and their pairs
        Set<Integer> colors = new HashSet<>();
        //Counter to increase when pair is found
        int pairs = 0;
        //Loop through the array of colors
        for(int i = 0; i < arr.length; i++) {
            //If the set doesn't contain the color, then add it to the set
            if(!colors.contains(arr[i])) {
                colors.add(arr[i]);
            } else {
                //else the same color was found in the set, so increase the pairs counter,
                //and remove the other pair that matches
                pairs++;
                colors.remove(arr[i]);
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] colors = {
                10, 20, 20,
                10, 10, 30,
                50, 10, 20
        };

        int[] colors2 = {
                1, 2, 1, 2, 1, 3, 2
        };

        int pairs1 = matchColors(colors);
        System.out.println(pairs1);

        int pairs2 = matchColors(colors2);
        System.out.println(pairs2);
    }
}
