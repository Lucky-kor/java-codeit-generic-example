package beforegenerics;

/** 문자열과 숫자 등을 담을 수 있지만, 꺼낼 때 무엇이 들어 있는지 알아야 하는 바구니입니다. */
public class ObjectBasket {
    private final Object item;

    public ObjectBasket(Object item) {
        this.item = item;
    }
    public Object getItem() {
        return item;
    }
}
