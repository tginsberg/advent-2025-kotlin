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

import com.ginsberg.advent2025.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 7")
class Day08Test {

    // Arrange
    private val input = """
    162,817,812
    57,618,57
    906,360,560
    592,479,940
    352,342,300
    466,668,158
    542,29,236
    431,825,988
    739,650,466
    52,470,668
    216,146,977
    819,987,18
    117,168,530
    805,96,715
    346,949,466
    970,615,88
    941,993,340
    862,61,35
    984,92,344
    425,690,689
    """.trimIndent().lines()
    
    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day08(input).solvePart1(10)

            // Assert
            assertThat(answer).isEqualTo(40)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(140_008)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day08(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(25_272)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(9_253_260_633)
        }
    }
}