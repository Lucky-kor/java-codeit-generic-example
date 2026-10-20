package practice.exercise.step5write;

import practice.support.PracticeCheck;
import practice.model.Book;
import practice.model.Notebook;
import practice.model.Product;
import java.util.List;
import java.util.ArrayList;

/** 실행해서 결과를 확인하는 파일입니다. 먼저 같은 폴더의 BookDonation.java를 완성하세요. */
public class Main {
    public static void main(String[] args) {
        // 아래는 확인용 코드입니다. 예상 값을 바꾸지 말고 구현 파일을 수정하세요.
        PracticeCheck.run("목록에 기부할 책 한 권을 넣는 도구", () -> {
            Book book = new Book("기부할 책", 5000);
            List<Book> books = new ArrayList<>();
            BookDonation.addBook(books, book);
            PracticeCheck.equal("책 목록에 추가", book, books.get(0));
            List<Product> products = new ArrayList<>();
            Notebook notebook = new Notebook("남아 있는 공책", 2000);
            products.add(notebook);
            BookDonation.addBook(products, book);
            PracticeCheck.equal("원래 공책 유지", notebook, products.get(0));
            PracticeCheck.equal("상품 목록 끝에 책 추가", book, products.get(1));
            PracticeCheck.equal("상품 개수", 2, products.size());
            List<Object> objects = new ArrayList<>();
            BookDonation.addBook(objects, book);
            PracticeCheck.equal("Object 목록에도 추가", book, objects.get(0));
            // List<Notebook> notebooks = new ArrayList<>();
            // BookDonation.addBook(notebooks, book); // 공책 전용 목록에 책을 넣으면 안 됩니다.
        });
    }
}
