package practice.solution.step1class;

import practice.support.PracticeCheck;

/** 실행해서 결과를 확인하는 파일입니다. 먼저 같은 폴더의 Locker.java를 완성하세요. */
public class Main {
    public static void main(String[] args) {
        // 아래는 확인용 코드입니다. 예상 값을 바꾸지 말고 구현 파일을 수정하세요.
        PracticeCheck.run("물건 하나를 보관하는 보관함", () -> {
            Locker<String> words = new Locker<>();
            PracticeCheck.equal("저장 전에는 null", null, words.get());
            words.put("안녕하세요");
            PracticeCheck.equal("문자열 꺼내기", "안녕하세요", words.get());
            words.put("반가워요");
            PracticeCheck.equal("값 바꾸기", "반가워요", words.get());

            Locker<Integer> numbers = new Locker<>();
            numbers.put(7);
            Integer number = numbers.get(); // (Integer)라고 직접 변환하지 않아도 되어야 합니다.
            PracticeCheck.equal("정수 꺼내기", 7, number);
            PracticeCheck.equal("서로 다른 보관함", "반가워요", words.get());
            // numbers.put("일곱"); // 정수 보관함에는 문자열을 넣을 수 없어야 합니다.
        });
    }
}
