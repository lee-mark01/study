## 과제: 객체 지향을 왜 쓰는가?
한마디로 말하면, 변경에 강하고 유지보수하기 쉬운 소프트웨어를 만들기 위해서

### 1. 객체 지향 프로그래밍을 했을 때 장점
- 데이터 관리: 데이터와 함수가 묶여서 관리가 쉽다.
- 코드 재사용성: 상속이나 조합을 통해 코드 재사용성이 높아진다.
- 유지보수: 클래스의 책임이 명확히 나눠져있어서 의존성,결합도가 낮다. 하나를 고쳐도 다른 곳에 영향이 적다.
- 확장성: 새 기능을 추가할 때 기존 코드를 건드리지 않고 새 클래스를 만들어서 끼워넣을 수 있다.

### 2. 객체 지향 프로그래밍의 특징을 말씀해주세요.
- 캡슐화(Encapsulation): 내부 데이터를 숨기고 외부에는 필요한 메서드만 공개하는 것. private int balance로 잔액을 숨기고, deposit(), withdraw() 메서드로만 접근 가능하게 하는 것.
- 상속(Ingeritance): 부모 클래스의 속성과 메서드를 자식이 물려받는 것. 코드 중복을 줄여줌.
- 다형성(Polymorphism): 같은 이름의 메서드가 상황에 따라 다르게 동작하는 것. animal.speak()을 호출하면 Dog는 "멍멍", Cat은 "야옹" 을 반환. 호출하는 쪽은 구체적인 타입을 몰라도 된다는 것.
- 추상화(Abstraction): 복잡한 내부 구현을 감추고 핵심 개념만 드러내는 것. 

### 3. 객체(또는 클래스)가 뭔가요?
클래스는 설계도이다. 마치 붕어빵 틀과 같이 객체(붕어빵)을 만들어낼 수 있다. 클래스는 속성(필드)와 행위(메서드)를 정의한다.
객체(인스턴스)는 그 설계도로 만든 붕어빵이다. new 키워드로 메모리에 생성한 실체이다.
하나의 클래스로 여러 객체를 만들 수 있고, 각 객체는 독립적인 상태를 가진다.

### 4. 객체 지향의 5원칙(SOLID)이란?
- S - Single Responsibility Principle (단일 책임 원칙): 클래스는 하나의 책임만 가져야한다. 너무 많은 일을 하면 수정할 이유가 많아져서 위험해진다. 하나의 클래스는 하나의 수정 이유로만 바뀔 수 있도록 짜자. 아래는 안지킨 경우와 지킨 경우의 예시이다.
```java
// 안지킨 예시. 이메일 발송을 수정할 때 DB저장에 문제가 생길 수도 있다.
class UserService{
    void registerUser(String name); { /*DB저장*/}
    void sendWelcomEmail(String email); {/*이메일 발송*/}
    String generateReport(); {/*유저통계리포트*/}
}
```
```java
class UserSerivice{void register(String name){}};
class EmailService{void sendWelcome(String email){}};
class ReportGenerator{ String generate(){}};
```

- O - Open/Closed Principle (개방-폐쇠 원칙): 확장에는 열려있고, 수정에는 닫혀있어야한다. 새 기능을 추가할 때 기존 코드를 고치지 않고, 새 클래스를 추가하는 방식으로 해결해야한다.
아래는 코드를 수정하는 예시와 확장하는 예시이다.
```java
// 결제 수단을 추가할 때마다 기존 코드를 수정
class PaymentService{
    void pay(String type, int amount){
        if (type.equals("card")){ /*카드결제*/}
        else if (type.equals("kakao")){/*카카오페이*/}
        // 네이버페이를 추가하려면 여기를 또 else if로 고쳐야함
    }
}
```

```java

```

- L - Liskov Substitution Principle (리스코프 치환 원칙): 자식 클래스는 부모 클래스를 대체할 수 있어야한다. Animal 타입 변수에 Dog를 넣어도 프로그램이 정상 동작해야한다. 자식이 부모의 약속(계약)을 깨면 안된다는 원칙)
- I - Interface Segregation Principle (인터페이스 분리원칙): 클라이언트가 자기가 쓰지 않는 메서드에 의존하면 안된다. 거대한 인터페이스 하나보다, 작고 구체적인 인터페이스 여러개가 낫다. "프린터" 인터페이스에 fax() 메서드가 있으면, 팩스 기능이 없는 프린터는 곤란.
- D - Dependency Inversion Princlple (의존 역전 원칙): 구체적인 구현이 아니라 추상화(인터페이스)에 의존하라. 리모컨(인터페이스)을 통해 TV를 조작하는 것처럼, 구체적인 TV 모델에 직접 의존하지않으면 나중에 TV 를 바꾸더라도 리모컨은 안바꿔도 된다.

