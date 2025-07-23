package leetcode.strings

// Final version using stack after understanding the pattern — much cleaner!
fun maximumGain(s: String, x: Int, y: Int): Int {
    val firstPair = if (x >= y) "ab" to x else "ba" to y
    val secondPair = if (x >= y) "ba" to y else "ab" to x

    var score = 0
    val stack1 = ArrayDeque<Char>()

    println("== First Pass: Remove '${firstPair.first}' for ${firstPair.second} points ==")

    for (ch in s) {
        stack1.addLast(ch)
        if (stack1.size >= 2 &&
            stack1[stack1.size - 2] == firstPair.first[0] &&
            stack1[stack1.size - 1] == firstPair.first[1]) {

            println("  >> Found '${firstPair.first}' at top of stack: ${stack1.joinToString("")}")
            stack1.removeLast()
            stack1.removeLast()
            score += firstPair.second
            println("  >> Removed '${firstPair.first}', score = $score")
        }
    }

    println("\n== Second Pass: Remove '${secondPair.first}' for ${secondPair.second} points ==")

    val stack2 = ArrayDeque<Char>()
    for (ch in stack1) {
        stack2.addLast(ch)
        if (stack2.size >= 2 &&
            stack2[stack2.size - 2] == secondPair.first[0] &&
            stack2[stack2.size - 1] == secondPair.first[1]) {

            println("  >> Found '${secondPair.first}' at top of stack: ${stack2.joinToString("")}")
            stack2.removeLast()
            stack2.removeLast()
            score += secondPair.second
            println("  >> Removed '${secondPair.first}', score = $score")
        }
    }

    println("\n== Final Score: $score ==")
    return score
}

// Second version using while-loop: it worked but was verbose and error-prone
fun maximumGainSecondWhileloop(s: String, x: Int, y: Int): Int {
    // Convert to a mutable list to simulate removal
    val charList = s.toCharArray().toMutableList()
    var maxPoint = 0

    fun removePair(a: Char, b: Char, points: Int) {
        var i = 0
        while (i < charList.size - 1) {
            if (charList[i] == a && charList[i + 1] == b) {
                maxPoint += points
                charList.removeAt(i)       // remove a
                charList.removeAt(i)       // b shifts to same index after a is removed
                i = 0                       // restart to process from the beginning
            } else {
                i++
            }
        }
    }

    // Remove higher value pair first
    if (x >= y) {
        removePair('a', 'b', x)
        removePair('b', 'a', y)
    } else {
        removePair('b', 'a', y)
        removePair('a', 'b', x)
    }

    return maxPoint
}

// First version using while-loop: it worked but was verbose and error-prone
fun maximumGainFirstWhileloop(s: String, x: Int, y: Int): Int {
    val charList: MutableList<Char> = s.toCharArray().toMutableList()
    var maxPoint = 0
    var i = 0

    while (i < charList.size - 1) {
        when (charList[i]) {
            'a' -> {
                if (charList[i + 1] == 'b') {
                    maxPoint += x
                    charList.removeAt(i)
                    charList.removeAt(i)
                    i = 0
                    continue
                }
            }
            'b' -> {
                if (charList[i + 1] == 'a') {
                    maxPoint += y
                    charList.removeAt(i)
                    charList.removeAt(i)
                    i = 0
                    continue
                }
            }
        }
        i++
    }

    return maxPoint
}

fun main() {
    val s = "cdbcbbaaabab"
    val x = 4
    val y = 5

    val result = maximumGain(s, x, y)
    println("\nResult: $result") // Should be 19
}