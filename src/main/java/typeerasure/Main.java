package typeerasure;

import java.util.ArrayList;
import java.util.List;

/** 조금 더 알아보기: <String>을 생략하면 어떤 문제가 생길까요? */
public class Main {
    public static void main(String[] args) {
        // 저장할 값의 타입은 다르지만, 둘 다 ArrayList 클래스로 만든 목록입니다.
        List<String> words = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        // getClass()는 실행 중인 객체가 어느 클래스로 만들어졌는지 알려줍니다.
        System.out.println("같은 런타임 클래스: " + (words.getClass() == numbers.getClass())); // true

        Object value = words;
        // instanceof는 값이 지정한 타입에 해당하는지 확인합니다.
        // List<?>로 "목록인가?"는 확인할 수 있습니다.
        System.out.println("List<?> 여부: " + (value instanceof List<?>)); // true
        // <String>까지 붙여서 "문자열만 담는 목록인가?"를 이렇게 검사할 수는 없습니다.
        // boolean onlyStrings = value instanceof List<String>;

        demonstrateRawType();
    }

    // 아래 메서드는 잘못된 사용을 일부러 보여줍니다. 실제 코드에서는 따라 쓰지 마세요.
    // @SuppressWarnings는 컴파일러의 경고를 숨기는 표시이지 오류를 고치는 기능이 아닙니다.
    // 이 표시를 잠시 지우면 아래 List와 add 사용에 대한 경고를 확인할 수 있습니다.
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void demonstrateRawType() {
        List<String> words = new ArrayList<>();
        // <String>처럼 저장할 타입을 적지 않은 List를 raw type이라고 부릅니다.
        // 새 목록을 만드는 것이 아니라, words와 같은 목록을 다른 변수로 가리킵니다.
        List raw = words;
        raw.add(123); // 타입 검사가 느슨해져 문자열 목록에 숫자가 들어가 버립니다.

        try {
            // 자바는 words를 문자열 목록으로 알고 있습니다.
            // 하지만 실제 첫 값은 Integer이므로 String으로 꺼내는 순간 오류가 납니다.
            String first = words.get(0);
            System.out.println(first);
        } catch (ClassCastException exception) {
            // 오류를 잡아 이유를 출력합니다. 그래서 프로그램이 갑자기 종료되지 않습니다.
            System.out.println("예상한 오류: raw type으로 저장한 Integer를 String으로 읽을 수 없습니다.");
        }
    }
}
