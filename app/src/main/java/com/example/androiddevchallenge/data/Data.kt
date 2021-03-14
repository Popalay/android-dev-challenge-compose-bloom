/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

data class ThemeItem(
    val title: String,
    val imageUrl: String
)

data class GardenItem(
    val title: String,
    val description: String,
    val imageUrl: String,
    val isSelected: Boolean
)

fun getThemeItems() = listOf(
    ThemeItem(
        title = "Desert chic",
        imageUrl = "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&h=480&w=800"
    ),
    ThemeItem(
        title = "Tiny terrariums",
        imageUrl = "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&h=480&w=800"
    ),
    ThemeItem(
        title = "Jungle vibes",
        imageUrl = "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&h=480&w=800"
    ),
    ThemeItem(
        title = "Easy care",
        imageUrl = "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&h=480&w=800"
    ),
    ThemeItem(
        title = "Statements",
        imageUrl = "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?auto=compress&cs=tinysrgb&h=480&w=800"
    )
)

fun getGardenItems() = listOf(
    GardenItem(
        title = "Monstera",
        description = "This is a description",
        isSelected = true,
        imageUrl = "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?auto=compress&cs=tinysrgb&h=480&w=800"
    ),
    GardenItem(
        title = "Aglaonema",
        description = "This is a description",
        isSelected = false,
        imageUrl = "https://images.pexels.com/photos/4751978/pexels-photo-4751978.jpeg?auto=compress&cs=tinysrgb&h=480&w=800"
    ),
    GardenItem(
        title = "Peace lili",
        description = "This is a description",
        isSelected = false,
        imageUrl = "https://images.pexels.com/photos/4425201/pexels-photo-4425201.jpeg?auto=compress&cs=tinysrgb&h=480&w=800"
    ),
    GardenItem(
        title = "Fiddle leaf tree",
        description = "This is a description",
        isSelected = false,
        imageUrl = "https://images.pexels.com/photos/6208087/pexels-photo-6208087.jpeg?auto=compress&cs=tinysrgb&h=480&w=800"
    ),
    GardenItem(
        title = "Snake plant",
        description = "This is a description",
        isSelected = false,
        imageUrl = "https://images.pexels.com/photos/2123482/pexels-photo-2123482.jpeg?auto=compress&cs=tinysrgb&h=480&w=800"
    ),
    GardenItem(
        title = "Pothos",
        description = "This is a description",
        isSelected = false,
        imageUrl = "https://images.pexels.com/photos/1084199/pexels-photo-1084199.jpeg?auto=compress&cs=tinysrgb&h=480&w=800"
    )
)
