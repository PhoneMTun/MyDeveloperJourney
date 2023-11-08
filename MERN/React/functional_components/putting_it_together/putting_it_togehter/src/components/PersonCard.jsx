import React, { useState } from 'react'


const PersonCard=(props) => {
    const{ fName, lName, age, hColor}= props;
    const[stateAge, setStateAge] = useState(age);
    return(
        <div>
            <h1>{fName}, {lName}</h1>
            <h4>Age: {stateAge}</h4>
            <h4>hair Color: {hColor}</h4>
            <button onClick={() =>setStateAge(stateAge+1)}>Birthday Button for {fName} {lName}</button>
        </div>
    )
}

export default PersonCard;