
import React, {useState} from 'react';
import axios from 'axios';
import EmployeeService from '../services/EmployeeService';
import 'bootstrap/dist/css/bootstrap.min.css';
import { render } from '@testing-library/react';
//import { useHistory } from "react-router-dom"; 


function Upload({email,password}) {

  //const history = useHistory();
  const[file,setFile]=React.useState();
  const [errorMessage, setErrorMessage] = React.useState()
  const [col='form-control', setCol] = React.useState()
  const [style,setStyle]=React.useState()
  const mystyle = {
    color: "black",
    backgroundColor: "lightgrey",
    padding: "5px",
    fontFamily: "Arial"
  };
  const mystyle1 = {
    color: "red",
    backgroundColor: "white",
    padding: "5px",
    fontFamily: "Arial"
  };
  const mystyle2 = {
    color: "green",
    backgroundColor: "white",
    padding: "5px",
    fontFamily: "Arial"
  };

  function handleChange(event) {
    event.preventDefault()
    setFile(event.target.files[0])
    if(event.target.files[0].type!=='text/xml'){
        setErrorMessage("Invalid File!")
        setStyle(mystyle1)
        setFile(null)
        console.log(event.target.files[0].type);
        console.log(event.target.files[0].type!=='text/xml');
        event.target.value=null;
        setCol("form-control is-invalid");
    }
    else if(event.target.files[0].type==='text/xml'){
        setErrorMessage(null);
        setCol("form-control is-valid")
    }
    else{
        setCol("form-control")
    }
  }
  
  
  function handleSubmit(event) {
    event.preventDefault()
    const url = 'http://localhost:8080/boomi/project/uploadFile/'+email+"/"+password;
    const formData = new FormData();
    formData.append('Mfile',file);
    axios.post(url,formData,{
        'content-type': 'multipart/form-data',
      } ).then((response) => {
      //history.push("/table");
      console.log(response.data)
      if(response.data===true){
      setErrorMessage("Uploaded and Read")
      setStyle(mystyle2)
      }
      else{
      setErrorMessage("Invalid XML Format")
      setStyle(mystyle1)
      }
      // setFile(null);
    });
  }

  //accept="application/xml"
  return (
    <form onSubmit={handleSubmit} onClick={e=>setErrorMessage(null)}>
    <div  className="row">
    <div  className=" col-md-3 mb-3">
          <h4 style={mystyle}>XML File Upload</h4>
          <input type="file" className={col} onChange={handleChange}/>
          {errorMessage && <div className="error" style={style}> {errorMessage} </div>}
    </div>
    <div className="col-sm-6" ><br></br>
    <br></br><button className="btn btn-primary mb-3" type="submit">Upload</button>
    </div>
    </div>
    </form>
  );
  
}

export default Upload;