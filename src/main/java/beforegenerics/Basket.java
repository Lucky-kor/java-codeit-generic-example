package beforegenerics;

/** 문자열 하나를 보관하는 바구니입니다. */
public class Basket {
    private final String item;

    // 객체를 만들 때 전달한 값을 이 객체 안에 저장합니다.
    public Basket(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
