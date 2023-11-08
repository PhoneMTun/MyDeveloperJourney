import React, { useState } from 'react';

const UserForm = (props) => {
    const[fname, setFname] = useState("");
    const[fnameerror, setFnameerror] = useState("");
    const[lname, setLname] = useState("");
    const[lnameerror, setLnameerror] = useState("");
    const[email, setEmail] = useState("");
    const[emailerror, setEmailerror] = useState("");
    const[password, setPassword] = useState("");
    const[passworderror, setPassworderror] = useState("");
    const[cpassword, setCpassword] = useState("");

    const checkfname =(e) => {
        setFname(e.target.value);
        if  (e.target.value.length === 0) {
            setFnameerror("")
        }
        else if  (e.target.value.length<2){
            setFnameerror("First Name must be at least 2 characters")
        }else{
            setFnameerror("")
        }
    }

    const checklname =(e) => {
        setLname(e.target.value);
        if  (e.target.value.length === 0) {
            setLnameerror("")
        }
        else if  (e.target.value.length<2){
            setLnameerror("Last Name must be at least 2 characters")
        }else {
            setLnameerror("");
    }
}

    const checkemail =(e) => {
        setEmail(e.target.value);
        if  (e.target.value.length === 0) {
            setEmailerror("")
        }
        else if  (e.target.value.length<5){
            setEmailerror("Email must be at least 5 characters")
        }
        else {
            setEmailerror("");
    }
}

    const checkpassword =(e) => {
        setPassword(e.target.value);
        if  (e.target.value.length === 0) {
            setPassworderror("")
        }
        else if  (e.target.value.length<8){
            setPassworderror("Password must be at least 8 characters")
        } else if(e.target.value!==cpassword){
            setPassworderror("Passwords must match")
        }else {
            setPassworderror("");
    }
}


    return(
        <div>
            <form onSubmit={(e)=>e.preventDefault()}>
                <div>
                    <label>First Name:</label>
                    <input type="text" name="fname" onChange={checkfname}/>
                    {
                        fnameerror ?
                        <p>{fnameerror}</p>:
                        ''
                    }

                </div>
                <div>
                    <label>Last Name:</label>
                    <input type="text" name="lname" onChange={checklname}/>
                    {
                        lnameerror ?
                        <p>{lnameerror}</p>:
                        ''
                    }
                </div>
                <div>
                    <label>Email:</label>
                    <input type="text" name="email" onChange={checkemail}/>
                    {
                        emailerror ?
                        <p>{emailerror}</p>:
                        ''
                    }
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" name="password" onChange={checkpassword}/>
                    {
                        passworderror ?
                        <p>{passworderror}</p>:
                        ''
                    }
                </div>
                <div>
                    <label>Confim Password:</label>
                    <input type="password" name="cpassword" onChange={(e)=>setCpassword(e.target.value)}/>
                    
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