## 구현 과제
### 1. main에서 유효성 검증 (필드 접근제어자 모두 public)
```java
/* step1(main) 파일
우선 첫번째 올바른 값을 입력한 경우에, 모든 정보를 출력하기 위해서 아래와 같이 작성했다.
다양한 상황으로 에러가 발생해서 터질 수도 있겠지만, 

과제 요구사항은 아래와 같았다.
다음 조건 중 하나라도 만족하지 않으면 Lion 객체를 생성하지 않는다.
이름이 비어 있다.
전공이 비어 있다.
기수가 1 미만이다.

따라서 위와 같은 경우만을 가정하고 유효성 검증을 진행.
가장 먼저 main에서 진행하겠다.
*/
package package1;
import java.util.Scanner;

public class step1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("아기사자 이름을 입력해주세요.");
        String name = scanner.nextLine();

        System.out.println("전공을 입력해주세요.");
        String major = scanner.nextLine();

        System.out.println("기수를 입력해주세요.");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("입력값 검증을 진행합니다.");

        if (name.isEmpty()){
            System.out.println("이름은 비어있을 수 없습니다.");
            return;
        }

        if (major.isEmpty()){
            System.out.println("전공은 비어있을 수 없습니다.");
            return;
        }


        if (year < 1 ) {
            System.out.println("잘못된 정보입니다.");
            return;
        }

        System.out.println("입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");

        Lion lion = new Lion(name, major, year);
        System.out.println("아기사자 객체를 성공적으로 생성하였습니다.");
        System.out.println("아기사자 정보를 출력합니다.");
        System.out.printf("이름: %s |전공: %s |기수: %d", lion.name, lion.major, lion.year);
        return;
    }
}

```

```java
// Lion.java
// 과제에서 출력은 사진과 같이 모두 출력하라면서, 접근제어자는 변경하지 말라길래, 그냥 바꿨다.

package package1;

public class Lion {
    public String name;
    public String major;
    public int year;

    Lion(String name, String major, int year){
        this.name = name;
        this.major = major;
        this.year = year;
    }
}

```
![](https://velog.velcdn.com/images/marklee12/post/c39071d6-84dc-44ce-a363-04f7e5a6ddd8/image.png)|![](https://velog.velcdn.com/images/marklee12/post/86b9e679-a6a7-4c78-907a-064934d4217d/image.png)
---|---|

![](https://velog.velcdn.com/images/marklee12/post/61a5e369-258f-4e6e-b67e-f7c8ea1338ef/image.png)|![](https://velog.velcdn.com/images/marklee12/post/624f3434-d689-4b99-83c0-be19d762352d/image.png)
---|---|


### 2. 검증 로직을 Lion 클래스로 이동

```java
// step2.java

package package1;
import java.util.Scanner;

// 객체 유효성 검증
public class step2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("아기사자 이름을 입력해주세요.");
        String name = scanner.nextLine();

        System.out.println("전공을 입력해주세요.");
        String major = scanner.nextLine();

        System.out.println("기수를 입력해주세요.");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");
        try {
            Lion lion = new Lion(name, major, year);
            System.out.println("아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
            System.out.println("아기사자 정보를 출력합니다.");
            System.out.printf("이름: %s |전공: %s |기수: %d", lion.name, lion.major, lion.year);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("잘못된 아기사자 정보입니다.");
        }
        return;
    }
}
```

```java
// Lion.java
package package1;

public class Lion {
    public String name;
    public String major;
    public int year;

    Lion(String name, String major, int year){

        if (name.isEmpty()){
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }

        if (major.isEmpty()){
            throw new IllegalArgumentException("전공이 비어있습니다.");
        }

        if (year < 1) {
            throw new IllegalArgumentException("잘못된 기수 정보입니다.");
        }

        this.name = name;
        this.major = major;
        this.year = year;
    }
}

```
![](https://velog.velcdn.com/images/marklee12/post/c644e299-def8-4dc5-8443-fb4d84bde1fc/image.png)|![](https://velog.velcdn.com/images/marklee12/post/2a47d168-d9f8-493c-b36a-777bb727239d/image.png)
---|---|

![](https://velog.velcdn.com/images/marklee12/post/ff6dee5a-8292-458f-b6ac-b57723404cdc/image.png)|![](https://velog.velcdn.com/images/marklee12/post/dc915268-b805-40ad-b967-0825622ef030/image.png)
---|---|

### 3. 접근제어자 별 출력
![](https://velog.velcdn.com/images/marklee12/post/9f185513-d786-493e-bb04-53462a8284b7/image.png)|![](https://velog.velcdn.com/images/marklee12/post/fd3aa102-372c-4a23-bba1-5a2b3e7f8ba1/image.png)
---|---|
![](https://velog.velcdn.com/images/marklee12/post/c542dff3-0fe5-4596-b8ee-efe74b9ece5e/image.png)![](https://velog.velcdn.com/images/marklee12/post/10f928ed-d91c-47a5-9e2a-65a41358a830/image.png)

근데 제약사항에서 getter도 쓰지 말라고 했기 때문에 이미지처럼 정보출력은 못함.
