# 자바 제네릭 학습 가이드

제네릭은 **클래스나 메서드를 사용할 때, 다룰 값의 타입을 정하는 방법**입니다. 이 프로젝트에서는 바구니에 정수와 문자열을 담고, 꽃과 휴대전화를 다루면서 제네릭을 연습합니다.

처음부터 모든 용어를 외울 필요는 없습니다. 코드를 실행하고, 값을 바꾸고, 왜 오류가 나는지 하나씩 확인하세요.

## 시작하기 전에

변수, 클래스, 생성자, 메서드, 상속을 먼저 연습하면 이해하기 쉽습니다. 아직 낯선 문법은 해당 기초 예제를 먼저 살펴보세요.

- **타입**: 값의 종류입니다. 여기서는 String, Integer, Flower 같은 이름으로 나타냅니다.
- **컴파일**: 자바 코드를 실행할 수 있는 형태로 바꾸는 과정입니다. 이때 문법과 타입도 검사합니다.
- **컴파일 오류**: 실행하기 전에 코드 검사를 통과하지 못한 것입니다.
- **실행 중 오류(예외)**: 실행은 시작했지만, 값을 꺼내거나 메서드를 호출하는 도중 문제가 생긴 것입니다.
- **try-catch**: 실행 중 생긴 오류를 받아 처리하는 문법입니다. 예제에서는 오류 이유를 출력하는 데 사용합니다.

## 예제 실행 방법

JDK 21을 사용합니다. IntelliJ IDEA에서 다음 순서로 실행하세요.

1. 프로젝트 폴더를 열고 Gradle 프로젝트로 불러옵니다.
2. 프로젝트 SDK와 Gradle JVM을 JDK 21로 설정합니다.
3. 아래 학습 순서에서 원하는 Main.java를 엽니다.
4. main 메서드 왼쪽의 실행 아이콘을 누릅니다.
5. Run 창에서 출력 결과를 확인합니다.

각 폴더를 자바에서는 **패키지**라고 부릅니다. 각 패키지의 Main을 따로 실행할 수 있습니다. Basket.java 같은 파일이 함께 있다면 저장하는 부분과 꺼내는 부분도 읽어 보세요.

터미널이 익숙하다면 프로젝트 폴더에서 다음 명령으로 실행할 수도 있습니다.

```sh
./gradlew clean classes
java -cp build/classes/java/main genericclass.Main
```

`genericclass.Main`을 다른 패키지 이름으로 바꾸면 해당 예제를 실행합니다.

## 권장 학습 순서

1~4단계로 바구니의 사용법을 익히고, 5~10단계에서 사용할 수 있는 타입의 범위를 배웁니다. 11~12단계는 나중에 읽어도 되는 선택 학습입니다. 1~10단계를 읽었다면 [작은 서점 만들기 실습 가이드](PRACTICE.md)에서 TODO 코드 문제를 풀어 보세요.

| 순서 | 학습 파일 | 배우는 내용 |
| --- | --- | --- |
| 1 | [boxing/Main.java](src/main/java/boxing/Main.java) | int와 Integer 알아보기 |
| 2 | [beforegenerics/Main.java](src/main/java/beforegenerics/Main.java) | 제네릭은 왜 필요할까요? |
| 3 | [genericclass/Main.java](src/main/java/genericclass/Main.java) | 저장할 타입을 정하는 바구니 만들기 |
| 4 | [typeparameters/Main.java](src/main/java/typeparameters/Main.java) | 두 값의 타입을 따로 정하기 |
| 5 | [statictypeparameter/Main.java](src/main/java/statictypeparameter/Main.java) | static에서는 T를 어떻게 사용할까요? |
| 6 | [invariance/Main.java](src/main/java/invariance/Main.java) | 장미와 장미 바구니는 구분해서 생각하기 |
| 7 | [boundedtype/Main.java](src/main/java/boundedtype/Main.java) | 꽃만 받을 수 있도록 제한하기 |
| 8 | [multiplebounds/Main.java](src/main/java/multiplebounds/Main.java) | 두 조건을 모두 만족하는 타입 받기 |
| 9 | [genericmethod/Main.java](src/main/java/genericmethod/Main.java) | 메서드에서 사용할 타입 정하기 |
| 10 | [wildcards/Main.java](src/main/java/wildcards/Main.java) | ?로 여러 종류의 사용자 받기 |
| 11 | [typeerasure/Main.java](src/main/java/typeerasure/Main.java) | 선택 학습: 타입을 생략하면 생기는 문제 |
| 12 | [typetoken/Main.java](src/main/java/typetoken/Main.java) | 선택 학습: 실행 중 값의 타입 확인하기 |

