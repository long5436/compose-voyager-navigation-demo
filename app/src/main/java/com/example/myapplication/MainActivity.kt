package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.myapplication.tab.DetailTab
import com.example.myapplication.tab.HomeTab
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                TabNavigator(HomeTab) {
                    Scaffold(
                        bottomBar = {
                            val tabNavigator = LocalTabNavigator.current

                            NavigationBar {
                                listOf(HomeTab, DetailTab).forEach { item ->
                                    NavigationBarItem(
                                        label = { Text(item.options.title) },
                                        selected = tabNavigator.current == item,
                                        onClick = { tabNavigator.current = item },
                                        icon = {
                                            Icon(
                                                painter = item.options.icon!!,
                                                contentDescription = ""
                                            )
                                        }
                                    )
                                }

                            }
                        }
                    ) {
                        Column(modifier = Modifier.padding(it)) {
                            CurrentTab()
                        }
                    }
                }
//                Navigator(Screen1()) { navigator ->
//                    SlideTransition(navigator)
//                }
            }
        }
    }
}

