package com.mohamed.peaceandroidtask.entities.posts

data class UiPost(
    val id: String,
    val mediaType:String,
    val media: String,
    val date: String,
    val title: String,
    val comments: Int,
    val author: Author,
    val commentsList: List<String>,
)

data class Author(
    val id: String = "",
    val email: String = "",
    val title: String = "",
    val picture: String = "",
    val name: String = "",
)

val author1 = Author(
    "1", "heinz-georg.fiedler@example.com",
    "mr", "https://randomuser.me/api/portraits/men/81.jpg",
    "Fiedler"
)
val author2 = Author(
    "2", "elisa.vincent@example.com",
    "miss", "https://randomuser.me/api/portraits/women/90.jpg",
    "Elise",
)
val uiPosts = listOf(
    UiPost(
        "1",
        "https://images.unsplash.com/photo-1595239541400-63a8eb5b3c24",
        "1974-03-12",
        "Viverra aliquet",
        "Ullam et saepe reiciendis voluptatem adipisci sit amet autem assumenda provident rerum culpa quis hic commodi nesciunt rem tenetur doloremque ipsam iure quis sunt voluptatem rerum illo velit",
        10,
        author1,
        listOf()
    ),
    UiPost(
        "2",

        "https://images.unsplash.com/photo-1473116519190-356a1463fbcf",
        "1974-03-12",
        "Lacus laoreet",
        "Et licet quocumque oculos flexeris feminas adfatim multas spectare cirratas, quibus, si nupsissent, per aetatem ter iam nixus poterat suppetere liberorum, ad usque taedium pedibus pavimenta tergentes iactari volucriter gyris, dum exprimunt innumera simulacra, quae finxere fabulae theatrales.",
        22,
        author2,
        listOf()
    )
)