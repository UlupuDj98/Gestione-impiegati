import React, { useEffect, useState } from 'react'
import '../App.css'
import { addEmployee, getEmployee, updateEmployee } from '../Services/Services'
import { useNavigate, useParams } from 'react-router-dom'

const EmployeeComponent = () => {

    const [fullName , setFullName] = useState('')
    const [phone , setPhone] = useState('')
    const [email , setEmail] = useState('')

    const handleFullName = (e) => setFullName(e.target.value)
    const handlePhone = (e) => setPhone(e.target.value)
    const handleEmail = (e) => setEmail(e.target.value)

    const {id} = useParams()

    const [errors,setErrors] = useState({
        fullName : '',
        phone : '',
        email : ''
} )


    useEffect(()=>{
        if(id){

            getEmployee(id).then((response)=>{
                setFullName(response.data.fullName)
                setPhone(response.data.phone)
                setEmail(response.data.email)
            }).catch(error => {
                console.error(error)
            })

        }
        
      
    },[id])

    function validateForm(){
        let valid = true

        const errorsCopy = {... errors}

        if(fullName.trim())
        {
            errorsCopy.fullName=''

        }else{
            errorsCopy.fullName = 'Full name required'
            valid= false
        }

        if(phone.trim())
        {
                errorsCopy.phone=''
    
        }else{
                errorsCopy.phone = 'Phone number required'
                valid= false
            }
         if(email.trim())
        {
            errorsCopy.email=''
        
        }else{
                errorsCopy.email = 'E-mail required'
                valid= false
        }


        setErrors(errorsCopy)
        return valid

    }


    const navigator = useNavigate()
    function saveorUpdateEmployee(e)
    {
        e.preventDefault()
        

        if(validateForm())
        {

            const employee = {fullName , phone , email}
            console.log(employee)

            if(id)
            {
                updateEmployee(id,employee).then((response) => {
                    console.log(response.data)
                    navigator('/employees')

                }).catch(error => {
                    console.error(error)
                })
            }
            else {
                addEmployee(employee).then((response) => {
                    console.log(response.data)
                    navigator('/employees')
        
                }).catch(error => {
                    console.error(error)
                })
            }
          
        }

        
    }

    function formTItle()
    {
        if(id)
            return <h2 className='text-center'>Update employee</h2>
        else
            return <h2 className='text-center'>Add Employee</h2>
    }


  return (
    <div className='container form-container'>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 '>
                {formTItle()}
                <div className='card-body'>
                <form>
    <div className='form-group mb-2'>
        <label className='form-label'>Full name</label>
        <input  
            type='text'
            placeholder='Enter full name'
            value={fullName}
            className={`form-control ${errors.fullName ? 'is-invalid' : ''}`}
            onChange={handleFullName}
        />
        {errors.fullName && <div className='invalid-feedback'>{errors.fullName}</div>}
    </div>

    <div className='form-group mb-2'>
        <label className='form-label'>Phone number</label>
        <input  
            type='text'
            placeholder='Enter phone number'
            value={phone}
            className={`form-control ${errors.phone ? 'is-invalid' : ''}`}
            onChange={handlePhone}
        />
        {errors.phone && <div className='invalid-feedback'>{errors.phone}</div>}
    </div>

    <div className='form-group mb-2'>
        <label className='form-label'>Email</label>
        <input  
            type='text'
            placeholder='Enter e-mail'
            value={email}
            className={`form-control ${errors.email ? 'is-invalid' : ''}`}
            onChange={handleEmail}
        />
        {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
    </div>
</form>

                    <button className='add-button' onClick={saveorUpdateEmployee}>Submit</button>
                </div>
            </div>
        </div>
        
        
    </div>
  )
}

export default EmployeeComponent