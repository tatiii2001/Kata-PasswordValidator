package com.kata

abstract class Validation(val password: String){
    abstract val characters : Int
    val isTheCorrectLength: Boolean
        get() {
            return password.length >= characters
        }
    val containsUpperCase: Boolean
        get() {
            return password.any { it.isUpperCase() }
        }
    val containsLowerCase: Boolean
        get() {
            return password.any { it.isLowerCase() }
        }
    abstract fun isTheValidPassword() : Boolean


}
class LOW(passwordLow: String) : Validation(passwordLow) {
    override val characters: Int
        get() = 6

    private val containsNumber: Boolean
        get() {
            return password.any { it.isDigit() }
        }

    override fun isTheValidPassword(): Boolean {
        return isTheCorrectLength &&
                containsUpperCase &&
                containsLowerCase &&
                containsNumber
    }
}
class MEDIUM(passwordMedium : String) : Validation(passwordMedium){
    override val characters: Int
        get() = 8
    private val containsNumber: Boolean
        get() {
            return password.any { it.isDigit() }
        }
    private val containsUnderscore : Boolean
        get() {
            return password.any { it == '_' }
        }
    override fun isTheValidPassword(): Boolean {
        return isTheCorrectLength &&
                containsUpperCase &&
                containsLowerCase &&
                containsNumber &&
                containsUnderscore

    }


}

class HIGH(passwordHigh : String) : Validation(passwordHigh){
    override val characters: Int
        get() = 16

    private val containsUnderscore : Boolean
        get() {
            return password.any { it == '_' }
        }
    override fun isTheValidPassword(): Boolean {
        return isTheCorrectLength &&
                containsUpperCase &&
                containsLowerCase &&
                containsUnderscore
    }


}

