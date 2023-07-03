package com.example.practice_type

import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.futured.donut.compose.DonutProgress
import app.futured.donut.compose.data.DonutConfig
import app.futured.donut.compose.data.DonutModel
import app.futured.donut.compose.data.DonutSection

@Composable
public fun ShowDonutProgress(timer: MutableState<Float>, widthSize: Dp) {
    DonutProgress(
        model = DonutModel(
            cap = 60f,
            masterProgress = 1f,
            gapWidthDegrees = 0f,
            gapAngleDegrees = 270f,
            strokeWidth = 80f,
            backgroundLineColor = Color.LightGray,
            sections = listOf(
                DonutSection(
                    //ステートフルな変数1
                    amount = timer.value,
                    color = Color.Cyan
                )
            )
        ),
        config = DonutConfig(
            gapAngleAnimationSpec = spring(),
            backgroundLineColorAnimationSpec = spring(),
            capAnimationSpec = spring(),
            gapWidthAnimationSpec = spring(),
            masterProgressAnimationSpec = spring(),
            sectionAmountAnimationSpec = spring(),
            sectionColorAnimationSpec = spring(),
            strokeWidthAnimationSpec = spring(),
        ),
        modifier = androidx.compose.ui.Modifier
            .size(widthSize - 150.dp)
            .padding(20.dp)
    )
}