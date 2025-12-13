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
 * Advent of Code 2025, Day 12 - Christmas Tree Farm
 * Problem Description: http://adventofcode.com/2025/day/12
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2025/day12/
 */
class Day12(input: String) {

    private val presents: List<Int> = input.split("\n\n")
        .dropLast(1)
        .map { present -> present.count { it == '#' } }

    private val treeRegions: List<TreeRegion> = input.split("\n\n")
        .last()
        .split("\n")
        .map { TreeRegion.of(it) }

    fun solvePart1(): Int =
        treeRegions.count { region ->
            region.counts.zip(presents).sumOf { (count, present) ->
                count * present
            } <= region.area
        }

    private data class TreeRegion(val area: Int, val counts: List<Int>) {

        companion object {
            fun of(input: String): TreeRegion =
                TreeRegion(
                    input.substringBefore("x").toInt() *
                    input.substringAfter("x").substringBefore(":").toInt(),
                    input.substringAfter(" ").split(" ").map { it.toInt() }
                )
        }
    }
}
