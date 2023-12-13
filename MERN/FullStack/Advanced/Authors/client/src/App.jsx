import { useState } from 'react'
import './App.css'
import Home from "./Main/Home"
import Create from "./Main/Create"
import Editpage from "./Main/Editpage"
import{ BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'

function App() {
  

  return (
    <>
      <BrowserRouter>
        <div className='App'>
          <Routes>
            <Route path='/' element = {<Navigate replace to= "/authors"/>} />
            <Route element={<Home/>} path= '/authors'/>
            <Route element= {<Create/>} path= '/authors/new'/>
            <Route element= {<Editpage/>} path= '/authors/:id'/>
          </Routes>
        </div>
      </BrowserRouter>
    </>
  )
}

export default App
