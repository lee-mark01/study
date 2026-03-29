// 전체 로직

package package3;
import java.util.*;

public class Join {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Lion lion = createLion(scanner);
        updateLion(scanner, lion);
    }

    private Lion createLion(Scanner scanner) {
        while (true) {
            try {
                System.out.println("아기사자 이름을 입력해주세요");
                String name = scanner.nextLine();
                System.out.println("아기사자 전공을 입력해주세요");
                String major = scanner.nextLine();
                System.out.println("아기사자 기수를 입력해주세요");
                int year = Integer.parseInt(scanner.nextLine());
                return new Lion(name, major, year);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void updateLion(Scanner scanner, Lion lion) {
        while (true) {
            System.out.println("아기사자 정보를 수정하시겠습니까? (네, 아니요)");
            String answer = scanner.nextLine();
            if (answer.equals("네")) {
                try {
                    // updateField 에서 입출력이 많이 작성되기 때문에 따로 뺌
                    updateField(scanner, lion);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (answer.equals("아니요")) {
                break;
            } else {
                System.out.println("네 또는 아니요로 입력해주세요");
            }
        }
    }

    private void updateField(Scanner scanner, Lion lion) {
        System.out.println("수정할 정보를 입력해주세요. (이름 / 전공 / 기수)");
        String fix = scanner.nextLine();

        if (fix.equals("이름")) {
            System.out.println("변경할 이름을 입력해주세요");
            lion.changeName(scanner.nextLine());
        } else if (fix.equals("전공")) {
            System.out.println("변경할 전공을 입력해주세요");
            lion.changeMajor(scanner.nextLine());
        } else if (fix.equals("기수")) {
            System.out.println("변경할 기수를 입력해주세요");
            lion.changeYear(Integer.parseInt(scanner.nextLine()));
        } else {
            System.out.println("이름, 전공, 기수 중에 입력해주세요");
        }
    }
}

