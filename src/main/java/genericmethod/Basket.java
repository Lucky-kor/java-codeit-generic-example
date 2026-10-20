package genericmethod;

/** 바구니에 저장하는 타입과 메서드가 받는 타입을 따로 정해 봅니다. */
public class Basket<T> {
    private final T item;

    // 객체를 만들 때 전달한 값을 이 객체 안에 저장합니다.
    public Basket(T item) {
        this.item = item;
    }

    // 저장한 값을 꺼냅니다. T는 이 바구니를 사용할 때 정한 타입입니다.
    public T getItem() {
        return item;
    }

    // <E>는 이 메서드 안에서 쓸 타입 이름을 선언합니다.
    // void는 값을 돌려주지 않는다는 뜻입니다. 받은 값을 화면에 출력하기만 합니다.
    // static이므로 바구니 객체를 만들지 않아도 Basket.print(...)로 호출할 수 있습니다.
    public static <E> void print(E element) {
        System.out.println(element);
    }
}
