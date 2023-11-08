import React, {useState} from "react"

const DisplayBox=(props)=>{
    const{boxColorArray}=props;
    return(
        <div>
            {boxColorArray.map((box, index)=>(
                <div 
                    key={index}
                    style={{
                        
                            backgroundColor: `${box.color}`,
                            width: `${box.size}px`,
                            height: `${box.size}px`,
                            display: 'inline-block',
                            margin: '10px'               
                    }}>
                </div>
            )
            )}
        </div>
    );
}

export default DisplayBox;
        