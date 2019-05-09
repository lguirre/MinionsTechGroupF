public class Menu {
    public int showmenu() {
        int swValue;
        System.out.println("|   MENU    |");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Add contact       |");
        System.out.println("|        2. Show contacts       |");
        System.out.println("|        3. Search contact           |");
        System.out.println("|        4. Delete contact           |");
        System.out.println("|        5. Exit           |");

        swValue = Keyin.inInt(" Select option: ");
        return swValue;
    }
}
