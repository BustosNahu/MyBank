package com.example.mybank.domain.useCases.auth


class ValidateEmail  {

    fun execute(email: String): LoginResult {
        if (email.isEmpty()) return LoginResult(false, "The email can't be blank")

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) return LoginResult(
            false,
            "The email is not valid"
        )

        return LoginResult(true)
    }

}