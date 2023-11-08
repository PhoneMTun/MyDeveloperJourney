import React , { useState } from 'react'
import DisplayBox from './components/Display'
import ColorForm from './components/Form'

function App() {
  const [boxColorArray, setBoxColorArray] = useState([]);

  return (
      <div>
        <ColorForm setBoxColorArray={setBoxColorArray}/>
        <DisplayBox boxColorArray={boxColorArray}/>
      </div>
  )
}

export default App
