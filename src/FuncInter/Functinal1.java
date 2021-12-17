package FuncInter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Functinal1 {
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
    }
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        //Твой код здесь
        return (arg) -> condition.test(arg) ? ifTrue.apply(arg) : ifFalse.apply(arg);

    }
}
