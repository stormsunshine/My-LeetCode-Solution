public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        int size = strs.size();
        for (int i = 0; i < size; i++) {
            String str = strs.get(i);
            int length = str.length();
            sb.append(length + "/" + str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<String>();
        StringBuffer sb = new StringBuffer(s);
        while (sb.length() > 0) {
            int index = sb.toString().indexOf('/');
            int length = Integer.parseInt(sb.substring(0, index));
            int endIndex = index + length + 1;
            String str = sb.substring(index + 1, endIndex);
            list.add(str);
            sb.delete(0, endIndex);
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));