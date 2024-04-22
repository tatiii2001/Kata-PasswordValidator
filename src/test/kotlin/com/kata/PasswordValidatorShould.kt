package com.kata

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class PasswordValidatorShould : DescribeSpec( {
    describe("when the validation level is low return false if"){
        it("contains less than 6 characters"){
            val password = Password(LOW("AVVa1"))
            val result = password.isThePasswordValid()
            result.shouldBeFalse()
        }
        it("don't contains a uppercase"){
            val password = Password(LOW("aaa455645"))
            val result = password.isThePasswordValid()
            result.shouldBeFalse()
        }
        it("don't contains a lowercase"){
            val password = Password(LOW("AETGG7865"))
            val result = password.isThePasswordValid()
            result.shouldBeFalse()
        }
        it("don't contains a number"){
            val password = Password(LOW("adgtghthFGHT"))
            val result = password.isThePasswordValid()
            result.shouldBeFalse()
        }
    }
    describe("when the validation level is low return true if "){
        it("all requirements are met"){
            val password = Password(LOW("asdf65AJDFH"))
            val result = password.isThePasswordValid()
            result.shouldBeTrue()
        }
    }
    describe("when the validation level is medium return false if"){
        it("contains less than 8 characters"){
            val password = Password(MEDIUM("AVVa1"))
            val result = password.isThePasswordValid()
            result.shouldBeFalse()
        }
        it("don't contains an underscore"){
            val password = Password(MEDIUM("AVV5dddda1"))
            val result = password.isThePasswordValid()
            result.shouldBeFalse()
        }
    }
    describe("when the validation level is medium return true if"){
        it("all requirements are met"){
            val password = Password(MEDIUM("AVVaagtf3_1"))
            val result = password.isThePasswordValid()
            result.shouldBeTrue()
        }
    }
})

