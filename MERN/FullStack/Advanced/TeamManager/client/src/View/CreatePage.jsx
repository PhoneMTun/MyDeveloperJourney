import React, {useState, useEffect} from 'react'
import {Link} from 'react-router-dom';
import axios from 'axios';
import Form from '../components/Createpage/Form.jsx';
import { useNavigate } from 'react-router-dom';

export default function Createpage() {
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();
  const [formData, setFormData] = useState({ name: '', position: '' });


  const validate = (values) => {
    const errors = {};
  
    if (!values.name) {
      errors.name = 'Name is required';
    } else if (values.name.length <= 2) {
      errors.name = 'Name must be at least 2 characters';
    }
  
    const positionLower = values.position.toLowerCase();
    if (positionLower !== 'striker' && positionLower !== 'midfield' && positionLower !== 'defender') {
      errors.position = 'Pick a position: Striker, Midfield, or Defender';  
    }
  
    return errors;
  }
  
    
//   const submithandler = e => {
//     e.preventDefault();
//     axios.post("http://localhost:8000/api/teammanager/new", formData)
//         .then((res) => {
//           console.log(formData);
//           console.log(res)
//           navigate("/")

//         })
//         .catch(err => {
//           console.error(err.response.data.errors);
//           setErrors(err.response.data.errors);
//       });
// }
const submithandler = e => {
  e.preventDefault();
  const validationErrors = validate(formData);
  setErrors(validationErrors);

  if (Object.keys(validationErrors). length === 0 ){
    axios.post("http://localhost:8000/api/teammanager/new", formData)
        .then((res) => {
          console.log(formData);
          console.log(res)
          navigate("/")

        })
        .catch(err => {
          console.error(err.response.data.errors);
          // setErrors(err.response.data.errors);  >>>>>>>>>>>> For backend validation
      });
  }
}
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
        ...prevState,
        [name]: value
    }));
  };



  return (
    <div>
      <h1><Link to = {"/"} className='underline-link '>Manage Players</Link> | <Link to = {"/"}>Manage Player Status</Link></h1>
      <Form submithandler={submithandler} errors={errors} handleChange={handleChange} formData={formData}/>
    </div>
    )
}
