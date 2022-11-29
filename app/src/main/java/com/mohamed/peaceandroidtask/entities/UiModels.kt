package com.mohamed.peaceandroidtask.entities

data class Favorite(
    val id: Long,
    val name: String,
    val picture: String,
    val description: String,
    val photo: String
)

data class UiPost(
    val id: String, val image: String, val date: String, val title: String, val text: String,
    val likes: Int, val comments: Int,
    val owner: Owner
)

data class UiComments(
    val id: String, val text: String,val firstName: String,
    val lastName: String, val date: String, val picture: String
)

data class Owner(
    val id: String, val email: String, val title: String, val picture: String,
    val firstName: String, val lastName: String
)

val owner1 = Owner(
    "1", "heinz-georg.fiedler@example.com",
    "mr", "https://randomuser.me/api/portraits/men/81.jpg",
    "Fiedler", "Heinz-Georg"
)
val owner2 = Owner(
    "2", "elisa.vincent@example.com",
    "miss", "https://randomuser.me/api/portraits/women/90.jpg",
    "Elise", "Vincent"
)
val uiPosts = listOf(
    UiPost(
        "1",
        "https://images.unsplash.com/photo-1595239541400-63a8eb5b3c24",
        "1974-03-12",
        "Viverra aliquet",
        "Ullam et saepe reiciendis voluptatem adipisci sit amet autem assumenda provident rerum culpa quis hic commodi nesciunt rem tenetur doloremque ipsam iure quis sunt voluptatem rerum illo velit",
        10,
        11,
        owner1
    ),
    UiPost(
        "2",
        "https://images.unsplash.com/photo-1473116519190-356a1463fbcf",
        "1974-03-12",
        "Lacus laoreet",
        "Et licet quocumque oculos flexeris feminas adfatim multas spectare cirratas, quibus, si nupsissent, per aetatem ter iam nixus poterat suppetere liberorum, ad usque taedium pedibus pavimenta tergentes iactari volucriter gyris, dum exprimunt innumera simulacra, quae finxere fabulae theatrales.",
        22,
        8,
        owner2
    ))