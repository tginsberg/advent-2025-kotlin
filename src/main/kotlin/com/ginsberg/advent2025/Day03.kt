/*
 * Copyright 2025 Todd Ginsberg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ginsberg.advent2025


/**
 * Advent of Code 2025, Day 3 -
 * Problem Description: http://adventofcode.com/2025/day/3
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2025/day3/
 */
class Day03(input: List<String>) {

    private val banks: List<List<IndexedValue<Int>>> = input.map { parseInput(it) }

    fun solvePart1(): Long =
        banks.sumOf { joltage(it, 2) }

    fun solvePart2(): Long =
        banks.sumOf { joltage(it, 12) }

    private fun joltage(bank: List<IndexedValue<Int>>, batteries: Int): Long =
        (1 .. batteries).fold(0L to 0) { (total, leftIndex), offset ->
            bank.subList(leftIndex, bank.size - batteries + offset)
                .maxBy { it.value }
                .let { (total * 10) + it.value to it.index + 1 }
        }.first

    private fun parseInput(input: String): List<IndexedValue<Int>> =
        input.map { it.digitToInt() }.withIndex().toList()

}