class Solution {

    public String encode(List<String> strs) {
        var b = new StringBuilder();
        for(String s : strs) {
            b.append(s.length());
            b.append("#");
            b.append(s);
        }
        return b.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        var num = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '#') {
                int l = Integer.parseInt(num.toString()) + i;
                String s = str.substring(i + 1, l + 1);
                list.add(s);
                i = l;
                num = new StringBuilder();
            } else {
                num.append(c);
            }
        }
        return list;
    }
}
