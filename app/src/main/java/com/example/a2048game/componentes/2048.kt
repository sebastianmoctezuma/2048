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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert



@Preview(showBackground = true)
@Composable
fun Juego(){
    Box(modifier = Modifier.background(Color(0xFFFAF8EF)).fillMaxSize()){
        Box(){
            Tablero(alineacion = Alignment.Center)
            Header()
            ControlesAbajo()
        }
    }
}
@Composable
fun Tablero(alineacion : Alignment){
    Box(Modifier.fillMaxSize(),contentAlignment = alineacion){
        Column() {
            Row() {
                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEDE0C8)).border(5.dp,Color(0xFF776E65))){
                    Text(text="4", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF67C5F)).border(5.dp,Color(0xFF776E65))){
                    Text(text="32", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White )
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF2B179)).border(5.dp,Color(0xFF776E65))){
                    Text(text="8", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF67C5F)).border(5.dp,Color(0xFF776E65))){
                    Text(text="32", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                }
            }

            Row() {
                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFB79D8E)).border(5.dp,Color(0xFF776E65))){
                    Text(text="", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF68C50)).border(5.dp,Color(0xFF776E65))){
                    Text(text="16", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White )
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF65E3B)).border(5.dp,Color(0xFF776E65))){
                    Text(text="64", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEDE0C8)).border(5.dp,Color(0xFF776E65))){
                    Text(text="4", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.Black)
                }
            }

            Row() {
                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFB79D8E)).border(5.dp,Color(0xFF776E65))){
                    Text(text="", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEEE4DA)).border(5.dp,Color(0xFF776E65))){
                    Text(
                        text="2",
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 25.sp,
                        color = Color(0xFF563320)
                    )
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFEDCF72)).border(5.dp,Color(0xFF776E65))){
                    Text(text="128", modifier = Modifier.align(Alignment.Center), fontSize = 20.sp, color = Color.White)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF65E3B)).border(5.dp,Color(0xFF776E65))){
                    Text(text="64", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                }
            }

            Row() {
                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFB79D8E)).border(5.dp,Color(0xFF776E65))){
                    Text(text="", modifier = Modifier.align(Alignment.Center), fontSize = 40.sp)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFB79D8E)).border(5.dp,Color(0xFF776E65))){
                    Text(text="", modifier = Modifier.align(Alignment.Center), fontSize = 40.sp, color = Color.White )
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFF2B179)).border(5.dp,Color(0xFF776E65))){
                    Text(text="8", modifier = Modifier.align(Alignment.Center), fontSize = 25.sp, color = Color.White)
                }

                Box(modifier = Modifier.height(75.dp).width(75.dp).background(Color(0xFFB79D8E)).border(5.dp,Color(0xFF776E65))){
                    Text(text="", modifier = Modifier.align(Alignment.Center), fontSize = 40.sp, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun Header(){
    Column() {
        Box(modifier = Modifier.fillMaxWidth()){
            Icon(imageVector = Icons.Default.Menu,
                contentDescription = null,
                tint = Color(0xFF776E65),
                modifier = Modifier.align(Alignment.TopStart).size(50.dp))

            Text(text="2048", fontSize =45.sp, fontWeight = FontWeight.Bold, color = Color(0xFF5B4848),
                modifier = Modifier.align(Alignment.TopCenter))

            Icon(imageVector = Icons.Default.Refresh,
                contentDescription = null,
                tint = Color(0xFF776E65),
                modifier = Modifier.align(Alignment.TopEnd).size(50.dp))
        }
        Row(){
            Box(modifier = Modifier.fillMaxWidth()){
                Box(modifier = Modifier.background(Color(0xFFD3C0B3), shape = RoundedCornerShape(15.dp)).width(180.dp).height(40.dp)){
                    Text(text="SCORE", modifier = Modifier.align(Alignment.CenterStart).padding(start = 10.dp),fontWeight = FontWeight.Bold)
                    Text(text="1692", modifier = Modifier.align(Alignment.CenterEnd).padding(end = 10.dp),fontWeight = FontWeight.Bold)
                }
                Box(modifier = Modifier.background(Color(0xFFFAF8EF), shape = RoundedCornerShape(8.dp)).width(180.dp).height(40.dp).align(Alignment.TopEnd).border(2.dp, Color(0xFFD3C0B3), shape = RoundedCornerShape(15.dp))){
                    Text(text="STOP", modifier = Modifier.align(Alignment.CenterStart).padding(start = 10.dp),fontWeight = FontWeight.Bold)
                    Text(text="7000", modifier = Modifier.align(Alignment.CenterEnd).padding(end =  10.dp),fontWeight = FontWeight.Bold)


                }


            }

        }

    }
}


@Composable
fun ControlesAbajo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(580.dp))

        Box(modifier = Modifier.width(220.dp).height(80.dp).background(Color(0xFFD3C0B3), shape = RoundedCornerShape(30.dp)),
            contentAlignment = Alignment.Center
        ) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
            ) {

                Box(modifier = Modifier.size(55.dp).background(Color(0xFFBDACA5), shape = RoundedCornerShape(15.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Undo", tint = Color(0xFF776E65), modifier = Modifier.size(28.dp))
                }

                Box(modifier = Modifier.size(55.dp).background(Color(0xFFBDACA5), shape = RoundedCornerShape(15.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refresh",
                        tint = Color(0xFF776E65),
                        modifier = Modifier.size(28.dp)
                    )
                }

                Box(modifier = Modifier.size(55.dp).background(Color(0xFFBDACA5), shape = RoundedCornerShape(15.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Menu", tint = Color(0xFF776E65), modifier = Modifier.size(28.dp)
                    )
                }
            }
        }
    }
}


