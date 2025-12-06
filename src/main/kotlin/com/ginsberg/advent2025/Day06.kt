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
 * Advent of Code 2025, Day 6 - Trash Compactor
 * Problem Description: http://adventofcode.com/2025/day/6
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2025/day6/
 */
class Day06(private val input: List<String>) {

    private val symbols: List<String> = input.last().trim().split("""\s+""".toRegex())

    fun solvePart1(): Long =
        solve(parseNumbersPart1(input))

    fun solvePart2(): Long =
        solve(parseNumbersPart2(input))

    private fun solve(numbers: Map<Int, List<Long>>): Long =
        symbols.withIndex().sumOf { (index, symbol) ->
            numbers.getValue(index).reduce { a, b ->
                if (symbol == "*") a * b
                else a + b
            }
        }

    private fun parseNumbersPart1(input: List<String>): Map<Int, List<Long>> =
        input.dropLast(1).flatMap { row ->
            row.trim().split("""\s+""".toRegex()).withIndex()
        }.groupBy({ it.index }, { it.value.toLong() })

    private fun parseNumbersPart2(input: List<String>): Map<Int, List<Long>> =
        input.first().indices
            .map { input.columnAsLongOrNull(it) }
            .fold(mutableListOf(mutableListOf<Long>())) { carry, maybeNumbers ->
                when(maybeNumbers) {
                    null -> carry.apply { add(mutableListOf()) }
                    else -> carry.apply { last().add(maybeNumbers) }
                }
            }.mapIndexed { index, list -> index to list }.toMap()

    private fun List<String>.columnAsLongOrNull(column: Int): Long? =
        dropLast(1).map { row -> row[column] }.joinToString("").trim().toLongOrNull()

}