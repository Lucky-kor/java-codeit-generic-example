package typetoken;

import java.util.Objects;

/** 값과 확인할 타입을 함께 받아, 그 타입으로 읽을 수 있는지 검사합니다. */
public class SafeCaster {
    // 예를 들어 String.class를 받으면 T는 String이 되고, 반환 타입도 String이 됩니다.
    public static <T> T cast(Object value, Class<T> type) {
        // 검사할 타입이 없으면 작업할 수 없으므로 type이 null인지 먼저 확인합니다.
        Objects.requireNonNull(type, "type은 필수입니다.");

        // isInstance는 value가 전달받은 타입에 맞는 객체인지 확인합니다.
        // 이 메서드는 값이 없다는 뜻의 null도 허용하며, 그때는 null을 그대로 돌려줍니다.
        if (value == null || type.isInstance(value)) {
            return type.cast(value); // 확인한 타입으로 값을 돌려줍니다.
        }

        // 맞지 않는 타입이면 오류를 알립니다. 호출한 곳의 try-catch에서 처리할 수 있습니다.
        throw new ClassCastException("요청한 타입으로 변환할 수 없습니다: " + type.getSimpleName());
    }
}
