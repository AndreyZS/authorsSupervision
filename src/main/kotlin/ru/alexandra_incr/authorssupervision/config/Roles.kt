package ru.alexandra_incr.authorssupervision.config


enum class Roles {
    ADMIN,USER;

    fun getRoles(name:String)=
        "ROLE_${Roles.valueOf(name).name}"

}