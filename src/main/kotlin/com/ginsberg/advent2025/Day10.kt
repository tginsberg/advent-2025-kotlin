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
 * Advent of Code 2025, Day 10 - Factory
 * Problem Description: http://adventofcode.com/2025/day/10
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2025/day10/
 */
class Day10(input: List<String>) {

    private val schematics: List<Schematic> = input.map { Schematic.of(it) }

    fun solvePart1(): Int =
        schematics.sumOf { solvePart1(it) }

    private fun solvePart1(schematic: Schematic): Int =
        schematic.buttons
            .combinations()
            .sortedBy { it.size }
            .first { set ->
                set.fold(0) { c, n -> c xor n } == schematic.lights
            }.size

    fun solvePart2(): Long = TODO()

    private data class Schematic(val lights: Int, val buttons: List<Int>, val joltage: List<Int>) {

        companion object {
            fun of(input: String): Schematic =
                Schematic(
                    lights = input.lightsToInt(),
                    buttons = input
                        .substringAfter(" ")
                        .substringBefore(" {")
                        .split(" ")
                        .map { it.buttonsToInt() },
                    joltage = input.substringAfter("{")
                        .substringBefore("}")
                        .split(",")
                        .map { it.toInt() }
                )

            private fun String.lightsToInt(): Int =
                this.substringAfter("[").substringBefore("]").reversed()
                    .fold(0) { carry, next ->
                        (carry shl 1) or if (next == '#') 1 else 0
                    }

            private fun String.buttonsToInt(): Int =
                this.substringAfter("(").substringBefore(")")
                    .split(",")
                    .fold(0) { carry, next ->
                        carry or (2 pow next.toInt())
                    }
        }
    }

}
