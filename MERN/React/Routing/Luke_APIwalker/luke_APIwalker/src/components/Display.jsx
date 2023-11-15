import {  useParams } from 'react-router-dom';
import React, {useState, useEffect} from 'react';
import Form from './Form';
import axios from 'axios'

const getHomeWorld=(url) =>{
    const parts = url.split('/');
    const id = parts[parts.length - 2];
    console.log(id)
    return id;
}
const Display=({responseData, datalist, haserror }) =>{
    const{something, dataid}=useParams();
    const [homeworld, setHomeWorld]= useState(null);
    
    useEffect(() => {
        if (something === "people" && responseData?.homeworld) {
            let hwid=getHomeWorld(responseData.homeworld);
            axios.get(`https://swapi.dev/api/planets/${hwid}`)
                .then(response => {
                    setHomeWorld(response.data);
                })
                .catch(error => console.error('Error fetching homeworld:', error));
        }
    }, [responseData, something]);

    const checkingSomething = () => {
        switch(something){
            case 'people':
                return (
                    <div>
                        <h2>{responseData.name}</h2>
                        <h4>Height: {responseData.height} cm</h4>
                        <h4>Hair Color: {responseData.hair_color}</h4>
                        <h4>Eye Color: {responseData.eye_color}</h4>
                        <h4>Skin Color: {responseData.skin_color}</h4>
                        {homeworld?
                            <p>Homeworld: {homeworld.name}</p>
                        :
                        ""}
                    </div>
            )
            case 'planets':
                return (
                    <div>
                        <h2>{responseData.name}</h2>
                        <h2>Climate: {responseData.climate}</h2>
                        <h4>Terrain: {responseData.terrain}</h4>
                        <h4>Surface Water: {responseData.surface_water}</h4>
                        <h4>Population: {responseData.population}</h4>
                    </div>
                );
            case 'starships':
                return (
                    <div>
                        <h2>{responseData.name}</h2>
                        <h2>Model: {responseData.model} cm</h2>
                        <h4>Passengers: {responseData.passengers}</h4>
                        <h4>Starship class: {responseData.starship_class}</h4>
                        <h4>Crew: {responseData.crew}</h4>
                    </div>
                )
            default:
                return <p>No data available</p>
                
            };
        };
    return (
        <div>
            <Form datalist={datalist} />
            {haserror?(
                <div>
                    <p>These aren't the droids you're looking for</p>
                    <img src='https://media.giphy.com/media/i7jofPIasaebfTlQ6b/giphy.gif' alt="Obi-Wan Kenobi"/>
                </div>
            ): 
            <div>
                {checkingSomething()}
            </div>
            }


        </div>
    )





}
export default Display;