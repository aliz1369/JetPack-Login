package com.aliz.jetpacklogin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Login() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .paint(
                painterResource(id = R.drawable.background_page),
                contentScale = ContentScale.FillHeight
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            val (topText, culm) = createRefs()
            Text(
                text = "Login Activity",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 16.dp, start = 32.dp)
                    .constrainAs(topText) {
                        linkTo(parent.top, culm.top, bias = 0.6f)
                    },
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .constrainAs(culm) {
                        bottom.linkTo(parent.bottom)
                    }
                    .background(
                        color = Color(android.graphics.Color.parseColor("#e0e0e0")),
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                    )
                    .padding(32.dp)
            ) {
                Text(
                    text = "Email",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp),
                    color = Color.Black
                )
                var text by rememberSaveable {
                    mutableStateOf("")
                }
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text(text = "Example@gmail.com") },
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        textColor = Color(android.graphics.Color.parseColor("#5e5e5e")),
                        unfocusedLabelColor = Color(android.graphics.Color.parseColor("#5e5e5e"))

                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .background(
                            Color.White,
                            CircleShape
                        )
                )
                Text(
                    text = "Password",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp),
                    color = Color.Black
                )

                var text2 by rememberSaveable {
                    mutableStateOf("")
                }

                var passwordVisible by remember { mutableStateOf(false) }
                TextField(
                    value = text2,
                    onValueChange = { text2 = it },
                    label = { Text(text = "Type your Password") },
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        // Localized description for accessibility services
                        val description = if (passwordVisible) "Hide password" else "Show password"

                        // Toggle button to hide or display password
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = image, description)
                        }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        textColor = Color(android.graphics.Color.parseColor("#5e5e5e")),
                        unfocusedLabelColor = Color(android.graphics.Color.parseColor("#5e5e5e"))

                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .background(
                            Color.White,
                            CircleShape
                        )
                )
                Text(
                    text = "Forget Your password? Recover it",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color(android.graphics.Color.parseColor("#5e5e5e"))
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .height(1.dp)
                            .weight(1f)
                            .background(Color(android.graphics.Color.parseColor("#4d4d4d")))
                    )
                    Text(
                        text = "Or Login With",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                        color = Color(android.graphics.Color.parseColor("#4d4d4d"))
                    )
                    Box(
                        modifier = Modifier
                            .height(1.dp)
                            .weight(1f)
                            .background(Color(android.graphics.Color.parseColor("#4d4d4d")))
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp, end = 8.dp)
                            .weight(0.5f)
                            .height(55.dp),
                        border = BorderStroke(
                            1.dp,
                            Color(android.graphics.Color.parseColor("#4d4d4d"))
                        ), colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ), shape = RoundedCornerShape(10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.3f),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.google),
                                contentDescription = "Google Login",
                                modifier = Modifier
                                    .width(25.dp)
                                    .clickable {})
                        }
                        Column(
                            modifier = Modifier
                                .padding(start = 14.dp)
                                .weight(0.7f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Google",
                                color = Color(android.graphics.Color.parseColor("#2f4f86")),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp, start = 8.dp)
                            .weight(0.5f)
                            .height(55.dp),
                        border = BorderStroke(
                            1.dp,
                            Color(android.graphics.Color.parseColor("#4d4d4d"))
                        ), colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ), shape = RoundedCornerShape(10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.2f),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.facebook),
                                contentDescription = "Facebook Login",
                                modifier = Modifier
                                    .width(25.dp)
                                    .clickable {})
                        }
                        Column(
                            modifier = Modifier
                                .padding(start = 14.dp)
                                .weight(0.8f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Facebook",
                                color = Color(android.graphics.Color.parseColor("#2f4f86")),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(android.graphics.Color.parseColor("#fa951a")),
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        }
    }

}