package com.pereyrarg11.instagramcomposable.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.instagramcomposable.login.domain.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isSubmitEnabled = MutableLiveData<Boolean>()
    val isSubmitEnabled: LiveData<Boolean> = _isSubmitEnabled

    fun onCredentialsChanged(newEmail: String, newPassword: String) {
        _email.value = newEmail
        _password.value = newPassword
        _isSubmitEnabled.value = shouldBeSubmitEnabled(newEmail, newPassword)
    }

    fun onSubmit() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email.value!!, password.value!!)
            if (result) {
                Log.i("LOGIN", "Success")
            }
            _isLoading.value = false
        }
    }
    private fun shouldBeSubmitEnabled(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
}