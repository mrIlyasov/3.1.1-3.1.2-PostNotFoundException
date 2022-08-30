data class User(val userId: Int, var userName: String) {
    override fun toString(): String {
        return "$userName"
    }


}