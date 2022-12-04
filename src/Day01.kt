fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        var temp = 0
        input.forEach {
            if (it.isEmpty()) {
                if (temp > sum) {
                    sum = temp
                }
                temp = 0
            } else {
                temp += it.toInt()
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var firstFourItems = MutableList(4){0}
        val newInput = input + ""
        var temp = 0
        newInput.forEach {
            if (it.isEmpty()) {
                firstFourItems[3] = temp
                firstFourItems = firstFourItems.sorted().reversed().toMutableList()
                println(firstFourItems)
                temp = 0
            } else {
                temp += it.toInt()
            }
        }
        return firstFourItems.take(3).sum()
    }

//     test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
