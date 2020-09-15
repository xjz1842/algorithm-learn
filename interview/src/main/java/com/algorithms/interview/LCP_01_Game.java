package com.algorithms.interview;

public class LCP_01_Game {


    public static int game(int[] guess, int[] answer) {
        int ans = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] guest = new int[]{1, 2, 3};
        int[] ans = new int[]{1, 2, 3};
        System.out.println(game(guest, ans));
    }

}
