
fun main() {
    val inputString = "Character"

    val characterMap = mutableMapOf<Char, Int>()

    inputString.forEach { char ->
        var charLowerCase = char.lowercaseChar()

        // if the key (lowercase character) is not yet in the hashmap, it will be recorded accordingly with a value of 1.
        // if the key is already in the hashmap, the value for the already existing key will be incremented.
        characterMap[charLowerCase] = characterMap.getOrDefault(charLowerCase,0) + 1
    }

    // getting the key (character) with the maximum occurrences
    val maximumCharacter = characterMap.maxByOrNull { it.value }?.key

    println(maximumCharacter)
}