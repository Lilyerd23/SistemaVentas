import React, { Component } from "react";
import ClienteService       from "./service/ClienteService";

class ListarDetalles extends Component {

    constructor( props ) {
        super( props );
        this.state = {
            clientes : [],
            idTipo : 1
        }
    }

    componentDidMount() {
        ClienteService.listarPorTipo( this.state.idTipo )
                      .then( listaC => {
                          this.setState( { clientes : listaC.data } )
                      } )
    }

    render() {
        return (
            <div>
                <div className="title-details">
                    <h2 className="title-main">Detalles de los clientes</h2>
                </div>
            </div>
        )
    }
}

export default ListarDetalles