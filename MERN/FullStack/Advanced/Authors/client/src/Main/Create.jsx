import React, { useState} from 'react'
import {Link} from 'react-router-dom'
import Form from '../componenets/Create/Form'
import { useNavigate } from 'react-router-dom';
import axios from 'axios';


export default function Create() {
    const [errors, setErrors] = useState({});
    const [name, setName] = useState(""); 
    const navigate = useNavigate();
    const submithandler = e => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/authors/new', { name })
            .then((res) => {
                console.log(res);
                navigate("/");
            })
            .catch(err => {
                console.error(err);
                setErrors(err.response.data.err.errors);
                setName("");
            });
    }
return (
    <>
        <h1>Favourite authors</h1>
        <Link to = {"/"}>Home</Link>
        <h3>Add a new authors:</h3>
        <Form submithandler={submithandler} errors={errors} initialname={name} setName={setName} />
    </>
  )
}
