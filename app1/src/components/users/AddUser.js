import React, {useState} from 'react'
import axios from 'axios'
import {useHistory} from 'react-router-dom'

const initialState = {
    id:0,
    name:"",
    mobNumber:"",
    emailId:""
}



function AddUser() {

    let history = useHistory()

    const [user,setUser] = useState(initialState)

    const onChange = e =>{
        setUser({
            ...user,
            [e.target.name]:e.target.value
        })
    }

    const onSubmit = e =>{
        e.preventDefault()
        axios.post("/users",user) //http://localhost:3005/users
        .then(res =>{
            console.log(res)
            history.push("/viewusers")
        })
    }

    return (
        <div className="container">
            <div className="w-75 mx-auto shadow p-5">
                <h2 className="text-center mb-4">Add A User</h2>
            <form onSubmit={onSubmit}>
                <div className="form-group">
                    <input type="text" className="form-control form-control-lg"  placeholder="Enter your Name" name="name" value={user.name} onChange={onChange}/>
                </div>
                <div className="form-group">
                    <input type="text" className="form-control form-control-lg"  placeholder="Enter your Mobile Number" name="mobNumber" value={user.mobNumber} onChange={onChange}/>
                </div>
                <div className="form-group">
                    <input type="text" className="form-control form-control-lg"  placeholder="Enter your Email-Id" name="emailId" value={user.emailId} onChange={onChange}/>
                </div>
                <button className="btn btn-primary btn-block">Add User</button>
            </form>
            </div>
        </div>
    )
}

export default AddUser
