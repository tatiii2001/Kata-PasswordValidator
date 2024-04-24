package com.kata

sealed class PasswordError(message: String) {
    data class MinimumLength(private val minLength: Int) :
        PasswordError("The minimum length must be $minLength characters")

    data object NoContainsUppercase : PasswordError("The password should contain minimum one Uppercase")
    data object NoContainsLowercase : PasswordError("The password should contain minimum one Lowercase")
    data object NoContainsAnyNumber : PasswordError("The password should contain minimum one number")
    data object NoContainsUnderscore : PasswordError("The password should contain minimum ome underscore")
}