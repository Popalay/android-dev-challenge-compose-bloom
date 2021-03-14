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
package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.GardenItem
import com.example.androiddevchallenge.data.ThemeItem
import com.example.androiddevchallenge.data.getGardenItems
import com.example.androiddevchallenge.data.getThemeItems
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues

@Composable
fun HomeScreen() {
    val insets = LocalWindowInsets.current
    Scaffold(
        bottomBar = {
            BottomAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                contentPadding = insets.navigationBars.toPaddingValues()
            ) {
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Home, "Home") },
                    label = { Text("Home") },
                    selected = true,
                    onClick = {}
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.FavoriteBorder, "Favorites") },
                    label = { Text("Favorites") },
                    selected = false,
                    onClick = {}
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.AccountCircle, "Profile") },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = {}
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.ShoppingCart, "Cart") },
                    label = { Text("Cart") },
                    selected = false,
                    onClick = {}
                )
            }
        }
    ) { innerPadding ->
        var searchQuery by remember { mutableStateOf("") }
        val themeItems by remember { mutableStateOf(getThemeItems()) }
        var gardenItems by remember { mutableStateOf(getGardenItems()) }

        Column {
            Spacer(modifier = Modifier.height(40.dp - insets.statusBars.bottom.dp))
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = {
                    Text(
                        text = ("Search"),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onBackground
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        modifier = Modifier.size(18.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
            )
            Text(
                text = "Browse themes",
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp)
                    .padding(horizontal = 16.dp)
            )
            LazyRow(contentPadding = PaddingValues(16.dp)) {
                itemsIndexed(themeItems) { index, item ->
                    ThemeListItem(item)
                    if (index != themeItems.lastIndex) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
            Text(
                text = "Design your home garden",
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(horizontal = 16.dp)
            )
            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                itemsIndexed(gardenItems) { index, item ->
                    GardenListItem(
                        data = item,
                        onSelectedChange = {
                            gardenItems = gardenItems.toMutableList().apply {
                                set(indexOf(item), item.copy(isSelected = it))
                            }
                        }
                    )
                    if (index != gardenItems.lastIndex) {
                        Spacer(modifier = Modifier.height(8.dp))
                    } else {
                        Spacer(modifier = Modifier.height(innerPadding.calculateBottomPadding()))
                    }
                }
            }
        }
    }
}

@Composable
fun ThemeListItem(data: ThemeItem) {
    Card(shape = MaterialTheme.shapes.small) {
        Column {
            CoilImage(
                data = data.imageUrl,
                contentDescription = null,
                fadeIn = true,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(136.dp, 96.dp),
            )
            Text(
                text = data.title,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun GardenListItem(
    data: GardenItem,
    onSelectedChange: (isSelected: Boolean) -> Unit
) {
    Row {
        CoilImage(
            data = data.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(64.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .weight(1F)
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.paddingFromBaseline(top = 24.dp)
            )
            Text(
                text = data.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.paddingFromBaseline(bottom = 24.dp)
            )
        }
        Checkbox(
            checked = data.isSelected,
            onCheckedChange = onSelectedChange,
            modifier = Modifier.paddingFromBaseline(bottom = 24.dp)
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeLightPreview() {
    MyTheme {
        HomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeDarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}
