class Solution {
    public String getHint(String secret, String guess) {
        int length = secret.length();
        int bulls = 0, cows = 0;
        List<Integer> bullsIndices = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                bullsIndices.add(i);
            }
        }
        List<Character> secretList = new ArrayList<Character>();
        List<Character> guessList = new ArrayList<Character>();
        for (int i = 0; i < length; i++) {
            if (bullsIndices.contains(i))
                continue;
            secretList.add(secret.charAt(i));
            guessList.add(guess.charAt(i));
        }
        int size = secretList.size();
        for (int i = size - 1; i >= 0; i--) {
            for (int j = secretList.size() - 1; j >= 0; j--) {
                if (secretList.get(i) == guessList.get(j)) {
                    cows++;
                    secretList.remove(i);
                    guessList.remove(j);
                    break;
                }
            }
        }
        String hint = bulls + "A" + cows + "B";
        return hint;
    }
}