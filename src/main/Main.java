package main;
import util.InputUtil;
import util.StudentUtil;

public class Main {
    public static void main(String[] args) {
        int menu = 0 ;
        while (true) {
            menu = InputUtil.requirNumber("What do you want to do?" +
                    "\n 1. Register Stundet" +
                    "\n 2. Show all Student" +
                    "\n 3. Find Student" +
                    "\n 4. Update Student");
            if (menu == 1) {
                StudentUtil.registeredStudent();
            } else if (menu == 2) {
                StudentUtil.printAllRegisteredStudents();
            } else if (menu == 3) {
                StudentUtil.findStudentsAndPrint();
            }
        }
    }
}