package day_01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var previous: String? = null
        var largerNumbers = 0

        for (item in input) {
            if (previous !== null && item.toInt() > previous.toInt()) {
                largerNumbers++
            }

            previous = item
        }

        return largerNumbers
    }

    fun part2(input: List<String>): Int {
        var previousSum: Int? = null
        var largerSums = 0

        for (index in 0..input.size) {
            val sum: Int = input[index].toInt() + input[index + 1].toInt() + input[index + 2].toInt()

            if (previousSum !== null && sum > previousSum) {
                largerSums++
            }

            previousSum = sum

            if (index + 2 == input.size - 1) break
        }

        return largerSums
    }

    val testInput = readInput("day_01/test_input")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("day_01/input")
    println(part1(input))
    println(part2(input))
}

