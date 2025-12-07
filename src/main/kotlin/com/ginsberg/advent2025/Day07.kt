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
 * Advent of Code 2025, Day 7 - Laboratories
 * Problem Description: http://adventofcode.com/2025/day/7
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2025/day7/
 */
class Day07(private val grid: List<String>) {

    private val start: Point2D = grid.findAll('S').first()

    fun solvePart1(): Int {
        val timelines = grid.countAllPaths()
        return grid.findAll('^').count { spot ->
            spot + Point2D.NORTH in timelines
        }
    }

    fun solvePart2(): Long =
        grid.countAllPaths()
            .filter { it.key.y == grid.lastIndex }
            .values
            .sum()

    private fun List<String>.countAllPaths(): Map<Point2D, Long> =
        generateSequence(setOf(start) to mutableMapOf(start to 1L)) { (streams, pathCounts) ->
            val liveStreams = streams.flatMap { stream ->
                val streamFlowsTo = stream + Point2D.SOUTH
                when {
                    grid[streamFlowsTo] == '^' -> listOf(streamFlowsTo + Point2D.EAST, streamFlowsTo + Point2D.WEST)
                    else -> listOf(streamFlowsTo)
                }
                    .filter { it in this }
                    .onEach {
                    pathCounts[it] = pathCounts.getOrDefault(stream, 0L) + pathCounts.getOrDefault(it, 0)
                }
            }.toSet()

            if (liveStreams.isNotEmpty()) liveStreams to pathCounts
            else null
        }.last().second

    private fun List<String>.findAll(target: Char): List<Point2D> =
        flatMapIndexed { y, row ->
            row.mapIndexed { x, c ->
                if (c == target) Point2D(x, y) else null
            }.filterNotNull()
        }

    private operator fun List<String>.get(point: Point2D): Char? =
        if (this.contains(point)) this[point.y][point.x] else null

    private operator fun List<String>.contains(point: Point2D): Boolean =
        point.x in this.first().indices && point.y in this.indices

}