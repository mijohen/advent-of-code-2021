package day_02

import readInput

fun main() {

    val directions = mapOf("up" to -1, "down" to 1)

    fun part1(input: List<String>): Int {
        var position = 0
        var depth = 0

        for (row in input) {
            val (direction, number) = row.split(' ')

            if (directions.containsKey(direction)) {
                depth += directions[direction]?.times(number.toInt()) ?: 0
            } else {
                position += number.toInt()
            }
        }

        return position*depth
    }

    fun part2(input: List<String>): Int {
        var position = 0
        var depth = 0
        var aim = 0

        for (row in input) {
            val (direction, number) = row.split(' ')

            if (directions.containsKey(direction)) {
                aim += directions[direction]?.times(number.toInt()) ?: 0
            } else {
                position += number.toInt()
                depth += number.toInt()*aim
            }
        }

        return position*depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day_02/test_input")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("day_02/input")
    println(part1(input))
    println(part2(input))
}

