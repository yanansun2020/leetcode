package algorithm.math;

public class GcdLcm {
    long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
