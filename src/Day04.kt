fun main() {

    fun List<String>.toIntRows() = this.map { row ->
        row.split(",", "-").map(String::toInt)
    }

    fun part1(input: List<String>): Int =
        input.toIntRows()
            .count { (a1, a2, b1, b2) -> (a1 <= b1) && (a2 >= b2) || (a1 >= b1) && (a2 >= b2) }

    fun part2(input: List<String>): Int =
        input.toIntRows()
            .count { (a1, a2, b1, b2) -> (a1 <= b1) && (a2 >= b1) || (b1 <= a1) && (b2 >= a1) }

    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}