## 1. int와 Integer 알아보기

학습 파일: [boxing/Main.java](src/main/java/boxing/Main.java)

### 먼저 이해하기

`int`는 정수를 다루는 기본 타입입니다. `Integer`는 정수를 객체로 다룰 때 사용하는 클래스입니다. 이런 클래스를 **래퍼 클래스**라고 부릅니다.

```java
Integer boxed = 20; // int 값을 Integer로 다룹니다: 오토박싱
int number = boxed; // Integer에서 숫자를 꺼냅니다: 언박싱
```

제네릭의 `< >` 안에는 `int` 대신 `Integer`를 씁니다. 예를 들어 정수 목록은 `List<Integer>`라고 적습니다.

`Integer`에는 `null`도 들어갈 수 있습니다. null은 가리키는 객체가 없다는 뜻이므로 여기서 숫자를 꺼내 int에 넣으려 하면 오류가 납니다.

Integer끼리 `==`로 비교하면 **같은 객체인지** 확인합니다. 숫자 값이 같은지 비교하려면 `equals`를 사용하세요. 자바는 일부 작은 정수의 객체를 재사용하므로 `==`가 우연히 값 비교처럼 보일 수 있습니다.

### 실행하며 확인하기

20을 넣었다가 꺼낸 결과는 20입니다. null에서 숫자를 꺼낼 때는 오류 설명이 출력됩니다. 100의 객체 비교는 true입니다. 200의 객체 비교 결과는 실행 환경에 따라 달라질 수 있지만 값 비교는 true입니다.

### 직접 해보기

`missing`을 null 대신 5로 바꿔 실행하세요. 오류가 사라지는 이유를 설명해 보세요.

## 2. 제네릭은 왜 필요할까요?

학습 파일: [beforegenerics/Main.java](src/main/java/beforegenerics/Main.java)

### 먼저 이해하기

`Basket`은 문자열만 저장하는 바구니입니다. "김러키"는 넣을 수 있지만 숫자 33은 넣을 수 없습니다.

`ObjectBasket`은 더 여러 종류의 값을 받을 수 있습니다. 자바 클래스들의 공통 부모인 `Object`로 값을 저장하기 때문입니다. 하지만 꺼낼 때도 Object로 알려 주므로 정수로 쓰려면 `(Integer)`를 적어야 합니다.

```java
ObjectBasket basket = new ObjectBasket(33);
int number = (Integer) basket.getItem();
```

문제는 실수로 `(String)`을 적어도 실행 전에는 오류를 발견하지 못한다는 점입니다. 실제로 실행해서 정수를 문자열로 읽으려 할 때 실패합니다. 다음 단계의 제네릭은 이런 실수를 실행 전에 발견하도록 도와줍니다.

### 실행하며 확인하기

문자열 바구니의 값과 정수 33을 출력합니다. 그 뒤 잘못된 형변환을 시도하고 오류 이유를 출력합니다. `(String)`을 쓴다고 숫자가 문자열로 바뀌지는 않습니다.

### 직접 해보기

ObjectBasket에 "Java"를 넣고 `(String)`으로 꺼내세요. 같은 값을 `(Integer)`로 꺼내면 어떻게 될지 예상하세요.

## 3. 저장할 타입을 정하는 바구니 만들기

학습 파일: [genericclass/Main.java](src/main/java/genericclass/Main.java)

### 먼저 이해하기

`Basket<T>`의 T는 **나중에 정할 타입의 이름**입니다. 사용할 때 T 자리에 Integer나 String을 적습니다.

```java
Basket<Integer> numbers = new Basket<>(123);
Basket<String> words = new Basket<>("Hello");
```

첫 줄은 정수용 바구니이고, 둘째 줄은 문자열용 바구니입니다. 오른쪽 `<>`에는 왼쪽에 쓴 타입을 반복해서 적지 않아도 됩니다. 자바가 주변 코드를 보고 알아내는 것을 **타입 추론**이라고 합니다.

`Basket.java`의 변수, 생성자, getItem에 모두 T가 쓰였는지 확인하세요. 저장할 값과 꺼낼 값의 타입을 같게 연결하는 역할입니다.

용어로는 T를 **타입 매개변수**, 실제로 적은 Integer를 **타입 인자**라고 합니다. 처음에는 "타입을 적어 둘 자리"와 "그 자리에 정한 타입"으로 이해해도 좋습니다.

