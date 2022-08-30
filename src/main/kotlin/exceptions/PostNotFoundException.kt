package exceptions

class PostNotFoundException(message: String = "Post not found") : RuntimeException(message) {
}