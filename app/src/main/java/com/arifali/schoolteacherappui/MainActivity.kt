package com.arifali.schoolteacherappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph
import com.arifali.schoolteacherappui.Navigation.NavGraph
import com.arifali.schoolteacherappui.Navigation.Route
import com.arifali.schoolteacherappui.ui.theme.SchoolTeacherAppUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SchoolTeacherAppUiTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        NavGraph()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SchoolTeacherAppUiTheme {

    }
}