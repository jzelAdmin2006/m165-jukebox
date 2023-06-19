package tech.bison.trainee.server.common;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdateUtils {
    public static <T> T updateIfNotNull(Supplier<T> getter, Consumer<T> setter) {
        T value = getter.get();
        if (value != null) {
            setter.accept(value);
        }
      return value;
    }
}
