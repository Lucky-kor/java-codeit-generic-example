package practice.solution.bookshop;

import practice.solution.step1class.Locker;
import practice.solution.step2method.Choice;
import practice.solution.step3bound.PriceTag;
import practice.solution.step4read.ProductReader;
import practice.solution.step5write.BookDonation;
import practice.model.Book;
import practice.support.PracticeCheck;
import java.util.ArrayList;
import java.util.List;

/** 1~5단계를 마친 뒤, 직접 만든 도구를 함께 사용하는 마지막 미션입니다. */
public class Main {
    public static void main(String[] args) {
        PracticeCheck.run("작은 서점 주문", () -> {
            Book first = new Book("자바 첫걸음", 10000);
            Book second = new Book("자바 연습", 12000);
            Book chosen = Choice.choose(false, first, second);

            Locker<Book> locker = new Locker<>();
            locker.put(chosen);
            Book ordered = locker.get();

            PriceTag<Book> tag = new PriceTag<>(ordered);
            List<Book> donations = new ArrayList<>();
            BookDonation.addBook(donations, ordered);

            PracticeCheck.equal("선택한 책", "자바 연습", ordered.getName());
            PracticeCheck.equal("주문 2권 가격", 24000, tag.totalPrice(2));
            PracticeCheck.equal("기부 목록 가격", 12000, ProductReader.total(donations));
            PracticeCheck.equal("기부한 책 수", 1, ProductReader.count(donations));
        });
    }
}
