package com.example.a2048game.componentes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


fun obtenerColorCelda(valorCelda: Int): Color {
    return when (valorCelda) {
        0 -> Color(0xFFCDC1B4) // Vacío
        2 -> Color(0xFFEEE4DA)
        4 -> Color(0xFFEDE0C8)
        8 -> Color(0xFFF2B179)
        16 -> Color(0xFFF59563)
        32 -> Color(0xFFF67C5F)
        64 -> Color(0xFFF65E3B)
        128 -> Color(0xFFEDCF72)
        256 -> Color(0xFFEDCC61)
        512 -> Color(0xFFEDC850)
        1024 -> Color(0xFFEDC53F)
        2048 -> Color(0xFFEDC22E)
        else -> Color(0xFF3C3A32)
    }
}

fun obtenerColorTexto(valorCelda: Int): Color {
    return if (valorCelda <= 4) Color(0xFF776E65) else Color.White
}

// Estado del juego
data class EstadoJuego(
    val tablero: List<List<Int>>,
    val puntuacion: Int,
    val mejorPuntuacion: Int,
    val juegoTerminado: Boolean,
    val movimientos: Int,
    val powerUpsUtilizados: Int
)

@Preview(showBackground = true)
@Composable
fun PantallaPrincipal() {
    var tablero by remember { mutableStateOf(List(4) { List(4) { 0 } }) } // Tablero vacío inicial
    var puntuacion by remember { mutableStateOf(0) }
    var mejorPuntuacion by remember { mutableStateOf(0) }
    var juegoTerminado by remember { mutableStateOf(false) }
    var nombreUsuario by remember { mutableStateOf("") }
    var movimientos by remember { mutableStateOf(0) }
    var powerUpsUtilizados by remember { mutableStateOf(0) } // Ejemplo para game over
    var mostrarPantalla1 by remember { mutableStateOf(false) } // Para icono menu (pantalla actividad 01)
    var mostrarPantalla2 by remember { mutableStateOf(false) } // Para icono refresh (pantalla actividad 01)

    // resetear juego
    fun reiniciarJuego() {
        tablero = List(4) { List(4) { 0 } }
        puntuacion = 0
        mejorPuntuacion = 0
        juegoTerminado = false
        movimientos = 0
        powerUpsUtilizados = 0
    }

    // aumentar numero dentro de la celda
    fun actualizarCelda(fila: Int, columna: Int) {
        if (juegoTerminado) return
        val valorActual = tablero[fila][columna]
        val nuevoValor = if (valorActual == 0) 2 else (valorActual * 2)
        val nuevoTablero = tablero.mapIndexed { indiceFila, listaFila ->
            if (indiceFila == fila) listaFila.mapIndexed { indiceColumna, valorCelda -> if (indiceColumna == columna) nuevoValor else valorCelda } else listaFila
        }
        tablero = nuevoTablero
        puntuacion = nuevoTablero.flatten().sum()
        val nuevaMejorPuntuacion = nuevoTablero.flatten().maxOrNull() ?: 0
        if (nuevaMejorPuntuacion > mejorPuntuacion) mejorPuntuacion = nuevaMejorPuntuacion
        movimientos++
        if (nuevaMejorPuntuacion > 2048) juegoTerminado = true
    }


    if (mostrarPantalla1) {

        Text("Placeholder: Primera pantalla de Actividad 01")
        return
    }
    if (mostrarPantalla2) {

        Text("Placeholder: Segunda pantalla de Actividad 01")
        return
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF8EF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            if (!juegoTerminado) {
                Arriba(
                    alClickMenu = { mostrarPantalla1 = true },
                    alClickActualizar = { mostrarPantalla2 = true } // Asumiendo refresh es el segundo icono
                )

                Spacer(modifier = Modifier.height(12.dp))

                Divider(color = Color(0xFFE6DED5), thickness = 1.dp)

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CajaPuntuacion(etiqueta = "SCORE", valorPuntos = puntuacion.toString())
                    CajaPuntuacion(etiqueta = "BEST", valorPuntos = mejorPuntuacion.toString())
                }

                Spacer(modifier = Modifier.height(12.dp))
            } else {
                ArribaJuegoTerminado(
                    puntuacion = puntuacion,
                    movimientos = movimientos,
                    powerUpsUtilizados = powerUpsUtilizados
                )

                Spacer(modifier = Modifier.height(12.dp))

                Divider(color = Color(0xFFE6DED5), thickness = 1.dp)

                Spacer(modifier = Modifier.height(12.dp))
            }

            Tabla(
                tablero = tablero,
                alClickCelda = if (!juegoTerminado) ::actualizarCelda else { _, _ -> }
            )

            Spacer(modifier = Modifier.weight(1f))

            if (!juegoTerminado) {
                BotonesInferiores()
            } else {
                BotonesJuegoTerminado(
                    alJugarDeNuevo = { reiniciarJuego() },
                    alDeshacer = {
                        // Undo
                        if (movimientos > 0) {

                            var encontrado = false
                            val nuevoTablero = tablero.map { listaFila ->
                                listaFila.map { valorCelda ->
                                    if (!encontrado && valorCelda > 0) {
                                        encontrado = true
                                        valorCelda / 2
                                    } else valorCelda
                                }
                            }
                            tablero = nuevoTablero
                            puntuacion = nuevoTablero.flatten().sum()
                            mejorPuntuacion = nuevoTablero.flatten().maxOrNull() ?: 0
                            movimientos--
                            juegoTerminado = mejorPuntuacion > 2048
                        }
                    }
                )

                Spacer(modifier = Modifier.height(6.dp))

                if (nombreUsuario.isNotEmpty()) {
                    Text(
                        text = "$nombreUsuario sigue participando",
                        fontSize = 14.sp,
                        color = Color(0xFF776E65),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                } else {
                    Text(
                        text = "Sigue participando",
                        fontSize = 14.sp,
                        color = Color(0xFF776E65),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // TextField paraingresar nombre
            OutlinedTextField(
                value = nombreUsuario,
                onValueChange = { nombreUsuario = it },
                label = { Text("Ingresa tu nombre") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

// iconos de arriba
@Composable
fun Arriba(alClickMenu: () -> Unit, alClickActualizar: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Box(modifier = Modifier.fillMaxWidth()) {

            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = null,
                tint = Color(0xFF776E65),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(42.dp)
                    .clickable { alClickMenu() }
            )

            Text(
                text = "2048",
                fontSize = 44.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF776E65),
                modifier = Modifier.align(Alignment.Center)
            )

            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = null,
                tint = Color(0xFF776E65),
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(42.dp)
                    .clickable { alClickActualizar() }
            )
        }
    }
}

@Composable
fun CajaPuntuacion(etiqueta: String, valorPuntos: String) {
    Box(
        modifier = Modifier
            .width(155.dp)
            .height(52.dp)
            .background(Color(0xFFBBADA0), RoundedCornerShape(10.dp))
            .padding(8.dp)
    ) {
        Column {
            Text(
                text = etiqueta,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = valorPuntos,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
        }
    }
}

// Tablero
@Composable
fun Tabla(tablero: List<List<Int>>, alClickCelda: (Int, Int) -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFBBADA0), RoundedCornerShape(14.dp))
                .padding(10.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                tablero.forEachIndexed { indiceFila, listaFila ->
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        listaFila.forEachIndexed { indiceColumna, valorCelda ->
                            Cuadro(valorCelda = valorCelda, alClick = { alClickCelda(indiceFila, indiceColumna) })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Cuadro(valorCelda: Int, alClick: () -> Unit) {
    val textoMostrar = if (valorCelda == 0) "" else valorCelda.toString()
    Box(
        modifier = Modifier
            .size(75.dp)
            .background(obtenerColorCelda(valorCelda), RoundedCornerShape(10.dp))
            .border(2.dp, Color(0xFF776E65), RoundedCornerShape(10.dp))
            .clickable { alClick() },
        contentAlignment = Alignment.Center
    ) {
        if (textoMostrar.isNotEmpty()) {
            Text(
                text = textoMostrar,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = obtenerColorTexto(valorCelda)
            )
        }
    }
}

@Composable
fun BotonesInferiores() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFEDE6DD), RoundedCornerShape(18.dp))
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                BotonIcono(Icons.Filled.ArrowBack)
                BotonIcono(Icons.Filled.Refresh)
                BotonIcono(Icons.Filled.Menu)
            }
        }
    }
}

