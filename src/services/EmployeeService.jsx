import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/boomi/project";
class EmployeeService {

    getByName(_email,_password,_name){
        return axios.get(EMPLOYEE_API_BASE_URL+"/byname/"+_email+"/"+_password+"/"+_name);
    }
    getByAccount(_email,_password,_account){
        return axios.get(EMPLOYEE_API_BASE_URL+"/byaccount/"+_email+"/"+_password+"/"+_account);
    }
    getByDate(_email,_password,_due_date){
        return axios.get(EMPLOYEE_API_BASE_URL+"/bydate/"+_email+"/"+_password+"/"+_due_date);
    }
    getByEmp(_email,_password){
        return axios.get(EMPLOYEE_API_BASE_URL+"/byemp/"+_email+"/"+_password);
    }

    validate(_email,_password){
        return axios.get(EMPLOYEE_API_BASE_URL+"/validate/"+_email+"/"+_password)
    }

    insert(_x){
        return axios.post(EMPLOYEE_API_BASE_URL+"/signup/",_x)
    }
    getByEmpS(_email,_password){
        return axios.get(EMPLOYEE_API_BASE_URL+"/byemps/"+_email+"/"+_password);
    }
    getByNameS(_email,_password,_name){
        return axios.get(EMPLOYEE_API_BASE_URL+"/bynames/"+_email+"/"+_password+"/"+_name);
    }
    getByAccountS(_email,_password,_account){
        return axios.get(EMPLOYEE_API_BASE_URL+"/byaccounts/"+_email+"/"+_password+"/"+_account);
    }
    getByDateS(_email,_password,_due_date){
        return axios.get(EMPLOYEE_API_BASE_URL+"/bydates/"+_email+"/"+_password+"/"+_due_date);
    }
}

export default new EmployeeService()