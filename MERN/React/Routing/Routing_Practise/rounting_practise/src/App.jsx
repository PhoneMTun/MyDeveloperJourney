import React , { useState } from 'react'
import {BrowserRouter, Link, Routes, Route, useNavigate, useParams} from "react-router-dom"
import './App.css'
import Home from './components/Home'
import Word from './components/ParamsComponents'





function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/home" element={<Home/>}/>
        <Route path="/:word" element={<Word/>}/>
        <Route path="/:word/:color/:bgcolor" element={<Word/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
