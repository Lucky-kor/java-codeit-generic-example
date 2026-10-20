package wildcards;

/** 사용자에게서 기기를 꺼내거나 새 기기를 넣을 때, ?를 어떻게 쓰는지 살펴봅니다. */
public class PhoneFunction {
    // ?는 "정확히 어떤 타입인지는 모른다"는 뜻입니다.
    // ? extends Phone은 "Phone 또는 Phone을 상속한 타입"으로 범위를 좁힙니다.
    public static void call(User<? extends Phone> user) {
        // 아이폰인지 갤럭시인지는 몰라도 Phone의 통화 기능은 사용할 수 있습니다.
        Phone phone = user.getPhone();
        phone.call();

        // 하지만 새 Phone을 넣을 수는 없습니다.
        // 전달받은 사용자가 아이폰만 담도록 만든 User<IPhone>일 수도 있기 때문입니다.
        // user.setPhone(new Phone());
    }

    // 아이폰 또는 아이폰을 상속한 기기를 가진 사용자만 받습니다.
    public static void faceId(User<? extends IPhone> user) {
        user.getPhone().faceId();
    }

    // 갤럭시 또는 갤럭시를 상속한 기기를 가진 사용자만 받습니다.
    public static void pay(User<? extends Galaxy> user) {
        user.getPhone().samsungPay();
    }

    // ? super Galaxy는 "Galaxy, 또는 Galaxy의 부모 쪽 타입"이라는 뜻입니다.
    // 여기서는 User<Galaxy>, User<Phone>, User<Object>를 받을 수 있습니다.
    public static void replaceWithGalaxy(User<? super Galaxy> user) {
        // 위의 세 사용자 모두 Galaxy를 담을 수 있습니다.
        // S25도 Galaxy를 상속했으므로 넣을 수 있습니다.
        user.setPhone(new S25());

        // getPhone()의 반환 타입은 Object로 받아야 합니다.
        // ?가 Object일 수도 있으므로 이 선언만으로는 Galaxy라고 확신할 수 없습니다.
        Object stored = user.getPhone();
        // getClass().getSimpleName()은 실제 객체의 클래스 이름(여기서는 S25)을 알려줍니다.
        System.out.println("교체된 기기: " + stored.getClass().getSimpleName());
        // Galaxy phone = user.getPhone(); // 자바는 이 대입을 허용하지 않습니다.
    }

    // User<?>는 저장한 값이 어떤 타입이든 사용자를 받겠다는 뜻입니다.
    public static void inspect(User<?> user) {
        // 문자열일 수도, 기기일 수도 있으므로 공통 부모인 Object로 꺼냅니다.
        Object value = user.getPhone();
        // 이 예제에서는 값이 들어 있는 사용자를 전달합니다. null에서 getClass()를 호출하면 오류입니다.
        System.out.println("알 수 없는 타입의 값: " + value.getClass().getSimpleName());
        // user.setPhone("새 값"); // 기기만 담는 사용자일 수도 있으니 문자열을 넣을 수 없습니다.
    }
}