### 실행하며 확인하기

123과 Hello의 글자 수인 5를 출력합니다. 꺼낼 때 `(Integer)`나 `(String)`을 직접 적지 않습니다. 정수용 바구니에 "Hello"를 넣는 줄은 실행 전에 오류가 납니다.

### 직접 해보기

`Basket<Double>`에 3.14를 담아 출력하세요. 정수용 바구니에 문자열을 넣는 주석을 한 줄만 해제하고 오류를 확인한 뒤 복구하세요.

## 4. 두 값의 타입을 따로 정하기

학습 파일: [typeparameters/Main.java](src/main/java/typeparameters/Main.java)

### 먼저 이해하기

타입을 정할 자리가 꼭 하나일 필요는 없습니다. `Basket<T, R>`은 두 값의 타입을 따로 정합니다.

```java
Basket<String, Integer> stock = new Basket<>("장미", 3);
```

여기서 T는 String이므로 item에 상품 이름을 넣습니다. R은 Integer이므로 label에 수량을 넣습니다. `getItem()`은 String을, `getLabel()`은 Integer를 돌려줍니다.

T와 R은 자바에 원래 있는 클래스 이름이 아닙니다. 이 클래스에서 타입을 가리키려고 붙인 이름입니다. 첫 번째와 두 번째 자리에 어떤 타입을 적는지 차례대로 읽으세요.

### 실행하며 확인하기

상품 이름 장미와 수량 3을 출력합니다. 다음 바구니는 순서를 바꿔 정수 코드 101과 문자열 위치 꽃 코너를 저장합니다.

### 직접 해보기

`Basket<String, Boolean>`에 상품 이름과 입고 여부 true를 저장하고 둘 다 출력하세요.

## 5. static에서는 T를 어떻게 사용할까요?

학습 파일: [statictypeparameter/Main.java](src/main/java/statictypeparameter/Main.java)

### 먼저 이해하기

먼저 `static`은 **특정 객체 하나가 아니라 클래스에 속한다**는 뜻으로 이해하세요. 바구니를 만들지 않고도 `Basket.identity(...)`를 호출할 수 있습니다.

반면 바구니의 T는 `Basket<Integer>`인지 `Basket<String>`인지에 따라 달라집니다. 모든 바구니가 함께 사용하는 static 변수에는 어느 바구니의 T를 쓸지 정할 수 없습니다. 그래서 `static T` 필드를 만들 수 없습니다.

static 메서드가 자신만의 타입 이름을 선언하는 것은 가능합니다.

```java
public static <E> E identity(E value) {
    return value;
}
```

앞의 `<E>`는 이 메서드에서 E라는 타입 이름을 쓰겠다는 선언입니다. 그 뒤의 E는 돌려줄 값의 타입입니다. 입력도 E, 출력도 E이므로 같은 타입으로 값을 돌려줍니다.

### 실행하며 확인하기

비어 있는 바구니에서는 null이 나옵니다. 7을 저장한 뒤에는 7이 나옵니다. `Basket.identity("Java")`는 받은 문자열을 그대로 돌려줍니다.

### 직접 해보기

`Basket.identity(42)`를 호출해 출력하세요. 비어 있는 바구니의 값을 int 변수에 넣으면 왜 오류가 날까요?

## 6. 장미와 장미 바구니는 구분해서 생각하기

학습 파일: [invariance/Main.java](src/main/java/invariance/Main.java)

### 먼저 이해하기

Rose는 Flower를 상속합니다. 따라서 "장미도 꽃이다"라고 말할 수 있고, 꽃 바구니에 장미를 넣을 수 있습니다.

```java
Basket<Flower> flowers = new Basket<>(new Rose());
```

하지만 `Basket<Rose>`와 `Basket<Flower>`는 같은 용도의 타입이 아닙니다. 하나는 장미만 다루고, 다른 하나는 여러 종류의 꽃을 다룹니다.

```java
Basket<Rose> roses = new Basket<>(new Rose());
// Basket<Flower> flowers = roses; // 허용하지 않습니다.
```

만약 이런 대입을 허용하고 바구니에 값을 넣을 수 있다면, 장미 전용 바구니에 다른 꽃을 넣게 될 수 있습니다. 그래서 자바는 이 두 타입 사이의 대입을 허용하지 않습니다. 이 규칙을 **불공변성**이라고 부릅니다.

마지막의 `? extends Flower`는 "정확한 꽃 종류를 몰라도 꽃으로 꺼내겠다"는 뜻입니다. 자세한 사용법은 10단계에서 배웁니다.

