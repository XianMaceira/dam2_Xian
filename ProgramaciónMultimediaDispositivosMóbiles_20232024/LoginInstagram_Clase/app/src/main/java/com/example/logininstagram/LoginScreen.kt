package com.example.logininstagram

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Header(modifier: Modifier){
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription ="Cierra la App",
        modifier = modifier.clickable { activity.finish() }
    )
}

@Composable
fun Body(modifier: Modifier){
    Column(
        modifier = modifier
    ) {
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }

        ImagenLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(15.dp))
        Email(email) { email = it}
        Spacer(modifier = Modifier.size(4.dp))
        Password(password) {password = it}
        Spacer(modifier = Modifier.size(4.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton()
        Spacer(modifier = Modifier.size(4.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(4.dp))
        LoginFacebook()

    }
}
@Composable
fun Footer(modifier: Modifier){
    Column( modifier = modifier.fillMaxWidth()) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
        )
        Spacer(modifier = Modifier.size(24.dp))
        SingUp()
        Spacer(modifier = Modifier.size(24.dp))
    }
}
@Composable
fun SingUp(){
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = "Don't have an account?",
            fontSize = 12.sp,
            color = Color(0xFFB5B5B5)

        )
        Text(
            text = "Sing Up",
            fontSize = 12.sp,
            color = Color(0XFF4EA8E9)
        )
    }
}




@Composable
fun LoginFacebook(){
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Logo facebook",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Continue as Brais",
            color = Color(0XFF4EA8E9),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun LoginDivider(){
    Row( Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            color = Color(0xFFB5B5B5),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.padding(12.dp)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }

}

@Composable
fun LoginButton(){
    Button(
        onClick = { /*TODO*/ },
        modifier =  Modifier.fillMaxWidth(),
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0XFF4EA8E9)
        )
    ) {
        Text(text = "Log In")
    }
}


@Composable
fun ForgotPassword(modifier: Modifier){
    Text(
        text = "Forgot password?",
        color = Color(0XFF4EA8E9),
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, onTextChanged: (String) -> Unit ){
    TextField(
        value = email,
        onValueChange = { onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email")},
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB5B5B5),
            containerColor = Color(0xFFFAFAFA),
            placeholderColor = Color(0xFFB5B5B5),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password: String, onTextChanged: (String) -> Unit ){
    var passwordvisibility by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password")},
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB5B5B5),
            containerColor = Color(0xFFFAFAFA),
            placeholderColor = Color(0xFFB5B5B5),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            var imagen = if (passwordvisibility){
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordvisibility = !passwordvisibility }) {
                Icon(imageVector = imagen, contentDescription = "show" )
            }
        },
        //leadingIcon = { Icon(imageVector = Icons.Filled.Mail, contentDescription = "emial") },
        visualTransformation = if (passwordvisibility){
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }

    )
}


@Composable
fun ImagenLogo(modifier: Modifier){
    Image(
        painter = painterResource(id = R.drawable.insta) ,
        contentDescription ="Instagram",
        modifier = modifier
    )
}