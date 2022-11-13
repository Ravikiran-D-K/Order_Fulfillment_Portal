
import React, { useState } from "react";
// import logo from './logo.svg';
import './App1.css';
import { Login } from "./components/Login";
import { Register } from "./components/Register";

function App1() {
  const [currentForm, setCurrentForm] = useState('login');

  const toggleForm = (formName) => {
    setCurrentForm(formName);
  }

  return (
    <div className="App1">
      {
        currentForm === "login" ? <Login onFormSwitch={toggleForm} /> : <Register onFormSwitch={toggleForm} />
      }
    </div>
  );
}

export default App1;