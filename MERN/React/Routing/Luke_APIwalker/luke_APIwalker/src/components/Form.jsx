import { useParams, useNavigate } from 'react-router-dom';
import React, {useState} from 'react';
import axios from 'axios'


const Form = (props) => {
    const [id, setId] = useState("");
    const [input, setInput] = useState("");
    const navigate = useNavigate();
    
    const handletosubmit = (e) => {
        e.preventDefault();
        const data = {
            id: Number(id),
            something: input
        };
        props.datalist(data);
        navigate(`/${data.something}/${data.id}`);
    };


    return (
        <div>
            <form onSubmit={handletosubmit}>
                <label>Search For:</label>
                <select id="category-select" onChange={(e)=>{setInput(e.target.value)}}>
                    <option></option>
                    <option value="people">People</option>
                    <option value="planets">Planet</option>
                    <option value="starships">Starships</option>
                </select>
                <label>ID:</label>
                <input type='number' value={id} onChange={(e)=>{setId(e.target.value)}}/><br/>
                <button type='submit'>Search</button>
            </form>
        </div>
    )
}

export default Form;