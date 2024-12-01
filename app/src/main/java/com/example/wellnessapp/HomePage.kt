package com.example.wellnessapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import com.example.wellnessapp.components.BlogItem
import com.example.wellnessapp.components.CategoryList
import com.example.wellnessapp.components.WellnessBottomAppBar
import com.example.wellnessapp.components.WellnessTopAppBar
import com.example.wellnessapp.data.blogs

@Composable
fun HomePage(navController: NavController) {
    Scaffold(
        topBar = { WellnessTopAppBar() },
        bottomBar = { WellnessBottomAppBar() }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF)) // General background color
                .padding(paddingValues)
        ) {
            Column {
                CategoryList(
                    categories = listOf(
                        "Lifestyle",
                        "Diets",
                        "Entertainment",
                        "Fitness",
                        "Skincare"
                    ),

                    )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFFFFFF)) // Set background color for LazyColumn
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(blogs) { blogPost ->
                            BlogItem(
                                blogPost = blogPost,
                                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                                onClick = { blogId ->
                                    navController.navigate("blog_details/$blogId")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}