@Composable
fun BotonIcono(iconoVector: androidx.compose.ui.graphics.vector.ImageVector) {
    Box(
        modifier = Modifier
            .size(44.dp)
            .background(Color(0xFFB8ACA0), RoundedCornerShape(14.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(imageVector = iconoVector, contentDescription = null, tint = Color.White)
    }
}

// Gameover
@Composable
fun ArribaJuegoTerminado(puntuacion: Int, movimientos: Int, powerUpsUtilizados: Int) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Game Over",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF776E65)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "$puntuacion points scored in $movimientos moves. $powerUpsUtilizados powerups used:",
            fontSize = 14.sp,
            color = Color(0xFF8B8178)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .background(Color(0xFFB8ACA0), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(text = "3", fontSize = 12.sp, color = Color(0xFF776E65)) // Ejemplo estático, haz dinámico si necesitas
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .background(Color(0xFFB8ACA0), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(text = "2", fontSize = 12.sp, color = Color(0xFF776E65)) // Ejemplo
            }
        }
    }
}

@Composable
fun BotonesJuegoTerminado(alJugarDeNuevo: () -> Unit, alDeshacer: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFEDE6DD), RoundedCornerShape(18.dp))
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

                BotonLargo(textoBoton = "Play Again", colorFondo = Color(0xFF8F857C), colorTextoBoton = Color.White) {
                    alJugarDeNuevo()
                }

                BotonLargo(textoBoton = "Undo", colorFondo = Color(0xFFF2EEE9), colorTextoBoton = Color(0xFFB8ACA0)) {
                    alDeshacer()
                }
            }
        }
    }
}

@Composable
fun BotonLargo(textoBoton: String, colorFondo: Color, colorTextoBoton: Color, alClick: () -> Unit) {
    Box(
        modifier = Modifier
            .height(44.dp)
            .width(150.dp)
            .background(colorFondo, RoundedCornerShape(12.dp))
            .clickable { alClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = textoBoton,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorTextoBoton
        )
    }
}