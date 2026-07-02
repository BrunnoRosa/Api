import './style.css'
import { toast } from 'react-toastify'
import * as yup from 'yup'
import { yupResolver } from '@hookform/resolvers/yup'
import { useForm } from 'react-hook-form'
import api from '../../services/api'

// Validação do formulário
const esquemaDeCadastro = yupResolver.object({
    nome: yup
    .string()
    .required('O nome é obrigatório'),
    email: yup
    .string()
    .email('Digite um e-mail válido').required('O e-mail é obrigatório'),    
    senha: yup
    .string()
    .min(6, 'A senha deve ter no mínimo 6 caracteres')
    .required('A senha é obrigatória'),
    confirmarSenha: yup
    .string()
    .oneOf([yup.ref('senha'), null], 'As senhas devem ser iguais')
    .required('A confirmação de senha é obrigatória'),
})
export default function CadastroPage() {

    // Configuração do formulário com React Hook Form

    const{
        register:registraCampo,
        handleSubmit: lidarComEnvioDeFormulario,
        formState:{errors: errosDeValidacao, isSubmiting:estaEnviandoFormulario},
        setError: definirErroNoCampo,
        reset: reiniciarFormulario,
    } = useForm({
        resolver: yupResolver(esquemaDeCadastro),
        defaultValues: {
            nome: '',
            email: '',
            senha: '',
            confirmarSenha: '',
        },
    })

    async function enviarFormulario(dadosDoFormulario) {
        const dadosParaApi = {
            nome: dadosDoFormulario.nome,
            email: dadosDoFormulario.email,
            senha: dadosDoFormulario.senha,
        }

        try {
            const resposta = await api.post('/usuarios', dadosParaApi)
            toast.sucess('Usuário cadastrado com sucesso:', resposta.data)
            reiniciarFormulario()
        } catch (erro) {
            const codigoDeStatus = erro.response?.status
            const mensagemDoServidor = erro.response?.data?.mensagem || 
            'Ocorreu um erro ao cadastrar o usuário.'
            if (codigoDeStatus === 400) {
                definirErroNoCampo('email', {
                    type: 'server',
                    message: mensagemDoServidor,
                })
            }
                toast.error(mensagemDoServidor)
                console.error('Erro ao cadastrar usuário:', erro)
        }
    }

    return (
        <div className="cadastro-container">
            <h1>Cadastro de Usuário</h1>

            // Formulário de cadastro
            <form noValidate onSubmit={lidarComEnvioDoFormulario(enviarFormulario)}>
                {/* Campo para o nome */}
                <div className="form-group">
                    <label htmlFor="nome">Nome:</label>
                    <input
                        type="text"
                        id="nome"
                        placeholder='ex: José Silva'
                        {...registrarCampo('nome')}
                    />
                    {errosDeValidacao.nome && (<p className='error-message'>{errosDeValidacao.nome.message}</p>)}
                </div>
                {/* Campo para o e-mail */}
                <div className="form-group">
                    <label htmlFor="email">E-mail:</label>
                    <input
                        type="email"
                        id="email"
                        placeholder='ex: jose.silva@email.com'
                        {...registrarCampo('email')}
                    />
                    {errosDeValidacao.email && (<p className='error-message'>{errosDeValidacao.email.message}</p>)}
                </div>
                {/* Campo para a senha */}
                <div className="form-group">
                    <label htmlFor="senha">Senha:</label>
                    <input
                        type="password"
                        id="senha"
                        placeholder='ex: ********'
                        {...registrarCampo('senha')}
                    />
                    {errosDeValidacao.senha && (<p className='error-message'>{errosDeValidacao.senha.message}</p>)}
                </div>
                {/* Campo para confirmar a senha */}
                <div className="form-group">
                    <label htmlFor="confirmarSenha">Confirmar Senha:</label>
                    <input
                        type="password"
                        id="confirmarSenha"
                        placeholder='ex: ********'
                        {...registrarCampo('confirmarSenha')}
                    />
                    {errosDeValidacao.confirmarSenha && (<p className='error-message'>{errosDeValidacao.confirmarSenha.message}</p>)}
                </div>
                <button type="submit" disabled={estaEnviandoFormulario}>
                    {estaEnviandoFormulario ? 'Cadastrando...' : 'Cadastrar'}
                </button>
            </form>
        </div>
    )
}