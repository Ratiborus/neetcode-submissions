class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String s : strs) {
            builder.append((char)s.length());
            builder.append(s);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        int cur = 0;
        int i = 0;
        char[] buff = null;
        for(char c : str.toCharArray()) {
            if (cur == 0) {
                cur = (int) c;
                if (buff != null) {
                    list.add(new String(buff));
                }
                buff = new char[cur];
                i = 0;
            } else {
                buff[i++] = c;
                cur--;
            }
        }
        if (buff != null) {
            list.add(new String(buff));
        }
        return list;
    }
}
