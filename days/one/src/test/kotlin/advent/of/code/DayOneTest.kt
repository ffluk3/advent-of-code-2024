package advent.of.code

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayOneTest {

    companion object {
        private const val INPUT = """3   4
4   3
2   5
1   3
3   9
3   3"""
    }

    @Test
    fun partOne() {
        val result = DayOne.partOne(INPUT)
        assertEquals("11", result)
    }

    @Test
    fun partTwo() {
        val result = DayOne.partTwo(INPUT)
        assertEquals("31", result)
    }
}