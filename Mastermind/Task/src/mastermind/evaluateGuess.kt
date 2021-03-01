package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var right = 0
    var wrong = 0

    var newSecret = secret
    var newGuess = guess

    for((index,value) in newSecret.withIndex()){
        if(newGuess[index] == value) {
            right++
            newGuess = newGuess.replaceFirst(oldChar = value, newChar = '.')
            newSecret = newSecret.replaceFirst(oldChar = value, newChar = '.')
        }
    }

    for ((index,value) in newSecret.withIndex())
    {

        if(value!= '.' && newGuess.contains(value))
        {
            newSecret = newSecret.replaceFirst(oldChar = value, newChar = '.')
            newGuess = newGuess.replaceFirst(oldChar = value, newChar = '.')
            wrong++
        }
    }
    return Evaluation(right,wrong)
}
