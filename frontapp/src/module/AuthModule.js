import {AuthAPI} from "@/axios/auth";
import {DefaultAPIInstant} from "@/axios";
import { createStore } from 'vuex'
export const AuthModule = ({
    namespaced:true,

    state(){
        return{
            credentials:{
                token: localStorage.getItem("token" ) || null,
                userRole: null
            }
        }
    },

    getter:{
        getUserRole:(state)=> state.credentials.userRole
    },

    mutation:{
        setToken(state,token){
            state.credentials.token = token
            localStorage.setItem("token",token)
        },

        setUserRole(state,role){
            state.credentials.userRole = role
        },

        deleteToken(state){
            state.credentials.token = null
            localStorage.removeItem("token")
        }
    },

    actions:{
        onLogin({commit},{login,password}){
           return AuthAPI.login(login, password).then((res)=>{
                console.log(res.data.jwt)
                commit('setToken',res.data.jwt)
                DefaultAPIInstant.defaults.headers['authorization'] = `Bearer ${res.data.jwt}`
            })
        }
    }
})