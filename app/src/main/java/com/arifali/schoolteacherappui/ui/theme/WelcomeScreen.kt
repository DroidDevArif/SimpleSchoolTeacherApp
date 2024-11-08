package com.arifali.schoolteacherappui.ui.theme

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.arifali.schoolteacherappui.Navigation.Route
import com.arifali.schoolteacherappui.R
import kotlinx.coroutines.time.delay

@Composable
fun WelcomeScreen(navController: NavHostController, isBackgroundOne: Boolean) {
    val backgroundBrush = if (isBackgroundOne) {
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFFA270D5),
                Color(0xFF945DCF)
            )
        )
    } else {
        Brush.horizontalGradient(
            colors = listOf(
                Color(0xFF42A5F5),
                Color(0xFF1E88E5)
            )
        )
    }

    // State for controlling the text visibility
    var textVisible by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(if (textVisible) 1f else 0f)

    LaunchedEffect(Unit) {
        // Delay to simulate loading or splash effect
        delay(500) // Adjust delay as needed
        textVisible = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush)
    ) {
        // Full-size image in the background
        Image(
            painter = painterResource(id = R.drawable.youngerteacher),
            contentDescription = "Image of a teacher",
            modifier = Modifier
                .fillMaxWidth() // Change this to adjust width
                .height(600.dp) // Set a specific height
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(48.dp))
                Text(
                    text = "School Teacher",
                    color = Color.White.copy(alpha = alpha), // Apply alpha
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Inform To You",
                    color = Color.White.copy(alpha = alpha), // Apply alpha
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        navController.navigate(Route.HomeScreen.name)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6429A8)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.clip(RoundedCornerShape(8.dp))
                ) {
                    Row {
                        Text(
                            text = "Get Started",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                        Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Navigate to Home")
                    }
                }
            }
        }
    }
}