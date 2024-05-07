package com.example.testproject.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproject.R
import com.example.testproject.data.vm.MainViewModel

@ExperimentalComposeUiApi
@Composable
fun MainScreen() {
    // Logics

//    val email = viewModel.email.collectAsState()
//    val password = viewModel.password.collectAsState()
//    val autoLoginClicked = viewModel.autoLoginClicked.collectAsState()
//    val pwdVisibilityClicked = viewModel.pwdVisibilityClicked.collectAsState()
//
//    val focusRequester = remember { FocusRequester() }

    // Views
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp)
            .imePadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "test")
    }

        /*Image(painter = painterResource(id = R.drawable.applogo), contentDescription = null)

        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        Image(
            painter = painterResource(id = R.drawable.apptitle), contentDescription = null
        )

        Spacer(modifier = Modifier.padding(vertical = 40.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .clip(shape = RoundedCornerShape(18.dp))
                .background(Color(0xffF3F3F3)),
            value = email.value,
            onValueChange = { text ->
                viewModel.setEmail(text)
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent, focusedBorderColor = Color.Transparent
            ),
            maxLines = 1,
            placeholder = {
                Text(text = "이메일 입력", color = Color(0xffA9A9A9))
            },
            textStyle = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { viewModel.setEmail("") }) {
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.deleteemail),
                        contentDescription = null
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = {}),
        )

        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .clip(shape = RoundedCornerShape(18.dp))
            .background(Color(0xffF3F3F3)),
            value = password.value,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent, focusedBorderColor = Color.Transparent
            ),
            onValueChange = { text ->
                viewModel.setPassWord(text)
            },
            maxLines = 1,
            placeholder = {
                Text(text = "비밀번호 입력", color = Color(0xffA9A9A9))
            },
            textStyle = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { viewModel.setPwdVisibilityClicked() }) {
                    Image(
                        modifier = Modifier.size(24.dp), painter = painterResource(
                            id = if (pwdVisibilityClicked.value) R.drawable.nonshow else R.drawable.show
                        ), contentDescription = null
                    )
                }
            },
            visualTransformation = if (pwdVisibilityClicked.value) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {

            }))

        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                modifier = Modifier.clickable {
                    Log.d("MainScreen", "${viewModel.autoLoginClicked.value}")
                    viewModel.setAutoLoginClicked()
                },
                painter = painterResource(id = if (autoLoginClicked.value) R.drawable.clicked else R.drawable.nonclicked),
                contentDescription = null
            )

            Spacer(modifier = Modifier.padding(horizontal = 3.dp))

            Text(text = "자동 로그인", fontWeight = FontWeight(700), fontSize = 15.sp)
        }

        Spacer(modifier = Modifier.padding(vertical = 20.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(Color(0xffFFDAB9)),
            shape = RoundedCornerShape(18.dp),
            onClick = { Log.d("MainScreen", "클릭") },
        ) {
            Text(
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
                color = Color(0xff424242),
                text = "로그인",
                fontWeight = FontWeight(800),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "비밀번호 찾기",
                fontWeight = FontWeight(700),
                fontSize = 15.sp,
                color = Color(0xff9E9E9E)
            )

            Text(text = "회원가입", fontWeight = FontWeight(700), fontSize = 15.sp)
        }
    }*/
}

@ExperimentalComposeUiApi
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun MainScreenPreview() {
    Scaffold {
        MainScreen()
    }
}