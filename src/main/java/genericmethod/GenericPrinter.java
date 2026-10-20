package genericmethod;

/** 문자열 배열과 정수 배열을 같은 메서드로 출력합니다. <T>는 사용할 타입의 이름입니다. */
public class GenericPrinter {
    public static <T> void printArray(T[] array) {
        // 배열에서 값을 하나씩 꺼내 element에 담고, 배열이 끝날 때까지 반복합니다.
        for (T element : array) {
            System.out.println("배열 원소: " + element);
        }
    }
}
