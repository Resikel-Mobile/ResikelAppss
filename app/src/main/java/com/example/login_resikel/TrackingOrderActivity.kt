package com.example.login_resikel

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
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
import com.example.login_resikel.ui.theme.DashedVerticalLine
import com.example.login_resikel.ui.theme.HeaderSection
import com.example.login_resikel.ui.theme.Login_ResikelTheme
import com.example.login_resikel.ui.theme.SimpleTextButton
import com.example.login_resikel.ui.theme.iconWithBackground

class TrackingOrderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login_ResikelTheme {
                TrackingOrderScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TrackingOrderScreen(){
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
        topBar = { HeaderSection("", R.color.white, R.color.main_green, R.color.white) },
        bottomBar = {bottomSectionTrackingOrder()},
        contentWindowInsets = WindowInsets.systemBars,
    ) {
        TrackingOrderBody()
    }
}

@Composable
fun TrackingOrderBody(){
    Image(modifier = Modifier
        .fillMaxSize(),
        painter = painterResource(id = R.drawable.map_example),
        contentDescription = "map",
    )
}

@Composable
fun bottomSectionTrackingOrder(){
    Box(modifier = Modifier
        .wrapContentSize()
        .background(color = Color.White)
    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 24.dp)
            .padding(top = 24.dp, bottom = 56.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(36.dp)
            )
            .shadow(16.dp, shape = RoundedCornerShape(36.dp))
        ){
            Column(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(36.dp)
                )
                .padding(20.dp)) {


//                START LOCATION
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically) {
                    iconWithBackground(imageIcon = painterResource(id = R.drawable.location), backgroundColor = colorResource(
                        id = R.color.light_green2),
                        iconColor = Color.White)

                    Column {
                        Text(
                            text = "Waste Station Punggur",
                            modifier = Modifier
                                .wrapContentSize()
                            ,
                            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                            style = TextStyle(fontWeight = FontWeight.ExtraBold),
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.black),
                        )
                        Text(
                            text = "Telaga Punggur, Kota Batam",
                            modifier = Modifier
                                .wrapContentSize()
                            ,
                            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                            fontSize = 10.sp,
                            color = colorResource(id = R.color.black),
                        )
                    }

                }

                DashedVerticalLine(color = Color.Black, modifier = Modifier.height(16.dp).padding(start = 28.dp))

//                END LOCATION
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically) {
                    iconWithBackground(imageIcon = painterResource(id = R.drawable.homev2), backgroundColor = colorResource(
                        id = R.color.blue),
                        iconColor = Color.White)

                    Column {
                        Text(
                            text = "Meisterstadt Pollux",
                            modifier = Modifier
                                .wrapContentSize()
                            ,
                            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                            style = TextStyle(fontWeight = FontWeight.ExtraBold),
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.black),
                        )
                        Text(
                            text = "Jl. Jend. A. Yani, Taman Baloi, Batam Kota",
                            modifier = Modifier
                                .wrapContentSize()
                            ,
                            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                            fontSize = 10.sp,
                            color = colorResource(id = R.color.black),
                        )
                    }

                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 8.dp, top = 16.dp)
                    , verticalAlignment = Alignment.CenterVertically) {

                    Image(modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .weight(1f),
                        painter = painterResource(id = R.drawable.profile_icon), contentDescription ="profile" )

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                        .weight(2f)) {
                        Text(
                            text = "Milo Enak",
                            modifier = Modifier
                                .wrapContentSize()
                            ,
                            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                            style = TextStyle(fontWeight = FontWeight.ExtraBold),
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.black),
                        )
                        Text(
                            text = "BP 1274 UJA",
                            modifier = Modifier
                                .wrapContentSize()
                            ,
                            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                            fontSize = 10.sp,
                            color = colorResource(id = R.color.black),
                        )
                    }

//                    Phone Button
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(56.dp)
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .background(
                                color = colorResource(id = R.color.light_green),
                                shape = RoundedCornerShape(36.dp)
                            )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.phone),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = colorResource(id = R.color.main_green)
                        )
                    }

//                    Message Button
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(56.dp)
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .background(
                                color = colorResource(id = R.color.light_green),
                                shape = RoundedCornerShape(36.dp)
                            )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.message),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = colorResource(id = R.color.main_green)
                        )
                    }

                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 12.dp, bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.weight),
                        contentDescription = "WEIGHT",
                        modifier = Modifier
                            .weight(1f)
                            .size(28.dp))

                    Column(modifier = Modifier
                        .wrapContentSize()
                        .weight(2f)) {
                        Text(
                            text = "Garbage weight",
                            modifier = Modifier
                                .fillMaxWidth()
                            ,
                            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                            fontSize = 10.sp,
                            color = colorResource(id = R.color.black),
                        )

                        Text(
                            text = "15 KG",
                            modifier = Modifier
                                .wrapContentSize()
                            ,
                            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                            fontSize = 20.sp,
                            style = TextStyle(fontWeight = FontWeight.Thin),
                            color = colorResource(id = R.color.black),
                        )
                    }

                    Column(modifier = Modifier
                        .wrapContentSize()
                        .weight(2f)
                    ) {
                        Text(
                            text = "Status",
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(bottom = 4.dp)
                            ,
                            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                            fontSize = 10.sp,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            color = colorResource(id = R.color.black),
                        )

                        SimpleTextButton(
                            backgroundColor = colorResource(id = R.color.light_green2),
                            textContent = "Pickup",
                            backgroundRadius = 4.dp,
                            textSize = 10.sp,
                            textStyle = TextStyle(fontWeight = FontWeight.Bold),
                            textColor = Color.White,
                            textPaddingVertical = 6.dp,
                            textPaddingHorizontal = 28.dp
                        )
                    }
                }
            }
        }
    }
}