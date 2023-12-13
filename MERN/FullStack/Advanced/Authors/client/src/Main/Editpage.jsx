import React, {useState, useEffect} from 'react'
import {Link, useNavigate, useParams} from 'react-router-dom'
import Form from '../componenets/Create/Form'
import axios from 'axios';

export default function Editpage() {
  const [errors, setErrors] = useState({});
  const [name, setName] = useState(""); 
  const navigate = useNavigate();
  const {id} = useParams();
  const submithandler = e => {
      e.preventDefault();
      axios.patch(`http://localhost:8000/api/authors/${id}`, { name })
          .then((res) => {
              console.log(res);
              navigate("/");
          })
          .catch(err => {
              setErrors(err.response.data.err.errors);
              setName("");
          });
  }
  useEffect(() => {
    axios.get(`http://localhost:8000/api/authors/${id}`)
      .then(res=>{
        console.log(res.data);
        setName(res.data.name);
      })
      .catch(err=>console.log(err))
  },[])
    return (
    <div>
      <h1>Favourite authors</h1>
      <Link to = {"/"}>Home</Link>
      <h4>Edit this author</h4>
      <Form submithandler={submithandler} errors={errors} initialname={name} setName={setName} />
    </div>
  )
}
