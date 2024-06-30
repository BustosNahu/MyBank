package com.example.mybank.core.util

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

object FunctionUtils {

    fun Context.createTempPictureUri(
        provider: String = "com.example.mybank.provider",
        fileName: String = "picture_${System.currentTimeMillis()}",
        fileExtension: String = ".png"
    ): Uri {
        val tempFile = File.createTempFile(
            fileName, fileExtension, cacheDir
        ).apply {
            createNewFile()
        }

        return FileProvider.getUriForFile(applicationContext, provider, tempFile)
    }

}