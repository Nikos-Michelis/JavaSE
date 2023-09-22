import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
public @interface MyAnno {
    String name();
    String team() default "Programming Team 1";
    int version() default 1;
}