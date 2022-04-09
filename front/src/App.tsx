import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import {Navigate, Route, Routes, useNavigate} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {useAppSelector} from "./store/store";
import {FormAuth} from "./components/FormAuth";
function App() {

    const token = useAppSelector((state) => state.auth)
    const navigate = useNavigate()
    const [isAuth,] = useState(token.isAuth)


    useEffect(()=>{
        if (isAuth){
            navigate("/auth")
        }
    },[isAuth])

    return (
        <div className="App">
            <Routes>
                <Route path="/auth" element={FormAuth()}/>
            </Routes>
        </div>
    );
}

export default App;
