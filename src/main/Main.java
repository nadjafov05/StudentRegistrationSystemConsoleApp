package main;

import util.InputUtil;
import util.MenuUtil;

public class Main {
    public static void main(String[] args) {
        int menu = 0;
        while (true) {
            menu = InputUtil.requirNumber("What do you want to do?" +
                    "\n 1. Register Stundet" +
                    "\n 2. Show all Student" +
                    "\n 3. Find Student" +
                    "\n 4. Update Student" +
                    "\n 5. Exit");
            MenuUtil.processMenu(menu);
        }
    }
}