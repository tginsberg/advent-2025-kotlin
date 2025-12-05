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

@DisplayName("Day 5")
class Day05Test {

    // Arrange
    private val input = """
    3-5
    10-14
    16-20
    12-18
    
    1
    5
    8
    11
    17
    32
    """.trimIndent().lines()
    
    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day05(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(3)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(resourceAsListOfString("day05.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(635)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day05(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(14)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(resourceAsListOfString("day05.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(369_761_800_782_619)
        }
    }
}