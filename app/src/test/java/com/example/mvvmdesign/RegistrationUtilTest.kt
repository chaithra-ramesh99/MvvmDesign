package com.example.mvvmdesign

import com.google.common.truth.Truth.assertThat
import org.junit.Assert
import org.junit.Test

class RegistrationUtilTest
{
    @Test
    fun `empty username returns false`()
    {

        val result = RegistrationUtil.validateRegisterInput(
            "",
            "",
        ""
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password return true`(){
        val result = RegistrationUtil.validateRegisterInput(
            "philip","123","123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists return false`(){
        val result = RegistrationUtil.validateRegisterInput(
            "carl","123","123"
        )
        assertThat(result).isFalse()
    }


}