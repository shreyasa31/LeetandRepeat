class Solution {
    public String reverseOnlyLetters(String s) {
        char[] k = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            if (!Character.isLetter(k[i])) {
                i++;
            } else if (!Character.isLetter(k[j])) {
                j--;
            } else {
                char temp = k[i];
                k[i] = k[j];
                k[j] = temp;
                i++;
                j--;
            }

        }
        return new String(k);
    }
}