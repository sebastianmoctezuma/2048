package com.example.a2048game.componentes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun juego(){
        Box(modifier = Modifier.background(Color(0xFFFAF8EF)).fillMaxSize(), contentAlignment = Alignment.Center){
            Column() {
                Row() {
                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFD3B8A6)).border(5.dp,Color(0xFF776E65))){
                        Text(text="4", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp)
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFE86C6C)).border(5.dp,Color(0xFF776E65))){
                        Text(text="32", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White )
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFE78F58)).border(5.dp,Color(0xFF776E65))){
                        Text(text="8", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFE86C6C)).border(5.dp,Color(0xFF776E65))){
                        Text(text="32", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                    }

                }
                Row() {
                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFB79D8E)).border(5.dp,Color(0xFF776E65))){
                        Text(text="", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp)
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFF68C50)).border(5.dp,Color(0xFF776E65))){
                        Text(text="16", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White )
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFEC591F)).border(5.dp,Color(0xFF776E65))){
                        Text(text="64", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFD3B8A6)).border(5.dp,Color(0xFF776E65))){
                        Text(text="4", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.Black)
                    }
                }
                Row() {
                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFB79D8E)).border(5.dp,Color(0xFF776E65))){
                        Text(text="", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp)
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFDACFC4)).border(5.dp,Color(0xFF776E65))){
                        Text(text="2", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color(
                            0xFF563320
                        )
                        )
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFFFC308)).border(5.dp,Color(0xFF776E65))){
                        Text(text="128", modifier = Modifier.align(Alignment.Center), fontSize = 20.sp, color = Color.White)
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFEC591F)).border(5.dp,Color(0xFF776E65))){
                        Text(text="64", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                    }

                }
                Row() {
                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFB79D8E)).border(5.dp,Color(0xFF776E65))){
                        Text(text="", modifier = Modifier.align(Alignment.Center), fontSize = 40.sp)
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFB79D8E)).border(5.dp,Color(0xFF776E65))){
                        Text(text="", modifier = Modifier.align(Alignment.Center), fontSize = 40.sp, color = Color.White )
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFE78F58)).border(5.dp,Color(0xFF776E65))){
                        Text(text="8", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                    }

                    Box(modifier = Modifier.height(50.dp).width(50.dp).background(Color(0xFFB79D8E)).border(5.dp,Color(0xFF776E65))){
                        Text(text="", modifier = Modifier.align(Alignment.Center), fontSize = 40.sp, color = Color.White)
                    }

                }
            }

        }

    }

