package invariance;

/** T로 정한 타입의 값을 하나 보관하는 바구니입니다. */
public class Basket<T> {
    private T item;

    // 객체를 만들 때 전달한 값을 이 객체 안에 저장합니다.
    public Basket(T item) {
        this.item = item;
    }

    // 저장한 값을 꺼냅니다. T는 이 바구니를 사용할 때 정한 타입입니다.
    public T getItem() {
        return item;
    }

    public void test() {
        System.out.println(item);
    }
}
