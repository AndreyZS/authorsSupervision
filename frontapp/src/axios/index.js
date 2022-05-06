import axios from "axios";
const loginConfig={
    baseURL: "http://localhost:7000",
}

export const LoginAPIInstant = axios.create(loginConfig)

const defaultConfig={
    baseURL: "http://localhost:7000",
    header:{
        'Content-Type':'application/json'
    }
}

export const DefaultAPIInstant = axios.create(loginConfig)