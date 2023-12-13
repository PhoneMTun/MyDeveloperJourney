import React from 'react';
import {BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'; 
import './App.css'
import LandingPage from './View/LandingPage';
import Createpage from './View/Createpage';
import StatusPage from './View/StatusPage';
import StatusPage2 from './View/StatusPage2';
import StatusPage3 from './View/StatusPage3';

function App() {
  return(
      <BrowserRouter>
        <div className="App">
          <Routes>
            <Route path='/' element= {<Navigate replace to="/players/list"/>}/>
            <Route element= {<LandingPage/>} path='/players/list'/>
            <Route element= {<Createpage/>} path='/players/addplayer'/>
            <Route element= {<StatusPage/>} path='/status/game/1'/>
            <Route element= {<StatusPage2/>} path='/status/game/2'/>
            <Route element= {<StatusPage3/>} path='/status/game/3'/>
          </Routes>
        </div>
      </BrowserRouter>
  )

}

export default App
