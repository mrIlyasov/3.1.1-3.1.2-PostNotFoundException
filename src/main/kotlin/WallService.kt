import exceptions.*
import javax.swing.text.StyledEditorKit.BoldAction

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun addPost(originalPost: Post, user: User, toPrint: Boolean) {
        var post: Post
        if (posts.size == 0) {
            post = originalPost.copy(id = 1, user = user)
        } else post = originalPost.copy(id = posts.last().id + 1, user = user)
        posts += post
        if (toPrint) {
            println(posts.last())
        }
    }


    fun printPost(id: Int) {
        var postToPrint: Post? = null
        for (index in posts.indices) {
            if (posts[index].id == id) {
                postToPrint = posts[index]
            }
        }
        if (postToPrint != null)
            println(postToPrint)
        else
            throw PostNotFoundException()
    }

    fun updatePost(id: Int, newText: String, toPrint: Boolean) {
        var postToUpdate: Post? = null
        for (index in posts.indices) {
            if (posts[index].id == id) {
                postToUpdate = posts[index].copy(text = newText)
                posts[index] = postToUpdate
                if (toPrint) {
                    println(posts[index])
                }
            }
        }
        if (postToUpdate == null)
            throw PostNotFoundException()

    }

    fun createComment(text: String, user: User): Comment {
        var comment: Comment
        if (comments.size < 1) {
            comment = Comment(1, user, text)
        } else {
            comment = Comment(comments.last().id + 1, user, text)
        }
        return comment
    }





    fun clear() {
        this.comments = emptyArray()
        this.posts = emptyArray()
    }


    fun findPost(id: Int): Post?{
        for (index in posts.indices) {
            if (posts[index].id == id) {
                return posts[index]
            }
        }
        return null
    }


    fun addComment(id: Int, comment: Comment, toPrint: Boolean): Boolean {
        var commentId: Int
        if (comments.isEmpty()) {
            commentId = 0
        } else {
            commentId = comments.last().id + 1
        }
        var postToComment: Post? = findPost(id)

        if (postToComment!= null)
        {
            comments += comment.copy(id = commentId)
        }

        else
            throw PostNotFoundException()


        if (toPrint && postToComment!= null) {
            println("$comments.last() $postToComment")
        }
        return true

    }

}

