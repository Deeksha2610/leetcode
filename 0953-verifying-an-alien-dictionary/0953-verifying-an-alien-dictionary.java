import java.util.*;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            int j = 0;
            int minLength = Math.min(first.length(), second.length());

            while (j < minLength) {

                if (first.charAt(j) != second.charAt(j)) {

                    int currLetter = orderMap.get(first.charAt(j));
                    int nextLetter = orderMap.get(second.charAt(j));

                    if (currLetter > nextLetter) {
                        return false;
                    }

                    break;
                }

                j++;
            }

            if (j == minLength && first.length() > second.length()) {
                return false;
            }
        }

        return true;
    }
}