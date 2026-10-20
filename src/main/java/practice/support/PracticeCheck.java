package practice.support;

import java.util.Objects;

/** 연습 결과를 알려 주는 도우미입니다. 학생은 이 파일을 수정하지 않아도 됩니다. */
public class PracticeCheck {
    public static void run(String title, Runnable task) {
        System.out.println("=== " + title + " ===");
        try {
            task.run();
            System.out.println("완료: 모든 확인을 통과했습니다.");
        } catch (UnsupportedOperationException exception) {
            System.out.println("아직 연습 중: " + exception.getMessage());
        } catch (AssertionError exception) {
            System.out.println("다시 확인: " + exception.getMessage());
        }
    }

    public static void equal(String description, Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(description + " / 예상: " + expected + " / 실제: " + actual);
        }
        System.out.println("통과: " + description + " → " + actual);
    }
}
