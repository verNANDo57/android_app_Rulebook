package com.verNANDo57.rulebook_educational.customthemeengine.utils

import java.lang.reflect.AccessibleObject
import java.lang.reflect.Field
import java.lang.reflect.Method

class Reflection private constructor() {

  init {
    throw AssertionError("no instances")
  }

  companion object {

    private val CACHE = mutableMapOf<String, AccessibleObject>()

    @JvmStatic
    fun <T> invoke(
      obj: Any?,
      name: String,
      types: Array<Class<*>> = emptyArray(),
      vararg args: Any
    ): T? {
      try {
        val method = getMethod(obj, name, *types)
        method?.let {
          @Suppress("UNCHECKED_CAST")
          return method.invoke(obj, *args) as? T
        }
      } catch (e: Exception) {
        e.printStackTrace()
      }
      return null
    }

    @JvmStatic
    fun <T> getFieldValue(obj: Any?, name: String): T? {
      val field = getField(obj, name)
      field?.let {
        if (!field.isAccessible) field.isAccessible = true
        try {
          @Suppress("UNCHECKED_CAST")
          return field.get(obj) as? T
        } catch (e: IllegalAccessException) {
          e.printStackTrace()
        }
      }
      return null
    }


    @JvmStatic
    fun getMethod(obj: Any?, name: String, vararg types: Class<*>): Method? {
      if (obj == null) return null

      val key = cacheKey(obj, name, *types)
      var method: Method? = CACHE[key] as? Method
      if (method != null) return method

      var klass: Class<*>? = obj as? Class<*> ?: obj.javaClass

      while (klass != null) {
        try {
          method = klass.getDeclaredMethod(name, *types).also { it.isAccessible = true }
          break
        } catch (ignored: NoSuchMethodException) {
        }
        klass = klass.superclass
      }

      method?.let { CACHE.put(key, method) }

      return method
    }

    @JvmStatic
    fun getField(obj: Any?, name: String): Field? {
      if (obj == null) return null

      val key = cacheKey(obj, name)
      var field: Field? = CACHE[key] as? Field
      if (field != null) return field

      var klass: Class<*>? = obj as? Class<*> ?: obj.javaClass

      do {
        try {
          field = klass?.getDeclaredField(name)
          if (field != null) {
            field.isAccessible = true
          }
        } catch (ignored: NoSuchFieldException) {
        }
        if (field == null) {
          klass = klass?.superclass
        }
      } while (field == null && klass != null)

      field?.let { CACHE.put(key, it) }

      return field
    }

    private fun cacheKey(obj: Any, name: String, vararg types: Class<*>): String {
      val klass = obj as? Class<*> ?: obj::class.java
      val key = StringBuilder(klass.name)
      key.append('#')
      key.append(name)
      if (types.isNotEmpty()) {
        var separator = ""
        key.append('(')
        types.forEach {
          key.append(separator)
          key.append(it.name)
          separator = ", "
        }
        key.append(')')
      }
      return key.toString()
    }
  }
}
