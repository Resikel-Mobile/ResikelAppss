package com.example.login_resikel.ui.theme

import android.app.Activity
import android.content.DialogInterface.OnClickListener
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.login_resikel.NavItem
import com.example.login_resikel.R


@Composable
fun DashedHorizontalLine(
    color: Color,
    strokeWidth: Float = 5f,
    dashLength: Float = 10f,
    gapLength: Float = 10f,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val canvasWidth = size.width
        var startX = 0f

        while (startX < canvasWidth) {
            drawLine(
                color = color,
                start = Offset(x = startX, y = 0f),
                end = Offset(x = startX + dashLength, y = 0f),
                strokeWidth = strokeWidth
            )
            startX += dashLength + gapLength
        }
    }
}

@Composable
fun DashedVerticalLine(
    color: Color,
    strokeWidth: Float = 5f,
    dashLength: Float = 10f,
    gapLength: Float = 10f,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        // Mendapatkan tinggi area gambar
        val canvasHeight = size.height
        var startY = 0f

        // Menggambar garis putus-putus secara vertikal
        while (startY < canvasHeight) {
            drawLine(
                color = color,
                start = Offset(x = 0f, y = startY),
                end = Offset(x = 0f, y = startY + dashLength),
                strokeWidth = strokeWidth
            )
            startY += dashLength + gapLength
        }
    }
}

@Composable
fun iconWithBackground(
    imageIcon: Painter,
    iconColor : Color = Color.Unspecified,
    iconSize: Dp = 16.dp,
    iconDescription : String = "iconName",
    backgroundColor: Color = colorResource(id = R.color.blue),
    backgroundSize: Dp = 56.dp,
    backgroundRadius : Dp = 99.dp,
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(backgroundSize)
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(backgroundRadius)
            )
    ) {
        Icon(
            painter = imageIcon,
            contentDescription = iconDescription,
            modifier = Modifier.size(iconSize),
            tint = iconColor
        )
    }
}


@Composable
fun SimpleTextButton(
    backgroundColor: Color,
    backgroundRadius: Dp = 16.dp,
    backgroundSize : Dp = 0.dp,
    textContent: String,
    textSize: TextUnit,
    textStyle: TextStyle =  TextStyle(fontWeight = FontWeight.Medium),
    textColor: Color,
    textPaddingVertical: Dp = 2.dp,
    textPaddingHorizontal: Dp = 2.dp,
    onClickListener: () -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = if (backgroundSize == 0.dp) {
            Modifier
                .wrapContentSize()
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(backgroundRadius)
                )
        } else {
            Modifier
                .size(backgroundSize)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(backgroundRadius)
                )
        }.clickable { onClickListener() }
    ) {
        Text(
            text = textContent,
            modifier = Modifier
                .wrapContentSize()
                .padding(
                    vertical = textPaddingVertical,
                    horizontal = textPaddingHorizontal
                ),
            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
            fontSize = textSize,
            style = textStyle,
            color = textColor,
        )
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchContainer(placeHolders: String, padding: Dp, PTop: Dp, PHorizon: Dp, elevationVal : Dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .padding(top = PTop)
            .shadow(elevationVal, shape = RoundedCornerShape(99.dp))
            .background(color = Color.White, shape = RoundedCornerShape(99.dp))
            .padding(horizontal = PHorizon)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                tint = Color.Unspecified,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = placeHolders) },
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
}


@Composable
fun HeaderSection(headerText: String, buttonColor: Int, iconColor: Int, textColor: Int){
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(56.dp)
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .background(
                    color = colorResource(buttonColor),
                    shape = RoundedCornerShape(36.dp)
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    (context as? Activity)?.finish()
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrowleft),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = colorResource(iconColor)
            )
        }
        Text(
            text = headerText,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 16.dp),
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 20.sp,
            color = colorResource(textColor),
        )
    }
}

@Composable
fun CustomBottomNavigationBar(
    navController: NavController,
    items: List<NavItem>,
    backgroundColor: Color = Color.White,
    selectedColor: Color = Color.Green,
    unselectedColor: Color = Color.Gray
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { item ->
            val isSelected = currentRoute == item.route

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
            ) {
                Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.label,
                    tint = if (isSelected) selectedColor else unselectedColor,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = item.label,
                    color = if (isSelected) selectedColor else unselectedColor,
                    fontSize = 12.sp
                )
                if (isSelected) {
                    Box(
                        modifier = Modifier
                            .height(2.dp)
                            .width(24.dp)
                            .background(selectedColor)
                    )
                }
            }
        }
    }
}