### 실행하며 확인하기

장미를 담은 바구니들이 Rose를 출력합니다. `? extends Flower`로 받은 바구니에서도 Flower 변수로 값을 꺼낼 수 있습니다.

### 직접 해보기

첫 바구니의 `new Rose()`를 `new Flower()`로 바꿔 보세요. 꽃 바구니에 넣는 것과 바구니 자체를 다른 변수에 대입하는 것을 구분해 설명하세요.

## 7. 꽃만 받을 수 있도록 제한하기

학습 파일: [boundedtype/Main.java](src/main/java/boundedtype/Main.java)

### 먼저 이해하기

지금까지의 T에는 여러 종류의 타입을 정할 수 있었습니다. `<T extends Flower>`라고 쓰면 **Flower 또는 Flower를 상속한 클래스만** 받습니다.

```java
public class Basket<T extends Flower>
```

이제 바구니 안의 값은 꽃이라고 알 수 있으므로 Flower의 `flowerMethod()`를 호출할 수 있습니다. 이런 제한을 타입의 **경계**라고 합니다.

`Basket<Rose>`를 만들었다면 그 바구니에는 장미만 넣습니다. 꽃만 받는 조건을 만족한다고 해서 일반 Flower를 장미 전용 바구니에 넣을 수 있는 것은 아닙니다.

### 실행하며 확인하기

꽃 관찰 메시지를 출력합니다. `Basket<Flower>`에는 Flower와 Rose 모두 넣을 수 있습니다. RosePasta는 이름에 Rose가 있어도 꽃을 상속하지 않아 사용할 수 없습니다.

### 직접 해보기

`roses.setItem(new Flower())`의 주석을 해제해 오류를 확인하세요. `flowers.setItem(new Rose())`는 왜 가능한지 비교하세요.

## 8. 두 조건을 모두 만족하는 타입 받기

학습 파일: [multiplebounds/Main.java](src/main/java/multiplebounds/Main.java)

### 먼저 이해하기

`<T extends Flower & Plant>`는 두 조건을 모두 요구합니다.

1. Flower를 상속해서 꽃의 기능을 가져야 합니다.
2. Plant 인터페이스에서 약속한 grow()를 만들어야 합니다.

Rose는 두 조건을 모두 만족합니다. 따라서 바구니 안에서 꽃을 관찰하는 메서드와 성장하는 메서드를 모두 호출할 수 있습니다.

`&`는 여기서 "이 조건도 함께"라는 뜻입니다. 클래스 Flower를 먼저 적고, 인터페이스 Plant를 뒤에 적습니다. 이 선언에서는 인터페이스 앞에도 implements를 쓰지 않습니다.

### 실행하며 확인하기

꽃을 관찰한다는 메시지와 장미가 자란다는 메시지를 출력합니다. Flower만 사용하면 Plant 조건이 부족하고, RosePasta만 사용하면 Flower 조건이 부족합니다. RosePasta는 한 조건만 맞는 경우를 보여주기 위한 연습용 클래스입니다.

### 직접 해보기

`Tulip extends Flower implements Plant` 클래스를 만들고 grow()를 작성하세요. `Basket<Tulip>`에 담아 실행하세요.

## 9. 메서드에서 사용할 타입 정하기

학습 파일: [genericmethod/Main.java](src/main/java/genericmethod/Main.java)

### 먼저 이해하기

클래스 전체가 아니라 메서드 하나에 타입 이름을 선언할 수도 있습니다.

```java
public static <E> void print(E element) {
    System.out.println(element);
}
```

`<E>`는 이 메서드에서 쓸 타입 이름이고, void는 값을 돌려주지 않는다는 뜻입니다. `Basket.print(true)`처럼 호출하면 E는 Boolean으로 정해집니다. 바구니가 String을 저장하는 것과는 별개입니다.

`printArray`는 배열의 값을 하나씩 출력합니다. 정수를 출력할 때는 `int[]` 대신 `Integer[]`를 전달합니다. 이 메서드의 T 자리에는 int를 사용할 수 없기 때문입니다.

`max`는 두 값을 비교합니다. `Comparable<T>`는 같은 타입의 값과 비교할 수 있다는 약속입니다. `compareTo`는 앞의 값이 작으면 음수, 같으면 0, 크면 양수를 돌려줍니다. Integer는 숫자 크기를, String은 문자열의 순서를 비교합니다.

### 실행하며 확인하기

