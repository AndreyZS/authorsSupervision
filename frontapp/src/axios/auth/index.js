import {LoginAPIInstant,DefaultAPIInstant} from "@/axios"


export const AuthAPI = {
    /**
     * @param{string} login
     * @param{string} password
     * */
    login(login,password){
        const url = "auth/login?login="+login+"&password="+password
        return LoginAPIInstant.get(url)
    }
}