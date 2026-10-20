package boundedtype;

/** 꽃 바구니와 장미 전용 바구니에 각각 무엇을 넣을 수 있는지 확인합니다. */
public class Main {
    public static void main(String[] args) {
        Basket<Rose> roses = new Basket<>(new Rose());
        roses.describeFlower();
        roses.setItem(new Rose());
        // roses.setItem(new Flower()); // T는 Flower가 아니라 Rose로 결정되어 있습니다.
        Basket<Flower> flowers = new Basket<>(new Rose());
        flowers.setItem(new Flower()); // T가 Flower이면 Flower와 Rose 모두 저장할 수 있습니다.
        System.out.println("교체한 꽃: " + flowers.getItem());
        // Basket<RosePasta> pasta; // RosePasta는 Flower의 하위 타입이 아닙니다.
    }
}
