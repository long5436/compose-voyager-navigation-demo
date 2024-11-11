package com.example.myapplication

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class Screen3 : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigate = LocalNavigator.current
        val context = LocalContext.current

        Scaffold(topBar = {
            TopAppBar(title = { Text("Hello title3") })
        }) {
            Column(modifier = Modifier.padding(it)) {
                Button(onClick = {
                    navigate?.pop()
                }) {
                    Text("Go to back")
                }

                Button(onClick = {

                    val intent = Intent(context, MainActivity2::class.java)
                    context.startActivity(intent)

                }) {
                    Text("Go to activity2")
                }
            }
        }
    }
}