package com.tutor.ecommerce_electronic.screen.component.step

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StepsProgressBar(modifier: Modifier = Modifier, numberOfSteps: Int, currentStep: Int) {
	Row(
		modifier = modifier,
		verticalAlignment = Alignment.CenterVertically
	) {
		for (step in 0..numberOfSteps) {
			Step(
				modifier = Modifier.weight(1F),
				isCompete = step < currentStep,
				isCurrent = step == currentStep
			)
		}
	}
}

@Composable
fun Step(modifier: Modifier = Modifier, isCompete: Boolean, isCurrent: Boolean) {
	val color = if (isCompete || isCurrent) Color.Red else Color.LightGray
	val innerCircleColor = if (isCompete) Color.Red else Color.LightGray

	Box(modifier = modifier) {

		//Line
		HorizontalDivider(
			modifier = Modifier.align(Alignment.CenterStart),
			color = color,
			thickness = 2.dp
		)

		//Circle
		Canvas(modifier = Modifier
			.size(15.dp)
			.align(Alignment.CenterEnd)
			.border(
				shape = CircleShape,
				width = 2.dp,
				color = color
			),
			onDraw = {
				drawCircle(color = innerCircleColor)
			}
		)
	}
}

@Preview
@Composable
private fun StepPrev() {
	Step(
		modifier = Modifier,
		isCompete = true,
		isCurrent = true
	)
}

@Preview
@Composable
fun StepsProgressBarPreview() {
	val currentStep = remember { mutableStateOf(1) }
	StepsProgressBar(
		modifier = Modifier.fillMaxWidth(),
		numberOfSteps = 5,
		currentStep = currentStep.value
	)
}