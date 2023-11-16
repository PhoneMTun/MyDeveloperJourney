import React, {useEffect, useState } from 'react'
import {BrowserRouter, Routes, Route} from "react-router-dom"
import axios from 'axios'
import Display from './components/Display'
import Form from './components/Form'
import './App.css'


function App() {
  const [responseData, setResponseData] = useState([]);
  const [haserror, setHasError]=useState(false);

  const handleFormSubmit = (data) => {
    axios.get(`https://swapi.dev/api/${data.something}/${data.id}`)
      .then(response => {
        setResponseData(response.data);
        setHasError(false);
      })
      .catch(error => {console.error('These arent the droids you are looking for', error);
      setHasError(true);
    })
      
  };
console.log(haserror)
  useEffect(() => {
    console.log('Response Data:', responseData);
  }, [responseData]);

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Form datalist={handleFormSubmit}/>}/>
        <Route path="/:something/:dataid" element={<Display responseData={responseData} datalist={handleFormSubmit} haserror={haserror}/> }/>
      </Routes>
    </BrowserRouter>
  );
}


export default App
