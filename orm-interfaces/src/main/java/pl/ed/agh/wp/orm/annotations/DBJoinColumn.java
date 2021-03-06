package pl.ed.agh.wp.orm.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DBJoinColumn {
    String columnName() default "";
    String tableName() default "";
    boolean nullable() default false;
    boolean unique() default false;

}
