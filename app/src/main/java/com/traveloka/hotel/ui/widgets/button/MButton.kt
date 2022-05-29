package com.traveloka.hotel.ui.widgets.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.traveloka.hotel.ui.theme.Blue
import com.traveloka.hotel.ui.theme.HotelmobileTheme

@Composable
fun MButton(
    modifier: Modifier = Modifier,
    text: String,
    bgColor: Color = Blue,
    textColor: Color = Color.White,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = bgColor,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        onClick = onClick
    ) {
        Text(text = text, style = MaterialTheme.typography.h6)
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewMButton() {
    HotelmobileTheme {
        Box {
            MButton(text = "Button")
        }
    }
}