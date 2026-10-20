package invariance;

/** 장미의 상위 클래스입니다. */
public class Flower {
    public String flowerMethod() {
        return "꽃을 관찰합니다.";
    }
    // 객체를 출력할 때 Flower 또는 Rose처럼 실제 클래스 이름이 보이게 합니다.
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
