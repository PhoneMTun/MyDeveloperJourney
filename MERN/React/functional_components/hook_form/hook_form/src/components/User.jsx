import React, { useState } from 'react';

const UserForm = (props) => {
    const[fname, setFname] = useState("");
    const[lname, setLname] = useState("");
    const[email, setEmail] = useState("");
    const[password, setPassword] = useState("");
    const[cpassword, setCpassword] = useState("");

    const createUser =(e) => {

        e.preventDefault();

        const newUser={fname, lname, email,password , cpassword };
        console.log("Hello" +newUser);
        setFname("");
        setLname("");
        setEmail("");
        setPassword("");
        setCpassword("");

};
    return(
        <div>
            <form onSubmit={createUser}>
                <div>
                    <label>First Name:</label>
                    <input type="text" name="fname" onChange={(e) => setFname(e.target.value)}/>
                </div>
                <div>
                    <label>Last Name:</label>
                    <input type="text" name="lname" onChange={(e) => setLname(e.target.value)}/>
                </div>
                <div>
                    <label>Email:</label>
                    <input type="text" name="email" onChange={(e) => setEmail(e.target.value)}/>
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" name="password" onChange={(e) => setPassword(e.target.value)}/>
                </div>
                <div>
                    <label>Confim Password:</label>
                    <input type="password" name="cpassword" onChange={(e) => setCpassword(e.target.value)}/>
                </div>
            </form>

            <div className="show">
                <h1> Your Form Data </h1>
                <h4>First Name: {fname}</h4>
                <h4>Last Name: {lname}</h4>
                <h4>Email: {email}</h4>
                <h4>Password: {password}</h4>
                <h4>Confim Password: {cpassword}</h4>

            </div>
        </div>
    )
}

export default UserForm;