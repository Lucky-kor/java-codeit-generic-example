package genericmethod;

/** 여러 타입의 값을 출력하고, 두 값 중 더 큰 값을 찾아봅니다. */
public class Main {
    public static void main(String[] args) {
        Basket<String> basket = new Basket<>("바구니의 문자열");
        Basket.<Integer>print(123); // static 메서드는 클래스 이름으로 호출합니다.
        Basket.print(true); // true를 보고 E를 Boolean으로 정합니다. 바구니에 넣는 String과 달라도 됩니다.
        System.out.println("바구니 내용: " + basket.getItem());
        GenericPrinter.printArray(new String[]{"Java", "Generic"});
        GenericPrinter.printArray(new Integer[]{1, 2});
        // GenericPrinter.printArray(new int[]{1, 2}); // 여기서는 int[] 대신 Integer[]를 전달해야 합니다.
        System.out.println("숫자 최댓값: " + GenericComparator.max(10, 20));
        System.out.println("사전식으로 뒤인 문자열: " + GenericComparator.max("hello", "java"));
        // GenericComparator.max(new Object(), new Object()); // Object에는 크기나 순서를 비교하는 compareTo()가 없습니다.
    }
}
