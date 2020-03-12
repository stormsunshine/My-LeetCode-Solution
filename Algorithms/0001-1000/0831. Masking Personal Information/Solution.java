class Solution {
    public String maskPII(String S) {
        if (S.indexOf('@') >= 0)
            return maskEmailAddress(S);
        else
            return maskPhoneNumber(S);
    }

    public String maskEmailAddress(String email) {
        email = email.toLowerCase();
        int atIndex = email.indexOf('@');
        String name = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);
        String maskedName = name.charAt(0) + "*****" + name.charAt(atIndex - 1);
        String maskedEmail = maskedName + "@" + domain;
        return maskedEmail;
    }

    public String maskPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("\\(", "");
        phoneNumber = phoneNumber.replaceAll("\\)", "");
        phoneNumber = phoneNumber.replaceAll(" ", "");
        phoneNumber = phoneNumber.replaceAll("\\+", "");
        phoneNumber = phoneNumber.replaceAll("-", "");
        int digits = phoneNumber.length();
        String countryCode = phoneNumber.substring(0, digits - 10);
        String lastFourDigits = phoneNumber.substring(digits - 4);
        if (countryCode.length() > 0) {
            countryCode = "+" + countryCode + "-";
            char[] array = countryCode.toCharArray();
            int length = array.length - 1;
            for (int i = 1; i < length; i++)
                array[i] = '*';
            countryCode = new String(array);
        }
        String maskedPhoneNumber = countryCode + "***-***-" + lastFourDigits;
        return maskedPhoneNumber;
    }
}