package com.mohamed.peaceandroidtask.ui.screens.posts_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostsScreen(viewModel: PostsViewModel, modifier: Modifier) {

    val postsState = viewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val comments = remember { mutableStateOf(listOf<String>()) }

    BackHandler(enabled = modalBottomSheetState.isVisible) {
        coroutineScope.launch {
            modalBottomSheetState.hide()
        }
    }
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            Column(modifier = Modifier
                .defaultMinSize(minHeight = 400.dp)
                .padding(all = 24.dp).testTag("BottomSheet")) {
                Text(text = "Comments", style = MaterialTheme.typography.h5)
                LazyColumn() {
                    items(comments.value.size) { item ->
                        Spacer(modifier = Modifier.size(24.dp))
                        Text(text = comments.value[item])
                    }
                }
            }
        }
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            if (postsState.value.posts.isNotEmpty()) {
                LazyColumn {
                    items(count = postsState.value.posts.size, key = {
                        postsState.value.posts[it].id
                    }, itemContent = { item ->
                        PostCard(uiPost = postsState.value.posts[item], onClick = {
                            coroutineScope.launch {
                                comments.value = it.commentsList
                                modalBottomSheetState.show()
                            }
                        })
                    })
                }
            }
            if (postsState.value.loading){
                CircularProgressIndicator(Modifier.size(size = 35.dp))
            }
        }
    }
}