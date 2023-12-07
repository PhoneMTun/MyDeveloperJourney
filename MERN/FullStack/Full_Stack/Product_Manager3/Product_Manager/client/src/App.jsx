import './App.css'
import Create from './components/create.jsx'
import Main from './views/Main.jsx'
import { BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'
import Detail from './components/detail.jsx'
import Update from './components/update.jsx'


function App() {


  return (
    <div>
      <BrowserRouter>
        <div className='App'>
          <Routes>
            <Route path="/" element={<Navigate replace to="/products" />} />
            <Route element={<Main/>} path='/products' default />
            <Route element={<Detail/>} path='/products/:id'/>
            <Route element={<Update/>} path="/product/edit/:id"/>
          </Routes>
        </div>
      </BrowserRouter>
    </div>
  )
}

export default App
