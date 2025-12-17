package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val secretList = secret.toMutableList()
    val guessList = guess.toMutableList()

    val rightPositions = secretList.zip(guessList).count { (s, g) -> s == g }

    secretList.removeAllAtMatchingPositions(guessList)
    guessList.removeAllAtMatchingPositions(secret.toList())


    val s: String = "hola"
    val length: Int? = s?.length

    val die = 6;
    when (die) {
        1 -> println("die is 1")
        2 -> println("die is 2")
        3:6 -> println("die is between 3 and 6")
        else -> println("die is unknown")
    }

    val wrongPositions = guessList.countMatchingWith(secretList)

    return Evaluation(rightPositions, wrongPositions)
}

private fun MutableList<Char>.removeAllAtMatchingPositions(other: List<Char>) {
    for (i in this.indices.reversed()) {
        if (i < other.size && this[i] == other[i]) {
            this.removeAt(i)
        }
    }
}

private fun List<Char>.countMatchingWith(other: MutableList<Char>): Int {
    var count = 0
    val otherCopy = other.toMutableList()
    this.forEach { char ->
        if (otherCopy.remove(char)) {
            count++
        }
    }
    return count
}