package genericclass;

/** 정수용 바구니와 문자열용 바구니를 같은 Basket 클래스로 만들어 봅니다. */
public class Main {
    public static void main(String[] args) {
        // <Integer>는 "이 바구니에는 정수를 넣겠습니다"라는 뜻입니다.
        // 오른쪽 <>에는 왼쪽에 적힌 Integer를 다시 쓰지 않아도 됩니다.
        Basket<Integer> numbers = new Basket<>(123);
        Basket<String> words = new Basket<>("Hello");

        // 정수용 바구니이므로 꺼낸 값도 Integer입니다.
        // int 변수에 넣으면 자바가 Integer 안의 숫자를 꺼내 줍니다(언박싱).
        int number = numbers.getItem();
        System.out.println("정수: " + number);

        // 문자열용 바구니에서 꺼낸 값은 String이므로 length()로 글자 수를 구할 수 있습니다.
        System.out.println("문자열 길이: " + words.getItem().length()); // 5

        // 아래 줄은 실행하기 전부터 오류가 납니다. 정수용 바구니에 문자열을 넣었기 때문입니다.
        // Basket<Integer> wrong = new Basket<>("Hello");
        // Basket<int> primitive; // < > 안에는 int 대신 Integer를 씁니다.
    }
}
