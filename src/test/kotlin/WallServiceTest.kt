import exceptions.PostNotFoundException
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {
    @Before
    fun clear() {
        WallService.clear()
    }

    @Test
    fun shouldAddPost() {
        val user = User(1, "Петя")
        val post = Post(1, user, "Тестовый пост")
        val post2 = Post(2, user, "Тестовый пост №2")
        val comment = Comment(1, user, "Тестовый комментарий")
        var wallService = WallService
        wallService.addPost(post, user, true)
        wallService.addPost(post2, user, true)
        val result = wallService.addComment(1, comment, false)
        Assert.assertEquals(true, result)


    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val user = User(1, "Петя")
        val post = Post(1, user, "Тестовый пост")
        val post2 = Post(2, user, "Тестовый пост №2")
        val comment = Comment(1, user, "Тестовый комментарий")
        var wallService = WallService
        wallService.addPost(post, user, false)
        wallService.addPost(post2, user, false)
        wallService.addComment(6, comment, false)


         // здесь код с вызовом функции, которая должна выкинуть PostNotFoundException
    }
}