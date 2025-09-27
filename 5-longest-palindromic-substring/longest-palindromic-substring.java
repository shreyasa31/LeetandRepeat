class Solution {
    public String longestPalindrome(String s) {
    int n = s.length();
    if (n < 2) return s;

    int bestStart = 0, bestLen = 1;

    for (int c = 0; c < n; c++) {
        int len1 = expand(c, c, s);       // odd center
        int len2 = expand(c, c + 1, s);   // even center
        int len = Math.max(len1, len2);
        if (len > bestLen) {
            bestLen = len;
            bestStart = c - (len - 1) / 2;
        }
    }
    return s.substring(bestStart, bestStart + bestLen);
}

private int expand(int i, int j, String s) {
    int l = i, r = j;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
    return r - l - 1;
}

}