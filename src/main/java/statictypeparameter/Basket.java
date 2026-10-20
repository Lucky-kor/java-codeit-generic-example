package statictypeparameter;

/** 객체마다 저장하는 값과, 객체 없이 사용하는 static 메서드를 비교합니다. */
public class Basket<T> {
    // 아직 값을 넣지 않았습니다. null은 가리키는 객체가 없다는 뜻입니다.
    private T item;

    // static 변수는 Basket 객체들이 함께 사용합니다.
    // 그런데 어떤 바구니는 Integer, 다른 바구니는 String을 사용합니다.
    // 함께 쓰는 변수에 어느 바구니의 T를 적용할지 정할 수 없으므로 아래 선언은 금지됩니다.
    // private static T sharedItem;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    // 앞의 <E>는 "이 메서드에서 사용할 타입 이름을 E로 정하겠습니다"라는 뜻입니다.
    // 뒤의 E는 돌려줄 값의 타입입니다. 입력과 출력에 같은 E를 쓰므로 둘의 타입이 같습니다.
    // 여기서 E는 바구니의 T와 별개이며, 메서드를 호출할 때 정해집니다.
    public static <E> E identity(E value) {
        return value; // 받은 값을 그대로 돌려줍니다.
    }
}
