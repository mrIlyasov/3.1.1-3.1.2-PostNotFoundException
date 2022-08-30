data class Comment(val id: Int, val user: User, val text: String) {
    override fun toString(): String{
        return "Пользователь $user оставил комментарий: $text "
    }
}