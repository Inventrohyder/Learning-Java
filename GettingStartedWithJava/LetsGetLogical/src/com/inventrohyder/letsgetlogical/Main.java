package com.inventrohyder.letsgetlogical;

public class Main {
    public static void main(String[] args) {
        int students = 150;
        int rooms = 4;

        System.out.println(isCrowded(students, rooms));

        System.out.println("*** End of the Program ***");
    }

    static String isCrowded(int students, int rooms) {
        if(rooms != 0 && students / rooms > 30) {
            return "Crowded";
        }
        return null;
    }
}