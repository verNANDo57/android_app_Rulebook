package com.verNANDo57.rulebook_educational.taptargetview;

import java.lang.reflect.Field;

class ReflectUtil {
  ReflectUtil() {
    //required empty constructor
  }

  /** Returns the value of the given private field from the source object **/
  static Object getPrivateField(Object source, String fieldName)
      throws NoSuchFieldException, IllegalAccessException {
    final Field objectField = source.getClass().getDeclaredField(fieldName);
    objectField.setAccessible(true);
    return objectField.get(source);
  }
}
