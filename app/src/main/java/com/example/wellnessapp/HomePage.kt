package com.example.wellnessapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wellnessapp.components.BlogItem
import com.example.wellnessapp.components.CategoryList
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.wellnessapp.components.SearchBar
import com.example.wellnessapp.components.WellnessBottomAppBar
import com.example.wellnessapp.components.WellnessTopAppBar
import com.example.wellnessapp.data.blogs
import com.example.wellnessapp.ui.themeTheme.kt.WellnessappTheme

@Composable
fun HomePage(navController: androidx.navigation.NavController) {
    var query by remember { mutableStateOf("") }  // Search query state
    var selectedCategory by remember { mutableStateOf<String?>(null) }  // Selected category state

    // Filter blogs based on search query and selected category
    val filteredBlogs = blogs.filter { blogPost ->
        (selectedCategory == null || blogPost.category == selectedCategory) &&  // Filter by category
                (blogPost.title.contains(query, ignoreCase = true) ||  // Filter by title
                        blogPost.description.contains(query, ignoreCase = true))  // Filter by description
    }

    Scaffold(
        topBar = { WellnessTopAppBar() },
        bottomBar = { WellnessBottomAppBar() },
        modifier = Modifier.background(Color.White),
        containerColor = Color.White
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            Column(modifier = Modifier.background(Color.White)) {
                // Search Bar
                SearchBar(
                    query = query,
                    onQueryChange = { newQuery -> query = newQuery },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.White)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Category List
                CategoryList(
                    categories = listOf("Lifestyle", "Diets", "Entertainment", "Fitness", "Skincare"),
                    onCategorySelected = { category ->  // Handle category selection
                        selectedCategory = if (selectedCategory == category) null else category
                    },
                    selectedCategory = selectedCategory
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Conditionally display "No results found" or the list of blogs
                if (filteredBlogs.isEmpty()) {
                    // Display "No results found" message
                    Text(
                        text = "No results found",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                } else {
                    // Display the filtered list of blogs
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        items(filteredBlogs) { blogPost ->
                            BlogItem(
                                blogPost = blogPost,
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


@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    WellnessappTheme(darkTheme = false) {
        HomePage(navController = androidx.navigation.compose.rememberNavController())
    }
}
