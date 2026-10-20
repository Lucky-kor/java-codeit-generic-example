package multiplebounds;

/** Flower의 기능을 물려받고, Plant에서 약속한 grow()도 만든 장미입니다. */
public class Rose extends Flower implements Plant {
    @Override
    public String grow() {
        return "장미가 자랍니다.";
    }
}
