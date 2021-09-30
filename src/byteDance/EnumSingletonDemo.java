package byteDance;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/27 11:20
 **/
public enum EnumSingletonDemo {
    instance;

    public EnumSingletonDemo getInstance() {
        return instance;
    }
}
