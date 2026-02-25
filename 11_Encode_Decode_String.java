class Solution {

    public String encode(List<String> strs) {
        StringBuilder strsB = new StringBuilder();
        for (String s: strs) {
            strsB.append(s.length());
            strsB.append('#'); // use this as a delimiter 
            strsB.append(s);
        }
        return strsB.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        System.out.println(str);
        int i = 0; // to keep track of pointer
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j)); // get length of string 
            i = j + 1; // get past the #
            j = i + length; // get j to the end of the string
            result.add(str.substring(i, j));
            i = j; // set j as the new starting point            
        }

        return result;
    }
}
