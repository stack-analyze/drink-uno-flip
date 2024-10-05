package com.stackanlyze.drinkunoflip.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.stackanlyze.drinkunoflip.R.drawable.salta
import com.stackanlyze.drinkunoflip.R.drawable.toma1
import com.stackanlyze.drinkunoflip.R.drawable.toma5
import com.stackanlyze.drinkunoflip.R.drawable.comodin_toma2
import com.stackanlyze.drinkunoflip.R.drawable.comodin_toma_un_color
import com.stackanlyze.drinkunoflip.R.drawable.reversa_claro
import com.stackanlyze.drinkunoflip.R.drawable.reversa_oscuro
import com.stackanlyze.drinkunoflip.R.drawable.salta_todos

data class Rule(
    val title: String,
    val shotUnit: String,
    val card: (@Composable () -> Unit)? = null,
)

val cardSize = Modifier.size(80.dp)

val commonDrinks: List<Rule> = listOf(
    Rule(
        title = "ganar la partida",
        shotUnit = "elige un jugador al azar y se toma tres shots.",
    ),
    Rule(
        title = "falso uno",
        shotUnit = "toma tres shots.",
    ),
)

val lightDrinks: List<Rule> = listOf(
    Rule(
        title = "reversa (claro)",
        shotUnit = "el jugador que le cambiaron la dirección toma un shot",
    ) {
        Image(
            painter = painterResource(id = reversa_claro),
            contentDescription = "revesa claro", modifier = cardSize
        )
    },
    Rule(
        title = "salta",
        shotUnit = "el jugador que perdió el turno se toma un shot.",
    ) {
        Image(
            painter = painterResource(id = salta),
            contentDescription = "salta", modifier = cardSize
        )
    },
    Rule(
        title = "toma 1",
        shotUnit = "toma un shot.",
    ) {
        Image(
            painter = painterResource(id = toma1),
            contentDescription = "toma 1", modifier = cardSize
        )
    },
    Rule(
        title = "comodín toma 2",
        shotUnit = "toma dos shots.",
    ) {
        Image(
            painter = painterResource(id = comodin_toma2),
            contentDescription = "comodín toma 2", modifier = cardSize
        )
    },
)

val darkDrinks: List<Rule> = listOf(
    Rule(
        title = "reversa (oscuro)",
        shotUnit = "el jugador que le cambiaron la dirección toma dos shots",
    ) {
        Image(
            painter = painterResource(id = reversa_oscuro),
            contentDescription = "reversa oscuro", modifier = cardSize
        )
    },
    Rule(
        title = "salta a todos",
        shotUnit = "todos los jugadores que perdieron su turno se toma un shot.",
    ) {
        Image(
            painter = painterResource(id = salta_todos),
            contentDescription = "salta a todos", modifier = cardSize
        )
    },
    Rule(
        title = "toma 5",
        shotUnit = "toma cuatro shots.",
    ) {
        Image(
            painter = painterResource(id = toma5),
            contentDescription = "toma 5", modifier = cardSize
        )
    },
    Rule(
        title = "toma un color",
        shotUnit = """
        el jugador debe tomar cartas hasta que le salga el color estipulado.se debe tomar la cantidad de shot basado en n ° total de cartas:
            caso 1: si tomo una carta o dos se toma un shot.
            caso 2 si agarro mas de tres cartas se toma dos o mas shots.
        """.trimIndent(),
    ) {
        Image(
            painter = painterResource(id = comodin_toma_un_color),
            contentDescription = "toma un color", modifier = cardSize
        )
    },
)