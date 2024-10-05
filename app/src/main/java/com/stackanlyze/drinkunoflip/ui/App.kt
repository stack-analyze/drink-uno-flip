package com.stackanlyze.drinkunoflip.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.stackanlyze.drinkunoflip.ui.theme.DrinkUnoFlipTheme
import com.stackanlyze.drinkunoflip.R.drawable.ic_dark_mode
import com.stackanlyze.drinkunoflip.R.drawable.ic_light_mode

@Composable
fun App() {
    val modifier = Modifier

    var isDarkTheme by remember { mutableStateOf(false) }

    val iconTheme = if (isDarkTheme) ic_dark_mode else ic_light_mode

    DrinkUnoFlipTheme(isDarkTheme) {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            floatingActionButton = {
                FloatingActionButton(onClick = { isDarkTheme = !isDarkTheme }) {
                    Icon(
                        painter = painterResource(id = iconTheme),
                        tint = if (!isDarkTheme) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground,
                        contentDescription = "icon theme"
                    )
                }
            },
        ) { innerPadding ->
            LazyColumn(
                modifier = modifier.padding(innerPadding)
            ) {
                items(commonDrinks) {
                    ListItem(
                        headlineContent = {
                            Text(it.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        },
                        supportingContent = { Text(it.shotUnit) }
                    )
                    HorizontalDivider()
                }

                items(if (isDarkTheme) darkDrinks else lightDrinks) {
                    ListItem(
                        headlineContent = {
                            Text(text = it.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        },
                        supportingContent = { Text(it.shotUnit) },
                        leadingContent = it.card
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}