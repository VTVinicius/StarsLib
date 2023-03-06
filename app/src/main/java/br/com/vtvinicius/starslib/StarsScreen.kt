package br.com.vtvinicius.stars.stars

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


@Composable
fun StarScreen() {

    var show by remember {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedButton(
            onClick = { show = true },
        ){
            Text(text = "Deseja Avaliar?", fontSize = 16.sp, textAlign = TextAlign.Center)
        }

        if (show) {
            DialogScore(onDismissRequest = { show = false })
        }
    }
}

@Composable
fun DialogScore(onDismissRequest: () -> Unit) {

    Dialog(onDismissRequest = { onDismissRequest() }) {

        var star by remember {
            mutableStateOf(Any())
        }

        var nota by remember {
            mutableStateOf("0")
        }

        when (star) {
            Stars.Star0 -> {
                nota = "0"
            }

            Stars.Star1 -> {
                nota = "1"
            }

            Stars.Star2 -> {
                nota = "2"
            }

            Stars.Star3 -> {
                nota = "3"
            }

            Stars.Star4 -> {
                nota = "4"
            }

            Stars.Star5 -> {
                nota = "5"
            }
        }


        Card(
            Modifier
                .fillMaxWidth()
                .padding(24.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(10.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    Modifier
                        .fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Avalie o Canvas do Vini :)",
                        modifier = Modifier.padding(16.dp),
                        fontSize = 24.sp
                    )

                }
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FiveStars(
                        onStarSelected = { star = it },
                        animStarTimeFill = 1000,
                        animStarTimeEmpty = 500
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "Obrigado pela Avaliação nota: ${nota ?: "0"}",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
                OutlinedButton(
                    onClick = { onDismissRequest() },
                ){
                    Text(text = "Enviar!", fontSize = 16.sp, textAlign = TextAlign.Center)
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }

    }
}