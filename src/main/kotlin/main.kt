fun main() {

    var user = User(1, "Петя")
    var post = Post(1, user, "Привет всем!")
    var post2 = Post(1, user, "Привет всем, снова!")

    var wallService = WallService

    wallService.addPost(post, user, true)
    wallService.addPost(post2, user,false)
    wallService.updatePost(2, "Я передумал!", true)
    var comment = wallService.createComment("Первый комментарий!", user )
    wallService.addComment(1, comment, true)
    println(wallService.findPost(10))



}