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
 * Advent of Code 2025, Day 4 - Printing Department
 * Problem Description: http://adventofcode.com/2025/day/4
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2025/day4/
 */
class Day04(input: List<String>) {

    private val paper: Set<Point2D> = parseInput(input)

    fun solvePart1(): Int =
        paper.count { roll ->
            roll.neighbors().count { it in paper } < 4
        }

    fun solvePart2(): Int =
        paper.size - generateSequence(paper) { rolls ->
            rolls.filter { roll ->
                roll.neighbors().count { it in rolls } >= 4
            }.takeIf { it.size < rolls.size }?.toSet()
        }.last().size

    private fun parseInput(input: List<String>): Set<Point2D> =
        input.flatMapIndexed { x, row ->
            row.mapIndexedNotNull { y, c ->
                if (c == '@') Point2D(x, y)
                else null
            }
        }.toSet()
}