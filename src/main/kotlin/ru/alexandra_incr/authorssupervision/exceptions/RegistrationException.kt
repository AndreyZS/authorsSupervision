package ru.alexandra_incr.authorssupervision.exceptions

data class RegistrationException(override val message:String) : Exception(message)