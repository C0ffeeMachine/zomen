import React,{useState,useEffect} from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'



function ViewUser() {

    const [users,setUser] = useState([])

    useEffect(()=>{
        axios.get("/users") //http://localhost:3005/users
        .then(res =>{
            console.log(res.data)
            setUser(res.data)
            //console.log(users)
        })
    },[])

    const loadUser = () =>{
        axios.get("/users") //http://localhost:3005/users
        .then(res =>{
            setUser(res.data)
        })
    }

    const deleteUser = id =>{
        axios.delete("/users/"+id)
        .then(res=>{
            loadUser();
        })
    }

    return (
        <div className="container">
            <div className="py-4">
                <h1>View Users</h1>
                <table className="table border shadow">
                    <thead className="thead-dark">
                        <tr>
                        <th scope="col">Id</th>
                        <th scope="col">User Name</th>
                        <th scope="col">Mobile Number</th>
                        <th scope="col">Email-Id</th>
                        <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            users.map((user)=>(
                                <tr key={user.id}>
                                    <th scope="row">{user.id}</th>
                                    <td>{user.name}</td>
                                    <td>{user.mobNumber}</td>
                                    <td>{user.emailId}</td>
                                    <td> 
                                        <Link className="btn btn-primary mr-2" to={`/users/${user.id}`}>View</Link>
                                        <Link className="btn btn-outline-primary mr-2" to={`/users/edit/${user.id}`}>Edit</Link>
                                        <Link className="btn btn-danger mr-2" onClick={()=>deleteUser(user.id)}>Delete</Link>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default ViewUser
