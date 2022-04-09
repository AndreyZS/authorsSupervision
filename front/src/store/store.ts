import {configureStore} from "@reduxjs/toolkit";
import authStore from "./authStore";
import {TypedUseSelectorHook, useDispatch, useSelector} from "react-redux";

interface test {
    auth:{
        token: string|null,
        isAuth: boolean,
    }
}

export const store =  configureStore({
    reducer: {
        auth:authStore
    },
})

export type RootState = ReturnType<typeof store.getState>
// Inferred type: {posts: PostsState, comments: CommentsState, users: UsersState}
export type AppDispatch = typeof store.dispatch

// Use throughout your app instead of plain `useDispatch` and `useSelector`
export const useAppDispatch = () => useDispatch<AppDispatch>()
export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector