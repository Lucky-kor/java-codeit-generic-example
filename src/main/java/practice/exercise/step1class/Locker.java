package practice.exercise.step1class;



/** 물건 하나를 보관하는 보관함입니다. */
public class Locker<T> {
    // T는 나중에 String, Integer, Book 등으로 정할 타입의 이름입니다.
    private T item;

    public void put(T item) {
        // TODO 1: 받은 item을 이 객체의 item 변수에 저장하세요.
        // 아래 throw 줄을 지우고 이 자리에 코드를 작성하세요.
        throw new UnsupportedOperationException("TODO 1: 받은 item을 이 객체의 item 변수에 저장하세요.");
    }

    public T get() {
        // TODO 2: 저장해 둔 item을 돌려주세요.
        // 아래 throw 줄을 지우고 이 자리에 코드를 작성하세요.
        throw new UnsupportedOperationException("TODO 2: 저장해 둔 item을 돌려주세요.");
    }
}
