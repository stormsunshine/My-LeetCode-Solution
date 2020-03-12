/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        int guess = (high - low) / 2 + low;
        while (low <= high) {
            if (guess(guess) == 0)
                break;
            else if (guess(guess) < 0)
                high = guess - 1;
            else
                low = guess + 1;
            guess = (high - low) / 2 + low;
        }
        return guess;
    }
}