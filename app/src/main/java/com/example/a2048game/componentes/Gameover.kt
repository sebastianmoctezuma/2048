package com.example.a2048game.componentes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview




@Preview(showBackground = true)
@Composable
fun Gameover(){
        HeaderGameOver()
        Tabla(alineacion=Alignment.Center)
        ControlesAbajo()
    }
@Composable
fun Tabla(alineacion : Alignment){
    Box(Modifier.fillMaxSize(), contentAlignment = alineacion){
        Column() {

            Row() {
                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEEE4DA)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "2", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color(0xFF776E65))
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF67C5F)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "32", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEEE4DA)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "2", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color(0xFF776E65))
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEDE0C8)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "4", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color(0xFF776E65))
                }
            }

            Row() {
                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEDE0C8)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "4", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color(0xFF776E65))
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF65E3B)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "64", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEDE0C8)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "4", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color(0xFF776E65))
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEDCF72)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "128", modifier = Modifier.align(Alignment.Center), fontSize = 20.sp, color = Color.White)
                }
            }

            Row() {
                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF2B179)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "8", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEDCC61)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "256", modifier = Modifier.align(Alignment.Center), fontSize = 20.sp, color = Color.White)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEDC850)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "512", modifier = Modifier.align(Alignment.Center), fontSize = 20.sp, color = Color.White)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF2B179)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "8", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                }
            }

            Row() {
                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEDE0C8)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "4", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color(0xFF776E65))
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF2B179)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "8", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEEE4DA)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "2", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color(0xFF776E65))
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEDE0C8)).border(5.dp, Color(0xFF776E65))){
                    Text(text = "4", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color(0xFF776E65))
                }
            }
        }
    }
}

@Composable
fun ControlesAbajo(){
    Row( modifier = Modifier.fillMaxSize().padding(bottom = 200.dp), horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ){

        Box(modifier = Modifier.height(45.dp).width(180.dp)
            .background(Color(0xFF9E8F80), shape = RoundedCornerShape(12.dp))
            .border(2.dp, Color(0xFF9E8F80), shape = RoundedCornerShape(12.dp))){
            Text(text = "Play Again", modifier = Modifier.align(Alignment.Center), fontSize = 18.sp, color = Color.White)
        }

        Box(modifier = Modifier.height(45.dp).width(180.dp)
            .background(Color(0xFFF5F0E6), shape = RoundedCornerShape(12.dp))
            .border(2.dp, Color(0xFFB9ADA1), shape = RoundedCornerShape(12.dp))){
            Text(text = "Undo", modifier = Modifier.align(Alignment.Center), fontSize = 18.sp, color = Color(0xFFB9ADA1))
        }
    }
}


@Composable
fun HeaderGameOver(){
    Column(modifier = Modifier.fillMaxWidth()){

        Text(text = "Game Over", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 40.sp, color = Color(0xFF776E65), fontWeight = FontWeight.Bold)
        Text(text = "7000 points scored in 476 moves. 2 powerups used:", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 14.sp, color = Color(0xFFB9ADA1))
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){

            Box(modifier = Modifier.height(45.dp).width(45.dp).background(Color(0xFFB9ADA1), shape = RoundedCornerShape(10.dp))){
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White, modifier = Modifier.align(Alignment.Center))
                Text(text = "3", modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 2.dp), fontSize = 12.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.width(15.dp))
            Box(modifier = Modifier.height(45.dp).width(45.dp).background(Color(0xFFB9ADA1), shape = RoundedCornerShape(10.dp))){
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null, tint = Color.White, modifier = Modifier.align(Alignment.Center))
                Text(text = "2", modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 2.dp), fontSize = 12.sp, color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "You're out of undos!", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 14.sp, color = Color(0xFFB9ADA1))
    }
}



