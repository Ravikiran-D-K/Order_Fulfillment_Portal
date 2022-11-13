import React, { useState } from "react";
import EmployeeService from '../services/EmployeeService';
import { useNavigate } from "react-router-dom";
import {Navigate,useParams} from 'react-router-dom';
//import { useHistory } from "react-router-dom"; 

export const PrivateRoute = ({ children}) => {
    const isAuthenticated = true;
        
    if (isAuthenticated ) {
      return children
    }
      
    return <Navigate to="/" />
  }

export const Login = (props) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    let navigate = useNavigate();

    const [Message, setMessage] = React.useState();
    const mystyle = {
        color: "black",
        backgroundColor: "lightgrey",
        padding: "5px",
        fontFamily: "Arial"
      };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
        EmployeeService.validate(email,password).then(res =>{
        if(res.data===true){
           navigate('/dashboard',{state: {email:email,password:password }});
        }
        else {
            setMessage(res.data);
        }
    });
    console.log("haii");
}
                                                  

    return (
        <div className="auth-form-container"  onClick={e=>setMessage(null)}>
            <h2>Login</h2>
            <form className="login-form" onSubmit={handleSubmit}>
                <label htmlFor="email">email</label>
                <input className="xyz" value={email} onChange={(e) => setEmail(e.target.value)}type="email" placeholder="youremail@gmail.com" id="email" name="email" />
                <label htmlFor="password">password</label>
                <input className="xyz" value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="********" id="password" name="password" />
                <br></br><button className="btn btn-primary mb-3" type="submit">Log In</button>
                {Message && <div className="error" style={mystyle}> {Message} </div>}
            </form>
            <button className="link-btn" onClick={() => props.onFormSwitch('register')}>Don't have an account? Register here.</button>
        </div>
    )
}
export default Login;