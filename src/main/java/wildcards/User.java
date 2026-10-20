package wildcards;

/** T로 정한 타입의 값을 보관하는 사용자입니다. <T>에 조건이 없어서 문자열도 보관할 수 있습니다. */
public class User<T> {
    private T phone;

    // 객체를 만들 때 전달한 값을 이 객체 안에 저장합니다.
    public User(T phone) {
        this.phone = phone;
    }

    public T getPhone() {
        return phone;
    }

    public void setPhone(T phone) {
        this.phone = phone;
    }
}
