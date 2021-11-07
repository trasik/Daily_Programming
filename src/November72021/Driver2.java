package November72021;

public class Driver2 {

    public static int hurdleRace(int k, int[] height) {
        //Find the tallest hurdle in the array
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            if(height[i] > max) {
                max = height[i];
            }
        }
        //If the current jump height is higher than the tallest hurdle then return 0
        if(k > max) return 0;
        //Return the tallest hurdle - the current jump to get the number of potions to drink
        return max - k;
    }

    public static void main(String[] args) {
        int[] height = {1, 6, 3, 5, 2};
        int jumpHeight = 4;

        int[] height2 = {2, 5, 4, 5, 2};
        int jumpHeight2 = 7;

        System.out.println(hurdleRace(jumpHeight, height));
        System.out.println(hurdleRace(jumpHeight2, height2));
    }
}
