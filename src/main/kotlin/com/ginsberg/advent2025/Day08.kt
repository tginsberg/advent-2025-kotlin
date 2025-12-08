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

import java.util.PriorityQueue


/**
 * Advent of Code 2025, Day 8 - Playground
 * Problem Description: http://adventofcode.com/2025/day/8
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2025/day8/
 */
class Day08(input: List<String>) {

    private val points: List<Point3D> = input.map { Point3D.of(it) }

    private val disjointSet = DisjointSet<Point3D>().apply {
        addAll(points)
    }

    private val closest: PriorityQueue<PointPair> = PriorityQueue<PointPair>().apply {
        points.forEachIndexed { index, a ->
            points.drop(index + 1).forEach { b ->
                add(PointPair(a, b))
            }
        }
    }

    fun solvePart1(connections: Int = 1_000): Int {
        repeat(connections) {
            closest.poll().let { (left, right) ->
                disjointSet.union(left, right)
            }
        }

        return disjointSet
            .setSizes()
            .sortedDescending()
            .take(3)
            .reduce { a, b -> a * b }
    }

    fun solvePart2(): Long =
        generateSequence(closest.poll()) { (left, right) ->
            disjointSet.union(left, right)
            closest.poll().takeIf { disjointSet.countSets() > 1 }
        }.last().let { (left, right) -> left.x.toLong() * right.x.toLong() }

    private data class PointPair(val a: Point3D, val b: Point3D) : Comparable<PointPair> {
        val distance: Double = a.straightLineDistanceTo(b)

        override fun compareTo(other: PointPair): Int =
            this.distance.compareTo(other.distance)
    }

}