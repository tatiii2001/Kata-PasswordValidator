package com.kata



class Password (private val typeValidation : Validation) {
    fun isThePasswordValid() : Boolean{
        return typeValidation.isTheValidPassword()
    }

}
