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

import kotlin.math.pow
import kotlin.math.sqrt


data class Point3D(val x: Int, val y: Int, val z: Int) {

    fun straightLineDistanceTo(other: Point3D): Double =
        sqrt(
            (other.x - x).toDouble().pow(2) +
            (other.y - y).toDouble().pow(2) +
            (other.z - z).toDouble().pow(2)
        )

    companion object {
        fun of(input: String): Point3D =
            input.split(",").let {
                Point3D(it[0].toInt(), it[1].toInt(), it[2].toInt())
            }
    }
}