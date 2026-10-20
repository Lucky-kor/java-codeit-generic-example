package practice.exercise.step4read;

import java.util.List;
import practice.model.Product;

/** 책 목록과 공책 목록의 가격을 읽는 도구입니다. */
public class ProductReader {
    // 정확한 상품 종류는 몰라도 됩니다. 모든 값이 Product이므로 가격을 읽을 수 있습니다.
    public static int total(List<? extends Product> products) {
        // TODO 1: 합계를 0으로 시작하고 각 상품의 가격을 더한 뒤 돌려주세요.
        // 아래 throw 줄을 지우고 이 자리에 코드를 작성하세요.
        throw new UnsupportedOperationException("TODO 1: 합계를 0으로 시작하고 각 상품의 가격을 더한 뒤 돌려주세요.");
    }

    // 어떤 종류의 목록이든 크기는 확인할 수 있습니다. 각 값의 타입을 알 필요가 없습니다.
    public static int count(List<?> values) {
        // TODO 2: values의 size()를 돌려주세요.
        // 아래 throw 줄을 지우고 이 자리에 코드를 작성하세요.
        throw new UnsupportedOperationException("TODO 2: values의 size()를 돌려주세요.");
    }
}
