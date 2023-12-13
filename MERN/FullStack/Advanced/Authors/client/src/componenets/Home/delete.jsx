import React from 'react';
import axios from 'axios';
import { Button } from '@mui/material';

export default function DeleteButton({ authorId, authors, setAuthors }) {
    const deleteAuthor = () => {
        axios.delete(`http://localhost:8000/api/authors/${authorId}`)
        .then(() => {
            setAuthors(authors.filter(author => author._id !== authorId));
        })
        .catch((err) => console.log(err)); 
    }

    return (
        <Button variant="contained" color="secondary" onClick={deleteAuthor}>
            Delete
        </Button>
    );
}
