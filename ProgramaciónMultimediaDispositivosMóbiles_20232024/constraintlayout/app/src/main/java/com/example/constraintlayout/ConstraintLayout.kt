package com.example.constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Preview
fun EjemploGuias(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxYellow, boxGreen, boxBlue, boxMagenta) = createRefs()
        val topGuide = createGuidelineFromTop(0.2f)
        val startGuide = createGuidelineFromStart(0.2f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(boxBlue.start)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(parent.top)
                start.linkTo(boxRed.end)
                end.linkTo(parent.end)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                top.linkTo(boxYellow.bottom)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end, margin = 16.dp)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            })
    }
}

@Preview
@Composable
fun EjemploBarreras(){
    ConstraintLayout(Modifier.fillMaxSize()) {

        val (boxRed, boxGreen, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxRed, boxGreen)

        Box(modifier = Modifier
            .size(25.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start, margin = 16.dp)
            }
        )
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxGreen.bottom)
                start.linkTo(parent.start, margin = 32.dp)
            }
        )

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(barrier)
            }
        )

    }
}

@Preview
@Composable
fun EjemploCadenas(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()

        Box(modifier = Modifier
            .size(60.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start)
                end.linkTo(boxRed.start)
            }
        )
        Box(modifier = Modifier
            .size(60.dp)
            .background(Color.Red)
            .constrainAs(boxRed){
                start.linkTo(boxGreen.end)
                end.linkTo(boxYellow.start)
            }
        )

        Box(modifier = Modifier
            .size(60.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow){
                start.linkTo(boxRed.end)
                end.linkTo(parent.end)
            }
        )

        createHorizontalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.Spread)
    }
}