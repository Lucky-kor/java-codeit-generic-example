package practice.solution.step4read;

import practice.support.PracticeCheck;
import practice.model.Book;
import practice.model.Notebook;
import practice.model.Product;
import java.util.List;

/** 실행해서 결과를 확인하는 파일입니다. 먼저 같은 폴더의 ProductReader.java를 완성하세요. */
public class Main {
    public static void main(String[] args) {
        // 아래는 확인용 코드입니다. 예상 값을 바꾸지 말고 구현 파일을 수정하세요.
        PracticeCheck.run("책 목록과 공책 목록의 가격을 읽는 도구", () -> {
            List<Book> books = List.of(new Book("자바 첫걸음", 10000), new Book("자바 연습", 12000));
            List<Notebook> notebooks = List.of(new Notebook("줄 공책", 2000));
            PracticeCheck.equal("책 목록 합계", 22000, ProductReader.total(books));
            PracticeCheck.equal("공책 목록 합계", 2000, ProductReader.total(notebooks));
            List<Product> empty = List.of();
            PracticeCheck.equal("빈 목록 합계", 0, ProductReader.total(empty));
            PracticeCheck.equal("책 개수", 2, ProductReader.count(books));
            PracticeCheck.equal("문자열 개수", 3, ProductReader.count(List.of("가", "나", "다")));
            PracticeCheck.equal("빈 목록 개수", 0, ProductReader.count(empty));
            PracticeCheck.equal("읽은 뒤에도 책은 2권", 2, books.size());
            // ProductReader.total(List.of("책")); // 문자열에는 상품 가격이 없습니다.
        });
    }
}
