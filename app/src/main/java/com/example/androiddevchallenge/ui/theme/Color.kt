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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.R

val pink100 = Color(0xFFFFF1F1)
val pink900 = Color(0xFF3F2C2C)
val white = Color(0xFFFFFFFF)
val gray = Color(0xFF232323)
val green900 = Color(0xFF2D3B2D)
val green300 = Color(0xFFB8C9B8)

@Composable
fun welcomeLogoRes() = if (MaterialTheme.colors.isLight) R.drawable.light_logo else R.drawable.dark_logo

@Composable
fun welcomeBackgroundRes() = if (MaterialTheme.colors.isLight) R.drawable.light_welcome_bg else R.drawable.dark_welcome_bg

@Composable
fun welcomeIllosRes() = if (MaterialTheme.colors.isLight) R.drawable.light_welcome_illos else R.drawable.dark_welcome_illos
