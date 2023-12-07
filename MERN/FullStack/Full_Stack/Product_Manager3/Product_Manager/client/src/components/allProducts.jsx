import React,{useEffect}   from 'react'
import axios from 'axios';
import {Link} from 'react-router-dom';
import '../App.css';
const AllProducts = (props)=>{

    const { removeFromDom, products, setProducts} = props;
    useEffect(()=>{
        axios.get("http://localhost:8000/api/products")
        .then((res)=>{
            console.log(res.data);
            setProducts(res.data);
        })
        .catch((err)=>
        console.log(err))
    },[])
    const deleteProduct = (prductId)=>{
        axios.delete(`http://localhost:8000/api/products/${prductId}`)
        .then(res=>{
            removeFromDom(prductId);
        })
        .catch(err=>console.log(err))
    }
    return(
        <div>
            <h1>All Products</h1>
            <table>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        products.map(eachProduct => (
                            <tr key={eachProduct._id}>
                                <td>{eachProduct.title}</td>
                                <td>
                                    <Link to={`/products/${eachProduct._id}`}>View</Link>
                                    {' | '}
                                    <Link to={`/product/edit/${eachProduct._id}`}>Edit</Link>
                                    {' | '}
                                    <button onClick={(e)=>{deleteProduct(eachProduct._id)}}>Delete</button>
                                </td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
    
    

                }
export default AllProducts;










