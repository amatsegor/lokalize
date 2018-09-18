package lokalize

import com.google.gson.Gson
import kotlinx.coroutines.experimental.runBlocking
import lokalize.loader.GoogleSheetLoader
import lokalize.models.Config
import lokalize.writer.FileWriter
import java.io.File

fun main(vararg args: String) {
    val configPath = try {
        args[0]
    } catch (ex: ArrayIndexOutOfBoundsException) {
        ""
    }

    if (configPath.isEmpty()) {
        Logger.error("Please, specify a config path")
        return
    }

    val configFile = File(configPath)
    if (!configFile.exists()) {
        Logger.error("File $configPath doesn't exist")
        return
    }

    val config = Gson().fromJson<Config>(configFile.readText(), Config::class.java)

    if (config.options?.encoding == null) config.options?.encoding = "utf8"

    if (!config.isValid) {
        Logger.error("Config file $configPath is not valid")
        return
    }

    runBlocking {
        Logger.info("Launching...")
        // using !! operator because I've validated a config before
        var task = Lokalize.using(GoogleSheetLoader(config.key!!, config.sheets!!)).load(config.options!!)
        config.targets?.forEach {
            task = task.extract(it.valueCol, it.filename)
        }
        task.transform().save(FileWriter())
    }
}