package typeparameters;

/** 두 값의 타입을 따로 정하는 바구니입니다. 첫 번째 값은 T, 두 번째 값은 R이라고 부릅니다. */
public class Basket<T, R> {
    // final은 생성자에서 저장한 뒤 다른 값으로 다시 바꾸지 않겠다는 뜻입니다.
    // T와 R을 다르게 정할 수 있으므로 두 변수에 서로 다른 종류의 값을 담을 수 있습니다.
    private final T item;
    private final R label;

    // 객체를 만들 때 전달한 값을 이 객체 안에 저장합니다.
    public Basket(T item, R label) {
        this.item = item;
        this.label = label;
    }

    // 저장한 값을 꺼냅니다. T는 이 바구니를 사용할 때 정한 타입입니다.
    public T getItem() {
        return item;
    }
    public R getLabel() {
        return label;
    }
}
