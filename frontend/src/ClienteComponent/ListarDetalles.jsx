import "./styles/ListarDetalle.scss"
import React, { Component } from "react";
import ClienteService       from "./service/ClienteService";
import TipoService          from "./service/TipoService";
import { FontAwesomeIcon }       from "@fortawesome/react-fontawesome";
import { faCaretDown, faSearch } from "@fortawesome/free-solid-svg-icons";

class ListarDetalles extends Component {

    constructor( props ) {
        super( props );
        this.state = {
            clientes : [],
            tipos : [],

            IDtipoSelect : '1',
            idTipo : '1'
        }

        this.filtrarDatos = this.filtrarDatos.bind( this );
        this.optionSelected = this.optionSelected.bind( this );
    }

    componentDidMount() {
        TipoService.mostrarTipos()
                   .then( listaT => {
                       this.setState( { tipos : listaT.data } )
                   } )
    }

    filtrarDatos( id_Tipo ) {
        ClienteService.listarPorTipo( this.state.idTipo )
                      .then( listaC => {
                          this.setState( { clientes : listaC.data } )
                      } )
    }

    optionSelected = ( event ) => {
        this.setState( { IDtipoSelect : event.target.value } )
    }

    render() {
        return (
            <div>
                <br/>
                <div className="title-details">
                    <h2 className="title-main">Detalles de los clientes</h2>
                </div>
                <div className="container-main-viewC">
                    <div className="search-list">
                        <div className="dropdown-viewC">
                            <select className="dropdown-list-viewC" value={ this.state.IDtipoSelect }
                                    onChange={ this.optionSelected }>
                                { this.state.tipos.map(
                                    TIPO =>
                                        <option key={ TIPO.id } value={ TIPO.id }>
                                            { TIPO.tipo }
                                        </option>
                                ) }
                            </select>
                            <span className="custom-arrow-viewC">
                                    <FontAwesomeIcon icon={ faCaretDown }/>
                                </span>
                        </div>
                        <div className="search-viewC">
                            <input className="search-txt_viewC" type="text" placeholder="Buscar por nombre"/>
                            <a className="search-btn_viewC">
                                <i><FontAwesomeIcon icon={ faSearch }/></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ListarDetalles