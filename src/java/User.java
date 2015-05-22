import java.util.Scanner;

/**
 * Created by Julik on 20.05.2015.
 */
public class User {
    private final String firstName = "Petya";
    private final String lastName = "Fortochkin";
    private String nickName = "Fort";
    private int phoneNumber = 12341212;

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void editUser(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter new nickname");
        String nickname = in.nextLine();
        setNickName(nickname);
        System.out.println("Enter new phone number");
        int phoneNumber = in.nextInt();
        setPhoneNumber(phoneNumber);
    }

    public String toString(){
        return "first name: " + firstName + " last name: " + lastName + " nickname:" + nickName + " phone number: " + phoneNumber;
    }
}
