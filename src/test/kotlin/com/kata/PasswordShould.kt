package com.kata


import io.kotest.assertions.fail
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

class PasswordShould : WordSpec({
    "password " should {
        "validate password is correct" {
            val password = Password.of(value = "asHY78_GT")
            password.fold(
                ifRight = {
                    it.value shouldBe "asHY78_GT"
                },
                ifLeft = {
                    fail("Expected right but got left")
                }
            )
        }
        "fail showing all errors when password is empty" {
            val password = Password.of(value = "")
            password.fold(
                ifRight = {
                    fail("Expected left but got right")
                },
                ifLeft = {
                    it.shouldContainExactlyInAnyOrder(
                        PasswordError.MinimumLength(8),
                        PasswordError.NoContainsLowercase,
                        PasswordError.NoContainsUppercase,
                        PasswordError.NoContainsAnyNumber,
                        PasswordError.NoContainsUnderscore,
                    )
                }
            )
        }
    }

})