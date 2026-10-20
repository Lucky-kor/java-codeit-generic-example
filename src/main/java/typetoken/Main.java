package typetoken;

/** 값의 타입을 확인하고 꺼내는 것과, 문자열을 숫자로 바꾸는 것을 비교합니다. */
public class Main {
    public static void main(String[] args) {
        // String.class는 "확인할 타입은 String입니다"라는 정보를 전달합니다.
        // String 값을 전달하는 "Hello"와, 타입 정보를 전달하는 String.class를 구분하세요.
        String text = SafeCaster.cast("Hello", String.class);
        Number number = SafeCaster.cast(123, Number.class); // Integer는 Number를 상속하므로 Number로 읽을 수 있습니다.
        System.out.println("문자열: " + text);
        System.out.println("상위 타입으로 읽기: " + number);
        System.out.println("null 허용: " + SafeCaster.cast(null, String.class));
        try {
            SafeCaster.cast("123", Integer.class); // 숫자 모양의 문자열도 Integer 객체가 아닙니다.
        } catch (ClassCastException exception) {
            System.out.println("예상한 오류: " + exception.getMessage());
        }
        System.out.println("문자열 파싱은 별도 작업: " + Integer.parseInt("123"));
    }
}
