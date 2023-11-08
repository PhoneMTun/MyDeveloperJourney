import React, {useState} from "react";

const ColorForm=(props)=>{
    const{setBoxColorArray}=props;
    const[color, setColor] = useState("");
    const[size, setSize] = useState("");

const submitHandler = (e)=>{
    e.preventDefault();
    setBoxColorArray(eachbox=>[...eachbox, {color, size}]);
}


return(
    <div>
        <form onSubmit={submitHandler}>
            <div>
                <label>Color</label>
                <input type="text" name="color" onChange={(e)=> setColor(e.target.value)}></input>
            </div>
            <div>
                <label>Size</label>
                <input type="number" name="size" onChange={(e)=> setSize(e.target.value)}></input>
            </div>
            <button type="submit">Add</button>
        </form>
    </div>

)
}
export default ColorForm;