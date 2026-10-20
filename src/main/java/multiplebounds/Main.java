package multiplebounds;

/** 꽃이면서 성장 기능도 있는 장미를 바구니에 담아 봅니다. */
public class Main {
    public static void main(String[] args) {
        Basket<Rose> roses = new Basket<>(new Rose());
        roses.describe();
        // Basket<Flower> flowers; // Flower는 Plant를 구현하지 않습니다.
        // Basket<RosePasta> pasta; // Plant는 구현하지만 Flower를 상속하지 않습니다.
    }
}
