package org.cytoscape.work;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * An annotation designed to signal that the annotated field contains
 * fields and methods that are annotated with the Tunable annotation.
 * The goal is to allow rich tunable collections to be created by
 * combining the tunables found in fields annotated with ContainsTunables. 
 * <br/>
 * For example, given classes A and B:
 * <p><pre><code>
 *
 * public class A {
 *    @Tunable
 *    public int value = 5;
 * }
 *
 * public class B {
 *    @ContainsTunable
 *    public A a = new A(); 
 *    @Tunable
 *    public String name = "homer";
 * }
 *
 * </code></pre></p>
 * When class B is evaluated for Tunables, it should display a tunable
 * for both the "name" and "value" fields.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ContainsTunables {
}
