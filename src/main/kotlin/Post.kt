data class Post(val id: Int, val user: User, val text: String) {

    override fun toString(): String {
        return "id: $id, Пользователь: $user, Текст: $text ${this.hashCode()} "
    }
}