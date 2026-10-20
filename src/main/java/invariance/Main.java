package invariance;

/** 장미는 꽃이지만, 장미 전용 바구니와 여러 꽃을 담는 바구니는 구분해야 합니다. */
public class Main {
    public static void main(String[] args) {
        Basket<Flower> flowers = new Basket<>(new Rose()); // 장미도 꽃이므로 꽃 바구니에 넣을 수 있습니다.
        Basket<Rose> roses = new Basket<>(new Rose());
        flowers.test();
        roses.test();
        // Basket<Flower> wrong = roses; // 장미 전용 바구니를 모든 꽃을 담는 바구니처럼 사용할 수는 없습니다.
        // Basket<Flower> pasta = new Basket<>(new RosePasta()); // 이름이 비슷해도 상속 관계가 없습니다.
        Basket<? extends Flower> readable = roses; // 꽃의 종류를 정확히 몰라도 꽃으로 꺼낼 수 있습니다. ?는 wildcards 예제에서 배웁니다.
        Flower flower = readable.getItem();
        System.out.println("와일드카드로 읽은 꽃: " + flower);
    }
}
