package ru.alexandra_incr.authorssupervision.config


enum class Roles {
    ADMIN,AnalyticsUser,MagazineDesigner,OOR,OOO,Scheduler,ReportDesigner,ChiefEngineer;
    companion object{
        fun getRoles(name:String)=
            "ROLE_${Roles.valueOf(name).name}"
    }


}