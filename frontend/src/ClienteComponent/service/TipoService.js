import axios from "axios";

const TIPO_API_BASE_URL = "http://localhost:8080/tipo"

class TipoService {

    mostrarTipos() {
        return axios.get( TIPO_API_BASE_URL + "/listar" );
    }

    buscarTipoporID( tipoID ) {
        return axios.get( TIPO_API_BASE_URL + "/listar/" + tipoID );
    }

    crearTipo( tipo ) {
        return axios.post( TIPO_API_BASE_URL + "/registrar", tipo );
    }

    actualizarTipo( tipo ) {
        return axios.put( TIPO_API_BASE_URL + "/actualizar", tipo );
    }

    eliminarTipo( tipoID ) {
        return axios.delete( TIPO_API_BASE_URL + "/eliminar/" + tipoID );
    }
}

export default new TipoService()