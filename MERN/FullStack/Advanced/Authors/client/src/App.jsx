import { useState } from 'react'
import './App.css'
import Home from "./Main/Home"
import{ BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'

function App() {
  

  return (
    <>
      <BrowserRouter>
        <div className='App'>
          <Routes>
            <Route element={<Home/>} path= '/authors'/>
          </Routes>
        </div>
      </BrowserRouter>
    </>
  )
}

export default App
