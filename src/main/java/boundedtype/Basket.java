package boundedtype;

/** Flower 또는 Flower를 상속한 클래스만 담을 수 있는 꽃 바구니입니다. */
public class Basket<T extends Flower> {
    private T item;
    // 객체를 만들 때 전달한 값을 이 객체 안에 저장합니다.
    public Basket(T item) {
        this.item = item;
    }
    // 저장한 값을 꺼냅니다. T는 이 바구니를 사용할 때 정한 타입입니다.
    public T getItem() {
        return item;
    }
    public void setItem(T item) {
        this.item = item;
    }

    public void describeFlower() {
        // 담긴 값은 꽃이므로 flowerMethod()를 호출할 수 있습니다. 단, null을 넣었다면 오류가 납니다.
        System.out.println(item.flowerMethod());
    }
}
