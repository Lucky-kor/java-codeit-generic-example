package practice.model;

/** 연습에서 판매할 물건입니다. 이름과 가격을 보관하는 코드는 미리 준비했습니다. */
public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }
}
