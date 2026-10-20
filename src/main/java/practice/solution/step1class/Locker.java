package practice.solution.step1class;



/** 물건 하나를 보관하는 보관함입니다. */
public class Locker<T> {
    // T는 나중에 String, Integer, Book 등으로 정할 타입의 이름입니다.
    private T item;

    public void put(T item) {
        // this.item은 객체의 변수, 오른쪽 item은 메서드가 받은 값입니다.
        this.item = item;
    }

    public T get() {
        return item;
    }
}
