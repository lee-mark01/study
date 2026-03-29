// Lion.java
package package3;

// 반복해서 생성될 수 있는 정보의 묶음 Lion 클래스
public class Lion {
    private String name;
    private String major;
    private int year;

    // 생성자(초기화). 여기서 입력 유효성 검증.
    public Lion(String name, String major, int year){

        validateName(name);
        validateMajor(major);
        validateYear(year);

        this.name = name;
        this.major = major;
        this.year = year;
    }

    // 필드 변경 함수. 여기서도 입력 유효성 검증. 반복됨으로 유효성 검증을 위한 validate 함수 만듬.
    public void changeName(String name){
        validateName(name);
        this.name = name;
    }

    public void changeMajor(String major){
        validateMajor(major);
        this.major = major;
    }

    public void changeYear(int year){
        validateYear(year);
        this.year = year;
    }


    private void validateName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
    }

    private void validateMajor(String major){
        if (major == null || major.isBlank()){
            throw new IllegalArgumentException("전공이 비어있습니다.");
        }
    }

    private void validateYear(int year){
        if (year < 1){
            throw new IllegalArgumentException("잘못된 기수정보입니다.");
        }
    }
}
