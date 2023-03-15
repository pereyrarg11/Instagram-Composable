package com.pereyrarg11.instagramcomposable.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isSubmitEnabled = MutableLiveData<Boolean>()
    val isSubmitEnabled: LiveData<Boolean> = _isSubmitEnabled

    fun onCredentialsChanged(newEmail: String, newPassword: String) {
        _email.value = newEmail
        _password.value = newPassword
        _isSubmitEnabled.value = shouldBeSubmitEnabled(newEmail, newPassword)
    }

    private fun shouldBeSubmitEnabled(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
}