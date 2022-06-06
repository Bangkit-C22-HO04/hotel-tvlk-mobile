package com.traveloka.hotel.component.form

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.traveloka.hotel.ui.theme.Grey
import com.traveloka.hotel.ui.theme.GreyLight

@Composable
fun BaseField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    title: String,
    onClick: () -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions()
) {
    Column {

        FormTitle(title)
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            enabled = enabled,
            readOnly = readOnly,
            modifier = modifier
                .fillMaxWidth()
                .clickable { onClick() },
            value = value,
            singleLine = true,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = GreyLight,
                disabledTextColor = LocalContentColor.current.copy(LocalContentAlpha.current),
                placeholderColor = Grey
            ),
            shape = RoundedCornerShape(12.dp),
            placeholder = { Text(text = placeholder) },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            trailingIcon = trailingIcon
        )
    }
}