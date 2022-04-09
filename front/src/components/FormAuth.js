import React from "react";
import {Button, Grid, Paper, TextField, Typography} from "@material-ui/core";
import {AccountApiAxiosParamCreator, AccountApiFp, Configuration} from "../generated/speca";
import {TypedUseSelectorHook, useDispatch, useSelector} from "react-redux";
import {AppDispatch, RootState} from "../store/store";
import {authorization} from "../store/authStore";
import axios from "axios";

export const FormAuth = () => {

    let [login, setLogin] = React.useState("")
    let [password, setPassword] = React.useState("")
    let useAppSelector = useSelector
    const useAppDispatch = () => useDispatch()

    function auth() {
        console.log("www")
        let r = axios.get("/auth/login?login="+login+"&password="+password)
        return r
    }

    return (
        <Grid
            style={{
                height: "100vh"
            }}
            container
            direction="column"
            justifyContent="center"
            alignItems="center"
        >
            <Paper style={{
                padding: "10px",
                margin: "10px"
            }}>
                <Grid
                    container
                    direction="column"
                    justifyContent="center"
                    alignItems="center"
                >
                    <Typography>Авторизация</Typography>
                    <TextField label={"Логин"} onChange={(e) => {
                        setLogin(e.target.value)
                    }}/>
                    <TextField label={"Пароль"} type={"password"} onChange={(e) => {
                        setPassword(e.target.value)
                    }}/>
                    <Button onClick={async (e) => {
                       let w = await new AccountApiFp().auth(login, password)
                        console.log(w)
                    }}>Войти</Button>
                </Grid>
            </Paper>
        </Grid>
    )
}