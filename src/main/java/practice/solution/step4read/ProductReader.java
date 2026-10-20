package practice.solution.step4read;

import java.util.List;
import practice.model.Product;

/** 책 목록과 공책 목록의 가격을 읽는 도구입니다. */
public class ProductReader {
    // 정확한 상품 종류는 몰라도 됩니다. 모든 값이 Product이므로 가격을 읽을 수 있습니다.
    public static int total(List<? extends Product> products) {
        int sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    // 어떤 종류의 목록이든 크기는 확인할 수 있습니다. 각 값의 타입을 알 필요가 없습니다.
    public static int count(List<?> values) {
        return values.size();
    }
}
