class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String s : strs) {
            int l = s.length();
            builder.append(l);
            builder.append("%");
            builder.append(s);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int c = getSize(0, str);
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '%') {
                list.add(str.substring(i + 1, i + 1 + c));
                i = i + c;
                c = getSize(i + 1, str);
            }
        }
        return list;
    }

    private int getSize(int i, String s) {
        for(int n = i; n < s.length(); n++) {
            if (s.charAt(n) == '%') {
                var num = s.substring(i, n);
                return Integer.parseInt(num);
            }
        }
        return 0;
    }
}
