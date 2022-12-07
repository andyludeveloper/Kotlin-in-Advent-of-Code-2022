fun main() {
    val ansChar = listOf(('a'..'z').toList(), ('A'..'Z').toList()).flatten()

    fun part1(input: List<String>): Int {
        return input.sumOf {
            it.chunked(it.length / 2)
                .let { compartment ->
                    compartment[0].filter { c: Char -> compartment[1].contains(c) }
                        .map { ans: Char -> ansChar.indexOf(ans) + 1 }
                        .take(1).single()
                }
        }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3).sumOf {
            it.let { compartment ->
                compartment[0].filter { c: Char -> compartment[1].contains(c) && compartment[2].contains(c) }
                    .map { ans: Char -> ansChar.indexOf(ans) + 1 }
                    .take(1).single()
            }
        }
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))

//    val split0 = line1.subSequence(0, (line1.length) / 2)
//    val split1 = line1.subSequence(line1.length / 2, line1.length)
//    for (char: Char in chunked[0]) {
//        if (chunked[1].contains(char)) {
//            println(char)
//            println(ansChar.indexOf(char) + 1)
//        }
//    }

//    line1.chunked(line1.length / 2)
}