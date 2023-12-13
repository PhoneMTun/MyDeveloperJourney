import React, { useState } from 'react';
import axios from 'axios';
import { Button } from '@mui/material';
import Popup from './Popup'; // Import Popup component

export default function DeleteButton({ selectedPlayer, players, setPlayers }) {
    // console.log(selectedPlayer);
    const [popupDelete, setPopupDelete] = useState(false);

    const handleDelete = () => {
        setPopupDelete(true);
    };

    const confirmDelete = () => {
        axios.delete(`http://localhost:8000/api/teammanager/${selectedPlayer.id}`)
            .then(() => {
                setPlayers(players.filter(player => player._id !== selectedPlayer.id));
                setPopupDelete(false);
            })
            .catch((err) => console.log(err));
    };

    return (
        <div>
            {popupDelete && 
                <Popup selectedPlayerName={selectedPlayer.name} onConfirm={confirmDelete} onClose={() => setPopupDelete(false)} />}
            <Button variant="contained" color="secondary" onClick={handleDelete}>
                Delete
            </Button>
        </div>
    );
}
