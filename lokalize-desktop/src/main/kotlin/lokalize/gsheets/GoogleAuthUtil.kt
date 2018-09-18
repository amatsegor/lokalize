package lokalize.gsheets

import com.google.api.client.auth.oauth2.Credential
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.client.util.store.FileDataStoreFactory
import com.google.api.services.sheets.v4.SheetsScopes
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.security.GeneralSecurityException
import java.util.*

object GoogleAuthUtil {

    private val jsonFactory = JacksonFactory()
    private val httpTransport = GoogleNetHttpTransport.newTrustedTransport()

    @Throws(IOException::class, GeneralSecurityException::class)
    fun authorize(): Credential {
        val credsInputStream = GoogleAuthUtil::class.java.getResourceAsStream("/client_id.json")
        val clientSecrets = GoogleClientSecrets.load(jsonFactory, InputStreamReader(credsInputStream))

        val scopes = Arrays.asList(SheetsScopes.SPREADSHEETS)

        val flow = GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory, clientSecrets, scopes)
                .setDataStoreFactory(FileDataStoreFactory(File("tokens")))
                .setAccessType("offline")
                .build()

        val localReceiver = LocalServerReceiver.Builder().setPort(8080).build()

        return AuthorizationCodeInstalledApp(flow, localReceiver).authorize("user")
    }
}