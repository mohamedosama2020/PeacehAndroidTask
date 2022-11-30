package com.mohamed.peaceandroidtask.ui.screens.posts_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.mohamed.peaceandroidtask.R
import com.mohamed.peaceandroidtask.entities.posts.UiPost
import com.mohamed.peaceandroidtask.entities.posts.uiPosts
import com.mohamed.peaceandroidtask.utils.FirebaseResources

@Composable
fun PostListView(uiPosts: List<UiPost>, modifier: Modifier) {
    LazyColumn(modifier = modifier){
        items(uiPosts.size, itemContent = { item ->
            PhotoPostCard(uiPost = uiPosts[item])
        })
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PhotoPostCard(uiPost: UiPost, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 8.dp)
            .clickable(onClick = {
                //navigateTo(ScreenSection.Comment.route)
            }),
        shape = RoundedCornerShape(16.dp),
        elevation = 3.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            val imageModifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(percent = 3))
            Row(
                modifier = Modifier.padding(top = 8.dp, bottom = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = "",
                    error = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )

                Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                    Text(
                        text = uiPost.author.name,
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = uiPost.date,
                        style = MaterialTheme.typography.caption
                    )
                }

            }
            GlideImage(
                model = FirebaseResources.getMedia(uiPost.image),
                contentDescription = null,
                modifier = imageModifier
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Post",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = uiPost.title,
                style = MaterialTheme.typography.body2
            )
            Row(modifier = Modifier.padding(top = 12.dp)) {
                Text(
                    text = "${uiPost.comments} Comments",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp)
                        .wrapContentWidth(Alignment.End)
                )
            }
        }
    }
}

@Preview
@Composable
fun PostsScreenPreview() {
    PostListView(uiPosts,Modifier.fillMaxSize())
}