package practice.solution.step3bound;

import practice.support.PracticeCheck;
import practice.model.Book;
import practice.model.Notebook;

/** 실행해서 결과를 확인하는 파일입니다. 먼저 같은 폴더의 PriceTag.java를 완성하세요. */
public class Main {
    public static void main(String[] args) {
        // 아래는 확인용 코드입니다. 예상 값을 바꾸지 말고 구현 파일을 수정하세요.
        PracticeCheck.run("상품만 담고 가격을 계산하는 가격표", () -> {
            Book book = new Book("자바 첫걸음", 10000);
            PriceTag<Book> bookTag = new PriceTag<>(book);
            Book sameBook = bookTag.getItem();
            PracticeCheck.equal("책 꺼내기", book, sameBook);
            PracticeCheck.equal("책 2권 가격", 20000, bookTag.totalPrice(2));
            PracticeCheck.equal("책 0권 가격", 0, bookTag.totalPrice(0));
            PriceTag<Notebook> notebookTag = new PriceTag<>(new Notebook("줄 공책", 2000));
            PracticeCheck.equal("공책 3권 가격", 6000, notebookTag.totalPrice(3));
            // PriceTag<String> wrong = new PriceTag<>("상품 아님"); // String은 Product가 아닙니다.
        });
    }
}
