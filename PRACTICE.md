# 제네릭 실습 가이드: 작은 서점

설명을 이해해도 직접 코드를 쓰려면 막힐 수 있습니다. 이번에는 **한 번에 한두 줄씩 완성**하며 작은 서점에서 사용할 도구를 만들어 봅니다. [README의 1~10단계 예제](README.md)를 읽었다면 시작할 수 있습니다. 선택 학습인 타입 소거와 Class<T>는 몰라도 됩니다.

처음부터 완성된 프로그램을 떠올리려고 하지 마세요. 매 문제에서 다음 세 가지만 먼저 적어 보세요.

1. 무엇을 받나요? 예: 책 한 권, 책 목록, 정수 수량.
2. 무엇을 돌려주나요? 예: 저장한 책, 가격, 개수.
3. 어떤 타입을 허용하나요? 예: 어떤 타입이든, 상품만, 책을 넣을 수 있는 목록만.

## 준비: 어떤 파일을 열어야 하나요?

| 폴더 | 용도 | 학생이 할 일 |
| --- | --- | --- |
| `practice/exercise` | 직접 풀 문제 | TODO가 있는 파일을 수정합니다. |
| `practice/solution` | 정답과 설명 | 먼저 풀어 본 뒤 같은 단계의 파일과 비교합니다. |
| `practice/model` | 상품, 책, 공책 | 이름과 가격을 보관하는 코드입니다. 읽어 보기만 합니다. |
| `practice/support` | 결과 확인 도우미 | 수정하지 않아도 됩니다. |

[Product.java](src/main/java/practice/model/Product.java)는 상품의 이름과 가격을 보관합니다. [Book.java](src/main/java/practice/model/Book.java)는 책, [Notebook.java](src/main/java/practice/model/Notebook.java)는 공책입니다. 책과 공책 모두 Product를 상속하므로 `getName()`과 `getPrice()`를 사용할 수 있습니다.

모든 문제는 처음 상태에서도 컴파일됩니다. 아직 풀지 않은 문제를 실행하면 `아직 연습 중: TODO ...`가 나옵니다. 문제 파일에서 **안내된 throw 한 줄을 지우고 직접 코드를 작성**하세요. 이 줄은 미완성임을 알리는 표시입니다. 정답 코드에 남겨 두지 마세요.

각 단계의 Main을 실행하면 다음처럼 결과를 알려 줍니다.

- `아직 연습 중`: 아직 작성하지 않은 부분이 있습니다.
- `다시 확인`: 작성한 결과와 예상 결과가 다릅니다. 표시된 값을 비교하세요.
- `통과`: 해당 확인을 통과했습니다.
- `완료: 모든 확인을 통과했습니다.`: 그 단계의 모든 확인이 끝났습니다.

예상 값이나 확인 도우미를 바꾸어서 통과시키지 말고 **구현하는 파일을 수정**하세요. 결과 확인은 첫 번째 미완성 또는 잘못된 결과에서 멈춥니다. 그 부분을 고치고 다시 실행하면 다음 확인으로 넘어갑니다. 다른 예외로 실행이 멈춘다면 표시된 오류 줄을 확인하세요.

Main에 있는 `() -> { ... }`는 확인할 코드를 도우미에 전달하는 문법입니다. 이번 실습에서는 고치거나 외우지 않아도 됩니다. 중괄호 안에 있는 보관함 생성과 메서드 호출만 읽으세요.

IntelliJ에서는 **exercise 쪽 Main**을 실행해야 내가 작성한 코드가 실행됩니다. solution 쪽 Main을 실행하면 정답이 실행됩니다. 터미널에서는 다음처럼 실행합니다.

```sh
./gradlew classes
java -cp build/classes/java/main practice.exercise.step1class.Main
```

코드를 수정했다면 다시 컴파일하세요. 아래 단계마다 Main의 전체 이름도 안내합니다. 1~5단계는 서로 독립적이므로 앞 문제를 다 풀지 못해도 다음 문제를 실행할 수 있습니다. 마지막 서점 미션은 1~5단계가 모두 필요합니다.

## 연습 1. 물건 하나를 넣고 꺼내는 보관함

수정할 파일: [exercise/step1class/Locker.java](src/main/java/practice/exercise/step1class/Locker.java)  
실행할 파일: [exercise/step1class/Main.java](src/main/java/practice/exercise/step1class/Main.java)  
실행 이름: `practice.exercise.step1class.Main`

