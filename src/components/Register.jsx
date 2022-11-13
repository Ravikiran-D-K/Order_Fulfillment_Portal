import React, { useState } from "react";
import EmployeeService from '../services/EmployeeService';

export const Register = (props) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [name, setName] = useState('');
    const [Message, setMessage] = React.useState()
    const mystyle = {
        color: "black",
        backgroundColor: "lightgrey",
        padding: "5px",
        fontFamily: "Arial"
      };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
       let x={name:name,password:password,email:email}
       console.log(x);
        EmployeeService.insert(x).then(res =>{
            setMessage(res.data);
        });
    }

    return (
        <div className="auth-form-container"  onClick={e=>setMessage(null)}>
            <h2>Register</h2>
        <form className="register-form" onSubmit={handleSubmit}>
            <label htmlFor="name">Full name</label>
            <input className="xyz" value={name} onChange={(e) => setName(e.target.value)} type="name"  name="name" id="name" placeholder="full Name" />
            <label htmlFor="email">email</label>
            <input className="xyz" value={email} onChange={(e) => setEmail(e.target.value)}type="email" placeholder="youremail@gmail.com" id="email" name="email" />
            <label htmlFor="password">password</label>
            <input className="xyz" value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="********" id="password" name="password" />
            <br></br><button type="submit">Submit</button>
            {Message && <div className="error" style={mystyle}> {Message} </div>}
        </form>
        <button className="link-btn" onClick={() => props.onFormSwitch('login')}>Already have an account? Login here.</button>
    </div>
    )
}
export default Register;