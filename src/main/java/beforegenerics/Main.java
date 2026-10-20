package beforegenerics;

/** 문자열만 담는 바구니와 여러 종류의 값을 담는 바구니를 비교합니다. */
public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket("김러키");
        System.out.println("문자열 전용 바구니: " + basket.getItem());
        // new Basket(33); // 이 바구니는 문자열만 받으므로 숫자 33을 넣을 수 없습니다.

        ObjectBasket flexible = new ObjectBasket(33);
        int number = (Integer) flexible.getItem(); // 꺼낸 값은 Object로 알려져 있으므로 (Integer)로 정수라고 알려 줍니다.
        System.out.println("Object 바구니에서 꺼낸 정수: " + number);
        // (String)을 적는다고 숫자가 문자열로 바뀌지는 않습니다.
        // "실제 값은 String이다"라고 읽으려 하지만 33이 들어 있으므로 실패합니다.
        try {
            // 저장은 허용되지만 읽는 사람이 타입을 잘못 기억하면 실행 중 실패합니다.
            String text = (String) flexible.getItem();
            System.out.println(text);
        } catch (ClassCastException exception) {
            System.out.println("예상한 오류: Integer를 String으로 변환할 수 없습니다.");
        }
    }
}
