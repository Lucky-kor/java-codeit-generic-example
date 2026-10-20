package genericmethod;

/** 두 값을 비교해서 더 큰 쪽을 돌려주는 클래스입니다. */
public class GenericComparator {
    // Comparable<T>는 "같은 타입의 값과 비교하는 방법이 있다"는 약속입니다.
    // Integer는 숫자의 크기를, String은 문자열의 순서를 비교할 수 있습니다.
    // T extends Comparable<T>는 이런 약속을 지키는 타입만 받겠다는 뜻입니다.
    // a에서 메서드를 호출하므로 이 예제에는 null이 아닌 값을 넣어 주세요.
    public static <T extends Comparable<T>> T max(T a, T b) {
        // compareTo의 결과: a가 작으면 음수, 같으면 0, 크면 양수입니다.
        // 처음에는 한 줄로 줄이기보다 비교 과정과 반환값을 차례로 읽어 보세요.
        if (a.compareTo(b) >= 0) {
            return a;
        }
        return b;
    }
}
