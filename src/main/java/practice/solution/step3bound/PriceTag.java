package practice.solution.step3bound;

import practice.model.Product;

/** 상품만 담고 가격을 계산하는 가격표입니다. */
public class PriceTag<T extends Product> {
    // Product에 getPrice()가 있으므로 T로 받은 상품에서도 가격을 읽을 수 있습니다.
    private final T item;

    public PriceTag(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    // 같은 상품을 quantity개 살 때의 가격을 돌려주세요. 0개라면 0원입니다.
    // 연습에서는 null이 아닌 상품과 0 이상의 작은 수량만 사용합니다.
    public int totalPrice(int quantity) {
        return item.getPrice() * quantity;
    }
}
