package com.example.truecost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.truecost.ui.navigation.AppStart
import com.example.truecost.ui.theme.TrueCostTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrueCostTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppStart()
                }
            }
        }
    }
}

