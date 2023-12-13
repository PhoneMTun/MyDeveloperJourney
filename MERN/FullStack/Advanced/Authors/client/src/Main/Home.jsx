import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../App.css';
import AuthorsTable from '../componenets/Home/table.jsx';
import {Link} from 'react-router-dom'

function Home() {
    const [authors, setAuthors] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8000/api/authors")
            .then((res) => {
                setAuthors(res.data);
            })
            .catch((err) => console.log(err));
    }, []);

    return (
        <>
            <h1>Favourite authors</h1>
            <Link to={"/authors/new"}>Add an author</Link>
            <AuthorsTable authors={authors} setAuthors={setAuthors} />
        </>
    )
}

export default Home;
