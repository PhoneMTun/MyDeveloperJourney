import Create from '../components/create.jsx'
import AllProducts from '../components/allProducts.jsx'
import React, {useState} from 'react'

function App() {
    const [products, setProducts] = useState([])
    const removeFromDom = personId=>{
        setProducts(product.filter(product => product.id != personId))
    }
return (
    <>
        <div>
            <Create products={products} setProducts={setProducts}/>
            <AllProducts products={products} setProducts={setProducts} removeFromDom={removeFromDom}/>
        </div>
    </>
  )
}

export default App
