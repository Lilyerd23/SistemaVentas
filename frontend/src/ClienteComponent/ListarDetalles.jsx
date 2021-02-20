import React, { Component } from "react";
import ClienteService       from "./service/ClienteService";
import TipoService          from "./service/TipoService";

class ListarDetalles extends Component {

    constructor( props ) {
        super( props );
        this.state = {
            clientes : [],
            tipos : [],
            idTipo : '1'
        }

        this.filtrarDatos = this.filtrarDatos.bind( this );
    }

    componentDidMount() {
        TipoService.mostrarTipos()
                   .then( listaT => {
                       this.setState( { tipos : listaT.data } )
                   } )
    }

    filtrarDatos( idTipo ) {
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