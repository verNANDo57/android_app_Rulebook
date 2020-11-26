package com.verNANDo57.rulebook_educational.customlocaleengine.store

import java.util.*

/**
 * Implementation of [LocaleStore] that keeps data in memory.
 *
 * Useful for cases like instrumentation tests, where you don't want to persist any changes
 * to the application locale.
 */
class InMemoryLocaleStore : LocaleStore {

    private var locale: Locale = Locale.getDefault()
    private var isFollowingSystemLocale = false

    override fun getLocale(): Locale = locale

    override fun persistLocale(locale: Locale) {
        this.locale = locale
    }

    override fun setFollowSystemLocale(value: Boolean) {
        isFollowingSystemLocale = value
    }

    override fun isFollowingSystemLocale(): Boolean {
        return isFollowingSystemLocale
    }
}
