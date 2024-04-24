package com.kata

import arrow.core.Either
import arrow.core.left
import arrow.core.right

@JvmInline
value class Password private constructor(val value: String) {
    companion object {
        fun of(
            value: String,
            strength: PasswordStrength = PasswordStrength.Normal
        ): Either<List<PasswordError>, Password> {
            val errors: List<PasswordError> = strength.validateAllRulesFor(value)
            return if (errors.size > 1) errors.left()
            else Password(value).right()
        }
    }
}
