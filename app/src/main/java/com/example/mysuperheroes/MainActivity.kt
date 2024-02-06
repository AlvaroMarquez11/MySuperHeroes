package com.example.mysuperheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.supeheroes.ui.theme.SupeheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SupeheroesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeroApp()
                }
            }
        }
    }
    @Preview
    @Composable
    fun HeroPreview() {
        SupeheroesTheme(darkTheme = false) {
            HeroApp()
        }
    }

    @Preview
    @Composable
    fun HeroDarkThemePreview() {
        SupeheroesTheme (darkTheme = true) {
            HeroApp()
        }
    }
}