package com.example.login_resikel

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_resikel.ui.theme.Login_ResikelTheme

class SuccessDeliveryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login_ResikelTheme {
                CourierArrivedScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CourierArrivedScreen() {
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
        bottomBar = {buttonNext()},
        contentWindowInsets = WindowInsets.systemBars,
    ) {
        CourierArrivedBody()
    }
}

@Composable
fun buttonNext(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
        .wrapContentHeight()) {
        Box(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.main_green),
                    shape = RoundedCornerShape(36.dp)
                )
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Back to Home",
                modifier = Modifier
                    .fillMaxWidth()
                ,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                style = TextStyle(fontWeight = FontWeight.ExtraBold),
                fontSize = 16.sp,
                color = colorResource(id = R.color.white),
            )    }
    }
}

@Composable
fun CourierArrivedBody(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the image
        Image(
            painter = painterResource(id=R.drawable.deliveries),
            contentDescription = "Courier arrived illustration",
            modifier = Modifier.size(256.dp)
        )

        Text(
            text = "The courier has arrived",
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2D6A4F),
            textAlign = TextAlign.Center
        )
    }
}