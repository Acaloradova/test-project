import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Julik on 20.05.2015.
 */
public class GoalTask {
    private int id;
    private String name;
    private String description;
    private boolean reached;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReached(boolean reached) {
        this.reached = reached;
    }

    static boolean enterGoal(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of a goal");
        String name = in.nextLine();
        System.out.println("Enter Description of a goal");
        String description = in.nextLine();
        if (validateNameSymbols(name)&&validateNameSymbols(name)&&validateDescriptionLength(description)){
            return true;
        }else {
            return false;
        }
    }

    static GoalTask addGoal(int id, String name, String description) {
        GoalTask goal = new GoalTask();
        goal.setId(id);
        goal.setName(name);
        goal.setDescription(description);
        goal.setReached(false);
        return goal;
    }

    public static boolean validateNameLength(String name) {
        if (name.length() < 6 || name.length() > 20) {
            return false;
        }
        return true;
    }

    public static boolean validateNameSymbols(String name) {
        return Pattern.compile("^[а-яА-ЯёЁa-zA-Z\\s]+$").matcher(name).matches();
    }

    public static boolean validateDescriptionLength(String description) {
        if (description.length() < 10 || description.length() > 50) {
            return false;
        }
        return true;
    }

    void editGoal() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of a goal");
        String name = in.nextLine();
        System.out.println("Enter Description of a goal");
        String description = in.nextLine();
        if (GoalTask.validateNameSymbols(name)&&GoalTask.validateNameSymbols(name)&&GoalTask.validateDescriptionLength(description)){
            setName(name);
            setDescription(description);
        } else System.out.println("name should be 6-20 alphabetical symbols, description should be 10-50");

    }

    void reachGoal() {
        setReached(true);
    }

    void unreachGoal() {
        setReached(false);
    }

    public String toString() {
        return "id: " + id + " name: " + name + " description: " + description + " reached: " + reached;
    }
}
