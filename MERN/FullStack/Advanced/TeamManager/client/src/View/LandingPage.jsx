import React, {useState, useEffect} from 'react'
import {Link} from 'react-router-dom';
import PlayerTable from '../components/Listpage/table';
import axios from 'axios';

export default function LandingPage() {
  const [players, setPlayers] = useState([]);

  
 
  useEffect(() => {
    axios.get("http://localhost:8000/api/teammanager")
        .then((res) => {
          setPlayers(res.data);
        })
        .catch((err) => console.log(err));
}, []);



  
  return (
    <div>
      <h1><Link to = {"/"} className='underline-link '>Manage Players</Link> | <Link to = {"/status/game/1"}>Manage Player Status</Link></h1>
      {/* {
        popup ==true?
        <Popup />: null
      } */}
      <PlayerTable players={players} setPlayers= {setPlayers}/>
    </div>
    )
}
