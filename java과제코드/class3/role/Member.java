package class3.role;
//부모 클래스의 필드는 private으로 유지한다.
// (힌트 : 자식 클래스에서 부모의 private 필드에 직접 접근할 수 없다.
// getter,setter 쓰라는 말.

public abstract class Member {
    private String name;
    private String major;
    private int year;
    private String part;

    public Member(String name, String major, int year, String part){
        this.name = name;
        this.major = major;
        this.year = year;
        this.part = part;
    }

    public String getName(){
        return name;
    }

    public String getMajor(){
        return major;
    }

    public int getYear(){
        return year;
    }

    public String getPart(){
        return part;
    }

    public abstract String getRole();
    public abstract boolean canSubmit();
    public abstract String getSpecificInfo();

    public String displayInfo(){
        return "====결과출력====\n"
                +"역할: " + getRole() + "\n"
                + "이름: " + getName() + " | 전공: " + getMajor() + " | 기수: " + getYear() + " | 파트: " + getPart() + "\n"
                + getSpecificInfo() + "\n"
                + "과제 제출 가능 여부: " + (canSubmit() ? "가능" : "불가능") + "\n";
    }
}
