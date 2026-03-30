package class3;
import java.util.*;
import class3.role.Member;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Member lion = CreateMember.createLion(scanner);
        Member staff = CreateMember.createStaff(scanner);

        System.out.println(lion.displayInfo());
        System.out.println(staff.displayInfo());

        scanner.close();
    }
}
