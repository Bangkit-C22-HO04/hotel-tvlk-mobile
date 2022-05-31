package com.traveloka.hotel.ui.screens.listHotel.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.traveloka.hotel.R
import com.traveloka.hotel.ui.theme.Blue
import com.traveloka.hotel.ui.theme.BlueDark
import com.traveloka.hotel.ui.theme.Orange
import com.traveloka.hotel.utils.TRAVEL_PURPOSE_OPTIONS

@Composable
fun FilterBox() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 10.dp
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(modifier = Modifier.weight(1F)) {
                    DestinationField()
                }
                IconButton(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Blue),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(28.dp),
                        imageVector = Icons.Default.GpsFixed,
                        contentDescription = "set current location",
                        tint = Color.White
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(modifier = Modifier.weight(2F)) {
                    TravelPurposeField()
                }
                Button(
                    modifier = Modifier.weight(1F),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Orange)
                ) {
                    Text(
                        text = stringResource(R.string.search),
                        style = MaterialTheme.typography.body1,
                        color = Color.White
                    )
                }

            }
        }
    }
}

@Composable
fun DestinationField() {
    var inputText by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = inputText,
        onValueChange = { inputText = it },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
        ),
        placeholder = { Text(text = stringResource(R.string.find_your_destination) + "...") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Place,
                modifier = Modifier.size(28.dp),
                tint = BlueDark,
                contentDescription = stringResource(R.string.add_location)
            )
        })
}

@Composable
fun TravelPurposeField() {
    var expanded by remember { mutableStateOf(false) }
    val suggestions = TRAVEL_PURPOSE_OPTIONS.map { stringResource(id = it) }
    var selectedText by remember { mutableStateOf("") }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.ArrowDropUp
    else
        Icons.Filled.ArrowDropDown

    Box {
        TextField(
            singleLine = true,
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textFieldSize = coordinates.size.toSize()
                }
                .clickable { expanded = !expanded },
            value = selectedText,
            onValueChange = { selectedText = it },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                disabledTextColor = LocalContentColor.current.copy(LocalContentAlpha.current)
            ),
            enabled = false,
            placeholder = { Text(text = stringResource(R.string.travel_purpose) + "...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Moving,
                    modifier = Modifier.size(28.dp),
                    tint = BlueDark,
                    contentDescription = "Add Travel Purpose"
                )
            },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded })
            })
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .requiredSizeIn(maxHeight = 150.dp)
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                }) {
                    Text(text = label, style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}