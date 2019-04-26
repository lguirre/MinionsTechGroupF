/**
 * Class description.
 *
 * @author Jose Colina
 * @version 1.0.
 */
public class Main {
    public static void main(String [] args){

        ActionsMenu menu = new ActionsMenu();
        String option = "";
        do {
            menu.displayMenu();
            option = menu.readOption();
            menu.runAction(option);
        }
        while (!option.equals("5"));
    }
}
