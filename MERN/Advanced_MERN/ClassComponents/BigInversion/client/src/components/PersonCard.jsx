import React, { Component } from 'react';

class PersonCard extends Component {
    render() {
        const { firstName, lastName, age, hairColor } = this.props;

        return (
            <>
                <h1>{`${lastName} , ${firstName}`}</h1>
                <h2>Age: {age}</h2>
                <h2>Hair Color: {hairColor}</h2>
            </>
        );
    }
}

export default PersonCard;