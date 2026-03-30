package class3;
import class3.role.Member;
import class3.role.Lion;
import class3.role.Staff;
import java.util.*;

public class CreateMember {
    public static Member createLion(Scanner scanner){
        System.out.println("아기사자 정보 입력");
        System.out.printf("이름: ");
        String lionName = scanner.nextLine();
        System.out.printf("전공: ");
        String lionMajor = scanner.nextLine();
        System.out.printf("기수: ");
        int lionYear = Integer.parseInt(scanner.nextLine());
        System.out.printf("파트 (백엔드/프론트엔드/기획/디자인): ");
        String lionPart = scanner.nextLine();
        System.out.printf("학번: ");
        String id = scanner.nextLine();

        return new Lion(lionName, lionMajor, lionYear, lionPart, id);
    }
    public static Member createStaff(Scanner scanner){
        System.out.println("운영진 정보 입력");
        System.out.printf("이름: ");
        String staffName = scanner.nextLine();
        System.out.printf("전공: ");
        String staffMajor = scanner.nextLine();
        System.out.printf("기수: ");
        int staffYear = Integer.parseInt(scanner.nextLine());
        System.out.printf("파트 (백엔드/프론트엔드/기획/디자인): ");
        String staffPart = scanner.nextLine();
        System.out.printf("직책 (대표/부대표/파트장/멘토): ");
        String staffPosition = scanner.nextLine();

        return new Staff(staffName, staffMajor, staffYear, staffPart, staffPosition);
    }
}
