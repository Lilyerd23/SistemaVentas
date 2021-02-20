import axios from "axios";

const TIPO_API_BASE_URL = "http://localhost:8080/cliente"

class ClienteService {

    mostrarCliente() {
        return axios.get( TIPO_API_BASE_URL + "/listar" )
    }

    buscarClienteporID( clienteID ) {
        return axios.get( TIPO_API_BASE_URL + "/listar/id/" + clienteID )
    }

    listarPorTipo( tipoId ) {
        return axios.get( TIPO_API_BASE_URL + "/listar/tipo/" + tipoId )
    }

    crearCliente( cliente ) {
        return axios.post( TIPO_API_BASE_URL + "/registrar", cliente )
    }

    actualizarCliente( cliente ) {
        return axios.put( TIPO_API_BASE_URL + "/actualizar", cliente )
    }

    eliminarCliente( clienteID ) {
        return axios.delete( TIPO_API_BASE_URL + "/eliminar/" + clienteID )
    }
}

export default new ClienteService()