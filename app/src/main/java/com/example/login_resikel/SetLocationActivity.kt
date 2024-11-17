package com.example.login_resikel

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_resikel.ui.theme.Login_ResikelTheme
import com.example.login_resikel.ui.theme.SearchContainer
import com.example.login_resikel.ui.theme.iconWithBackground


class SetLocationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login_ResikelTheme {
                SetLocationScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SetLocationScreen() {
    val context = LocalContext.current
    val activity = context as? ComponentActivity

    activity?.window?.let { window ->
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val insetsController = window.insetsController
            insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
            window.statusBarColor = Color.Transparent.toArgb()
        }
    }
    Scaffold(
        topBar = {SearchContainer("Specify the address", 24.dp, 24.dp, 16.dp, 32.dp)},
        bottomBar = { SetPickUpLocationSection() },
        contentWindowInsets = WindowInsets.systemBars,
    ) {
        Box(modifier = Modifier
            .fillMaxSize()){
            MapSection()
        }
    }
}

@Composable
fun MapSection() {
    Image(
        painter = painterResource(id = R.drawable.map_example),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetPickUpLocationSection() {
    val isOpen = remember { mutableStateOf(false) }
    val isButtonClicked = remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .shadow(12.dp, shape = RoundedCornerShape(8.dp))
            .background(Color.White)
    ) {
        // BUTTON TRIGGER CLOSE/OPEN
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrowup),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .graphicsLayer(
                        scaleY = if (!isButtonClicked.value) -1f else 1f,
                        scaleX = 1f
                    )
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        isOpen.value = !isOpen.value
                        isButtonClicked.value = !isButtonClicked.value
                    },
                tint = Color.Unspecified,
            )
        }

        // CONTAINER YANG DI TARGET BUTTON
        AnimatedVisibility(visible = isOpen.value) {
            val isMotorClicked = remember { mutableStateOf(false) }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.White)
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp)
                            .padding(bottom = 12.dp)
                            .background(
                                color = colorResource(id = R.color.grey2),
                                shape = RoundedCornerShape(24.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .weight(4f)
                            ) {

                                // KOLOM INPUT START LOC
                                Row(
                                    modifier = Modifier
                                        .wrapContentSize()
                                        .padding(bottom = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                )  {
                                    iconWithBackground(imageIcon = painterResource(id = R.drawable.homev2),
                                        iconSize = 20.dp,
                                        iconColor = Color.White,
                                        backgroundSize = 64.dp,
                                        backgroundRadius = 99.dp)

                                    TextField(
                                        value = "",
                                        onValueChange = {},
                                        modifier = Modifier.fillMaxWidth(),
                                        placeholder = { Text(text = "Start location / Home",
                                            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(10), color = colorResource(id = R.color.main_green)) },
                                        textStyle = TextStyle(
                                            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                                            fontSize = 10.sp
                                        ),
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = Color.Transparent,
                                            cursorColor = Color.Black,
                                            focusedIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            disabledIndicatorColor = Color.Transparent
                                        )
                                    )
                                }

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(2.dp)
                                        .background(colorResource(id = R.color.grey3))
                                ) {
                                }

                                // KOLOM INPUT END LOC
                                Row(
                                    modifier = Modifier
                                        .wrapContentSize()
                                        .padding(top = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                )  {
                                    iconWithBackground(imageIcon = painterResource(id = R.drawable.location),
                                        iconSize = 20.dp,
                                        iconColor = Color.White,
                                        backgroundSize = 64.dp,
                                        backgroundColor = colorResource(id = R.color.light_green2),
                                        backgroundRadius = 99.dp)

                                    TextField(
                                        value = "",
                                        onValueChange = {},
                                        modifier = Modifier.fillMaxWidth(),
                                        placeholder = { Text(text = "Nearby waste station",
                                            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(10),
                                            color = colorResource(id = R.color.main_green)) },
                                        textStyle = TextStyle(
                                            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                                            fontSize = 10.sp
                                        ),
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = Color.Transparent,
                                            cursorColor = Color.Black,
                                            focusedIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            disabledIndicatorColor = Color.Transparent
                                        )
                                    )
                                }
                            }
                            Icon(
                                painter = painterResource(id = R.drawable.swap),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                                    .weight(1f),
                                tint = colorResource(id = R.color.dark_grey2)
                            )
                        }
                    }

                    // CONTAINER PILIH TIPE JEMPUT
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp, vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        // kolom motor
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(72.dp)
                            .weight(if (isMotorClicked.value) 2f else 1f)
                            .padding(horizontal = 8.dp)
                            .background(
                                color = if (isMotorClicked.value) colorResource(id = R.color.main_green) else Color.White,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ) {
                                if (isMotorClicked.value != true) isMotorClicked.value =
                                    !isMotorClicked.value
                            }
                            .border(
                                width = 1.dp,
                                color = colorResource(id = R.color.main_green),
                                shape = RoundedCornerShape(12.dp)
                            ),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically)

                        {
                            Icon(
                                painter = painterResource(id = R.drawable.motor),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp),
                                tint = if(isMotorClicked.value) colorResource(id = R.color.white) else colorResource(
                                    id = R.color.main_green
                                )
                            )

                            androidx.compose.animation.AnimatedVisibility(visible = isMotorClicked.value) {
                                Column(
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .fillMaxHeight()
                                        .padding(start = 8.dp),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "Motorcylce",
                                        modifier = Modifier
                                            .padding(top = 2.dp),
                                        fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,
                                        color = colorResource(id = R.color.white),
                                    )
                                    Text(
                                        text = "Estimated time 30m",
                                        modifier = Modifier
                                            .padding(bottom = 2.dp),
                                        fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                                        fontSize = 10.sp,
                                        color = colorResource(id = R.color.white),
                                    )
                                }
                            }
                        }

                        // kolom truk
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(72.dp)
                            .weight(if (!isMotorClicked.value) 2f else 1f)
                            .padding(horizontal = 8.dp)
                            .background(
                                color = if (!isMotorClicked.value) colorResource(id = R.color.main_green) else Color.White,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ) {
                                if (isMotorClicked.value == true) isMotorClicked.value =
                                    !isMotorClicked.value
                            }
                            .border(
                                width = 1.dp,
                                color = colorResource(id = R.color.main_green),
                                shape = RoundedCornerShape(12.dp)
                            ),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically)

                        {
                            Icon(
                                painter = painterResource(id = R.drawable.truck),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp),
                                tint = if(!isMotorClicked.value) colorResource(id = R.color.white) else colorResource(
                                    id = R.color.main_green
                                )
                            )

                            androidx.compose.animation.AnimatedVisibility(visible = !isMotorClicked.value) {
                                Column(
                                    modifier = Modifier
                                        .wrapContentSize()
                                        .padding(start = 8.dp),
                                    verticalArrangement = Arrangement.Center) {
                                    Text(
                                        modifier = Modifier
                                            .padding(0.dp),
                                        text = "Cargo / Truck",
                                        fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,
                                        color = colorResource(id = R.color.white),
                                    )
                                    Text(
                                        modifier = Modifier
                                            .padding(0.dp),
                                        text = "Estimated time 30m",
                                        fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                                        fontSize = 10.sp,
                                        color = colorResource(id = R.color.white),
                                    )
                                }
                            }
                        }

                    }
                }
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .padding(top = 24.dp, bottom = 64.dp)
                .background(
                    color = colorResource(id = R.color.light_green2),
                    shape = RoundedCornerShape(36.dp)
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    val intent = Intent(context, TrackingOrderActivity::class.java)
                    context.startActivity(intent)
                }
        ) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.order),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )

                Text(
                    text = "Buat Pesanan",
                    modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 8.dp),
                    fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white),
                )
            }
        }
    }
}