package common

data class ProblemJson(
    val name: String,
    val group: String,
    val url: String,
    val memoryLimit: Int,
    val timeLimit: Int,
    val tests: List<TestJson>,
    val batch: BatchJson
)

data class TestJson(
    val input: String,
    val output: String,
)

data class BatchJson(
    val id: String,
    val size: Int
)