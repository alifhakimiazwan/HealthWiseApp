package com.example.wellnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wellnessapp.data.blogs
import com.example.wellnessapp.ui.themeTheme.kt.WellnessappTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use WindowCompat to enable edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            WellnessappTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize()

                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomePage(navController)
        }

        composable(
            route = "blog_details/{blogId}",
            arguments = listOf(navArgument("blogId") { type = NavType.StringType })
        ) { backStackEntry ->
            val blogId = backStackEntry.arguments?.getString("blogId")
            val blogPost = blogs.find { it.id == blogId }
            if (blogPost != null) {
                BlogDetailsPage(blogPost, navController)
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun WellnessPreview() {
    WellnessappTheme(darkTheme = false) {
        MainApp()
    }
}
