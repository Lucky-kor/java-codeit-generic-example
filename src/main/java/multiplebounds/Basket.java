package multiplebounds;

/** Flower를 상속하면서 Plant의 기능도 가진 값만 받는 바구니입니다. */
// extends Flower는 꽃이어야 한다는 조건, & Plant는 성장 기능도 있어야 한다는 조건입니다.
// 클래스 이름인 Flower를 먼저 적고, 인터페이스 이름인 Plant를 & 뒤에 적습니다.
public class Basket<T extends Flower & Plant> {
    private final T item;
    // 객체를 만들 때 전달한 값을 이 객체 안에 저장합니다.
    public Basket(T item) {
        this.item = item;
    }
    // 저장한 값을 꺼냅니다. T는 이 바구니를 사용할 때 정한 타입입니다.
    public T getItem() {
        return item;
    }
    public void describe() {
        // 꽃의 기능 flowerMethod()와 Plant의 기능 grow()를 모두 사용할 수 있습니다.
        System.out.println(item.flowerMethod());
        System.out.println(item.grow());
    }
}
