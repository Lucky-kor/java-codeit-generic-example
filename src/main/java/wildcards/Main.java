package wildcards;

/** 아이폰과 갤럭시 사용자를 통해 ? extends, ? super, ?의 차이를 알아봅니다. */
public class Main {
    public static void main(String[] args) {
        // < > 안의 타입을 먼저 읽어 보세요. User<IPhone>은 아이폰을 담는 사용자입니다.
        // IPhone17Pro는 IPhone을 상속했으므로 User<IPhone>에 넣을 수 있습니다.
        User<Phone> phone = new User<>(new Phone());
        User<IPhone> iphone = new User<>(new IPhone17Pro());
        User<IPhone16> olderIphone = new User<>(new IPhone16());
        User<Galaxy> galaxy = new User<>(new Zflip6());
        // 네 기기 모두 Phone을 상속했거나 Phone 자체이므로 통화할 수 있습니다.
        PhoneFunction.call(phone);
        PhoneFunction.call(iphone);
        PhoneFunction.call(olderIphone);
        PhoneFunction.call(galaxy);
        PhoneFunction.faceId(iphone);
        PhoneFunction.pay(galaxy);
        // PhoneFunction.faceId(galaxy); // Galaxy는 IPhone의 하위 타입이 아닙니다.

        // Phone을 담는 사용자와 Galaxy를 담는 사용자 모두 갤럭시로 교체할 수 있습니다.
        PhoneFunction.replaceWithGalaxy(phone);
        PhoneFunction.replaceWithGalaxy(galaxy);
        User<Object> anything = new User<>("기존 문자열");
        PhoneFunction.replaceWithGalaxy(anything);
        // PhoneFunction.replaceWithGalaxy(new User<S25>(new S25())); // S25 전용 사용자에게는 다른 Galaxy 기기를 넣을 수 없으므로 허용하지 않습니다.
        // PhoneFunction.replaceWithGalaxy(iphone); // 아이폰 전용 사용자에게 갤럭시를 넣을 수 없습니다.
        PhoneFunction.inspect(new User<>("Hello"));
        PhoneFunction.inspect(iphone);
        // PhoneFunction.call(new User<>("Hello")); // String은 Phone이 아닙니다.
    }
}
