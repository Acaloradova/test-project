import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<GoalTask> goals = new ArrayList();
        User user = new User();
        for (; ; ) {
            System.out.println("Write 1 to Add Goal, 2 to edit goal, 3 to show existed goals, 4 to reach the goal, 7 to set goal not reached 5 to show user, 6 for editing a user, 0 to exit");
            Scanner in = new Scanner(System.in);
            String choice = in.nextLine();
            if (choice.equals("1")) {
                System.out.println("Enter name of a goal");
                String name = in.nextLine();
                System.out.println("Enter Description of a goal");
                String description = in.nextLine();
                if (GoalTask.validateNameSymbols(name) && GoalTask.validateNameSymbols(name) && GoalTask.validateDescriptionLength(description)) {
                    GoalTask goal = GoalTask.addGoal(goals.size(), name, description);
                    goals.add(goal);
                } else System.out.println("name should be 6-20 alphabetical symbols, description should be 10-50");
            } else if (choice.equals("3")) {
                System.out.println("show goals");
                for (int i = 0; i < goals.size(); ++i) {
                    System.out.println(goals.get(i));
                }
            } else if (choice.equals("2")) {
                System.out.println("enter id of a goal");
                int id = in.nextInt();
                goals.get(id).editGoal();
            } else if (choice.equals("4")) {
                System.out.println("enter id of a goal you've reached");
                int id = in.nextInt();
                goals.get(id).reachGoal();
            } else if (choice.equals("5")) {
                System.out.println(user);
            } else if (choice.equals("6")) {
                user.editUser();
            } else if (choice.equals("7")) {
                System.out.println("enter id of a goal you want to set not reached");
                int id = in.nextInt();
                goals.get(id).unreachGoal();
            } else if (choice.equals("0")) {
                System.out.println("Exiting..");
                break;
            } else System.out.println("I didn't catch that");
        }

    }
}
