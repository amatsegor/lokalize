package lokalize.gsheets

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets
import com.google.api.client.json.jackson2.JacksonFactory
import lokalize.Logger
import java.io.InputStreamReader
import com.google.api.services.sheets.v4.SheetsScopes
import java.util.Arrays

object GoogleAuthUtil {
    fun authorize() {
        val reader = InputStreamReader(GoogleAuthUtil::class.java.getResourceAsStream("/client_id.json"))
        val clientSecrets = GoogleClientSecrets.load(JacksonFactory(), reader)

        val scopes = Arrays.asList(SheetsScopes.SPREADSHEETS)

        if (clientSecrets.details.clientId.startsWith("Enter")
                || clientSecrets.details.clientSecret.startsWith("Enter ")) {
            Logger.error(
                    "Enter Client ID and Secret from https://code.google.com/apis/console/?api=youtube"
                            + "into src/main/resources/client_secrets.json")
            System.exit(1)
        }
    }
}