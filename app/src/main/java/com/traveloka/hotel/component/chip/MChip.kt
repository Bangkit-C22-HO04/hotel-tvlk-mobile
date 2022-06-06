package com.traveloka.hotel.component.chip

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.traveloka.hotel.ui.theme.*

@Composable
fun MChip(text: String, shapeColor: Color, textColor: Color, modifier: Modifier, style: TextStyle) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = shapeColor
    ) {
        Text(
            text = text,
            style = style,
            color = textColor,
            modifier = modifier
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMButton() {
    HotelmobileTheme {
        Row {
            MChip(
                "Hotels",
                OrangeChip,
                Orange,
                Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                MaterialTheme.typography.body2
            )
            MChip(
                "Family vacation",
                BlueChip,
                Blue,
                Modifier.padding(vertical = 3.dp, horizontal = 4.dp),
                MaterialTheme.typography.caption
            )
        }
    }
}