package com.example.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class Screen1 : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigate = LocalNavigator.current

        Scaffold(topBar = {
            TopAppBar(title = { Text("Hello title") })
        }) {
            Column(modifier = Modifier.padding(it)) {
                Button(onClick = {
                    navigate?.push(Screen2())
                }) {
                    Text("Go to screen 2")
                }
            }
        }
    }
}