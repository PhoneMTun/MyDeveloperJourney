import { useState , useEffect} from 'react'
import axios from 'axios'
import './App.css'

function App() {
  const [pokemon, setPokemon] = useState([]);

  useEffect(() =>{
    axios.get('https://pokeapi.co/api/v2/pokemon?limit=15&offset=0')
    .then(response=>{setPokemon(response.data.results)})
  },[]);

  return (
    <>
      <button>Fetch Pokemon</button>
      <ul>
        {
        pokemon.map((poke, index)=>{
          return(<li key={index}>{poke.name}</li>)
        })
          
        }
          </ul>
    </>
    
  )
}

export default App
