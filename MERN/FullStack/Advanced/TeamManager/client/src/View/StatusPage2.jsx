import React, {useState, useEffect} from 'react'
import axios from 'axios';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, Button } from '@mui/material';
import {Link} from 'react-router-dom'
import StatusTable from '../components/Statuspage/table2';

export default function StatusPage2() {
    const [players, setPlayers] = useState([]);
    

    useEffect(() => {
      axios.get("http://localhost:8000/api/teammanager")
          .then((res) => {
            setPlayers(res.data);
            console.log(res.data);
          })
          .catch((err) => console.log(err));
  }, []);

  return (
    <div>
        <h1><Link to = {"/"} >Manage Players</Link> | <Link to = {"/status/game/1"} className='underline-link '>Manage Player Status</Link></h1>
        <StatusTable players={players} setPlayers= {setPlayers}/>
    </div>
  )
}