**상황:** 손님에게 줄 문구나 주문 번호를 보관하고 싶습니다. String 전용 클래스와 Integer 전용 클래스를 따로 만들지 않고 `Locker<T>` 하나를 사용합니다.

| 질문 | 이번 문제의 답 |
| --- | --- |
| 무엇을 받나요? | put에서 T 타입의 값 하나를 받습니다. |
| 무엇을 돌려주나요? | get에서 저장한 T 타입의 값을 돌려줍니다. |
| 어떤 타입을 허용하나요? | String, Integer, Book 등 참조 타입을 정할 수 있습니다. |

해야 할 일은 두 가지입니다.

1. `put`에서 전달받은 item을 객체의 item 변수에 저장하세요.
2. `get`에서 저장한 값을 반환하세요.

첫 문제에서는 `Locker<T>`, `put(T item)`, `T get()` 선언을 준비해 두었습니다. 세 곳의 T가 모두 **같은 타입을 가리킨다**는 점부터 확인하세요.

<details>
<summary>힌트 1: 두 item은 어떻게 구분하나요?</summary>

`this.item`은 보관함 객체의 변수이고, 그냥 `item`은 put 메서드가 받은 값입니다. 왼쪽에 저장할 곳, 오른쪽에 받은 값을 적어 대입하세요.

</details>

<details>
<summary>힌트 2: 저장한 값은 어떻게 돌려주나요?</summary>

`return` 뒤에 돌려줄 변수 이름을 적습니다. get에는 별도의 item 매개변수가 없으므로 `item`은 객체에 저장한 값을 뜻합니다.

</details>

**완료 기준:** 저장 전 null, 문자열 저장, 문자열 교체, 정수 7 저장을 모두 확인합니다. 정수용 보관함을 바꿔도 문자열용 보관함의 값은 그대로여야 합니다.

**작은 실험:** Main 마지막의 `numbers.put("일곱")`을 잠시 해제하세요. 실행 전에 타입 오류가 나야 합니다. 확인 후 다시 주석 처리하세요.

<details>
<summary>시도한 뒤 정답 보기</summary>

[solution/step1class/Locker.java](src/main/java/practice/solution/step1class/Locker.java)를 확인하세요. 제네릭이라고 해서 저장 코드가 복잡해지지 않습니다. 타입 이름이 T로 바뀌었을 뿐, 변수에 값을 넣고 꺼내는 방법은 같습니다.

</details>

## 연습 2. 두 값 중 하나를 골라 주는 메서드

수정할 파일: [exercise/step2method/Choice.java](src/main/java/practice/exercise/step2method/Choice.java)  
실행할 파일: [exercise/step2method/Main.java](src/main/java/practice/exercise/step2method/Main.java)  
실행 이름: `practice.exercise.step2method.Main`

**상황:** 손님이 두 인사말이나 두 번호 중 하나를 고릅니다. 문자열과 정수 모두에 사용할 선택 메서드를 만듭니다.

`choose`는 boolean 값과 T 타입 값 두 개를 받습니다. `selectFirst`가 true이면 first를, false이면 second를 돌려주세요. 계산하거나 문자열로 바꾸는 것이 아니라 **받은 값 중 하나를 그대로 반환**하는 문제입니다.

```java
String greeting = Choice.choose(true, "안녕", "잘 가"); // 안녕
Integer number = Choice.choose(false, 10, 20);          // 20
```

`public static <T> T choose(...)`에서 앞의 `<T>`는 메서드가 사용할 타입 이름을 정합니다. 뒤의 T는 돌려줄 값의 타입입니다. 클래스 이름 Choice에는 `<T>`가 없다는 점도 확인하세요.

<details>
<summary>힌트: 제네릭을 잠시 빼고 생각해 보세요</summary>

두 정수 중 하나를 고른다고 생각하면 `if (selectFirst)`일 때 first를 반환하고, 그렇지 않으면 second를 반환하면 됩니다. T라고 해서 if문의 모양이 달라지지는 않습니다.

</details>

**완료 기준:** 첫 문자열 안녕, 둘째 문자열 잘 가, 둘째 정수 20, 첫 정수 10을 반환합니다.

**작은 실험:** 문자열 대신 책 두 권을 전달하고 반환값을 Book 변수에 담아 보세요. Book을 쓰려면 `practice.model.Book`을 import합니다. 이 실습에서는 두 값에 같은 종류를 사용하세요. T를 썼다고 두 값의 실제 클래스가 항상 같도록 강제되는 것은 아닙니다. 서로 다른 종류를 섞으면 자바가 공통 부모 타입을 선택할 수도 있습니다.

