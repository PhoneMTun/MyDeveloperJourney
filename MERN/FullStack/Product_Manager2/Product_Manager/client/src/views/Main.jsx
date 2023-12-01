import Create from '../components/create.jsx'
import AllProducts from '../components/allProducts.jsx'
import React, {useState} from 'react'

function App() {
    const [products, setProducts] = useState([])

return (
    <>
        <div>
            <Create products={products} setProducts={setProducts}/>
            <hr/>
            <AllProducts products={products} setProducts={setProducts}/>
        </div>
    </>
  )
}

export default App
