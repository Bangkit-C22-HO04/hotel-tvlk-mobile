package com.traveloka.hotel.ui.widgets.chip

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.traveloka.hotel.ui.theme.HotelmobileTheme
import com.traveloka.hotel.ui.theme.Orange
import com.traveloka.hotel.ui.theme.OrangeChip
import com.traveloka.hotel.ui.widgets.button.MButton

@Composable
fun MChip(type: String) {
    Surface(
        modifier = Modifier.padding(end = 8.dp),
        shape = RoundedCornerShape(16.dp),
        color = OrangeChip
    ) {
        Text(
            text = type,
            style = MaterialTheme.typography.body2,
            color = Orange,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMButton() {
    HotelmobileTheme {
        Box {
            MChip(type = "Hotels")
        }
    }
}