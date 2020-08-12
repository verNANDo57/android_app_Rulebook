package com.verNANDo57.rulebook_educational.customthemeengine

import android.app.Application
import android.content.res.Resources

/**
 * A subclass of [Application] which should be added to the AndroidManifest.
 *
 * If you cannot extend from this class you can initialize you must initialize CustomThemeEngine from your own base app:
 *
 * ```kotlin
 * override run onCreate() {
 *   super.onCreate()
 *   CustomThemeEngine.init(this, super.getResources())
 *
 *   java
 *   CustomThemeEngine.init(this, getResources());
 *   super.onCreate();
 * }
 * ```
 */
open class CustomThemeEngineInApp : Application() {

  private val resources: CustomThemeEngineResources by lazy {
    CustomThemeEngineResources(super.getResources(), customThemeEngine)
  }

  /**
   * The [CustomThemeEngine] instance used to create the application's resources
   */
  open val customThemeEngine: CustomThemeEngine by lazy { CustomThemeEngine.INSTANCE }

  override fun onCreate() {
    super.onCreate()
    CustomThemeEngine.init(this, super.getResources())
  }

  override fun getResources(): Resources {
    return if (CustomThemeEngine.isInitialized()) resources else super.getResources()
  }
}
