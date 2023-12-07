import React,{useEffect}   from 'react'
import axios from 'axios';
import {Link} from 'react-router-dom';
const AllProducts = (props)=>{

    const {products, setProducts} = props;
    useEffect(()=>{
        axios.get("http://localhost:8000/api/products")
        .then((res)=>{
            console.log(res.data);
            setProducts(res.data);
        })
        .catch((err)=>
        console.log(err))
    },[])
    return(
        <div>
            <h1>All Products</h1>
            {
                products.map((eachProduct, index)=>{
                    return (
                        <Link to={`/products/${eachProduct._id}`} key={index}>
                            <p>{eachProduct.title}</p>
                        </Link>
                    );
                    
                })
            } 
        </div>
    )
        }

export default AllProducts;