123과 true, 바구니의 문자열, 배열의 각 값을 출력합니다. 10과 20 중 큰 값은 20입니다. hello와 java 중 사전식으로 뒤에 오는 값은 java입니다.

### 직접 해보기

Double 배열에 1.5와 2.5를 넣고 출력하세요. `max(20, 20)`은 어느 쪽 값을 반환하는지 if문을 따라 읽으세요.

## 10. ?로 여러 종류의 사용자 받기

학습 파일: [wildcards/Main.java](src/main/java/wildcards/Main.java)

### 먼저 이해하기

`User<IPhone>`은 아이폰을 보관하는 사용자, `User<Galaxy>`는 갤럭시를 보관하는 사용자입니다. 두 사용자 모두에게 통화 기능을 실행하고 싶다면 어떻게 받을까요?

`?`는 **정확한 타입을 모른다**는 뜻이며, 와일드카드라고 부릅니다.

| 표현 | 쉬운 뜻 | 이 예제에서 할 수 있는 일 |
| --- | --- | --- |
| `User<? extends Phone>` | Phone이나 Phone을 상속한 기기를 담는 사용자 | 꺼낸 기기로 통화하기 |
| `User<? super Galaxy>` | Galaxy, Phone, Object 중 하나를 담는 사용자 | Galaxy나 S25 넣기 |
| `User<?>` | 어떤 타입을 담는지 모르는 사용자 | Object로 꺼내기 |

`extends`로 받은 사용자에게 새 Phone을 넣을 수는 없습니다. 실제 사용자가 아이폰만 담는 `User<IPhone>`일 수도 있기 때문입니다.

`super`는 부모 쪽으로 범위를 정합니다. Galaxy는 Phone이기도 하고 Object이기도 하므로 위 세 사용자 모두에게 넣을 수 있습니다. 하지만 값을 꺼낼 때는 Object로 받아야 합니다. 선언만 봐서는 사용자가 원래 무엇을 담고 있었는지 모르기 때문입니다.

`User<?>`에는 아무 값이나 넣을 수 없습니다. "어떤 값이든 넣는다"가 아니라 "담는 타입이 무엇인지 모른다"는 뜻입니다. 위의 넣기 설명은 null이 아닌 값을 기준으로 합니다. null은 타입 검사상 넣을 수 있지만, 이후 그 값에서 메서드를 호출하면 오류가 납니다.

### 실행하며 확인하기

통화·얼굴 인증·결제를 실행하고 사용자의 기기를 S25로 교체합니다. User<Object>도 갤럭시를 담을 수 있지만, User<IPhone>에는 넣을 수 없습니다.

### 직접 해보기

`User<S25>`를 교체 메서드에 전달할 수 없는 이유를 생각해 보세요. S25만 담는 사용자에게 다른 종류의 Galaxy를 넣어도 될까요?

## 11. 선택 학습: 타입을 생략하면 생기는 문제

학습 파일: [typeerasure/Main.java](src/main/java/typeerasure/Main.java)

### 먼저 이해하기

이 단계부터는 앞의 예제를 충분히 연습한 뒤 읽어도 괜찮습니다.

`List<String>`은 문자열을 담는 목록입니다. `<String>`을 생략하고 `List`라고만 쓰는 것을 **raw type**이라고 부릅니다. 이렇게 쓰면 타입 검사가 느슨해져, 문자열 목록에 숫자를 넣는 실수를 놓칠 수 있습니다.

예제에서는 같은 목록을 words와 raw가 함께 가리킵니다. raw를 통해 숫자를 넣고 words에서 문자열로 꺼내려 하면 실행 중 오류가 납니다.

한편 `ArrayList<String>`과 `ArrayList<Integer>`는 실행 중에 같은 ArrayList 클래스를 사용합니다. 자바가 컴파일할 때 타입을 검사하고 실행용 코드로 바꾸는 과정에서 제네릭 타입을 처리하는 방식을 **타입 소거**라고 부릅니다. 타입마다 ArrayList 클래스를 새로 만드는 것은 아닙니다.

`instanceof List<?>`로 목록인지는 검사할 수 있지만, `instanceof List<String>`처럼 저장할 타입까지 검사할 수는 없습니다. 이것이 모든 타입 설명이 어디에서도 남지 않는다는 뜻은 아닙니다. 지금은 타입을 생략하지 않고 쓰는 습관에 집중하세요.

### 실행하며 확인하기

두 목록이 같은 클래스를 사용하는지 묻는 결과는 true입니다. 숫자를 문자열로 꺼내려 할 때 오류 설명이 출력됩니다.

