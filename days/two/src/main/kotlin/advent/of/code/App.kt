package advent.of.code

suspend fun main() {
    val client = AocClient.fromEnv()

    val day = AocDay(2024, 1)

    day.requireUnlocked()

    val input = client.fetchInput(day)

    for (part in 1..2) {
        if (client.fetchAocPageDay(day).getPart(part)?.solution == null) {
            println("Part $part unsolved. Solving...")
            val (partOutcome) = client.submit(part, day, when (part) {
                1 -> DayOne.partOne(input)
                2 -> DayOne.partTwo(input)
                else -> throw Exception("There is not part $part")
            })
            println("Part $part: $partOutcome")
        }
    }
}