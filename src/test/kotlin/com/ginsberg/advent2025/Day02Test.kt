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

import com.ginsberg.advent2025.Resources.resourceAsString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day02Test {

    // Arrange
    private val input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day02(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(1227775554)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day02(resourceAsString("day02.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(35_367_539_282)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day02(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(4174379265)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day02(resourceAsString("day02.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(45_814_076_230)
        }
    }
}