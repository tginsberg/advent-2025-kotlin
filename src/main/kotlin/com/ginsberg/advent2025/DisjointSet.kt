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

class DisjointSet<T> {
    private val parents: MutableMap<T, T> = mutableMapOf()
    private val counts: MutableMap<T, Int> = mutableMapOf()

    fun setSizes(): List<Int> = counts.values.toList()

    fun countSets(): Int = counts.size

    fun addAll(elements: Collection<T>) =
        elements.forEach { add(it) }

    fun add(element: T) {
        if(element !in parents) {
            parents[element] = element
            counts[element] = 1
        }
    }

    // Note: Assumes element is always present
    fun find(element: T): T =
        if(parents.getValue(element) == element) element
        else find(parents.getValue(element)).also {
            parents[element] = it
        }

    // Note: Assumes left and right are always present
    fun union(left: T, right: T) {
        val leftRoot = find(left)
        val rightRoot = find(right)

        if(leftRoot != rightRoot) {
            if(counts.getValue(leftRoot) < counts.getValue(rightRoot)) {
                parents[rightRoot] = leftRoot
                counts[leftRoot] = counts.getValue(leftRoot) + counts.getValue(rightRoot)
                counts.remove(rightRoot)
            } else {
                parents[leftRoot] = rightRoot
                counts[rightRoot] = counts.getValue(rightRoot) + counts.getValue(leftRoot)
                counts.remove(leftRoot)
            }
        }
    }
}