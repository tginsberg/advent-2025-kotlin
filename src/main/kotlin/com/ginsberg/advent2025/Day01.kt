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
 * Advent of Code 2025, Day 1 - Secret Entrance
 * Problem Description: http://adventofcode.com/2025/day/1
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2025/day1/
 */
class Day01(input: List<String>) {

    private val rotations: List<Int> = parseInput(input)

    fun solvePart1(): Int =
        rotations.runningFold(50) { dial, rotation ->
            (dial + rotation).mod(100)
        }.count { it == 0 }

    fun solvePart2(): Int =
        rotations.fold(Pair(50, 0)) { (dial, zeros), rotation ->
            val numberOfZeroCrossings: Int = if (rotation > 0) {
                (dial + rotation) / 100
            } else when (dial) {
                0 -> -rotation / 100
                else -> (-rotation - dial + 100) / 100
            }

            Pair(
                (dial + rotation).mod(100),
                zeros + numberOfZeroCrossings
            )
        }.second

    private fun parseInput(input: List<String>): List<Int> =
        input.map {
            val amount = it.drop(1).toInt()
            when (it[0]) {
                'L' -> -amount
                else -> amount
            }
        }
}