import React, {useState, useEffect} from 'react'
import axios from 'axios'
import { HashLoader } from 'react-spinners';



const Create = (props)=>{
    const [loading, setLoading] = useState(false)
    const {products ,setProducts}=props;
    const [title, setTitle] = useState("")
    const [price, setPrice] = useState("")
    const [description, setDescription] = useState("")


const handleSubmit = (e)=>{
    e.preventDefault()
    setLoading(true);
    axios.post('http://localhost:8000/api/products',{
        title,
        price, 
        description,
    })
    .then((res)=>{
        console.log(res);
        console.log(res.data);
        setTitle("")
        setPrice("")
        setDescription("")
        setProducts([...products, res.data]);
    })
    .catch((err)=>{
    console.error(err)
    })
    .finally(() => {
        setTimeout(()=>{
        setLoading(false)
    },2000)
})
}



return(
    <div >
        {
            loading?(
                <HashLoader color="#36d7b7" size={50}/>
            ) :
        <form onSubmit={handleSubmit}>
            <div className='form'>
                <h4>
                    <label>Title:</label>
                    <input type='text' onChange={(e)=>setTitle(e.target.value)} name='title' value={title}></input>
                </h4>
                <h4>
                    <label>Price:</label>
                    <input type='number' onChange={(e)=>setPrice(e.target.value)}name='price' value={price}></input>
                </h4>
                <h4>
                    <label>Description:</label>
                    <input type='text' onChange={(e)=>setDescription(e.target.value)} name='description' value={description}></input>
                </h4>
                <input type='submit'  className='submit'/>
            </div>
        </form>
        }
    </div>
    )
}
export default Create;