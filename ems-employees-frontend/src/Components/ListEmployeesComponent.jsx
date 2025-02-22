import React, { useEffect, useState } from 'react'
import { deleteEmployee, listEmployees } from '../Services/Services'
import { useNavigate } from 'react-router-dom'
import '../App.css'

const ListEmployeesComponent = () => {

    const [employees,setEmployees] = useState([])

    const navigate = useNavigate ()

    function goToForm()
    {
        navigate('/edit-employee')
    }

    function getAllEmployees(){
        listEmployees().then((response)=>{
            setEmployees(response.data)
        }).catch(error => {
            console.error(error)
        })

    }
    useEffect(() => {
        getAllEmployees()
       
    },[])

    function removeEmployee(id)
    {
        deleteEmployee(id).then((response)=>{
           getAllEmployees()
        }).catch(error => {
            console.error(error)
        })
    }

    function updEmployee(id)
    {
        navigate(`/edit-employee/${id}`)
    }


  return (
    <div className='container'>
            <button className='add-button' onClick={goToForm}>Add Employee </button>
            <h2 className='text-center'> List of employees</h2>
            <table className='table table-striped table-bordered'> 
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Full-name</th>
                        <th>Telefon</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        employees.map(employee => 
                            <tr key={employee.id}>
                                <td>{employee.id}</td>
                                <td>{employee.fullName}</td>
                                <td>{employee.phone}</td>
                                <td>{employee.email}</td>
                                <td>
                                    <button className='btn btn-primary' onClick={()=>updEmployee(employee.id)}>Update</button>
                                    <button className='btn btn-danger' onClick={()=>removeEmployee(employee.id)}>Delete</button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
    </div>
  )
}

export default ListEmployeesComponent