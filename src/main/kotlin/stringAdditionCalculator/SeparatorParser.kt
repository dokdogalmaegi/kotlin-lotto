package stringAdditionCalculator

class SeparatorParser {

    private fun extractCustomSeparator(input: String): String? {
        if (!isCustomSeparator(input)) {
            return null
        }

        val matchList: MatchResult? = CUSTOM_SEPARATOR_REGEX.find(input)

        return matchList?.groupValues?.get(1)
    }

    fun extractCustomSeparatorList(input: String): List<String> = extractCustomSeparator(input)?.split(",") ?: StringParser.Companion.DEFAULT_SEPARATOR_LIST

    private fun isCustomSeparator(input: String): Boolean {
        return CUSTOM_SEPARATOR_PATTERN.matches(input)
    }

    fun getWithoutCustomSeparator(input: String): String = input.substringAfter(CUSTOM_SEPARATOR_END_CHARACTER)

    companion object {
        private val CUSTOM_SEPARATOR_REGEX = Regex("//([^\\\\n]+)\\\\n")
        private val CUSTOM_SEPARATOR_PATTERN = Regex("//([^\\\\n]+)\\\\n(.+)")
        private const val CUSTOM_SEPARATOR_END_CHARACTER = "\\n"
    }
}
