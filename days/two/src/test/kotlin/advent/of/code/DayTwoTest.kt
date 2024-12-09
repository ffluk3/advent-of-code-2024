package advent.of.code

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayTwoTest {

    companion object {
        private const val INPUT = """7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9"""
    }

    @Test
    fun partOne() {
        val result = DayTwo.partOne(INPUT)
        assertEquals("2", result)
    }

    @Test
    fun partTwo() {
        val result = DayTwo.partTwo(INPUT)
        assertEquals("31", result)
    }
}