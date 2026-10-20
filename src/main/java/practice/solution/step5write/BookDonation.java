package practice.solution.step5write;

import java.util.List;
import practice.model.Book;

/** 목록에 기부할 책 한 권을 넣는 도구입니다. */
public class BookDonation {
    // Book을 담을 수 있는 목록을 받습니다: List<Book>, List<Product>, List<Object>.
    // ArrayList처럼 값을 추가할 수 있는 목록을 전달하세요.
    public static void addBook(List<? super Book> destination, Book book) {
        destination.add(book);
    }
}
