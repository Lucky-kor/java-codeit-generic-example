package multiplebounds;

/** 이름에 Rose가 들어 있어도 Flower를 상속하지 않으므로 꽃은 아닙니다. */
public class RosePasta implements Plant {
    public String grow() {
        return "인터페이스만 구현한 반례";
    }
}
