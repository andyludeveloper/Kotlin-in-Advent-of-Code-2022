fun main() {
    val map = mapOf(
        "A Y" to 8,
        "A X" to 4,
        "A Z" to 3,
        "B X" to 1,
        "B Y" to 5,
        "B Z" to 9,
        "C X" to 7,
        "C Y" to 2,
        "C Z" to 6
    )

    val map2 = mapOf(
        "A X" to "Z",
        "A Y" to "X",
        "A Z" to "Y",
        "B X" to "X",
        "B Y" to "Y",
        "B Z" to "Z",
        "C X" to "Y",
        "C Y" to "Z",
        "C Z" to "X"
    )

    fun part1(input: List<String>): Int {
        var result = 0
        input.forEach { result += map[it] ?: 0 }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        for (item in input) {
            if (item.endsWith("X")) {
                result += 0
            }
            if (item.endsWith("Y")) {
                result += 3
            }
            if (item.endsWith("Z")) {
                result += 6
            }
            val myTurn = map2[item]
            when (myTurn) {
                "X" -> result += 1
                "Y" -> result += 2
                "Z" -> result += 3
            }
        }
        return result
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
