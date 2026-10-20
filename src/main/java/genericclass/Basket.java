package genericclass;

/** 사용할 때 저장할 값의 타입을 정하는 바구니입니다. */
public class Basket<T> {
    // T는 아직 정하지 않은 타입의 이름입니다.
    // Basket<String>으로 사용하면 String 값을, Basket<Integer>로 사용하면 Integer 값을 다룹니다.
    private T item;

    // 바구니를 만들 때 받은 값을 item에 보관합니다.
    // this.item은 이 객체의 변수이고, 오른쪽 item은 생성자가 받은 값입니다.
    public Basket(T item) {
        this.item = item;
    }

    // 저장한 값을 돌려줍니다. 앞의 T는 돌려줄 값의 타입을 뜻합니다.
    public T getItem() {
        return item;
    }
}
