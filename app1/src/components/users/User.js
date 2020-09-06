import React,{useState,useEffect} from 'react'
import { useParams } from 'react-router-dom'
import axios from 'axios'


function User() {

    const {id} = useParams()
    const [user,setUser] = useState({
        id:0,
        name:"",
        mobNumber:"",
        emailId:""
    })
 
    useEffect(()=>{
        loadUser()
    },[])

    const loadUser = ()=>{
        axios.get("http://localhost:8080/users/"+id) //http://localhost:3005/users
        .then(res=>{
            setUser(res.data)
        })
    }

    return (
        <div className="container py-4">
            <h1 className="display-4">User Id:  {id}</h1>
            <hr />
            <ul className="list-group w-50">
                <li className="list-group-item">name: {user.name}</li>
                <li className="list-group-item">mobile number: {user.mobNumber}</li>
                <li className="list-group-item">email: {user.emailId}</li>
            </ul>
        </div>
    )
}

export default User
