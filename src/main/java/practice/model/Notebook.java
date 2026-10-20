package practice.model;

/** 공책도 상품이므로 Product의 이름과 가격 기능을 물려받습니다. */
public class Notebook extends Product {
    public Notebook(String name, int price) {
        // 부모 클래스의 생성자에 이름과 가격을 전달합니다.
        super(name, price);
    }
}
