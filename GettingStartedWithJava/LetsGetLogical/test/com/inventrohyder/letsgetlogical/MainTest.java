package com.inventrohyder.letsgetlogical;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MainTest {

    @Nested
    @DisplayName("Is Crowded Function")
    class IsCrowded {

        final int threshHold = 30;

        @ParameterizedTest()
        @DisplayName("For Crowded rooms")
        @ValueSource(ints = {
                19, 18, 100, 200, 34, 50, 183
        })
        void trulyCrowded(int students) {

            if (students < 0) {
                students = -students;
            }

            if (students < threshHold) {
                students += threshHold;
            }

            int rooms = students / (threshHold+1);

            assertEquals("Crowded", Main.isCrowded(students, rooms));
        }

        @ParameterizedTest
        @DisplayName("For non-crowded rooms")
        @ValueSource(ints = {
                19, 18, 100, 200, 34, 50, 183
        })
        void notCrowded(int students){
            assertNull(Main.isCrowded(students, Integer.MAX_VALUE));
        }

        @ParameterizedTest
        @DisplayName("For no rooms")
        @ValueSource(ints = {
                19, 18, 100, 200, 34, 50, 183
        })
        void noRooms(int students){
            assertNull(Main.isCrowded(students, 0));
        }
    }
}