<details>
<summary>시도한 뒤 정답 보기</summary>

[solution/step2method/Choice.java](src/main/java/practice/solution/step2method/Choice.java)를 확인하세요. 제네릭 메서드는 입력과 반환에 같은 T를 써서 타입 관계를 유지합니다.

</details>

## 연습 3. 상품 가격을 계산하는 가격표

수정할 파일: [exercise/step3bound/PriceTag.java](src/main/java/practice/exercise/step3bound/PriceTag.java)  
실행할 파일: [exercise/step3bound/Main.java](src/main/java/practice/exercise/step3bound/Main.java)  
실행 이름: `practice.exercise.step3bound.Main`

**상황:** 책이나 공책을 여러 개 살 때의 가격을 계산합니다. 가격을 알 수 없는 문자열은 받지 않으려 합니다.

`PriceTag<T extends Product>`는 상품 또는 상품을 상속한 타입만 받습니다. 생성자와 getItem은 준비되어 있습니다. `totalPrice(int quantity)`에 **상품 하나의 가격 × 수량**을 작성하세요.

이 문제에서는 null이 아닌 상품과 0 이상의 작은 수량만 사용합니다. 할인, 세금, 큰 금액의 범위 초과 처리는 생각하지 않아도 됩니다.

<details>
<summary>힌트: item에서 어떤 메서드를 호출할 수 있나요?</summary>

Product.java에 `getPrice()`가 있습니다. T가 Product이거나 그 자식이라고 제한했으므로 item에서도 그 메서드를 호출할 수 있습니다. 읽은 가격과 quantity를 곱하고 결과를 return하세요.

</details>

**완료 기준:** 책 2권은 20000원, 0권은 0원, 공책 3권은 6000원입니다. getItem으로 꺼낸 책은 Book 변수에 바로 담을 수 있어야 합니다.

**작은 실험:** 선언에서 `extends Product`를 잠시 지워 보세요. T가 무엇인지 모르게 되어 `getPrice()`를 호출할 수 없습니다. 확인한 뒤 되돌리세요. Main의 `PriceTag<String>`도 허용되지 않아야 합니다.

<details>
<summary>시도한 뒤 정답 보기</summary>

[solution/step3bound/PriceTag.java](src/main/java/practice/solution/step3bound/PriceTag.java)를 확인하세요. 제한된 제네릭은 단순히 타입을 막는 기능만 하는 것이 아니라, 그 타입이 가진 메서드를 사용할 수 있게 해 줍니다.

</details>

## 연습 4. 책 목록과 공책 목록을 같은 메서드로 읽기

수정할 파일: [exercise/step4read/ProductReader.java](src/main/java/practice/exercise/step4read/ProductReader.java)  
실행할 파일: [exercise/step4read/Main.java](src/main/java/practice/exercise/step4read/Main.java)  
실행 이름: `practice.exercise.step4read.Main`

**상황:** 손님이 선택한 상품 목록의 가격 합계와 개수를 확인합니다. `List<Book>`과 `List<Notebook>`을 같은 메서드에 전달하고 싶습니다.

여기서는 목록을 새로 만들거나 수정하지 않습니다. 다음 두 메서드를 완성하세요.

1. `total(List<? extends Product> products)`: 각 상품의 가격을 더해 int로 반환합니다. 빈 목록이면 0입니다.
2. `count(List<?> values)`: 목록에 들어 있는 값의 개수를 int로 반환합니다. 문자열 목록도 받을 수 있어야 합니다.

`? extends Product`는 “정확히 책인지 공책인지는 몰라도 상품이다”라는 뜻입니다. `?`만 쓰면 어떤 종류인지 모르지만, 목록의 개수를 세는 데는 문제가 없습니다.

<details>
<summary>힌트 1: 목록을 순서대로 읽는 방법</summary>

다음 반복문은 products에서 상품을 하나씩 꺼내 product라는 변수에 담습니다.

```java
for (Product product : products) {
    // product의 가격을 읽어서 합계에 더하세요.
}
```

</details>

<details>
<summary>힌트 2: 합계와 개수</summary>

반복문 전에 `int sum = 0;`을 만드세요. 반복문 안에서 가격을 더하고, 반복문이 끝난 **다음** sum을 반환합니다. 빈 목록이면 반복문이 실행되지 않아 0이 남습니다. 개수는 목록의 `size()`로 구합니다.

</details>

**완료 기준:** 책 목록 합계 22000원, 공책 목록 합계 2000원, 빈 목록 합계 0원입니다. 책 목록 개수 2, 문자열 목록 개수 3, 빈 목록 개수 0도 확인합니다.

