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
 * Advent of Code 2025, Day 5 - Cafeteria
 * Problem Description: http://adventofcode.com/2025/day/5
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2025/day5/
 */
class Day05(input: List<String>) {

    private val ranges: List<LongRange> = parseRanges(input)
    private val ingredients: List<Long> = input.dropWhile { it.isNotBlank() }.drop(1).map { it.toLong() }

    fun solvePart1(): Int =
        ingredients.count { ingredient -> ranges.any { ingredient in it } }

    fun solvePart2(): Long =
        ranges.sumOf { it.last - it.first + 1 }

    private fun parseRanges(input: List<String>): List<LongRange> =
        input
            .takeWhile { it.isNotBlank() }
            .map {
                val (first, last) = it.split("-")
                first.toLong()..last.toLong()
            }
            .combineRanges()
}