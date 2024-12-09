/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package advent.of.code

import kotlin.math.abs

object DayOne {

    fun partOne(input: String): String {
        val (left, right) = splitInputToTwoLists(input)

        var sum = 0

        for (idx in left.indices) {
            sum += abs(left[idx] - right[idx])
        }

        return sum.toString()
    }

    fun partTwo(input: String): String {
        val (list, frequencyMap) = buildListAndFrequencyMap(input)
        return list.map {
            it * frequencyMap.getOrDefault(it, 0)
        }.sum().toString()
    }

    private fun splitInputToTwoLists(input: String): Pair<List<Int>, List<Int>> {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()

        input.split("\n").map {
            val parts = it.split("\\s+".toRegex())

            left.insertSorted(parts[0].toInt())
            right.insertSorted(parts[1].toInt())
        }

        return left to right
    }

    private fun buildListAndFrequencyMap(input: String): Pair<List<Int>, Map<Int, Int>> {
        val list = mutableListOf<Int>()
        val frequencyMap = mutableMapOf<Int, Int>()

        input.split("\n").map {
            val (left, right) = it.split("\\s+".toRegex()).map { it.toInt() }

            list.insertSorted(left)

            frequencyMap[right] = frequencyMap.getOrDefault(right, 0) + 1

        }

        return list to frequencyMap.toMap()
    }


    private fun <T : Comparable<T>> MutableList<T>.insertSorted(element: T) {
        val index = this.indexOfFirst { it > element }
        if (index == -1) {
            this.add(element)
        } else {
            this.add(index, element)
        }
    }
}