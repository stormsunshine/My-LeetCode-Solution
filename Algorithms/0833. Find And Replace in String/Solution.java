class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int length = indexes.length;
        boolean[] occurs = new boolean[length];
        for (int i = 0; i < length; i++) {
            int index = indexes[i];
            String source = sources[i];
            int curLength = source.length();
            occurs[i] = S.substring(index, index + curLength).equals(source);
        }
        IndexSourceTargetOccur[] array = new IndexSourceTargetOccur[length];
        for (int i = 0; i < length; i++)
            array[i] = new IndexSourceTargetOccur(indexes[i], sources[i], targets[i], occurs[i]);
        Arrays.sort(array);
        StringBuffer sb = new StringBuffer(S);
        for (int i = length - 1; i >= 0; i--) {
            IndexSourceTargetOccur indexSourceTargetOccur = array[i];
            if (indexSourceTargetOccur.occur) {
                int index = indexSourceTargetOccur.index;
                String source = indexSourceTargetOccur.source;
                String target = indexSourceTargetOccur.target;
                sb.delete(index, index + source.length());
                sb.insert(index, target);
            }
        }
        return sb.toString();
    }
}

class IndexSourceTargetOccur implements Comparable<IndexSourceTargetOccur> {
    int index;
    String source;
    String target;
    boolean occur;

    public IndexSourceTargetOccur(int index, String source, String target, boolean occur) {
        this.index = index;
        this.source = source;
        this.target = target;
        this.occur = occur;
    }

    public int compareTo(IndexSourceTargetOccur indexSourceTargetOccur2) {
        return this.index - indexSourceTargetOccur2.index;
    }
}