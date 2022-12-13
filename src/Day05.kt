fun main() {

    val testInput = readInput("Day05_test")
    println(part1(testInput, 1))
    println(part1(testInput, 2))
    check(part1(testInput, 1) == "CMZ")
    check(part1(testInput, 2) == "MCD")

    val input = readInput("Day05")
    val part1 = part1(input, 1)
    val part2 = part1(input, 2)
    println(part1)
    println(part2)
}

private fun part1(input: List<String>, method: Int): String {
    val index = input.indexOf("")
    val cratesCount = input[index - 1].count { it.isDigit() }
    val crates = MutableList(cratesCount) { mutableListOf<Char>() }
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
        if (method == 1) {
            for (i in 0 until count) {
                crates[to] += crates[from].takeLast(1)
                crates[from] = crates[from].dropLast(1).toMutableList()
            }
        } else {
            crates[to] += crates[from].takeLast(count)
            crates[from] = crates[from].dropLast(count).toMutableList()
        }
        moveIndex++
    }
    val stringBuilder = StringBuilder()
    for (crate in crates) {
        stringBuilder.append(crate.last())
    }
    return stringBuilder.toString()
}