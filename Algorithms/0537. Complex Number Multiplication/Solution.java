class Solution {
    public String complexNumberMultiply(String a, String b) {
        int aReal = Integer.parseInt(a.substring(0, a.indexOf('+')));
        int aImag = Integer.parseInt(a.substring(a.indexOf('+') + 1, a.indexOf('i')));
        int bReal = Integer.parseInt(b.substring(0, b.indexOf('+')));
        int bImag = Integer.parseInt(b.substring(b.indexOf('+') + 1, b.indexOf('i')));
        int mulReal = aReal * bReal - aImag * bImag;
        int mulImag = aReal * bImag + bReal * aImag;
        return mulReal + "+" + mulImag + "i";
    }
}