package ru.alexandra_incr.authorssupervision.exceptions

data class PasswordException(override val message:String) : Exception(message)
