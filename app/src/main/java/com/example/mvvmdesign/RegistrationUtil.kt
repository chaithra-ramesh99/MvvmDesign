package com.example.mvvmdesign

object RegistrationUtil {

    /*
    the input is  ot valid if user name/password is empty
    the name is already taken
     */

    private val existingUSers = listOf("peter","carl")

    fun validateRegisterInput(
        username:String,
        password:String,
        confirmPassword:String
    ):Boolean{
        if(username.isEmpty() || password.isEmpty())
        {
            return  false
        }
        if(username in existingUSers) {
            return false
        }
        if(password!=confirmPassword)
        {
            return  false
        }
        if(password.count { it.isDigit() }<2){
            return false
        }
        return true
    }
}


