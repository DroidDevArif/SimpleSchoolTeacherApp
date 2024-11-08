package com.arifali.schoolteacherappui.ui.theme

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.arifali.schoolteacherappui.Navigation.Route
import com.arifali.schoolteacherappui.R


data class Teacher(
    val name: String,
    val specialty: String,
    val rating: Float,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavHostController) {
    val teachers = listOf(
        Teacher("Mr.Govind Kumar Sir", "Chemistry", 4.3f, R.drawable.math),
        Teacher("Mr.Rajesh Singh Sir", "Biology", 4.3f, R.drawable.teacher3),
        Teacher("Mr.Sarvjeet Singh Sir", "Mathematics", 4.3f, R.drawable.teacher4),
        Teacher("Miss. Mona Srivastva Ma'am", "Physics", 4.3f, R.drawable.youngerteacher),
        Teacher("Mr.Javed Khan", "Commerce", 4.3f, R.drawable.teacher5)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recommended List") },
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = "Back",
                        modifier = Modifier
                         .size(60.dp)
                         .padding(8.dp)
                         .clickable {

                         }
                    )
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
             .fillMaxSize()
             .padding(innerPadding)
             .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(teachers) { teacher ->
                TeacherCard(teacher, navController)
            }
        }
    }
}

@Composable
fun TeacherCard(teacher: Teacher, navController: NavHostController) {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
         .fillMaxWidth()
         .height(220.dp)
         .clickable {
          navController.navigate(Route.DetailsScreen.name)
         },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
             .fillMaxSize()
             .padding(16.dp)
             .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = teacher.imageRes),
                contentDescription = "Teacher's photo",
                modifier = Modifier
                 .size(120.dp)
                 .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Highly Recommend Teacher",
                                color = Color(0xFF6200EE),
                                fontSize = 12.sp
                            )
                            Spacer(modifier = Modifier.width(2.dp))
                            Image(
                                painter = painterResource(id = R.drawable.education),
                                contentDescription = "experience",
                                modifier = Modifier.size(12.dp)
                            )
                        }
                        Text(
                            text = teacher.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.education),
                        contentDescription = "Back",
                        modifier = Modifier
                         .size(48.dp)
                         .padding(8.dp)
                         .clickable {

                         }
                    )
                }
                Text(
                    text = teacher.specialty,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(5) { index ->
                        Icon(
                            Icons.Filled.Star,
                            contentDescription = null,
                            tint = if (index < teacher.rating.toInt()) Color(0xFFFFC107) else Color.LightGray,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = teacher.rating.toString(),
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* Handle appointment */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF945DCF))
                ) {
                    Text("See Experience")
                }
            }
        }
    }

}