package com.kata

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PasswordRuleShould : WordSpec({
    "require minimum length rule" should {
        "validate password has a minimum length" {
            val aPassword = "12345678"
            val rule = PasswordRule.RequiredMinimumLength(8)

            rule.validate(aPassword).shouldBeNull()
        }
        "fail when length is less than required" {
            val aPassword = "hs12"
            val rule = PasswordRule.RequiredMinimumLength(8)
            rule.validate(aPassword) shouldBe PasswordError.MinimumLength(8)
        }
    }
    "contains at least a lowercase rule" should {
        "validate password has at least one lowercase" {
            val aPassword = "12345678a"
            val rule = PasswordRule.ContainAtLeastLowerCase

            rule.validate(aPassword).shouldBeNull()
        }
        "fail when it hasn't at least one lowercase letter" {
            val aPassword = "12"
            val rule = PasswordRule.ContainAtLeastLowerCase
            rule.validate(aPassword) shouldBe PasswordError.NoContainsLowercase
        }
    }
    "contains at least a uppercase rule" should {
        "validate password has at least one uppercase" {
            val aPassword = "12345678A"
            val rule = PasswordRule.ContainAtLeastUppercase

            rule.validate(aPassword).shouldBeNull()
        }
        "fail when it hasn't at least one uppercase letter" {
            val aPassword = "12"
            val rule = PasswordRule.ContainAtLeastUppercase
            rule.validate(aPassword) shouldBe PasswordError.NoContainsUppercase
        }
    }
    "contains at least a digit rule" should {
        "validate password has at least one digit" {
            val aPassword = "12gh"
            val rule = PasswordRule.ContainAtLeastDigit

            rule.validate(aPassword).shouldBeNull()
        }
        "fail when it hasn't at least one digit" {
            val aPassword = "dferDF"
            val rule = PasswordRule.ContainAtLeastDigit
            rule.validate(aPassword) shouldBe PasswordError.NoContainsAnyNumber
        }
    }
    "contains at least a underscore rule" should {
        "validate password has at least one underscore" {
            val aPassword = "12gh_"
            val rule = PasswordRule.ContainAtLeastUnderscore

            rule.validate(aPassword).shouldBeNull()
        }
        "fail when it hasn't at least one underscore" {
            val aPassword = "d34ferDF"
            val rule = PasswordRule.ContainAtLeastUnderscore
            rule.validate(aPassword) shouldBe PasswordError.NoContainsUnderscore
        }
    }
})