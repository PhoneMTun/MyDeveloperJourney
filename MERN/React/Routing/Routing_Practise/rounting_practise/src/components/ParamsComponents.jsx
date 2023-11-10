import React from 'react';
import { useParams } from 'react-router-dom';



const Word =(props)=> {
    const{word, color , bgcolor}= useParams();
    return(
        isNaN(word)?
            <h1 style={{color: color, backgroundColor: bgcolor}}>The word is: {word}</h1> 
            :
            <h1>The number is: {word}</h1> 
    )
  }

  export default Word