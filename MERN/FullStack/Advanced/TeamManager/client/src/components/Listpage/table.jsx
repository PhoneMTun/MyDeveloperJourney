import React from 'react'
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, Button } from '@mui/material';
import {Link} from 'react-router-dom'
import DeleteButton from './Deletebutton';
import "../../App.css"

export default function PlayerTable({players, setPlayers }) {


    return (
    <div className='border-table'>
        <h2><Link to = {"/"} className='underline-link '>List</Link> | <Link to = {"/players/addplayer"}>Add Player</Link></h2>
        <TableContainer component={Paper} sx={{ backgroundColor: 'grey' }}>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell>Player Name</TableCell>
                        <TableCell>Preferred Position</TableCell>
                        <TableCell>Actions</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {players.map((eachPlayer) => (
                        <TableRow key={eachPlayer._id}>
                            <TableCell>{eachPlayer.name}</TableCell>
                            <TableCell>{eachPlayer.position}</TableCell>
                            <TableCell>
                                {/* {
                                    popup ==true?
                                    <Popup setSelectedPlayer= {eachPlayer.name}/>: null
                                } */}
                                    <DeleteButton selectedPlayer={{ id: eachPlayer._id, name: eachPlayer.name }} players={players} setPlayers={setPlayers} />

                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    </div>
  )
}
