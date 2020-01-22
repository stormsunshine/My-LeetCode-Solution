class Solution {
    public String fractionAddition(String expression) {
        expression = expression.replaceAll("-", "+-");
        if (expression.charAt(0) == '+')
            expression = expression.substring(1);
        String[] array = expression.split("\\+");
        Rational sum = new Rational(0);
        int length = array.length;
        for (int i = 0; i < length; i++) {
            String rationalStr = array[i];
            int divisionIndex = rationalStr.indexOf('/');
            if (divisionIndex < 0) {
                Rational rational = new Rational(Long.parseLong(rationalStr));
                sum = sum.add(rational);
            } else {
                long numerator = Long.parseLong(rationalStr.substring(0, divisionIndex));
                long denominator = Long.parseLong(rationalStr.substring(divisionIndex + 1));
                Rational rational = new Rational(numerator, denominator);
                sum = sum.add(rational);
            }
        }
        String sumStr = sum.numerator + "/" + sum.denominator;
        return sumStr;
    }
}

class Rational {
    long numerator = 0;
    long denominator = 1;

    public Rational() {
        
    }

    public Rational(long numerator) {
        this(numerator, 1);
    }

    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Rational add(Rational rational2) {
        long newNumerator = this.numerator * rational2.denominator + rational2.numerator * this.denominator;
        long newDenominator = this.denominator * rational2.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational subtract(Rational rational2) {
        long newNumerator = this.numerator * rational2.denominator - rational2.numerator * this.denominator;
        long newDenominator = this.denominator * rational2.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0)
            return 1;
        while (a != 0 && b != 0) {
            if (a > b) {
                long temp = a;
                a = b;
                b = temp;
            }
            b %= a;
        }
        return a == 0 ? b : a;
    }
}