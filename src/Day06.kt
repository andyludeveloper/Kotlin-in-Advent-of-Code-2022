import java.io.*

fun main() {
    val test1 = "bvwbjplbgvbhsrlpgdmjqwftvncz"
    val test2 = "nppdvjthqldpwncqszvftbrmjlhg"
    val test3 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
    val test4 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
    println(part1(test1))
    check(part1(test1) == 5)
    check(part1(test2) == 6)

    check(part1(test3) == 10)
    check(part1(test4) == 11)

    val input = readInputToText("Day06")
    println(part1(input))
}

fun part1(string: String): Int {
    return string.toCharArray().toList()
        .windowed(4)
        .map { it.toSet() }
        .map { it.size == 4 }
        .indexOf(true) + 4
//    var result = 4
//    println(windowed.indexOf(true))
//    for (index in windowed.indices) {
//        if (windowed[index]) {
//            result += index
//            break
//        }
//    }
//    return result
}
