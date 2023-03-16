package com.pereyrarg11.instagramcomposable.login.domain

import com.pereyrarg11.instagramcomposable.login.data.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }
}