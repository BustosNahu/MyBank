package com.example.mybank.presentation.auth.register

import android.net.Uri

sealed interface RegisterEvents {
    data class OnNameTextChange(val name: String) : RegisterEvents
    data class OnSurnameTextChange(val surname: String) : RegisterEvents
    data class OnPasswordTextChange(val password: String) : RegisterEvents
    data class OnEmailTextChange(val email: String) : RegisterEvents
    data class OnSavePicAndRegisterUser(val uri: Uri) : RegisterEvents


    data object ContinueWithRegistration : RegisterEvents
    data object ContinueWithRegistrationStep2 : RegisterEvents
}