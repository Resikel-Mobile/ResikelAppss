package com.example.login_resikel

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
import com.example.login_resikel.ui.theme.HeaderSection
import com.example.login_resikel.ui.theme.Login_ResikelTheme


class TrashItemListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login_ResikelTheme {
                TrashListScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrashListScreen() {
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
        topBar = { HeaderSection(
            "Item In Your Trash",
            R.color.main_green,
            R.color.white,
            R.color.main_green
        ) },
        bottomBar = { UploadProofSection() },
        contentWindowInsets = WindowInsets.systemBars,
    ) { innerPadding ->
        val categoryItems = listOf(
            CategoryItem(
                icon = R.drawable.book, // Ganti dengan resource icon yang sesuai
                name = "Book",
                desc = "Non-Organic Paper",
                point = "1500 points/kg",
                count = 4
            ),
            CategoryItem(
                icon = R.drawable.cardboard, // Ganti dengan resource icon yang sesuai
                name = "Cardboard Box",
                desc = "Non-Organic Paper",
                point = "1500 points/kg",
                count = 3
            ),
            CategoryItem(
                icon = R.drawable.metal, // Ganti dengan resource icon yang sesuai
                name = "Metal Can",
                desc = "Metal",
                point = "2000 points/kg",
                count = 4

            ),
            CategoryItem(
                icon = R.drawable.glass, // Ganti dengan resource icon yang sesuai
                name = "Broken Lamp",
                desc = "glass",
                point = "1500 points/kg",
                count = 0
            ),
        )
        TrashItemListBody(categoryItems, modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth()
            .padding(top = 16.dp))
    }
}

@Composable
fun UploadProofSection() {
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(256.dp)
                        .padding(horizontal = 24.dp)
                        .padding(bottom = 24.dp)
                        .background(
                            color = colorResource(id = R.color.grey2),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.camera),
                            contentDescription = null,
                            modifier = Modifier
                                .size(72.dp),
                            tint = Color.Unspecified
                        )
                        Text(
                            text = "Take pictures for proof",
                            modifier = Modifier
                                .padding(vertical = 8.dp),
                            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.dark_grey),
                        )
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
                    color = colorResource(id = R.color.main_green),
                    shape = RoundedCornerShape(36.dp)
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    val intent = Intent(context, SetLocationActivity::class.java)
                    context.startActivity(intent)
                }
        ) {
            Text(
                text = "Set pick up location",
                modifier = Modifier
                    .padding(vertical = 16.dp),
                fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = colorResource(id = R.color.white),
            )
        }
    }
}




@Composable
fun TrashItemListBody(listItems: List<CategoryItem>, modifier: Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        items(listItems) { item ->
            if(item.count!=0){
                TrashListItemLayout(
                    name = item.name,
                    desc = item.desc,
                    point = item.point,
                    count = item.count,
                    icon = item.icon
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun TrashListItemLayout(name :String, desc:String, point:String, count:Int, icon: Int){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 24.dp, vertical = 4.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 2.dp,
                    color = colorResource(id = R.color.grey2),
                    shape = RoundedCornerShape(16.dp)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(3f)
                    .size(128.dp)
                    .padding(12.dp)
                    .background(
                        colorResource(id = R.color.grey2),
                        shape = RoundedCornerShape(20.dp)
                    ),
                contentAlignment = Alignment.Center
            )
            {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    tint = Color.Unspecified,
                )
            }

            Column(
                modifier = Modifier
                    .weight(5f)
                    .padding(vertical = 24.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = name,
                    style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    textAlign = TextAlign.Start
                )

                Text(
                    text = point,
                    style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 12.sp,
                    color = colorResource(id = R.color.main_green),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                    ,
                    textAlign = TextAlign.Start
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

//                BUTTON MINUS
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(24.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(36.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = colorResource(id = R.color.black),
                                shape = RoundedCornerShape(36.dp)
                            )
                    ) {
                        Text(
                            text = "-",
                            style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 12.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }

                    Text(
                        text = count.toString(),
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 12.sp,
                        color = colorResource(id = R.color.black),
                    )

//                BUTTON PLUS
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(24.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(36.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = colorResource(id = R.color.black),
                                shape = RoundedCornerShape(36.dp)
                            )
                    ) {
                        Text(
                            text = "+",
                            style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 12.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp)
                .size(28.dp)
                .background(
                    color = colorResource(id = R.color.dark_grey),
                    shape = RoundedCornerShape(36.dp)
                )
        ) {
            Text(
                text = "x",
                style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}