package com.example.campsidecommander

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Gear(
    val title: String,
    val comments: String,
    val category: String,
    val quantity: String
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
                                text = "Welcome to Campside Commander",
                                fontSize = 28.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                onClick = { screen = "playlist" },
                                modifier = Modifier.width(220.dp)
                            ) {
                                Text("Add to Playlist")
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


                    "playlist" -> {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Enter Song Details",
                                fontSize = 24.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            OutlinedTextField(
                                value = ItemName,
                                onValueChange = { ItemName = it },
                                label = { Text("Song Title") }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = ItemName,
                                onValueChange = { ItemName = it },
                                label = { Text("Artist Name") }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = Category,
                                onValueChange = { Category = it },
                                label = { Text("Rating (1-5)") }
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value = Comments,
                                onValueChange = { Comments = it },
                                label = { Text("Comments") }
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Row {

                                Button(
                                    onClick = {

                                        var ItemName = ItemName.trim()
                                        var Category = Category.trim()
                                        var Quantity = Quantity.trim()
                                        var Comments = Comments.trim()


                                        if (
                                            ItemName.isNotBlank() &&
                                            Category.isNotBlank() &&
                                            Quantity. isNotBlank()&&
                                            Comments.isNotBlank()

                                        ) {

                                            gear.add(
                                                Gear(
                                                    title = ItemName,
                                                    category = Category,
                                                    quantity = Quantity,
                                                    comments = Comments
                                                )
                                            )

                                            ItemName = ""
                                            Category = ""
                                            Quantity = ""
                                            Comments = ""
                                        }
                                    }
                                ) {
                                    Text("Save")
                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Button(
                                    onClick = { screen = "home" }
                                ) {
                                    Text("Home")
                                }
                            }
                        }
                    }


                    "details" -> {



                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {

                            Text(
                                text = "Display List",
                                fontSize = 24.sp
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // TABLE HEADER
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(1.dp, Color.Black)
                                    .padding(8.dp)
                            ) {
                                Text("ItemName", modifier = Modifier.weight(1f))
                                Text("Category", modifier = Modifier.weight(1f))
                                Text("Quantity", modifier = Modifier.weight(1f))
                                Text("Comments", modifier = Modifier.weight(2f))
                            }

                            LazyColumn(
                                modifier = Modifier.weight(1f)
                            ) {

                                items() { gear ->

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .border(1.dp, Color.Gray)
                                            .padding(8.dp)
                                    ) {

                                        Text(
                                            text = gear.ItemName,
                                            modifier = Modifier.weight(1f)
                                        )

                                        Text(
                                            text = gear.Category,
                                            modifier = Modifier.weight(1f)
                                        )

                                        Text(
                                            text = gear.Quantity.toString(),
                                            modifier = Modifier.weight(1f)
                                        )

                                        Text(
                                            text = gear.Comments,
                                            modifier = Modifier.weight(2f)
                                        )
                                    }
                                }
                            }


                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = { screen = "home" }
                            ) {
                                Text("Home")
                            }
                        }
                    }
                }
            }
        }
    }
}






