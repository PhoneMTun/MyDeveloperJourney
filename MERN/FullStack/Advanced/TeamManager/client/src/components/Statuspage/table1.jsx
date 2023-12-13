import React from 'react';
import axios from 'axios'; // Import axios
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, Button } from '@mui/material';
import { Link } from 'react-router-dom';
import "../../App.css";

export default function StatusTable({ players, setPlayers }) {

    const updateStatus = (playerId, newStatus) => {
        const updatedPlayer = players.map(player => 
            player._id === playerId ? { ...player, gameOneStatus: newStatus } : player
        );
        
        setPlayers(updatedPlayer);

        axios.patch(`http://localhost:8000/api/teammanager/${playerId}`, { gameOneStatus: newStatus })
          .then((res) => {
              console.log(res);
          })
          .catch(err => {
              console.error(err); // Update error handling as needed
          });
    };

    const getButtonStyle = (playerStatus, buttonStatus) => {
        if (playerStatus === buttonStatus) {
            return buttonStatus === 'Playing' ? { backgroundColor: 'green', color: 'white' } 
: buttonStatus === 'Not Playing' ? { backgroundColor: 'red', color: 'white' }: { backgroundColor: 'gold', color: 'white' };
        }
        return {};
    };

    return (
        <div className='border-table'>
            <h2><Link to={"/status/game/1"} className='underline-link'>Game 1</Link> | <Link to={"/status/game/2"}>Game 2</Link> | <Link to={"/status/game/3"}>Game 3</Link></h2>
            <TableContainer component={Paper} sx={{ backgroundColor: 'grey' }}>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>Player Name</TableCell>
                            <TableCell>Status</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {players.map((eachPlayer) => (
                            <TableRow key={eachPlayer._id}>
                                <TableCell>{eachPlayer.name}</TableCell>
                                <TableCell>
                                    <Button style={getButtonStyle(eachPlayer.gameOneStatus, 'Playing')}
                                            onClick={() => updateStatus(eachPlayer._id, 'Playing')}>
                                        Playing
                                    </Button>
                                    <Button style={getButtonStyle(eachPlayer.gameOneStatus, 'Not Playing')}
                                            onClick={() => updateStatus(eachPlayer._id, 'Not Playing')}>
                                        Not Playing
                                    </Button>
                                    <Button style={getButtonStyle(eachPlayer.gameOneStatus, 'Undecided')}
                                            onClick={() => updateStatus(eachPlayer._id, 'Undecided')}>
                                        Undecided
                                    </Button>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </div>
    );
}
