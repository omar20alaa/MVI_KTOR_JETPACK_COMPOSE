package app.mvi_ktor

import app.mvi_ktor.ui.network.model.Post

data class PostState(
    val progressBar: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String? = null,
)