package lokalize.models

data class Error(val name: String,
                 val message: String,
                 val stack: String?)