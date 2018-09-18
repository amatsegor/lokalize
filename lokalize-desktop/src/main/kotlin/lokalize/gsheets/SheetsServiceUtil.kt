package lokalize.gsheets

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.sheets.v4.Sheets
import java.io.IOException
import java.security.GeneralSecurityException


object SheetsServiceUtil {

    @Throws(IOException::class, GeneralSecurityException::class)
    fun getSheetsService(): Sheets {
        val credential = GoogleAuthUtil.authorize()
        return Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build()
    }

    private const val APPLICATION_NAME = "Lokalize"
}