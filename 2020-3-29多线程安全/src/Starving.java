

/**
 * 饿汉模式
 * 这个类只允许生成一个对象
 * 是线程安全的么？ YES
 */
public class Starving {

    // 是发生在类加载时期（初始化），是线程安全（
    private static Starving instance = new Starving();

    // 其他类如果需要 Starving 类的对象
    // 统统调用 getInstance() 这个静态方法获取
    // 保证不会有新的对象产生
    public static Starving getInstance() {
        return instance;
    }

    // 更优一点
    // 把构造方法声明为 private，保证别人无法调用构造方法
    private Starving() {
    }
}
