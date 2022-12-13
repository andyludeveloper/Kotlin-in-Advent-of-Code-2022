fun main() {

    val testInput = readInput("Day05_test")
    println(part1(testInput))
    check(part1(testInput) == "CMZ")

    val input = readInput("Day05")
//    println(input)
    val part1 = part1(input)
    println(part1)
}

private fun part1(input: List<String>): String {
    val index = input.indexOf("")
    val cratesCount = input[index - 1].count { it.isDigit() }
    val crates = List(cratesCount) { mutableListOf<Char>() }
    val inputCrates = input.subList(0, index + 1)
    val action = input.subList(index + 1, input.size)

    inputCrates.take(index - 1).reversed().forEach { line ->
        for (i in line.indices step 4)
            if (line[i + 1] != ' ')
                crates[i / 4] += line[i + 1]
    }

    var moveIndex = 0
    while (moveIndex < action.size) {

        val move = action[moveIndex]
        val (countS, fromS, toS) =
            move.removePrefix("move").split("from", "to")
        val count = countS.trim().toInt()
        val from = fromS.trim().toInt() - 1
        val to = toS.trim().toInt() - 1

        for (i in 0 until count) {
            if (crates[from].isNotEmpty()) {

                crates[to] += crates[from].last()
                crates[from].removeLast()
            }
        }
        moveIndex++
    }
    val stringBuilder = StringBuilder()
    for (crate in crates) {
        stringBuilder.append(crate.last())
    }
    return stringBuilder.toString()
}