package com.verNANDo57.rulebook_educational.customlocaleengine.store

import com.verNANDo57.rulebook_educational.customlocaleengine.CustomLocaleEngine
import java.util.Locale

/**
 *  Interface to be used by [CustomLocaleEngine] for storing a Locale and its complementary data.
 */
interface LocaleStore {
    fun getLocale(): Locale
    fun persistLocale(locale: Locale)

    fun setFollowSystemLocale(value: Boolean)
    fun isFollowingSystemLocale(): Boolean
}
