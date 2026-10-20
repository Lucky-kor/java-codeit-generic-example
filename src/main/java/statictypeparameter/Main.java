package statictypeparameter;

/** 비어 있는 바구니에 값을 넣고, 받은 값을 그대로 돌려주는 메서드도 사용합니다. */
public class Main {
    public static void main(String[] args) {
        Basket<Integer> basket = new Basket<>();
        System.out.println("저장 전: " + basket.getItem()); // null을 출력하는 것은 안전합니다.
        // int missing = basket.getItem(); // 아직 숫자가 없으므로 int로 꺼내려 하면 오류가 납니다.
        basket.setItem(7);
        System.out.println("저장 후: " + basket.getItem());
        System.out.println("독립적인 메서드 타입: " + Basket.identity("Java"));
    }
}
