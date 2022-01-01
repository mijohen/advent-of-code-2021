package day_03

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        val length = input[0].length - 1
        var gamma = ""
        var epsilon = ""

        for (column in 0..length) {
            var zeroes = 0
            var ones = 0

            for (row in input) {
                val number = row[column]
                if (number == '1') {
                    ones++
                } else {
                    zeroes++
                }
            }

            if (ones > zeroes) {
                gamma += '1'
                epsilon += '0'
            } else {
                gamma += '0'
                epsilon += '1'
            }
        }

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun analyseNumbers(input: List<String>, fewer: Boolean): String {
        val length = input[0].length - 1
        var rows = input

        for (column in 0..length) {
            val zeroes = arrayListOf<String>()
            val ones = arrayListOf<String>()

            for (row in rows) {
                val number = row[column]
                if (number == '1') {
                    ones.add(row)
                } else {
                    zeroes.add(row)
                }
            }

            rows = if (ones.size > zeroes.size || ones.size == zeroes.size) {
                if (fewer) zeroes else ones
            } else {
                if (fewer) ones else zeroes
            }

            if (rows.size == 1) break
        }

        return rows[0]
    }

    fun part2(input: List<String>): Int {
        val oxygen = analyseNumbers(input, false)
        val scrubber = analyseNumbers(input, true)

        return oxygen.toInt(2) * scrubber.toInt(2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day_03/test_input")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("day_03/input")
    println(part1(input))
    println(part2(input))
}

