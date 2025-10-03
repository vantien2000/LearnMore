package LearnMore.example.LearnMore.Patterns;

public final class Singleton<T> {
    private Singleton() {}
    private static Singleton<?> _instance;
    public static<T> Singleton<T> getInstance() {
        synchronized (Singleton.class) {
            if (_instance == null) {
                _instance = new Singleton<T>();
            }
        }
        return (Singleton<T>) _instance;
    }
}
