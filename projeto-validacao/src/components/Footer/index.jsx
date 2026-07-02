import './styles.css'

export default function footer(){
    return (
        <footer>
            <div className='footer'>
            <p>
                &copy; {new Date().getFullYear()} My App. Todos os direitos reservados.
                <br />
                Senai Bahia
            </p>
            </div>
        </footer>
    )
}