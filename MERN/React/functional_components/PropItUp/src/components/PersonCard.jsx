import React from 'react';

const PersonCard= (props) => {
    return(
        <div>
            <h1>{props.lname}, {props.fname}</h1>
            <h3>Age: {props.age}</h3>
            <h3>Hair Color: {props.hcolor}</h3>
        </div>
    )
}

export default PersonCard;