**작은 실험:** total의 `List<? extends Product>`를 잠시 `List<Product>`로 바꿔 보세요. Main에서 List<Book>을 전달하는 부분에 오류가 나는지 확인하고 복구하세요. Book이 Product를 상속해도 List<Book>을 List<Product> 대신 쓸 수는 없습니다.

<details>
<summary>시도한 뒤 정답 보기</summary>

[solution/step4read/ProductReader.java](src/main/java/practice/solution/step4read/ProductReader.java)를 확인하세요. 읽은 값을 돌려줄 필요가 없고 합계만 구하므로, 어떤 상품 종류인지 이름을 붙일 필요 없이 ?로 받을 수 있습니다.

</details>

## 연습 5. 기부할 책을 목록에 추가하기

수정할 파일: [exercise/step5write/BookDonation.java](src/main/java/practice/exercise/step5write/BookDonation.java)  
실행할 파일: [exercise/step5write/Main.java](src/main/java/practice/exercise/step5write/Main.java)  
실행 이름: `practice.exercise.step5write.Main`

**상황:** 기부할 책 한 권을 목록 끝에 넣습니다. 책 목록에도, 여러 상품을 모은 목록에도 넣을 수 있어야 합니다.

`addBook`은 **목록과 책**을 받아서 그 목록에 책을 추가합니다. 반환할 값은 없으므로 void입니다. 새 목록을 만들거나 원래 내용을 지우지 마세요.

`List<? super Book>`은 이 예제에서 List<Book>, List<Product>, List<Object>를 받습니다. 세 목록 모두 Book을 담을 수 있습니다. 반면 List<Notebook>은 공책만 담으므로 받을 수 없습니다.

Main에서 사용하는 ArrayList는 값을 추가할 수 있는 목록입니다. `List.of(...)`로 만든 목록은 add를 할 수 없으니 이 문제의 목적지로 사용하지 마세요. 타입이 맞는 것과 목록을 수정할 수 있는 것은 별개의 조건입니다.

<details>
<summary>힌트: add는 어느 목록에 호출하나요?</summary>

받아 온 목록 변수의 이름은 destination입니다. `destination.add(...)`의 괄호 안에 받은 책 변수를 넣으세요. 한 줄이면 됩니다.

</details>

**완료 기준:** 세 종류의 목록에 같은 책이 추가됩니다. 상품 목록에 먼저 있던 공책도 남아 있어야 합니다.

**작은 실험:** Main 마지막의 List<Notebook> 선언과 addBook 호출 두 줄을 해제하세요. 공책 전용 목록은 받을 수 없어야 합니다. 확인 후 두 줄 모두 다시 주석 처리하세요.

<details>
<summary>시도한 뒤 정답 보기</summary>

[solution/step5write/BookDonation.java](src/main/java/practice/solution/step5write/BookDonation.java)를 확인하세요. ? super Book은 정확한 목록 타입을 몰라도 책을 넣어도 된다는 뜻입니다.

</details>

## 마지막 미션. 내가 만든 도구로 서점 주문 처리하기

수정하고 실행할 파일: [exercise/bookshop/Main.java](src/main/java/practice/exercise/bookshop/Main.java)  
실행 이름: `practice.exercise.bookshop.Main`

1~5단계가 모두 완료되었다면 이번에는 호출하는 코드도 직접 작성해 보세요. 필요한 import는 준비되어 있습니다. TODO 아래의 throw 줄을 지우고 다음 순서대로 작성하세요.

1. Book 두 권을 만듭니다. 첫 책은 이름이 "자바 첫걸음", 가격은 10000입니다. 두 번째 책은 "자바 연습", 가격은 12000입니다.
2. Choice.choose에 false와 책 두 권을 전달해 두 번째 책을 선택합니다. 결과를 Book 변수에 담습니다.
3. Locker<Book>을 만들고 선택한 책을 put한 뒤 get으로 꺼냅니다.
4. 꺼낸 책으로 PriceTag<Book>을 만들고 totalPrice(2)를 호출합니다.
5. `List<Book> donations = new ArrayList<>();`로 빈 기부 목록을 만듭니다.
6. BookDonation.addBook으로 선택한 책을 한 권 넣습니다.
7. 선택한 책 이름, 2권 주문 가격, 기부 목록 가격 합계, 기부한 책 수를 각각 확인합니다.

주문 수량은 2권이지만, 기부 목록에는 1권을 넣습니다. 그래서 두 가격은 다르게 나옵니다.

