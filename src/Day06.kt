fun main() {
    val test1 = "bvwbjplbgvbhsrlpgdmjqwftvncz"
    val test2 = "nppdvjthqldpwncqszvftbrmjlhg"
    val test3 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
    val test4 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
    println(solution(test1, 1))
    check(solution(test1, 1) == 5)
    check(solution(test2, 1) == 6)

    check(solution(test3, 1) == 10)
    check(solution(test4, 1) == 11)

    val input = readInputToText("Day06")
    println(solution(input, 1))

    val test5 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
    check(solution(test5, 2) == 19)
    println(solution(input, 2))
}

fun solution(string: String, part: Int): Int {
    val windowSize = if (part == 1) 4 else 14
    return string.toCharArray().toList().windowed(windowSize).map { it.toSet() }.map { it.size == windowSize }
        .indexOf(true) + windowSize
}
