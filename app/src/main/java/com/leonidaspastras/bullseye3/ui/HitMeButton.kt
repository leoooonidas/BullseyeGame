package com.leonidaspastras.bullseye3.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leonidaspastras.bullseye3.R

@Composable
fun HitMeButton(
    modifier: Modifier,
    onClickAction: () -> Unit
) {

    //  Wrapped the button with a box otherwise the button
    //  gets stretched to comply with the given weight
    Box(modifier = modifier
        .padding(top = 16.dp)
    ) {

        Button(
            onClick = { onClickAction() },
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.sick_red)
            )
        ) {

            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                text = "HIT ME",
                style = MaterialTheme.typography.titleMedium.copy(
                    letterSpacing = 1.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
