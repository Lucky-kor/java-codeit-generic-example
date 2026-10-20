package typeparameters;

/** 두 값의 타입을 각각 정한 뒤 저장하고 꺼내 봅니다. */
public class Main {
    public static void main(String[] args) {
        // 첫 번째 타입 String은 상품 이름, 두 번째 타입 Integer는 수량에 적용됩니다.
        Basket<String, Integer> stock = new Basket<>("장미", 3);
        System.out.println("상품: " + stock.getItem() + ", 수량: " + stock.getLabel());
        // 이번에는 순서를 바꿔 정수 코드와 문자열 위치를 저장합니다.
        Basket<Integer, String> code = new Basket<>(101, "꽃 코너");
        System.out.println("코드: " + code.getItem() + ", 위치: " + code.getLabel());
        // Basket<String, Integer> wrong = new Basket<>("장미", "세 개");
    }
}
