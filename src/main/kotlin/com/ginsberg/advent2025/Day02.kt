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
 * Advent of Code 2025, Day 2 - Gift Shop
 * Problem Description: http://adventofcode.com/2025/day/2
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2025/day2/
 */
class Day02(input: String) {

    private val ranges: List<LongRange> = parseInput(input)

    fun solvePart1(): Long =
        solve {
            part1InvalidOrNull()
        }

    fun solvePart2(): Long =
        solve {
            part2InvalidOrNull()
        }

    private fun solve(function: Long.() -> Long?): Long =
        ranges.sumOf { range ->
            range.mapNotNull { it.function() }.sum()
        }

    private fun Long.part1InvalidOrNull(): Long? =
        takeIf {
            toString().let {
                it.length % 2 == 0 && it.take(it.length / 2) == it.drop(it.length / 2)
            }
        }

    private fun Long.part2InvalidOrNull(): Long? =
        takeIf {
            toString().let {
                (1..it.length / 2).any { n ->
                    it.windowed(n, n, true).containsSingleValue()
                }
            }
        }

    private fun <T> List<T>.containsSingleValue(): Boolean =
        this.size == 1 || this.all { it == this.first() }

    private fun parseInput(input: String): List<LongRange> =
        input.split(",")
            .map { it.split("-") }
            .map { LongRange(it.first().toLong(), it.last().toLong()) }
}