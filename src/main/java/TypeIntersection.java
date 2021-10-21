public class TypeIntersection {
    public static void main(String... args) {
        var duck = (Quacks & Waddles) () -> {
            Mixin.create();
        };
        duck.quack();
        duck.waddle();


    }

    interface Quacks extends Mixin {
        default void quack() {
            System.out.println("Quack");
        }
    }

    interface Waddles extends Mixin {
        default void waddle() {
            System.out.println("Waddle");
        }
    }

    @FunctionalInterface
    interface Mixin {
        void __noop__();
        static void create() {}
    }
}
