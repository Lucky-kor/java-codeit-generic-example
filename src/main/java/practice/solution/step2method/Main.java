package practice.solution.step2method;

import practice.support.PracticeCheck;

/** 실행해서 결과를 확인하는 파일입니다. 먼저 같은 폴더의 Choice.java를 완성하세요. */
public class Main {
    public static void main(String[] args) {
        // 아래는 확인용 코드입니다. 예상 값을 바꾸지 말고 구현 파일을 수정하세요.
        PracticeCheck.run("두 값 중 하나를 골라 돌려주는 도구", () -> {
            String greeting = Choice.choose(true, "안녕", "잘 가");
            PracticeCheck.equal("첫 문자열 선택", "안녕", greeting);
            PracticeCheck.equal("둘째 문자열 선택", "잘 가", Choice.choose(false, "안녕", "잘 가"));
            Integer number = Choice.choose(false, 10, 20);
            PracticeCheck.equal("둘째 정수 선택", 20, number);
            PracticeCheck.equal("첫 정수 선택", 10, Choice.choose(true, 10, 20));
        });
    }
}
