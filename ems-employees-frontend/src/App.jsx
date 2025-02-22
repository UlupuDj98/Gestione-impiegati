import { useState } from 'react'
import './App.css'
import ListEmployeesComponent from './Components/ListEmployeesComponent'
import Header from './Components/Header'
import Footer from './Components/Footer'
import { BrowserRouter , Route , Routes} from 'react-router-dom'
import EmployeeComponent from './Components/EmployeeComponent'


function App() {
 

  return (
    <>
    <BrowserRouter>
          <Header />
              <Routes>
                  <Route path='/' element = {<ListEmployeesComponent />}></Route>
                  <Route path='/employees' element = {<ListEmployeesComponent />}></Route>
                  <Route path='/edit-employee' element={<EmployeeComponent />} ></Route>
                  <Route path='/edit-employee/:id' element={<EmployeeComponent />}></Route>
              </Routes>

          <Footer />
    </BrowserRouter>
     
    
      
    </>
  )
}

export default App
