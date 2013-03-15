/*
 * Created on Apr 12, 2009
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2009-2011 the original author or authors.
 */
package org.assert4j.core.test;

import static org.junit.Assert.*;

/**
 * Assertion methods that verify that an object's {@code equals} and {@code hashCode} are implemented correctly.
 *
 * @author Alex Ruiz
 */
public final class EqualsHashCodeContractAssert {

  /**
   * Verifies that the {@code equals} implementation of the given object returns {@code false} when the object is
   * compared to {@code null}.
   * @param obj the object to verify.
   * @throws AssertionError if the {@code equals} implementation of the given objects returns {@code true} when the
   * object compared to {@code null}.
   * @see EqualsHashCodeContractTestCase#should_not_be_equal_to_null()
   */
  public static void assertIsNotEqualToNull(Object obj) {
    assertFalse(obj.equals(null));
  }

  /**
   * Verifies that the {@code equals} implementation of the given object is reflexive: the object must be equal to
   * itself, which it would be at any given instance; unless you intentionally override the equals method to behave
   * otherwise.
   * @param obj the object to verify.
   * @throws AssertionError if the {@code equals} implementation of the given object is reflexive.
   */
  public static void assertEqualsIsReflexive(Object obj) {
    assertEquals(obj, obj);
  }

  /**
   * Verifies that the {@code equals} implementation of the given objects is symmetric: if object of one class is equal
   * to another class object, the other class object must be equal to this class object. In other words, one object can
   * not unilaterally decide whether it is equal to another object; two objects, and consequently the classes to which
   * they belong, must bilaterally decide if they are equal or not. They BOTH must agree.
   * @param obj1 the object to verify.
   * @param obj2 the object to compare to.
   * @throws AssertionError if the {@code equals} implementation of the given object is not symmetric.
   */
  public static void assertEqualsIsSymmetric(Object obj1, Object obj2) {
    assertEquals(obj1, obj2);
    assertEquals(obj2, obj1);
  }

  /**
   * Verifies that the {@code equals} implementation of the given objects is transitive: if the first object is equal to
   * the second object and the second object is equal to the third object; then the first object is equal to the third
   * object. In other words, if two objects agree that they are equal, and follow the symmetry principle, one of them
   * can not decide to have a similar contract with another object of different class. All three must agree and follow
   * symmetry principle for various permutations of these three classes.
   * @param obj1 the object to verify.
   * @param obj2 an object to compare to.
   * @param obj3 an object to compare to.
   * @throws AssertionError if the {@code equals} implementation of the given objects is not transitive.
   */
  public static void assertEqualsIsTransitive(Object obj1, Object obj2, Object obj3) {
    assertEquals(obj1, obj2);
    assertEquals(obj2, obj3);
    assertEquals(obj1, obj3);
  }

  /**
   * Verifies that the {@code equals}/{@code hashCode} contract of the given objects is implemented correctly: if two
   * objects are equal, then they must have the same hash code, however the opposite is NOT true.
   * @param obj1 the object to verify.
   * @param obj2 the object to compare to.
   * @throws AssertionError if the {@code equals}/{@code hashCode} contract of the given objects is not implemented
   * correctly.
   */
  public static void assertMaintainsEqualsAndHashCodeContract(Object obj1, Object obj2) {
    assertEquals(obj1, obj2);
    assertEquals(obj1.hashCode(), obj2.hashCode());
  }

  private EqualsHashCodeContractAssert() {}
}