| 확인할 항목 | 예상 결과 |
| --- | --- |
| 선택한 책 | 자바 연습 |
| 주문 2권 가격 | 24000 |
| 기부 목록 가격 | 12000 |
| 기부한 책 수 | 1 |

결과는 System.out.println으로 출력해 비교해도 좋습니다. 자동으로 비교하려면 다음처럼 준비된 도우미를 호출할 수 있습니다.

```java
// selectedBook은 예시 이름입니다. 자신이 만든 변수 이름에 맞춰 적으세요.
PracticeCheck.equal("선택한 책", "자바 연습", selectedBook.getName());
```

**주의:** 마지막 미션은 확인 코드까지 직접 작성하는 문제입니다. 도우미의 완료 메시지만 보고 끝내지 말고 위 네 결과가 모두 맞는지 확인하세요. PriceTag나 ProductReader의 계산 대신 24000, 12000 같은 정답 숫자를 직접 출력하면 연습을 마친 것이 아닙니다.

<details>
<summary>막히면 사용할 메서드만 먼저 확인하세요</summary>

필요한 메서드는 choose → put/get → totalPrice → addBook → total/count 순서입니다. 각 단계의 Main을 하나씩 참고하세요. 아직 어렵다면 한 번에 다 쓰지 말고, 책을 만들고 이름을 출력하는 것부터 시작하세요.

</details>

<details>
<summary>완성한 뒤 정답과 비교하기</summary>

[solution/bookshop/Main.java](src/main/java/practice/solution/bookshop/Main.java)를 확인하세요. solution 쪽 도구를 사용하는 코드이므로 파일 전체를 exercise에 복사하지 마세요. 내가 작성한 메서드를 호출하는지, import가 exercise 쪽인지도 확인하세요.

</details>

## 두 번째 연습: 타입 선언도 직접 쓰기

첫 번째 연습은 선언을 읽고 메서드 안을 완성하는 연습이었습니다. 이제 파일을 새로 만들지 않아도 됩니다. 작성한 파일을 복사해 별도로 보관한 뒤, **한 파일씩 선언과 본문을 지우고** 아래 요구만 보고 다시 작성해 보세요. 기존 Main을 수정하지 않고 컴파일하고 실행하는 것이 목표입니다. 선언을 지운 동안 빨간 줄이 나오는 것은 자연스럽습니다.

| 만들 것 | 선언을 고르는 질문 |
| --- | --- |
| Locker | 객체 안에 같은 타입을 저장하고 꺼내나요? 클래스에 T를 선언합니다. |
| Choice.choose | 이 메서드에서만 입력과 반환 타입을 연결하나요? 메서드에 T를 선언합니다. |
| PriceTag | 받은 값의 getPrice()를 사용해야 하나요? T를 Product로 제한합니다. |
| ProductReader.total | 여러 종류의 상품 목록을 읽기만 하나요? ? extends Product를 사용합니다. |
| ProductReader.count | 값의 종류를 몰라도 개수를 셀 수 있나요? ?를 사용합니다. |
| BookDonation.addBook | 책을 넣을 수 있는 목록이 필요한가요? ? super Book을 사용합니다. |

첫 파일부터 어렵다면 선언을 통째로 지우지 말고 `<T>`가 들어가는 위치만 종이에 가려 보세요. 떠올린 선언을 적은 뒤 원래 코드와 비교하고, 점점 가리는 부분을 늘리면 됩니다.

## 조금 바꿔서 혼자 풀어 보기

마지막으로 정답 파일 없이 다음 두 가지를 해 보세요.

- 서점 미션에서 choose의 첫 인자를 true로 바꾸세요. 선택한 책은 자바 첫걸음, 주문 2권은 20000원, 기부 목록은 10000원이 되어야 합니다. equal로 확인했다면 예상 값도 이 요구에 맞게 바꾸세요.
- BookDonation을 참고해 `NotebookDonation` 클래스를 같은 exercise.step5write 폴더에 만드세요. `addNotebook`은 공책을 받아 공책 목록과 상품 목록에 넣어야 합니다. 책 전용 목록에는 넣을 수 없어야 합니다. 목록을 받는 타입의 이름도 Book에서 Notebook으로 바꿔 생각하세요.

출력 결과뿐 아니라 **잘못된 타입은 컴파일되지 않는지**까지 확인했다면, 제네릭을 직접 구현하는 중요한 연습을 마친 것입니다.

[개념 학습 가이드로 돌아가기](README.md)
