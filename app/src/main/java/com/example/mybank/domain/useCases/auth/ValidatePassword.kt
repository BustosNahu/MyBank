package com.example.mybank.domain.useCases.auth


class ValidatePassword  {

    fun execute(password: String): LoginResult {
        if (password.isEmpty()) return LoginResult(false, "The password can't be blank")

        if (password.length <= 6) return LoginResult(
            false,
            "The password must have at least 6 characters"
        )

        return LoginResult(true)
    }

}