### 직접 해보기

raw를 `List<?>`로 바꿔 보세요. `add(123)`이 실행 전부터 오류가 되는지 확인하세요. 확인 후 원래 코드로 되돌리세요.

## 12. 선택 학습: 실행 중 값의 타입 확인하기

학습 파일: [typetoken/Main.java](src/main/java/typetoken/Main.java)

### 먼저 이해하기

`String.class`는 문자열 값이 아니라 **String이라는 타입의 정보**입니다. 메서드에 이 정보를 전달하면 어떤 타입인지 확인하는 데 쓸 수 있습니다.

```java
String text = SafeCaster.cast("Hello", String.class);
```

첫 인자는 확인할 값, 둘째 인자는 확인할 타입입니다. SafeCaster 안의 `isInstance`가 값이 그 타입에 맞는지 검사하고, `cast`가 그 타입으로 돌려줍니다. `Class<T>`는 입력으로 받은 타입 정보와 반환 타입 T를 연결합니다. 이런 타입 정보를 타입 토큰이라고 부르기도 합니다.

문자열 "123"은 Integer 객체가 아니므로 Integer로 캐스팅할 수 없습니다. 문자열을 읽어서 숫자로 바꾸고 싶다면 `Integer.parseInt("123")`를 사용합니다.

이 메서드는 null 값을 받으면 그대로 null을 돌려주지만, 확인할 타입 자리에 null을 넣으면 오류를 냅니다. `List.class`를 전달한다고 목록 안의 모든 값이 String인지까지 검사되는 것은 아닙니다.

### 실행하며 확인하기

Hello, 숫자 123, null을 출력합니다. "123"을 Integer로 읽으려는 시도는 실패하고, parseInt로 바꾼 숫자는 123이 됩니다.

### 직접 해보기

Integer 값 123을 Integer.class와 Number.class로 각각 확인하세요. Integer가 Number를 상속하므로 둘 다 가능한지 확인하세요.

## 직접 구현하는 실습

[작은 서점 만들기 실습 가이드](PRACTICE.md)에서 제네릭 클래스·메서드, 제한된 제네릭, 와일드카드를 직접 연습하세요. 단계별 TODO 문제, 힌트, 예상 결과와 정답 확인 방법을 제공합니다.

## 추천하는 연습 방법

1. 코드를 실행하기 전에 출력할 값을 예상합니다.
2. 실제 결과와 비교하고, 다르면 해당 줄의 주석을 읽습니다.
3. 숫자나 문자열을 하나 바꿔 다시 실행합니다.
4. 오류 예제의 주석은 한 줄만 해제합니다. 오류를 확인한 뒤 다시 주석 처리합니다.
5. “이 바구니에는 무엇을 넣을 수 있나?”와 “꺼낸 값은 어떤 타입인가?”를 말로 설명합니다.

## 마지막으로 확인해 보기

1. 정수 바구니를 만들 때 왜 int 대신 Integer를 쓰나요?
2. Object 바구니에서 값을 꺼내는 것과 Basket<Integer>에서 꺼내는 것은 무엇이 다른가요?
3. Basket<T>에서 T는 언제 어떤 타입으로 정하나요?
4. Basket<String, Integer>에서 첫 번째와 두 번째 타입은 각각 어디에 쓰이나요?
5. 바구니에 아직 값을 넣지 않았다면 무엇이 나오나요?
6. 장미를 꽃 바구니에 넣는 것과 장미 바구니를 꽃 바구니 변수에 대입하는 것은 왜 다른가요?
7. T extends Flower는 어떤 값을 받겠다는 뜻인가요?
8. Flower & Plant의 두 조건 중 하나만 만족해도 사용할 수 있나요?
9. 제네릭 메서드의 입력과 반환에 같은 T를 쓰면 어떤 관계가 생기나요?
10. ? extends Phone으로 받은 사용자에게 왜 새 Phone을 넣을 수 없나요?
11. ? super Galaxy로 받은 사용자에게는 무엇을 넣을 수 있나요?
12. 선택 학습: List에서 <String>을 빼면 어떤 실수를 놓칠 수 있나요?
13. 선택 학습: "123"을 Integer로 캐스팅하는 것과 parseInt로 숫자로 바꾸는 것은 어떻게 다른가요?

답하기 어렵다면 관련 예제로 돌아가 값을 바꿔 보세요. 용어를 외우는 것보다 실제 코드를 설명할 수 있는 것이 먼저입니다.
