package advent.of.code


import java.time.*

enum class SubmissionOutcome {
    CORRECT,
    INCORRECT,
    WAIT,
    WRONG_LEVEL,
}

data class AocPageDay(
    val partOne: AocPagePart,
    val partTwo: AocPagePart?,
) {
    fun getPart(part: Int) = when (part) {
        1 -> partOne
        2 -> partTwo
        else -> throw Exception("There is not part $part")
    }
}

data class AocPagePart(
    val html: String,
    val solution: AocPageSolution?,
)

data class AocPageSolution(
    val html: String,
    val value: String,
)

data class AocDay(val year: Int, val day: Int): Comparable<AocDay> {
    init {
        require(day in 1..25) {
            "Day $day is not the day of Advent of Code. Please enter a number between 1 and 25"
        }
        require(year >= 2015) {
            "There is no Advent Of Code for year $year"
        }
    }

    private fun targetTime() = LocalDateTime.of(
        year,
        Month.DECEMBER,
        day,
        0,
        0
    ).atZone(zone)

    fun untilStartsEstimate(): Duration {
        val (target, now) = targetTime() to now()
        val duration = Duration.between(now, target)
        return duration
    }

    fun requireUnlocked() {
        val (target, now) = targetTime() to now()

        if (now.isAfter(target)) {
            return
        }

        val duration = Duration.between(now, target)

        val humanReadableTime = duration.humanReadable()

        throw Exception("This day is not unlocked yet. Unlocks in $humanReadableTime")
    }

    companion object {
        private val zone = ZoneId.of("America/New_York")

        private fun now() = ZonedDateTime.now(zone)
    }

    override fun compareTo(other: AocDay) =
        compareBy<AocDay>({ it.year }, { it.day })
            .compare(this, other)
}

fun Duration.humanReadable() = sequenceOf(
    Duration::toDays to "day",
    Duration::toHours to "hour",
    Duration::toMinutes to "minute",
    Duration::toSeconds to "second",
)
    .map { (a, b) -> a(this) to b }
    .firstOrNull { (a, _) -> a > 1 }
    .let { it ?: (1L to "second") }
    .let { (count, string) ->
        buildString {
            append(count)
            append(' ')
            append(string)
            if (count > 1L) append("s")
        }
    }