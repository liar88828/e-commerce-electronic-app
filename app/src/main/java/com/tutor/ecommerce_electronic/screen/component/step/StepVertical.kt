package com.tutor.ecommerce_electronic.screen.component.step

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StepsProcessVertical(modifier: Modifier = Modifier, numberOfSteps: Int, currentStep: Int) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.Start
	) {
		for (step in 0..numberOfSteps) {
			StepVertical(
//				modifier = Modifier.weight(1F),
				isCompete = step < currentStep,
				isCurrent = step == currentStep,
				first = step == 0
			)
		}
	}
}

@Composable
fun StepVertical(
	isCompete: Boolean,
	isCurrent: Boolean,
	first: Boolean = true,
	modifier: Modifier = Modifier,
) {
	val color =
		if (isCompete || isCurrent) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary
	val innerCircleColor =
		if (isCompete) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary

	Box(modifier = modifier) {
		if (!first) {
			//Line
			VerticalDivider(
				modifier = Modifier
					.align(Alignment.TopCenter)
//					.height(20.dp),
				, color = color,
				thickness = 2.dp
			)
		}

		//Circle
		Canvas(modifier = Modifier
			.size(15.dp)
			.align(Alignment.BottomEnd)
			.border(
				shape = CircleShape, width = 2.dp, color = color
			), onDraw = {
			drawCircle(color = innerCircleColor)
		})
	}
}

@Preview
@Composable
private fun StepVerticalPrev() {
	Column(
		modifier = Modifier.fillMaxHeight()
	) {

		StepVertical(isCompete = false, isCurrent = true, first = true)
		StepVertical(isCompete = false, isCurrent = true, first = false)
		StepVertical(isCompete = false, isCurrent = true, first = false)
		StepVertical(isCompete = false, isCurrent = true, first = false)
	}
}

@Preview
@Composable
fun StepsProgressVerticalPrev() {
	val currentStep = remember { mutableStateOf(1) }
	StepsProcessVertical(
		modifier = Modifier.fillMaxWidth(), numberOfSteps = 5, currentStep = currentStep.value
	)
}