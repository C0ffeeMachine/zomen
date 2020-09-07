import React, {useState,useEffect} from 'react'
import axios from 'axios'
import {useHistory,useParams} from 'react-router-dom'

const initialState = {
    id:0,
    name:"",
    mobNumber:"",
    emailId:""
}



function EditUser() {

    let history = useHistory()

    const {id} = useParams()
    const [user,setUser] = useState(initialState)

    useEffect(()=>{
        loadUser()
    },[])

    const onChange = e =>{
        setUser({
            ...user,
            [e.target.name]:e.target.value
        })
    }

    const onSubmit = e =>{
        e.preventDefault()
        axios.put("/users/"+id,user) //http://localhost:3005/users
        .then(res =>{
            console.log(res)
            history.push("/viewusers")
        })
    }

    const loadUser = () =>{
        axios.get("/users/"+id) //http://localhost:3005/users
        .then(res =>{
            setUser(res.data)
        })
    }

    return (
        <div className="container">
            <div className="w-75 mx-auto shadow p-5">
                <h2 className="text-center mb-4">Edit A User</h2>
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
                <button className="btn btn-warning btn-block">Update User</button>
            </form>
            </div>
        </div>
    )
}

export default EditUser
