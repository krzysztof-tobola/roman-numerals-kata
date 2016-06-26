package com.github.tobolak;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Arrays.stream;

public class RomanNumeral {

    private final String numeralString;

    private RomanNumeral(String numeralString) {
        this.numeralString = numeralString;
    }

    public static RomanNumeral romanNumeral(int value) {
        checkArgument(value > 0 && value < 4000);
        return new RomanNumeral(romanString(value));
    }

    private static String romanString(int value) {
        return Segment.biggestNotExceeding(value)
                .map(segment -> segment.name() + romanString(value - segment.value))
                .orElse("");
    }

    @Override
    public String toString() {
        return numeralString;
    }

    private enum Segment {
        M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

        private final int value;

        Segment(int value) {
            this.value = value;
        }

        private static Optional<Segment> biggestNotExceeding(int value) {
            return stream(values()).filter(s -> s.value <= value).findFirst();
        }
    }
}
