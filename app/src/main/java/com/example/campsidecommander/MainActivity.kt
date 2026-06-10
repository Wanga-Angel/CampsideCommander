package com.example.campsidecommander

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Gear(
    val title: String,
    val artist: String,
    val rating: Int,
    val comments: String
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var screen by remember { mutableStateOf("home") }

            var ItemName by remember { mutableStateOf("") }
            var Category by remember { mutableStateOf("") }
            var Quantity by remember { mutableStateOf("") }
            var Comments by remember { mutableStateOf("") }

            val gear = remember { mutableStateListOf<Gear>() }
            val bgColor = remember { mutableStateOf(Color.White) }

            Surface(
                modifier = Modifier.fillMaxSize()
            ) {

                when (screen) {


                    "home" -> {

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Text(
                                text = "Campside Commander",
                                fontSize = 38.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                onClick = { screen = "playlist" },
                                modifier = Modifier.width(220.dp)
                            ) {
                                Text("")
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = { screen = "details" },
                                modifier = Modifier.width(220.dp)
                            ) {
                                Text("Display List")
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = { finish() },
                                modifier = Modifier.width(220.dp)
                            ) {
                                Text("Exit")
                            }
                        }
                    }


                }
            }
        }
    }}

