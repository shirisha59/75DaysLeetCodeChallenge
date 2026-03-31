class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] word = new char[n + m - 1];

        // Step 1: Initialize with '?'
        for (int i = 0; i < word.length; i++) {
            word[i] = '?';
        }

        // Step 2: Apply 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                    } else {
                        return ""; // conflict
                    }
                }
            }
        }

        // Step 3: Fill remaining with 'a' (smallest lexicographically)
        for (int i = 0; i < word.length; i++) {
            if (word[i] == '?') {
                word[i] = 'a';
            }
        }

        // Step 4: Fix 'F' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                // Check if it matches str2
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // If matches, we must break it
                if (match) {
                    boolean changed = false;

                    // 🔥 IMPORTANT: go RIGHT → LEFT
                    for (int j = m - 1; j >= 0; j--) {
                        int pos = i + j;

                        // Check if changing this breaks any 'T'
                        boolean safe = true;

                        for (int k = Math.max(0, pos - m + 1); k <= Math.min(pos, n - 1); k++) {
                            if (str1.charAt(k) == 'T') {
                                if (word[pos] == str2.charAt(pos - k)) {
                                    safe = false;
                                    break;
                                }
                            }
                        }

                        if (!safe) continue;

                        // Change to smallest possible different char
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != word[pos]) {
                                word[pos] = c;
                                changed = true;
                                break;
                            }
                        }

                        if (changed) break;
                    }

                    // If we couldn't break the match → impossible
                    if (!changed) return "";
                }
            }
        }

        return new String(word);
    }
}