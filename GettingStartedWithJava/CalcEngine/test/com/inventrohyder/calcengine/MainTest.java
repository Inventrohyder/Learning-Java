package com.inventrohyder.calcengine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MainTest {

    @Nested
    @DisplayName("Addition properties test")
    class AdditionTest {
        private final char opCode = 'a';

        @ParameterizedTest(name = "0 + {0} = {0}")
        @DisplayName("Identity Property: 0 + n = n")
        @ValueSource(doubles = {1.1d, 2.3d, 3.6d, 4.1d, 5d})
        void zeroPlusN(double n) {
            assertEquals(Main.calculate(0, n, opCode), n);
        }

        @ParameterizedTest(name = "-{0} + {0} = 0")
        @DisplayName("Negative Identity: -n + n = 0")
        @ValueSource(doubles = {1.1d, -2.3d, 3.6d, -4.1d, 5d})
        void negativeNPlusN(double n) {
            assertEquals(Main.calculate(-n, n, opCode), 0);
        }

        @ParameterizedTest(name = "{0} + {1} = {1} + {0}")
        @DisplayName("Cumulative Property: x + y = y + x")
        @CsvSource({
                "1d, 2d",
                "3d, 4d",
                "5.2d, 6.7d"
        })
        void cumulativeProperty(double x, double y) {
            assertEquals(
                    Main.calculate(x, y, opCode),
                    Main.calculate(y, x, opCode)
            );
        }

        @ParameterizedTest(name = "({0} + {1}) + {2} = {0} + ({1} + {2})")
        @DisplayName("Associative Property: (x + y) + z = x + (y + z)")
        @CsvSource({
                "1d, 2d, 7.3d",
                "3d, 4d, 2.7d",
                "5.2d, 6.7d, 8.1d"
        })
        void associativeProperty(double x, double y, double z) {
            assertEquals(
                    Main.calculate(Main.calculate(x, y, opCode), z, opCode),
                    Main.calculate(x, Main.calculate(y, z, opCode), opCode)
            );
        }
    }

    @Nested
    @DisplayName("Subtraction properties test")
    class SubtractionTest {
        private final char opCode = 's';

        @ParameterizedTest(name = "{0} - 0 = {0}")
        @DisplayName("Identity Property: n - 0 = n")
        @ValueSource(doubles = {1.1d, 2.3d, 3.6d, 4.1d, 5d})
        void zeroMinusN(double n) {
            assertEquals(Main.calculate(n, 0, opCode), n);
        }

        @ParameterizedTest(name = "{0} - {1} ≠ {1} - {0}")
        @DisplayName("Cumulative Property: x - y ≠ y - x")
        @CsvSource({
                "1d, 2d",
                "3d, 4d",
                "5.2d, 6.7d"
        })
        void cumulativeProperty(double x, double y) {
            assertNotEquals(
                    Main.calculate(x, y, opCode),
                    Main.calculate(y, x, opCode)
            );
        }

        @ParameterizedTest(name = "({0} - {1}) - {2} ≠ {0} - ({1} - {2})")
        @DisplayName("Associative Property: (x - y) - z ≠ x - (y - z)")
        @CsvSource({
                "1d, 2d, 7.3d",
                "3d, 4d, 2.7d",
                "5.2d, 6.7d, 8.1d"
        })
        void associativeProperty(double x, double y, double z) {
            assertNotEquals(
                    Main.calculate(Main.calculate(x, y, opCode), z, opCode),
                    Main.calculate(x, Main.calculate(y, z, opCode), opCode)
            );
        }
    }

    @Nested
    @DisplayName("Multiplication properties test")
    class MultiplicationTest {
        private final char opCode = 'm';

        @ParameterizedTest(name = "{0} ✖ 0 = 0")
        @DisplayName("Zero Identity Property: n ✖ 0 = 0")
        @ValueSource(doubles = {1.1d, 2.3d, 3.6d, 4.1d, 5d})
        void zeroTimesN(double n) {
            assertEquals(Main.calculate(n, 0, opCode), 0);
        }

        @ParameterizedTest(name = "{0} ✖ 1 = {0}")
        @DisplayName("Identity Property: n ✖ 1 = {0}")
        @ValueSource(doubles = {1.1d, 2.3d, 3.6d, 4.1d, 5d})
        void oneTimesN(double n) {
            assertEquals(Main.calculate(n, 1, opCode), n);
        }

        @ParameterizedTest(name = "{0} ✖ {1} = {1} ✖ {0}")
        @DisplayName("Cumulative Property: x ✖ y = y ✖ x")
        @CsvSource({
                "1d, 2d",
                "3d, 4d",
                "5.2d, 6.7d"
        })
        void cumulativeProperty(double x, double y) {
            assertEquals(
                    Main.calculate(x, y, opCode),
                    Main.calculate(y, x, opCode)
            );
        }

        @ParameterizedTest(name = "({0} ✖ {1}) ✖ {2} ≠ {0} ✖ ({1} ✖ {2})")
        @DisplayName("Associative Property: (x ✖ y) ✖ z ≠ x ✖ (y ✖ z)")
        @CsvSource({
                "1d, 2d, 7.3d",
                "3d, 4d, 2.7d",
                "5.2d, 6.7d, 8.1d"
        })
        void associativeProperty(double x, double y, double z) {
            assertEquals(
                    Main.calculate(Main.calculate(x, y, opCode), z, opCode),
                    Main.calculate(x, Main.calculate(y, z, opCode), opCode)
            );
        }
    }

    @Nested
    @DisplayName("Division properties test")
    class DivisionTest {
        private final char opCode = 'd';

        @ParameterizedTest(name = "0 / {0} = 0")
        @DisplayName("Zero Identity Property: 0 / n = 0")
        @ValueSource(doubles = {1.1d, 2.3d, 3.6d, 4.1d, 5d})
        void zeroOfN(double n) {
            assertEquals(Main.calculate(0, n, opCode), 0);
        }

        @ParameterizedTest(name = "{0} / 1 = {0}")
        @DisplayName("Identity Property: n / 1 = {0}")
        @ValueSource(doubles = {1.1d, 2.3d, 3.6d, 4.1d, 5d})
        void oneTimesN(double n) {
            assertEquals(Main.calculate(n, 1, opCode), n);
        }

        @ParameterizedTest(name = "{0} / {0} = 1")
        @DisplayName("Division by itself: n / n = 1")
        @ValueSource(doubles = {1.1d, 2.3d, 3.6d, 4.1d, 5d})
        void divisionByItself(double n) {
            assertEquals(Main.calculate(n, n, opCode), 1);
        }

        @ParameterizedTest(name = "{0} / 0 = Infinity")
        @DisplayName("Division by itself: n / 0 = Infinity")
        @ValueSource(doubles = {1.1d, 2.3d, 3.6d, 4.1d, 5d})
        void divisionByZero(double n) {
            assertEquals(Main.calculate(n, 0, opCode), Double.POSITIVE_INFINITY);
        }
    }

    @Nested
    @DisplayName("Undefined operation")
    class UndefinedOperation {

        @ParameterizedTest
        @DisplayName("Any undefined operation returns 0")
        @ValueSource(chars = {'b', 'c', 'p', 'x', 'z'})
        void undefinedOperation(char opCode) {
            assertEquals(Main.calculate(1, 2, opCode), 0d);
        }
    }

}