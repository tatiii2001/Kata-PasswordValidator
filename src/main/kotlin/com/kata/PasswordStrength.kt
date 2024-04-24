package com.kata

sealed class PasswordStrength(private val rules: List<PasswordRule>) {
    fun validateAllRulesFor(password: String): List<PasswordError> {
        return rules.mapNotNull { it.validate(password) }
    }

    data object Weak :
        PasswordStrength(
            listOf(
                PasswordRule.RequiredMinimumLength(6),
                PasswordRule.ContainAtLeastLowerCase,
                PasswordRule.ContainAtLeastUppercase,
                PasswordRule.ContainAtLeastDigit
            )
        )

    data object Normal :
        PasswordStrength(
            listOf(
                PasswordRule.RequiredMinimumLength(8),
                PasswordRule.ContainAtLeastLowerCase,
                PasswordRule.ContainAtLeastUppercase,
                PasswordRule.ContainAtLeastDigit,
                PasswordRule.ContainAtLeastUnderscore
            )
        )

    data object Strong :
        PasswordStrength(
            listOf(
                PasswordRule.RequiredMinimumLength(16),
                PasswordRule.ContainAtLeastLowerCase,
                PasswordRule.ContainAtLeastUppercase,
                PasswordRule.ContainAtLeastUnderscore
            )
        )
}