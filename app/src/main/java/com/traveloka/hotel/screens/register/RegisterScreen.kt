package com.traveloka.hotel.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.ui.theme.Blue
import com.traveloka.hotel.ui.theme.BlueBg
import com.traveloka.hotel.ui.theme.Grey
import com.traveloka.hotel.ui.theme.HotelmobileTheme
import com.traveloka.hotel.widgets.button.MButton
import com.traveloka.hotel.widgets.form.DateField
import com.traveloka.hotel.widgets.form.EmailField
import com.traveloka.hotel.widgets.form.PasswordField
import com.traveloka.hotel.widgets.form.RadioField


@Composable
fun RegisterScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .background(BlueBg)
            .fillMaxSize()
    ) {
        Column {

            RegisterHeader()
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .background(Color.White)
            ) {

                RegisterBody()
            }
        }
    }
}

@Composable
fun RegisterHeader() {
    Row(
        modifier = Modifier
            .padding(start = 14.dp, top = 8.dp, end = 24.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                tint = Color.White,
                modifier = Modifier.size(30.dp),
                contentDescription = "Movie Image"
            )
        }
        Text(
            text = "Register",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun RegisterBody() {
    Column(
        modifier = Modifier
            .padding(start = 24.dp, top = 28.dp, end = 24.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Welcome",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Create an account, It’s free",
            style = MaterialTheme.typography.subtitle1,
            color = Grey
        )
        Spacer(modifier = Modifier.height(25.dp))

        Form()

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Grey)) {
                    append("Already have an account? ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Blue,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Log In")
                }
            },
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        )
    }
}


@Composable
fun Form() {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }
    val options = listOf("Male", "Female")
    val genderState = remember {
        mutableStateOf(options.first())
    }
    val dateState = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        EmailField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            placeholder = "Enter your email",
            title = "Email"
        )
        PasswordField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            placeholder = "Enter your password",
            title = "Password"
        )
        PasswordField(
            value = confirmPasswordState.value,
            onValueChange = { confirmPasswordState.value = it },
            placeholder = "Enter your Confirm password",
            title = "Confirm Password"
        )
        RadioField(title = "Gender", options = options, selectedItem = genderState)
        DateField(
            onValueChange = { dateState.value = it },
            placeholder = "dd/mm/yyyy",
            title = "Birth Date"
        )

        MButton(modifier = Modifier.widthIn(min = 200.dp), text = "Register", onClick = {})
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    HotelmobileTheme {
        RegisterScreen(rememberNavController())
    }
}