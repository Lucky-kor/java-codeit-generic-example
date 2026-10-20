package practice.solution.step2method;



/** 두 값 중 하나를 골라 돌려주는 도구입니다. */
public class Choice {
    // <T>는 이 메서드가 쓸 타입 이름입니다. 다음 T는 반환하는 값의 타입입니다.
    // selectFirst가 true이면 first, false이면 second를 돌려주세요.
    public static <T> T choose(boolean selectFirst, T first, T second) {
        if (selectFirst) {
            return first;
        }
        return second;
    }
}
