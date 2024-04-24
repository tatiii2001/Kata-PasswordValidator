package com.kata

sealed interface PasswordRule {
    fun validate(password: String): PasswordError?

    class RequiredMinimumLength(private val length: Int) : PasswordRule {
        override fun validate(password: String): PasswordError? {
            return password
                .takeUnless { it.length >= length }
                ?.let { PasswordError.MinimumLength(length) }
        }
    }

    data object ContainAtLeastLowerCase : PasswordRule {
        override fun validate(password: String): PasswordError? {
            return password
                .takeUnless { it.any { character -> character.isLowerCase() } }
                ?.let { PasswordError.NoContainsLowercase }
        }

    }

    data object ContainAtLeastUppercase : PasswordRule {
        override fun validate(password: String): PasswordError? {
            return password
                .takeUnless { it.any { character -> character.isUpperCase() } }
                ?.let { PasswordError.NoContainsUppercase }
        }

    }

    data object ContainAtLeastDigit : PasswordRule {
        override fun validate(password: String): PasswordError? {
            return password
                .takeUnless { it.any { character -> character.isDigit() } }
                ?.let { PasswordError.NoContainsAnyNumber }
        }

    }

    data object ContainAtLeastUnderscore : PasswordRule {
        override fun validate(password: String): PasswordError? {
            return password
                .takeUnless { it.any { character -> character == '_' } }
                ?.let { PasswordError.NoContainsUnderscore }
        }

    }
}