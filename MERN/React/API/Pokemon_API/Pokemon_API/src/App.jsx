import React, {useState, useEffect} from 'react'
import './App.css'

function App() {
  const [pokemon, setPokemon] = useState([])

  const showPokemons=()=>{

    fetch("https://pokeapi.co/api/v2/pokemon?limit=10&offset=0")
    .then(response => {
      return response.json()
    }).then(response => {
      setPokemon(response.results)
    }).catch(err => {
      console.log(err);
    });
  }   

  useEffect(()=>{
    showPokemons();},[]);
  

  return (
    <div className='App'>
        <button>Fetch Pokemon</button>
        <ul>
          {
          pokemon.map((poke, i) =>{
            return (<li key={i}>{poke.name}</li>)
          }
          )
          }
        </ul>
    </div>

      

  )
        }

export default App
