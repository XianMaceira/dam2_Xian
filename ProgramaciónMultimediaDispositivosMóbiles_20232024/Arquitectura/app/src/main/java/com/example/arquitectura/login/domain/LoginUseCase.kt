package com.example.arquitectura.login.domain

import com.example.arquitectura.login.data.LoginRepository

class LoginUseCase {

    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String):Boolean{
        return repository.doLogin(user, password)
    }
}