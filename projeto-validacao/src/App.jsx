import { Routes } from 'react-router-dom'
import './App.css'
import footer from './components/Footer'
import Header from './components/Header'
import { ToastContainer } from 'react-toastify'

function App() {


  return (
    <>
    <Header />
    <main>
      <Routes path='/' element={<h1>Home</h1>} />
      <Routes path='/cadastro' element={<h1>CadastroPage</h1>} />
      <Routes path='/lista' element={<h1>ListaPage</h1>} />
    </main>
    <ToastContainer position='bottom-right' autoClose={3000} />
    <Footer />
    </>
  )
}

export default App
